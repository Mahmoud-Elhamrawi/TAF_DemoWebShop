package pages;

import Utilities.classesUtility;
import Utilities.logUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P10_AddToCartPage {


    private static List<WebElement> allProducts;
    public final WebDriver driver;
    private final By btnAddToCart = By.xpath("//input[contains(@class,'product-box-add-to-cart-button')]");
    private final By cartIcon = By.cssSelector("span[class=\"cart-qty\"]");

    //(//input[contains(@class,'product-box-add-to-cart-button')])[2]
    public P10_AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    ////input[contains(@class,'product-box-add-to-cart-button')]
    public P10_AddToCartPage clickOnAddProductsBtn() {
        allProducts = driver.findElements(btnAddToCart);//size 1
        logUtility.info("size :" + allProducts);
        for (int i = 1; i <= allProducts.size(); i++) {
            By AddProducts = By.xpath("(//input[contains(@class,'product-box-add-to-cart-button')])[" + i + "]");
            classesUtility.clickOnEle(driver, AddProducts);
        }

        return this;
    }

    public String getCountOnCartIcon() {
        try {
            logUtility.info("cart number :" + classesUtility.getText(driver, cartIcon));
            return classesUtility.getText(driver, cartIcon);
        } catch (Exception e) {
            logUtility.error(e.getMessage());
            return "0";
        }
    }

}
