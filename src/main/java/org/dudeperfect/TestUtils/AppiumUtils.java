package org.dudeperfect.TestUtils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AppiumUtils {
    public String getScreenshot(String testCaseName, AppiumDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"//reports"+"//"+testCaseName+".png";
        System.out.println(System.getProperty("user.dir"));
        FileHandler.copy(source, new File(destinationFile));
        return destinationFile;
    }
}
