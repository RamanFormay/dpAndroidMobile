package org.dudeperfect;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static AppiumDriverLocalService service;
    public static AndroidDriver driver;
    //    Appium start
    @BeforeClass
    public static void open() throws MalformedURLException {

        System.out.println("Application started");
        service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4890).build();
        service.start();
        System.out.println("Application started");

//        setting the desired capabilites
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Raman");
        options.setUdid("R9WTA13MTGA");
        options.setPlatformVersion("12");

//        setting the app package and activity
        options.setAppPackage("tv.kidoodle.android.dudeperfect");
        options.setAppActivity("tv.kidoodle.android.ui.MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }

    @AfterClass
    public void teardown(){
        driver.quit();
        service.stop();
    }
}
