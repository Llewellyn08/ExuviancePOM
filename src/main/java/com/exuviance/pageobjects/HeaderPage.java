package com.exuviance.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.exuviance.actiondriver.Action;
import com.exuviance.base.BaseClass;
import com.github.javafaker.Faker;

/**
 * Author : Vaibhav Nagvekar Date : 13 June 2022
 * Updated by: Rashi Tiwari Date : 16 Oct 2024
 **/

public class HeaderPage extends BaseClass {

    // Property to determine whether to run tests on Browserstack
    String runOnBrowserstack = prop.getProperty("runOnBrowserstack");

    // WebElements representing various elements on the page
    @FindBy(css = "#navigation > ul.menu-category.level-1 > li:nth-child(1) > a")
    private WebElement holiday;

    @FindBy(css = "#HeaderMenu-offers")
    private WebElement offers;

    @FindBy(xpath = "//span[normalize-space()='Email Sign Up']")
    private WebElement emailSignUp;

    @FindBy(xpath = "//h2[normalize-space()='Email Sign Up']")
    public WebElement emailSignUpText;

    @FindBy(xpath = "//*[@id='wrapper']/div[1]/div[1]/div/ul/li/div/div/form/div[9]/button")
    private WebElement submitBtn;

    @FindBy(xpath = "//img[@alt='EXUVIANCE®️']")
    private WebElement exuvianceLogo;

    @FindBy(xpath = "//summary[@aria-label='Search']")
    private WebElement searchIcon;
    
    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchBox;

    @FindBy(css = "#ProductCountDesktop")
    public WebElement searchSuccessText;

    @FindBy(css = "//p[@role='status']")
    private WebElement searchErrorText;

    @FindBy(css = "#cart-icon-bubble")
    private WebElement shoppingBagIcon;

    @FindBy(css = "span.cart_drawer__item-count")
    public WebElement shoppingBagText;

    @FindBy(css = "#HeaderMenu-bestsellers")
    private WebElement bestSellerDropDownMenu;

    @FindBy(css = "#HeaderMenu-bestsellers-discover-shop-all-bestsellers")
    private WebElement shopAllBestSeller;

    @FindBy(css = "#HeaderMenu-shop-skincare")
    private WebElement shopSkincareDropDownMenu;

    @FindBy(css = "#HeaderMenu-discover")
    private WebElement discoverDropDownMenu;

    @FindBy(xpath = "//button[@aria-label='close']")
    private WebElement popupCloseBtn;

    @FindBy(xpath = "//*[@id='navigation']/ul[2]/li[1]/div/div/div[2]/div")
    private List<WebElement> bestSellerItemCount;

    @FindBy(xpath = "//*[@id='navigation']/ul[2]/li[3]/div/div/div[2]/div")
    private List<WebElement> discoverItemCount;

    // WebElements for email sign-up
    @FindBy(xpath = "//input[@id='header-email']")
    private WebElement emailSignUpInput;

    @FindBy(xpath = "//span[@id='header-email-error']")
    private WebElement emailSignUpError;

    @FindBy(xpath = "//p[normalize-space()='Email address already taken.']")
    private WebElement emailSignUpValidation;

    @FindBy(xpath = "//div[@class='signup-message']//p[1]")
    private WebElement emailSignUpSuccess;

    private WebElement getHolidaySubMenus(String subMenu) {
        return driver
                .findElement(By.xpath("//*[@id='navigation']/ul[2]/li[1]/div/div/div[1]/div/ul/li[" + subMenu + "]/a"));
    }

    private WebElement getHolidayItems(String item) {
        return driver.findElement(By.xpath("//*[@id='navigation']/ul[2]/li[1]/div/div/div[2]/div/div[" + item + "]"));
    }

    private WebElement getItems(String menu, String item) {
        return driver.findElement(
                By.xpath("//*[@id='navigation']/ul[2]/li[" + menu + "]/div/div/div[2]/div[" + item + "]/a[2]"));
    }

    private WebElement getBestSellerSubMenus(String subMenu) {
        return driver 
                .findElement(By.xpath("//*[@class='mega-menu__list header-width']/div[" + subMenu + "]"));
    }

