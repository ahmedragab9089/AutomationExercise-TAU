package tests;

import base.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.annotations.Test;
import pages.CartPage;

public class TestCase17RemoveProductsFromCart extends BaseTest {
    @Test
    public void removeProductsFromCart() throws InterruptedException {
        //4. Add products to cart
        homePage.setAddFirstProductToCart();
        //5. Click 'Cart' button
        CartPage cartPage = homePage.clickViewCartAfterAddItemToCart();
        //6. Verify that cart page is displayed
        String currentURL = driver.getCurrentUrl();
        softAssert.assertEquals(currentURL,
                "https://automationexercise.com/view_cart",
                "You are not in the cart page");
        //7. Click 'X' button corresponding to particular product
        cartPage.clickRemoveItemFromCartButton();
        //8. Verify that product is removed from the cart
        boolean isCartEmptySentenceDisplayed = cartPage.isCartIsEmptySentenceDisplayed();
        softAssert.assertTrue(isCartEmptySentenceDisplayed,
                "The cart is not empty");
        softAssert.assertAll();
    }
}
