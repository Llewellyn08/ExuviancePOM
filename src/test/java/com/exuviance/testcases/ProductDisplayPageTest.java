package com.exuviance.testcases;

import com.exuviance.dataprovider.ProductDisplayProviders;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;

/**
 * @author : Vaibhav Nagvekar
 * @Date : 07 Feb 2023
 **/

public class ProductDisplayPageTest extends BaseClass {

    @BeforeMethod
    public void setup() {
        launchApplication();
    }

    @Test(priority = 1, dataProvider = "allWebElements", dataProviderClass = ProductDisplayProviders.class)
    public void PDP_verifyAllElementsDisplayed(String testcase, String execution, String productName) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.checkBreadcrumb();
            PDP.getThumbnailsCount();
            PDP.checkProductName();
            PDP.checkRatings();
            PDP.checkWARLink();
            PDP.checkPrice();
            PDP.checkQuantityDropdown();
            PDP.checkAddToBagBtn();
            PDP.checkWishlistBtn();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 2, dataProvider = "thumbnailI", dataProviderClass = ProductDisplayProviders.class)
    public void PDP_verifyThubnailImage(String testcase, String execution, String productName) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.checkWARLink();
            PDP.clickWAR();
            PDP.checkThumbnail();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 3, dataProvider = "productDetails", dataProviderClass = ProductDisplayProviders.class)
    public void PDP_verifyProductDetails(String testcase, String execution, String productName, String tabValue, String textValue, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            String actualResult = PDP.getTextFromDetailsTab(tabValue, textValue);
            PDP.printAndAssert(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 4, dataProvider = "ymal", dataProviderClass = ProductDisplayProviders.class)
    public void PDP_verifyYouMayAlsoLikeSection(String testcase, String execution, String productName, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            boolean actualtext = PDP.checkYouMayAlsoLikeSection();
            Assert.assertTrue(actualtext);
            PDP.checkYouMayAlsoLikeProductCount(actualtext, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
