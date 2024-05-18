package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    private WebDriver driver;
    private By getInTouchSentence = By.cssSelector(".contact-form h2");
    private By name = By.cssSelector("[data-qa=\"name\"]");
    private By email = By.cssSelector("[data-qa=\"email\"]");
    private By subject = By.cssSelector("[data-qa=\"subject\"]");
    private By message = By.id("message");
    private By chooseFile = By.name("upload_file");
    private By submit = By.name("submit");
    private By successMessage = By.cssSelector(".status.alert.alert-success");
    private By backToHomeButton = By.cssSelector(".btn.btn-success");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean isGetInTouchDisplayed(){
        return driver.findElement(getInTouchSentence).isDisplayed();
    }
    public void enterName(String Name){
        driver.findElement(name).sendKeys(Name);
    }
    public void enterEmail(String Email){
        driver.findElement(email).sendKeys(Email);
    }
    public void enterSubject(String Subject){
        driver.findElement(subject).sendKeys(Subject);
    }
    public void enterMessage(String Message){
        driver.findElement(message).sendKeys(Message);
    }
    public void uploadFile(String filePath){
        driver.findElement(chooseFile).sendKeys(filePath);
    }
    public void clickSubmitButton(){
        driver.findElement(submit).click();
    }
    public boolean isSuccessMessageDisplayed(){
        return driver.findElement(successMessage).isDisplayed();
    }
    public HomePage clickBackToHomeButton(){
        driver.findElement(backToHomeButton).click();
        return new HomePage(driver);
    }
}
