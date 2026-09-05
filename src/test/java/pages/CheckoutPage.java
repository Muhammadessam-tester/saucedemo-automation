package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipField = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By finishMessage = By.cssSelector(".complete-header");
    private By errorMessage = By.cssSelector(".error-message-container");
    private By itemName = By.cssSelector(".inventory_item_name");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String first) {
        driver.findElement(firstNameField).sendKeys(first);
    }

    public void enterLastName(String last) {
        driver.findElement(lastNameField).sendKeys(last);
    }

    public void enterZip(String zip) {
        driver.findElement(zipField).sendKeys(zip);
    }

    public void fillFields(String first, String last, String zip) {
        enterFirstName(first);
        enterLastName(last);
        enterZip(zip);
        clickContinue();
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public void clickFinish() {
        driver.findElement(finishBtn).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(finishMessage).getText();
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
