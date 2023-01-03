package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.letters.JPage;
import pages.browse_languages.languages.JQueryLanguagePage;

public class JTest extends BaseTest {

    @Test
    public void testJQueryLink_NavigatesTo_JQueryLanguagePage() {

        final String expectedUrl = "https://www.99-bottles-of-beer.net/language-jquery-1361.html";
        final String expectedTitle = "99 Bottles of Beer | Language jQuery";

        JQueryLanguagePage jQueryLanguagePage = new JQueryLanguagePage(getDriver());

        String oldUrl = openBaseURL()
                .clickBrowseLanguagesFooter()
                .clickJSubmenu()
                .getUrl();

        new JPage(getDriver()).clickJQueryLink();

        Assert.assertNotEquals(oldUrl, getDriver().getCurrentUrl());

        String actualUrl = jQueryLanguagePage.getUrl();
        String actualTitle = jQueryLanguagePage.getTitle();

        Assert.assertEquals(actualUrl,expectedUrl);
        Assert.assertEquals(actualTitle,expectedTitle);

//        JPage jPage = new JPage(getDriver());
//        JQueryLanguagePage jQueryLanguagePage = new JQueryLanguagePage(getDriver());
//
//        String oldURL = openBaseURL()
//                .clickBrowseLanguagesFooterMenu()
//                .clickJSubmenu()
//                .getURL();
//
//        String actualURL = jPage.clickJQueryLanguage().getURL();
//        String actualTitle = jQueryLanguagePage.getTitle();
//
//        Assert.assertNotEquals(oldURL, actualURL);
//        Assert.assertEquals(actualURL, expectedURL);
//        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
