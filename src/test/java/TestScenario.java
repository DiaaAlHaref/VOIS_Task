import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.io.IOException;
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
    public void test_SearchForVodafoneAndAssertOnSearchResults(Map<Object, Object> map) {
        Log.log4PropertiesConfiguration();
        Log.runTestCase("test_SearchForVodafoneAndAssertOnSearchResults");

        landingPage.openUrl(); //1) Navigate to the target url
        Log.info("Navigate to url");

        landingPage.typeKeywordToSearch(String.valueOf(map.get("keyword"))); //Type Keyword to search for
        Log.info("Typed the keyword to search for");

        firstResultPage.scrollDown_First_Page(); //Scroll down and go to next page
        Log.info("scroll down to the next button");

        firstResultPage.click_On_Next_Button_First_Page();
        Log.info("click on next button in first page");

        int countSecondPage = secondResultPage.countNumberOfResultsInSecond_Page(); //Count number of results displayed
        Log.info("number of results displayed in second page:  " + countSecondPage);

        secondResultPage.scrollDown_Second_Page();//Scroll down and go to next page
        Log.info("scroll down to the element");

        secondResultPage.click_On_Next_Button_SecondPage();
        Log.info("click on next button in second page");

        int countLastPage = lastPage.countNumberOfResultsInThird_Page();
        Log.info("number of result displayed in last page:  " + countLastPage);

        Assert.assertEquals(countSecondPage, countLastPage, "Result Number didn't match"); //Validate if the number of results in page 2 equal to page 3 or not
        Log.fatal("number of results of page_2 equals to page_3");

        Log.endTestCase("test_SearchForVodafoneAndAssertOnSearchResults");
    }


    @DataProvider(name = "Locators")
    public Object[][] getDataFromExcel() throws IOException {
        final Object[][] objects = ReadFromExcelSheet.ReturnData();
        return objects;
    }


}
