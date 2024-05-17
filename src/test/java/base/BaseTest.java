package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

public class BaseTest {
    private WebDriver driver;
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
}
