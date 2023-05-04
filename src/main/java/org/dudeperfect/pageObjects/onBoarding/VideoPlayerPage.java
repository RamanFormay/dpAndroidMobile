package org.dudeperfect.pageObjects.onBoarding;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class VideoPlayerPage {
    AndroidDriver driver;

    public VideoPlayerPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/btnBack")
    public WebElement backButton;

    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/videoTitle")
    public WebElement videoTitle;

    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/imgSeekBack")
    public WebElement backwardControl;

    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/imgPlayPause")
    public WebElement playPauseControl;

    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/imgSeekForward")
    public WebElement forwardControl;

    @AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]")
    public WebElement startTime;

    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/tvTimeLeft")
    public  WebElement endTime;

    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/video_seek_bar")
    public WebElement seekBar;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageButton")
    public WebElement expandButton;

//  Action Methods
    public boolean videoTitleDisplayed(){
        return videoTitle.isDisplayed();
    }

    public void clickForwardControl(){
        forwardControl.click();
    }

    public String getVideoTitleText(){
       return videoTitle.getText();
    }

}
