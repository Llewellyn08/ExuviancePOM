package com.exuviance.testcases;

import com.exuviance.dataprovider.ProductListingProviders;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;

/**
 * @author : Vaibhav Nagvekar
 * @Date : 02 Feb 2023
 **/

public class ProductListingPageTest extends BaseClass {

    @BeforeMethod
    public void setup() {
        launchApplication();
    }

    @Test(priority = 1, dataProvider = "sortOption", dataProviderClass = ProductListingProviders.class)
    public void PLP_verifySortDropdown(String testcase, String execution, String option, String expectedResult) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectSortByFilter(option);
            String actualResult = driver.getCurrentUrl();
            PLP.printAndAssert(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 2, dataProvider = "refineOption", dataProviderClass = ProductListingProviders.class)
    public void PLP_verifyRefineFilter(String testcase, String execution, String option, String expectedResult) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectRefineFilter(option);
            String actualResult = driver.getCurrentUrl();
            PLP.printAndAssert(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 3, dataProvider = "quickView", dataProviderClass = ProductListingProviders.class)
    public void PLP_verifyQuickView(String testcase, String execution, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.quickViewCheckout();
            String actualResult = PLP.getProductName();
            PLP.printAndAssert(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 4, dataProvider = "addToBag", dataProviderClass = ProductListingProviders.class)
    public void PLP_verifyAddToBag(String testcase, String execution, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.clickOnAddToBagBtn();
            String actualResult = PLP.checkProductNameInCart();
            PLP.printAndAssert(actualResult, expectedResult);
            PLP.removeFromCart();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
