package com.exuviance.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.exuviance.actiondriver.Action;
import com.exuviance.base.BaseClass;

/**
 *	Author : Vaibhav Nagvekar
 *	Date : 14 July 2022
 **/

public class MyAccountPage extends BaseClass {
	
	String runOnBrowserstack = prop.getProperty("runOnBrowserstack");

	@FindBy (xpath = "//span[@class='account-title']")
	private WebElement myAccountText;

	@FindBy (xpath = "//h2[normalize-space()='Edit Profile']")
	private	WebElement editProfileText;

	@FindBy (xpath = "//h2[normalize-space()='Orders']")
	private	WebElement orderText;

	@FindBy (xpath = "//h2[normalize-space()='Payment Settings']")
	private	WebElement paymentSystemText;

	@FindBy (xpath = "//h2[normalize-space()='My Repeat Deliveries']")
	private	WebElement myRepeatDeliveryText;

	@FindBy (xpath = "//h2[normalize-space()='Addresses']")
	private	WebElement addressText;

	@FindBy (xpath = "//span[@role='button'][normalize-space()='My Account']")
	private WebElement myAccountDropdown;

	@FindBy (xpath = "//a[@title='Show or update your personal information']")
	private WebElement editProfileLink;

	@FindBy (xpath = "//a[@title='Manage credit cards']")
	private WebElement paymentMethodLink;

	@FindBy (xpath = "//a[@title='Manage your billing and shipping addresses']")
	private WebElement addressesLink;

	@FindBy (xpath = "//a[@title='Manage your WishList']")
	private WebElement wishListLink;

	@FindBy (xpath = "//span[normalize-space()='Order Information']")
	private WebElement orderInformationDropdown;

	@FindBy (xpath = "//*[@id='secondary']/nav/div/div/div/ul[2]/li/a")
	private WebElement orderHistoryLink;

	@FindBy (xpath = "//span[normalize-space()='My Subscriptions']")
	private WebElement mySubscriptionsDropdown;

	@FindBy (xpath = "//*[@id='secondary']/nav/div/div/div/ul[3]/li/a")
	private WebElement subscriptionsLink;

	@FindBy (xpath = "//span[normalize-space()='Secure Shopping']")
	private WebElement secureShoppingDropdown;

	@FindBy (xpath = "//a[@title='View Privacy Policy']")
	private WebElement policyLink;

	@FindBy (xpath = "//a[@title='Secure Shopping']")
	private WebElement secureShoppingLink;

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	public void navigateToAccount() {
		driver.navigate().to("https://www.exuviance.com/on/demandware.store/Sites-Exuviance-Site/default/Account-Show");
	}

	public void myAccountDropdown() {
		Action.click(driver, myAccountDropdown);
		Action.click(driver, myAccountDropdown);
		Action.click(driver, editProfileLink);

		String actualProfileURL = driver.getCurrentUrl();
		String expectedProfileURL = "https://www.exuviance.com/on/demandware.store/Sites-Exuviance-Site/default/Account-EditProfile";

		//Assertion
		Assert.assertEquals(actualProfileURL, expectedProfileURL);
		
		//Printing data on report
		extentInfoLog("Actual Edit profile URL = ", actualProfileURL);
		extentInfoLog("Expected Edit profile URL = ", expectedProfileURL);

		Action.click(driver, myAccountDropdown);
		Action.click(driver, myAccountDropdown);
		Action.click(driver, paymentMethodLink);

		String actualPaymentURL = driver.getCurrentUrl();
		String expectedPaymentURL = "https://www.exuviance.com/on/demandware.store/Sites-Exuviance-Site/default/PaymentInstruments-List";

		//Assertion
		Assert.assertEquals(actualPaymentURL, expectedPaymentURL);
		
		//Printing data on report
		extentInfoLog("Actual Payment method URL = ", actualPaymentURL);
		extentInfoLog("Expected Payment method URL = ", expectedPaymentURL);

		Action.click(driver, myAccountDropdown);
		Action.click(driver, myAccountDropdown);
		Action.click(driver, addressesLink);

		String actualAddressURL = driver.getCurrentUrl();
		String expectedAddressURL = "https://www.exuviance.com/on/demandware.store/Sites-Exuviance-Site/default/Address-List";

		//Assertion
		Assert.assertEquals(actualAddressURL, expectedAddressURL);
		
		//Printing data on report
		extentInfoLog("Actual Addresses URL = ", actualAddressURL);
		extentInfoLog("Expected Addresses URL = ", expectedAddressURL);

		Action.click(driver, myAccountDropdown);
		Action.click(driver, myAccountDropdown);
		Action.click(driver, wishListLink);

		String actualWishlistURL = driver.getCurrentUrl();
		String expectedWishlistURL = "https://www.exuviance.com/on/demandware.store/Sites-Exuviance-Site/default/Wishlist-Show";

		//Assertion
		Assert.assertEquals(actualWishlistURL, expectedWishlistURL);
		
		//Printing data on report
		extentInfoLog("Actual Wishlist URL = ", actualWishlistURL);
		extentInfoLog("Expected Wishlist URL = ", expectedWishlistURL);
	}

	public void orderInformationDropdown() {
		Action.click(driver, orderInformationDropdown);
		Action.click(driver, orderInformationDropdown);
		Action.explicitWait(orderHistoryLink, 15);
		Action.click(driver, orderHistoryLink);

		String actualHistoryURL = driver.getCurrentUrl();
		String expectedHistoryURL = "https://www.exuviance.com/on/demandware.store/Sites-Exuviance-Site/default/Order-History";

		//Assertion
		Assert.assertEquals(actualHistoryURL, expectedHistoryURL);
		
		//Printing data on report
		extentInfoLog("Actual Order History URL = ", actualHistoryURL);
		extentInfoLog("Expected Order History URL = ", expectedHistoryURL);
	}

