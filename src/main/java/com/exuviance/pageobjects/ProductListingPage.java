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
 * @author : Vaibhav Nagvekar
 * @Date : 02 Feb 2023
 **/

public class ProductListingPage extends BaseClass {

    String runOnBrowserstack = prop.getProperty("runOnBrowserstack");

    @FindBy(xpath = "//*[@id='navigation']/ul[2]/li[2]/a")
    private WebElement shopSkincareDropDownMenu;

    @FindBy(xpath = "//a[normalize-space()='Shop All Skincare']")
    private WebElement ShopAllSkincareLink;

    @FindBy(xpath = "//button[@aria-label='Bestsellers selected, Sort By']")
    private WebElement sortByDropdown;

    @FindBy(id = "dropdown-refinement-btn")
    private WebElement refineDropdown;

    @FindBy(xpath = "//*[@id='search-result-items']/li")
    private List<WebElement> itemCount;

    @FindBy(xpath = "(//img[@alt='Vitamin C Serum Capsules'])[1]")
    private WebElement productToCheckout;

    @FindBy(xpath = "//a[@id='quickviewbutton']")
    private WebElement clickQuickView;

    @FindBy(xpath = "//h1[normalize-space()='Vitamin C Serum Capsules']")
    private WebElement checkProductName;

    @FindBy(xpath = "//div[@id='525a0b348dab5f94c55a0169db']//button[@title='Add To Bag'][normalize-space()='Add To Bag']")
    private WebElement productAddToBagbtn;

    @FindBy(xpath = "//button[normalize-space()='No, thanks']")
    private WebElement noThanksBtn;

    @FindBy(xpath = "//a[@title='Go to Bag']")
    private WebElement viewShoppingBagBtn;

    @FindBy(xpath = "//div[@class='product-list-item']//a[@title='Go to Product: Vitamin C Serum Capsules'][normalize-space()='Vitamin C Serum Capsules']")
    private WebElement checkProductNameInCart;

    @FindBy(xpath = "//span[normalize-space()='Remove']")
    private WebElement removeLink;

    private WebElement sortOption(Object option) {
        return driver.findElement(By.xpath("//a[normalize-space()='" + option + "']"));
    }

    private WebElement refineOption(Object option) {
        return driver.findElement(By.xpath("//a[normalize-space()='" + option + "']"));
    }

    private WebElement product(Object productName) {
        return driver.findElement(By.xpath("//a[@title='Go to Product: " + productName + "']"));
    }

    public ProductListingPage() {
        PageFactory.initElements(driver, this);
    }

    public void printAndAssert(Object actualResult, Object expectedResult) {
        //Printing data in the report
        extentInfoLog("Actual result : ", actualResult);
        extentInfoLog("Expected result : ", expectedResult);

        //Assertion
        Assert.assertEquals(actualResult, expectedResult);
    }

    public void navigateToShopAllSkincare() {
        Action.moveToElement(driver, shopSkincareDropDownMenu);
        Action.explicitWaitForElementTobeclickable(ShopAllSkincareLink, 5);
        ShopAllSkincareLink.click();
    }

    public void selectSortByFilter(String option) throws InterruptedException {
        Action.explicitWaitForElementTobeclickable(sortByDropdown, 10);
        Action.scrollByPixels(driver, 250);
        sortByDropdown.click();
        sortOption(option).click();
        Thread.sleep(3000);
        //Printing data in the report
        extentInfoLog("Option selected from the sort dropdown : ", option);
    }

    public void selectRefineFilter(String option) throws InterruptedException {
        Action.explicitWaitForElementTobeclickable(refineDropdown, 10);
        Action.scrollByPixels(driver, 250);
        refineDropdown.click();
        Action.explicitWaitForElementTobeclickable(refineOption(option), 5);
        Action.click(driver, refineOption(option));
        Thread.sleep(3000);
        Action.scrollByPixels(driver, 500);
        //Printing data in the report
        extentInfoLog("Option selected from the refine filter : ", option);
    }

    /*
     * public void selectPagination(String value) throws InterruptedException {
     * Action.explicitWaitForElementTobeclickable(paginationDropdown, 10);
     * Action.scrollByPixels(driver,250); paginationDropdown.click(); Select zz =
     * new Select(paginationDropdown); zz.selectByVisibleText(value); //Printing
     * data in the report extentInfoLog("Value selected from pagination : ",value);
     * Action.waitFor(3000); }
     */

    public int getItemCount() {
        int totalItemsDisplayed = itemCount.size() - 3;
        extentInfoLog("Total items displayed : ", totalItemsDisplayed);
        return totalItemsDisplayed;
    }

    public void quickViewCheckout() {
        Action.scrollByVisibilityOfElement(driver, productToCheckout);
        Action.mouseOverElement(driver, productToCheckout);
        clickQuickView.click();
    }

    public void selectingProduct(Object productName) {
        product(productName).click();
    }

    public String getProductName() {
        Action.explicitWaitForElementTobeclickable(checkProductName, 10);
        return checkProductName.getText();
    }

    public void clickOnAddToBagBtn() {
        Action.scrollByPixels(driver, 400);
        Action.waitFor(2000);
        productAddToBagbtn.click();
        noThanksBtn.click();
        viewShoppingBagBtn.click();
    }

    public String checkProductNameInCart() {
        Action.explicitWaitForElementTobeclickable(checkProductNameInCart, 10);
        return checkProductNameInCart.getText();
    }

    public void removeFromCart() {
        Action.explicitWaitForElementTobeclickable(removeLink, 10);
        Action.click(driver, removeLink);
    }
}
