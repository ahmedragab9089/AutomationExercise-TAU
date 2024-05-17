package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {
    private WebDriver driver;
    private By enterAccountInfo = By.cssSelector(".login-form > .title.text-center");
    private By titleMr = By.id("id_gender1");
    private By titleMrs = By.id("uniform-id_gender2");
    private By password = By.id("password");
    private By birthDay = By.id("days");
    private By birthMonth = By.id("months");
    private By birthYear = By.id("years");
    private By signUpforNewsLetter = By.id("newsletter");
    private By receiveOffers = By.id("optin");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By company = By.id("company");
    private By address = By.id("address1");
    private By country = By.id("country");
    private By state = By.id("state");


    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }
    public Boolean isEnterAccountInfoVisible(){
        return driver.findElement(enterAccountInfo).isDisplayed();
    }
    public void selectTtileMr(){
        driver.findElement(titleMr).click();
    }
    public void selectTitleMrs(){
        driver.findElement(titleMrs).click();
    }
    public void setPassword(String userPassword){
        driver.findElement(password).sendKeys(userPassword);
    }
    public void selectBirthDay(String value){
        Select birthDayEle = new Select(driver.findElement(birthDay));
        birthDayEle.selectByValue(value);
    }
    public void selectBirthMonth(String value){
        Select birthDayEle = new Select(driver.findElement(birthMonth));
        birthDayEle.selectByValue(value);
    }
    public void selectBirthYear(String value){
        Select birthDayEle = new Select(driver.findElement(birthYear));
        birthDayEle.selectByValue(value);
    }
    public void signUpforNewsLetter(){
        driver.findElement(signUpforNewsLetter).click();
    }
    public void receiveOffers(){
        driver.findElement(receiveOffers).click();
    }
    public void setFirstName(String name){
        driver.findElement(firstName).sendKeys(name);
    }
    public void setLastName(String name){
        driver.findElement(lastName).sendKeys(name);
    }
    public void setCompany(String companyName){
        driver.findElement(company).sendKeys(companyName);
    }
    public void setAddress(String addressValue){
        driver.findElement(address).sendKeys(addressValue);
    }
    public void setCountry(String countryName){
        Select countryfield = new Select(driver.findElement(country));
        countryfield.selectByVisibleText(countryName);
    }
}
