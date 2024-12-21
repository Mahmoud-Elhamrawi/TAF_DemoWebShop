package Listeners;

import Utilities.classesUtility;
import Utilities.logUtility;
import io.qameta.allure.Allure;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static DriverFacory.DriverFactory.getDriver;
import static Utilities.logUtility.logPath;

public class IInvokedListener implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        try {
            logUtility.info(testResult.getName() + "executed......");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (testResult.getStatus() == ITestResult.FAILURE) {
            logUtility.error(testResult.getName() + "fail....");
            classesUtility.takeScreenShot(getDriver(), testResult.getName());
            File logFile = classesUtility.getLatestFile(logPath);
            try {
                Allure.addAttachment("logsError", Files.readString(Path.of(logFile.getPath())));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            try {
                logUtility.info("tc is pass....");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
