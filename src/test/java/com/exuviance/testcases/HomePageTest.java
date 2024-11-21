package com.exuviance.testcases;

import com.exuviance.dataprovider.HomeProviders;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;

/**
 * Author : Llewellyn Nagvekar
 * Date : 13 June 2022
 **/

public class HomePageTest extends BaseClass {

    @BeforeMethod
    public void setup() {
        launchApplication();
    }

    @Test(priority = 1, dataProvider = "headerOne", dataProviderClass = HomeProviders.class)
    public void HOME_validateHeaderOne(String testcase, String execution,String expectedResult,String expectedUrl ) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            home.validateFirstHeader(expectedResult,expectedUrl);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 2, dataProvider = "headerTwo", dataProviderClass = HomeProviders.class)
    public void HOME_validateHeaderTwo(String testcase, String execution, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            home.validateSecondHeader(expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 3, dataProvider = "headerThree", dataProviderClass = HomeProviders.class)
    public void HOME_validateHeaderThree(String testcase, String execution, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            home.validateThirdHeader(expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 4, dataProvider = "bestSellingCount", dataProviderClass = HomeProviders.class)
    public void HOME_validateBestSellingProductCount(String testcase, String execution, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            home.bestSellingCount(Integer.parseInt(expectedResult));
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 5, dataProvider = "specialOfferCount", dataProviderClass = HomeProviders.class)
    public void HOME_validateSpecialOfferCount(String testcase, String execution, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            home.specialOfferCount(Integer.parseInt(expectedResult));
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 6, dataProvider = "visibleResultCount", dataProviderClass = HomeProviders.class)
    public void HOME_validateVisibleResultsCount(String testcase, String execution, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            home.visibleResultsCount(Integer.parseInt(expectedResult));
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
