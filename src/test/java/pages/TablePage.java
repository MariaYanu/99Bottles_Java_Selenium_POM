package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class TablePage extends MainPage {

    private final By NAMES_LIST = By.xpath("//table[@id='category']/tbody/tr/td[1]/a");

    public TablePage(WebDriver driver) {
        super(driver);
    }

    protected By getNamesList() {

        return NAMES_LIST;
    }

    public List<String> getNamesInLowerCase(){

       return getElementsTextInLowerCase(getNamesList());
    }



}