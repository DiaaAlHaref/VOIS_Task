package pages;

import fileReaders.PropertiesFile;
import org.openqa.selenium.By;
import utilities.UiActions;
/**
 * SecondResultPage Class represents the Second search result page
 */

/**
 * @author Diaa AlHaref
 */

public class SecondResultPage {
    UiActions uiActions = new UiActions();

    private String[] view = PropertiesFile.propertiesFileReader(new String[]{"listResultLocator", "nextButtonLocator"});
    private final By listResultLocator = By.xpath(view[0]);
    private final By nextButtonLocator = By.xpath(view[1]);

    /**
     * Scroll Down to Bottom of the page
     */
    public void scrollDownSecond_Page() {
        uiActions.scrollDownToBottom();
    }

    /**
     * Wait for the element locator to be clickable
     * <p>Click On Next Button to navigate the next result page</p>
     */
    public void clickOnNextButtonSecondPage() {
        uiActions.waitForElement(nextButtonLocator, "clickable")
                .findElementAndReturn(nextButtonLocator).takeActionOnElement("click");
    }

    /**
     * Get Number of Results in the page
     *
     * @return number of elements
     */
    public int countNumberOfResultsInSecond_Page() {
        return uiActions.findListOfElements(listResultLocator).getSizeOfElements();
    }

}
