package TestCases;

import Listeners.IInvokedListener;
import Listeners.ITestListener;
import Utilities.DataUtility;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.P07_SearchPage;
import pages.P08_ProductDetails;

import static DriverFacory.DriverFactory.getDriver;

@Listeners({IInvokedListener.class, ITestListener.class})
public class TC03_SearchTest extends TC00_TestBase {


    @Test(priority = 1)
    public void validSearchTC() {
        new P07_SearchPage(getDriver())
                .enterTextForSearch(DataUtility.readPropertyFile("ENV", "searchText"))
                .clickOnOption();

        Assert.assertTrue(new P08_ProductDetails(getDriver()).asserOnProdDetailsUrl(DataUtility.readPropertyFile("ENV", "productDetailsURL")));
        Assert.assertEquals(new P08_ProductDetails(getDriver()).assertOnText(), "HEALTH BOOK", "Health Book is the text");
    }

    @Test(priority = 2)
    public void inValidSearchTC() {
        new P07_SearchPage(getDriver())
                .enterTextForSearch(DataUtility.readPropertyFile("ENV", "inValidSearchText"))
                .clickOnSearchBtnSubmit();

        Assert.assertTrue(new P08_ProductDetails(getDriver()).assertOnTextNotFound().contains("No products were found"));
        // logUtility.info("mes:"+);
    }

}
