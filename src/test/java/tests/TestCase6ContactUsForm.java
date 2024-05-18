package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class TestCase6ContactUsForm extends BaseTest {
    @Test
    public void contactUs(){
        //3. Verify that home page is visible successfully
        String homeURLColor = homePage.getHomeUrlColor();
        softAssert.assertEquals(homeURLColor, "color: orange;", "You are not in home page");
        //4. Click on 'Contact Us' button
        ContactUsPage contactUsPage = homePage.clickContactUs();
        //5. Verify 'GET IN TOUCH' is visible
        boolean isGetInTouchDisplayed = contactUsPage.isGetInTouchDisplayed();
        softAssert.assertTrue(isGetInTouchDisplayed, "The 'get in touch' sentence is not displayed");
        //6. Enter name, email, subject and message
        contactUsPage.enterName("Ahmed");
        contactUsPage.enterEmail("ahmedragab9089@gmail.com");
        contactUsPage.enterSubject("Test Message");
        contactUsPage.enterMessage("This is a message from Ahmed");
        //7. Upload file
        contactUsPage.uploadFile("C:\\Users\\AhmedRagab\\Desktop\\messageToBeAttached.txt");
        //8. Click 'Submit' button
        contactUsPage.clickSubmitButton();
        //9. Click OK button
        driver.switchTo().alert().accept();
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        boolean isSuccessMessageDisplayed = contactUsPage.isSuccessMessageDisplayed();
        softAssert.assertTrue(isSuccessMessageDisplayed, "The success message is not displayed");
        //11. Click 'Home' button and verify that landed to home page successfully
        contactUsPage.clickBackToHomeButton();
        String homeURLColorAfterRedirection = homePage.getHomeUrlColor();
        softAssert.assertEquals(homeURLColorAfterRedirection, "color: orange;", "You are not in home page");


        softAssert.assertAll();
    }
}
