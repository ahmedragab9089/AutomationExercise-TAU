package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
    private WebDriver driver;
    private By accountCreatedStatement = By.cssSelector("[data-qa=\"account-created\"]");
    private By continueButton = By.cssSelector(".btn.btn-primary");

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isAccountCreatedDisplayed(){
        return driver.findElement(accountCreatedStatement).isDisplayed();
    }
    public HomePage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }
}
