package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    private WebDriver driver;
    private By allProductsParentTag = By.cssSelector(".features_items");
    private By viewFirstProduct = By.cssSelector("[href=\"/product_details/1\"]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isAllProductsParentTagDisplayed(){
        return driver.findElement(allProductsParentTag).isDisplayed();
    }
    public FirstProductPage clickViewFirstProduct(){
        driver.findElement(viewFirstProduct).click();
        return new FirstProductPage(driver);
    }
}
