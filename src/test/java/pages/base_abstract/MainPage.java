package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.BrowseLanguagesPage;
import pages.search_languages.SearchLanguagesPage;
import pages.start.StartPage;

import java.util.List;

public abstract class MainPage extends BasePage {

    @FindBy(xpath = "//div[@id='header']/h1")
    private WebElement h1LogoHeader;

    @FindBy(xpath = "//div[@id='header']/h2")
    private WebElement h2LogoHeader;
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

    @FindBy(id = "main")
    private WebElement mainBody;

    @FindBy(tagName = "img")
    private List<WebElement> images;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getH1LogoHeaderText() {

        return getText(h1LogoHeader);
    }

    public String getH2LogoHeaderText() {

        return getText(h2LogoHeader);
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
       return getListTextInLowerCase(headerLinks);
    }

    public int getHeaderLinksSize() {
       return getListSize(headerLinks);
    }

    public String getPageContext() {

       return getText(mainBody);
    }

    public List<WebElement> getImages() {

        return images;
    }

    public List<WebElement> getHeaderLinks() {

        return headerLinks;
    }
    public void clickTopMenu(int index) {
        getHeaderLinks().get(index).click();
    }
}

