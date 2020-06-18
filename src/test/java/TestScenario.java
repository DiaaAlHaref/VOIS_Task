import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario extends BaseTest {


    @Test
    public void test_OpenUrl() {
        landingPage.openUrl();
        landingPage.typeKeywordToSearch();
        firstResultPage.scrollDown_First_Page();
        firstResultPage.click_On_Next_Button_First_Page();
        secondResultPage.scrollDown_Second_Page();
        secondResultPage.click_On_Next_Button_SecondPage();
        int countLastPage =lastPage.get_Result_Size_Last_Page();
        int countSecondPage = secondResultPage.get_Result_Size_Second_Page();
        Assert.assertEquals(countSecondPage,countLastPage,"Result Number didn't match");
    }


}
