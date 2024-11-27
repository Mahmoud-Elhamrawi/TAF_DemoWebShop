package Listeners;

import Utilities.classesUtility;
import Utilities.logUtility;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import static DriverFacory.DriverFactory.getDriver;

public class IInvokedListener implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        logUtility.info(testResult.getName()+"executed......");
        if(testResult.getStatus()== ITestResult.FAILURE)
        {
            logUtility.error(testResult.getName()+"fail....");
            classesUtility.takeScreenShot(getDriver(),testResult.getName());

        }else
        {
           logUtility.info("tc is pass....");
        }



    }
}
