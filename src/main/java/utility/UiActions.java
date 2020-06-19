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
    private List<WebElement> webElementList;

    /**
     * Find Element
     *
     * @param locator ex. by.xpath , by.id , by.name , etc...
     * @return Element
     */
    public UiActions findElementAndReturn(By locator) {
        element = driver.findElement(locator);
        return this;
    }

    /**
     * Send keys to a text field
     *
     * @param text String or keyword to search for
     * @return Element
     */
    public UiActions sendKeysToElement(String text) {
        element.sendKeys(text);
        return this;
    }

    /**
     * Handle type of waits either visible or clickable
     *
     * @param locator    element to wait for
     * @param typeOfWait type of the wait either "visible" or "clickable"
     */
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

    /**
     * Handle type of actions performed on an element
     *
     * @param action takes type of action either "click" or "submit"
     */
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

    /**
     * Get Size for list of elements have the same path
     *
     * @param locator path locator for list of elements
     * @return elements size
     */
    public int getSizeOfElements(By locator) {
        webElementList = driver.findElements(locator);
        return webElementList.size();
    }

    /**
     * Handle scroll Down action on the browser
     */
    public void scrollDownToBottom() {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollTo(0,700);");
    }
}