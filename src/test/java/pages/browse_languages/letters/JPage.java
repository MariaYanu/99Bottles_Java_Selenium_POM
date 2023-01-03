package pages.browse_languages.letters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.browse_languages.languages.JQueryLanguagePage;

public class JPage extends LetterPage {

    @FindBy (xpath = "//a[@href='language-jquery-1361.html']")
    private WebElement jQueryLink;

    public JPage(WebDriver driver) {
        super(driver);
    }

    public JQueryLanguagePage clickJQueryLink() {
        click(jQueryLink);

        return new JQueryLanguagePage(getDriver());
    }
}
