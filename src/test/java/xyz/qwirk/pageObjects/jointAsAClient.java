package xyz.qwirk.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class jointAsAClient {
	
	WebDriver driver;
	WebDriverWait lwait;
	static Logger llog;
	Alert alert;
	
	public static String plantName;

	public jointAsAClient(WebDriver rdriver,WebDriverWait rwait, Logger rlog) {
		// TODO Auto-generated constructor stub
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		lwait = rwait;
		llog = rlog;
	}
	
	// web element Joint as a Client 
	@FindBy(how = How.LINK_TEXT, using="Join as a Client")
	WebElement jointAsAClient;// link Joint as a client
	
	@FindBy(how = How.ID, using="user_name")
	WebElement enterName;// name text box 
	
	@FindBy(how = How.ID, using="user_email")
	WebElement enterEmail;// name text box
	@FindBy(how = How.ID, using="user_password")
	WebElement enterPwd;// name text box
	@FindBy(how = How.ID, using="user_mobile")
	WebElement enterMobi;// name text box
	@FindBy(how = How.ID, using="agree_checkbox_user")
	WebElement agreeChk;// tick on the agreement check box
	@FindBy(how = How.ID, using="registration_submit_user")
	WebElement register;// Register element
	@FindBy(how = How.ID, using="country_code")
	WebElement selectCountry;// Register element
	
	public void clickOnJointAsClient() {
		jointAsAClient = lwait.until(ExpectedConditions.elementToBeClickable(jointAsAClient));
		jointAsAClient.click();
		llog.info("Click On the Joint As A Client link in Menu bar.");

	}

	public void enterName() {
		enterName = lwait.until(ExpectedConditions.elementToBeClickable(enterName));
		enterName.sendKeys("Test Name");
		llog.info("Enter the test Name");

	}
	public void enterEmail() {
		enterEmail = lwait.until(ExpectedConditions.elementToBeClickable(enterEmail));
		enterEmail.sendKeys("Test_Email@abc.com");
		llog.info("Enter the email");

	}
	public void enterPassword() {
		enterPwd = lwait.until(ExpectedConditions.elementToBeClickable(enterPwd));
		enterPwd.sendKeys("TestAdmin");
		llog.info("Enter the password");

	}
	public void enterMobileNumber() {
		enterMobi = lwait.until(ExpectedConditions.elementToBeClickable(enterMobi));
		enterMobi.sendKeys("3456789012");
		llog.info("Enter the Mobile number");

	}
	public void clickOnTheChkBox() {
		agreeChk = lwait.until(ExpectedConditions.elementToBeClickable(agreeChk));
		agreeChk.click();
		llog.info("click on the Check Box");

	}
	public void ClickOnTheRegister() {
		register = lwait.until(ExpectedConditions.elementToBeClickable(register));
		register.click();
		llog.info("Click on the Register button");

	}
	public void selectCountryDrpdwn(String LOBIndex) {
		selectCountry = lwait.until(ExpectedConditions.elementToBeClickable(selectCountry));
		 Select SelectObj = new Select(selectCountry);
		 SelectObj.selectByVisibleText(LOBIndex);
		WebElement option= SelectObj.getFirstSelectedOption();
	    String LOB=option.getText();
		llog.info(LOB);
		llog.info("Select Country "+ LOB);
	}
	
	public void verifyTitleName() {
		lwait.until(ExpectedConditions.titleContains("Round Read | Heavy Dashboard"));
		String tilt = driver.getTitle();
		llog.info(tilt);
		Assert.assertEquals("Qwirk",driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Qwirck"));
		llog.info("title "+ tilt);

		
	}

}
