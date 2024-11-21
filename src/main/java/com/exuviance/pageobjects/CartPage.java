package com.exuviance.pageobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.exuviance.actiondriver.Action;
import com.exuviance.base.BaseClass;

/**
 * @author : Vaibhav Nagvekar
 * @Date : 06 Mar 2023
 **/

public class CartPage extends BaseClass {

    @FindBy(xpath = "//button[normalize-space()='No, thanks']")
    private WebElement noThanksBtn;

    @FindBy(xpath = "//p[@class='added-heading']")
    private WebElement miniCartTitle;

    @FindBy(xpath = "//span[normalize-space()='Order Subtotal']")
    private WebElement subTotalText;

    @FindBy(xpath = "//a[contains(normalize-space(),'View Bag')]")
    private WebElement viewBagBtn;

    @FindBy(xpath = "//a[normalize-space()='Continue Shopping']")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "(//p[@class='title-heading'])[1]")
    private WebElement cartTitle;

    @FindBy(xpath = "//a[normalize-space()='Select Bonus Products']")
    private WebElement selectBonusProductBtn;

    @FindBy(xpath = "//button[@id='bonus-product-1']")
    private WebElement selectBonusProduct1Btn;

    @FindBy(xpath = "//button[@id='bonus-product-2']")
    private WebElement selectBonusProduct2Btn;

    @FindBy(xpath = "//button[@id='bonus-product-3']")
    private WebElement selectBonusProduct3Btn;

    @FindBy(xpath = "(//button[@value='Add to Cart'])[1]")
    private WebElement addToBagBtn;

    @FindBy(xpath = "//*[@id='cart-table']/div/div[3]/div[1]/span")
    private List<WebElement> bonusText;

    @FindBy(xpath = "//*[@id='cart-table']/div[2]/div[3]/div[2]/div")
    private WebElement editLink;

    @FindBy(xpath = "//button[@id='add-to-cart']")
    private WebElement updateItemBtn;

    @FindBy(xpath = "//div[@class='actions']//span[contains(text(),'Remove')]")
    private WebElement removeLink;

    @FindBy(xpath = "//h1[normalize-space()='Your Shopping Bag is Currently Empty']")
    private WebElement shoppingBagEmptyText;

    @FindBy(xpath = "//h2[normalize-space()='Order Details']")
    private WebElement orderDetailsHeader;

    @FindBy(xpath = "//a[normalize-space()='+Add Offer Code']")
    private WebElement addOfferCodeLink;

    @FindBy(xpath = "//input[@id='dwfrm_cart_couponCode']")
    private WebElement couponInput;

    @FindBy(xpath = "//button[@id='add-coupon']")
    private WebElement addCouponBtn;

    @FindBy(xpath = "(//button[normalize-space()='Checkout'])[1]")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//button[@name='dwfrm_login_unregistered']")
    private WebElement guestCheckoutBtn;

    @FindBy(xpath = "//a[contains(@id,'paypal')]")
    private WebElement paypalBtn;

    @FindBy(xpath = "//klarna-express-button[@id='klarna-express-button-0']")
    private WebElement klarnaBtn;

    @FindBy(xpath = "//h2[normalize-space()='Recommended for You']")
    private WebElement recommendationText;

    @FindBy(xpath = "//*[@id='carousel-recommendationsx']/div/div/li[@aria-hidden='false']")
    private List<WebElement> recommendationProductCount;

    private WebElement getColumnTitles(Object value) {
        return driver.findElement(By.xpath("//span[normalize-space()='" + value + "']"));
    }

    private WebElement getValidationForCoupon(Object value) {
        return driver.findElement(By.xpath("//div[@class='" + value + "']"));
    }

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public void printDataOnReport(Object actualResult, Object expectedResult) {
        //Printing data on report
        extentInfoLog("Actual result : ", actualResult);
        extentInfoLog("Expected result : ", expectedResult);

        //Assertion
        Assert.assertEquals(actualResult, expectedResult);
    }

    public void clickNoThanksBtn() {
        Action.waitFor(3000);
        try {
            if (isElementClickable(noThanksBtn)) {
                noThanksBtn.click();
                System.out.println("Clicked on No Thanks button.");
            } else {
                System.out.println("No Thanks button is not visible or not enabled. Continuing with the script.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No Thanks button is not present. Continuing with the script.");
        }
    }

    private boolean isElementClickable(WebElement element) {
        try {
            Action.explicitWaitForElementTobeclickable(element, 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void checkMiniCartTitle() {
        String actualResult = miniCartTitle.getText();
        extentInfoLog("Title displayed on the mini cart : ", actualResult);
    }

    public void checkSubTotal() {
        String actualResult = subTotalText.getText();
        extentInfoLog("Sub total displayed on the mini cart : ", actualResult);
    }

    public void checkButtons() {
        boolean viewBtn = viewBagBtn.isDisplayed();
        extentInfoLog("'View Bag' Button Displayed : ", viewBtn);

        boolean continueBtn = continueShoppingBtn.isDisplayed();
        extentInfoLog("'Continue Shopping' Button Displayed : ", continueBtn);
    }

    public void clickOnViewBagButton() {
        try {
            cart.clickNoThanksBtn();
        } catch (NoSuchElementException e) {
            extentInfoLog("Bonus pop-up : ", "Not displayed");
        }
        Action.explicitWaitForElementTobeclickable(viewBagBtn, 10);
        viewBagBtn.click();
        extentInfoLog("Clicked on : ", "'View Bag' button");
    }

    public void checkCartTitle() {
        String actualResult = cartTitle.getText();
        extentInfoLog("Title displayed on the cart : ", actualResult);
    }

    public void checkCartOrderTitle() {
        Action.explicitWait(orderDetailsHeader, 10);
        String actualResult = orderDetailsHeader.getText();
        extentInfoLog("Order title displayed on the cart : ", actualResult);
    }

    public int addBonusProducts() {
        Action.explicitWaitForElementTobeclickable(selectBonusProductBtn, 10);
        selectBonusProductBtn.click();
        extentInfoLog("Clicked on 'Select Bonus Product' button", "");

        Action.explicitWaitForElementTobeclickable(selectBonusProduct1Btn, 10);
        boolean btn1 = selectBonusProduct1Btn.isDisplayed();
        extentInfoLog("Select button for product 1 displayed : ", btn1);
        if (btn1 == true) {
            selectBonusProduct1Btn.click();
            extentInfoLog("Clicked on 1st select button", "");
        }

        Action.explicitWaitForElementTobeclickable(selectBonusProduct2Btn, 10);
        boolean btn2 = selectBonusProduct2Btn.isDisplayed();
        extentInfoLog("Select button for product 2 displayed : ", btn2);
        if (btn2 == true) {
            selectBonusProduct2Btn.click();
            extentInfoLog("Clicked on 2nd select button", "");
        }

        Action.explicitWaitForElementTobeclickable(selectBonusProduct3Btn, 10);
        boolean btn3 = selectBonusProduct3Btn.isDisplayed();
        extentInfoLog("Select button for product 3 displayed : ", btn3);
        if (btn3 == true) {
            selectBonusProduct3Btn.click();
            extentInfoLog("Clicked on 3rd select button", "");
        }

        Action.explicitWaitForElementTobeclickable(addToBagBtn, 10);
        addToBagBtn.click();
        extentInfoLog("Clicked on 'Add to Bag' button", "");
        Action.waitFor(3000);
        return bonusText.size();
    }

    public String checkEditProduct() {
        Action.explicitWaitForElementTobeclickable(editLink, 10);
        editLink.click();
        extentInfoLog("Clicked on 'Edit' link from the cart", "");

        if (updateItemBtn.isDisplayed() == true) {
            Action.explicitWaitForElementTobeclickable(updateItemBtn, 10);
            String btnName = updateItemBtn.getText();
            extentInfoLog("Button name displayed : ", btnName);
            return btnName;
        }
        return null;
    }

    public String checkRemoveProduct() {
        Action.explicitWaitForElementTobeclickable(removeLink, 10);
        removeLink.click();
        extentInfoLog("Clicked on : ", "'Remove' link from the cart");
        Action.explicitWaitForElementTobeclickable(shoppingBagEmptyText, 10);
        return shoppingBagEmptyText.getText();
    }

    public String checkPromoCode(Object value, String code) {
        Action.waitFor(2000);
        addOfferCodeLink.click();
        couponInput.sendKeys(code);
        addCouponBtn.click();
        Action.waitFor(2000);
        return getColumnTitles(value).getText();
    }

    public String checkOfferCode(Object value, String code) {
        Action.explicitWaitForElementTobeclickable(addOfferCodeLink, 10);
        addOfferCodeLink.click();
        couponInput.sendKeys(code);
        extentInfoLog("Promo code entered : ", code);
        addCouponBtn.click();
        extentInfoLog("Clicked on : ", "'Apply' button");
        return getValidationForCoupon(value).getText();
    }

    public String clickOnCheckoutBtn() throws Exception {
        Action.scrollByPixels(driver, 200);
        Action.waitFor(5000);
        Action.JSClick(checkoutBtn);
        Action.waitFor(2000);
        extentInfoLog("Clicked on : ", "'Checkout' button");
        try {
            boolean eleDisplayed = guestCheckoutBtn.isDisplayed();
            extentInfoLog("Guest Checkout button displayed : ", eleDisplayed);
            guestCheckoutBtn.click();
            extentInfoLog("Clicked on : ", "'Guest Checkout' button");
        } catch (Exception e) {
            extentInfoLog("Guest Checkout button displayed : ", e);
        }
        return Action.getCurrentURL(driver);
    }

    public String clickOnPaypalBtn() {
        Action.scrollByPixels(driver, 300);
        Action.explicitWaitForElementTobeclickable(paypalBtn, 10);
        Action.JSClick(paypalBtn);
        Action.waitFor(2000);

        // hold all window handles in array list
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());

        //switch to new tab
        driver.switchTo().window(newTb.get(1));
        extentInfoLog("Page title of new tab : ", driver.getTitle());
        return driver.getTitle();
    }

    public String clickOnKlarnaBtn() {
        Action.scrollByPixels(driver, 300);
        Action.waitFor(2000);
        klarnaBtn.click();

        // hold all window handles in array list
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());

        //switch to new tab
        driver.switchTo().window(newTb.get(1));
        extentInfoLog("Page title of new tab : ", driver.getTitle());
        return driver.getTitle();
    }

    public void checkRecommendation() {
        boolean result = recommendationText.isDisplayed();
        extentInfoLog("'Recommendation Text' Displayed : ", result);
        extentInfoLog("'Recommendation Text' : ", recommendationText.getText());

        if (result == true) {
            int productCount = recommendationProductCount.size();
            extentInfoLog("Product displayed in 'Recommended for You' section : ", productCount);
        }
    }
}
