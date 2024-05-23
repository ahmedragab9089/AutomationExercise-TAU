package tests;

import base.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;

import java.util.List;

public class TestCase12AddProductsInCart extends BaseTest {
    @Test
    public void addProductsInCart(){
        //3. Verify that home page is visible successfully
        String homeURLColor = homePage.getHomeUrlColor();
        softAssert.assertEquals(homeURLColor, "color: orange;",
                "You are not in home page");
        //4. Click 'Products' button
        ProductsPage productsPage = homePage.clickProductsUrl();
        //5. Hover over first product and click 'Add to cart'
        productsPage.hoverOverFirstProduct();
        productsPage.clickAddToCartFromOverlayAfterHoverFirstProduct();
        //6. Click 'Continue Shopping' button
        productsPage.clickContinueShoppingButton();
        //7. Hover over second product and click 'Add to cart'
        productsPage.hoverOverSecondProduct();
        productsPage.clickAddToCartFromOverlayAfterHoverSecondProduct();
        //8. Click 'View Cart' button
        CartPage cartPage = productsPage.clickViewCartAfterAddItemToCart();
        //9. Verify both products are added to Cart
        //We can verify that there are two items in the cart
        softAssert.assertEquals(cartPage.getNumberofProductsInCart(), 2, "The two products are not added to the cart");
        //10. Verify their prices, quantity and total price

        softAssert.assertAll();

    }
}
