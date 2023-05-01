package org.dudeperfect;

import org.dudeperfect.pageObjects.onBoarding.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

public class dpMobile_VideoPlayer extends BaseTest {
    AgeGatePage ageGatePage;
    YearOfBirthPage yearOfBirthPage;
    FindAdultPage findAdultPage;
    HomeTabPage homeTabPage;
    VideoPlayerPage videoPlayerPage;

    @BeforeMethod()
    public void PreSetup(){
        ageGatePage = new AgeGatePage(driver);
        yearOfBirthPage = new YearOfBirthPage(driver);
        findAdultPage = new FindAdultPage(driver);
        homeTabPage =new HomeTabPage(driver);
        videoPlayerPage =new VideoPlayerPage(driver);
    }

    @Test(priority = 1)
    public void VideoPlayerForwardControl(){
        ageGatePage.clickAdultButton();
        yearOfBirthPage.InputField("2000");
        yearOfBirthPage.selectCheckbox();
        yearOfBirthPage.clickContinueButton();
//        homeTabPage.clickLoadButton();
        Assert.assertTrue(videoPlayerPage.videoTitleText());
        videoPlayerPage.clickForwardControl();
    }



}
