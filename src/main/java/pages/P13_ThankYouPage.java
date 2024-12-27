package pages;

import Utilities.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P13_ThankYouPage {

    private final WebDriver driver;
    private final By confirmText = By.cssSelector("div[class=\"title\"] strong");
    private final By continueBtn = By.cssSelector("input[value=\"Continue\"]");

    public P13_ThankYouPage(WebDriver driver) {
        this.driver = driver;
    }

    //Assert on url

    // https://demowebshop.tricentis.com/checkout/completed/
    public boolean assertOnUrlCompleteOrder(String expectUrl) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/checkout/completed/"));
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
