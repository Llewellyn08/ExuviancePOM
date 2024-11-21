package com.exuviance.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.exuviance.actiondriver.Action;
import com.exuviance.base.BaseClass;
import com.github.javafaker.Faker;

/**
 * @author : Vaibhav Nagvekar
 * @Date : 28 April 2023
 **/

public class ShippingPage extends BaseClass {

    Faker faker;
    String firstName;
    String lastName;

    public ShippingPage() {
        PageFactory.initElements(driver, this);
        faker = new Faker();
    }

    @FindBy(xpath = "(//h2[normalize-space()='Order Details'])[1]")
    private WebElement orderDetailsTitle;

    @FindBy(xpath = "(//div[contains(@class,'items-wrapper')])[1]")
    private WebElement productsDeatils;

    @FindBy(xpath = "(//a[normalize-space()='+Add Offer Code'])[1]")
    private WebElement offderCodeLink;

    @FindBy(xpath = "//div[@class='ex-heading-1']")
    private WebElement refundPolicyHeader;

    @FindBy(xpath = "//h1[@class='ex-heading-1']")
    private WebElement privacyPolicyHeader;

    @FindBy(xpath = "//div[@class='ex-heading-1']")
    private WebElement needHelpHeader;

    @FindBy(xpath = "//h1[@class='ex-heading-1']")
    private WebElement subscriptionPolicyHeader;

    @FindBy(xpath = "//h1[@class='ex-heading-1']")
    private WebElement termConditionHeader;

    @FindBy(id = "dwfrm_profile_customer_email")
    private WebElement emailIdInput;

    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_phone")
    private WebElement PhoneInput;

    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_firstName")
    private WebElement firstNameInput;

    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_lastName")
    private WebElement lastNameInput;

    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_address1")
    private WebElement addressInput;

    @FindBy(xpath = "(//div[@class='pac-container pac-logo hdpi'])[1]")
    private WebElement selectAddress;

    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_city")
    private WebElement cityInput;

    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_postal")
    private WebElement zipcodeInput;

    @FindBy(name = "dwfrm_singleshipping_shippingAddress_save")
    private WebElement continueBtn;

    @FindBy(xpath = "//span[@id='dwfrm_profile_customer_email-error']")
    private WebElement emailValidationMsg;

    @FindBy(id = "dwfrm_billing_paymentMethods_creditCard_owner")
    private WebElement cardNameInput;

    @FindBy(xpath = "//input[@id='dwfrm_billing_paymentMethods_creditCard_number']")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//input[@id='ccmo']")
    private WebElement expDateMonthInput;

    @FindBy(xpath = "//input[@id='ccyr']")
    private WebElement expDateYearInput;

    @FindBy(id = "dwfrm_billing_paymentMethods_creditCard_cvn")
    private WebElement cvvInput;

    @FindBy(xpath = "//span[normalize-space()='Place Order']")
    private WebElement placeOrderBtn;

    @FindBy(xpath = "//div[@class='form-caption error']")
    private WebElement cardNumberValidationMsg;

    @FindBy(xpath = "//span[@class='error yr']")
    private WebElement cardExpiryValidationMsg;

    @FindBy(xpath = "//*[@id='primary']/div[2]/div[1]")
    private WebElement validationMessage;

    @FindBy(xpath = "//a[normalize-space()='< Shopping Bag']")
    private WebElement shoppingBagLink;

    private WebElement getOrderDetails(Object value) {
        return driver.findElement(By.xpath("//span[normalize-space()='" + value + "']"));
    }

    private WebElement getShippingValidationMsg(Object value) {
        return driver.findElement(By.xpath("//span[@id='dwfrm_singleshipping_shippingAddress_addressFields_" + value + "']"));
    }

    private WebElement getCardValidationMsg(Object value) {
        return driver.findElement(By.xpath("//span[@id='dwfrm_billing_paymentMethods_creditCard_" + value + "']"));
    }

    private WebElement getSectionTitles(Object value) {
        return driver.findElement(By.xpath("(//h1[@class='checkout-title'])[" + value + "]"));
    }

