package xyz.qwirk.testCases;


import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

//import com.RoundAndRead.pageObjects.loginPage;

import junit.framework.Assert;

public class TC_login extends BaseClass{

	@Test
	public void logintest() throws IOException {

		

//		loginPage lp = new loginPage(driver);
//		lp.enterUserName(eusername);
//		Log.info("Enter the Email");
//		lp.clickNext();
//		Log.info("Click on Next");
//		lp. enterPassWord(epassword);
//		Log.info("Enter the Password");
//		
//		lp.clickSubmit();
//		
//		Log.info("Click on submit");
//	
//		lp.clickNoSave();
//		Log.info("Click on Yes btn");
//		Log.info("Login succesfull");
//		
		wait.until(ExpectedConditions.titleContains("Round Read | Heavy Dashboard"));
		String tilt = driver.getTitle();
		Log.info(tilt);
		Assert.assertEquals("Round Read | Heavy Dashboard",driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Round Read | Heavy Dashboard"));
		Log.info("Dashboard");
	}

}
