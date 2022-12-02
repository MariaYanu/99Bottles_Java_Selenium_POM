package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage extends StartSubMenuPage{
    private final By HEADER = By.xpath("//div[@id='main']//h2");
    private final String HEADER_TEXT = "Welcome to 99 Bottles of Beer";
    public StartPage(WebDriver driver) {
        super(driver);
    }

    public By getHeader() {
        return HEADER;
    }

    public String getHeaderText(){return HEADER_TEXT;}

    public String getTextOfHeader(){

        return getTextOfElement(getHeader());
    }
}
