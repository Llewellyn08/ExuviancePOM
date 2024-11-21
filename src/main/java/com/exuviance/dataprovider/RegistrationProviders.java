package com.exuviance.dataprovider;

import com.exuviance.utility.DataProvider;

import java.io.IOException;

public class RegistrationProviders {

    String dataPath = "src\\test\\resources\\TestData\\RegistrationTestData.xlsx";

    DataProvider provider = new DataProvider();

    @org.testng.annotations.DataProvider(name = "registration")
    public Object[][] registration() throws IOException, IOException {
        return provider.getData(dataPath, "registration");
    }

    @org.testng.annotations.DataProvider(name = "privacyPolicyLink")
    public Object[][] privacyPolicyLink() throws IOException, IOException {
        return provider.getData(dataPath, "privacyPolicyLink");
    }

    @org.testng.annotations.DataProvider(name = "financialIncentLink")
    public Object[][] financialIncentLink() throws IOException, IOException {
        return provider.getData(dataPath, "financialIncentLink");
    }
}
