package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public abstract class TablePage extends MainPage {

    @FindBy(xpath = "//table[@id='category']/tbody/tr/td[1]/a")
    private List<WebElement> namesList;

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getNamesInLowerCase(){

       return getElementsTextInLowerCase(namesList);
    }

    public List<String> getNamesFirstSymbolInLowerCase() {
        List<String> startValue = getNamesInLowerCase();
        List<String> onlyFirstSymbols = new ArrayList<>();

        for (int i = 0; i < startValue.size(); i++){
            onlyFirstSymbols.add(String.valueOf(String.valueOf(startValue.get(i)).charAt(0)));
        }

        return onlyFirstSymbols;
    }




}
