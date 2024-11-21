package com.exuviance.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.exuviance.actiondriver.Action;
import com.exuviance.base.BaseClass;

/**
 *	Author : Llewellyn Thattazhi
 *	Date : 25 May 2022
 **/

public class LoginPage extends BaseClass {
	
	@FindBy (xpath = "//h1[normalize-space()='My Account Login']") 
	private WebElement accountLoginTitle;

	@FindBy (id = "dwfrm_login_username")
	private WebElement email;

	@FindBy (id = "dwfrm_login_password")
	private WebElement password;

	@FindBy (css = "#password-reset")
	private WebElement forgotPasswordLink;
	
	@FindBy (xpath = "//button[normalize-space()='SIGN IN']")
	private WebElement loginBtn;
	
	@FindBy (xpath = "//*[@id='wrapper']/div[1]/div[2]/div[4]/a") 
	private WebElement account;

	@FindBy (xpath = "//div[@class='error-form']") 
	private WebElement errorMessage;

	@FindBy(xpath = "//*[@id='dwfrm_login_username-error']")
	private WebElement invalidEmailErrorMessage;

	@FindBy (xpath = "//*[@id='dwfrm_login_username-error']")
	private WebElement blankEmailErrorMessage;

	@FindBy (xpath = "//*[@id='dwfrm_login_password-error']")
	private WebElement blankPasswordErrorMessage;

	@FindBy (xpath = "//div[@class='error-form']")
	private WebElement errorMsg;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
		
	public String checkTitle() {
		return accountLoginTitle.getText();
	}
	
	public HomePage doLogin(String uname, String pass) {
		Action.explicitWait(email, 10);
		Action.type(email, uname);
		Action.explicitWait(password, 10);
		Action.type(password, pass);
		Action.pressTabTwice(driver);
		Action.pressEnter(driver);
		Action.waitFor(10);
		loginBtn.click();
		return new HomePage();
	}

	public String getBlankEmailErrorMessage() {
		return blankEmailErrorMessage.getText();
	}

	public String getBlankPasswordErrorMessage() {
		return blankPasswordErrorMessage.getText();
	}

	public String getInvalidErrorMessage() {
		return invalidEmailErrorMessage.getText();
	}	

	public ForgotPasswordPage clickOnForgotPasswordLink() {
		Action.mouseover(driver, forgotPasswordLink);
		Action.click(driver, forgotPasswordLink);
		return new ForgotPasswordPage();
	}

	public void doStaticLogin() {
		Action.explicitWait(email, 10);
		email.sendKeys(prop.getProperty("username"));
		Action.explicitWait(password, 10);
		password.sendKeys(prop.getProperty("password"));
		Action.pressTabTwice(driver);
		Action.pressEnter(driver);
		Action.explicitWaitForElementTobeclickable(loginBtn, 10);
		loginBtn.click();
	}
}
