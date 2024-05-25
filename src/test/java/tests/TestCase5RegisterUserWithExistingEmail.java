package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TestCase5RegisterUserWithExistingEmail extends BaseTest {
    @Test
    public void registerUserWithExistingEmail(){
        //4. Click on 'Signup / Login' button
        LoginPage loginPage = homePage.clickSignUpInURL();
        //5. Verify 'New User Signup!' is visible
        softAssert.assertTrue(loginPage.isNewUserSignUpDisplayed(), "The New user signup is not displayed");
        //6. Enter name and already registered email address
        loginPage.addSignupName("Ahmed Ragab");
        loginPage.addSignupMail("ahmedragab9089@gmail.com");
        //7. Click 'Signup' button
        loginPage.clickSignupButton();
        //8. Verify error 'Email Address already exist!' is visible
        boolean isSignupErrorMessageDisplayed = loginPage.isSignupErrorMessageDisplayed();
        softAssert.assertTrue(isSignupErrorMessageDisplayed, "The sign up error message is not displayed");

        softAssert.assertAll();
    }
}