    private WebElement getShippingMethods(Object value) {
        return driver.findElement(By.xpath("//label[@for='shipping-method-" + value + "']"));
    }

    private WebElement clickPaymentType(Object value) {
        return driver.findElement(By.xpath("//span[normalize-space()='" + value + "']"));
    }

    private WebElement getLinks(Object value) {
        return driver.findElement(By.xpath("//div[@class='co-footer']//a[normalize-space()='" + value + "']"));
    }

    public void checkSectionTitles(String value, String expectedResult) {
        Action.explicitWait(getSectionTitles(value), 10);
        boolean eleDisplayed = getSectionTitles(value).isDisplayed();
        if (eleDisplayed == true) {
            String actualResult = getSectionTitles(value).getText();
            extentInfoLog("Actual Section Title : ", actualResult);
            extentInfoLog("Expected Section Title : ", expectedResult);
            Assert.assertEquals(actualResult, expectedResult);
        }
    }

    public void checkOrderDeatilsTitle(String expectedResult) {
        Action.explicitWait(orderDetailsTitle, 10);
        boolean eleDisplayed = orderDetailsTitle.isDisplayed();
        if (eleDisplayed == true) {
            String actualResult = orderDetailsTitle.getText();
            extentInfoLog("Actual Title : ", actualResult);
            extentInfoLog("Expected Title : ", expectedResult);
            Assert.assertEquals(actualResult, expectedResult);
        }
    }

    public void checkProductDeatils() {
        Action.explicitWait(productsDeatils, 10);
        boolean eleDisplayed = productsDeatils.isDisplayed();
        if (eleDisplayed == true) {
            extentInfoLog("Products details displayed : ", eleDisplayed);
        }
    }

    public void checkOfferCodeLink(String expectedResult) {
        Action.explicitWait(offderCodeLink, 10);
        boolean eleDisplayed = offderCodeLink.isDisplayed();
        if (eleDisplayed == true) {
            String actualResult = offderCodeLink.getText();
            extentInfoLog("Actual Offer code text : ", actualResult);
            extentInfoLog("Expected Offer code text : ", expectedResult);
            Assert.assertEquals(actualResult, expectedResult);
        }
    }

    public void checkOrderDetailsText(Object value, String expectedResult) {
        Action.explicitWait(getOrderDetails(value), 10);
        boolean eleDisplayed = getOrderDetails(value).isDisplayed();
        if (eleDisplayed == true) {
            String actualResult = getOrderDetails(value).getText();
            extentInfoLog("Actual Text : ", actualResult);
            extentInfoLog("Expected Text : ", expectedResult);
            Assert.assertEquals(actualResult, expectedResult);
        }
    }

    public void checkOrderDetailsSection(Object value, String expectedResult) throws InterruptedException {
        Thread.sleep(2000);
        switch (expectedResult) {
            case "Order Details":
                this.checkOrderDeatilsTitle(expectedResult);
                break;
            case "Product":
                this.checkProductDeatils();
                break;
            case "+Add Offer Code":
                this.checkOfferCodeLink(expectedResult);
                break;
            case "Subtotal":
                this.checkOrderDetailsText(value, expectedResult);
                break;
            case "Standard Shipping":
                this.checkOrderDetailsText(value, expectedResult);
                break;
            case "Shipping Discount":
                this.checkOrderDetailsText(value, expectedResult);
                break;
            case "Sales Tax":
                this.checkOrderDetailsText(value, expectedResult);
                break;
            case "Estimated Total":
                this.checkOrderDetailsText(value, expectedResult);
                break;
        }
    }

    public void enterShippingEmail() {
        Action.explicitWaitForElementTobeclickable(emailIdInput, 10);
        boolean eleDisplayed = emailIdInput.isDisplayed();
        if (eleDisplayed == true) {
            extentPassLog("Email Address Input displayed : ", eleDisplayed);
            String email = faker.internet().emailAddress();
            emailIdInput.sendKeys(email);
            extentPassLog("Entered Email ID : ", email);
        } else {
            extentFailLog("Email Address Input displayed : ", eleDisplayed);
        }
    }

