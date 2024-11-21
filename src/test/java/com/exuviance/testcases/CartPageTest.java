package com.exuviance.testcases;

import com.exuviance.dataprovider.CartProviders;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;

/**
 * @author : Vaibhav Nagvekar
 * @Date : 06 Mar 2023
 **/

public class CartPageTest extends BaseClass {

    @BeforeMethod
    public void setup() {
        launchApplication();
    }

    @Test(priority = 1, dataProvider = "miniCartEleCheck", dataProviderClass = CartProviders.class)
    public void CART_checkElementsOnMiniCart(String testcase, String execution, String productName) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.checkMiniCartTitle();
            cart.checkSubTotal();
            cart.checkButtons();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 2, dataProvider = "cartEleCheck", dataProviderClass = CartProviders.class)
    public void CART_checkElementsOnCart(String testcase, String execution, String productName) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickOnViewBagButton();
            cart.checkCartTitle();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 3, dataProvider = "editProduct", dataProviderClass = CartProviders.class)
    public void CART_checkEditProduct(String testcase, String execution, String productName, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickOnViewBagButton();
            String actualResult = cart.checkEditProduct();
            cart.printDataOnReport(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 4, dataProvider = "removeProduct", dataProviderClass = CartProviders.class)
    public void CART_checkRemoveProduct(String testcase, String execution, String productName, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickOnViewBagButton();
            String actualResult = cart.checkRemoveProduct();
            cart.printDataOnReport(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }


    @Test(priority = 5, dataProvider = "orderDetails", dataProviderClass = CartProviders.class)
    public void CART_verifyOrderDetails(String testcase, String execution, String productName, String code, String subHeader, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickOnViewBagButton();
            cart.checkCartOrderTitle();
            String actualResult = cart.checkPromoCode(subHeader, code);
            cart.printDataOnReport(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 6, dataProvider = "couponCode", dataProviderClass = CartProviders.class)
    public void CART_verifyOfferCode(String testcase, String execution, String productName, String code, String classname, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickOnViewBagButton();
            String actualResult = cart.checkOfferCode(classname, code);
            cart.printDataOnReport(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 7, dataProvider = "bonusProduct", dataProviderClass = CartProviders.class)
    public void CART_checkBonusProduct(String testcase, String execution, String productName) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickOnViewBagButton();
            int actualResult = cart.addBonusProducts();
            cart.printDataOnReport(actualResult, 4);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 8, dataProvider = "checkout", dataProviderClass = CartProviders.class)
    public void CART_verifyCheckout(String testcase, String execution, String productName, String couponCode, String className, String expectedResult) throws Exception {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickOnViewBagButton();
            cart.addBonusProducts();
            cart.checkOfferCode(className, couponCode);
            String actualResult = cart.clickOnCheckoutBtn();
            cart.printDataOnReport(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 9, dataProvider = "paypal", dataProviderClass = CartProviders.class)
    public void CART_verifyPaypal(String testcase, String execution, String productName, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickOnViewBagButton();
            String actualResult = cart.clickOnPaypalBtn();
            cart.printDataOnReport(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 10, dataProvider = "klarna", dataProviderClass = CartProviders.class)
    public void CART_verifyKlarna(String testcase, String execution, String productName, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickOnViewBagButton();
            String actualResult = cart.clickOnKlarnaBtn();
            cart.printDataOnReport(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 11, dataProvider = "recommendation", dataProviderClass = CartProviders.class)
    public void CART_verifyRecommendationAndCount(String testcase, String execution, String productName) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            PLP.navigateToShopAllSkincare();
            PLP.selectingProduct(productName);
            PDP.clickOnAddToBagBtn();
            cart.clickOnViewBagButton();
            cart.checkRecommendation();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
