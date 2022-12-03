package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchLanguagesPage extends SearchLanguagesSubMenuPage{

    @FindBy(name = "search")
    private WebElement searchForField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement goButton;

    public SearchLanguagesPage(WebDriver driver) {
        super(driver);
    }

    public SearchLanguagesPage clickSearchForField(){
        click(searchForField);

        return this;
    }

    public SearchLanguagesPage inputSearchCriteria(String text) {
        input(text,searchForField);

        return this;
    }

    public SearchLanguagesPage clickGoButton(){
        click(goButton);

        return this;
    }


}
