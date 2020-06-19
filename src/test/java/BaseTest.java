/**
 * This is a task to search for a keyword then count the search result elements in the Second result page,
 * Third result page and then assert on the number of elements occured in both pages
 * /
 * <p>
 * /**
 * This Framework for VOIS CoE Team, performed on a task using Intellij IDE
 * Selenium WebDriver, TestNG, Allure Report Framework, Data Driver Framework
 */


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;
import pom.FirstResultPage;
import pom.LandingPage;
import pom.LastPage;
import pom.SecondResultPage;
import utilities.Logging;
import utilities.UiActions;

/**
 * BaseClass Demonstrates WebDrivers loading and other classes inherit from
 *
 * @author Diaa AlHaref
 */

public class BaseTest {

    Logging Log = new Logging();

    LandingPage landingPage;
    FirstResultPage firstResultPage;
    SecondResultPage secondResultPage;
    LastPage lastPage;

    /**
     * loads the drivers Chrome, FireFox, InternetExplorer
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
                UiActions.driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                UiActions.driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "src//main//resources//IEDriverServer.exe");
                UiActions.driver = new InternetExplorerDriver();
                break;
        }

        UiActions.driver.manage().window().maximize();
        landingPage = new LandingPage();
        firstResultPage = new FirstResultPage();
        secondResultPage = new SecondResultPage();
        lastPage = new LastPage();

    }

    /**
     * Exit the running browser
     */
    @AfterClass
    public void tearDownBrowser() {
        UiActions.driver.quit();
    }
}
