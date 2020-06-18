package pom;

import org.openqa.selenium.By;
import utility.UiActions;


public class SecondResultPage{
    UiActions uiActions = new UiActions();

    By listResultLocator = By.xpath("//div[@id='rso']//div[@class='g']");
    By nextButtonLocator = By.xpath("//td//span[contains(.,'Next')]");


    public void scrollDown_Second_Page() {
        uiActions.scrollDownToBottom();
    }

    public void click_On_Next_Button_SecondPage() {
        uiActions.waitForElement(nextButtonLocator,"clickable");
        uiActions.findElementAndReturn(nextButtonLocator).takeActionOnElement("click");
    }
    public int get_Result_Size_Second_Page(){
        return uiActions.getSizeOfElements(listResultLocator);
    }


}
