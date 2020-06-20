package pages;

import fileReaders.PropertiesFile;
import org.openqa.selenium.By;
import utilities.UiActions;
/**
 * LastPage Class represents the third search result page
 */

/**
 * @author Diaa AlHaref
 */
public class LastPage {
    UiActions uiActions = new UiActions();
    private String[] view = PropertiesFile.propertiesFileReader(new String[]{"listResultLocator"});
    private final By listResultLocator = By.xpath(view[0]);

    /**
     * Get Number of Results in the page
     *
     * @return number of elements
     */
    public int countNumberOfResultsInThird_Page() {
        return uiActions.findListOfElements(listResultLocator).getSizeOfElements();
    }
}
