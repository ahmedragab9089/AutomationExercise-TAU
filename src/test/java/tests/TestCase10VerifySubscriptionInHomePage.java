package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class TestCase10VerifySubscriptionInHomePage extends BaseTest {
    @Test
    public void verifySubscriptionInHomePage(){
        //4. Scroll down to footer
        homePage.scrollToFooter();
        //5. Verify text 'SUBSCRIPTION'
        boolean isSubscriptionTextDisplayed = homePage.isSubscriptionTextDisplayed();
        softAssert.assertTrue(isSubscriptionTextDisplayed,
                "The sunscription text is not displayed");
        //6. Enter email address in input and click arrow button
        homePage.enterSubscriptionEmail("ahmedragab9089@gmail.com");
        homePage.clickSubscriptionEmailSendButton();
        //7. Verify success message 'You have been successfully subscribed!' is visible
        String successSubscriptionMessage = homePage.getSuccessSubscriptionMessage();
        softAssert.assertEquals(successSubscriptionMessage,
                "You have been successfully subscribed!",
                "The success message does not appear");

        softAssert.assertAll();
    }
}
