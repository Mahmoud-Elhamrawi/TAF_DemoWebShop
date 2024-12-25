package pages;

import Utilities.classesUtility;
import Utilities.logUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class P10_AddToCartPage {


    public static String price;
    private static List<WebElement> allProducts;
    public final WebDriver driver;
    private final By btnAddToCart = By.xpath("//input[contains(@class,'product-box-add-to-cart-button')]");
    private final By cartIcon = By.cssSelector("span[class=\"cart-qty\"]");
    private final By notificationMsg = By.cssSelector("div[id=\"bar-notification\"] p");
    private final By shoppingCartLink = By.cssSelector("li[id=\"topcartlink\"] span:nth-of-type(1)");
    private final By itemPrice = By.cssSelector("span[class=\"price actual-price\"]");

    public P10_AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public P10_AddToCartPage clickOnAddProductsBtn() throws IOException {
        allProducts = driver.findElements(btnAddToCart);//size 1

        for (int i = 1; i <= allProducts.size(); i++) {
            By AddProducts = By.xpath("(//input[contains(@class,'product-box-add-to-cart-button')])[" + i + "]");
            classesUtility.clickOnEle(driver, AddProducts);
        }

        return this;
    }

    public String getCountOnCartIcon() {
        try {
            logUtility.info("cart number :" + " " + classesUtility.getText(driver, cartIcon));
            return classesUtility.getText(driver, cartIcon);
        } catch (Exception e) {
            logUtility.error(e.getMessage());
            return "0";
        }
    }

    // get item price from the item
    public String getItemPriceFromItemSelected() {
        price = classesUtility.getText(driver, itemPrice);
        return price;
    }


    //assert on message added
    public String getNotificationMsg() {
        return driver.findElement(notificationMsg).getText();
    }


    //go to cart page
    public P11_CartPage goToCartPage() {
        classesUtility.clickOnEle(driver, shoppingCartLink);
        return new P11_CartPage(driver);
    }


    //assert on cart page
    public boolean assertOnCartPage(String expectUrl) {
        return driver.getCurrentUrl().contains(expectUrl);
    }

}
