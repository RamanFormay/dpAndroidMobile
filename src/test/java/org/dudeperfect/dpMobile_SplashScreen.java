package org.dudeperfect;

import org.dudeperfect.pageObjects.onBoarding.SplashScreenPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class dpMobile_SplashScreen extends BaseTest {
        SplashScreenPage splashScreenPage;

        @Test
        public void SplashScreenValidation() {
            splashScreenPage = new SplashScreenPage(driver);
            Assert.assertTrue(splashScreenPage.dpLogoDisplayed());
        }
}
