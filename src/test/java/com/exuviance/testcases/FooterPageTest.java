package com.exuviance.testcases;

import java.lang.reflect.Method;

import com.exuviance.dataprovider.FooterProvider;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;

/**
 * Author : Vaibhav Nagvekar
 * Date : 21 June 2022
 **/

public class FooterPageTest extends BaseClass {

    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApplication();
    }

    @Test(priority = 1, dataProvider = "Links", dataProviderClass = FooterProvider.class)
    public void FOOTER_verifyLinks(String testcase, String execution,String column, String value, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            footer.checkLinks(column, value, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 2, dataProvider = "SocailMedia", dataProviderClass = FooterProvider.class)
    public void FOOTER_verifySocialMediaLinks(String testcase, String execution, String value, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            footer.checkSocialMediaLinks(testcase, value, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 3, dataProvider = "newLinks", dataProviderClass = FooterProvider.class)
    public void FOOTER_verifyNewLinks(String testcase, String execution, String value, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            footer.checkNewFooterLinks(testcase, value, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 4, dataProvider = "custCookie", dataProviderClass = FooterProvider.class)
    public void FOOTER_verifyCustomizeCookieSettingsTest(String testcase, String execution, String checkBox) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            footer.customizeCookieSettingAccept(checkBox);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 5, dataProvider = "prodAvilability", dataProviderClass = FooterProvider.class)
    public void FOOTER_verifyProductAvilability(String testcase, String execution, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            footer.clickOnAvilabilityLink();
            footer.checkAvilabilityHeader(expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }
//Inactive
    @Test(priority = 6, dataProvider = "emailSignUpFooter", dataProviderClass = FooterProvider.class, enabled =false)
    public void FOOTER_checkEmailSignUpTest(String testcase,String execution, String email, String expectedResult) {
        index.closePopup();
        switch (expectedResult) {
            case "This field is required.":
                footer.checkEmailSignUp(email);
                footer.emailErrorMsg(testcase, expectedResult);
                break;
            case "Please enter a valid email address.":
                footer.checkEmailSignUp(email);
                footer.emailErrorMsg(testcase, expectedResult);
                break;
            case "Email address already taken.":
                footer.checkEmailSignUp(email);
                footer.emailValidationMsg(testcase, expectedResult);
                break;
            case "You've been successfully signed up!":
                footer.checkEmailSignUp(email);
                footer.emailSuccessMsg(testcase, expectedResult);
                break;
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
