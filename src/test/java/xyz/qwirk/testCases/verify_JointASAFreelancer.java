package xyz.qwirk.testCases;

import xyz.qwirk.pageObjects.joinAsAFreelancer_form;

public class verify_JointASAFreelancer extends BaseClass  {
	
	
	public void jointAsAClient_Form() throws InterruptedException {
		joinAsAFreelancer_form obj = new joinAsAFreelancer_form(driver, wait, Log);
		obj.clickOnJointAsFreelancer();
		obj.enterName();
		obj.enterEmail();
		obj.enterPassword();
		obj.selectCountryDrpdwn("India (+91)");
		obj.enterMobileNumber();
		obj.clickOnTheChkBox();
		obj.ClickOnTheRegister();
	}


}