    private WebElement getSkincareSubMenus(String category, String subMenu) {
        return driver.findElement(
                By.xpath("//*[@id='MegaMenu-Content-2']/ul/li[" + category + "]/ul/li[" + subMenu + "]/a"));
    }

    private WebElement getDiscoverSubMenus(String subMenu) {
        return driver 
                .findElement(By.xpath("//*[@id='MegaMenu-Content-3']//li[" + subMenu + "]/a"));
    }

    // Constructor to initialize page elements using PageFactory
    public HeaderPage() {
        PageFactory.initElements(driver, this);
    }

    // Assertion Method
    public void assertion(String actualResult, String expectedResult) {
        Assert.assertEquals(actualResult, expectedResult);
    }

    // Printing Data on Report
    public void printDataOnReport(String actualResult, String expectedResult) {
        extentInfoLog("Assertion on Actual result : ", actualResult);
        extentInfoLog("Assertion on Expected result : ", expectedResult);
    }

    public void printDataOnReport(String testcase, String actualResult, String expectedResult) {
        extentInfoLog("Test-Case Name : ", testcase);
        extentInfoLog("Assertion on Actual result : ", actualResult);
        extentInfoLog("Assertion on Expected result : ", expectedResult);
    }

    // Validates the presence of a logo on the page
    public void validateLogo() {
        boolean result = Action.isDisplayed(driver, exuvianceLogo);

        if (runOnBrowserstack.contains("Yes")) {
            this.assertTrueBS(result, "Logo is Displayed", "Logo is Mismatched");
        } else {
            extentInfoLog("Is logo displayed : ", result);
            Assert.assertTrue(result);
        }
    }

