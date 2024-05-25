package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TestCase3LoginUserWithIncorrectEmailAndPassword extends BaseTest {
    @Test
    public void loginUserWithIncorrectEmailAndPassword(){
        //4. Click on 'Signup / Login' button
        LoginPage loginPage = homePage.clickSignUpInURL();
        //5. Verify 'Login to your account' is visible
        boolean isLoginToYourAccountDisplayed = loginPage.isLoginToYourAccountDisplayed();
        softAssert.assertTrue(isLoginToYourAccountDisplayed, "The 'login to your account' is not displayed");
        //6. Enter incorrect email address and password
        loginPage.addLoginEmail("ahmed@gmail.com");
        loginPage.addPassword("000");
        //7. Click 'login' button
        loginPage.clickLoginButton();
        //8. Verify error 'Your email or password is incorrect!' is visible
        boolean isLoginErrorMessageDisplayed = loginPage.isLoginErrorMessageDisplayed();
        softAssert.assertTrue(isLoginErrorMessageDisplayed, "The erorr message is not displayed");
        softAssert.assertAll();
    }
}
