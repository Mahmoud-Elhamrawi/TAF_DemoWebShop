package Listeners;

import Utilities.logUtility;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class ITestListener implements org.testng.ITestListener {

    public void onTestStart(ITestResult result) {
        logUtility.info("the test case is starting  : " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        logUtility.info("the test case is passing : " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        logUtility.info("the test case is failing : " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        logUtility.info("the test case is skipping : " + result.getName());
    }

    public void onStart(ITestContext context) {
        logUtility.info("the suite is start...");
    }

    public void onFinish(ITestContext context) {
        logUtility.info("the suite is finish...");
    }


}
