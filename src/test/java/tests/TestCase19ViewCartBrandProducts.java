package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class TestCase19ViewCartBrandProducts extends BaseTest {
    @Test
    public void viewCartBrandProducts(){
        //3. Click on 'Products' button
        ProductsPage productsPage = homePage.clickProductsUrl();
        //4. Verify that Brands are visible on left side bar
        softAssert.assertTrue(productsPage.isBarndsMenuDisplayed(),
                "The brands menu is not displayed");
        //5. Click on any brand name
        productsPage.clickPoloBrand();
        //6. Verify that user is navigated to brand page and brand products are displayed
        String currentUrl = driver.getCurrentUrl();
        softAssert.assertEquals(currentUrl,
                "https://automationexercise.com/brand_products/Polo",
                "You are not in polo brand page");
        //7. On left side bar, click on any other brand link
        productsPage.clickHAndMBrand();
        //8. Verify that user is navigated to that brand page and can see products
        String hAndMUrl = driver.getCurrentUrl();
        softAssert.assertEquals(hAndMUrl,
                "https://automationexercise.com/brand_products/H&M",
                "You are not in H&M brand page");







        softAssert.assertAll();








    }
}
