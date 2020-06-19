package pom;

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

    By listResultLocator = By.xpath("//div[@id='rso']//div[@class='g']");
    By nextButtonLocator = By.xpath("//td//span[contains(.,'Next')]");

    /**
     * Scroll Down to Bottom of the page
     */
    public void scrollDown_Second_Page() {
        uiActions.scrollDownToBottom();
    }

    /**
     * Wait for the element locator to be clickable
     * Click On Next Button to navigate the next result page
     */
    public void click_On_Next_Button_SecondPage() {
        uiActions.waitForElement(nextButtonLocator, "clickable");
        uiActions.findElementAndReturn(nextButtonLocator).takeActionOnElement("click");
    }

    /**
     * Get Number of Results in the page
     *
     * @return number of elements
     */
    public int countNumberOfResultsInSecond_Page() {
        return uiActions.getSizeOfElements(listResultLocator);
    }

}
