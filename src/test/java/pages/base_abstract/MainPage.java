package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.BrowseLanguagesPage;
import pages.search_languages.SearchLanguagesPage;
import pages.start.StartPage;

import java.util.List;

public abstract class MainPage extends BasePage {
    @FindBy (xpath = "//div[@id='navigation']//a[@href='/search.html']")
    private WebElement searchLanguagesHeader;

    @FindBy (xpath = "//div[@id='navigation']//a[text()='Start']")
    private WebElement startHeader;

    @FindBy (xpath = "//ul[@id='menu']//a[@href='/abc.html']")
    private WebElement browseLanguagesHeader;

    @FindBy (xpath = "//div[@id='footer']//a[@href='/abc.html']")
    private WebElement browseLanguagesFooter;

    @FindBy (xpath = "//ul[@id='menu']//li")
    private List<WebElement> headerLinks;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SearchLanguagesPage clickSearchLanguagesHeader() {
        click(searchLanguagesHeader);

        return new SearchLanguagesPage(getDriver());
    }

    public StartPage clickStartHeader() {
        click(startHeader);

    return new StartPage(getDriver());
    }

    public BrowseLanguagesPage clickBrowseLanguagesHeader() {
        click(browseLanguagesHeader);

        return new BrowseLanguagesPage(getDriver());
    }

    public BrowseLanguagesPage clickBrowseLanguagesFooter() {
        click(browseLanguagesFooter);

        return new BrowseLanguagesPage(getDriver());
    }

    public List<String> getHeaderLinksTextInLowerCase() {
       return getElementsTextInLowerCase(headerLinks);
    }

    public int getHeaderLinksSize() {
       return getListSize(headerLinks);
    }
}

