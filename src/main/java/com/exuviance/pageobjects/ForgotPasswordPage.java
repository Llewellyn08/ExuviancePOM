package com.exuviance.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.exuviance.base.BaseClass;

/**
 * Author : Vaibhav Nagvekar
 * Date : 23 June 2022
 **/

public class ForgotPasswordPage extends BaseClass {

    // WebElements on the Forgot Password Tile
    @FindBy(xpath = "//*[@id='dialog-container']/h1")
    public WebElement popupTitle;

    @FindBy(xpath = "//input[@id='dwfrm_requestpassword_email']")
    private WebElement forgotPasswordInput;

    @FindBy(xpath = "//span[@id='dwfrm_requestpassword_email-error']")
    public WebElement errorMessageText;

    @FindBy(css = "#PasswordResetForm > fieldset > div > div.form-caption.error")
    public WebElement invalidMessageText;

    @FindBy(xpath = "//div[@class='error-form']")
    public WebElement outOfSystemMessageText;

    @FindBy(xpath = "//h1[normalize-space()='Request to Reset Your Password Received']")
    public WebElement successMessageText;

    @FindBy(xpath = "//button[normalize-space()='Send']")
    private WebElement sendBtn;

    @FindBy(xpath = "//button[@title='Close']")
    private WebElement closeBtn;

    // Constructor
    public ForgotPasswordPage() {
        PageFactory.initElements(driver, this);
    }

    // Input Empty Email Address
    public void inputEmptyEmail(String email) {
        forgotPasswordInput.sendKeys(email);
        extentInfoLog("Entered email : ", email);
        sendBtn.click();
        extentInfoLog("Clicked on : ", "'Send' button.");
    }

    // Input Invalid Email Address
    public void inputInvaildEmail(String email) {
        forgotPasswordInput.sendKeys(email);
        extentInfoLog("Entered email : ", email);
        sendBtn.click();
        extentInfoLog("Clicked on : ", "'Send' button.");
    }

    // Input an Email Address that is not registered
    public void inputOutOfSystemEmail(String email) {
        forgotPasswordInput.sendKeys(email);
        extentInfoLog("Entered email : ", email);
        sendBtn.click();
        extentInfoLog("Clicked on : ", "'Send' button.");
    }

    // Input a valid Email Address
    public void inputVaildEmail(String email) {
        forgotPasswordInput.sendKeys(email);
        extentInfoLog("Entered email : ", email);
        sendBtn.click();
        extentInfoLog("Clicked on : ", "'Send' button.");
    }

    // Click on the close button
    public void clickOnCloseButton() {
        closeBtn.click();
        extentInfoLog("Clicked on : ", "'Close' button.");
    }
}
