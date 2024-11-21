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
 * @Date : 07 Feb 2023
 **/

public class ProductDisplayPage extends BaseClass {

    @FindBy(xpath = "//div[@class='breadcrumb']")
    private WebElement breadCrumb;

    @FindBy(xpath = "//h1[@class='product-name']")
    private WebElement productNameText;

    @FindBy(xpath = "//*[@id='thumbnails']/ul/div/div/li")
    private List<WebElement> thumbnailsImgs;

    @FindBy(xpath = "//button[@id='ratings-summary']")
    private WebElement ratingsSummary;

    @FindBy(xpath = "//button[@id='WAR']")
    private WebElement writeReviewLink;

    @FindBy(xpath = "//*[@id='bv-mbox-lightbox-list']/div[1]/div/div/div/img")
    private WebElement thumbnailImage;

    @FindBy(xpath = "//*[@id='product-content']/div[2]")
    private WebElement price;

    @FindBy(xpath = "//select[@id='Quantity']")
    private WebElement quantityDropdown;

    @FindBy(css = "#add-to-cart")
    private WebElement addToBagBtn;

    @FindBy(xpath = "//div[@class='remotely-included-product-add-to-cart']//a[@title='Add this product to wishlist']//*[name()='svg']")
    private WebElement wishlistBtn;

    @FindBy(xpath = "//p[@class='subheading-1 text-center']")
    private WebElement youMayAlsoLikeHeading;

    @FindBy(xpath = "//*[@id='cq_recomm_slot-244afa1209f7b51bf86bb43c46']/div/ul/div/div/li[contains(@aria-hidden,'false')]")
    private List<WebElement> youMayAlsoLikeCount;

    private WebElement productDetailsTab(Object value) {
        return driver.findElement(By.xpath("//label[normalize-space()='" + value + "']"));
    }

    private WebElement productDetailsText(Object value) {
        return driver.findElement(By.xpath("//div[normalize-space()='" + value + "']"));
    }

    public ProductDisplayPage() {
        PageFactory.initElements(driver, this);
    }

    public void printAndAssert(Object actualResult, Object expectedResult) {
        //Printing data in the report
        extentInfoLog("Actual result : ", actualResult);
        extentInfoLog("Expected result : ", expectedResult);

        //Assertion
        Assert.assertEquals(actualResult, expectedResult);
    }

    public void checkBreadcrumb() {
        boolean eleDisplayed = breadCrumb.isDisplayed();
        extentInfoLog("Breadcrumb Displayed : ", eleDisplayed);
    }

    public void getThumbnailsCount() {
        int imgCount = thumbnailsImgs.size();
        extentInfoLog("Number of Thumbnails images Displayed : ", imgCount);
    }

    public void checkProductName() {
        boolean eleDisplayed = productNameText.isDisplayed();
        extentInfoLog("Product Name Displayed : ", eleDisplayed);

        if (eleDisplayed == true) {
            String actualResult = productNameText.getText();
            extentInfoLog("Product name : ", actualResult);
        }
    }

    public void checkRatings() {
        boolean eleDisplayed = ratingsSummary.isDisplayed();
        extentInfoLog("Ratings Displayed : ", eleDisplayed);
    }

    public void checkWARLink() {
        boolean eleDisplayed = writeReviewLink.isDisplayed();
        extentInfoLog("Write a review link Displayed : ", eleDisplayed);

        if (eleDisplayed == true) {
            String actualResult = writeReviewLink.getText();
            extentInfoLog("Link name : ", actualResult);
        }
    }

    public void clickWAR() {
        writeReviewLink.click();
        extentInfoLog("Clicked on : ", "'Write a review' Link.");
    }

    public void checkThumbnail() {
        boolean eleDisplayed = thumbnailImage.isDisplayed();
        extentInfoLog("Thumbnail Image Displayed : ", eleDisplayed);
    }

    public void checkPrice() {
        boolean eleDisplayed = price.isDisplayed();
        extentInfoLog("Price Displayed : ", eleDisplayed);
    }

    public void checkQuantityDropdown() {
        boolean eleDisplayed = quantityDropdown.isDisplayed();
        extentInfoLog("Quantity dropdown Displayed : ", eleDisplayed);
    }

    public void checkAddToBagBtn() {
        boolean eleDisplayed = addToBagBtn.isDisplayed();
        extentInfoLog("Add to Bag button Displayed : ", eleDisplayed);
    }

    public void clickOnAddToBagBtn() {
        Action.waitFor(3000);
        Action.scrollByVisibilityOfElement(driver, addToBagBtn);
        Action.mouseHoverByJavaScript(addToBagBtn);
        Action.waitFor(3000);
        Action.JSClick(addToBagBtn);
    }

    public void checkWishlistBtn() {
        boolean eleDisplayed = wishlistBtn.isDisplayed();
        extentInfoLog("Wishlist button Displayed : ", eleDisplayed);
    }

    public String getTextFromDetailsTab(Object tabValue, Object textValue) {
        Action.scrollByPixels(driver, 500);
        Action.explicitWaitForElementTobeclickable(productDetailsTab(tabValue), 10);
        productDetailsTab(tabValue).click();
        extentInfoLog("Clicked on the Tab : ", tabValue);
        return productDetailsText(textValue).getText();
    }

    public boolean checkYouMayAlsoLikeSection() {
        return youMayAlsoLikeHeading.isDisplayed();
    }

    public String getYouMayAlsoLikeSection() {
        return youMayAlsoLikeHeading.getText();
    }

    public int getYouMayAlsoLikeProductCount() {
        return youMayAlsoLikeCount.size();
    }

    public void checkYouMayAlsoLikeProductCount(boolean actualtext, String expectedResult) {
        if (actualtext == true) {
            String actualResult = getYouMayAlsoLikeSection();
            printAndAssert(actualResult, expectedResult);

            int productCount = getYouMayAlsoLikeProductCount();
            extentInfoLog("Number of product displayed in You May Also Like Section : ", productCount);
        }
    }
}
