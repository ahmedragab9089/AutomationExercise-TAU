package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By homeURL = By.linkText("Home");
    private By loggedInURL = By.cssSelector(".fa.fa-user");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //Method to get the color of home URL
    public String getHomeUrlColor(){
        WebElement homeURLEle = driver.findElement(homeURL);
        return homeURLEle.getAttribute("style");
    }

    //Method to call when pressing the links in homepage such as products, sign, cart page
    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
    //click sign up/in button
    public LoginPage clickSignUpInButton(){
        clickLink("Signup / Login");
        return new LoginPage(driver);
    }
    public boolean isLoggedInAsUsernameDisplayed(){
        return driver.findElement(loggedInURL).isDisplayed();
    }
    public DeletedAccountPage clickDeleteAccount(){
        clickLink("Delete Account");
        return new DeletedAccountPage(driver);
    }
    public LoginPage clickLogoutUrl(){
        clickLink("Logout");
        return new LoginPage(driver);
    }
}
