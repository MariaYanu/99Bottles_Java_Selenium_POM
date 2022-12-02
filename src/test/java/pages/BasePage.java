package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebElement getElement(By by) {

        return getDriver().findElement(by);
    }

    public String getTextOfElement(By by) {
        return getElement(by).getText();
    }

    private List<WebElement> getElements(By by) {

        return getDriver().findElements(by);
    }

    public int getListSize(By by) {

        return getElements(by).size();
    }

    protected List<String> getElementsText(By by) {
        if(getListSize(by) > 0) {
            List<String> textList = new ArrayList<>();

            for (WebElement element : getElements(by)) {
                textList.add(element.getText());
            }

            return textList;
        }

        return null;
    }

    protected List<String> getElementsTextInLowerCase(By by) {
        if(getListSize(by) > 0) {
            List<String> textList = new ArrayList<>();

            for (WebElement element : getElements(by)) {
                textList.add(element.getText().toLowerCase());
            }
            return textList;
        }
        return null;
    }

    protected void click(By by) {
        getElement(by).click();
    }

    protected void input(String text, By by) {
        getElement(by).sendKeys(text);
    }
}
