package com.exuviance.dataprovider;

import com.exuviance.utility.DataProvider;

import java.io.IOException;

public class ShippingProviders {

    String dataPath = "src\\test\\resources\\TestData\\ShippingTestData.xlsx";

    DataProvider provider = new DataProvider();

    @org.testng.annotations.DataProvider(name = "shippingLinks")
    public Object[][] shippingLinks() throws IOException, IOException {
        return provider.getData(dataPath, "shippingLinks");
    }

    @org.testng.annotations.DataProvider(name = "sectionTitle")
    public Object[][] sectionTitle() throws IOException, IOException {
        return provider.getData(dataPath, "sectionTitle");
    }

    @org.testng.annotations.DataProvider(name = "shippingOrderDetails")
    public Object[][] shippingOrderDetails() throws IOException, IOException {
        return provider.getData(dataPath, "shippingOrderDetails");
    }

    @org.testng.annotations.DataProvider(name = "shippingDetailsValidation")
    public Object[][] shippingDetailsValidation() throws IOException, IOException {
        return provider.getData(dataPath, "shippingDetailsValidation");
    }

    @org.testng.annotations.DataProvider(name = "shippingDetails")
    public Object[][] shippingDetails() throws IOException, IOException {
        return provider.getData(dataPath, "shippingDetails");
    }

    @org.testng.annotations.DataProvider(name = "cardDetailsValidation")
    public Object[][] cardDetailsValidation() throws IOException, IOException {
        return provider.getData(dataPath, "cardDetailsValidation");
    }

    @org.testng.annotations.DataProvider(name = "cardDetails")
    public Object[][] cardDetails() throws IOException, IOException {
        return provider.getData(dataPath, "cardDetails");
    }
}
