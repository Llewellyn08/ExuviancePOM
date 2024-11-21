package com.exuviance.dataprovider;

import com.exuviance.utility.DataProvider;

import java.io.IOException;

public class HomeProviders {


    String dataPath = "src\\test\\resources\\TestData\\HomeTestData.xlsx";

    DataProvider provider = new DataProvider();

    @org.testng.annotations.DataProvider(name = "headerOne")
    public Object[][] headerOne() throws IOException, IOException {
        return provider.getData(dataPath, "headerOne");
    }

    @org.testng.annotations.DataProvider(name = "headerTwo")
    public Object[][] headerTwo() throws IOException, IOException {
        return provider.getData(dataPath, "headerTwo");
    }

    @org.testng.annotations.DataProvider(name = "headerThree")
    public Object[][] headerThree() throws IOException, IOException {
        return provider.getData(dataPath, "headerThree");
    }

    @org.testng.annotations.DataProvider(name = "bestSellingCount")
    public Object[][] bestSellingCount() throws IOException, IOException {
        return provider.getData(dataPath, "bestSellingCount");
    }

    @org.testng.annotations.DataProvider(name = "specialOfferCount")
    public Object[][] specialOfferCount() throws IOException, IOException {
        return provider.getData(dataPath, "specialOfferCount");
    }

    @org.testng.annotations.DataProvider(name = "visibleResultCount")
    public Object[][] visibleResultCount() throws IOException, IOException {
        return provider.getData(dataPath, "visibleResultCount");
    }
}
