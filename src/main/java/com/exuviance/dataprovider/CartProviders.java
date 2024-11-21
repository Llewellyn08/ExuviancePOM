package com.exuviance.dataprovider;

import com.exuviance.utility.DataProvider;

import java.io.IOException;

public class CartProviders {

    String dataPath = "src\\test\\resources\\TestData\\CartTestData.xlsx";

    DataProvider provider = new DataProvider();

    @org.testng.annotations.DataProvider(name = "miniCartEleCheck")
    public Object[][] miniCartEleCheck() throws IOException, IOException {
        return provider.getData(dataPath, "miniCartEleCheck");
    }

    @org.testng.annotations.DataProvider(name = "cartEleCheck")
    public Object[][] cartEleCheck() throws IOException, IOException {
        return provider.getData(dataPath, "cartEleCheck");
    }

    @org.testng.annotations.DataProvider(name = "editProduct")
    public Object[][] editProduct() throws IOException, IOException {
        return provider.getData(dataPath, "editProduct");
    }

    @org.testng.annotations.DataProvider(name = "removeProduct")
    public Object[][] removeProduct() throws IOException, IOException {
        return provider.getData(dataPath, "removeProduct");
    }

    @org.testng.annotations.DataProvider(name = "orderDetails")
    public Object[][] orderDetails() throws IOException, IOException {
        return provider.getData(dataPath, "orderDetails");
    }

    @org.testng.annotations.DataProvider(name = "couponCode")
    public Object[][] couponCode() throws IOException, IOException {
        return provider.getData(dataPath, "couponCode");
    }

    @org.testng.annotations.DataProvider(name = "bonusProduct")
    public Object[][] bonusProduct() throws IOException, IOException {
        return provider.getData(dataPath, "bonusProduct");
    }

    @org.testng.annotations.DataProvider(name = "checkout")
    public Object[][] checkout() throws IOException, IOException {
        return provider.getData(dataPath, "checkout");
    }

    @org.testng.annotations.DataProvider(name = "paypal")
    public Object[][] paypal() throws IOException, IOException {
        return provider.getData(dataPath, "paypal");
    }

    @org.testng.annotations.DataProvider(name = "klarna")
    public Object[][] klarna() throws IOException, IOException {
        return provider.getData(dataPath, "klarna");
    }

    @org.testng.annotations.DataProvider(name = "recommendation")
    public Object[][] recommendation() throws IOException, IOException {
        return provider.getData(dataPath, "recommendation");
    }
}
