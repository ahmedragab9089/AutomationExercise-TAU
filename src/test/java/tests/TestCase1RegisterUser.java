package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignupPage;

public class TestCase1RegisterUser extends BaseTest {
    @Test //Register user
    public void registerUser(){
        //3. Verify that home page is visible successfully
        //We can do that by verifying the home URL color to be orange which means it is selected
        String homeURLColor = homePage.getHomeUrlColor();
        softAssert.assertEquals(homeURLColor, "color: orange;", "You are not in home page");
        //4. Click on 'Signup / Login' button
        LoginPage loginPage = homePage.clickSignUpInButton();
        //5. Verify 'New User Signup!' is visible
        softAssert.assertTrue(loginPage.isNewUserSignUpDisplayed(), "The New user signup is not displayed");
        //6. Enter name and email address
        loginPage.addSignupName("Ahmed Ragab");
        loginPage.addSignupMail("ahmedragab9089@gmail.com");
        //7. Click 'Signup' button
        SignupPage signupPage = loginPage.clickSignupButton();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        boolean isEnterAccountInformationDisplayed = signupPage.isEnterAccountInfoVisible();
        softAssert.assertTrue(isEnterAccountInformationDisplayed, "You are not in sign up page");
        //9. Fill details: Title, Name, Email, Password, Date of birth
        signupPage.selectTtileMr();
        signupPage.setPassword("123456");
        signupPage.selectBirthDay("1");
        signupPage.selectBirthMonth("3");
        signupPage.selectBirthYear("1990");
        //10. Select checkbox 'Sign up for our newsletter!'
        signupPage.signUpforNewsLetter();
        //11. Select checkbox 'Receive special offers from our partners!'
        signupPage.receiveOffers();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

















        softAssert.assertAll();





        //13. Click 'Create Account button'
        //14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }

}
