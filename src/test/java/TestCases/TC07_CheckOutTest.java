package TestCases;

import Listeners.IInvokedListener;
import Listeners.ITestListener;
import Utilities.DataUtility;
import Utilities.classesUtility;
import io.qameta.allure.Description;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

import static DriverFacory.DriverFactory.getDriver;

@Listeners({IInvokedListener.class, ITestListener.class})
public class TC07_CheckOutTest extends TC00_TestBase {

    @DataProvider
    public Object[] testDataValidLogin() throws IOException, ParseException {
        return classesUtility.readJsonDataLogin("validLogin");

    }

    @Description("change the quantity of item")
    @Test(dataProvider = "testDataValidLogin", priority = 1)
    public void checkoutProcessTC(String data) throws InterruptedException {
        //TODO:: login
        String[] users = data.split(",");
        new P01_LandingPage(getDriver()).goToLoginPage();
        Assert.assertTrue(new P01_LandingPage(getDriver()).assertOnLoginPageUrl(DataUtility.readPropertyFile("ENV", "LoginLink")));
        new P06_LoginPage(getDriver()).loginProcess(users[0], users[1]);

        //TODO:: go to cart page
        new P10_AddToCartPage(getDriver()).goToCartPage();  //1590.00

        //TODO::go to checkout page
        new P11_CartPage(getDriver()).goToBillingAddress();
        Assert.assertTrue(new P11_CartPage(getDriver()).assertOnUrlCheckOut("https://demowebshop.tricentis.com/onepagecheckout"));

        //TODO:: checkout process
        new P12_BillingAddressPage(getDriver())
                .selectBillingAdd()
                .shippingAddress()
                .shippingMethod()
                .paymentMethod()
                .paymentInfo();


        Assert.assertEquals(new P12_BillingAddressPage(getDriver()).getPriceUnitCheck(), "1590.00");
        // Assert.assertEquals(new P12_BillingAddressPage(getDriver()).getPriceTotalCheck(), "4770.00");
        Assert.assertEquals(new P12_BillingAddressPage(getDriver()).getProdNameCheck(), "14.1-inch Laptop");


        new P12_BillingAddressPage(getDriver())
                .confirmOrder();

        Assert.assertTrue(new P12_BillingAddressPage(getDriver()).assertOnUrlCompleteOrder("https://demowebshop.tricentis.com/checkout/completed/"));
        Assert.assertEquals(new P12_BillingAddressPage(getDriver()).assertOnConfirmText(), "Your order has been successfully processed!");

        new P12_BillingAddressPage(getDriver()).continueOrder();

        Assert.assertTrue(new P04_HomePage(getDriver()).assertOnHomePageUrl(DataUtility.readPropertyFile("ENV", "HomePage")));


    }


}