    // Clicks on the 'offers' element and validates the URL
    public void clickOnOffers(String expectedURL) {
        Action.explicitWaitForElementTobeclickable(offers, 10);
        Action.click(driver, offers);
        String actualURL = driver.getCurrentUrl();
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedURL, actualURL, "Redirected to correct page", "Redirected to login-error");
        } else {
            extentInfoLog("Actual URL : ", actualURL);
            extentInfoLog("Expected URL : ", expectedURL);
            Assert.assertEquals(actualURL, expectedURL);
        }
    }

    // Clicks on the 'emailSignUp' element and validates the text
    public void clickOnEmailSignUp(String expectedText) {
        Action.click(driver, emailSignUp);
        String actualText = emailSignUpText.getText();
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedText, actualText, "Correct text displayed", "Text is Mismatched");
        } else {
            extentInfoLog("Actual Text : ", actualText);
            extentInfoLog("Expected Text : ", expectedText);
            Assert.assertEquals(actualText, expectedText);
        }
    }

    // Enters an email address and submits the email sign-up form
    public void enterEmail(String email) {
        Action.explicitWaitForElementTobeclickable(emailSignUpInput, 10);
        emailSignUpInput.sendKeys(email);
        Action.pressTab(driver);
        Action.pressEnter(driver);
        Action.waitFor(10);
        submitBtn.click();
    }

    // Checks the email sign-up process using provided email address
    public void checkEmailSignUp(String email) {
        Action.click(driver, emailSignUp);
        if (email.contains("Random")) {
            Faker faker = new Faker();
            String emailAdd = faker.internet().emailAddress();
            this.enterEmail(emailAdd);
            extentInfoLog("Email : ", emailAdd);
        } else {
            this.enterEmail(email);
            extentInfoLog("Email : ", email);
        }
    }

    // Validating Email Error Message
    public String emailErrorMsg(String testcase, String expectedResult) {
        String actualResult = emailSignUpError.getText();
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualResult, "Correct text displayed", "Wrong text displayed");
        } else {
            extentInfoLog("Test Case : ", testcase);
            extentInfoLog("Actual Text : ", actualResult);
            extentInfoLog("Expected Text : ", expectedResult);
            Assert.assertEquals(actualResult, expectedResult);
        }
        return actualResult;
    }

    // Validating Message for Existing Email
    public String emailValidationMsg(String testcase, String expectedResult) {
        String actualResult = emailSignUpValidation.getText();
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualResult, "Correct text displayed", "Wrong text displayed");
        } else {
            extentInfoLog("Test Case : ", testcase);
            extentInfoLog("Actual Text : ", actualResult);
            extentInfoLog("Expected Text : ", expectedResult);
            Assert.assertEquals(actualResult, expectedResult);
        }
        return actualResult;
    }

    // Validating Message on Successful Sign Up
    public String emailSuccessMsg(String testcase, String expectedResult) {
        String actualResult = emailSignUpSuccess.getText();
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualResult, "Correct text displayed", "Wrong text displayed");
        } else {
            extentInfoLog("Test Case : ", testcase);
            extentInfoLog("Actual Text : ", actualResult);
            extentInfoLog("Expected Text : ", expectedResult);
            Assert.assertEquals(actualResult, expectedResult);
        }
        return actualResult;
    }

    // Enters a search query and validates search results and error messages
    public void inputSearchBox(String testcase, String value, String expectedResult) {
        String actualResult = null;
        Action.click(driver, searchIcon);
        Action.type(searchBox, value);
        Action.pressEnter(driver);
                actualResult = driver.getTitle();
                System.out.println(actualResult);

        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualResult, "Correct text displayed", "Text is Mismatched");
        } else {
            extentInfoLog("Test case : ", testcase);
            extentInfoLog("Search keyword : ", value);
            extentInfoLog("Actual Result : ", actualResult);
            extentInfoLog("Expected Result : ", expectedResult);
            Assert.assertEquals(actualResult, expectedResult);
        }
    }

    // Clicks on the shopping bag icon and validates the text
    public void clickShoppingBag(String expectedText) {
        Action.moveToElement(driver, shoppingBagIcon);
        Action.click(driver, shoppingBagIcon);
        Action.explicitWaitForElementTobeclickable(shoppingBagText, 30);
        String actualText = shoppingBagText.getText();
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedText, actualText, "Correct text displayed", "Text is Mismatched");
        } else {
            extentInfoLog("Actual Text : ", actualText);
            extentInfoLog("Expected Text : ", expectedText);
            Assert.assertEquals(actualText, expectedText);
        }
    }

    // Clicks on the 'holiday' element and returns a new HeaderPage object
    public HeaderPage clickOnHoliday() {
        Action.explicitWait(holiday, 15);
        Action.click(driver, holiday);
        return new HeaderPage();
    }

    // Clicks on a sub-menu item under the 'holiday' dropdown and validates the URL
    public void checkHolidayDropdownAction(String testcase, String expectedResult, String subMenu) {
        Action.explicitWait(holiday, 15);
        Action.mouseover(driver, holiday);
        Action.explicitWait(getHolidaySubMenus(subMenu), 15);
        Action.click(driver, getHolidaySubMenus(subMenu));
        String actualResult = driver.getCurrentUrl();
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
        } else {
            extentInfoLog("Test case : ", testcase);
            extentInfoLog("Actual URL : ", actualResult);
            extentInfoLog("Expected URL : ", expectedResult);
            Assert.assertEquals(actualResult, expectedResult);
        }
    }

    // Clicks on an item under the 'holiday' dropdown and returns a new HeaderPage object
    public HeaderPage checkHolidayDropdownItems(String item) {
        Action.explicitWait(holiday, 15);
        Action.mouseover(driver, holiday);
        Action.explicitWait(getHolidayItems(item), 15);
        Action.click(driver, getHolidayItems(item));
        return new HeaderPage();
    }

    // Clicks on a sub-menu item under the 'best seller' dropdown and validates the URL
    public void checkBestSellerDropdownAction(String testcase, String expectedResult, String subMenu) {
        Action.explicitWait(bestSellerDropDownMenu, 15);
        Action.click(driver, bestSellerDropDownMenu);
        Action.explicitWait(getBestSellerSubMenus(subMenu), 15);
        Action.click(driver, getBestSellerSubMenus(subMenu));
        String actualResult = driver.getCurrentUrl();
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
        } else {
            extentInfoLog("Test case : ", testcase);
            extentInfoLog("Actual URL : ", actualResult);
            extentInfoLog("Expected URL : ", expectedResult);
            Assert.assertEquals(actualResult, expectedResult);
        }
    }

    // Validates the number of items in the 'best seller' dropdown
    public void checkBestSellerShopAll(String testcase,String expectedResult) {
        Action.explicitWait(bestSellerDropDownMenu, 10);
        Action.click(driver, bestSellerDropDownMenu);
        Action.explicitWait(shopAllBestSeller, 10);
        Action.click(driver, shopAllBestSeller);
        String actualResult = driver.getCurrentUrl();;
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
        } else {
            extentInfoLog("Test case : ", testcase);
            extentInfoLog("Actual Item Count : ", actualResult);
            extentInfoLog("Expected Item Count : ", expectedResult);
            Assert.assertEquals(actualResult, expectedResult);
        }
    }

    // Validates the number of items in the 'discover' dropdown
    public void checkDiscoverItemCount(String testcase, String value, String expectedResult) {
        Action.explicitWait(discoverDropDownMenu, 10);
        Action.mouseover(driver, discoverDropDownMenu);
        int actualResult = discoverItemCount.size();
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualResult, "Number of Item count is Correct",
                    "Number of Item count is Wrong");
        } else {
            extentInfoLog("Test case : ", testcase);
            extentInfoLog("Actual Item Count : ", actualResult);
            extentInfoLog("Expected Item Count : ", expectedResult);
            Assert.assertEquals(actualResult, Integer.parseInt(expectedResult));
        }
    }

    // INACTIVE: Clicks on an item under the 'best seller'dropdown and returns a new HeaderPage object
    public HeaderPage checkBestSellerDropdownItems(String menu, String item) {
        Action.explicitWait(bestSellerDropDownMenu, 15);
        Action.mouseover(driver, bestSellerDropDownMenu);
        Action.explicitWait(getItems(menu, item), 15);
        Action.click(driver, getItems(menu, item));
        return new HeaderPage();
    }

    // Clicks on a sub-menu item under the 'shop skincare' dropdown and validates the URL
    public void checkShopSkincareDropDownAction(String testcase, String category, String subMenu,
                                                String expectedResult) {
        Action.explicitWait(shopSkincareDropDownMenu, 15);
        Action.click(driver,shopSkincareDropDownMenu);
        Action.explicitWait(getSkincareSubMenus(category, subMenu), 15);
        Action.click(driver, getSkincareSubMenus(category, subMenu));
        String actualResult = driver.getCurrentUrl();
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
        } else {
            extentInfoLog("Test case : ", testcase);
            extentInfoLog("Actual URL : ", actualResult);
            extentInfoLog("Expected URL : ", expectedResult);
            Assert.assertEquals(actualResult, expectedResult);
        }
    }

    // Clicks on a sub-menu item under the 'discover' dropdown and validates the URL
    public void checkDiscoverDropdownAction(String testcase, String subMenu, String expectedResult) {
        Action.explicitWait(discoverDropDownMenu, 15);
        Action.scrollByPixels(driver, 500);
        Action.click(driver, discoverDropDownMenu);
        Action.explicitWait(getDiscoverSubMenus(subMenu), 15);
        Action.click(driver, getDiscoverSubMenus(subMenu));
        String actualResult = driver.getCurrentUrl();
        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
        } else {
            extentInfoLog("Test case : ", testcase);
            extentInfoLog("Actual URL : ", actualResult);
            extentInfoLog("Expected URL : ", expectedResult);
            Assert.assertEquals(actualResult, expectedResult);
        }
    }

    // INACTIVE: Clicks on an item under the 'discover' dropdown and returns a HeaderPage object
    public HeaderPage checkDiscoverDropdownItems(String menu, String item) {
        Action.explicitWait(discoverDropDownMenu, 15);
        Action.mouseover(driver, discoverDropDownMenu);
        Action.explicitWait(getItems(menu, item), 15);
        Action.click(driver, getItems(menu, item));
        return new HeaderPage();
    }
}
