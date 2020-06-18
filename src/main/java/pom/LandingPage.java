


package pom;

import org.openqa.selenium.By;
import utility.UiActions;

public class LandingPage {

    UiActions uiActions = new UiActions();
    private By keywordLocator = By.name("q");
    private String keyword = "Vodafone";


    public void openUrl() {
        UiActions.driver.navigate().to("https://www.google.com/ncr");
    }

    public void typeKeywordToSearch() {
        uiActions.findElementAndReturn(keywordLocator)
                .sendKeysToElement(keyword).takeActionOnElement("submit");
    }
}
