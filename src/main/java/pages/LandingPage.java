package pages;

import fileReaders.PropertiesFile;
import org.openqa.selenium.By;
import utilities.UiActions;
/**
 * LandingPage Class represents the homepage that URL Navigate to
 * Contains Element locators for searchbar and String to search for
 */

/**
 * @author Diaa AlHaref
 */
public class LandingPage {

    UiActions uiActions = new UiActions();

    private String[] view = PropertiesFile.propertiesFileReader(new String[]{"keywordLocator"});
    private By keywordLocator = By.name(view[0]);

    /**
     * Method To Find Element locator and send keyword to search for it
     */
    public void typeKeywordToSearch(String keyword) {
        uiActions.findElementAndReturn(keywordLocator)
                .sendKeysToElement(keyword).takeActionOnElement("submit");
    }
}
