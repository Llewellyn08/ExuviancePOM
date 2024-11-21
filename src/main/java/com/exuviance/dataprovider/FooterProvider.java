package com.exuviance.dataprovider;

import com.exuviance.utility.DataProvider;

import java.io.IOException;

public class FooterProvider {

    String dataPath = "src\\test\\resources\\TestData\\FooterTestData.xlsx";

    DataProvider provider = new DataProvider();

    @org.testng.annotations.DataProvider(name = "Links")
    public Object[][] Links() throws IOException, IOException {
        return provider.getData(dataPath, "Links");
    }

    @org.testng.annotations.DataProvider(name = "SocailMedia")
    public Object[][] SocailMedia() throws IOException, IOException {
        return provider.getData(dataPath, "SocailMedia");
    }

    @org.testng.annotations.DataProvider(name = "newLinks")
    public Object[][] newLinks() throws IOException, IOException {
        return provider.getData(dataPath, "newLinks");
    }

    @org.testng.annotations.DataProvider(name = "prodAvilability")
    public Object[][] prodAvilability() throws IOException, IOException {
        return provider.getData(dataPath, "prodAvilability");
    }

    @org.testng.annotations.DataProvider(name = "custCookie")
    public Object[][] custCookie() throws IOException, IOException {
        return provider.getData(dataPath, "custCookie");
    }

    @org.testng.annotations.DataProvider(name = "emailSignUpFooter")
    public Object[][] emailSignUpFooter() throws IOException, IOException {
        return provider.getData(dataPath, "emailSignUpFooter");
    }
}
