package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;

public class TestCase16PlaceOrderLoginBeforeCheckout extends BaseTest {
    @Test
    public void placeOrderLoginBeforeCheckout(){
        //4. Click 'Signup / Login' button
        LoginPage loginPage = homePage.clickSignUpInURL();
        //5. Fill email, password and click 'Login' button
        loginPage.addLoginEmail("ahmedragab9089@gmail.com");
        loginPage.addPassword("123456");
        loginPage.clickLoginButton();
        //6. Verify 'Logged in as username' at top
        softAssert.assertTrue(homePage.isLoggedInAsUsernameDisplayed(),
                "The user is not logged in");
        //7. Add products to cart
        homePage.setAddFirstProductToCart();
        //8. Click 'Cart' button
        CartPage cartPage = homePage.clickCartUrl();
        //9. Verify that cart page is displayed
        String currentURL = driver.getCurrentUrl();
        softAssert.assertEquals(currentURL,
                "https://automationexercise.com/view_cart",
                "You are not in the cart page");
        //10. Click Proceed To Checkout
        CheckoutPage checkoutPage = cartPage.clickProceedToCheckoutButton();
        //11. Verify Address Details and Review Your Order











        softAssert.assertAll();



        //12. Enter description in comment text area and click 'Place Order'
        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //14. Click 'Pay and Confirm Order' button
        //15. Verify success message 'Your order has been placed successfully!'
        //16. Click 'Delete Account' button
        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
