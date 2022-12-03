package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class MainPage extends BasePage {
    @FindBy (xpath = "//div[@id='navigation']//a[@href='/search.html']")
    private WebElement searchLanguagesLink;

    @FindBy (xpath = "//div[@id='navigation']//a[text()='Start']")
    private WebElement startLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SearchLanguagesPage clickSearchLanguagesLink() {
        click(searchLanguagesLink);

        return new SearchLanguagesPage(getDriver());
    }

    public StartPage clickStartLink() {
        click(startLink);

    return new StartPage(getDriver());
    }
}

