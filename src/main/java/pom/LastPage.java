package pom;

import org.openqa.selenium.By;
import utility.UiActions;

public class LastPage {
    UiActions uiActions = new UiActions();

    By listResultLocator = By.xpath("//div[@id='rso']//div[@class='g']");


    public int get_Result_Size_Last_Page(){
        return uiActions.getSizeOfElements(listResultLocator);
               /* UiActions.driver.findElements(listResultLocator).size();*/
    }
}
