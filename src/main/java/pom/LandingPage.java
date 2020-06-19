package pom;

import org.openqa.selenium.By;
import utility.UiActions;
/**
 * LandingPage Class represents the homepage that URL Navigate to
 * Contains Element locators for searchbar and String to search for
 */

/**
 * @author Diaa AlHaref
 */
public class LandingPage {

    UiActions uiActions = new UiActions();
    private By keywordLocator = By.name("q");
    // private String keyword = "Vodafone";

    /**
     * Method to Navigate directly to url
     */
    public void openUrl() {
        UiActions.driver.navigate().to("https://www.google.com/ncr");
    }

    /**
     * Method To Find Element locator and send keyword to search for it
     */
    public void typeKeywordToSearch(String keyword) {
        uiActions.findElementAndReturn(keywordLocator)
                .sendKeysToElement(keyword).takeActionOnElement("submit");
    }
}
