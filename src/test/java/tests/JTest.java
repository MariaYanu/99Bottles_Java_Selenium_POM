package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.JQueryLanguagePage;

public class JTest extends BaseTest {

    @Test
    public void testJQueryLink_NavigatesTo_JQueryLanguagePage() {

        final String expectedUrl = "https://www.99-bottles-of-beer.net/language-jquery-1361.html";
        final String expectedTitle = "99 Bottles of Beer | Language jQuery";

        JQueryLanguagePage jQueryLanguagePage = new JQueryLanguagePage(getDriver());

        openBaseURL();
    }
}
