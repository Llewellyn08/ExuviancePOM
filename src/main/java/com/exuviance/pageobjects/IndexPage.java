package com.exuviance.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.exuviance.actiondriver.Action;
import com.exuviance.base.BaseClass;

/**
 *	Author : Vaibhav Nagvekar
 *	Date : 25 May 2022
 **/

public class IndexPage extends BaseClass {
	
	String runOnBrowserstack = prop.getProperty("runOnBrowserstack");
	
	@FindBy (xpath = "//div[@class='header__heading-logo-wrapper']")
	private WebElement exuvianceLogo;

	@FindBy (xpath = "//*[@id='wrapper']/div[1]/div[2]/div[4]/a")
	private WebElement myAccount;

	@FindBy (xpath = "//*[@id='wrapper']/div[1]/div[2]/div[4]/div[1]/div/a[2]")
	private WebElement registrationLink;

	@FindBy (xpath = "//*[@id='wrapper']/div[1]/div[2]/div[4]/div[1]/div/a[1]")
	private WebElement loginLink;
	
	@FindBy (css = "#password-reset")
	private WebElement forgotPasswordLink;

	@FindBy (xpath = "//*[@id='element-kiNjTs']/span/svg/line[1]")
	private WebElement popupCloseBtn;

	@FindBy (xpath = "//button[@id='onetrust-accept-btn-handler']")
	private WebElement acceptPrivacyPolicy;

	public IndexPage() {
		PageFactory.initElements(driver , this);
	}
	
	public void closePopup() {
		Action.pressEsc(driver, popupCloseBtn);
		extentInfoLog("Clicked on : ", "Close Popup");
		this.acceptPrivacyPolicy();
	}

	public void acceptPrivacyPolicy() {
		Action.performActionwithExtentInfoLog(acceptPrivacyPolicy, "click", "Clicking on : Privacy pop-up 'Accept' button");
		Action.explicitWaitForElementToDisappear(acceptPrivacyPolicy, 10);
	}

	public void getTitle(String expectedTitle) {
		String actualResult = driver.getTitle();
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedTitle, actualResult, "Correct title displayed", "Wrong title displayed");
		} else {
			Action.printAndAssert(actualResult, expectedTitle);
		}
	}

	public void validateLogo() {
		boolean result = Action.isDisplayed(driver, exuvianceLogo);
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertTrueBS(result, "Logo is Displayed", "Logo is Mismatched");
		} else {
			extentInfoLog("Is logo displayed : ", result);
			Assert.assertTrue(result);
		}
	}

	public void clickOnReg() {
		Action.mouseOverElement(driver, myAccount);
		Action.click(driver, registrationLink);
		extentInfoLog("Clicked on : ", "Registration link");
	}
	
	public IndexPage clickOnLogin() {
		Action.mouseOverElement(driver, myAccount);
		Action.click(driver, loginLink);
		extentInfoLog("Clicked on : ", "Login link");
		return new IndexPage();
	}
	
	public ForgotPasswordPage clickOnForgotPasswordLink() {
		Action.mouseover(driver, forgotPasswordLink);
		Action.click(driver, forgotPasswordLink);
		extentInfoLog("Clicked on : ", "Forgot Password link");
		return new ForgotPasswordPage();
	}
}
