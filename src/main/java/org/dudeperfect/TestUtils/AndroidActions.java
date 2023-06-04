package org.dudeperfect.TestUtils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class AndroidActions {
    AndroidDriver driver;
    public AndroidActions(AndroidDriver driver){
        this.driver = driver;
    }
    public void scrollToEnd() throws InterruptedException {
        Dimension size = driver.manage().window().getSize();

// set the start point from the top of the screen
        Point startPoint = new Point(size.getWidth() / 2, (int) (size.getHeight() * 0.5));

// set the end point to the bottom of the screen
        Point endPoint = new Point(size.getWidth() / 2, (int) (size.getHeight() * 0.2));

// set the duration of the scroll gesture
        Duration duration = Duration.ofMillis(1000);
        int count=0;
// repeat the scroll gesture again and again
        while (count<7) {
            // perform the scroll gesture from start point to end point
            new TouchAction(driver)
                    .press(point(startPoint))
                    .waitAction(waitOptions(duration))
                    .moveTo(point(endPoint))
                    .release()
                    .perform();

            // wait for some time before performing the next scroll gesture
            Thread.sleep(1000);
           count++;
        }
    }

    public void swipeAction(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "direction", direction,
                "percent", 0.75
        ));
    }

}

