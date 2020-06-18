package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SecondResultPage{

    WebDriver driver;
    By listResultLocator = By.xpath("//div[@id='rso']//div[@class='g']");
    By nextButtonLocator = By.xpath("//td//span[contains(.,'Next')]");
    public SecondResultPage(WebDriver driver){
        this.driver=driver;
    }

    public void scrollDown_Second_Page() {
        WebDriverWait wait = new WebDriverWait(driver,1000);
        driver.findElements(listResultLocator);
        wait.until(ExpectedConditions.numberOfElementsToBe(listResultLocator,10));
        //System.out.println("Result Number of Page_2 is: " + resultList.size());
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollTo(0,700);");
    }

    public void click_On_Next_Button_SecondPage() {
        WebDriverWait wait = new WebDriverWait(driver,1000);
        wait.until(ExpectedConditions.elementToBeClickable(nextButtonLocator));
        driver.findElement(nextButtonLocator).click();
    }
    public int get_Result_Size_Second_Page(){
        return driver.findElements(listResultLocator).size();

    }


}
