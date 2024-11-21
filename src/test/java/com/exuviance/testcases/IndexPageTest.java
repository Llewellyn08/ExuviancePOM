package com.exuviance.testcases;

import com.exuviance.dataprovider.IndexProvider;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;

/**
 * Author : Vaibhav Nagvekar
 * Date : 24 May 2022
 **/

public class IndexPageTest extends BaseClass {

    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApplication();
    }

    @Test(priority = 1, dataProvider = "logo", dataProviderClass = IndexProvider.class)
    public void INDEX_verifyLogo(String testcase, String execution) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            index.validateLogo();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 2, dataProvider = "title", dataProviderClass = IndexProvider.class)
    public void INDEX_verifyTitle(String testcase, String execution, String expectedTitle) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            index.getTitle(expectedTitle);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
