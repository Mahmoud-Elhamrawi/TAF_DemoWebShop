package pages;

import Utilities.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P08_ProductDetails {
    private final WebDriver driver;
    private final By assertText = By.className("current-item");
    private final By assertTextNotFound = By.cssSelector("div[class=\"search-results\"] strong");

    public P08_ProductDetails(WebDriver driver) {
        this.driver = driver;
    }


    public String assertOnTextNotFound() {
        return classesUtility.getText(driver, assertTextNotFound);
    }


    public boolean asserOnProdDetailsUrl(String expectUrl) {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.urlToBe(expectUrl));
    }

    public String assertOnText() {
        return classesUtility.getText(driver, assertText).toUpperCase();
    }


}
