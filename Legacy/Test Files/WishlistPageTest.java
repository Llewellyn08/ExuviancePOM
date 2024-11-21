package com.exuviance.testcases;

import com.exuviance.dataprovider.DataProviders;
import com.exuviance.pageobjects.ProductListingPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;
import com.exuviance.pageobjects.IndexPage;
import com.exuviance.pageobjects.LoginPage;
import com.exuviance.pageobjects.WishlistPage;

/**
 *	Author : Vaibhav Nagvekar
 *	Date : 30 May 2022
 **/

public class WishlistPageTest extends BaseClass {

	IndexPage index;
	LoginPage login;
	WishlistPage wish;
	ProductListingPage PLP;

	@BeforeMethod
	public void setup() throws InterruptedException {
		launchApplication();
		index = new IndexPage();
		login = new LoginPage();
		wish = new WishlistPage();
		PLP = new ProductListingPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=1, dataProvider="verifyWishList", dataProviderClass= DataProviders.class, enabled=true)
	public void WISHLIST_verifyAddToWishlist(String testcase, String productName) throws InterruptedException {
		extentInfoLog("Test case : ", testcase);
		index.closePopup();
		index.clickOnLogin();
		login.doStaticLogin();
		PLP.navigateToShopAllSkincare();
		PLP.selectingProduct(productName);
		wish.clickOnWishlist(productName);
	}

	@Test(priority=2, dataProvider="invalidSomeoneWishlist", dataProviderClass= DataProviders.class, enabled=true)
	public void WISHLIST_verifyInvalidFindSomeoneWishlist(String testcase, String lastname, String firstname, String email, String expectedResult) {
		extentInfoLog("Test case : ", testcase);
		index.closePopup();
		index.clickOnLogin();
		login.doStaticLogin();
		wish.navigateToWishlist();
		wish.verifyInvalidSomeoneWishlist(lastname,firstname,email,expectedResult);
	}

	@Test(priority=3, dataProvider="validSomeoneWishlist", dataProviderClass= DataProviders.class, enabled=true)
	public void WISHLIST_verifyValidFindSomeoneWishlist(String testcase, String lastname, String firstname, String email, String expectedResult) {
		extentInfoLog("Test case : ", testcase);
		index.closePopup();
		index.clickOnLogin();
		login.doStaticLogin();
		wish.navigateToWishlist();
		wish.verifyValidSomeoneWishlist(lastname,firstname,email,expectedResult);
	}

	@Test(priority=4, dataProvider="wishlistProduct", dataProviderClass= DataProviders.class, enabled=true)
	public void WISHLIST_verifyAddToWishlistBeforeLogin(String testcase, String productName) {
		extentInfoLog("Test case : ", testcase);
		index.closePopup();
		PLP.navigateToShopAllSkincare();
		wish.clickOnWishlistProduct(productName);
		login.doStaticLogin();
		wish.searchAndVerifyWishlistProduct(productName);
	}
}