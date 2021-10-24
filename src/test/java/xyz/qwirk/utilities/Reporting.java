package xyz.qwirk.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Reporting extends  TestListenerAdapter
{

	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	String concatenate = ".";

	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Qwirk_Test_Reports-"+timeStamp+".html";  


		htmlReporter=new ExtentHtmlReporter(".\\Resources\\Export\\Reports\\"+ repName);//specify location of the report
		htmlReporter.loadXMLConfig(".\\extent-config.xml");

		extent=new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","Test");
		extent.setSystemInfo("user","Ravi_QA");

		htmlReporter.config().setDocumentTitle("Qwirk Project"); // Tile of report
		htmlReporter.config().setReportName("Qwirk_Test_Reports"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
		
		
	}

	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	}

	public void onTestFailure(ITestResult tr)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		
		WebDriver driver = (WebDriver) tr.getTestContext().getAttribute("driver");  // here we are accessing the driver object that we added in Test class  

		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted

		if(ITestResult.FAILURE==tr.getStatus()){

			System.out.println("Failed Status Check");
			try {
				Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
				String path = ".\\Resources\\Export\\Screenshots\\"+ tr.getName() +timeStamp+".png";
				ImageIO.write(screenshot.getImage(), "png", new File(path));
				logger.fail(tr.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath("..\\Screenshots\\"+ tr.getName() +timeStamp+ ".png").build());
				//logger.fail(tr.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(Paths.get("").toAbsolutePath().toString() + ".\\Resources\\Export\\Screenshots\\"+ tr.getName() +timeStamp+ ".png").build());
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		extent.flush();
	}

	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
	

	
	public static void screenCapture(String logDetails, String imagepath) throws IOException {
		// report with snapshot
		logger=extent.createTest(logDetails);
		logger.log(Status.ERROR,MarkupHelper.createLabel(logDetails,ExtentColor.BLUE));
		logger.log(Status.ERROR, logDetails, MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
		
		extent.flush();
		}

}
