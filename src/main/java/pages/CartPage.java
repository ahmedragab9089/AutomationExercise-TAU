package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private By productsTableRow =By.xpath("//tbody/tr");
    private By proceedToCheckout = By.cssSelector(".col-sm-6 a");
    private By registerLoginUrlInPopup = By.cssSelector(".modal-body a");
    private By removeItemFromCart = By.cssSelector(".cart_quantity_delete");
    private By cartIsEmptySentence = By.id("empty_cart");
    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    public int getNumberofProductsInCart(){
        return driver.findElements(productsTableRow).size();
    }
    public CheckoutPage clickProceedToCheckoutButton(){
        driver.findElement(proceedToCheckout).click();
        return new CheckoutPage(driver);
    }
    public LoginPage clickRegisterLoginButton(){
        driver.findElement(registerLoginUrlInPopup).click();
        return new LoginPage(driver);
    }
    public void clickRemoveItemFromCartButton(){
        driver.findElement(removeItemFromCart).click();
    }
    public boolean isCartIsEmptySentenceDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartIsEmptySentence)).isDisplayed();
        //return driver.findElement(cartIsEmptySentence).isDisplayed();
    }

}
