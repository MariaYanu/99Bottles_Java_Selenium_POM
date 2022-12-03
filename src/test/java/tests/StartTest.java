package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StartTest extends BaseTest {

    @Test
    public void testH2HeaderStartPage() {
        final String expectedResult = "Welcome to 99 Bottles of Beer";

        String h2HeaderText =
                openBaseURL()
                        .clickStartLink()
                        .getH2HeaderText();

        Assert.assertEquals(h2HeaderText,expectedResult);

    }
}
