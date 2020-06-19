package pom;

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

    By listResultLocator = By.xpath("//div[@id='rso']//div[@class='g']");

    /**
     * Get Number of Results in the page
     *
     * @return number of elements
     */
    public int countNumberOfResultsInThird_Page() {
        return uiActions.getSizeOfElements(listResultLocator);
    }
}
