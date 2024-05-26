package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CategoryProductsPage;

public class TestCase18ViewCategoryProducts extends BaseTest {
    @Test
    public void viewCategoryProducts(){
        //3. Verify that categories are visible on left side bar
        softAssert.assertTrue(homePage.isCategoriesInLeftSideMenuDisplayed(),
                "The categories list is not displayed");
        //4. Click on 'Women' category
        homePage.clickWomenCategory();
        //5. Click on any category link under 'Women' category, for example: Dress
        CategoryProductsPage categoryProductsPage = homePage.clickDressWomenCategory();
        //6. Verify that category page is displayed and confirm text 'WOMEN - Dress PRODUCTS'
        String categoryName = categoryProductsPage.getCategoryName();
        softAssert.assertEquals(categoryName.toLowerCase(),
                "women - dress products",
                "The category name is incorrect");
        //7. On left side bar, click on any sub-category link of 'Men' category
        homePage.clickMenCategory();
        homePage.clickTshirtsMenCategory();
        String menCategoryName = categoryProductsPage.getCategoryName();
        softAssert.assertTrue(menCategoryName.toLowerCase().contains("tshirtssss"));











        softAssert.assertAll();






        //8. Verify that user is navigated to that category page

    }
}
