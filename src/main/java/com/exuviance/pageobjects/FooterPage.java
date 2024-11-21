package com.exuviance.pageobjects;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.exuviance.actiondriver.Action;
import com.exuviance.base.BaseClass;
import com.github.javafaker.Faker;

/**
 *	Author : Vaibhav Nagvekar
 *	Date : 21 June 2022
 **/

public class FooterPage extends BaseClass {

	String runOnBrowserstack = prop.getProperty("runOnBrowserstack");

	@FindBy (xpath = "//a[normalize-space()='Find in Store']")
	private WebElement findStoreLink;

	@FindBy (xpath = "//input[@placeholder='City, State or Zip Code']")
	private WebElement pincodeTextbox;

	@FindBy (xpath = "//span[@aria-label='Search for this product by city or zip code.']")
	private WebElement searchBtn;

	@FindBy (xpath = "//div[@class='ps-local-tab']//span[1]")
	public WebElement resultErrorText;

	@FindBy (xpath = "//button[@id='ot-sdk-btn']")
	private WebElement customizeCookieSettingsBtn;

	@FindBy (xpath = "//div[@class='ot-tgl']")	
	private List<WebElement> allowAllBtn;
	
	@FindBy (xpath = "(//div[@class='ot-tgl'])[1]")
	private WebElement performanceCookie;
	

	@FindBy (xpath = "//button[normalize-space()='Reject All']")	
	private WebElement rejectAllBtn;

	@FindBy (xpath = "//button[normalize-space()='Confirm My Choices']")	
	private WebElement confirmBtn;

	@FindBy (css = "#email")	
	private WebElement emailSignUpInput;
	
	@FindBy (xpath = "//button[@class='btn btn-primary']")	
	private WebElement emailSignUpSubmitBtn;
	
	@FindBy (xpath = "//span[@id='footer-email-error']")	
	private WebElement emailSignUpError;

	 @FindBy(xpath = "//div[@class='ot-tgl']/input") // Locator for input elements inside toggle buttons
	    private List<WebElement> toggleInputs;
	  
	@FindBy (xpath = "//p[normalize-space()='Email address already taken.']")	
	private WebElement emailSignUpValidation;

	@FindBy (xpath = "//div[@class='signup-message']//p[1]")	
	private WebElement emailSignUpSuccess;

	@FindBy (xpath = "//a[contains(text(),'If you reside outside of the United States, you ca')]")	
	private WebElement checkAvilability;

	@FindBy (xpath = "//h1[@class='ex-heading-1']")
	private WebElement checkAvilabilityHeader;

	@FindBy (xpath = "//button[@id='onetrust-accept-btn-handler']")
	private WebElement acceptBtnPrivacyPolicy;

	private WebElement getShadowHost() {
        return driver.findElement(By.cssSelector("your-shadow-host-selector"));  // Replace with the actual selector
    }

	private WebElement getNewfooterlinks(String value) {
		return driver.findElement(By.xpath("//div[@class='content-asset']/ul/li["+value+"]"));
	}

	private WebElement getSocialMedialinks(String value) {
		return driver.findElement(By.xpath("//*[@class='list-social-wrapper']/ul/li["+value+"]"));
	}
	
	private WebElement getfooterlinks(String column, String value) {
		return driver.findElement(By.xpath("//*[@class='footer__content-top__blocks']/div[2]/div[1]/div["+column+"]/ul/li["+value+"]/a"));
	}

	public FooterPage() {
		PageFactory.initElements(driver, this);
	}

	public void printDataOnReport(String actualResult, String expectedResult) {
		extentInfoLog("Assertion on Actual result : ", actualResult);
		extentInfoLog("Assertion on Expected result : ", expectedResult);
	}
		
    public WebElement getSubmitButton() {
        WebElement shadowRoot = (WebElement) getShadowHost().getShadowRoot();
        return shadowRoot.findElement(By.cssSelector("[data-testid='btn-form-submit']"));
    }

