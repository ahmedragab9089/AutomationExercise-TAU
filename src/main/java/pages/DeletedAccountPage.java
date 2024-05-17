package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class DeletedAccountPage {
    private WebDriver driver;
    private By accountDeleted = By.cssSelector("[data-qa=\"account-deleted\"]");
    private By continueButton = By.cssSelector("[data-qa=\"continue-button\"]");

    public DeletedAccountPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean isAccountDeletedDisplayed(){
        return driver.findElement(accountDeleted).isDisplayed();
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
}