    public void enterShippingPhone() {
        Action.explicitWaitForElementTobeclickable(PhoneInput, 10);
        boolean eleDisplayed = PhoneInput.isDisplayed();
        if (eleDisplayed == true) {
            extentPassLog("Phone number Input displayed : ", eleDisplayed);
            String phone = faker.numerify("##########");
            PhoneInput.sendKeys(phone);
            extentPassLog("Entered Phone number : ", phone);
        } else {
            extentFailLog("Phone number Input displayed : ", eleDisplayed);
        }
    }

    public void enterShippingFirstName() {
        Action.explicitWaitForElementTobeclickable(firstNameInput, 10);
        boolean eleDisplayed = firstNameInput.isDisplayed();
        if (eleDisplayed == true) {
            extentPassLog("First name Input displayed : ", eleDisplayed);
            firstName = faker.address().firstName();
            firstNameInput.sendKeys(firstName);
            extentPassLog("Entered First name : ", firstName);
        } else {
            extentFailLog("First name Input displayed : ", eleDisplayed);
        }
    }

    public void enterShippingLastName() {
        Action.explicitWaitForElementTobeclickable(lastNameInput, 10);
        boolean eleDisplayed = lastNameInput.isDisplayed();
        if (eleDisplayed == true) {
            extentPassLog("Last name Input displayed : ", eleDisplayed);
            lastName = faker.address().lastName();
            lastNameInput.sendKeys(lastName);
            extentPassLog("Entered Last name : ", lastName);
        } else {
            extentFailLog("Last name Input displayed : ", eleDisplayed);
        }
    }

    public void enterShippingAddress(String add) {
        Action.explicitWaitForElementTobeclickable(addressInput, 10);
        boolean eleDisplayed = addressInput.isDisplayed();
        if (eleDisplayed == true) {
            extentPassLog("Address Input displayed : ", eleDisplayed);
            addressInput.sendKeys(add);
            selectAddress.click();
            extentPassLog("Entered Address : ", add.toString());
        } else {
            extentFailLog("City Input displayed : ", eleDisplayed);
        }
    }

    public void chooseMethod(String method) {
        Action.explicitWaitForElementTobeclickable(getShippingMethods(method), 10);
        boolean eleDisplayed = getShippingMethods(method).isDisplayed();
        if (eleDisplayed == true) {
            extentPassLog("Shipping method displayed : ", eleDisplayed);
            getShippingMethods(method).click();
            extentPassLog("Selected shipping method : ", getShippingMethods(method).getText());
        } else {
            extentFailLog("Shipping method displayed : ", eleDisplayed);
        }
    }

    public void clickOnContinueBtn() {
        Action.explicitWaitForElementTobeclickable(continueBtn, 10);
        boolean eleDisplayed = continueBtn.isDisplayed();
        if (eleDisplayed == true) {
            extentPassLog("Continue button displayed : ", eleDisplayed);
            continueBtn.click();
            extentPassLog("Clicking on : ", continueBtn.getText());
        } else {
            extentFailLog("Continue button displayed : ", eleDisplayed);
        }
    }

    public void enterShippingDetails(String add, String method) {
        this.enterShippingEmail();
        this.enterShippingPhone();
        this.enterShippingFirstName();
        this.enterShippingLastName();
        this.enterShippingAddress(add);
        this.chooseMethod(method);
        this.clickOnContinueBtn();
    }

