package xyz.qwirk.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class freelancer_ProfileSetting_form {

	WebDriver driver;
	WebDriverWait lwait;
	static Logger llog;
	
	public freelancer_ProfileSetting_form(WebDriver rdriver,WebDriverWait rwait, Logger rlog) {
		// TODO Auto-generated constructor stub
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
		lwait = rwait;
		llog = rlog;
	}
	// web element of Profile Setting
		
	@FindBy(how = How.ID, using="name")
	WebElement firstName;// first name text box 
	@FindBy(how = How.ID, using="lastname")
	WebElement lastName;// last name text box
	@FindBy(how = How.ID, using="mobileno")
	WebElement mobNub;// mobile number 
	@FindBy(how = How.XPATH, using="//*[@id=\"update_provider\"]/div[2]/div[7]/span[1]/span[1]/span/span/textarea")
	WebElement selectLang;// select language drop down
	@FindBy(how = How.XPATH, using="//*[@id=\"update_provider\"]/div[2]/div[3]/input")
	WebElement Email;// name text box
	@FindBy(how = How.ID, using="inlineRadio1")
	WebElement genderMale;// gender male radio button
	@FindBy(how = How.ID, using="inlineRadio2")
	WebElement genderFemale;// gender female radio button
	@FindBy(how = How.XPATH, using="//*[@id=\"inlineRadio2\"]")
	WebElement genderAny;// gender any radio button
	@FindBy(how = How.ID, using="address")
	WebElement address;// address text box element
	@FindBy(how = How.ID, using="providercity_id")
	WebElement selectCity;// city drop down
	
	@FindBy(how = How.ID, using="providerstate_id")
	WebElement selectState;// state drop down
	@FindBy(how = How.ID, using="providercountry_id")
	WebElement selectCountry;// country drop down
	@FindBy(how = How.ID, using="pincode")
	WebElement pincode;// pin code text box
	@FindBy(how = How.ID, using="form_submit")
	WebElement saveAndNext;// Save and Next button.
	
	public void firstName() {
		firstName = lwait.until(ExpectedConditions.elementToBeClickable(firstName));
		String textName = firstName.getText();
		llog.info(textName);

	}

	public void lastName() {
		lastName = lwait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys("Test Name");
		llog.info("Enter the test Name");

	}
	public void Email() {
		Email = lwait.until(ExpectedConditions.elementToBeClickable(Email));
		String email = Email.getText();
		llog.info(email);

	}
	public void mobiNumber() {
		mobNub = lwait.until(ExpectedConditions.elementToBeClickable(mobNub));
		String mobile = mobNub.getText();
		llog.info(mobile);

	}
	public void maleGender() {
		genderMale = lwait.until(ExpectedConditions.elementToBeClickable(genderMale));
		genderMale.click();
		llog.info("Click on the Male gender radio button");

	}
	public void femaleGender() {
		genderFemale = lwait.until(ExpectedConditions.elementToBeClickable(genderFemale));
		genderFemale.click();
		llog.info("Click on the Female gender radio button");

	}
	public void anyGender() {
		genderAny = lwait.until(ExpectedConditions.elementToBeClickable(genderAny));
		genderAny.click();
		llog.info("Click on the Any gender radio button");

	}
	public void selectLanguage() {
		selectLang = lwait.until(ExpectedConditions.elementToBeClickable(selectLang));
		selectLang.click();
		selectLang.sendKeys("test punjab");
		llog.info("Language enter in the text box");

	}
	public void enterAddress() {
		address = lwait.until(ExpectedConditions.elementToBeClickable(address));
		address.sendKeys("test address");
		llog.info("Enter address ");

	}
	
	public void selectCity(String LOBIndex) {
		selectCity = lwait.until(ExpectedConditions.elementToBeClickable(selectCity));
		 Select SelectObj = new Select(selectCity);
		 SelectObj.selectByVisibleText(LOBIndex);
		WebElement option= SelectObj.getFirstSelectedOption();
	    String LOB=option.getText();
		llog.info(LOB);
		llog.info("Selected City "+ LOB);
	}
	public void selectCountry(String LOBIndex) {
		selectCountry = lwait.until(ExpectedConditions.elementToBeClickable(selectCountry));
		 Select SelectObj = new Select(selectCountry);
		 SelectObj.selectByVisibleText(LOBIndex);
		WebElement option= SelectObj.getFirstSelectedOption();
	    String LOB=option.getText();
		llog.info(LOB);
		llog.info("Selected Country "+ LOB);
	}
	public void selectState(String LOBIndex) {
		selectState = lwait.until(ExpectedConditions.elementToBeClickable(selectState));
		 Select SelectObj = new Select(selectState);
		 SelectObj.selectByVisibleText(LOBIndex);
		WebElement option= SelectObj.getFirstSelectedOption();
	    String LOB=option.getText();
		llog.info(LOB);
		llog.info("Selected State "+ LOB);
	}
	public void pnicode() {
		pincode = lwait.until(ExpectedConditions.elementToBeClickable(pincode));
		pincode.sendKeys("123456");
		llog.info("Pin code enter");
		
	}


	public void saveAndNext() {
		saveAndNext = lwait.until(ExpectedConditions.elementToBeClickable(saveAndNext));
		saveAndNext.click();
		llog.info("Click on the Save&Next button");

	}

}
