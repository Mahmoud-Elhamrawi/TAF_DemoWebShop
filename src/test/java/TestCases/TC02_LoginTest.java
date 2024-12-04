package TestCases;

import Listeners.IInvokedListener;
import Listeners.ITestListener;
import Utilities.DataUtility;
import Utilities.classesUtility;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.P01_LandingPage;
import pages.P06_LoginPage;

import java.io.IOException;

import static DriverFacory.DriverFactory.getDriver;

@Listeners({IInvokedListener.class, ITestListener.class})
public class TC02_LoginTest extends TC00_TestBase {

    @DataProvider
    public Object[] testDataValidLogin() throws IOException, ParseException {
        return classesUtility.readJsonDataLogin("validLogin");

    }


    @Test(dataProvider = "testDataValidLogin", priority = 1)
    public void validLoginTC(String data) {
        String users[] = data.split(",");
        new P01_LandingPage(getDriver()).goToLoginPage();
        Assert.assertTrue(new P01_LandingPage(getDriver()).assertOnLoginPageUrl(DataUtility.readPropertyFile("ENV", "LoginLink")));

        new P06_LoginPage(getDriver()).loginProcess(users[0], users[1]);

    }


    @DataProvider
    public Object[] testDataInValidLogin() throws IOException, ParseException {
        return classesUtility.readJsonDataLogin("invalidLogin");

    }

    @Test(dataProvider = "testDataInValidLogin", priority = 2)
    public void invalidLoginTC(String data) {
        String users[] = data.split(",");
        new P01_LandingPage(getDriver()).goToLoginPage();
        Assert.assertTrue(new P01_LandingPage(getDriver()).assertOnLoginPageUrl(DataUtility.readPropertyFile("ENV", "LoginLink")));

        new P06_LoginPage(getDriver()).loginProcess(users[0], users[1]);

    }


}
