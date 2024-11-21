package com.exuviance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.exuviance.actiondriver.Action;
import com.exuviance.base.BaseClass;

/**
 *	Author : Vaibhav Nagvekar
 *	Date : 30 May 2022
 **/

public class WishlistPage extends BaseClass {

	String runOnBrowserstack = prop.getProperty("runOnBrowserstack");

	@FindBy (xpath = "(//*[name()='svg'][@class='icon heart-icon svg-heart-icon-dims pdp-wishlist'])[1]")
	private WebElement whishlistBtn;

	@FindBy (xpath = "//button[@name='dwfrm_wishlist_items_i3_deleteItem']")
	private WebElement removeWishlistProductLink;

	@FindBy (xpath = "//a[normalize-space()='Gentle Daily Exfoliating Pads']")
	private WebElement productTextInWishlist;

	@FindBy (xpath = "//*[@id='wrapper']/div[1]/div[2]/div[4]/a")
	private WebElement myAccount;

	@FindBy (xpath = "//*[@id='wrapper']/div[1]/div[2]/div[4]/div[1]/div/a[1]")
	private WebElement myAccountLink;

	@FindBy (xpath = "//a[normalize-space()='Wish List']")
	private WebElement wishlistLink;

	@FindBy (id = "dwfrm_wishlist_search_firstname")
	private WebElement firstNameInput;

	@FindBy (id = "dwfrm_wishlist_search_lastname")
	private WebElement lastNameInput;

	@FindBy (id = "dwfrm_wishlist_search_email")
	private WebElement emailInput;

	@FindBy (name = "dwfrm_wishlist_search_search")
	private WebElement findBtn;

	@FindBy (xpath = "//span[normalize-space()='View']")
	private WebElement viewBtn;

	@FindBy (xpath = "//p[contains(text(),'No wish list has been found for Test Test test@tes')]")
	private WebElement errorMessageText;

	@FindBy (xpath = "//div[@class='name ']//a[contains(text(),'Clarifying & Renewing Serum')]")
	private WebElement verifyProductText;

	@FindBy (xpath = "//button[@name='dwfrm_wishlist_items_i4_deleteItem']")
	private WebElement removeProductLink;

	private WebElement clickWishlistProduct(Object value) {
		return driver.findElement(By.xpath("//a[normalize-space()='"+value+"']/../..//a[@title='Add this product to wishlist']"));
	}
	private WebElement verifyWishlistProduct(Object value) {
		return driver.findElement(By.xpath("//a[normalize-space()='"+value+"']"));
	}

	public WishlistPage() {
		PageFactory.initElements(driver , this);
	}

	public void assertion(String actualResult, String expectedResult) {
		//Verification
		Assert.assertEquals(actualResult, expectedResult);
	}

	public void printDataOnReport(String actualResult, String expectedResult) {
		//Printing data on report
		extentInfoLog("Assertion on Actual result : ", actualResult);
		extentInfoLog("Assertion on Expected result : ", expectedResult);
	}

	public void clickOnWishlist(String expectedResult) throws InterruptedException {
		Action.scrollByPixels(driver, 3000);
		Action.click(driver, whishlistBtn);
		String actualResult = productTextInWishlist.getText();

		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Correct product name displayed", "Wrong product name displayed");
		} else {
			//Printing data on report
			printDataOnReport(actualResult, expectedResult);

			//Verification
			assertion(actualResult, expectedResult);
		}
		removeWishlistProductLink.click();
		extentInfoLog("Clicked on : ","'Remove' product link");
	}

	public void navigateToWishlist() {
		Action.mouseHoverByJavaScript(myAccount);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Action.click(driver, myAccountLink);
		extentInfoLog("Clicked on : ","'My Account' link.");
		Action.click(driver, wishlistLink);
		extentInfoLog("Clicked on : ","'Wishlist' link.");
	}

	public void verifyInvalidSomeoneWishlist(String lastname, String firstname, String email, String expectedResult) {
		lastNameInput.sendKeys(lastname);
		firstNameInput.sendKeys(firstname);
		emailInput.sendKeys(email);
		findBtn.click();
		extentInfoLog("Clicked on : ","'Find' button.");
		String actualResult = errorMessageText.getText();

		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "No Wishlist product found", "Wishlist product found");
		} else {
			//Printing data on report
			printDataOnReport(actualResult, expectedResult);

			//Verification
			assertion(actualResult, expectedResult);
		}
	}

	public void verifyValidSomeoneWishlist(String lastname, String firstname, String email, String expectedResult) {
		lastNameInput.sendKeys(lastname);
		firstNameInput.sendKeys(firstname);
		emailInput.sendKeys(email);
		findBtn.click();
		extentInfoLog("Clicked on : ","'Find' button.");
		viewBtn.click();
		extentInfoLog("Clicked on : ","'View' link.");
		String actualResult = verifyProductText.getText();

		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Product found in Wishlist", "Product not found in Wishlist");
		} else {
			//Printing data on report
			printDataOnReport(actualResult, expectedResult);

			//Verification
			assertion(actualResult, expectedResult);
		}
	}

	public void clickOnWishlistProduct(Object value){
		clickWishlistProduct(value).click();
		extentInfoLog("Clicked on Product ListList button : ", value);
	}

	public void searchAndVerifyWishlistProduct(Object value){
		Action.scrollByPixels(driver,900);
		String actualResult = verifyWishlistProduct(value).getText();
		extentInfoLog("Actual product in wishlist : ", actualResult);
		extentInfoLog("Expected product in wishlist : ", value);
		Assert.assertEquals(actualResult,value);
		removeProductLink.click();
		extentInfoLog("Clicked on : ","'Remove' product link");
	}
}