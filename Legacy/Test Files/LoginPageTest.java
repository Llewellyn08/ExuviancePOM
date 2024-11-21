package com.exuviance.testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;
import com.exuviance.dataprovider.DataProviders;
import com.exuviance.pageobjects.HomePage;
import com.exuviance.pageobjects.IndexPage;
import com.exuviance.pageobjects.LoginPage;

/**
 *	Author : Llewellyn Thattazhi
 *	Date : 27 May 2022
 **/

public class LoginPageTest extends BaseClass {

	IndexPage index;
	LoginPage login;
	HomePage home;

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
		index = new IndexPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=1, description="Check the functionality of login page", dataProvider="credentials", dataProviderClass = DataProviders.class)
	public void LOGIN_verifyLoginPage(String flag, String testcase, String uname, String pass) {
		
		// Blank Login Test
		if(flag.contains("1")) {

			index.closePopup();
			login = index.clickOnLogin();
			home = login.doLogin(uname, pass);

			//Printing data on report
			extentInfoLog("Test-case name = ", testcase);
			extentInfoLog("Actual Email entered = ", uname);
			extentInfoLog("Actual Password entered = ", pass);

			String actualBlankEmailErrorMessage = login.getBlankEmailErrorMessage();
			String expectedEmailErrorMessage = "This field is required.";

			//Assertion
			Assert.assertEquals(actualBlankEmailErrorMessage, expectedEmailErrorMessage);

			//Printing data on report
			extentInfoLog("Actual Error Message for Email = ", actualBlankEmailErrorMessage);
			extentInfoLog("Expected Error Message for Email = ", expectedEmailErrorMessage);

			String actualPasswordErrorMessage = login.getBlankPasswordErrorMessage();
			String expectedPasswordErrorMessage= "This field is required.";

			//Assertion
			Assert.assertEquals(actualPasswordErrorMessage, expectedPasswordErrorMessage);

			//Printing data on report
			extentInfoLog("Actual Error Message for Password = ", actualPasswordErrorMessage);
			extentInfoLog("Expected Error Message for Password = ", expectedPasswordErrorMessage);
		} 

		// Invalid Login Test
		else if(flag.contains("2")) {

			index.closePopup();
			login = index.clickOnLogin();
			home = login.doLogin(uname, pass);
			
			//Printing data on report
			extentInfoLog("Test-case name = ", testcase);
			extentInfoLog("Actual Email entered = ", uname);
			extentInfoLog("Actual Password entered = ", pass);
			
			String actualEmailErrorMesssage = login.getInvalidErrorMessage();
			String expectedEmailErrorMessage = "Please enter a valid email address.";

			//Assertion
			Assert.assertEquals(actualEmailErrorMesssage, expectedEmailErrorMessage);

			//Printing data on report
			extentInfoLog("Actual Error Message = ", actualEmailErrorMesssage);
			extentInfoLog("Expected Error Message = ", expectedEmailErrorMessage);
		}

		// Incorrect Login Test
		else if(flag.contains("3")) {

			index.closePopup();
			login = index.clickOnLogin();
			home = login.doLogin(uname, pass);
			
			//Printing data on report
			extentInfoLog("Test-case name = ", testcase);
			extentInfoLog("Actual Email entered = ", uname);
			extentInfoLog("Actual Password entered = ", pass);
			
			String actualURL = home.getCurrentURL();
			String expectedURL = "https://www.exuviance.com/on/demandware.store/Sites-Exuviance-Site/default/Login-LoginForm?scope=";

			//Assertion
			Assert.assertEquals(actualURL, expectedURL);

			//Printing data on report
			extentInfoLog("Actual URL = ", actualURL);
			extentInfoLog("Expected URL = ", expectedURL);
		}

		// Valid Login Test
		else if (flag.contains("4")){

			index.closePopup();
			login = index.clickOnLogin();
			home = login.doLogin(uname,pass);
			
			//Printing data on report
			extentInfoLog("Test-case name = ", testcase);
			extentInfoLog("Actual Email entered = ", uname);
			extentInfoLog("Actual Password entered = ", pass);

			String actualURL = home.getCurrentURL();
			String expectedURL = "https://www.exuviance.com/";

			//Assertion
			Assert.assertEquals(actualURL, expectedURL);

			//Printing data on report
			extentInfoLog("Actual URL = ", actualURL);
			extentInfoLog("Expected URL = ", expectedURL);
		} 
	}
}
