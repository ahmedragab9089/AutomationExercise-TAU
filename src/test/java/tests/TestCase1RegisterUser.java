package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.DeletedAccountPage;
import pages.LoginPage;
import pages.SignupPage;

public class TestCase1RegisterUser extends BaseTest {
    @Test //Register user and delete him after creation
    public void registerUserAndDeleteHim(){
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
        signupPage.enterPassword("123456");
        signupPage.selectBirthDay("1");
        signupPage.selectBirthMonth("3");
        signupPage.selectBirthYear("1990");
        //10. Select checkbox 'Sign up for our newsletter!'
        signupPage.signUpforNewsLetter();
        //11. Select checkbox 'Receive special offers from our partners!'
        signupPage.receiveOffers();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        signupPage.enterFirstName("Ahmed");
        signupPage.enterLastName("Ragab");
        signupPage.enterCompany("Personal");
        signupPage.enterAddress("India");
        signupPage.selectCountry("India");
        signupPage.enterState("New Delhi");
        signupPage.enterCity("New Delhi");
        signupPage.enterZipCode("12345");
        signupPage.enterMobileNumber("01277410198");
        //13. Click 'Create Account button'
        AccountCreatedPage accountCreatedPage = signupPage.clickCreateAccount();
        //14. Verify that 'ACCOUNT CREATED!' is visible
        boolean isAccountCreatedDisplayed = accountCreatedPage.isAccountCreatedDisplayed();
        softAssert.assertTrue(isAccountCreatedDisplayed, "You are not in account created page");
        //15. Click 'Continue' button
        accountCreatedPage.clickContinueButton();
        //16. Verify that 'Logged in as username' is visible
        boolean isLoggedInAsUsernameDisplayed = homePage.isLinkedInAsUsernameDisplayed();
        softAssert.assertTrue(isLoggedInAsUsernameDisplayed, "You are not signed");
        //17. Click 'Delete Account' button
        DeletedAccountPage deletedAccountPage = homePage.clickDeleteAccount();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        boolean isAccountDeletedDisplayed = deletedAccountPage.isAccountDeletedDisplayed();
        softAssert.assertTrue(isAccountDeletedDisplayed, "The account is not deleted");
        deletedAccountPage.clickContinueButton();
        softAssert.assertAll();
    }

   //Register user but do not delete him

    public void registerUserAndDoNotDeleteHim(){
        //4. Click on 'Signup / Login' button
        LoginPage loginPage = homePage.clickSignUpInButton();
        //5. Verify 'New User Signup!' is visible
        //6. Enter name and email address
        loginPage.addSignupName("Ahmed Ragab");
        loginPage.addSignupMail("ahmedragab9089@gmail.com");
        //7. Click 'Signup' button
        SignupPage signupPage = loginPage.clickSignupButton();
        //9. Fill details: Title, Name, Email, Password, Date of birth
        signupPage.selectTtileMr();
        signupPage.enterPassword("123456");
        signupPage.selectBirthDay("1");
        signupPage.selectBirthMonth("3");
        signupPage.selectBirthYear("1990");
        //10. Select checkbox 'Sign up for our newsletter!'
        signupPage.signUpforNewsLetter();
        //11. Select checkbox 'Receive special offers from our partners!'
        signupPage.receiveOffers();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        signupPage.enterFirstName("Ahmed");
        signupPage.enterLastName("Ragab");
        signupPage.enterCompany("Personal");
        signupPage.enterAddress("India");
        signupPage.selectCountry("India");
        signupPage.enterState("New Delhi");
        signupPage.enterCity("New Delhi");
        signupPage.enterZipCode("12345");
        signupPage.enterMobileNumber("01277410198");
        //13. Click 'Create Account button'
        AccountCreatedPage accountCreatedPage = signupPage.clickCreateAccount();
        //15. Click 'Continue' button
        accountCreatedPage.clickContinueButton();
        homePage.clickLogoutUrl();
        driver.get("https://automationexercise.com/");
    }


}
