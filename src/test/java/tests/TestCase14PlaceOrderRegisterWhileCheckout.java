package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

public class TestCase14PlaceOrderRegisterWhileCheckout extends BaseTest {
    @Test
    public void placeOrderRegisterWhileCheckout(){
        //4. Add products to cart
        homePage.setAddFirstProductToCart();
        //5. Click 'Cart' button
        CartPage cartPage = homePage.clickViewCartAfterAddItemToCart();
        //6. Verify that cart page is displayed
        String currentURL = driver.getCurrentUrl();
        softAssert.assertEquals(currentURL,
                "https://automationexercise.com/view_cart",
                "You are not in cart page");
        //7. Click Proceed To Checkout
        cartPage.clickProceedToCheckoutButton();
        //8. Click 'Register / Login' button
        LoginPage loginPage = cartPage.clickRegisterLoginButton();
        //9. Fill all details in Signup and create account
        loginPage.addSignupName("Ahmed Ragab");
        loginPage.addSignupMail("ahmedragabahmedabdel@gmail.com");
        SignupPage signupPage = loginPage.clickSignupButton();
        signupPage.selectTtileMr();
        signupPage.enterPassword("123456");
        signupPage.selectBirthDay("1");
        signupPage.selectBirthMonth("3");
        signupPage.selectBirthYear("1990");
        signupPage.signUpforNewsLetter();
        signupPage.receiveOffers();
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
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        boolean isAccountCreatedDisplayed = accountCreatedPage.isAccountCreatedDisplayed();
        softAssert.assertTrue(isAccountCreatedDisplayed, "You are not in account created page");
        accountCreatedPage.clickContinueButton();
        //11. Verify ' Logged in as username' at top
        boolean isLoggedInAsUsernameDisplayed = homePage.isLoggedInAsUsernameDisplayed();
        softAssert.assertTrue(isLoggedInAsUsernameDisplayed, "You are not signed");
        //12.Click 'Cart' button
        homePage.clickCartUrl();
        //13. Click 'Proceed To Checkout' button
        CheckoutPage checkoutPage = cartPage.clickProceedToCheckoutButton();
        //14. Verify Address Details and Review Your Order
        //15. Enter description in comment text area and click 'Place Order'
        checkoutPage.fillDescription("This is a test description");
        PaymentPage paymentPage = checkoutPage.clickPlaceOrderButton();
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        paymentPage.fillNameONCard("Ahmed Ragab");
        paymentPage.fillCardNumber("1234123412341234");
        paymentPage.fillCVC();
        paymentPage.fillExpirationMonth("12");
        paymentPage.fillExpirationYear("2026");
        //17. Click 'Pay and Confirm Order' button
        PaymentDonePage paymentDonePage = paymentPage.clickPayAndConfirmOrderButton();
        //18. Verify success message 'Your order has been placed successfully!'
        //softAssert.assertTrue(paymentPage.isSuccessMessageDisplayed(), "Your order is not placed");
        //19. Click 'Delete Account' button
        DeletedAccountPage deletedAccountPage = homePage.clickDeleteAccount();
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        softAssert.assertTrue(deletedAccountPage.isAccountDeletedDisplayed(),
                "The account is not deleted");
        deletedAccountPage.clickContinueButton();
        softAssert.assertAll();
    }
}
