package com.exuviance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.exuviance.actiondriver.Action;
import com.exuviance.base.BaseClass;

/**
 *	Author : Llewellyn Thattazhi
 *	Date : 18 October 2022
 **/

public class HolidayPage extends BaseClass {
	
	String runOnBrowserstack = prop.getProperty("runOnBrowserstack");
	
	@FindBy(css = "#main > div.breadcrumb > span")
	private WebElement breadCrumbElement;
	
	@FindBy(css = "#home-banner-neo-holidayshop2022 > picture > img")
	private WebElement holidayBanner;
	
	@FindBy(css = "#home-freeShipBanner-holidayShop2022 > a > picture > img")
	private WebElement freeshippingBanner;
	
	@FindBy(css = "#primary > div > div:nth-child(6) > h3")
	private WebElement shopAllGiftSetsSubheading;
	
	@FindBy(css = "#primary > div > div:nth-child(6) > div")
	private WebElement shopAllGiftSetsSection;
	
	@FindBy(css = "#primary > div > div:nth-child(6) > div > ul > li.grid-tile.x-7.content-li-value")
	private WebElement limitedOfferTile;
	
	@FindBy(css = "#home-shopByProdType-holidayShop2022 > div > h3")
	private WebElement shopBySkinConcernSubheading;
	
	@FindBy(css = "#home-shopByProdType-holidayShop2022 > div > h4")
	private WebElement shopBySkinConcernSubheading2;
	
	@FindBy(css = "#home-shopByProdType-holidayShop2022 > div > div > div.shopByProductTypeImgBanner > picture > img")
	private WebElement shopBySkinConcernImage;
	
	@FindBy(xpath = "//h3[normalize-space()='SHOP BEST SELLERS BY PRODUCT TYPE']")
	private WebElement bestSellerProductSubheading;
	
	@FindBy(css = "//h4[normalize-space()='Our most coveted picks for youthful-looking skin.']")
	private WebElement bestSellerProductSubheading2;
	
	@FindBy(xpath = "//h3[normalize-space()='SHOP BY PRODUCT TYPE']")
	private WebElement shopByProductTypeSubheading;
	
	@FindBy(xpath = "//h4[normalize-space()='Must haves for the ultimate skincare routine.']")
	private WebElement shopByProductTypeSubheading2;
	
	@FindBy(css = "#home-shopByConcern-holidayShop2022 > div > div.shopByConcernImgBanner > picture > img")
	private WebElement shopByProductTypeBanner;
	
	
	private WebElement getSkinLinks(String value) {
		return driver.findElement(By.xpath("//*[@id='home-shopByProdType-holidayShop2022']/div/div/div[2]/ul/li["+value+"]/a"));
	}
	
	private WebElement getProductLinks(String value) {
		return driver.findElement(By.xpath("//*[@id='home-shopByConcern-holidayShop2022']/div/div[2]/ul/li["+value+"]/a"));
	}
	
