package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FirstResultPage {
    WebDriver driver;
    By nextButtonLocator = By.xpath("//td//span[contains(.,'Next')]");


    public FirstResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollDown_First_Page() {

        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollTo(0,100);");

    }

    public void click_On_Next_Button_First_Page() {
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator));
        driver.findElement(nextButtonLocator).click();
    }
}
