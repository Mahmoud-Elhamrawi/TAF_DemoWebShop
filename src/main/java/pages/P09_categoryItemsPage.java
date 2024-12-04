package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P09_categoryItemsPage {

    public final WebDriver driver;
    private final By computerLi = By.cssSelector("ul[class=\"top-menu\"] >li >a[href=\"/computers\"]");
    private final By desktopLi = By.xpath("(//a[@href=\"/computers\"]//following-sibling:: ul[contains(@class,'firstLevel')])[1] //li[2]//a");


    public P09_categoryItemsPage(WebDriver driver) {
        this.driver = driver;
    }


    public P10_AddToCartPage moveToProducts() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(computerLi)).perform();
        action.click(driver.findElement(desktopLi)).perform();
        return new P10_AddToCartPage(driver);
    }


    public boolean assertOnDesktopItemsUrl(String url) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(url));
    }

}
