package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //Method to call when pressing the links in homepage such as products, sign, cart page
    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    //click sign up/in button
    public SignUpInPage clickSignUpInButton(){
        clickLink(" Signup / Login");
        return new SignUpInPage(driver);
    }
}
