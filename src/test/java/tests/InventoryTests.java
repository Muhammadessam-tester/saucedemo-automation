package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTests extends BaseTest {
    @Test
    public void itemCount() {
        login();
        InventoryPage ip1 = new InventoryPage(driver);
        Assert.assertEquals(ip1.getItemCount(), 6);
    }

    @Test
    public void sortProducts() {
       login();
        InventoryPage ip2 = new InventoryPage(driver);
        ip2.sortProducts("Price (low to high)");
        Assert.assertEquals(ip2.getSelectedSort(), "Price (low to high)");
    }

    @Test
    public void addItemToCartUpdatesBadge() {
        LoginPage validLog = new LoginPage(driver);
        validLog.loginAs("standard_user", "secret_sauce");
        InventoryPage ip3 = new InventoryPage(driver);
        ip3.addItemToCart("Sauce Labs Bike Light");
        Assert.assertEquals(ip3.getCartItemCount(), 1);
    }
}
