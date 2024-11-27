package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class classesUtility {

    //TODO::click on Ele
    public static void clickOnEle(WebDriver driver, By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
       driver.findElement(locator).click();
    }

    //TODO::Enter text
       public static void enterText(WebDriver driver , By locator , String text)
       {
           new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
           driver.findElement(locator).sendKeys(text);
       }

    //TODO::get text from ele
    public static String getText(WebDriver driver , By locator)
    {
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    //TODO:: scrolling
    public static void  scroll(WebDriver driver , By locator)
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));
    }

    //TODO::  select option
    public static void selectOption(WebDriver driver , By locator, String value)
    {
        new Select(driver.findElement(locator)).selectByValue(value);
    }


    //TODO:: timeStamp
    public static String timeStamp()
    {
        return new SimpleDateFormat("yyyy-MM-dd  h-m-ssa").format(new Date());
    }

    //TODO:: take screenshot
    public static final String filePath = "test-outputs/screenShots/";
    public static void takeScreenShot(WebDriver driver, String screenName)
    {
        try {
            File screenSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File screenDis = new File(filePath+screenName+"_"+timeStamp()+".png");
            FileUtils.copyFile(screenSrc,screenDis);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }




}
