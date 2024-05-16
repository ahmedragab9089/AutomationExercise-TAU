package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    private WebDriver driver;
    private By enterAccountInfo = By.cssSelector(".login-form > .title.text-center");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }
    public Boolean isEnterAccountInfoVisible(){
        return driver.findElement(enterAccountInfo).isDisplayed();
    }
}
