package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class TestCase2LoginUserWithCorrectEmailAndPassword extends BaseTest {
    @BeforeMethod //This method is called here only to register the user to be able to sign with him as we delete the user after registering him in test case 1
    public void createUserWithoutDeletinHim(){
        registerUserAndDoNotDeleteHim();
    }
    @Test
    public void loginUserWithCorrectEmailAndPassword(){
        //3. Verify that home page is visible successfully
        String homeURLColor = homePage.getHomeUrlColor();
        softAssert.assertEquals(homeURLColor, "color: orange;", "You are not in home page");
        //4. Click on 'Signup / Login' button
        LoginPage loginPage = homePage.clickSignUpInURL();
        //5. Verify 'Login to your account' is visible
        boolean isLoginToYourAccountDisplayed = loginPage.isLoginToYourAccountDisplayed();
        softAssert.assertTrue(isLoginToYourAccountDisplayed, "The 'login to your account' is not displayed");
        //6. Enter correct email address and password
        loginPage.addLoginEmail("ahmedragab9089@gmail.com");
        loginPage.addPassword("123456");
        //7. Click 'login' button
        loginPage.clickLoginButton();
        //8. Verify that 'Logged in as username' is visible
        boolean isloggedInAsUserName = homePage.isLoggedInAsUsernameDisplayed();
        softAssert.assertTrue(isloggedInAsUserName, "You are not logged in");
        //9. Click 'Delete Account' button
        DeletedAccountPage deletedAccountPage = homePage.clickDeleteAccount();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        boolean isAccountDeletedDisplayed = deletedAccountPage.isAccountDeletedDisplayed();
        softAssert.assertTrue(isAccountDeletedDisplayed, "The account is not deleted");

        softAssert.assertAll();
    }
}
