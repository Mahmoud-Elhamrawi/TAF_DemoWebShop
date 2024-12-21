package TestCases;

import DriverFacory.DriverFactory;
import Utilities.DataUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static DriverFacory.DriverFactory.getDriver;

public class TC00_TestBase {

    public ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {
        String Browser = System.getProperty("browser") != null ? System.getProperty("browser") : DataUtility.readPropertyFile("ENV", "browser");

        DriverFactory.setupDriver(Browser);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(DataUtility.readPropertyFile("ENV", "HomePage"));
    }


    @AfterMethod
    public void tearDown() {
        DriverFactory.tearDown();
    }

}
