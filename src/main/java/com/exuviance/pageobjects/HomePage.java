package com.exuviance.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.exuviance.actiondriver.Action;
import com.exuviance.base.BaseClass;

/**
 * Author : Llewellyn Thattazhi
 * Date : 27 May 2022
 **/

public class HomePage extends BaseClass {

    String runOnBrowserstack = prop.getProperty("runOnBrowserstack");

    // WebElements representing various elements on the page
    @FindBy(xpath = "//a[@class='button button-primary']")
    private WebElement firstHeader;
    
    @FindBy(css = ".dynamic-banner__media")
    private WebElement firstHeaderBanner;

    @FindBy(css = "div.card-wrapper.product-card-wrapper.underline-links-hover.strikethrough-loaded")
    private List<WebElement> bestSellingProductsCount;

    @FindBy(css = "section.shopify-section.section-collection-carousel--container")
    private WebElement secondHeader;

    @FindBy(css = "img.special-offers--desktop")
    private List<WebElement> specialOffersCount;

    @FindBy(css = "section.shopify-section.section-multi-content--container")
    private WebElement thirdHeader;

    @FindBy(xpath = "//*[@id='crl8-homepage-carousel']/div/div/div/div/div/div/div[2]/div[2]/div/div/div")
    private List<WebElement> visibleResultCount;

    // Constructor to initialize page elements using PageFactory
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    // Method to perform assertion
    public void assertion(Object actualResult, Object expectedResult) {
        //Assertion
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Method to print data on the report
    public void printDataOnReport(Object actualResult, Object expectedResult) {
        extentInfoLog("Assertion on Actual result : ", actualResult);
        extentInfoLog("Assertion on Expected result : ", expectedResult);
    }

    // Validating the first header on the page
    public void validateFirstHeader(String expectedResult,String expectedUrl) {
    	Action.explicitWait(firstHeaderBanner,5);
    	extentInfoLog("Banner is visible : ", "");
        String actualFirstHeader = firstHeader.getText();
        Action.click(driver, firstHeader);
        String actualUrl = driver.getCurrentUrl();;
        Assert.assertEquals(actualUrl, expectedUrl);
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualFirstHeader, "First Header displayed correctly", "First Header displayed wrongly");
        } else {
            printDataOnReport(actualFirstHeader, expectedResult);
            assertion(actualFirstHeader, expectedResult);
        }
    }

    // Validating best selling item count
    public void bestSellingCount(int expectedResult) {
        int actualResult = bestSellingProductsCount.size();

        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualResult, "Number of Item count is Correct", "Number of Item count is Wrong");
        } else {
            printDataOnReport(actualResult, expectedResult);
            assertion(actualResult, expectedResult);
        }
    }

    // Validating second header on the page
    public void validateSecondHeader(String expectedSecondHeader) {
         Action.explicitWait(secondHeader, 10);
         boolean actualSecondHeaderbol = Action.isDisplayed(driver, firstHeader);
         String actualSecondHeader = String.valueOf(actualSecondHeaderbol);

        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedSecondHeader, actualSecondHeader, "Second Header displayed correctly", "Second Header displayed wrongly");
        } else {
            printDataOnReport(actualSecondHeader, expectedSecondHeader);
            assertion(actualSecondHeader, expectedSecondHeader);
        }
    }

    // Validating special offer item count
    public void specialOfferCount(int expectedResult) {
        int actualResult = specialOffersCount.size();
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualResult, "Number of Item count is Correct", "Number of Item count is Wrong");
        } else {
            printDataOnReport(actualResult, expectedResult);
            assertion(actualResult, expectedResult);
        }
    }

    // Validating Third Header on the page
    public void validateThirdHeader(String expectedThirdHeader) {
    	 Action.explicitWait(secondHeader, 10);
         boolean actualThirdHeaderbol = Action.isDisplayed(driver, thirdHeader);
         String actualThirdHeader = String.valueOf(actualThirdHeaderbol);
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedThirdHeader, actualThirdHeader, "Third Header displayed correctly", "Third Header displayed wrongly");
        } else {
            printDataOnReport(actualThirdHeader, expectedThirdHeader);
            assertion(actualThirdHeader, expectedThirdHeader);
        }
    }

    // Validating visible results item count
    public void visibleResultsCount(int expectedResult) {
        int actualResult = visibleResultCount.size();
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualResult, "Number of Item count is Correct", "Number of Item count is Wrong");
        } else {
            printDataOnReport(actualResult, expectedResult);
            assertion(actualResult, expectedResult);
        }
    }

    // Method to get the current URL of the page
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}
