package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.start.StartPage;

public class StartTest extends BaseTest {

    @Test
    public void testH2HeaderStartPage() {
        final String expectedResult = "Welcome to 99 Bottles of Beer";

        String h2HeaderText =
                openBaseURL()
                        .clickStartHeader()
                        .getH2HeaderText();

        Assert.assertEquals(h2HeaderText,expectedResult);
    }

    @Test
    public void testBaseUrlLoadedSuccessfully() {

        StartPage startPage = openBaseURL();
        String actualUrl = startPage.getUrl();
        String actualTitle = startPage.getTitle();

        String h1LogoHeader = startPage.getH1LogoHeaderText();
        String h2LogoHeader = startPage.getH2LogoHeaderText();

        Assert.assertEquals(actualUrl, getBaseUrl());
        Assert.assertEquals(actualTitle, "99 Bottles of Beer | Start");
        Assert.assertEquals(h1LogoHeader, "99 Bottles of Beer");
        Assert.assertEquals(h2LogoHeader, "one program in 1500 variations");
    }
}
