package xyz.qwirk.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class joinAsAFreelancer_form {

	
	WebDriver driver;
	WebDriverWait lwait;
	static Logger llog;
	Alert alert;
	public joinAsAFreelancer_form(WebDriver rdriver,WebDriverWait rwait, Logger rlog) {
		// TODO Auto-generated constructor stub
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		lwait = rwait;
		llog = rlog;
	
	}
	
	// web element Joint As A Free lancer 
		@FindBy(how = How.LINK_TEXT, using="Join as a Freelancer")
		WebElement jointAsAClient;// link Joint as a client
		
		@FindBy(how = How.ID, using="userName")
		WebElement enterName;// name text box 
		
		@FindBy(how = How.ID, using="userEmail")
		WebElement enterEmail;// name text box
		@FindBy(how = How.ID, using="UserPassword")
		WebElement enterPwd;// name text box
		@FindBy(how = How.ID, using="userMobile")
		WebElement enterMobi;// name text box
		@FindBy(how = How.XPATH, using="//*[@id=\"agree_checkbox\"]")
		WebElement agreeChk;// tick on the agreement check box
		@FindBy(how = How.ID, using="registration_submit")
		WebElement register;// Register element
		@FindBy(how = How.ID, using="countryCode")
		WebElement selectCountry;// Register element
		
		//--------------------validation web element--------------------------------------------
		
		@FindBy(how = How.XPATH, using="//*[@id=\"new_third_page\"]/div[1]/small")
		WebElement valid_enterName;// validation name text box 
		
		@FindBy(how = How.XPATH, using="//*[@id=\"new_third_page\"]/div[2]/small[2]")
		WebElement valid_enterEmail;// validation name text box
		@FindBy(how = How.XPATH, using="//*[@id=\"new_third_page\"]/div[3]/small[1]")
		WebElement valid_enterPwd;// validation name text box
		@FindBy(how = How.XPATH, using="//*[@id=\"new_third_page\"]/div[4]/small[3]")
		WebElement valid_enterMobi;// validation name text box
		@FindBy(how = How.XPATH, using="//*[@id=\"new_third_page\"]/div[5]/small")
		WebElement valid_agreeChk;//validation on the agreement check box
		
		
		
		public void clickOnJointAsFreelancer() {
			jointAsAClient = lwait.until(ExpectedConditions.elementToBeClickable(jointAsAClient));
			jointAsAClient.click();
			llog.info("Click On the Joint As A Freelancer link in Menu bar.");

		}

		public void enterName() {
			enterName = lwait.until(ExpectedConditions.elementToBeClickable(enterName));
			enterName.sendKeys("Test_Name");
			llog.info("Enter the user Name");

		}
		public void enterEmail(long email) {
			enterEmail = lwait.until(ExpectedConditions.elementToBeClickable(enterEmail));
			enterEmail.sendKeys("ravishonkwaniqa+"+email+"@gmail.com");
			llog.info("Enter the email");

		}
		public void enterPassword() {
			enterPwd = lwait.until(ExpectedConditions.elementToBeClickable(enterPwd));
			enterPwd.sendKeys("Qwert@123");
			llog.info("Enter the password");

		}
		public void enterMobileNumber(long mobile ) {
			enterMobi = lwait.until(ExpectedConditions.elementToBeClickable(enterMobi));
			enterMobi.sendKeys("3456789"+mobile);
			llog.info("Enter the Mobile number");

		}
		public void clickOnTheChkBox() throws InterruptedException {
			//Thread.sleep(7000);
			//agreeChk = lwait.until(	ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input:checked")));
			String script = "return window.getComputedStyle(document.querySelector('.custom-control-label'),':after').getPropertyValue('content')";
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String content = (String) js.executeScript(script);
            System.out.println("after pesudo code"+content);
			Actions builder = new Actions(driver);
			Action checkBox = builder.moveToElement(agreeChk).click().build();
			checkBox.perform();
			llog.info("click on the Check Box");
			Thread.sleep(6000);

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
			lwait.until(ExpectedConditions.titleContains("Round"));
			String tilt = driver.getTitle();
			llog.info(tilt);
			Assert.assertEquals("Qwirk",driver.getTitle());
			Assert.assertTrue(driver.getTitle().contains("Qwirck"));
			llog.info("title "+ tilt);

			
		}

		//------------validation method--------------------------------------
		public void validationEnterName() {
			
			valid_enterName = lwait.until(ExpectedConditions.visibilityOf(valid_enterName));
			String val = valid_enterName.getText();
			llog.info(val);

		}
		public void validationEnterEmail() {
			valid_enterEmail = lwait.until(ExpectedConditions.visibilityOf(valid_enterEmail));
			String val = valid_enterEmail.getText();
			llog.info(val);

		}
		public void validationEnterPassword() {
			valid_enterPwd = lwait.until(ExpectedConditions.visibilityOf(valid_enterPwd));
			String val = valid_enterPwd.getText();
			llog.info(val);

		}
		public void validationEnterMobileNumber() {
			valid_enterMobi = lwait.until(ExpectedConditions.visibilityOf(valid_enterMobi));
			String val = valid_enterMobi.getText();
			llog.info(val);

		}
		public void validationnClickOnTheChkBox() {
			valid_agreeChk = lwait.until(ExpectedConditions.visibilityOf(valid_agreeChk));
			String val = valid_agreeChk.getText();
			llog.info(val);

		}
		


}
