package pom;

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
    By nextButtonLocator = By.xpath("//td//span[contains(.,'Next')]");

    /**
     * Scroll Down to Bottom of the page
     */

    public void scrollDown_First_Page() {
        uiActions.scrollDownToBottom();
    }

    /**
     * Wait for the element locator to be clickable
     * Click On Next Button to navigate the next result page
     */
    public void click_On_Next_Button_First_Page() {
        uiActions.waitForElement(nextButtonLocator, "clickable");
        uiActions.findElementAndReturn(nextButtonLocator).takeActionOnElement("click");
    }
}
