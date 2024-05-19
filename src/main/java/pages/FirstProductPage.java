package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstProductPage {
    private WebDriver driver;
    private By productName = By.cssSelector(".product-information h2");
    private By productCatergory = By.xpath("//div[@class=\"product-information\"]/p[1]");
    private By productPrice = By.cssSelector(".product-information span span");
    private By productAvailability = By.xpath("//div[@class=\"product-information\"]/p[2]");
    private By productCondition = By.xpath("//div[@class=\"product-information\"]/p[3]");
    private By productBrand = By.xpath("//div[@class=\"product-information\"]/p[4]");

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
}
