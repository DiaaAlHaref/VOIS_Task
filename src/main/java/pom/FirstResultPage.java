package pom;

import org.openqa.selenium.By;
import utility.UiActions;


public class FirstResultPage {
    UiActions uiActions = new UiActions();
    By nextButtonLocator = By.xpath("//td//span[contains(.,'Next')]");



    public void scrollDown_First_Page() {
        uiActions.scrollDownToBottom();
    }

    public void click_On_Next_Button_First_Page() {
        uiActions.waitForElement(nextButtonLocator,"clickable");
        uiActions.findElementAndReturn(nextButtonLocator).takeActionOnElement("click");
    }
}
