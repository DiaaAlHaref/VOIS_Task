package googleTest;

import fileReaders.ReadFromExcelSheet;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FirstResultPage;
import pages.LandingPage;
import pages.LastPage;
import pages.SecondResultPage;
import utilities.UiActions;

import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestScenario extends ParallelTest {

    LandingPage landingPage = new LandingPage(); //Instantiation of LandPage object
    FirstResultPage firstResultPage = new FirstResultPage(); //Instantiation of FirstPage object
    SecondResultPage secondResultPage = new SecondResultPage(); //Instantiation of SecondPage object
    LastPage lastPage = new LastPage(); //Instantiation of LastPage object

    /**
     * <p> Test Scenario </p>
     * <p> Step.1) Open Url </p>
     * <p> Step.2) Type Keyword "Vodafone" to search for </p>
     * <p> Step.3) Scroll down and go to next page </p>
     * <p> Step.4) Count number of results displayed </p>
     * <p> Step.5) Scroll down and go to next page </p>
     * <p> Step.6) Validate if the number of results in page 2 equal to page 3 </p>
     * <p> Step.7) Close the browser window </p>
     */

    @Attachment(value = "Screenshot", type = "image/png")
    @Description("Search for Vodafone and assert on number of result of last two pages ")
    @Test(dataProvider = "Locators")
    public void test_SearchForVodafoneAndAssertOnSearchResults(Map<Object, Object> map) {
        Allure.addAttachment("Page Screenshot",
                new ByteArrayInputStream(((TakesScreenshot) UiActions.driver).getScreenshotAs(OutputType.BYTES)));
        Log.log4PropertiesConfiguration();
        Log.runTestCase("test_SearchForVodafoneAndAssertOnSearchResults");


        landingPage.typeKeywordToSearch(String.valueOf(map.get("keyword"))); //Type Keyword to search for
        Log.info("Typed the keyword to search for");

        firstResultPage.scrollDownFirst_Page(); //Scroll down and go to next page
        Log.info("Scroll down to the next button in the firstPage");
        firstResultPage.clickOnNextButtonFirst_Page();
        Log.info("Click on next button in first page");

        int countSecondPage = secondResultPage.countNumberOfResultsInSecond_Page(); //Count number of results displayed
        Log.info("Number of results displayed in second page:  " + countSecondPage);

        secondResultPage.scrollDownSecond_Page();//Scroll down and go to next page
        Log.info("Scroll down to the next button in the secondPage");
        secondResultPage.clickOnNextButtonSecondPage();
        Log.info("Click on next button in second page");

        int countLastPage = lastPage.countNumberOfResultsInThird_Page();
        Log.info("Number of result displayed in last page:  " + countLastPage);

        Assert.assertEquals(countSecondPage, countLastPage, "Result Number didn't match"); //Validate if the number of results in page 2 equal to page 3 or not
        UiActions.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        Log.fatal("Number of results of page_2 equals to page_3");

        Log.endTestCase("test_SearchForVodafoneAndAssertOnSearchResults");

    }

    /**
     * Data Provider linked with excel sheet method to return data in form of key and value
     *
     * @return key and value
     */
    @DataProvider(name = "Locators")
    public Object[][] getDataFromExcel() {
        final Object[][] objects = ReadFromExcelSheet.returnData();
        return objects;
    }


}
