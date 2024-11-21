package com.exuviance.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;
import com.exuviance.pageobjects.IndexPage;
import com.exuviance.pageobjects.LoginPage;
import com.exuviance.pageobjects.MyAccountPage;

/**
 *	Author : Vaibhav Nagvekar
 *	Date : 14 July 2022
 **/

public class MyAccountPageTest extends BaseClass {

	IndexPage index;
	LoginPage login;
	MyAccountPage home;

	@BeforeMethod
	public void setup() {
		launchApplication();
		index = new IndexPage();
		login = new LoginPage();
		home = new MyAccountPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=1, description="Check if 'My Account' text is displayed on my account page", enabled=true)
	public void MYACCOUNT_verifyMyAccountText() {
		index.closePopup();
		index.clickOnLogin();
		login.doStaticLogin();
		home.navigateToAccount();
		home.myAccountText();
	}

	@Test(priority=2, description="Check if 'Edit Profile' text is displayed on my account page", enabled=true)
	public void MYACCOUNT_verifyEditProfileText() {
		index.closePopup();
		index.clickOnLogin();
		login.doStaticLogin();
		home.navigateToAccount();
		home.editProfileText();
	}

	@Test(priority=3, description="Check if 'Orders' text is displayed on my account page", enabled=true)
	public void MYACCOUNT_verifyOrderText() {
		index.closePopup();
		index.clickOnLogin();
		login.doStaticLogin();
		home.navigateToAccount();
		home.orderText();
	}

	@Test(priority=4, description="Check if 'Payment Settings' text is displayed on my account page", enabled=true)
	public void MYACCOUNT_verifyPaymentSystemText() {
		index.closePopup();
		index.clickOnLogin();
		login.doStaticLogin();
		home.navigateToAccount();
		home.paymentSystemText();
	}

	@Test(priority=5, description="Check if 'My Repeat Deliveries' text is displayed on my account page", enabled=true)
	public void MYACCOUNT_verifyMyRepeatDeliveryText() {
		index.closePopup();
		index.clickOnLogin();
		login.doStaticLogin();
		home.navigateToAccount();
		home.myRepeatDeliveryText();
	}

	@Test(priority=6, description="Check if 'Addresses' text is displayed on my account page", enabled=true)
	public void MYACCOUNT_verifyAddressText() {
		index.closePopup();
		index.clickOnLogin();
		login.doStaticLogin();
		home.navigateToAccount();
		home.addressText();
	}

	@Test(priority=7, description="Check the functionality of My Account dropdown on my account page", enabled=true)
	public void MYACCOUNT_verifyMyAccountDropdown() {
		index.closePopup();
		index.clickOnLogin();
		login.doStaticLogin();
		home.navigateToAccount();
		home.myAccountDropdown();
	}

	@Test(priority=8, description="Check the functionality of Order Information dropdown on my account page", enabled=true)
	public void MYACCOUNT_verifyOrderInformationDropdown() {
		index.closePopup();
		index.clickOnLogin();
		login.doStaticLogin();
		home.navigateToAccount();
		home.orderInformationDropdown();
	}

	@Test(priority=9, description="Check the functionality of Subscriptions dropdown on my account page", enabled=true)
	public void MYACCOUNT_verifySubscriptionsDropdown() {
		index.closePopup();
		index.clickOnLogin();
		login.doStaticLogin();
		home.navigateToAccount();
		home.subscriptionDropdown();
	}

	@Test(priority=10, description="Check the functionality of Secure Shopping dropdown on my account page", enabled=true)
	public void MYACCOUNT_verifySecureShoppingDropdown() {
		index.closePopup();
		index.clickOnLogin();
		login.doStaticLogin();
		home.navigateToAccount();
		home.secureShoppingDropdown();
	}
}
