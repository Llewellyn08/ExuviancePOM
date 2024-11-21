package com.exuviance.pageobjects;

import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.exuviance.actiondriver.Action;
import com.exuviance.base.BaseClass;

/**
 * Author : Vaibhav Nagvekar
 * Date : 25 May 2022
 **/

public class RegistrationPage extends BaseClass {

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_firstname']")
    private WebElement firstName;

    @FindBy(xpath = "//span[@id='dwfrm_profile_customer_firstname-error']")
    public WebElement firstNameErrorMsg;

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_lastname']")
    private WebElement lastName;

    @FindBy(xpath = "//span[@id='dwfrm_profile_customer_lastname-error']")
    public WebElement lastNameErrorMsg;

    @FindBy(xpath = "//input[@id='dwfrm_customeraddress_phone']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//span[@id='dwfrm_customeraddress_phone-error']")
    public WebElement phoneNumberErrorMsg;

    @FindBy(xpath = "//input[@id='dwfrm_profile_customer_email']")
    private WebElement emailnput;

    @FindBy(xpath = "//span[@id='dwfrm_profile_customer_email-error']")
    public WebElement emailErrorMsg;

    @FindBy(xpath = "//div[@class='form-caption error']")
    public WebElement emailInvalidErrorMsg;

    @FindBy(xpath = "//input[@id='dwfrm_profile_login_password']")
    private WebElement password;

    @FindBy(xpath = "//span[@id='dwfrm_profile_login_password-error']")
    public WebElement passwordErrorMsg;

    @FindBy(xpath = "//input[@id='dwfrm_profile_login_passwordconfirm']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//span[@id='dwfrm_profile_login_passwordconfirm-error']")
    public WebElement confirmPasswordErrorMsg;

    @FindBy(xpath = "(//a[@title='Privacy Policy'][normalize-space()='Privacy Policy'])[2]")
    private WebElement privacyPolicyLink;

    @FindBy(xpath = "(//a[normalize-space()='Financial Incentive Notice.'])[2]")
    private WebElement financialIncentiveNoticeLink;

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage doRegistration(String fname, String lname, String phone, String email, String pass, String conpass) {
        Action.type(firstName, fname);
        Action.type(lastName, lname);
        Action.type(phoneNumber, phone);

        //random email generation
        if (email.contains("Random")) {
            Random rand = new Random();
            int randomNumber = rand.nextInt(9999);
            email = "automation_user" + randomNumber + "@abc.com";

            Action.type(emailnput, email);
        } else {
            Action.type(emailnput, email);
        }
        Action.type(password, pass);
        Action.type(confirmPassword, conpass);

        for (int i = 0; i <= 4; i++) {
            Action.pressTab(driver);
        }
        Action.waitFor(2000);
        Action.pressEnter(driver);
        return new RegistrationPage();
    }

    public void checkPrivacyPolicy(String expectedResult) {
        Action.scrollByPixels(driver, 1000);
        Action.explicitWaitForElementTobeclickable(privacyPolicyLink, 10);
        privacyPolicyLink.click();
        //to switch to next window
        ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab2.get(1));
        extentInfoLog("Clicked on : ", "'Privacy Policy' link.");
        String actualResult = driver.getCurrentUrl();
        extentInfoLog("URL displayed : ", actualResult);
        Assert.assertEquals(actualResult, expectedResult);
    }

    public void checkFinancialIncentiveNotice(String expectedResult) {
        Action.scrollByPixels(driver, 1000);
        Action.explicitWaitForElementTobeclickable(financialIncentiveNoticeLink, 10);
        financialIncentiveNoticeLink.click();
        //to switch to next window
        ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab2.get(1));
        extentInfoLog("Clicked on : ", "'Financial Incentive Notice' link.");
        String actualResult = driver.getCurrentUrl();
        extentInfoLog("URL displayed : ", actualResult);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
