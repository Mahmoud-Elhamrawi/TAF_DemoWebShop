package Utilities;


import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class classesUtility {

    //TODO:: take screenshot
    public static final String filePath = "test-outputs/screenShots/";
    //TODO::read data from array of json
    String validLogin = "validLogin";

    //TODO::click on Ele
    public static void clickOnEle(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    //TODO::Enter text
    public static void enterText(WebDriver driver, By locator, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }

    //TODO::get text from ele
    public static String getText(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    //TODO:: scrolling
    public static void scroll(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    //TODO::  select option
    public static void selectOption(WebDriver driver, By locator, String value) {
        new Select(driver.findElement(locator)).selectByValue(value);
    }

    //TODO:: timeStamp
    public static String timeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd-h-m-ssa").format(new Date());
    }

    public static void takeScreenShot(WebDriver driver, String screenName) {
        try {
            File screenSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File screenDis = new File(filePath + screenName + "_" + timeStamp() + ".png");
            FileUtils.copyFile(screenSrc, screenDis);
            Allure.addAttachment(screenName, Files.newInputStream(Path.of(screenDis.getPath())));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String[] readJsonFile(String status) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/resources/testData/loginData.json");
        Object object = jsonParser.parse(reader);
        JSONObject jsonObject = (JSONObject) object;
        JSONArray jsonArray = (JSONArray) jsonObject.get(status);

        String arr[] = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject users = (JSONObject) jsonArray.get(i);
            String email = (String) users.get("email");
            String pass = (String) users.get("password");
            arr[i] = email + "," + pass;

        }
        return arr;

    }


    public static String[] readJsonDataLogin(String status) throws IOException, ParseException {
        return readJsonFile(status);
    }


    //ToDO:: all logs in allure report
    public static File getLatestFile(String logPath) {
        File folder = new File(logPath);
        File[] files = folder.listFiles();
        if (files.length == 0)
            return null;
        Arrays.sort(files, Comparator.comparing(File::lastModified).reversed());
        return files[0];

    }

}
