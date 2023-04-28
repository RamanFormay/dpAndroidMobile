package org.dudeperfect;

import io.appium.java_client.android.Activity;
import org.dudeperfect.pageObjects.onBoarding.AgeGatePage;
import org.dudeperfect.pageObjects.onBoarding.FindAdultPage;
import org.dudeperfect.pageObjects.onBoarding.YearOfBirthPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class dpMobile_AgeGate extends BaseTest{
    AgeGatePage ageGatePage;
    YearOfBirthPage yearOfBirthPage;
    FindAdultPage findAdultPage;
    @BeforeMethod()
    public void PreSetup() throws InterruptedException {
        ageGatePage = new AgeGatePage(driver);
        yearOfBirthPage = new YearOfBirthPage(driver);
        findAdultPage = new FindAdultPage(driver);
    }

//  Age Gate Page Text Validations
    @Test(priority = 1)
    public void AgeGatePage_TextValidations(){
        Assert.assertEquals(ageGatePage.getTitleText(), "WELCOME TO \n" +
                "DUDE PERFECT+");
        Assert.assertEquals(ageGatePage.getDescriptionText(), "Choose your path and let’s get started.");
        Assert.assertEquals(ageGatePage.youthButtonText(), "YOUTH");
        Assert.assertEquals(ageGatePage.adultButtonText(), "ADULT");
    }

//  ---------------- Negative Flow Validations ---------------

//  Negative Kid Flow Validation
    @Test(priority = 2)
    public void AgeGatePage_FindParentFlowValidation(){
        ageGatePage.clickYouthButton();
        findAdultPage.clickBackButton();
    }

//  Negative Adult Flow Validation
   @Test(priority =3)
   public void AgeGatePage_YOBErrorTextValidation(){
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ageGatePage.clickAdultButton();
        yearOfBirthPage.InputField("2010");
        yearOfBirthPage.selectCheckbox();
        yearOfBirthPage.clickContinueButton();
        Assert.assertEquals(yearOfBirthPage.getErrorHintText(), "This is only for adults.");
        driver.resetApp();

   }
    @Test(priority = 4)
    public void AgeGatePage_YOBContinueButtonDisabled(){
        ageGatePage.clickAdultButton();
        yearOfBirthPage.InputField("2010");
        Assert.assertFalse(yearOfBirthPage.continueButton());
        driver.resetApp();
    }
//  ------------------ Positive Flow Validations-----------------

//  Positive Kid Flow Validation
    @Test(priority = 5)
    public void AgeGatePage_KidFlowValidation(){
        ageGatePage.clickYouthButton();
        findAdultPage.clickParentButton();
        yearOfBirthPage.InputField("2000");
        yearOfBirthPage.selectCheckbox();
        yearOfBirthPage.clickContinueButton();
        driver.resetApp();
    }

//  Positive Adult Flow Validation
    @Test(priority = 6)
    public void AgeGatePage_AdultFlowValidation(){
        ageGatePage.clickAdultButton();
        yearOfBirthPage.InputField("2000");
        yearOfBirthPage.selectCheckbox();
        yearOfBirthPage.clickContinueButton();
        driver.resetApp();
    }

}
