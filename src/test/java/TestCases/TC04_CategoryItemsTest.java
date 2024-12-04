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
import pages.P09_categoryItemsPage;

import java.io.IOException;

import static DriverFacory.DriverFactory.getDriver;

@Listeners({IInvokedListener.class, ITestListener.class})
public class TC04_CategoryItemsTest extends TC00_TestBase {


    @DataProvider
    public Object[] testDataValidLogin() throws IOException, ParseException {
        return classesUtility.readJsonDataLogin("validLogin");

    }


    @Test(dataProvider = "testDataValidLogin", priority = 1)
    public void moveToCategoryItems(String data) {
        //TODO:: login
        String users[] = data.split(",");
        new P01_LandingPage(getDriver()).goToLoginPage();
        Assert.assertTrue(new P01_LandingPage(getDriver()).assertOnLoginPageUrl(DataUtility.readPropertyFile("ENV", "LoginLink")));
        new P06_LoginPage(getDriver()).loginProcess(users[0], users[1]);

        //TODO::go to category page
        new P09_categoryItemsPage(getDriver()).moveToProducts();
        Assert.assertTrue(new P09_categoryItemsPage(getDriver()).assertOnDesktopItemsUrl(DataUtility.readPropertyFile("ENV", "desktopItemsUrl")));
    }

}
