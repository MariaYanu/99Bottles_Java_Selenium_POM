package pages.base_abstract;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

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

    public String getAttribute(WebElement element, String attribute) {

        return element.getAttribute(attribute);
    }

    public int getListSize(List <WebElement> list) {

        return list.size();
    }

    public List<String> getElementsText(List<WebElement> list) {
        List<String> textList = new ArrayList<>();

        if(list.size() > 0) {

            for (WebElement element : list) {
                textList.add(element.getText());
            }

            return textList;
        }

        return textList;
    }

    public List<String> getElementsTextInLowerCase(List<WebElement> list) {
        List<String> textList = new ArrayList<>();

        if(list.size() > 0) {

            for (WebElement element : list) {
                textList.add(element.getText().toLowerCase());
            }
            return textList;
        }
        return textList;
    }

    public List<String> getElementsTextInUpperCase(List<WebElement> list) {
        List<String> textList = new ArrayList<>();

        if(list.size() > 0) {

            for (WebElement element : list) {
                textList.add(element.getText().toUpperCase());
            }
            return textList;
        }
        return textList;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void input(String text, WebElement element) {
        element.sendKeys(text);
    }

    public void clear(WebElement element) {
        element.clear();
    }

    public void clickClearInput(WebElement element, String text) {
        click(element);

        if(!getElementText(element).isEmpty()){
            clear(element);
        }

        input(text,element);
    }

    public boolean isImageDisplayed(WebElement image) {
        try {
            boolean imageDisplayed = (Boolean) ((JavascriptExecutor) getDriver())
                    .executeScript(
                            "return (typeof arguments[0].naturalWidth !=\"undefined\" " +
                                    "&& arguments[0].naturalWidth > 0);", image
                    );
            if (imageDisplayed) {

                return true;
            } else {
                Reporter.log(image + "image is broken ", true);
            }
        } catch (Exception e) {
            System.out.println("Image not loading");
        }

        return false;
    }
}
