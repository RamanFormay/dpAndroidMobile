package org.dudeperfect;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.dudeperfect.pageObjects.onBoarding.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
        @Test(priority=1)
        public void HomeTab_TextValidation() throws InterruptedException {
            ageGateTest.AgeGatePage_AdultFlowValidation();
            Assert.assertTrue(homeTabPage.loadingSpinnerDisplayed());
//            Assert.assertEquals(homeTabPage.errorDescriptionText(),"Hang tight, we're getting that \n" +
//                    "video loaded up!");
            Assert.assertTrue(homeTabPage.staticImageHeaderDisplayed());
            Assert.assertTrue(homeTabPage.categoryNameDisplayed());
            Assert.assertTrue(homeTabPage.videoDurationDisplayed());
            Assert.assertTrue(homeTabPage.seriesNameDisplayed());
            Assert.assertTrue(homeTabPage.releasedMonthDisplayed());
            Assert.assertTrue(homeTabPage.episodeNameDisplayed());
            Assert.assertTrue(homeTabPage.homeButtonDisplayed());
            Assert.assertTrue(homeTabPage.joinButtonDisplayed());
        }
        @Test(priority = 2)
        public void HomeTab_EpisodeCard_And_ScrollValidation() throws InterruptedException {
            ageGateTest.AgeGatePage_AdultFlowValidation();
            homeTabPage.scrollToEnd();
            driver.resetApp();
        }
        @Test(priority=3)
        public void HomeTab_SwipeValidation() throws InterruptedException {
            ageGateTest.AgeGatePage_AdultFlowValidation();
            WebElement firstEpisodeCard = homeTabPage.getEpisodeCardFirstElement();
            Assert.assertEquals(firstEpisodeCard.getAttribute("focusable"),"true");
            homeTabPage.swipeAction(firstEpisodeCard, "left");
            Thread.sleep(2000);
        }
         @Test(priority = 4)
         public void HomeTab_PlayVideoValidation() throws InterruptedException {
             ageGateTest.AgeGatePage_AdultFlowValidation();
             Assert.assertTrue(homeTabPage.relatedVideoImageDisplayed());
             String currentEpisodeName= homeTabPage.getEpisodeName();
             homeTabPage.clickRelatedVideoImage();
             Thread.sleep(2000);
//           Assert.assertEquals(currentEpisodeName, videoPlayerPage.getVideoTitleText());

       }

}
