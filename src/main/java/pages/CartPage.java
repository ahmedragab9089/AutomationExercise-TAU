package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private By productsTableRow =By.xpath("//tbody/tr");
    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    public int getNumberofProductsInCart(){
        return driver.findElements(productsTableRow).size();
    }
}
