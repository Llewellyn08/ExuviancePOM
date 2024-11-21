package com.exuviance.dataprovider;

import com.exuviance.utility.DataProvider;

import java.io.IOException;

public class ForgotPasswordProviders {

    String dataPath = "src\\test\\resources\\TestData\\ForgotPasswordTestData.xlsx";

    DataProvider provider = new DataProvider();

    @org.testng.annotations.DataProvider(name = "popUpCheck")
    public Object[][] popUpCheck() throws IOException, IOException {
        return provider.getData(dataPath, "popUpCheck");
    }

    @org.testng.annotations.DataProvider(name = "closeBtn")
    public Object[][] closeBtn() throws IOException, IOException {
        return provider.getData(dataPath, "closeBtn");
    }

    @org.testng.annotations.DataProvider(name = "forgotPassword")
    public Object[][] forgotPassword() throws IOException, IOException {
        return provider.getData(dataPath, "forgotPassword");
    }
}
