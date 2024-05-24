package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;
    private By descriptionField = By.cssSelector(".form-control");
    private By placeOrderButton = By.cssSelector(".btn.btn-default.check_out");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void fillDescription(String description){
        driver.findElement(descriptionField).sendKeys(description);
    }
    public PaymentPage clickPlaceOrderButton(){
        driver.findElement(placeOrderButton).click();
        return new PaymentPage(driver);
    }
}
