package com.exuviance.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.exuviance.base.BaseClass;
import com.exuviance.dataprovider.DataProviders;
import com.exuviance.pageobjects.HeaderPage;
import com.exuviance.pageobjects.HolidayPage;
import com.exuviance.pageobjects.IndexPage;

/**
 *	Author : Llewellyn Thattazhi
 *	Date : 19 October 2022
 **/

public class HolidayPageTest extends BaseClass {

	@BeforeMethod
	public void setup() {
		launchApplication();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority=1, enabled=true)
	public void HOLIDAY_verifyBreadCrumb() {
		index.closePopup();
		header.clickOnHoliday();
		holiday.validateBreadCrumb();
	}
	
	@Test(priority=2, enabled=true)
	public void HOLIDAY_verifyHolidayBanner() {
		index.closePopup();
		header.clickOnHoliday();
		holiday.validateHolidayBanner();
	}
	
	@Test(priority=3, enabled=true)
	public void HOLIDAY_verifyFreeShippingBanner() {
		index.closePopup();
		header.clickOnHoliday();
		holiday.clickOnFreeShippingBanner();
	}
	
	@Test(priority=4, enabled=true)
	public void HOLIDAY_verifyShopAllGifySetsSubheading() {
		index.closePopup();
		header.clickOnHoliday();
		holiday.validateShopAllGiftSetsSubheading();
	}
	
	@Test(priority=5, enabled=true)
	public void HOLIDAY_verifyShopAllGiftSetsSection() {
		index.closePopup();
		header.clickOnHoliday();
		holiday.validateShopAllGiftSetsSection();
	}
	
	@Test(priority=6, enabled=true)
	public void HOLIDAY_verifyLimitedOfferTile() {
		index.closePopup();
		header.clickOnHoliday();
		holiday.validateLimitedOfferTile();
	}
	
	@Test(priority=7, enabled=true)
	public void HOLIDAY_verifyShopBySkinConcernSubheading() {
		index.closePopup();
		header.clickOnHoliday();
		holiday.validateShopBySkinConcernSubheading();
	}
	
	@Test(priority=8, enabled=true)
	public void HOLIDAY_verifyShopBySkinConcernSubheading2() {
		index.closePopup();
		header.clickOnHoliday();
		holiday.validateShopBySkinConcernSubheading2();
	}
	
	@Test(priority=9, enabled=true)
	public void HOLIDAY_verifyShopBySkinConcernImage() {
		index.closePopup();
		header.clickOnHoliday();
		holiday.validateShopBySkinConcernImage();
	}
	
	@Test(priority=10, dataProvider = "skinConcernLinks", dataProviderClass = DataProviders.class, enabled=true)
	public void HOLIDAY_verifyShopBySkinConcernLinks(String testcase, String value, String expectedResult) throws InterruptedException {
		index.closePopup();
		header.clickOnHoliday();
		holiday.clickOnSkinConcernLink(testcase,value,expectedResult);
	}
	
	@Test(priority=11, enabled=true)
	public void HOLIDAY_verifyBestSellerSubheading() {
		index.closePopup();
		header.clickOnHoliday();
		holiday.validateBestSellerSubheading();
	}
	
	@Test(priority=12, enabled=true)
	public void HOLIDAY_verifyBestSellerSubheading2() {
		index.closePopup();
		header.clickOnHoliday();
		holiday.validateBestSellerSubheading2();
	}

	@Test(priority=13, enabled=true)
	public void HOLIDAY_verifyShopByProductTypeSubheading() {
		index.closePopup();
		header.clickOnHoliday();
		holiday.validateShopByProductTypeSubheading();
	}
	
	@Test(priority=14, enabled=true)
	public void HOLIDAY_verifyShopByProductTypeSubheading2() {
		index.closePopup();
		header.clickOnHoliday();
		holiday.validateShopByProductTypeSubheading2();
	}
	
	@Test(priority=15, enabled=true)
	public void HOLIDAY_verifyShopByProductType() {
		index.closePopup();
		header.clickOnHoliday();
		holiday.validateProductTypeImage();
	}
	
	@Test(priority=16, dataProvider = "productTypeLinks", dataProviderClass = DataProviders.class, enabled=true)
	public void HOLIDAY_verifyShopByProductTypeLinks(String testcase, String value, String expectedResult) throws InterruptedException {
		index.closePopup();
		header.clickOnHoliday();
		holiday.clickOnProductTypeLink(testcase,value,expectedResult);
	}
}