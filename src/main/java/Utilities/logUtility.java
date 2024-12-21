package Utilities;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class logUtility {

    public static final String logPath = "test-outputs/LOGS";

    public static void info(String msg) throws IOException {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).info(msg);
        File logFile = classesUtility.getLatestFile(logPath);
        Allure.addAttachment("logs", Files.readString(Path.of(logFile.getPath())));
    }

    public static void trace(String msg) {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).trace(msg);
    }

    public static void error(String msg) {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).error(msg);
    }
}
