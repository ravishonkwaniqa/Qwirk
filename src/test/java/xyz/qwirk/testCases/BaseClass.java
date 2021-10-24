package xyz.qwirk.testCases;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import xyz.qwirk.utilities.ReadConfig;
import xyz.qwirk.utilities.Reporting;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationUrl();
//	public String eusername=readconfig.getUsername();
//	public String epassword=readconfig.getPassword();

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Logger Log;
	public static ITestContext context;  // creating a ITestContext variable
	public ExtentTest test;
	public static ExtentReports extent;

	@BeforeTest
	@Parameters("browser")
	
	public void setup(String br, ITestContext iTestContext) throws Exception {

		Log = Logger.getLogger("Round&Read");
		PropertyConfigurator.configure("log4j.properties");

		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			String home = System.getProperty("user.home"); 
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			//chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
			chromePrefs.put("download.default_directory", home+"\\Downloads\\Export\\");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(options);
			BaseClass.context = setContext(iTestContext, driver);  // setting the driver into context

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			wait= new WebDriverWait(driver,5);
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFireFoxPath());
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//driver.manage().window().maximize();
			wait= new WebDriverWait(driver,50);
		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//driver.manage().window().maximize();
			wait= new WebDriverWait(driver,50);
		}
		Log.info("**********Execution Started**********");
		driver.get(baseURL);
		Thread.sleep(5000);
		Log.info("URL Enter");
	}
	
//	@AfterMethod
	public static void captureScreen(String ScreenShotName ) throws IOException {
		
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		String path = ".\\Resources\\Export\\Screenshots\\" + ScreenShotName +".png";
		ImageIO.write(screenshot.getImage(), "png", new File(path));
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		String path = ".\\Resources\\Export\\Screenshots\\"+ ScreenShotName + ".png";
//		File target = new File(path);
//		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}

	@AfterTest
	public void teardown() {
		Log.info("**********Execution Closed***********");
		driver.close();
	}
	public static long random() {
		long random = (Math.round(Math.random() * 899) + 100);
		return (random);
	}
	
	public static ITestContext setContext(ITestContext iTestContext, WebDriver driver) {
        iTestContext.setAttribute("driver", driver);

        return iTestContext;
    }
	

	public static void  particularScreenShot(String name) throws IOException {
		BaseClass.captureScreen(name);
		String imagePath1 = "..\\Screenshots\\" + name +".png";
		Reporting.screenCapture(name+"-L2S_Seperate_ScrShot", imagePath1);
		
	}
}
