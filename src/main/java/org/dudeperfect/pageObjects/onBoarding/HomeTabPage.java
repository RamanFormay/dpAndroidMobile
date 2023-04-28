package org.dudeperfect.pageObjects.onBoarding;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomeTabPage {
    AndroidDriver driver;

    public HomeTabPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ImageView")
    public WebElement episode;

    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/homeFragment")
    public WebElement homeNavButton;

    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/shortFragment")
    public WebElement shortNavButton;

    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/searchFragment")
    public WebElement searchNavButton;

    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/settingsFragment")
    public WebElement settingsNavButton;

    public void clickOnEpisode(){
        episode.click();
    }

}