	public void checkLinks(String column, String value, String expectedResult) {
		String actualResult;
		Action.explicitWait(getfooterlinks(column,value), 15);
		getfooterlinks(column,value).click();
		extentInfoLog("Clicked on link : ", getfooterlinks(column,value).getText());
		
		 actualResult = driver.getCurrentUrl();
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
		}
		else {
			//Printing data on report
			printDataOnReport(actualResult, expectedResult);

			//Assertion
			Assert.assertEquals(actualResult, expectedResult);
		}	
	}

	public void checkSocialMediaLinks(String testcase, String value, String expectedResult) {
		String actualResult;
		Action.scrollByPixels(driver, 2000);
		Action.click(driver, getSocialMedialinks(value));		
			actualResult = driver.getCurrentUrl();
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
		}
		else {
			printDataOnReport(actualResult, expectedResult);
			Assert.assertEquals(actualResult, expectedResult);
		}		
		driver.navigate().back();
	}

	public void checkNewFooterLinks(String testcase, String value, String expectedResult) {
		Action.scrollByVisibilityOfElement(driver, getNewfooterlinks(value));
		Action.explicitWait(getNewfooterlinks(value), 10);
		Action.waitFor(3000);
		getNewfooterlinks(value).click();
		Action.waitFor(3000);
		extentInfoLog("Clicked on link : ", getNewfooterlinks(value).getText());
		String actualResult = driver.getCurrentUrl();
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
		} else {
			//Printing data on report
			printDataOnReport(actualResult, expectedResult);

			//Assertion
			Assert.assertEquals(actualResult, expectedResult);
		}	
	}

	
	public void customizeCookieSettingAccept(String checkBox) {
		Action.scrollByVisibilityOfElement(driver, customizeCookieSettingsBtn);
		Action.click(driver, customizeCookieSettingsBtn);
		extentInfoLog("Clicked on : ", customizeCookieSettingsBtn.getText());
		Action.scrollByVisibilityOfElement(driver, performanceCookie);
		Action.waitFor(3000);
		int selectedCount = 0; 
		for (WebElement input : toggleInputs) {
            if (input.isSelected()) { 
                selectedCount++; 
            }
        }
	    System.out.println("Number of active toggle buttons: " + selectedCount);
			Assert.assertEquals(selectedCount, Integer.parseInt(checkBox),"All checkboxes are selected");
			boolean actualResult = confirmBtn.isDisplayed();
		Action.click(driver, confirmBtn);
		extentInfoLog("Clicked on : ", confirmBtn.getText());
		if (runOnBrowserstack.contains("Yes")) {
			this.assertFalseBS(actualResult, "'Confirm button' Button displayed", "'Confirm button' Button not displayed");
		} else {
			extentInfoLog("Is 'Confirm button' button displayed after clicking on 'Confirm button' button : ", actualResult);
		}
	}

	public void clickOnFindStoreForPositiveCase() {
		Action.scrollByVisibilityOfElement(driver, findStoreLink);
		Action.click(driver, findStoreLink);
		Action.type(pincodeTextbox, "89108");
		Action.extentInfoLog("Entered pincode : ", "89108");
		Action.click(driver, searchBtn);
	}

	public void clickOnFindStoreForNegativeCase() {
		Action.scrollByVisibilityOfElement(driver, findStoreLink);
		Action.click(driver, findStoreLink);
		Action.type(pincodeTextbox, "403401");
		Action.extentInfoLog("Entered pincode : ", "403401");
		Action.click(driver, searchBtn);
	}

	//INACTIVE
	public void enterEmail(String email) {
		Action.scrollByPixels(driver, 3000);
		emailSignUpInput.sendKeys(email);
		Action.pressTab(driver);
		Action.pressEnter(driver);	
		Action.waitFor(10);
		getSubmitButton().click();
	}

	//INACTIVE
	public void checkEmailSignUp(String email) {
		if (email.contains("Random")) {
			// Faker test data
			Faker faker = new Faker();
			String emailAdd = faker.internet().emailAddress();
			this.enterEmail(emailAdd);
			//Printing data on report
			extentInfoLog("Email : ", emailAdd);
		} else {
			this.enterEmail(email);
			//Printing data on report
			extentInfoLog("Email : ", email);
		}
	}

	//INACTIVE
	public String emailErrorMsg(String testcase, String expectedResult) {
		Action.explicitWait(emailSignUpError, 10);
		String actualResult =  emailSignUpError.getText();

		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Correct text displayed", "Wrong text displayed");
		} else {
			//Printing data on report
			extentInfoLog("Test Case : ", testcase);
			extentInfoLog("Actual Text : ", actualResult);
			extentInfoLog("Expected Text : ", expectedResult);

			//Assertion
			Assert.assertEquals(actualResult, expectedResult);
		}
		return actualResult;
	}

	//INACTIVE
	public String emailValidationMsg(String testcase, String expectedResult) {
		//Action.explicitWait(emailSignUpValidation, 10);
		Action.waitFor(3000);
		String actualResult =  emailSignUpValidation.getText();

		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Correct text displayed", "Wrong text displayed");
		} else {
			//Printing data on report
			extentInfoLog("Test Case : ", testcase);
			extentInfoLog("Actual Text : ", actualResult);
			extentInfoLog("Expected Text : ", expectedResult);

			//Assertion
			Assert.assertEquals(actualResult, expectedResult);
		}
		return actualResult;
	}

	//INACTIVE
	public String emailSuccessMsg(String testcase, String expectedResult) {
		//Action.explicitWait(emailSignUpSuccess, 10);
		Action.waitFor(3000);
		String actualResult =  emailSignUpSuccess.getText();

		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Correct text displayed", "Wrong text displayed");
		} else {
			//Printing data on report
			extentInfoLog("Test Case : ", testcase);
			extentInfoLog("Actual Text : ", actualResult);
			extentInfoLog("Expected Text : ", expectedResult);

			//Assertion
			Assert.assertEquals(actualResult, expectedResult);
		}
		return actualResult;
	}

	public void clickOnAvilabilityLink() {
		Action.explicitWaitForElementTobeclickable(checkAvilability, 10);
		checkAvilability.click();
	}

	public void checkAvilabilityHeader(String expectedResult) {
		String actualResult = checkAvilabilityHeader.getText();

		//Printing data on report
		extentInfoLog("Actual Text : ", actualResult);
		extentInfoLog("Expected Text : ", expectedResult);

		//Assertion
		Assert.assertEquals(actualResult, expectedResult);
	}
}