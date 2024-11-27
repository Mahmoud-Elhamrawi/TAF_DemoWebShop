package pages;

import Utilities.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P03_ConfirmRegisterPage {
    private final WebDriver driver;

    public P03_ConfirmRegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By assertText = By.xpath("//div[@class=\"result\"]");
    private final By continueBtn = By.xpath("//input[@value=\"Continue\"]");

    public boolean assertOnConfirmRegisterUrl(String expectUrl)
    {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(expectUrl));
    }

    public boolean assertOnConfirmRegisterText(String text)
    {
        return driver.findElement(assertText).getText().contains(text);
    }

    public  P04_HomePage clickOnContinueBtn()
    {
        classesUtility.clickOnEle(driver,continueBtn);
        return new P04_HomePage(driver);
    }


}
