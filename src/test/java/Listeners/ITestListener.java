package Listeners;

import Utilities.logUtility;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.IOException;

public class ITestListener implements org.testng.ITestListener {

    public void onTestStart(ITestResult result) {
        try {
            logUtility.info("the test case is starting  : " + result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSuccess(ITestResult result) {
        try {
            logUtility.info("the test case is passing : " + result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestFailure(ITestResult result) {
        try {
            logUtility.info("the test case is failing : " + result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result) {
        try {
            logUtility.info("the test case is skipping : " + result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onStart(ITestContext context) {
        try {
            logUtility.info("the suite is start...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onFinish(ITestContext context) {
        try {
            logUtility.info("the suite is finish...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
