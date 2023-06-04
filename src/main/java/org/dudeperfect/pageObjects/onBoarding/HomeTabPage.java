package org.dudeperfect.pageObjects.onBoarding;

import com.aventstack.extentreports.gherkin.model.And;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.dudeperfect.TestUtils.AndroidActions;
import org.dudeperfect.TestUtils.AppiumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomeTabPage extends AndroidActions {
    AndroidDriver driver;
    public HomeTabPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/homeFragment")
    public WebElement homeNavButton;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/joinFragment")
    public WebElement joinNavButton;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/shortFragment")
    public WebElement shortNavButton;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/searchFragment")
    public WebElement searchNavButton;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/settingsFragment")
    public WebElement settingsNavButton;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/progress_loading")
    public WebElement loadingSpinner;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/error_desc")
    public WebElement errorDescription;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/ivtitle")
    public WebElement videoTitle;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/categoryName")
    public WebElement categoryName;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/duration")
    public WebElement videoDuration;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/seriesName")
    public WebElement seriesName;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/released")
    public WebElement releasedMonth;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/episodeName")
    public WebElement episodeName;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/relatedVideoImage")
    public WebElement relatedVideoImage;
    @AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]")
    public WebElement episodeCardFirst;

//  Action Methods
    public boolean loadingSpinnerDisplayed(){
        return loadingSpinner.isDisplayed();
    }
    public String errorDescriptionText(){
        return errorDescription.getText();
    }
    public boolean staticImageHeaderDisplayed(){
        return videoTitle.isDisplayed();
    }
    public boolean categoryNameDisplayed(){
        return categoryName.isDisplayed();
    }
    public boolean seriesNameDisplayed(){
        return seriesName.isDisplayed();
    }
    public boolean episodeNameDisplayed(){
        return episodeName.isDisplayed();
    }
    public boolean relatedVideoImageDisplayed(){
        return relatedVideoImage.isDisplayed();
    }
    public boolean videoDurationDisplayed(){
        return videoDuration.isDisplayed();
    }
    public boolean releasedMonthDisplayed(){
        return releasedMonth.isDisplayed();
    }

    public String getEpisodeName(){
         return episodeName.getText();
    }
    public void clickRelatedVideoImage(){
         relatedVideoImage.click();
    }
    public boolean homeButtonDisplayed(){
        return homeNavButton.isDisplayed();
    }
    public boolean joinButtonDisplayed(){
        return joinNavButton.isDisplayed();
    }

    public WebElement getEpisodeCardFirstElement(){
        return episodeCardFirst;
    }
}
