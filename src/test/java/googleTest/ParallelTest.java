package googleTest;

import fileReaders.PropertiesFile;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.HandleExceptions;
import utilities.Logs;
import utilities.UiActions;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * ParallelTest Class Demonstrates Test execution on selenium Grid hub with number of different drivers nodes
 *
 * @author Diaa AlHaref
 */
public class ParallelTest {

    Logs Log = new Logs();
    private ThreadLocal<RemoteWebDriver> remotedriver;
    String[] view = PropertiesFile.propertiesFileReader(new String[]{"baseUrl"});
    protected String url = view[0] + "ncr";

    /**
     * performs parallel browser execution with nodes Chrome, FireFox on selenium Grid hub
     *
     * @param browser types of browsers chrome, firefox extended from parallelTest.xml
     * @throws MalformedURLException
     */
    @BeforeClass
    @Parameters(value = {"browserParallel"})
    public void setup(String browser) throws MalformedURLException {

        remotedriver = new ThreadLocal<>();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browserName", browser);
        remotedriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap));


        UiActions.driver = remotedriver.get();

        UiActions.driver.navigate().to(url);
        Log.info("Navigate to url");
        UiActions.driver.manage().window().maximize();
        Log.info("Browser window size maximized");

    }

    /**
     * Close the running node after execution
     */
    @AfterClass
    public void teardown() {
        try {
            remotedriver.get().close();
        } catch (NoSuchSessionException e) {
            HandleExceptions.NoSuchSessionExceptionHandling(e);
        }

    }

}