    public void validationForShippingDetails(String key, String value, String expectedResult) {
        switch (value) {
            case "Email":
                emailIdInput.click();
                emailIdInput.clear();
                Action.pressTab(driver);
                extentInfoLog("Validation messgae displayed for : ", "Email");
                Action.explicitWait(emailValidationMsg, 10);
                String actualEmailValidationResult = emailValidationMsg.getText();
                extentPassLog("Actual validation message : ", actualEmailValidationResult);
                extentPassLog("Expected validation message : ", expectedResult);
                Assert.assertEquals(actualEmailValidationResult, expectedResult);
                break;
            case "Phone":
                PhoneInput.click();
                PhoneInput.clear();
                Action.pressTab(driver);
                extentInfoLog("Validation messgae displayed for : ", "Phone");
                Action.explicitWait(getShippingValidationMsg(key), 10);
                String actualPhoneValidationResult = getShippingValidationMsg(key).getText();
                extentPassLog("Actual validation message : ", actualPhoneValidationResult);
                extentPassLog("Expected validation message : ", expectedResult);
                Assert.assertEquals(actualPhoneValidationResult, expectedResult);
                break;
            case "First name":
                firstNameInput.click();
                firstNameInput.clear();
                Action.pressTab(driver);
                extentInfoLog("Validation messgae displayed for : ", "First name");
                Action.explicitWait(getShippingValidationMsg(key), 10);
                String actualFnameValidationResult = getShippingValidationMsg(key).getText();
                extentPassLog("Actual validation message : ", actualFnameValidationResult);
                extentPassLog("Expected validation message : ", expectedResult);
                Assert.assertEquals(actualFnameValidationResult, expectedResult);
                break;
            case "Last name":
                lastNameInput.click();
                lastNameInput.clear();
                Action.pressTab(driver);
                extentInfoLog("Validation messgae displayed for : ", "Last name");
                Action.explicitWait(getShippingValidationMsg(key), 10);
                String actualLnameValidationResult = getShippingValidationMsg(key).getText();
                extentPassLog("Actual validation message : ", actualLnameValidationResult);
                extentPassLog("Expected validation message : ", expectedResult);
                Assert.assertEquals(actualLnameValidationResult, expectedResult);
                break;
            case "City":
                cityInput.click();
                cityInput.clear();
                Action.pressTab(driver);
                extentInfoLog("Validation messgae displayed for : ", "City");
                Action.explicitWait(getShippingValidationMsg(key), 10);
                String actualCityValidationResult = getShippingValidationMsg(key).getText();
                extentPassLog("Actual validation message : ", actualCityValidationResult);
                extentPassLog("Expected validation message : ", expectedResult);
                Assert.assertEquals(actualCityValidationResult, expectedResult);
                break;
            case "Zipcode":
                zipcodeInput.click();
                zipcodeInput.clear();
                Action.pressTab(driver);
                extentInfoLog("Validation messgae displayed for : ", "Zipcode");
                Action.explicitWait(getShippingValidationMsg(key), 10);
                String actualZipValidationResult = getShippingValidationMsg(key).getText();
                extentPassLog("Actual validation message : ", actualZipValidationResult);
                extentPassLog("Expected validation message : ", expectedResult);
                Assert.assertEquals(actualZipValidationResult, expectedResult);
                break;
        }
    }

    public void enterCardName() {
        Action.explicitWaitForElementTobeclickable(cardNameInput, 10);
        boolean eleDisplayed = cardNameInput.isDisplayed();
        if (eleDisplayed == true) {
            extentPassLog("Card name input displayed : ", eleDisplayed);
            cardNameInput.sendKeys(firstName, " ", lastName);
            extentPassLog("Entered card name : ", firstName + " " + lastName);
        } else {
            extentFailLog("Card name input displayed : ", eleDisplayed);
        }
    }

    public void enterCardNumber(String number) {
        Action.explicitWaitForElementTobeclickable(cardNumberInput, 10);
        boolean eleDisplayed = cardNumberInput.isDisplayed();
        if (eleDisplayed == true) {
            extentPassLog("Card number input displayed : ", eleDisplayed);
            cardNumberInput.sendKeys(number);
            extentPassLog("Entered card number : ", number);
        } else {
            extentFailLog("Card number input displayed : ", eleDisplayed);
        }
    }

    public void enterExpDate(String expMonth, String expYear) {
        Action.explicitWaitForElementTobeclickable(expDateMonthInput, 10);
        boolean eleDisplayed = expDateMonthInput.isDisplayed();
        if (eleDisplayed == true) {
            extentPassLog("Card expiry date input displayed : ", eleDisplayed);
            expDateMonthInput.sendKeys(expMonth);
            expDateYearInput.sendKeys(expYear);
            extentPassLog("Entered expiry date : ", expMonth + "/" + expYear);
        } else {
            extentFailLog("Card expiry date input displayed : ", eleDisplayed);
        }
    }

