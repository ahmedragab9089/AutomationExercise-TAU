package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.FirstProductPage;

public class TestCase13VerifyProductQuantityInCart extends BaseTest {
    @Test
    public void verifyProductQuantityInCart(){
        //4. Click 'View Product' for any product on home page
        FirstProductPage firstProductPage = homePage.clickViewFirstProduct();
        //5. Verify product detail is opened
        String currentURL = driver.getCurrentUrl();
        softAssert.assertEquals(currentURL,
                "https://automationexercise.com/product_details/1",
                "You are not in the product page");
        //6. Increase quantity to 4
        firstProductPage.increaseQuantity("4");
        //7. Click 'Add to cart' button
        firstProductPage.clickAddItemToCart();
        //8. Click 'View Cart' button
        CartPage cartPage= firstProductPage.clickViewCart();
        //9. Verify that product is displayed in cart page with exact quantity
        softAssert.assertEquals(cartPage.getNumberofProductsInCart(),
                1, "The item is not added to cart");

        softAssert.assertAll();
    }
}
