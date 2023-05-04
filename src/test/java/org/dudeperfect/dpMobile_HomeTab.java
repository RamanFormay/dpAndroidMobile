package org.dudeperfect;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.dudeperfect.pageObjects.onBoarding.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dpMobile_HomeTab extends BaseTest{
        AgeGatePage ageGatePage;
        YearOfBirthPage yearOfBirthPage;
        FindAdultPage findAdultPage;
        HomeTabPage homeTabPage;
        VideoPlayerPage videoPlayerPage;
        dpMobile_AgeGate ageGateTest;

        @BeforeMethod()
        public void PreSetup() throws InterruptedException {
            ageGatePage = new AgeGatePage(driver);
            yearOfBirthPage = new YearOfBirthPage(driver);
            findAdultPage = new FindAdultPage(driver);
            homeTabPage = new HomeTabPage(driver);
            videoPlayerPage = new VideoPlayerPage(driver);
            ageGateTest =new dpMobile_AgeGate();
        }

        @Test(priority = 1)
        public void HomeTab_EpisodeCard_And_ScrollValidation() throws InterruptedException {
            ageGateTest.AgeGatePage_AdultFlowValidation();
            Assert.assertTrue(homeTabPage.loadingSpinnerDisplayed());
            Assert.assertEquals(homeTabPage.errorDescriptionText(),"Hang tight, we're getting that \n" +
                    "video loaded up!");
            Assert.assertTrue(homeTabPage.categoryNameDisplayed());
            Assert.assertTrue(homeTabPage.videoDurationDisplayed());
            Assert.assertTrue(homeTabPage.seriesNameDisplayed());
            Assert.assertTrue(homeTabPage.releasedMonthDisplayed());
            Assert.assertTrue(homeTabPage.episodeNameDisplayed());
            homeTabPage.scrollToEnd();
            driver.resetApp();
        }

         @Test(priority = 2)
         public void HomeTab_PlayVideoValidation() throws InterruptedException {
             ageGateTest.AgeGatePage_AdultFlowValidation();
             Assert.assertTrue(homeTabPage.relatedVideoImageDisplayed());
             String episodeName = homeTabPage.getEpisodeName();
             homeTabPage.clickRelatedVideoImage();
             Assert.assertTrue(videoPlayerPage.videoTitleDisplayed());
             Assert.assertEquals(videoPlayerPage.getVideoTitleText(),episodeName);
       }

}
