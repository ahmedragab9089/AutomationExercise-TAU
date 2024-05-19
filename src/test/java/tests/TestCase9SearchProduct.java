package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class TestCase9SearchProduct extends BaseTest {
    @Test
    public void searchProduct(){
        //3. Verify that home page is visible successfully
        String homeURLColor = homePage.getHomeUrlColor();
        softAssert.assertEquals(homeURLColor, "color: orange;",
                "You are not in home page");
        //4. Click on 'Products' button
        ProductsPage productsPage = homePage.clickProductsUrl();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String productsPageUrl = driver.getCurrentUrl();
        softAssert.assertEquals(productsPageUrl,
                "https://automationexercise.com/products",
                "You are not in products page");
        //6. Enter product name in search input and click search button
        productsPage.searchProducts("Top");
        productsPage.clickSearchButton();
        //7. Verify 'SEARCHED PRODUCTS' is visible
        String searchedProductsSentence = productsPage.getSearchedProductsSentence();
        softAssert.assertEquals(searchedProductsSentence, "SEARCHED PRODUCTS",
                "The searched products is not visible");
        //8. Verify all the products related to search are visible


        
        softAssert.assertAll();
    }
}
