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

    public String getTextOfElement(WebElement element) {
        return element.getText();
    }

    public int getListSize(List <WebElement> list) {

        return list.size();
    }

    protected List<String> getElementsText(List<WebElement> list) {
        if(list.size() > 0) {
            List<String> textList = new ArrayList<>();

            for (WebElement element : list) {
                textList.add(element.getText());
            }

            return textList;
        }

        return null;
    }

    protected List<String> getElementsTextInLowerCase(List<WebElement> list) {
        if(list.size() > 0) {
            List<String> textList = new ArrayList<>();

            for (WebElement element : list) {
                textList.add(element.getText().toLowerCase());
            }
            return textList;
        }
        return null;
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void input(String text, WebElement element) {
        element.sendKeys(text);
    }
}
