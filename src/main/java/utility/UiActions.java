package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UiActions {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private WebElement element;
    private List <WebElement> webElementList;

    public void waitForElement(By locator, String typeOfWait) {
        wait = new WebDriverWait(driver, 1000);
        switch (typeOfWait) {
            case "visible":
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
            case "clickable":
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                break;
        }
    }

    public UiActions findElementAndReturn(By locator) {
        element = driver.findElement(locator);
        return this;
    }

    public UiActions sendKeysToElement(String text) {
        element.sendKeys(text);
        return this;
    }

    public void takeActionOnElement(String action) {
        switch (action) {
            case "click":
                element.click();
                break;
            case "submit":
                element.submit();
                break;
        }


    }
    public int getSizeOfElements(By locator){
        webElementList = driver.findElements(locator);
        return webElementList.size();
    }

    public void scrollDownToBottom(){
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollTo(0,700);");
    }
}