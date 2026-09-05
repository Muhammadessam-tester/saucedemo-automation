package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void validLogin() {
        LoginPage validLog = new LoginPage(driver);
        validLog.loginAs("standard_user", "secret_sauce");

        InventoryPage i1 = new InventoryPage(driver);
        String expectedPageTitle = "Products";
        String actualPageTitle = i1.getPageTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }

    @Test
    public void invalidPassword() {
        LoginPage invalidPass = new LoginPage(driver);
        invalidPass.loginAs("standard_user", "wrong_password");
        Assert.assertTrue(invalidPass.isErrorDisplayed());
    }

    @Test
    public void lockedOutUser() {
        LoginPage lockedOut = new LoginPage(driver);
        lockedOut.loginAs("locked_out_user", "secret_sauce");
        Assert.assertTrue(lockedOut.getErrorMessage().contains("locked out"));
    }

    @Test(dataProvider = "dataTestForLogin")
    public void loginWithDifferentData(String username, String password) {
        LoginPage differentData = new LoginPage(driver);
        differentData.loginAs(username, password);
        Assert.assertTrue(differentData.isErrorDisplayed());
    }

    @DataProvider(name = "dataTestForLogin")
    public Object[][] dataSet() {
        return new Object[][]{
                {"", ""},
                {"standard_user", ""},
                {"", "secret_sauce"},
                {"standard_user", "wrong_password"}
        };
    }
}
