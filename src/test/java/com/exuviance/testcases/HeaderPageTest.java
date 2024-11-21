package com.exuviance.testcases;

import com.exuviance.dataprovider.HeaderProvider;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;
import com.exuviance.dataprovider.DataProviders;

/**
 * Author : Vaibhav Nagvekar
 * Date : 13 June 2022
 * Updated by: Rashi Tiwari
 * Date : 16 Oct 2024
 **/

public class HeaderPageTest extends BaseClass {

    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApplication();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1, dataProvider = "logoCheck", dataProviderClass = HeaderProvider.class)
    public void HEADER_verifyLogo(String testcase, String execution) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            header.validateLogo();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 2, dataProvider = "offerLink", dataProviderClass = HeaderProvider.class)
    public void HEADER_verifyOfferLinkFromHeader(String testcase, String execution, String expectedURL) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            header.clickOnOffers(expectedURL);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 3, dataProvider = "emailSign", dataProviderClass = HeaderProvider.class)
    public void HEADER_verifyEmailSignUp(String testcase, String execution, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            header.clickOnEmailSignUp(expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 4, dataProvider = "Search", dataProviderClass = HeaderProvider.class)
    public void HEADER_verifySearchBox(String testcase, String execution, String value, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            header.inputSearchBox(testcase, value, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 5, dataProvider = "shoppingBag", dataProviderClass = HeaderProvider.class)
    public void HEADER_verifyShoppingBag(String testcase, String execution, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            header.clickShoppingBag(expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 6, dataProvider = "BestSeller", dataProviderClass = HeaderProvider.class)
    public void HEADER_verifyBestSellerDropdown(String testcase, String execution, String subMenu, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            header.checkBestSellerDropdownAction(testcase, expectedResult, subMenu);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 7, dataProvider = "BestSellerShopAll", dataProviderClass = HeaderProvider.class)
    public void HEADER_verifyItemCount(String testcase, String execution, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
                    header.checkBestSellerShopAll( testcase,  expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 8, dataProvider = "SkinCare", dataProviderClass = HeaderProvider.class)
    public void HEADER_verifySkincareDropdown(String testcase, String execution, String category, String subMenu, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            header.checkShopSkincareDropDownAction(testcase, category, subMenu, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 9, dataProvider = "Discover", dataProviderClass = HeaderProvider.class)
    public void HEADER_verifyDiscoverDropdown(String testcase, String execution, String subMenu, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            header.checkDiscoverDropdownAction(testcase, subMenu, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    // INACTIVE
    @Test(priority = 4, description = "Verifying 3 scenarios of Email Sign Up on header", dataProvider = "EmailSignUp", dataProviderClass = DataProviders.class, enabled = false)
    public void HEADER_checkEmailSignUpTest(String testcase, String email, String expectedResult) {
        index.closePopup();
        switch (expectedResult) {
            case "This field is required.":
                header.checkEmailSignUp(email);
                header.emailErrorMsg(testcase, expectedResult);
                break;
            case "Email address already taken.":
                header.checkEmailSignUp(email);
                header.emailValidationMsg(testcase, expectedResult);
                break;
            case "You've been successfully signed up!":
                header.checkEmailSignUp(email);
                header.emailSuccessMsg(testcase, expectedResult);
                break;
        }
    }

    // INACTIVE
    @Test(priority = 7, description = "Verifying Holiday Menu", dataProvider = "Holiday", dataProviderClass = DataProviders.class, enabled = false)
    public void HEADER_verifyHolidayDropdownTest(String testcase, String subMenu, String expectedResult) {
        index.closePopup();
        header.checkHolidayDropdownAction(testcase, expectedResult, subMenu);
    }
}
