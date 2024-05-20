package tests;

import base.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.annotations.Test;
import pages.ProductsPage;

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
        productsPage.clickAddToCartFromOverlayAfterHover();









        softAssert.assertAll();




        //6. Click 'Continue Shopping' button
        //7. Hover over second product and click 'Add to cart'
        //8. Click 'View Cart' button
        //9. Verify both products are added to Cart
        //10. Verify their prices, quantity and total price
    }
}
