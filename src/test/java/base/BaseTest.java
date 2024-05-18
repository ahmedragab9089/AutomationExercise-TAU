package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignupPage;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected SoftAssert softAssert;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
    }

//    @AfterClass
//    public void quitBrowser(){
//        driver.quit();
//    }

    //Method to register a user without deleting him as we delete the user in some test cases such as test case 1 and 2
    public void registerUserAndDoNotDeleteHim(){
        //4. Click on 'Signup / Login' button
        LoginPage loginPage = homePage.clickSignUpInURL();
        //5. Verify 'New User Signup!' is visible
        //6. Enter name and email address
        loginPage.addSignupName("Ahmed Ragab");
        loginPage.addSignupMail("ahmedragab9089@gmail.com");
        //7. Click 'Signup' button
        SignupPage signupPage = loginPage.clickSignupButton();
        //9. Fill details: Title, Name, Email, Password, Date of birth
        signupPage.selectTtileMr();
        signupPage.enterPassword("123456");
        signupPage.selectBirthDay("1");
        signupPage.selectBirthMonth("3");
        signupPage.selectBirthYear("1990");
        //10. Select checkbox 'Sign up for our newsletter!'
        signupPage.signUpforNewsLetter();
        //11. Select checkbox 'Receive special offers from our partners!'
        signupPage.receiveOffers();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        signupPage.enterFirstName("Ahmed");
        signupPage.enterLastName("Ragab");
        signupPage.enterCompany("Personal");
        signupPage.enterAddress("India");
        signupPage.selectCountry("India");
        signupPage.enterState("New Delhi");
        signupPage.enterCity("New Delhi");
        signupPage.enterZipCode("12345");
        signupPage.enterMobileNumber("01277410198");
        //13. Click 'Create Account button'
        AccountCreatedPage accountCreatedPage = signupPage.clickCreateAccount();
        //15. Click 'Continue' button
        accountCreatedPage.clickContinueButton();
        homePage.clickLogoutUrl();
        driver.get("https://automationexercise.com/");
    }
}
