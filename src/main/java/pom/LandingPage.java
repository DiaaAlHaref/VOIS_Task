package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    WebDriver driver;

    private By keywordLocator = By.name("q");
    private String keyword = "Vodafone";

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl() {

        driver.navigate().to("https://www.google.com/ncr");
    }

    public void typeKeywordToSearch() {
        driver.findElement(keywordLocator).sendKeys(keyword, Keys.ENTER);


    }
}
