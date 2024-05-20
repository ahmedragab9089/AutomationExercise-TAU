package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By homeURL = By.linkText("Home");
    private By loggedInURL = By.cssSelector(".fa.fa-user");
    private By testCasesButton = By.cssSelector(".test_cases_list button");
    private By footer = By.id("footer");
    private By subscriptionText = By.cssSelector(".single-widget h2");
    private By subscriptionEmail = By.id("susbscribe_email");
    private By subscriptionEmailSendButton = By.id("subscribe");
    private By successSubscriptionMessage = By.cssSelector("#success-subscribe div");

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
        driver.findElement(By.partialLinkText(linkText)).click();
    }
    //click sign up/in button
    public LoginPage clickSignUpInURL(){
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
    public ContactUsPage clickContactUs(){
        clickLink("Contact us");
        return new ContactUsPage(driver);
    }
    public ProductsPage clickProductsUrl(){
        clickLink("Products");
        return new ProductsPage(driver);
    }
    public TestCasesPage clickTestCasesButton(){
        driver.findElement(testCasesButton).click();
        return new TestCasesPage(driver);
    }
    public void scrollToFooter(){
        WebElement footerEle = driver.findElement(footer);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down to the footer
        js.executeScript("arguments[0].scrollIntoView(true);", footerEle);
    }
    public boolean isSubscriptionTextDisplayed(){
        return driver.findElement(subscriptionText).isDisplayed();
    }
    public void enterSubscriptionEmail(String email){
        driver.findElement(subscriptionEmail).sendKeys(email);
    }
    public void clickSubscriptionEmailSendButton(){
        driver.findElement(subscriptionEmailSendButton).click();
    }
    public String getSuccessSubscriptionMessage(){
        return driver.findElement(successSubscriptionMessage).getText();
    }


}
