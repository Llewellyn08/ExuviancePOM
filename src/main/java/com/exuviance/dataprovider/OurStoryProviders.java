package com.exuviance.dataprovider;

import com.exuviance.utility.DataProvider;

import java.io.IOException;

public class OurStoryProviders {

    String dataPath = "src\\test\\resources\\TestData\\OurStoryTestData.xlsx";

    DataProvider provider = new DataProvider();

    @org.testng.annotations.DataProvider(name = "BrightenAndRenew")
    public Object[][] BrightenAndRenew() throws IOException, IOException {
        return provider.getData(dataPath, "BrightenAndRenew");
    }

    @org.testng.annotations.DataProvider(name = "AcneProneAndRenew")
    public Object[][] AcneProneAndRenew() throws IOException, IOException {
        return provider.getData(dataPath, "AcneProneAndRenew");
    }

    @org.testng.annotations.DataProvider(name = "HydrateAndRenew")
    public Object[][] HydrateAndRenew() throws IOException, IOException {
        return provider.getData(dataPath, "HydrateAndRenew");
    }

    @org.testng.annotations.DataProvider(name = "ComprehensiveAntiaging")
    public Object[][] ComprehensiveAntiaging() throws IOException, IOException {
        return provider.getData(dataPath, "ComprehensiveAntiaging");
    }
}
