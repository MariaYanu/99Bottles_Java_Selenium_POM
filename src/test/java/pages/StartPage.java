package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends StartSubMenuPage{

    @FindBy(xpath = "//div[@id='main']/h2")
    private WebElement header;
    private final String HEADER_TEXT = "Welcome to 99 Bottles of Beer";

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText(){return HEADER_TEXT;}

    public String getTextOfHeader(){

        return getTextOfElement(header);
    }
}
