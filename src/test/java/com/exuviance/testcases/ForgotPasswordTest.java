package com.exuviance.testcases;

import com.exuviance.actiondriver.Action;
import com.exuviance.dataprovider.ForgotPasswordProviders;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;
import com.exuviance.pageobjects.IndexPage;

/**
 * @author : Vaibhav Nagvekar
 * @Date : 23 June 2022
 **/

public class ForgotPasswordTest extends BaseClass {

    IndexPage login;

    @BeforeMethod
    public void setup() throws InterruptedException {
        launchApplication();
        login = new IndexPage();
    }

    @Test(priority = 1, dataProvider = "popUpCheck", dataProviderClass = ForgotPasswordProviders.class)
    public void FORGOTPASSWORD_verifyForgotPasswordPopupTitle(String testcase, String execution, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            login = index.clickOnLogin();
            forgotpassword = login.clickOnForgotPasswordLink();
            String actualText = forgotpassword.popupTitle.getText();
            Action.printAndAssert(actualText, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 2, dataProvider = "closeBtn", dataProviderClass = ForgotPasswordProviders.class)
    public void FORGOTPASSWORD_verifyCloseButton(String testcase, String execution) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            index.clickOnLogin();
            login.clickOnForgotPasswordLink();
            forgotpassword.clickOnCloseButton();
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 3, dataProvider = "forgotPassword", dataProviderClass = ForgotPasswordProviders.class)
    public void FORGOTPASSWORD_verifyForgotPassword(String flag, String testcase, String execution, String email, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            login = index.clickOnLogin();
            forgotpassword = login.clickOnForgotPasswordLink();
            if (flag.contains("1")) {
                forgotpassword.inputEmptyEmail(email);
                String actualText = forgotpassword.errorMessageText.getText();
                Action.printAndAssert(actualText, expectedResult);
            } else if (flag.contains("2")) {
                forgotpassword.inputInvaildEmail(email);
                String actualText = forgotpassword.invalidMessageText.getText();
                Action.printAndAssert(actualText, expectedResult);
            } else if (flag.contains("3")) {
                forgotpassword.inputOutOfSystemEmail(email);
                String actualText = forgotpassword.outOfSystemMessageText.getText();
                Action.printAndAssert(actualText, expectedResult);
            } else if (flag.contains("4")) {
                forgotpassword.inputVaildEmail(email);
                String actualText = forgotpassword.successMessageText.getText();
                Action.printAndAssert(actualText, expectedResult);
            }
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
