package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstProductPage {
    private WebDriver driver;
    private By productName = By.cssSelector(".product-information h2");
    private By productCatergory = By.xpath("//div[@class=\"product-information\"]/p[1]");
    private By productPrice = By.cssSelector(".product-information span span");
    private By productAvailability = By.xpath("//div[@class=\"product-information\"]/p[2]");
    private By productCondition = By.xpath("//div[@class=\"product-information\"]/p[3]");
    private By productBrand = By.xpath("//div[@class=\"product-information\"]/p[4]");
    private By quantity = By.id("quantity");
    private By addItemToCart = By.cssSelector(".btn.btn-default.cart");
    private By viewCart = By.xpath("//div[@id=\"cartModal\"]//a");

    public FirstProductPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean isProductNameDisplayed(){
        return driver.findElement(productName).isDisplayed();
    }
    public boolean isProductCategoryDisplayed(){
        return driver.findElement(productCatergory).isDisplayed();
    }
    public boolean isProductPriceDisplayed(){
        return driver.findElement(productPrice).isDisplayed();
    }
    public boolean isProductAvailaibilityDisplayed(){
        return driver.findElement(productAvailability).isDisplayed();
    }
    public boolean isProductConditionDisplayed(){
        return driver.findElement(productCondition).isDisplayed();
    }
    public boolean isProductBrandDisplayed(){
        return driver.findElement(productBrand).isDisplayed();
    }
    public void increaseQuantity(String quantityNumber){
        driver.findElement(quantity).clear();
        driver.findElement(quantity).sendKeys(quantityNumber);
    }
    public void clickAddItemToCart(){
        driver.findElement(addItemToCart).click();
    }
    public CartPage clickViewCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCart)).click();
        //driver.findElement().click();
        return new CartPage(driver);
    }
}
