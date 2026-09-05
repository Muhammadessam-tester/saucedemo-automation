package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By currentItems = By.cssSelector(".inventory_item_name");
    private By checkOutBtn = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getItemCount(){
       return driver.findElements(currentItems).size();
    }

    public void clickCheckout(){
        driver.findElement(checkOutBtn).click();
    }
}