	public HolidayPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateBreadCrumb() {
		String actualResult = breadCrumbElement.getText();
		String expectedResult = "Exuviance Holiday Shop 2022";
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
		} else {
			//Printing data on report
			extentInfoLog("Actual URL : ", actualResult);
			extentInfoLog("Expected URL : ", expectedResult);
			
			//ASSERTION
			Assert.assertEquals(actualResult, expectedResult);
		}
	}
	
	public void validateHolidayBanner() {
		boolean actualResult = Action.isDisplayed(driver, holidayBanner);
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertTrueBS(actualResult, "Banner image displayed", "Banner image not displayed");
		} else {
			//Printing data on report
			extentInfoLog("Is banner displayed : ", actualResult);
			
			// ASSERTION
			Assert.assertTrue(actualResult);
		}
	}
	
	public void clickOnFreeShippingBanner() {
		Action.click(driver, freeshippingBanner);
		String actualResult = driver.getCurrentUrl();
		String expectedResult = "https://www.exuviance.com/black-friday.html";
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
		} else {
			//Printing data on report
			extentInfoLog("Actual URL : ", actualResult);
			extentInfoLog("Expected URL : ", expectedResult);
			
			//ASSERTION
			Assert.assertEquals(actualResult, expectedResult);
		}
	}
	
	public void validateShopAllGiftSetsSubheading() {
		String actualResult = shopAllGiftSetsSubheading.getText();
		String expectedResult = "SHOP GIFT SETS";
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
		} else {
			//Printing data on report
			extentInfoLog("Actual URL : ", actualResult);
			extentInfoLog("Expected URL : ", expectedResult);
			
			//ASSERTION
			Assert.assertEquals(actualResult, expectedResult);
		}
	}
	
	public void validateShopAllGiftSetsSection() {
		boolean actualResult = Action.isDisplayed(driver, shopAllGiftSetsSection);
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertTrueBS(actualResult, "Section displayed", "Section not displayed");
		} else {
			//Printing data on report
			extentInfoLog("Is section displayed : ", actualResult);
			
			// ASSERTION
			Assert.assertTrue(actualResult);
		}
	}
	
	public void validateLimitedOfferTile() {
		boolean actualResult = Action.isDisplayed(driver, limitedOfferTile);
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertTrueBS(actualResult, "Title displayed", "Title not displayed");
		} else {
			//Printing data on report
			extentInfoLog("Is tile displayed : ", actualResult);
			
			// ASSERTION
			Assert.assertTrue(actualResult);
		}
	}
	
	public void validateShopBySkinConcernSubheading() {
		String actualResult = shopBySkinConcernSubheading.getText();
		String expectedResult = "SHOP BY SKIN CONCERN";
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Correct text displayed", "Wrong text displayed");
		} else {
			//Printing data on report
			extentInfoLog("Actual result : ", actualResult);
			extentInfoLog("Expected result : ", expectedResult);
			
			//ASSERTION
			Assert.assertEquals(actualResult, expectedResult);
		}
	}
	
	public void validateShopBySkinConcernSubheading2() {
		String actualResult = shopBySkinConcernSubheading2.getText();
		String expectedResult = "Find your personalized skincare solution";
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Correct text displayed", "Wrong text displayed");
		} else {
			//Printing data on report
			extentInfoLog("Actual result : ", actualResult);
			extentInfoLog("Expected result : ", expectedResult);
			
			//ASSERTION
			Assert.assertEquals(actualResult, expectedResult);
		}
	}
	
	public void validateShopBySkinConcernImage() {
		boolean actualResult = Action.isDisplayed(driver, shopBySkinConcernImage);
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertTrueBS(actualResult, "Image displayed", "Image not displayed");
		} else {
			//Printing data on report
			extentInfoLog("Is Image displayed : ", actualResult);
			
			// ASSERTION
			Assert.assertTrue(actualResult);
		}
	}
	
	public void validateBestSellerSubheading() {
		String actualResult = bestSellerProductSubheading.getText();
		String expectedResult = "SHOP BEST SELLERS BY PRODUCT TYPE";
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Correct text displayed", "Wrong text displayed");
		} else {
			//Printing data on report
			extentInfoLog("Actual result : ", actualResult);
			extentInfoLog("Expected result : ", expectedResult);
			
			//ASSERTION
			Assert.assertEquals(actualResult, expectedResult);
		}
	}
	
	public void validateBestSellerSubheading2() {
		String actualResult = bestSellerProductSubheading2.getText();
		String expectedResult = "Our most coveted picks for youthful-looking skin.";
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Correct text displayed", "Wrong text displayed");
		} else {
			//Printing data on report
			extentInfoLog("Actual result : ", actualResult);
			extentInfoLog("Expected result : ", expectedResult);
			
			//ASSERTION
			Assert.assertEquals(actualResult, expectedResult);
		}
	}
	
	public void validateShopByProductTypeSubheading() {
		String actualResult = shopByProductTypeSubheading.getText();
		String expectedResult = "SHOP BY PRODUCT TYPE";
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Correct text displayed", "Wrong text displayed");
		} else {
			//Printing data on report
			extentInfoLog("Actual result : ", actualResult);
			extentInfoLog("Expected result : ", expectedResult);
			
			//ASSERTION
			Assert.assertEquals(actualResult, expectedResult);
		}
	}
	
	public void validateShopByProductTypeSubheading2() {
		String actualResult = shopByProductTypeSubheading2.getText();
		String expectedResult = "Must haves for the ultimate skincare routine.";
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Correct text displayed", "Wrong text displayed");
		} else {
			//Printing data on report
			extentInfoLog("Actual result : ", actualResult);
			extentInfoLog("Expected result : ", expectedResult);
			
			//ASSERTION
			Assert.assertEquals(actualResult, expectedResult);
		}
	}
	
	public void validateProductTypeImage() {
		boolean actualResult = Action.isDisplayed(driver, shopByProductTypeBanner);
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertTrueBS(actualResult, "Image displayed", "Image not displayed");
		} else {
			//Printing data on report
			extentInfoLog("Is Image displayed : ", actualResult);
			
			// ASSERTION
			Assert.assertTrue(actualResult);
		}
	}
	
	public void clickOnSkinConcernLink(String testcase, String value, String expectedResult) throws InterruptedException {
		Action.scrollByVisibilityOfElement(driver, getSkinLinks(value));
		Thread.sleep(1000);
		Action.click(driver, getSkinLinks(value));
		Thread.sleep(3000);
		
		String actualResult = driver.getCurrentUrl();
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
		} else {
			//Printing data on report
			extentInfoLog("Test case : ", testcase);
			extentInfoLog("Actual URL : ", actualResult);
			extentInfoLog("Expected URL : ", expectedResult);
			
			//ASSERTION
			Assert.assertEquals(actualResult, expectedResult);
		}
	}
	
	public void clickOnProductTypeLink(String testcase, String value, String expectedResult) throws InterruptedException {
		Action.scrollByPixels(driver,3000);
		Thread.sleep(1000);
		Action.click(driver, getProductLinks(value));
		Thread.sleep(3000);
		
		String actualResult = driver.getCurrentUrl();
		
		if (runOnBrowserstack.contains("Yes")) {
			this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
		} else {
			//Printing data on report
			extentInfoLog("Test case : ", testcase);
			extentInfoLog("Actual URL : ", actualResult);
			extentInfoLog("Expected URL : ", expectedResult);
			
			//ASSERTION
			Assert.assertEquals(actualResult, expectedResult);
		}
	}
}
