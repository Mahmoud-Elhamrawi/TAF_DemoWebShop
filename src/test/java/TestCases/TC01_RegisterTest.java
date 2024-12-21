package TestCases;

import DriverFacory.DriverFactory;
import Listeners.IInvokedListener;
import Listeners.ITestListener;
import Utilities.DataUtility;
import Utilities.classesUtility;
import Utilities.logUtility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.time.Duration;

import static DriverFacory.DriverFactory.getDriver;

@Listeners({IInvokedListener.class, ITestListener.class})
public class TC01_RegisterTest {

    String fName = DataUtility.readJsonFile("registerData", "fName");
    String lName = DataUtility.readJsonFile("registerData", "lName");
    String email = classesUtility.timeStamp() + DataUtility.readJsonFile("registerData", "email");
    String password = DataUtility.readJsonFile("registerData", "password");
    String cpassword = DataUtility.readJsonFile("registerData", "cpassword");

    @BeforeMethod
    public void setUp() {
        DriverFactory.setupDriver("chrome");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(DataUtility.readPropertyFile("ENV", "HomePage"));
    }

    @Test
    public void registerTC() throws IOException {

        new P01_LandingPage(getDriver()).goToRegisterPage();
        logUtility.info("register page opening....");
        Assert.assertTrue(new P01_LandingPage(getDriver()).assertOnRegisterPage(DataUtility.readPropertyFile("ENV", "RegisterPage")));

        new P02_RegisterPage(getDriver()).registerProcess("female", fName, lName, email, password, cpassword);
        new P03_ConfirmRegisterPage(getDriver()).assertOnConfirmRegisterUrl(DataUtility.readPropertyFile("ENV", "ConfirmRegister"));
        new P03_ConfirmRegisterPage(getDriver()).assertOnConfirmRegisterText(DataUtility.readPropertyFile("ENV", "textConfirm"));

        new P03_ConfirmRegisterPage(getDriver()).clickOnContinueBtn();

        new P04_HomePage(getDriver()).assertOnHomePageUrl(DataUtility.readPropertyFile("ENV", "HomePage"));
        logUtility.info("Home page opening....");

        new P05_LogOutPage(getDriver()).clickOnLogout();
        new P04_HomePage(getDriver()).assertOnHomePageUrl(DataUtility.readPropertyFile("ENV", "HomePage"));


    }


    @AfterMethod
    public void tearDown() {
        DriverFactory.tearDown();
    }


}
