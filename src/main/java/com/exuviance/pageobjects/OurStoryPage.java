package com.exuviance.pageobjects;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.exuviance.actiondriver.Action;
import com.exuviance.base.BaseClass;

/**
 * @author : Llewellyn Thattazhi
 * @Date : 05 Nov 2024
 **/

public class OurStoryPage extends BaseClass {

    // Property to determine whether to run tests on Browserstack
    String runOnBrowserstack = prop.getProperty("runOnBrowserstack");

    // Selectors
    @FindBy(xpath = "//a[normalize-space()='Our Story']")
    private WebElement breadcrumb;

    @FindBy(css = "#HeaderMenu-discover > span")
    private WebElement discoverDropDownMenu;

    @FindBy(css = "#HeaderMenu-discover-discover-the-exuviance-story")
    private WebElement ourStoryPageLink;

    // Custom methods to locate sub-menus and items dynamically
    private WebElement getProducts(String uniqueId) {
        return driver.findElement(By.cssSelector("#CardLink-template--23575883809133__section_our_story_products_carousel_"+ uniqueId +""));
    }

    public OurStoryPage() {
        PageFactory.initElements(driver, this);
    }

    // Assertion Method
    public void assertion(String actualResult, String expectedResult) {
        // Assertion
        Assert.assertEquals(actualResult, expectedResult);
    }

    public void printDataOnReport(Object actualResult, Object expectedResult) {
        //Printing data on report
        extentInfoLog("Actual result : ", actualResult);
        extentInfoLog("Expected result : ", expectedResult);
    }

    public void printDataOnReport(String testcase, String actualResult, String expectedResult) {
        extentInfoLog("Test-Case Name : ", testcase);
        extentInfoLog("Assertion on Actual result : ", actualResult);
        extentInfoLog("Assertion on Expected result : ", expectedResult);
    }

    // Navigate to Our Story page
    public void navigateToOurStory() {
        Action.click(driver, discoverDropDownMenu);
        Action.explicitWaitForElementTobeclickable(ourStoryPageLink, 5);
        ourStoryPageLink.click();
        extentInfoLog("Clicked on : ", "The Exuviance Story");
    }

    // Clicks on PDP link in Each Category and validates URL
    public void verifyProducts(String uniqueId, String expectedResult) {
        Action.explicitWait(breadcrumb, 15);
        Action.scrollByVisibilityOfElement(driver, getProducts(uniqueId));
        Action.click(driver, getProducts(uniqueId));
        String actualResult = driver.getCurrentUrl();

        if (runOnBrowserstack.contains("Yes")) {
            this.assertEqualsBS(expectedResult, actualResult, "Redirected to correct URL", "Redirected to wrong URL");
        } else {
            Action.printAndAssert(actualResult, expectedResult);
        }
    }
}
