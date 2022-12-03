package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(getDriver(),this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public String getUrl() {
        return getDriver().getCurrentUrl();
    }
    public String getTitle() {
        return getDriver().getTitle();
    }

    public int getListSize(List <WebElement> list) {

        return list.size();
    }

    protected List<String> getElementsText(List<WebElement> list) {
        List<String> textList = new ArrayList<>();

        if(list.size() > 0) {

            for (WebElement element : list) {
                textList.add(element.getText());
            }

            return textList;
        }

        return textList;
    }

    protected List<String> getElementsTextInLowerCase(List<WebElement> list) {
        List<String> textList = new ArrayList<>();

        if(list.size() > 0) {

            for (WebElement element : list) {
                textList.add(element.getText().toLowerCase());
            }
            return textList;
        }
        return textList;
    }

    protected List<String> getElementsTextInUpperCase(List<WebElement> list) {
        List<String> textList = new ArrayList<>();

        if(list.size() > 0) {

            for (WebElement element : list) {
                textList.add(element.getText().toUpperCase());
            }
            return textList;
        }
        return textList;
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void input(String text, WebElement element) {
        element.sendKeys(text);
    }

    protected void clear(WebElement element) {
        element.clear();
    }

    public void clickClearInput(WebElement element, String text) {
        click(element);

        if(!getElementText(element).isEmpty()){
            clear(element);
        }

        input(text,element);
    }
}
