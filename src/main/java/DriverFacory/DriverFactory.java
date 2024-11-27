package DriverFacory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {


public static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();


public static void setupDriver(String browser)
{

    switch (browser.toLowerCase())
    {
        case "chrome":
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized") ;
            threadLocal.set(new ChromeDriver(chromeOptions));
            break;
        case "firefox":
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--start-maximized");
            threadLocal.set(new FirefoxDriver(firefoxOptions));
            break;
        default:
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("start-maximized");
            threadLocal.set(new EdgeDriver(edgeOptions));
    }

}

public static WebDriver getDriver()
{
    return threadLocal.get();
}


public static void tearDown()
{
    getDriver().quit();
    threadLocal.remove();
}



}
