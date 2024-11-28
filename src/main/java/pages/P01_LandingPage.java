package pages;

import Utilities.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P01_LandingPage {

public WebDriver driver ;

public P01_LandingPage(WebDriver driver)
{
    this.driver=driver;
}


private final By registerLink = By.linkText("Register");
private  final By loginKink = By.linkText("Log in");

public P01_LandingPage goToRegisterPage()
{
    classesUtility.clickOnEle(driver,registerLink);
    return this;
}

public P06_LoginPage goToLoginPage()
{
    classesUtility.clickOnEle(driver,loginKink);
    return new P06_LoginPage(driver);
}


    public boolean assertOnLoginPageUrl(String url)
{
    return new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(url));
}

public boolean assertOnRegisterPage(String expectUrl)
{
    return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(expectUrl));
}









}
