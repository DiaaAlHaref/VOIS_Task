package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LastPage {

    WebDriver driver;
    By listResultLocator = By.xpath("//div[@id='rso']//div[@class='g']");
    public LastPage(WebDriver driver){
        this.driver=driver;
    }

    public int get_Result_Size_Last_Page(){
        return driver.findElements(listResultLocator).size();
    }
}
