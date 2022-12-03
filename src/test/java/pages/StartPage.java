package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends StartSubMenuPage{

    @FindBy(xpath = "//div[@id='main']/h2")
    private WebElement h2Header;

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public String getH2HeaderText(){

        return getElementText(h2Header);
    }
}
