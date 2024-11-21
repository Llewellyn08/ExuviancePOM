package com.exuviance.testcases;

import java.util.ArrayList;

import com.exuviance.dataprovider.QuizProviders;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;
import com.github.javafaker.Faker;

/**
 * Author : Vaibhav Nagvekar
 * Date : 04 Jan 2023
 **/

public class QuizPageTest extends BaseClass {

    Faker faker = new Faker();
    String emailID = faker.internet().emailAddress();

    @BeforeMethod
    public void setup() {
        launchApplication();
    }

    @Test(priority = 1, dataProvider = "url", dataProviderClass = QuizProviders.class)
    public void QUIZ_verifyPageURL(String testcase, String execution, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            quiz.clickOnQuiz();
            String actualResult = quiz.currentURL();
            quiz.printDataOnReport(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 2, dataProvider = "banner", dataProviderClass = QuizProviders.class)
    public void QUIZ_verifyBannerTitle(String testcase, String execution, String expectedResult) {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            quiz.clickOnQuiz();
            String actualResult = quiz.bannerText();
            quiz.printDataOnReport(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 3, dataProvider = "privacyPolicy", dataProviderClass = QuizProviders.class)
    public void QUIZ_verifyPrivacyPolicy(String testcase, String execution, String skinUsuallyFeel, String skincareGoals, String ageGroup, String skincareRegimen, String expectedResult) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            quiz.clickOnQuiz();
            quiz.clickOnStartButton();
            quiz.selectOptions(skinUsuallyFeel, skincareGoals, ageGroup, skincareRegimen);
            quiz.clickOnPrivacyPolicy();
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            String actualResult = quiz.currentURL();
            quiz.printDataOnReport(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 4, dataProvider = "email", dataProviderClass = QuizProviders.class)
    public void QUIZ_verifyProductsByEnteringEmail(String testcase, String execution, String skinUsuallyFeel, String skincareGoals, String ageGroup, String skincareRegimen, String expectedResult) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            quiz.clickOnQuiz();
            quiz.clickOnStartButton();
            quiz.selectOptions(skinUsuallyFeel, skincareGoals, ageGroup, skincareRegimen);
            quiz.enterEmail(emailID);
            String actualResult = quiz.successMsg();
            quiz.printDataOnReport(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @Test(priority = 5, dataProvider = "quiz", dataProviderClass = QuizProviders.class)
    public void QUIZ_verifyProductsAfterQuiz(String testcase, String execution, String skinUsuallyFeel, String skincareGoals, String ageGroup, String skincareRegimen, String expectedResult) throws InterruptedException {
        test = test.createNode(testcase);
        if (execution.equalsIgnoreCase(defaultFlag)) {
            selectEnv(runOn);
            index.closePopup();
            quiz.clickOnQuiz();
            quiz.clickOnStartButton();
            quiz.selectOptions(skinUsuallyFeel, skincareGoals, ageGroup, skincareRegimen);
            quiz.clickOnShowResultsLink();
            String actualResult = quiz.successMsg();
            int list = quiz.checkListOfProducts();
            extentInfoLog("Number of products displayed : ", list);
            quiz.printDataOnReport(actualResult, expectedResult);
        } else {
            throw new SkipException("Test skipped : " + testcase);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
