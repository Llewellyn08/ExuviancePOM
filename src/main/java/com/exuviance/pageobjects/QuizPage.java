package com.exuviance.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.exuviance.actiondriver.Action;
import com.exuviance.base.BaseClass;

/**
 * Author : Vaibhav Nagvekar
 * Date : 04 Jan 2023
 **/

public class QuizPage extends BaseClass {

    @FindBy(xpath = "//a[normalize-space()='Quiz']")
    private WebElement quizMenuLink;

    @FindBy(xpath = "//*[@id='quiz-banner']/div/div[1]")
    private WebElement bannerText;

    @FindBy(xpath = "//*[@id='quiz-banner']/div/button")
    private WebElement startQuizBtn;

    @FindBy(xpath = "//input[@id='quizemail']")
    private WebElement quizEmailInput;

    @FindBy(xpath = "//div[@id='showresults']")
    private WebElement showResultsBtn;

    @FindBy(xpath = "//a[normalize-space()='View our privacy policy']")
    private WebElement privacyPolicyLink;

    @FindBy(xpath = "//div[@id='quiznothanks']")
    private WebElement noThanksShowResultLink;

    @FindBy(xpath = "//h2[normalize-space()='Here are your product recommendations']")
    private WebElement actualResultMsg;

    @FindBy(xpath = "//div[contains(@class,'sc__product-details')]")
    private List<WebElement> ListOfProducts;

    private WebElement skinFeelsOption(String option) {
        return driver.findElement(By.xpath("//*[@id='sc__popup']/div[1]/div[2]/div[" + option + "]"));
    }

    private WebElement skincareGoalOption(String option) {
        return driver.findElement(By.xpath("//*[@id='sc__popup']/div[2]/div[2]/div[" + option + "]"));
    }

    private WebElement ageGroupOption(String option) {
        return driver.findElement(By.xpath("//*[@id='sc__popup']/div[3]/div[2]/div[" + option + "]"));
    }

    private WebElement idealSkincareRegimenOption(String option) {
        return driver.findElement(By.xpath("//*[@id='sc__popup']/div[4]/div[2]/div[" + option + "]"));
    }

    public QuizPage() {
        PageFactory.initElements(driver, this);
    }

    public void printDataOnReport(String actualResult, String expectedResult) {
        //Printing data on report
        extentInfoLog("Assertion on Actual result : ", actualResult);
        extentInfoLog("Assertion on Expected result : ", expectedResult);

        //Verification
        Assert.assertEquals(actualResult, expectedResult);
    }

    public String currentURL() {
        return driver.getCurrentUrl();
    }

    public String bannerText() {
        Action.explicitWait(bannerText, 10);
        return bannerText.getText();
    }

    public void clickOnQuiz() {
        Action.explicitWaitForElementTobeclickable(quizMenuLink, 10);
        quizMenuLink.click();
        extentInfoLog("Clicked on : ", quizMenuLink.getText());
    }

    public void clickOnStartButton() throws InterruptedException {
        Action.explicitWaitForElementTobeclickable(startQuizBtn, 10);
        startQuizBtn.click();
        Thread.sleep(5000);
        startQuizBtn.click();
        extentInfoLog("Clicked on : ", startQuizBtn.getText());
    }

    public void selectOptions(String skinUsuallyFeel, String skincareGoals, String ageGroup, String skincareRegimen) {
        Action.click(driver, skinFeelsOption(skinUsuallyFeel));
        extentInfoLog("Selected skin feel : ", skinUsuallyFeel);
        Action.click(driver, skincareGoalOption(skincareGoals));
        extentInfoLog("Selected skin care goal : ", skincareGoals);
        Action.click(driver, ageGroupOption(ageGroup));
        extentInfoLog("Selected age group : ", ageGroup);
        Action.click(driver, idealSkincareRegimenOption(skincareRegimen));
        extentInfoLog("Selected ideal skin care : ", skincareRegimen);
    }

    public void clickOnShowResultsLink() {
        Action.explicitWaitForElementTobeclickable(noThanksShowResultLink, 10);
        noThanksShowResultLink.click();
        extentInfoLog("Clicked on : ", "No thanks show results");
    }

    public String successMsg() {
        Action.explicitWait(actualResultMsg, 10);
        return actualResultMsg.getText();
    }

    public int checkListOfProducts() {
        return ListOfProducts.size();
    }

    public void clickOnPrivacyPolicy() {
        Action.explicitWait(privacyPolicyLink, 10);
        privacyPolicyLink.click();
    }

    public void enterEmail(String email) {
        Action.explicitWait(quizEmailInput, 10);
        quizEmailInput.sendKeys(email);
        extentInfoLog("Entered Email address : ", email);
        showResultsBtn.click();
    }
}
