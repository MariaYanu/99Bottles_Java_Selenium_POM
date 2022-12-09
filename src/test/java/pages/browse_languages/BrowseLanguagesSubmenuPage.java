package pages.browse_languages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.TablePage;
import pages.browse_languages.letters.JPage;
import pages.browse_languages.letters.ZeroPage;

public abstract class BrowseLanguagesSubmenuPage extends TablePage {

    @FindBy (xpath = "//ul[@id='submenu']//a[@href='j.html']")
    private WebElement jSubmenu;

    @FindBy (xpath = "//ul[@id='submenu']//a[@href='0.html']")
    private WebElement zeroSubmenu;

    public BrowseLanguagesSubmenuPage(WebDriver driver) {
        super(driver);
    }

    public JPage clickJSubmenu() {
        click(jSubmenu);

        return new JPage(getDriver());
    }

    public ZeroPage clickZeroSubmenu() {
        click(zeroSubmenu);

        return new ZeroPage(getDriver());
    }
}
