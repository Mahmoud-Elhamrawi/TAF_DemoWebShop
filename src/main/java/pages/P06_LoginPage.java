package pages;

import Utilities.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_LoginPage {
    public final WebDriver driver;

    public P06_LoginPage(WebDriver driver) {
        this.driver = driver ;
    }


    private final By emailInp = By.id("Email");
    private final By passInp = By.id("Password");
    private final By loginBtn = By.cssSelector("input[value=\"Log in\"]");


    public P05_LogOutPage loginProcess(String em , String pass)
    {
        classesUtility.enterText(driver,emailInp,em);
        classesUtility.enterText(driver,passInp,pass);
        classesUtility.clickOnEle(driver,loginBtn);

        return new P05_LogOutPage(driver);
    }




}
