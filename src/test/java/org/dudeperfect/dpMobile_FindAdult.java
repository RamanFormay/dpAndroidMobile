package org.dudeperfect;

import org.dudeperfect.pageObjects.onBoarding.AgeGatePage;
import org.dudeperfect.pageObjects.onBoarding.FindAdultPage;
import org.dudeperfect.pageObjects.onBoarding.YearOfBirthPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dpMobile_FindAdult extends BaseTest {
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
    public void FindAdultPage_TextValidations(){
        ageGatePage.clickYouthButton();
        Assert.assertEquals(findAdultPage.findAdultTitleText(),"FIND A PARENT OR \n" +
                "GUARDIAN TO CONTINUE");
        Assert.assertEquals(findAdultPage.parentButtonText(),"I'M A PARENT");
        Assert.assertEquals(findAdultPage.backButtonText(),"GO BACK");

    }
}
