package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.browse_languages.letters.ZeroPage;

import java.util.List;

public class ZeroTest extends BaseTest {

    @Test
    public void allTableLanguagesNamesHavePositiveNumberFirstSymbol() {

        openBaseURL()
                .clickBrowseLanguagesHeader()
                .clickZeroSubmenu();

        ZeroPage zeroPage = new ZeroPage(getDriver());
        List<String> namesFirstSymbol = zeroPage.getNamesFirstSymbolInLowerCase();

        Assert.assertTrue(namesFirstSymbol.size() > 0);

        for(int i = 0; i < namesFirstSymbol.size(); i++) {
            Assert.assertTrue(Integer.parseInt(namesFirstSymbol.get(i)) >= 0 || Integer.parseInt(namesFirstSymbol.get(i)) <= 9);
        }
    }
}