    public void enterCVV(String cvv) {
        Action.explicitWaitForElementTobeclickable(cvvInput, 10);
        boolean eleDisplayed = cvvInput.isDisplayed();
        if (eleDisplayed == true) {
            extentPassLog("Card cvv number input displayed : ", eleDisplayed);
            cvvInput.click();
            cvvInput.sendKeys(cvv);
            extentPassLog("Entered CVV : ", cvv);
        } else {
            extentFailLog("Card cvv number input displayed : ", eleDisplayed);
        }
    }

    public void clickOnPlaceOrderBtn() {
        Action.scrollByPixels(driver, 400);
        Action.explicitWaitForElementTobeclickable(placeOrderBtn, 10);
        boolean eleDisplayed = placeOrderBtn.isDisplayed();
        if (eleDisplayed == true) {
            extentPassLog("Place order button displayed : ", eleDisplayed);
            placeOrderBtn.click();
            extentPassLog("Clicking on : ", placeOrderBtn.getText());
        } else {
            extentFailLog("Place order button displayed : ", eleDisplayed);
        }
    }

    public void enterCardDetails(String add, String method, String type, String cNumber, String expMonth, String expYear, String cvv) {
        Action.explicitWaitForElementTobeclickable(clickPaymentType(type), 10);
        clickPaymentType(type).click();
        this.enterCardName();
        this.enterCardNumber(cNumber);
        this.enterExpDate(expMonth, expYear);
        this.enterCVV(cvv);
        this.clickOnPlaceOrderBtn();
    }

    public void validationForCardDetails(String type, String key, String value, String expectedResult) throws InterruptedException {
        Thread.sleep(3000);
        clickPaymentType(type).click();
        switch (value) {
            case "Card name":
                Action.scrollByPixels(driver, 500);
                cardNameInput.click();
                cardNameInput.clear();
                Action.pressTab(driver);
                extentInfoLog("Validation messgae displayed for : ", "Card Name");
                Action.explicitWait(getCardValidationMsg(key), 10);
                String actualCardNameValidationResult = getCardValidationMsg(key).getText();
                extentPassLog("Actual validation message : ", actualCardNameValidationResult);
                extentPassLog("Expected validation message : ", expectedResult);
                Assert.assertEquals(actualCardNameValidationResult, expectedResult);
                break;
            case "Card number":
                Thread.sleep(2000);
                Action.scrollByPixels(driver, 500);
                cardNumberInput.sendKeys("12345");
                for (int i = 0; i <= 4; i++) {
                    Action.pressBackSpace(driver);
                }
                extentInfoLog("Validation messgae displayed for : ", "Card Number");
                Action.explicitWait(cardNumberValidationMsg, 10);
                String actualFnameValidationResult = cardNumberValidationMsg.getText();
                extentPassLog("Actual validation message : ", actualFnameValidationResult);
                extentPassLog("Expected validation message : ", expectedResult);
                Assert.assertEquals(actualFnameValidationResult, expectedResult);
                break;
            case "Card expiry":
                Action.scrollByPixels(driver, 500);
                expDateMonthInput.click();
                expDateMonthInput.clear();
                expDateYearInput.click();
                expDateYearInput.clear();
                Action.pressTab(driver);
                extentInfoLog("Validation messgae displayed for : ", "Card Expiry");
                Action.explicitWait(cardExpiryValidationMsg, 10);
                String actualLnameValidationResult = cardExpiryValidationMsg.getText();
                extentPassLog("Actual validation message : ", actualLnameValidationResult);
                extentPassLog("Expected validation message : ", expectedResult);
                Assert.assertEquals(actualLnameValidationResult, expectedResult);
                break;
            case "Card cvv":
                Action.scrollByPixels(driver, 500);
                cvvInput.click();
                cvvInput.clear();
                Action.pressTab(driver);
                extentInfoLog("Validation messgae displayed for : ", "Card CVV");
                Action.explicitWait(getCardValidationMsg(key), 10);
                String actualCardCVVValidationResult = getCardValidationMsg(key).getText();
                extentPassLog("Actual validation message : ", actualCardCVVValidationResult);
                extentPassLog("Expected validation message : ", expectedResult);
                Assert.assertEquals(actualCardCVVValidationResult, expectedResult);
                break;
        }
    }

