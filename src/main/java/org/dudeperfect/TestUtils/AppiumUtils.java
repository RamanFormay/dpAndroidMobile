package org.dudeperfect.TestUtils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class AppiumUtils{
    AndroidDriver driver;

    public String getScreenshot(String testCaseName, AppiumDriver driver) throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"//reports"+"//"+testCaseName+".png";
        System.out.println(System.getProperty("user.dir"));
        FileHandler.copy(source, new File(destinationFile));
        return destinationFile;
    }

}
