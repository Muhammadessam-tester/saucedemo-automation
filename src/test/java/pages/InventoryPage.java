package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    private WebDriver driver;

    private By pageTitle = By.cssSelector(".title");
    private By cartIcon = By.cssSelector(".shopping_cart_link");
    private By inventoryItems = By.cssSelector(".inventory_item_name");
    private By sort = By.cssSelector(".product_sort_container");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public int getItemCount() {
        return driver.findElements(inventoryItems).size();
    }

    public void addItemToCart(String itemName) {
        String buttonId = "add-to-cart-" + itemName.toLowerCase().replace(" ", "-");
        driver.findElement(By.id(buttonId)).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public void sortProducts(String option) {
        Select select = new Select(driver.findElement(sort));
        select.selectByVisibleText(option);
    }

    public String getSelectedSort() {
        Select select = new Select(driver.findElement(sort));
        return select.getFirstSelectedOption().getText();
    }

    public int getCartItemCount() {
        return Integer.parseInt(driver.findElement(cartBadge).getText());
    }
}
