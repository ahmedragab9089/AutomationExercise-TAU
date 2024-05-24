package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage {
    //This page needs refactor to unify one locator for the products instead of two locators and one function to handle them
    private WebDriver driver;
    private By allProductsParentTag = By.cssSelector(".features_items");
    private By viewFirstProduct = By.cssSelector("[href=\"/product_details/1\"]");
    private By searchProduct = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By searchedProductsSentence = By.xpath("//div[@class=\"features_items\"]/h2[1]");
    private By allSearchedproductsNamesTags = By.xpath("//div[@class=\"features_items\"]/div[@class=\"col-sm-4\"]/div/div/div[1]/p");
    private By allFeaturedProductsNamesTags = By.cssSelector(".col-sm-4  div div div p");
        private By firstProduct = By.xpath("//div[@class=\"features_items\"]/div[@class=\"col-sm-4\"][1]");
    private By secondProduct = By.xpath("//div[@class=\"features_items\"]/div[@class=\"col-sm-4\"][2]");
    private By addFirstProductToCartFromOverlayAfterHover = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a");
    private By addSecondProductToCartFromOverlayAfterHover = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a");
    private By continueShoppingButton = By.cssSelector(".btn.btn-success.close-modal.btn-block");
    private By viewCartAfterAddItemToCart = By.cssSelector(".modal-body a");


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
    public void hoverOverSecondProduct(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(secondProduct)).perform();
    }
    public void clickAddToCartFromOverlayAfterHoverFirstProduct(){
        driver.findElement(addFirstProductToCartFromOverlayAfterHover).click();
    }
    public void clickAddToCartFromOverlayAfterHoverSecondProduct(){
        driver.findElement(addSecondProductToCartFromOverlayAfterHover).click();
    }
    public void clickContinueShoppingButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton)).click();
        //driver.findElement(continueShoppingButton).click();
    }
    public CartPage clickViewCartAfterAddItemToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartAfterAddItemToCart)).click();
        //driver.findElement(viewCartAfterAddItemToCart).click();
        return new CartPage(driver);
    }
//    public List<String> getFirstAndSecondProductsNames(){
//        List<WebElement> featuredProductsNames = driver.findElements(allFeaturedProductsNamesTags);
//        List<String> firstAndSecondProductsNames = new ArrayList<>();
//        if (featuredProductsNames.size() >= 2) {
//            // Add the text of the first and second elements to the list
//            firstAndSecondProductsNames.add(featuredProductsNames.get(0).getText());
//            System.out.println(1);
//            firstAndSecondProductsNames.add(featuredProductsNames.get(2).getText());
//            System.out.println(2);
//        } else {
//            System.out.println("The list does not contain enough elements.");
//        }
//        return firstAndSecondProductsNames;
//    }
}
