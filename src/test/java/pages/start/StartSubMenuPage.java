package pages.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.MainPage;

public abstract class StartSubMenuPage extends MainPage {

    @FindBy(xpath = "//ul[@id='submenu']//a[@href='lyrics.html']")
    private WebElement songLyricsSubmenu;

    public StartSubMenuPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSongLyricsSubmenu() {

        return songLyricsSubmenu;
    }

    public LyricsPage clickSongLyricsSubmenu() {
        click(getSongLyricsSubmenu());

        return new LyricsPage(getDriver());
    }
}
