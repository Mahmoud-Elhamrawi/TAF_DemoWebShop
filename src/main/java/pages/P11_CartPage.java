package pages;

import Utilities.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P11_CartPage {
    public final WebDriver driver;
    private final By nameOfProd = By.cssSelector("a[class=\"product-name\"]");
    private final By unitPrice = By.cssSelector("span[class=\"product-unit-price\"]");
    private final By totalPrice = By.cssSelector("span[class=\"product-subtotal\"]");
    private final By inpQuantityPrice = By.cssSelector("span[class=\"product-unit-price\"]");
    private final By InpQuantityPriceAfter = By.cssSelector("span[class=\"product-subtotal\"]");
    private final By checkBoxRemove = By.cssSelector("input[name=\"removefromcart\"]");
    private final By updateQuantityBtn = By.cssSelector("div[class=\"common-buttons\"] input:nth-of-type(1)");
    //get---> name +q  +unit price + total price
    private final By emptyCartText = By.cssSelector("div[class=\"page-body\"] div");
    private final By itemQuantity = By.cssSelector("input[class=\"qty-input\"]");
    private final By checkoutBtn = By.id("checkout");
    private final By termsOfServiceCheckBox = By.id("termsofservice");

    public P11_CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getTotalPrice() {
        return totalPrice;
    }


    public By getUnitPrice() {
        return unitPrice;
    }

    public By getNameOfProd() {
        return nameOfProd;
    }

    public P11_CartPage removingCartPage() {
        classesUtility.clickOnEle(driver, checkBoxRemove);
        classesUtility.clickOnEle(driver, updateQuantityBtn);
        return this;
    }

    public String assertOnTextEmpty() {
        return classesUtility.getText(driver, emptyCartText);
    }

    public P11_CartPage changeQuantity(String quantity) {
        classesUtility.removeText(driver, itemQuantity);
        classesUtility.enterText(driver, itemQuantity, quantity);
        classesUtility.clickOnEle(driver, updateQuantityBtn);
        return this;
    }

    public String getItemUnitPriceFromCartPage() {
        return driver.findElement(inpQuantityPrice).getText();
    }

    public String getItemTotalPriceFromCartPage() {
        return driver.findElement(InpQuantityPriceAfter).getText();
    }

    public P12_BillingAddressPage goToBillingAddress() {
        classesUtility.scroll(driver, checkoutBtn);
        classesUtility.clickOnEle(driver, termsOfServiceCheckBox);
        classesUtility.clickOnEle(driver, checkoutBtn);

        return new P12_BillingAddressPage(driver);
    }

    public boolean assertOnUrlCheckOut(String expectUrl) {
        return driver.getCurrentUrl().contains(expectUrl);
    }


}
