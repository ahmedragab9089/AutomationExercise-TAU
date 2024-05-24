package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private By productsTableRow =By.xpath("//tbody/tr");
    private By proceedToCheckout = By.cssSelector(".col-sm-6 a");
    private By registerLoginUrlInPopup = By.cssSelector(".modal-body a");
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

}
