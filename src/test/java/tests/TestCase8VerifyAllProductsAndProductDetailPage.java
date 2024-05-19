package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FirstProductPage;
import pages.ProductsPage;

public class TestCase8VerifyAllProductsAndProductDetailPage extends BaseTest {
    @Test
    public void verifyAllProductsAndProductDetailPage(){
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
        //6. The products list is visible
        boolean isProductsListVisible = productsPage.isAllProductsParentTagDisplayed();
        softAssert.assertTrue(isProductsListVisible,
                "The products list is not visible");
        //7. Click on 'View Product' of first product
        FirstProductPage firstProductPage = productsPage.clickViewFirstProduct();
        //8. User is landed to product detail page
        String currentUrl = driver.getCurrentUrl();
        softAssert.assertEquals(currentUrl,
                "https://automationexercise.com/product_details/1",
                "You are not in products page");
        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        boolean isProductNameVisible = firstProductPage.isProductNameDisplayed();
        softAssert.assertTrue(isProductNameVisible,
                "The product name is not visible");
        boolean isProductCategoryVisible = firstProductPage.isProductCategoryDisplayed();
        softAssert.assertTrue(isProductCategoryVisible,
                "The product category is not visible");
        boolean isProductPriceVisible = firstProductPage.isProductPriceDisplayed();
        softAssert.assertTrue(isProductPriceVisible,
                "The product price is not visible");
        boolean isProductAvailabilityVisible = firstProductPage.isProductAvailaibilityDisplayed();
        softAssert.assertTrue(isProductAvailabilityVisible,
                "The product availability is not visible");
        boolean isProductConditionVisible = firstProductPage.isProductConditionDisplayed();
        softAssert.assertTrue(isProductConditionVisible,
                "The product condition is not visible");
        boolean isProductBrandVisible = firstProductPage.isProductBrandDisplayed();
        softAssert.assertTrue(isProductBrandVisible,
                "The product brand is not visible");
        softAssert.assertAll();
    }
}
