package pages;

import Utilities.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P12_BillingAddressPage {
    public final WebDriver driver;
    private final By continueBillingBtn = By.cssSelector("div[id=\"billing-buttons-container\"] input");
    private final By continueBillingBtnAdd2 = By.cssSelector("div[id=\"shipping-buttons-container\"] input");
    private final By continueShippingBtn = By.cssSelector("div[id=\"shipping-method-buttons-container\"] input");
    private final By paymentMethodContinueBtn = By.cssSelector("div[id=\"payment-method-buttons-container\"] input");
    private final By paymentInfoContinueBtn = By.cssSelector("div[id=\"payment-info-buttons-container\"] input");
    private final By confirmationBtn = By.cssSelector("div[id=\"confirm-order-buttons-container\"] input");
    private final By confirmText = By.cssSelector("div[class=\"title\"] strong");
    private final By continueBtn = By.cssSelector("input[value=\"Continue\"]");


    public P12_BillingAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPriceUnitCheck() {
        return driver.findElement(new P11_CartPage(driver).getUnitPrice()).getText();
    }

    public String getPriceTotalCheck() {
        return driver.findElement(new P11_CartPage(driver).getTotalPrice()).getText();
    }

    public String getProdNameCheck() {
        return driver.findElement(new P11_CartPage(driver).getNameOfProd()).getText();
    }

    //billing address
    public P12_BillingAddressPage selectBillingAdd() {
        classesUtility.clickOnEle(driver, continueBillingBtn);
        return this;
    }

    //Shipping address
    public P12_BillingAddressPage shippingAddress() {
        classesUtility.clickOnEle(driver, continueBillingBtnAdd2);
        return this;
    }

    //Shipping method
    public P12_BillingAddressPage shippingMethod() {
        classesUtility.clickOnEle(driver, continueShippingBtn);
        return this;
    }

    //Payment method
    public P12_BillingAddressPage paymentMethod() {
        classesUtility.clickOnEle(driver, paymentMethodContinueBtn);
        return this;
    }

    //Payment information
    public P12_BillingAddressPage paymentInfo() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(paymentInfoContinueBtn));
        classesUtility.clickOnEle(driver, paymentInfoContinueBtn);
        return this;
    }

    //Confirm order
    public P12_BillingAddressPage confirmOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(confirmationBtn));
        classesUtility.clickOnEle(driver, confirmationBtn);
        return this;
    }


    //Assert on url
    public boolean assertOnUrlCompleteOrder(String expectUrl) {
        //   new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/checkout/completed"));
        return driver.getCurrentUrl().contains(expectUrl);
    }


    //Assert on confirm text
    public String assertOnConfirmText() {
        return driver.findElement(confirmText).getText();
    }


    public P04_HomePage continueOrder() {
        classesUtility.clickOnEle(driver, continueBtn);
        return new P04_HomePage(driver);
    }


}
