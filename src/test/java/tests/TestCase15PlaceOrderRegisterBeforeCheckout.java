package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

public class TestCase15PlaceOrderRegisterBeforeCheckout extends BaseTest {
    @Test
    public void placeOrderRegisterBeforeCheckout(){
        //4. Click 'Signup / Login' button
        LoginPage loginPage = homePage.clickSignUpInURL();
        //5. Fill all details in Signup and create account
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
        AccountCreatedPage accountCreatedPage = signupPage.clickCreateAccount();
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        boolean isAccountCreatedDisplayed = accountCreatedPage.isAccountCreatedDisplayed();
        softAssert.assertTrue(isAccountCreatedDisplayed, "You are not in account created page");
        accountCreatedPage.clickContinueButton();
        //7. Verify ' Logged in as username' at top
        boolean isLoggedInAsUsernameDisplayed = homePage.isLoggedInAsUsernameDisplayed();
        softAssert.assertTrue(isLoggedInAsUsernameDisplayed, "You are not signed");
        //8. Add products to cart
        homePage.setAddFirstProductToCart();
        //9. Click 'Cart' button
        CartPage cartPage = homePage.clickViewCartAfterAddItemToCart();
        //10. Verify that cart page is displayed
        String currentURL = driver.getCurrentUrl();
        softAssert.assertEquals(currentURL,
                "https://automationexercise.com/view_cart",
                "You are not in the cart page");
        //11. Click Proceed To Checkout
        CheckoutPage checkoutPage = cartPage.clickProceedToCheckoutButton();
        //12. Verify Address Details and Review Your Order
        //13. Enter description in comment text area and click 'Place Order'
        checkoutPage.fillDescription("This is a test description");
        PaymentPage paymentPage = checkoutPage.clickPlaceOrderButton();
        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        paymentPage.fillNameONCard("Ahmed Ragab");
        paymentPage.fillCardNumber("1234123412341234");
        paymentPage.fillCVC();
        paymentPage.fillExpirationMonth("12");
        paymentPage.fillExpirationYear("2026");
        //15. Click 'Pay and Confirm Order' button
        PaymentDonePage paymentDonePage = paymentPage.clickPayAndConfirmOrderButton();
        //16. Verify success message 'Your order has been placed successfully!'
        //17. Click 'Delete Account' button
        DeletedAccountPage deletedAccountPage = homePage.clickDeleteAccount();
        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        softAssert.assertTrue(deletedAccountPage.isAccountDeletedDisplayed(),
                "The account is not deleted");
        deletedAccountPage.clickContinueButton();
        softAssert.assertAll();
    }
}
