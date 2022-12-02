package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class MainPage extends BasePage {

    private final By START_LINK = By.xpath("//div[@id='navigation']//a[text()='Start']");
    private final By SEARCH_LANGUAGES_LINK = By.xpath("//div[@id='navigation']//a[@href='/search.html']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    protected By getSearchLanguagesLink() {

        return SEARCH_LANGUAGES_LINK;
    }

    protected By getStartLink() {
        return START_LINK;
    }

    public SearchLanguagesPage clickSearchLanguagesLink() {

        click(getSearchLanguagesLink());

        return new SearchLanguagesPage(getDriver());
    }

    public StartPage clickStartLink() {
        click(getStartLink());

    return new StartPage(getDriver());
    }
}

