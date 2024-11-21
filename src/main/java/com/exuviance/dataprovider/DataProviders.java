package com.exuviance.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {
/*
	NewExcelLibrary obj = new NewExcelLibrary();

	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = obj.getRowCount("Credentials");
		// Total Columns
		int column = obj.getColumnCount("Credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i+2);
			}
		}
		return data;
	}

	@DataProvider(name = "forgotpassword")
	public Object[][] getEmail() {
		// Totals rows count
		int rows = obj.getRowCount("ForgotPassword");
		// Total Columns
		int column = obj.getColumnCount("ForgotPassword");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {			
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("ForgotPassword", j, i + 2);
			}
		}
		return data;
	}

	@DataProvider(name = "registration")
	public Object[][] getRegistration() {
		// Totals rows count
		int rows = obj.getRowCount("Registration");
		// Total Columns
		int column = obj.getColumnCount("Registration");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Registration", j, i + 2);
			}
		}
		return data;
	}
	
	DataFormatter formatter = new DataFormatter();
	String dataPath = "src/test/resources/TestData/";

	// ----------- Start of Data Providers for Registration Module -----------
	@DataProvider(name = "privacyPolicyLink")
	public Object[][] privacyPolicyLink() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "RegistrationTestData.xlsx");
		Object[][] data = getAllData(fis, "privacyPolicyLink");
		return data;
	}
	
	@DataProvider(name = "financialIncentLink")
	public Object[][] financialIncentLink() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "RegistrationTestData.xlsx");
		Object[][] data = getAllData(fis, "financialIncentLink");
		return data;
	}
	// ----------- End of Data Providers for Registration Module -----------

	// ----------- Start of Data Providers for Header Module -----------
	@DataProvider(name = "Holiday")
	public Object[][] Holiday() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "HeaderTestData.xlsx");
		Object[][] data = getAllData(fis, "Holiday");
		return data;
	}

	@DataProvider(name = "HolidayItems")
	public Object[][] HolidayItems() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "HeaderTestData.xlsx");
		Object[][] data = getAllData(fis, "HolidayItems");
		return data;
	}

	@DataProvider(name = "BestSeller")
	public Object[][] BestSeller() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "HeaderTestData.xlsx");
		Object[][] data = getAllData(fis, "BestSeller");
		return data;
	}

	@DataProvider(name = "BestSellerItem")
	public Object[][] BestSellerItem() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "HeaderTestData.xlsx");
		Object[][] data = getAllData(fis, "BestSellerItem");
		return data;
	}

	@DataProvider(name = "SkinCare")
	public Object[][] SkinCare() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "HeaderTestData.xlsx");
		Object[][] data = getAllData(fis, "SkinCare");
		return data;
	}

	@DataProvider(name = "Discover")
	public Object[][] Discover() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "HeaderTestData.xlsx");
		Object[][] data = getAllData(fis, "Discover");
		return data;
	}

	@DataProvider(name = "DiscoverItem")
	public Object[][] DiscoverItem() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "HeaderTestData.xlsx");
		Object[][] data = getAllData(fis, "DiscoverItem");
		return data;
	}

	@DataProvider(name = "ItemsCount")
	public Object[][] ItemsCount() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "HeaderTestData.xlsx");
		Object[][] data = getAllData(fis, "ItemsCount");
		return data;
	}

	@DataProvider(name = "EmailSignUp")
	public Object[][] EmailSignUp() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "HeaderTestData.xlsx");
		Object[][] data = getAllData(fis, "EmailSignUp");
		return data;
	}

	@DataProvider(name = "Search")
	public Object[][] Search() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "HeaderTestData.xlsx");
		Object[][] data = getAllData(fis, "Search");
		return data;
	}	
	// ----------- End of Data Providers for Header Module -----------

	// ----------- Start of Data Providers for Footer Module ----------
	@DataProvider(name = "Links")
	public Object[][] Links() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "FooterTestData.xlsx");
		Object[][] data = getAllData(fis, "Links");
		return data;
	}

	@DataProvider(name = "SocailMedia")
	public Object[][] SocailMedia() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "FooterTestData.xlsx");
		Object[][] data = getAllData(fis, "SocailMedia");
		return data;
	}

	@DataProvider(name = "newLinks")
	public Object[][] newLinks() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "FooterTestData.xlsx");
		Object[][] data = getAllData(fis, "newLinks");
		return data;
	}

	@DataProvider(name = "emailSignUpFooter")
	public Object[][] emailSignUpFooter() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "FooterTestData.xlsx");
		Object[][] data = getAllData(fis, "emailSignUpFooter");
		return data;
	}
	// ----------- End of Data Providers for footer Module -----------

	// ----------- Start of Data Providers for Holiday Module ----------
	@DataProvider(name = "skinConcernLinks")
	public Object[][] skinConcernLinks() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "HolidayTestData.xlsx");
		Object[][] data = getAllData(fis, "skinConcernLinks");
		return data;
	}

	@DataProvider(name = "productTypeLinks")
	public Object[][] productTypeLinks() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "HolidayTestData.xlsx");
		Object[][] data = getAllData(fis, "productTypeLinks");
		return data;
	}
	// ----------- End of Data Providers for Holiday Module -----------
	
	// ----------- Start of Data Providers for OurStory Module -----------
	
	@DataProvider(name = "BrightenAndRenew")
	public Object[][] BrightenAndRenew() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "OurStoryTestData.xlsx");
		Object[][] data = getAllData(fis, "BrightenAndRenew");
		return data;
	}
	
	@DataProvider(name = "AcneProneAndRenew")
	public Object[][] AcneProneAndRenew() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "OurStoryTestData.xlsx");
		Object[][] data = getAllData(fis, "AcneProneAndRenew");
		return data;
	}
	
	@DataProvider(name = "HydrateAndRenew")
	public Object[][] HydrateAndRenew() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "OurStoryTestData.xlsx");
		Object[][] data = getAllData(fis, "HydrateAndRenew");
		return data;
	}
	
	@DataProvider(name = "ComprehensiveAntiaging")
	public Object[][] ComprehensiveAntiaging() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "OurStoryTestData.xlsx");
		Object[][] data = getAllData(fis, "ComprehensiveAntiaging");
		return data;
	}
	// ----------- End of Data Providers for OurStory Module -----------

	// ----------- Start of Data Providers for Quiz Module ----------
	
	@DataProvider(name = "quiz")
	public Object[][] quiz() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "QuizTestData.xlsx");
		Object[][] data = getAllData(fis, "quiz");
		return data;
	}

	@DataProvider(name = "privacyPolicy")
	public Object[][] privacyPolicy() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "QuizTestData.xlsx");
		Object[][] data = getAllData(fis, "privacyPolicy");
		return data;
	}

	@DataProvider(name = "email")
	public Object[][] email() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "QuizTestData.xlsx");
		Object[][] data = getAllData(fis, "email");
		return data;
	}	
	// ----------- End of Data Providers for Quiz Module -----------

	// ----------- Start of Data Providers for PLP Module ----------
	@DataProvider(name = "sortOption")
	public Object[][] sortOption() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ProductListingPageTestData.xlsx");
		Object[][] data = getAllData(fis, "sortOption");
		return data;
	}

	@DataProvider(name = "refineOption")
	public Object[][] refineOption() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ProductListingPageTestData.xlsx");
		Object[][] data = getAllData(fis, "refineOption");
		return data;
	}

	@DataProvider(name = "paginationOption")
	public Object[][] paginationOption() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ProductListingPageTestData.xlsx");
		Object[][] data = getAllData(fis, "paginationOption");
		return data;
	}

	@DataProvider(name = "quickView")
	public Object[][] quickView() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ProductListingPageTestData.xlsx");
		Object[][] data = getAllData(fis, "quickView");
		return data;
	}

	@DataProvider(name = "addToBag")
	public Object[][] addToBag() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ProductListingPageTestData.xlsx");
		Object[][] data = getAllData(fis, "addToBag");
		return data;
	}
	// ----------- End of Data Providers for PLP Module -----------

	// ----------- Start of Data Providers for PDP Module ----------
	@DataProvider(name = "productDetails")
	public Object[][] productDetails() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ProductDisplayPageTestData.xlsx");
		Object[][] data = getAllData(fis, "productDetails");
		return data;
	}

	@DataProvider(name = "ymal")
	public Object[][] ymal() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ProductDisplayPageTestData.xlsx");
		Object[][] data = getAllData(fis, "ymal");
		return data;
	}
	
	@DataProvider(name = "thumbnailI")
	public Object[][] thumbnailI() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ProductDisplayPageTestData.xlsx");
		Object[][] data = getAllData(fis, "thumbnailI");
		return data;
	}
	
	@DataProvider(name = "allWebElements")
	public Object[][] allWebElements() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ProductDisplayPageTestData.xlsx");
		Object[][] data = getAllData(fis, "allWebElements");
		return data;
	}
	// ----------- End of Data Providers for PDP Module -----------

	// ----------- Start of Data Providers for cart Module ----------
	@DataProvider(name = "couponCode")
	public Object[][] couponCode() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "CartTestData.xlsx");
		Object[][] data = getAllData(fis, "couponCode");
		return data;
	}

	@DataProvider(name = "orderDetails")
	public Object[][] orderDetails() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "CartTestData.xlsx");
		Object[][] data = getAllData(fis, "orderDetails");
		return data;
	}
	
	@DataProvider(name = "editProduct")
	public Object[][] editProduct() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "CartTestData.xlsx");
		Object[][] data = getAllData(fis, "editProduct");
		return data;
	}
	
	@DataProvider(name = "miniCartEleCheck")
	public Object[][] miniCartEleCheck() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "CartTestData.xlsx");
		Object[][] data = getAllData(fis, "miniCartEleCheck");
		return data;
	}
	
	@DataProvider(name = "cartEleCheck")
	public Object[][] cartEleCheck() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "CartTestData.xlsx");
		Object[][] data = getAllData(fis, "cartEleCheck");
		return data;
	}
	
	
	@DataProvider(name = "removeProduct")
	public Object[][] removeProduct() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "CartTestData.xlsx");
		Object[][] data = getAllData(fis, "removeProduct");
		return data;
	}
	
	@DataProvider(name = "saveLaterProduct")
	public Object[][] saveLaterProduct() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "CartTestData.xlsx");
		Object[][] data = getAllData(fis, "saveLaterProduct");
		return data;
	}
	
	@DataProvider(name = "checkout")
	public Object[][] checkout() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "CartTestData.xlsx");
		Object[][] data = getAllData(fis, "checkout");
		return data;
	}
	
	@DataProvider(name = "bonusProduct")
	public Object[][] bonusProduct() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "CartTestData.xlsx");
		Object[][] data = getAllData(fis, "bonusProduct");
		return data;
	}
	
	@DataProvider(name = "recommendation")
	public Object[][] recommendation() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "CartTestData.xlsx");
		Object[][] data = getAllData(fis, "recommendation");
		return data;
	}
	
	@DataProvider(name = "paypal")
	public Object[][] paypal() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "CartTestData.xlsx");
		Object[][] data = getAllData(fis, "paypal");
		return data;
	}
	
	@DataProvider(name = "klarna")
	public Object[][] klarna() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "CartTestData.xlsx");
		Object[][] data = getAllData(fis, "klarna");
		return data;
	}	
	// ----------- End of Data Providers for cart Module -----------
	
	// ----------- Start of Data Providers for shipping Module -----------
	@DataProvider(name = "shippingLinks")
	public Object[][] shippingLinks() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ShippingTestData.xlsx");
		Object[][] data = getAllData(fis, "shippingLinks");
		return data;
	}
	
	@DataProvider(name = "sectionTitle")
	public Object[][] sectionTitle() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ShippingTestData.xlsx");
		Object[][] data = getAllData(fis, "sectionTitle");
		return data;
	}
	
	@DataProvider(name = "shippingDetailsValidation")
	public Object[][] shippingDetailsValidation() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ShippingTestData.xlsx");
		Object[][] data = getAllData(fis, "shippingDetailsValidation");
		return data;
	}
	
	@DataProvider(name = "shippingDetails")
	public Object[][] shippingDetails() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ShippingTestData.xlsx");
		Object[][] data = getAllData(fis, "shippingDetails");
		return data;
	}
	
	@DataProvider(name = "cardDetailsValidation")
	public Object[][] cardDetailsValidation() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ShippingTestData.xlsx");
		Object[][] data = getAllData(fis, "cardDetailsValidation");
		return data;
	}
	
	@DataProvider(name = "cardDetails")
	public Object[][] cardDetails() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ShippingTestData.xlsx");
		Object[][] data = getAllData(fis, "cardDetails");
		return data;
	}
	
	@DataProvider(name = "shippingOrderDetails")
	public Object[][] shippingOrderDetails() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ShippingTestData.xlsx");
		Object[][] data = getAllData(fis, "shippingOrderDetails");
		return data;
	}
	
	@DataProvider(name = "cardDetailsForLoggedinUser")
	public Object[][] cardDetailsForLoggedinUser() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "ShippingTestData.xlsx");
		Object[][] data = getAllData(fis, "cardDetailsForLoggedinUser");
		return data;
	}	
	// ----------- End of Data Providers for shipping Module -----------

	// ----------- Start of Data Providers for wishlist Module -----------
	@DataProvider(name = "verifyWishList")
	public Object[][] verifyWishList() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "WishlistTestData.xlsx");
		Object[][] data = getAllData(fis, "verifyWishList");
		return data;
	}

	@DataProvider(name = "validSomeoneWishlist")
	public Object[][] validSomeoneWishlist() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "WishlistTestData.xlsx");
		Object[][] data = getAllData(fis, "validSomeoneWishlist");
		return data;
	}

	@DataProvider(name = "invalidSomeoneWishlist")
	public Object[][] invalidSomeoneWishlist() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "WishlistTestData.xlsx");
		Object[][] data = getAllData(fis, "invalidSomeoneWishlist");
		return data;
	}

	@DataProvider(name = "wishlistProduct")
	public Object[][] wishlistProduct() throws IOException {
		FileInputStream fis = new FileInputStream(dataPath + "WishlistTestData.xlsx");
		Object[][] data = getAllData(fis, "wishlistProduct");
		return data;
	}
	// ----------- End of Data Providers for wishlist Module -----------

	public Object[][] getAllData(FileInputStream fis, String sheetName) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// XSSFSheet sheet = wb.getSheetAt(0);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		Object data[][] = new Object[rowCount - 1][colCount];
		for (int i = 0; i < rowCount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		return data;
	}*/
}
