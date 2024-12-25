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
import pages.P01_LandingPage;
import pages.P06_LoginPage;
import pages.P10_AddToCartPage;
import pages.P11_CartPage;

import java.io.IOException;

import static DriverFacory.DriverFactory.getDriver;

@Listeners({IInvokedListener.class, ITestListener.class})
public class TC06_CartPageTest extends TC00_TestBase {

    @DataProvider
    public Object[] testDataValidLogin() throws IOException, ParseException {
        return classesUtility.readJsonDataLogin("validLogin");

    }

    @Test(dataProvider = "testDataValidLogin", priority = 2, dependsOnMethods = "changeQuantityOfProducts")
    public void removeCartPage(String data) {
        //TODO:: login
        String users[] = data.split(",");
        new P01_LandingPage(getDriver()).goToLoginPage();
        Assert.assertTrue(new P01_LandingPage(getDriver()).assertOnLoginPageUrl(DataUtility.readPropertyFile("ENV", "LoginLink")));
        new P06_LoginPage(getDriver()).loginProcess(users[0], users[1]);
        //TODO:: go to cart page
        new P10_AddToCartPage(getDriver()).goToCartPage();  //1590.00
        //Assert.assertEquals(new P11_CartPage(getDriver()).getItemPriceFromCartPage(), new P10_AddToCartPage(getDriver()).getItemPriceFromItemSelected());

        //TODO:: remove cart page
        new P11_CartPage(getDriver()).removingCartPage();
        Assert.assertTrue(new P11_CartPage(getDriver()).assertOnTextEmpty().contains("Your Shopping Cart is empty"));

    }


    @Description("change the quantity of item")
    @Test(dataProvider = "testDataValidLogin", priority = 1)
    public void changeQuantityOfProducts(String data) {
        //TODO:: login
        String users[] = data.split(",");
        new P01_LandingPage(getDriver()).goToLoginPage();
        Assert.assertTrue(new P01_LandingPage(getDriver()).assertOnLoginPageUrl(DataUtility.readPropertyFile("ENV", "LoginLink")));
        new P06_LoginPage(getDriver()).loginProcess(users[0], users[1]);
        //TODO:: go to cart page
        new P10_AddToCartPage(getDriver()).goToCartPage();  //1590.00
        System.out.println("price before change :" + new P11_CartPage(getDriver()).getItemUnitPriceFromCartPage());

        //TODO:: change the quantity
        new P11_CartPage(getDriver()).changeQuantity("3");
        System.out.println("price after  change :" + new P11_CartPage(getDriver()).getItemTotalPriceFromCartPage());
        Assert.assertNotEquals(new P11_CartPage(getDriver()).getItemTotalPriceFromCartPage(), new P11_CartPage(getDriver()).getItemUnitPriceFromCartPage());


    }

}
