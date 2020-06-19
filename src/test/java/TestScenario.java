import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestScenario extends BaseTest {
    /**
     * <p> Test Scenario </p>
     * Open Url
     * Type Keyword to search for
     * Scroll down and go to next page
     * Count number of results displayed
     * Scroll down and go to next page
     * Validate if the number of results in page 2 equal to page 3 or not
     * Close the browser window
     */

    @Test(dataProvider = "Locators")
    public void test_OpenUrl(Map<Object, Object> map) {

        landingPage.openUrl(); //Navigate to the target url

        landingPage.typeKeywordToSearch(String.valueOf(map.get("keyword"))); //Type Keyword to search for

        firstResultPage.scrollDown_First_Page(); //Scroll down and go to next page
        firstResultPage.click_On_Next_Button_First_Page();

        int countSecondPage = secondResultPage.countNumberOfResultsInSecond_Page(); //Count number of results displayed

        secondResultPage.scrollDown_Second_Page();//Scroll down and go to next page
        secondResultPage.click_On_Next_Button_SecondPage();

        int countLastPage = lastPage.countNumberOfResultsInThird_Page();
        Assert.assertEquals(countSecondPage, 10, "Result Number didn't match"); //Validate if the number of results in page 2 equal to page 3 or not
    }


    @DataProvider(name = "Locators")
    public Object[][] getDataFromExcel() throws IOException {
        final Object[][] objects = ReadFromExcelSheet.ReturnData();
        return objects;
    }


}
