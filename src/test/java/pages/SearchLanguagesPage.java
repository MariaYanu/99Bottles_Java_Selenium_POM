package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchLanguagesPage extends SearchLanguagesSubMenuPage{

   private final By SEARCH_FOR_FIELD = By.name("search");
   private final By GO_BUTTON = By.xpath("//input[@type='submit']");

    public SearchLanguagesPage(WebDriver driver) {
        super(driver);
    }

    protected By getSearchForField(){

        return SEARCH_FOR_FIELD;
    }

    protected By getGoButton() {

        return GO_BUTTON;
    }

    public SearchLanguagesPage clickSearchForField(){
        click(getSearchForField());

        return this;
    }

    public SearchLanguagesPage inputSearchCriteria(String text) {
        input(text,getSearchForField());

        return this;
    }

    public SearchLanguagesPage clickGoButton(){
        click(getGoButton());

        return this;
    }


}
