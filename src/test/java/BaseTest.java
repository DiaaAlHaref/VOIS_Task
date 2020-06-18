/**
 * This is a Framework for VOIS CoE Team, performed on a task using Intellij IDE
 * Selenium WebDriver, TestNG, Allure Report Framework, Data Driver Framework
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pom.FirstResultPage;
import pom.LandingPage;
import pom.LastPage;
import pom.SecondResultPage;

/**
 * BaseClass Demonstrates WebDrivers loading and other classes inherit from
 *
 * @author Diaa AlHaref
 */

public class BaseTest {
    static WebDriver driver;
    LandingPage landingPage;
    FirstResultPage firstResultPage;
    SecondResultPage secondResultPage;
    LastPage lastPage;

    /**
     * loads the drivers Chrome, FireFox, InternetExplorer when passing
     *
     * @param browser takes name of the browsers as string "chrome" , "firefox" , "ie"
     */
    @BeforeClass
    @Parameters({"browser"}) //To Run Test From testng.xml file
    public void startupDrivers(@Optional("ie") String browser) {
        //@optional used to run test by default value passed to it ex. ("chrome")
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver","src//main//resources//IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
        }

        driver.manage().window().maximize();
        landingPage = new LandingPage(driver);
        firstResultPage = new FirstResultPage(driver);
        secondResultPage = new SecondResultPage(driver);
        lastPage = new LastPage(driver);

    }


    @AfterClass
    public void tearDownBrowser() {
        /*if (driver != null) {
            driver.quit();
        }*/
    }
}
