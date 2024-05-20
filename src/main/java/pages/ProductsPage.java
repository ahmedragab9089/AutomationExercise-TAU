package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    private By allProductsParentTag = By.cssSelector(".features_items");
    private By viewFirstProduct = By.cssSelector("[href=\"/product_details/1\"]");
    private By searchProduct = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By searchedProductsSentence = By.xpath("//div[@class=\"features_items\"]/h2[1]");
    private By allSearchedproductsNamesTags = By.xpath("//div[@class=\"features_items\"]/div[@class=\"col-sm-4\"]/div/div/div[1]/p");
    private By firstProduct = By.xpath("//div[@class=\"features_items\"]/div[@class=\"col-sm-4\"][1]");
    private By addToCartFromOverlayAfterHover = By.xpath("//div[@class=\"product-overlay\"]//a[1]");

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
    public void searchProducts(String searchData){
        driver.findElement(searchProduct).sendKeys(searchData);
    }
    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }
    public String getSearchedProductsSentence(){
        return driver.findElement(searchedProductsSentence).getText();
    }
    public List<String> getAllSearchedProductsNames(){
        List<WebElement> allSearchedProductsNameTags = driver.findElements(allSearchedproductsNamesTags);
        List<String> searchedProductNames = new ArrayList<>();
        for (WebElement element : allSearchedProductsNameTags){
            searchedProductNames.add(element.getText());
        }
        return searchedProductNames;
    }
    public void hoverOverFirstProduct(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(firstProduct)).perform();
    }
    public void clickAddToCartFromOverlayAfterHover(){
        driver.findElement(addToCartFromOverlayAfterHover).click();
    }
}
