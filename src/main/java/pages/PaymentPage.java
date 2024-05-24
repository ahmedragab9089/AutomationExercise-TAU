package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {
    private WebDriver driver;
    private By nameOnCard = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    private By cvc = By.name("cvc");
    private By expirationMonth = By.name("expiry_month");
    private By expirationYear = By.name("expiry_year");
    private By payAndConfirmYourCard = By.id("submit");
    private By successMessage = By.id("success_message");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }
    public void fillNameONCard(String data){
        driver.findElement(nameOnCard).sendKeys(data);
    }
    public void fillCardNumber(String data){
        driver.findElement(cardNumber).sendKeys(data);
    }
    public void fillCVC(){
        driver.findElement(cvc).sendKeys("311");
    }
    public void fillExpirationMonth(String data){
        driver.findElement(expirationMonth).sendKeys(data);
    }
    public void fillExpirationYear(String data){
        driver.findElement(expirationYear).sendKeys(data);
    }
    public PaymentDonePage clickPayAndConfirmOrderButton(){
        driver.findElement(payAndConfirmYourCard).click();
        return new PaymentDonePage(driver);
    }
    public boolean isSuccessMessageDisplayed(){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(50)) // Reduce the polling interval to 100 milliseconds
                .ignoring(NoSuchElementException.class);


        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement successMessageEle =  wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return successMessageEle.isDisplayed();
    }
}
