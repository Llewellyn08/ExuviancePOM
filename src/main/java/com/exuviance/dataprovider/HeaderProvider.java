package com.exuviance.dataprovider;

import com.exuviance.utility.DataProvider;

import java.io.IOException;

public class HeaderProvider {

    String dataPath = "src\\test\\resources\\TestData\\HeaderTestData.xlsx";

    DataProvider provider = new DataProvider();

    @org.testng.annotations.DataProvider(name = "logoCheck")
    public Object[][] logoCheck() throws IOException, IOException {
        return provider.getData(dataPath, "logoCheck");
    }

    @org.testng.annotations.DataProvider(name = "offerLink")
    public Object[][] offerLink() throws IOException, IOException {
        return provider.getData(dataPath, "offerLink");
    }

    @org.testng.annotations.DataProvider(name = "emailSign")
    public Object[][] emailSign() throws IOException, IOException {
        return provider.getData(dataPath, "emailSign");
    }

    @org.testng.annotations.DataProvider(name = "shoppingBag")
    public Object[][] shoppingBag() throws IOException, IOException {
        return provider.getData(dataPath, "shoppingBag");
    }

    @org.testng.annotations.DataProvider(name = "BestSeller")
    public Object[][] BestSeller() throws IOException, IOException {
        return provider.getData(dataPath, "BestSeller");
    }

    @org.testng.annotations.DataProvider(name = "BestSellerShopAll")
    public Object[][] BestSellerShopAll() throws IOException, IOException {
        return provider.getData(dataPath, "BestSellerShopAll");
    }

    @org.testng.annotations.DataProvider(name = "SkinCare")
    public Object[][] SkinCare() throws IOException, IOException {
        return provider.getData(dataPath, "SkinCare");
    }

    @org.testng.annotations.DataProvider(name = "Discover")
    public Object[][] Discover() throws IOException, IOException {
        return provider.getData(dataPath, "Discover");
    }

    @org.testng.annotations.DataProvider(name = "Search")
    public Object[][] Search() throws IOException, IOException {
        return provider.getData(dataPath, "Search");
    }
}
