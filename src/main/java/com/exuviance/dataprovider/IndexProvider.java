package com.exuviance.dataprovider;

import com.exuviance.utility.DataProvider;

import java.io.IOException;

public class IndexProvider {

    String dataPath = "src\\test\\resources\\TestData\\IndexTestData.xlsx";

    DataProvider provider = new DataProvider();

    @org.testng.annotations.DataProvider(name = "logo")
    public Object[][] logo() throws IOException, IOException {
        return provider.getData(dataPath, "logo");
    }

    @org.testng.annotations.DataProvider(name = "title")
    public Object[][] title() throws IOException, IOException {
        return provider.getData(dataPath, "title");
    }
}
