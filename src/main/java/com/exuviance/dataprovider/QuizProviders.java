package com.exuviance.dataprovider;

import com.exuviance.utility.DataProvider;

import java.io.IOException;

public class QuizProviders {

    String dataPath = "src\\test\\resources\\TestData\\QuizTestData.xlsx";

    DataProvider provider = new DataProvider();

    @org.testng.annotations.DataProvider(name = "url")
    public Object[][] url() throws IOException, IOException {
        return provider.getData(dataPath, "url");
    }

    @org.testng.annotations.DataProvider(name = "banner")
    public Object[][] banner() throws IOException, IOException {
        return provider.getData(dataPath, "banner");
    }

    @org.testng.annotations.DataProvider(name = "privacyPolicy")
    public Object[][] privacyPolicy() throws IOException, IOException {
        return provider.getData(dataPath, "privacyPolicy");
    }

    @org.testng.annotations.DataProvider(name = "email")
    public Object[][] email() throws IOException, IOException {
        return provider.getData(dataPath, "email");
    }

    @org.testng.annotations.DataProvider(name = "quiz")
    public Object[][] quiz() throws IOException, IOException {
        return provider.getData(dataPath, "quiz");
    }
}
