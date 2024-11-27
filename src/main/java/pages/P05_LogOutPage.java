package pages;

import Utilities.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_LogOutPage {

    private final WebDriver driver;

    public P05_LogOutPage(WebDriver driver)
    {
        this.driver = driver ;
    }

    private final By logoutBtn =  By.linkText("Log out");


    public P04_HomePage clickOnLogout()
    {
        classesUtility.clickOnEle(driver,logoutBtn);
        return new P04_HomePage(driver);
    }




}
