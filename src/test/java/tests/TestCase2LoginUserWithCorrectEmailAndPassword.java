package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.Base64;

public class TestCase2LoginUserWithCorrectEmailAndPassword extends BaseTest {
    @BeforeMethod
    public void createAccount(){
        TestCase1RegisterUser tc1 = new TestCase1RegisterUser();
        tc1.registerUserAndDoNotDeleteHim();
    }
    @Test
    public void loginUserWithCorrectEmailAndPassword(){
        //3. Verify that home page is visible successfully
        String homeURLColor = homePage.getHomeUrlColor();
        softAssert.assertEquals(homeURLColor, "color: orange;", "You are not in home page");
        //4. Click on 'Signup / Login' button
        LoginPage loginPage = homePage.clickSignUpInButton();






        //5. Verify 'Login to your account' is visible
        //6. Enter correct email address and password
        //7. Click 'login' button
        //8. Verify that 'Logged in as username' is visible
        //9. Click 'Delete Account' button
        //10. Verify that 'ACCOUNT DELETED!' is visible
    }

}
