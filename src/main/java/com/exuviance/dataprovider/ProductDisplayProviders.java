package com.exuviance.dataprovider;

import com.exuviance.utility.DataProvider;

import java.io.IOException;

public class ProductDisplayProviders {

    String dataPath = "src\\test\\resources\\TestData\\ProductDisplayPageTestData.xlsx";

    DataProvider provider = new DataProvider();

    @org.testng.annotations.DataProvider(name = "allWebElements")
    public Object[][] allWebElements() throws IOException, IOException {
        return provider.getData(dataPath, "allWebElements");
    }

    @org.testng.annotations.DataProvider(name = "thumbnailI")
    public Object[][] thumbnailI() throws IOException, IOException {
        return provider.getData(dataPath, "thumbnailI");
    }

    @org.testng.annotations.DataProvider(name = "productDetails")
    public Object[][] productDetails() throws IOException, IOException {
        return provider.getData(dataPath, "productDetails");
    }

    @org.testng.annotations.DataProvider(name = "ymal")
    public Object[][] ymal() throws IOException, IOException {
        return provider.getData(dataPath, "ymal");
    }
}
