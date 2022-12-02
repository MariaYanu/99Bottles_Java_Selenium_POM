package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchLanguagesPage;
import pages.StartPage;

import java.util.List;

public class SearchLanguagesTest extends BaseTest {

    @Test
    public void testSearchForLanguageByName() {
        final String LANGUAGE_NAME = "python";

        List<String> languagesNames =
                openBaseURL()
                .clickSearchLanguagesLink()
                .clickSearchForField()
                .inputSearchCriteria(LANGUAGE_NAME)
                .clickGoButton()
                .getNamesInLowerCase();

        Assert.assertTrue(languagesNames.size() > 0);

        for(String languageName : languagesNames) {
            Assert.assertTrue(languageName.contains(LANGUAGE_NAME));
        }
    }
}
