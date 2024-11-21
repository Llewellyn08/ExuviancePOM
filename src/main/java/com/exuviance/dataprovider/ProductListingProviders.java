package com.exuviance.dataprovider;

import com.exuviance.utility.DataProvider;

import java.io.IOException;

public class ProductListingProviders {

    String dataPath = "src\\test\\resources\\TestData\\ProductListingPageTestData.xlsx";

    DataProvider provider = new DataProvider();

    @org.testng.annotations.DataProvider(name = "sortOption")
    public Object[][] sortOption() throws IOException, IOException {
        return provider.getData(dataPath, "sortOption");
    }

    @org.testng.annotations.DataProvider(name = "refineOption")
    public Object[][] refineOption() throws IOException, IOException {
        return provider.getData(dataPath, "refineOption");
    }

    @org.testng.annotations.DataProvider(name = "quickView")
    public Object[][] quickView() throws IOException, IOException {
        return provider.getData(dataPath, "quickView");
    }

    @org.testng.annotations.DataProvider(name = "addToBag")
    public Object[][] addToBag() throws IOException, IOException {
        return provider.getData(dataPath, "addToBag");
    }
}
