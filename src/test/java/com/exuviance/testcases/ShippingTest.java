package com.exuviance.testcases;

import com.exuviance.dataprovider.ShippingProviders;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;

/**
 * @author : Vaibhav Nagvekar
 * @Date : 28 April 2023
 **/

public class ShippingTest extends BaseClass {

    @BeforeMethod
    public void setup() {
        launchApplication();
    }

    @Test(priority = 1, dataProvider = "shippingLinks", dataProviderClass = ShippingProviders.class)
    public void SHIPPING_checkLinks(String testcase, String execution, String productName, String value, String expectedResult) throws Exception {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickNoThanksBtn();
            cart.clickOnViewBagButton();
            String actualResult = cart.clickOnCheckoutBtn();
            extentInfoLog("Shipping page URL: ", actualResult);
            shipping.clickOnLink(value, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 2, dataProvider = "sectionTitle", dataProviderClass = ShippingProviders.class)
    public void SHIPPING_checkSectionTitles(String testcase, String execution, String productName, String value, String expectedResult) throws Exception {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickNoThanksBtn();
            cart.clickOnViewBagButton();
            String actualResult = cart.clickOnCheckoutBtn();
            extentInfoLog("Shipping page URL: ", actualResult);
            shipping.checkSectionTitles(value, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 3, dataProvider = "shippingOrderDetails", dataProviderClass = ShippingProviders.class)
    public void SHIPPING_verifyOrderDetails(String testcase, String execution, String productName, String value, String expectedResult) throws Exception {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickNoThanksBtn();
            cart.clickOnViewBagButton();
            String actualResult = cart.clickOnCheckoutBtn();
            extentInfoLog("Shipping page URL: ", actualResult);
            shipping.checkOrderDetailsSection(value, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 4, dataProvider = "shippingDetailsValidation", dataProviderClass = ShippingProviders.class)
    public void SHIPPING_verifyShippingDetailsValidations(String testcase, String execution, String productName, String key, String value, String expectedResult) throws Exception {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickNoThanksBtn();
            cart.clickOnViewBagButton();
            String actualResult = cart.clickOnCheckoutBtn();
            extentInfoLog("Shipping page URL: ", actualResult);
            shipping.validationForShippingDetails(key, value, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 5, dataProvider = "shippingDetails", dataProviderClass = ShippingProviders.class)
    public void SHIPPING_verifyShippingDetails(String testcase, String execution, String productName, String add, String method) throws Exception {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickNoThanksBtn();
            cart.clickOnViewBagButton();
            String actualResult = cart.clickOnCheckoutBtn();
            extentInfoLog("Shipping page URL: ", actualResult);
            shipping.enterShippingDetails(add, method);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 6, dataProvider = "cardDetailsValidation", dataProviderClass = ShippingProviders.class)
    public void SHIPPING_verifyCardDetailsValidations(String testcase, String execution, String productName, String add, String method, String type, String key, String value, String expectedResult) throws Exception {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickNoThanksBtn();
            cart.clickOnViewBagButton();
            String actualResult = cart.clickOnCheckoutBtn();
            extentInfoLog("Shipping page URL: ", actualResult);
            shipping.enterShippingDetails(add, method);
            shipping.validationForCardDetails(type, key, value, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 7, dataProvider = "cardDetails", dataProviderClass = ShippingProviders.class)
    public void SHIPPING_verifyCardDetails(String testcase, String execution, String productName, String add, String method, String type, String cardNumber, String expMonth, String expYear, String cvv, String expectedResult) throws Exception {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickNoThanksBtn();
            cart.clickOnViewBagButton();
            String actualResult = cart.clickOnCheckoutBtn();
            extentInfoLog("Shipping page URL: ", actualResult);
            shipping.enterShippingDetails(add, method);
            shipping.enterCardDetails(add, method, type, cardNumber, expMonth, expYear, cvv);
            shipping.checkValidationMessage(expectedResult);
            shipping.removeProduct();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
