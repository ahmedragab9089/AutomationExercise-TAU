package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By newUserSignupSentence = By.cssSelector(".signup-form h2");
    private By loginToYourAccountSentence = By.cssSelector(".login-form h2");
    private By signupName= By.cssSelector("[data-qa=\"signup-name\"]");
    private By signupMail = By.cssSelector("[data-qa=\"signup-email\"]");
    private By signupButton = By.cssSelector("[data-qa=\"signup-button\"]");
    private By loginEmail = By.cssSelector("[data-qa=\"login-email\"]");
    private By password = By.cssSelector("[data-qa=\"login-password\"]");
    private By loginButton = By.cssSelector("[data-qa=\"login-button\"]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public Boolean isNewUserSignUpDisplayed(){
        return driver.findElement(newUserSignupSentence).isDisplayed();
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
    public boolean isLoginToYourAccountDisplayed(){
        return driver.findElement(loginToYourAccountSentence).isDisplayed();
    }
    public void addLoginEmail(String email){
        driver.findElement(loginEmail).sendKeys(email);
    }
    public void addPassword(String userPassword){
        driver.findElement(password).sendKeys(userPassword);
    }
    public HomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
