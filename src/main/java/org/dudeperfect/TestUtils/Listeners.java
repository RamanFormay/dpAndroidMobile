package org.dudeperfect.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends AppiumUtils implements ITestListener {
    ExtentTest tests;
    AndroidDriver driver;
    ExtentReports extent= ExtentReporterNG.getReporterObject();
    public void ScreenshotCapture(ITestResult result) throws NoSuchFieldException, IllegalAccessException {
        driver = (AndroidDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        try {
            tests.addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    public void onTestStart(ITestResult result) {
// TODO Auto-generated method stub
        tests = extent.createTest(result.getMethod().getMethodName());
        ScreenshotCapture(result);
    }

    @SneakyThrows
    @Override
    public void onTestSuccess(ITestResult result) {
// TODO Auto-generated method stub
        tests.log(Status.PASS,"Test Passed");
        ScreenshotCapture(result);
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
// TODO Auto-generated method stub
        tests.fail(result.getThrowable());
        ScreenshotCapture(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
// TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
// TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
// TODO Auto-generated method stub
    }

    @Override
    public void onFinish(ITestContext context) {
// TODO Auto-generated method stub
        extent.flush();
    }

}
