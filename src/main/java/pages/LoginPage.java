package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By newUserSignup = By.cssSelector(".signup-form h2");
    private By signupName= By.cssSelector("[data-qa=\"signup-name\"]");
    private By signupMail = By.cssSelector("[data-qa=\"signup-email\"]");
    private By signupButton = By.cssSelector("[data-qa=\"signup-button\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public Boolean isNewUserSignUpDisplayed(){
        return driver.findElement(newUserSignup).isDisplayed();
    }
    public void addSignupName(String name){
        driver.findElement(signupName).sendKeys(name);
    }
    public void addSignupMail(String mail){
        driver.findElement(signupMail).sendKeys(mail);
    }
    public SignupPage clickSignupButton(){
        driver.findElement(signupButton).click();
        return new SignupPage(driver);
    }
}
