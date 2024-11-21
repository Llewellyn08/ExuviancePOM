package com.exuviance.testcases;

import com.exuviance.actiondriver.Action;
import com.exuviance.dataprovider.RegistrationProviders;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;

/**
 * Author : Vaibhav Nagvekar
 * Date : 27 May 2022
 **/

public class RegistrationTest extends BaseClass {

    String actError;

    @BeforeMethod
    public void setup() {
        launchApplication();
    }

    @Test(priority = 1, dataProvider = "registration", dataProviderClass = RegistrationProviders.class)
    public void REGISTRATION_doRegistration(String flag, String testcase, String execution, String fname, String lname, String phone, String email, String pass, String conpass, String expError) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            index.clickOnReg();
            registration = registration.doRegistration(fname, lname, phone, email, pass, conpass);

            if (flag.contains("A")) {
                extentInfoLog("Entered First name : ", fname);
                actError = registration.firstNameErrorMsg.getText();
                Action.printAndAssert(actError, expError);
            } else if (flag.contains("B")) {
                extentInfoLog("Entered First name : ", fname);
                actError = registration.firstNameErrorMsg.getText();
                Action.printAndAssert(actError, expError);
            } else if (flag.contains("C")) {
                extentInfoLog("Entered Last name : ", lname);
                actError = registration.lastNameErrorMsg.getText();
                Action.printAndAssert(actError, expError);
            } else if (flag.contains("D")) {
                extentInfoLog("Entered Last name : ", lname);
                actError = registration.lastNameErrorMsg.getText();
                Action.printAndAssert(actError, expError);
            } else if (flag.contains("E")) {
                extentInfoLog("Entered Phone number : ", phone);
                actError = registration.phoneNumberErrorMsg.getText();
                Action.printAndAssert(actError, expError);
            } else if (flag.contains("F")) {
                extentInfoLog("Entered Phone number : ", phone);
                actError = registration.phoneNumberErrorMsg.getText();
                Action.printAndAssert(actError, expError);
            } else if (flag.contains("G")) {
                extentInfoLog("Entered Email : ", email);
                actError = registration.emailErrorMsg.getText();
                Action.printAndAssert(actError, expError);
            } else if (flag.contains("H")) {
                extentInfoLog("Entered Email : ", email);
                actError = registration.emailInvalidErrorMsg.getText();
                Action.printAndAssert(actError, expError);
            } else if (flag.contains("I")) {
                extentInfoLog("Entered Password : ", pass);
                actError = registration.passwordErrorMsg.getText();
                Action.printAndAssert(actError, expError);
            } else if (flag.contains("J")) {
                extentInfoLog("Entered Confirm password : ", conpass);
                actError = registration.confirmPasswordErrorMsg.getText();
                Action.printAndAssert(actError, expError);
            } else if (flag.contains("K")) {
                extentInfoLog("Entered Password : ", pass);
                extentInfoLog("Entered Confirm password : ", conpass);
                actError = registration.confirmPasswordErrorMsg.getText();
                Action.printAndAssert(actError, expError);
            }
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 2, dataProvider = "privacyPolicyLink", dataProviderClass = RegistrationProviders.class)
    public void REGISTRATION_verifyPrivacyPolicyLink(String testcase, String execution, String expectedResult) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            index.clickOnReg();
            registration.checkPrivacyPolicy(expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 3, dataProvider = "financialIncentLink", dataProviderClass = RegistrationProviders.class)
    public void REGISTRATION_verifyFinancialIncentLink(String testcase, String execution, String expectedResult) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            index.clickOnReg();
            registration.checkFinancialIncentiveNotice(expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
