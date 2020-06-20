package pages;

import fileReaders.PropertiesFile;
import org.openqa.selenium.By;
import utilities.UiActions;
/**
 * FirstResultPage Class represents the first search result page
 */

/**
 * @author Diaa AlHaref
 */

public class FirstResultPage {
    UiActions uiActions = new UiActions();

    private String[] view = PropertiesFile.propertiesFileReader(new String[]{"nextButtonLocator"});
    private final By nextButtonLocator = By.xpath(view[0]);

    /**
     * Scroll Down to Bottom of the page
     */

    public void scrollDownFirst_Page() {
        uiActions.scrollDownToBottom();
    }

    /**
     * Wait for the element locator to be clickable
     * <p>Click On Next Button to navigate the next result page</p>
     */
    public void clickOnNextButtonFirst_Page() {
        uiActions.waitForElement(nextButtonLocator, "clickable")
                .findElementAndReturn(nextButtonLocator).takeActionOnElement("click");
    }
}
