package xyz.qwirk.testCases;

import org.testng.annotations.Test;

import xyz.qwirk.pageObjects.jointAsAClient_form;

public class Verify_JointAsClient extends BaseClass{
	
	public static long random =random();
	public static long random2 = random();
	public static long random3 = random();
	
	
	@Test(priority=0, enabled=true)
	public void jointAsAClientForm() throws Exception {
		jointAsAClient_form obj = new jointAsAClient_form(driver, wait, Log);
		obj.clickOnJointAsClient();
		obj.enterName(random);
		obj.enterEmail(random2);
		obj.enterPassword();
		obj.selectCountryDrpdwn("India (+91)");
		obj.enterMobileNumber();
		obj.clickOnTheChkBox();
		obj.ClickOnTheRegister();
	}

	@Test(priority=1, enabled=true)
	public void verifyTitle() throws InterruptedException {
		jointAsAClient_form obj1 = new jointAsAClient_form(driver, wait, Log);
		obj1.verifyTitleName();

	}
	
		

}
