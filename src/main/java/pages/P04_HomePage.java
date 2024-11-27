package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P04_HomePage {
    private final WebDriver driver;

    public P04_HomePage(WebDriver driver) {
        this.driver = driver ;
    }

    public boolean assertOnHomePageUrl(String url)
    {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(url));
    }






}
