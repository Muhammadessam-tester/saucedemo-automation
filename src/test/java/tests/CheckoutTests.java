package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTests extends BaseTest {

    private CheckoutPage openCheckout() {
        LoginPage login = new LoginPage(driver);
        login.loginAs("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addItemToCart("Sauce Labs Bike Light");
        inventory.goToCart();
        CartPage cart = new CartPage(driver);
        cart.clickCheckout();
        return new CheckoutPage(driver);
    }

    @Test
    public void completePurchase() {
        CheckoutPage checkout = openCheckout();
        checkout.enterFirstName("Muhammad");
        checkout.enterLastName("Essam");
        checkout.enterZip("12345");
        checkout.clickContinue();
        Assert.assertTrue(checkout.getItemName().contains("Sauce Labs Bike Light"));

        checkout.clickFinish();
        Assert.assertEquals(checkout.getConfirmationMessage(), "Thank you for your order!");
    }

    @Test
    public void missingCheckoutFields() {
        CheckoutPage checkout = openCheckout();
        checkout.clickContinue();
        Assert.assertTrue(checkout.getErrorMessage().contains("First Name is required"));
    }

    @Test
    public void missingLastName() {
        CheckoutPage checkout = openCheckout();
        checkout.fillFields("Muhammad", "", "12345");
        Assert.assertTrue(checkout.getErrorMessage().contains("Last Name is required"));
    }
}