	public void subscriptionDropdown() {
		Action.click(driver, mySubscriptionsDropdown);
		Action.click(driver, mySubscriptionsDropdown);
		Action.explicitWait(subscriptionsLink, 15);
		Action.click(driver, subscriptionsLink);

		String actualSubscriptionURL = driver.getCurrentUrl();
		String expectedSubscriptionURL = "https://www.exuviance.com/on/demandware.store/Sites-Exuviance-Site/default/Order-Replenishments";

		//Assertion
		Assert.assertEquals(actualSubscriptionURL, expectedSubscriptionURL);
		
		//Printing data on report
		extentInfoLog("Actual Subscription URL = ", actualSubscriptionURL);
		extentInfoLog("Expected Subscription URL = ", expectedSubscriptionURL);
	}

	public void secureShoppingDropdown() {
		Action.click(driver, secureShoppingDropdown);
		Action.click(driver, secureShoppingDropdown);
		Action.explicitWait(policyLink, 15);
		Action.click(driver, policyLink);

		String actualPolicyURL = driver.getCurrentUrl();
		String expectedPolicyURL = "https://www.exuviance.com/privacy-policy.html";

		//Assertion
		Assert.assertEquals(actualPolicyURL, expectedPolicyURL);
		
		//Printing data on report
		extentInfoLog("Actual Policy URL = ", actualPolicyURL);
		extentInfoLog("Expected Policy URL = ", expectedPolicyURL);

		driver.navigate().to("https://www.exuviance.com/on/demandware.store/Sites-Exuviance-Site/default/Account-Show");

		Action.click(driver, secureShoppingDropdown);
		Action.click(driver, secureShoppingDropdown);
		Action.explicitWait(secureShoppingLink, 15);
		Action.click(driver, secureShoppingLink);

		String actualSecureShoppingURL = driver.getCurrentUrl();
		String expectedSecureShoppingURL = "https://www.exuviance.com/online-purchases/ordering-payment.html";

		//Assertion
		Assert.assertEquals(actualSecureShoppingURL, expectedSecureShoppingURL);
		
		//Printing data on report
		extentInfoLog("Actual Secure Shopping URL = ", actualSecureShoppingURL);
		extentInfoLog("Expected Secure Shopping URL = ", expectedSecureShoppingURL);
	}
	
	public void myAccountText() {
		Action.explicitWait(myAccountText, 10);
		String actualText = myAccountText.getText();
		String expectedText = "My Account";
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedText, actualText, "Correct text displayed", "Text is Mismatched");
		} else {
			//Printing data on report
			extentInfoLog("Actual Text : ", actualText);
			extentInfoLog("Expected Text : ", expectedText);

			//Assertion
			Assert.assertEquals(actualText, expectedText);
		}
	}
	
	public void editProfileText() {
		Action.explicitWait(editProfileText, 10);
		String actualText = editProfileText.getText();
		String expectedText = "EDIT PROFILE";

		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedText, actualText, "Correct text displayed", "Text is Mismatched");
		} else {
			//Printing data on report
			extentInfoLog("Actual Text : ", actualText);
			extentInfoLog("Expected Text : ", expectedText);

			//Assertion
			Assert.assertEquals(actualText, expectedText);
		}
	}
	
	public void orderText() {
		Action.explicitWait(orderText, 10);
		String actualText = orderText.getText();
		String expectedText = "ORDERS";

		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedText, actualText, "Correct text displayed", "Text is Mismatched");
		} else {
			//Printing data on report
			extentInfoLog("Actual Text : ", actualText);
			extentInfoLog("Expected Text : ", expectedText);

			//Assertion
			Assert.assertEquals(actualText, expectedText);
		}
	}
	
	public void paymentSystemText() {
		Action.explicitWait(paymentSystemText, 10);
		String actualText = paymentSystemText.getText();
		String expectedText = "PAYMENT SETTINGS";

		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedText, actualText, "Correct text displayed", "Text is Mismatched");
		} else {
			//Printing data on report
			extentInfoLog("Actual Text : ", actualText);
			extentInfoLog("Expected Text : ", expectedText);

			//Assertion
			Assert.assertEquals(actualText, expectedText);
		}
	}
	
	public void myRepeatDeliveryText() {
		Action.explicitWait(myRepeatDeliveryText, 10);
		String actualText = myRepeatDeliveryText.getText();
		String expectedText = "MY REPEAT DELIVERIES";

		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedText, actualText, "Correct text displayed", "Text is Mismatched");
		} else {
			//Printing data on report
			extentInfoLog("Actual Text : ", actualText);
			extentInfoLog("Expected Text : ", expectedText);

			//Assertion
			Assert.assertEquals(actualText, expectedText);
		}
	}
	
	public void addressText() {
		Action.explicitWait(addressText, 10);
		String actualText = addressText.getText();
		String expectedText = "ADDRESSES";

		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedText, actualText, "Correct text displayed", "Text is Mismatched");
		} else {
			//Printing data on report
			extentInfoLog("Actual Text : ", actualText);
			extentInfoLog("Expected Text : ", expectedText);

			//Assertion
			Assert.assertEquals(actualText, expectedText);
		}
	}
}
