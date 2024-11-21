package com.exuviance.testcases;

import com.exuviance.dataprovider.OurStoryProviders;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;

public class OurStoryTest extends BaseClass {

    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApplication();
    }

    @Test(priority = 1, dataProvider = "BrightenAndRenew", dataProviderClass = OurStoryProviders.class)
    public void OURSTORY_verifyBrightenAndRenewProduct(String testcase, String execution, String uniqueId, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            ourStory.navigateToOurStory();
            ourStory.verifyProducts(uniqueId, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 2, dataProvider = "AcneProneAndRenew", dataProviderClass = OurStoryProviders.class)
    public void OURSTORY_verifyAcneProneAndRenew(String testcase, String execution, String productName, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            ourStory.navigateToOurStory();
            ourStory.verifyProducts(productName, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 3, dataProvider = "HydrateAndRenew", dataProviderClass = OurStoryProviders.class)
    public void OURSTORY_verifyHydrateAndRenew(String testcase, String execution, String productName, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            ourStory.navigateToOurStory();
            ourStory.verifyProducts(productName, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 4, dataProvider = "ComprehensiveAntiaging", dataProviderClass = OurStoryProviders.class)
    public void OURSTORY_verifyComprehensiveAntiaging(String testcase, String execution, String productName, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            ourStory.navigateToOurStory();
            ourStory.verifyProducts(productName, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
