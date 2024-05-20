package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;

public class TestCase11VerifySubscriptionInCartPage extends BaseTest {
    @Test
    public void verifySubscriptionInCartPage(){
        //3. Verify that home page is visible successfully
        String homeURLColor = homePage.getHomeUrlColor();
        softAssert.assertEquals(homeURLColor, "color: orange;",
                "You are not in home page");
        //4. Click 'Cart' button
        CartPage cartPage = homePage.clickCartUrl();
        //5. Scroll down to footer
        homePage.scrollToFooter();
        //6. Verify text 'SUBSCRIPTION'
        boolean isSubscriptionTextDisplayed = homePage.isSubscriptionTextDisplayed();
        softAssert.assertTrue(isSubscriptionTextDisplayed,
                "The sunscription text is not displayed");
        //7. Enter email address in input and click arrow button
        homePage.enterSubscriptionEmail("ahmedragab9089@gmail.com");
        homePage.clickSubscriptionEmailSendButton();
        //8. Verify success message 'You have been successfully subscribed!' is visible
        String successSubscriptionMessage = homePage.getSuccessSubscriptionMessage();
        softAssert.assertEquals(successSubscriptionMessage,
                "You have been successfully subscribed!",
                "The success message does not appear");

        softAssert.assertAll();
    }
}
