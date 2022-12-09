package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.start.StartPage;

import java.util.List;

public class MainTest extends BaseTest {

    @Test
    public void testNavigationMenuLinksAmountAndText() {
        final int expectedAmount = 6;
        final String[] expectedText = {"Start", "Browse Languages", "Search Languages", "Top Lists", "Guestbook", "Submit new Language"};

        openBaseURL();
        StartPage startPage = new StartPage(getDriver());

        int actualAmount = startPage.getHeaderLinksSize();
        List<String> actualText = startPage.getHeaderLinksTextInLowerCase();

        Assert.assertEquals(actualAmount, expectedAmount);
        for(int i = 0; i < actualText.size(); i++) {
            Assert.assertEquals(actualText.get(i), expectedText[i].toLowerCase());
        }
    }
}
