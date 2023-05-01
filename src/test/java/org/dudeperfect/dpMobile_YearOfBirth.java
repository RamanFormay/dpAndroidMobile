package org.dudeperfect;

import org.dudeperfect.pageObjects.onBoarding.AgeGatePage;
import org.dudeperfect.pageObjects.onBoarding.FindAdultPage;
import org.dudeperfect.pageObjects.onBoarding.YearOfBirthPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dpMobile_YearOfBirth extends BaseTest{
    AgeGatePage ageGatePage;
    YearOfBirthPage yearOfBirthPage;
    FindAdultPage findAdultPage;
    @BeforeMethod()
    public void PreSetup(){
        ageGatePage = new AgeGatePage(driver);
        yearOfBirthPage = new YearOfBirthPage(driver);
        findAdultPage = new FindAdultPage(driver);
    }

    @Test
    public void YOBPage_TextValidations(){
        ageGatePage.clickAdultButton();
        Assert.assertEquals(yearOfBirthPage.getYobTitle(), "WHAT IS YOUR \n" +
                "YEAR OF BIRTH?");
        Assert.assertEquals(yearOfBirthPage.getYobDescription(),"This information is not stored and \n" +
                "is only used for age verification.");
        Assert.assertEquals( yearOfBirthPage.getPrivacyPolicy(),"I agree to the Privacy Policy, \n" +
               "Terms and Conditions & accept cookies.");
        Assert.assertEquals(yearOfBirthPage.getContinueButtonText(), "CONTINUE");

    }
}
