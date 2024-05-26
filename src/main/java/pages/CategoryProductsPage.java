package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryProductsPage {
    private WebDriver driver;
    private By categoryName = By.cssSelector(".features_items h2");

    public CategoryProductsPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getCategoryName(){
        return driver.findElement(categoryName).getText();
    }
}
