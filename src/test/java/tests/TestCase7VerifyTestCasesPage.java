package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.TestCasesPage;

public class TestCase7VerifyTestCasesPage extends BaseTest {
    @Test
    public void verifyTestCasesPage(){
        //3. Verify that home page is visible successfully
        String homeURLColor = homePage.getHomeUrlColor();
        softAssert.assertEquals(homeURLColor, "color: orange;", "You are not in home page");
        //4. Click on 'Test Cases' button
        TestCasesPage testCasesPage = homePage.clickTestCasesButton();
        //5. Verify user is navigated to test cases page successfully
        String testCasesPageUrl = driver.getCurrentUrl();
        softAssert.assertEquals(testCasesPageUrl,
                "https://automationexercise.com/test_cases",
                "You are not in test cases page");
        softAssert.assertAll();
    }
}
