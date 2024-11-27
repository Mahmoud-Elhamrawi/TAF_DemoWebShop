package pages;

import Utilities.classesUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P02_RegisterPage {

    private final WebDriver driver;

    public P02_RegisterPage(WebDriver driver)
    {
        this.driver=driver;
    }


    public By genderType(String type)
    {
        return  By.xpath("//input[@id=\"gender-"+type+"\"]") ;
    }

    private final By firstNameInp=By.id("FirstName");
    private final By lastNameInp = By.id("LastName");
    private final By emailInp =By.id("Email");
    private final By passwordInp = By.id("Password");
    private final By confirmPasswordInp = By.id("ConfirmPassword");
    private final By registerBtn = By.id("register-button");

    public P03_ConfirmRegisterPage registerProcess(String type , String fName, String LName , String email , String pass , String CPass)
    {

        classesUtility.clickOnEle(driver,genderType(type));
        classesUtility.enterText(driver,firstNameInp,fName);
        classesUtility.enterText(driver,lastNameInp,LName);
        classesUtility.enterText(driver,emailInp,email);
        classesUtility.enterText(driver,passwordInp,pass);
        classesUtility.enterText(driver,confirmPasswordInp,CPass);
        classesUtility.clickOnEle(driver,registerBtn);

        return new P03_ConfirmRegisterPage(driver);
    }

}
