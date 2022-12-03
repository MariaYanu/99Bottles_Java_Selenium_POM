package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StartPage;

public class StartTest extends BaseTest {

    @Test
    public void testHeaderOnTheStartPage() {
        StartPage startPage = new StartPage(getDriver());

       String headerText =
               openBaseURL()
               .clickStartLink()
                .getH2HeaderText();

        Assert.assertEquals(headerText, startPage.getH2HeaderText() );

    }
}