    public void clickOnLink(String value, String expectedResult) {
        String actualResult;
        Action.scrollByPixels(driver, 500);
        boolean eleDisplayed = getLinks(value).isDisplayed();
        if (eleDisplayed == true) {
            extentInfoLog("Displayed link : ", eleDisplayed);
            getLinks(value).click();

            switch (value) {
                case "Refund Policy":
                    boolean refundEleDis = refundPolicyHeader.isDisplayed();
                    if (refundEleDis == true) {
                        extentPassLog("Displayed header : ", refundEleDis);
                        actualResult = refundPolicyHeader.getText();
                        extentInfoLog("Actual Header : ", actualResult);
                        extentInfoLog("Expected Header : ", expectedResult);
                        Assert.assertEquals(actualResult, expectedResult);
                    } else {
                        extentFailLog("Displayed header : ", refundEleDis);
                    }
                    break;
                case "Privacy Policy":
                    boolean privacyEleDis = privacyPolicyHeader.isDisplayed();
                    if (privacyEleDis == true) {
                        extentPassLog("Displayed header : ", privacyEleDis);
                        actualResult = privacyPolicyHeader.getText();
                        extentInfoLog("Actual Header : ", actualResult);
                        extentInfoLog("Expected Header : ", expectedResult);
                        Assert.assertEquals(actualResult, expectedResult);
                    } else {
                        extentFailLog("Displayed header : ", privacyEleDis);
                    }
                    break;
                case "Need Help?":
                    boolean helpEleDis = needHelpHeader.isDisplayed();
                    if (helpEleDis == true) {
                        extentPassLog("Displayed header : ", helpEleDis);
                        actualResult = needHelpHeader.getText();
                        extentInfoLog("Actual Header : ", actualResult);
                        extentInfoLog("Expected Header : ", expectedResult);
                        Assert.assertEquals(actualResult, expectedResult);
                    } else {
                        extentFailLog("Displayed header : ", helpEleDis);
                    }
                    break;
                case "Subscription Policy":
                    boolean subsEleDis = subscriptionPolicyHeader.isDisplayed();
                    if (subsEleDis == true) {
                        extentPassLog("Displayed header : ", subsEleDis);
                        actualResult = subscriptionPolicyHeader.getText();
                        extentInfoLog("Actual Header : ", actualResult);
                        extentInfoLog("Expected Header : ", expectedResult);
                        Assert.assertEquals(actualResult, expectedResult);
                    } else {
                        extentFailLog("Displayed header : ", subsEleDis);
                    }
                    break;
                case "Terms & Conditions":
                    boolean termEleDis = termConditionHeader.isDisplayed();
                    if (termEleDis == true) {
                        extentPassLog("Displayed header : ", termEleDis);
                        actualResult = termConditionHeader.getText();
                        extentInfoLog("Actual Header : ", actualResult);
                        extentInfoLog("Expected Header : ", expectedResult);
                        Assert.assertEquals(actualResult, expectedResult);
                    } else {
                        extentFailLog("Displayed header : ", termEleDis);
                    }
                    break;
            }
        } else {
            extentFailLog("Displayed link : ", eleDisplayed);
        }
    }

    public void checkValidationMessage(String expectedRsult) {
        Action.explicitWait(validationMessage, 30);
        String actualResult = validationMessage.getText();
        Action.printAndAssert(actualResult, expectedRsult);
    }

    public void removeProduct() {
        Action.explicitWaitForElementTobeclickable(shoppingBagLink, 30);
        shoppingBagLink.click();
        extentInfoLog("Clicked on : ", "Shopping Bag link");
        cart.checkRemoveProduct();
    }
}
