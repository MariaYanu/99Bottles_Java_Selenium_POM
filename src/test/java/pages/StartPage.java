package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends StartSubMenuPage{

    @FindBy(xpath = "//div[@id='main']/h2")
    private WebElement h2Header;
    private final String H2_HEADER_TEXT = "Welcome to 99 Bottles of Beer";

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public String getH2_HEADER_TEXT(){return H2_HEADER_TEXT;}

    public String getH2HeaderText(){

        return getElementText(h2Header);
    }
}
