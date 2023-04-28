package org.dudeperfect.pageObjects.onBoarding;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FindAdultPage {
    AndroidDriver driver;

    public FindAdultPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/title")
    private WebElement findParentTitle;

    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/adultButton")
    private WebElement parentButton;

    @AndroidFindBy(id ="tv.kidoodle.android.dudeperfect:id/backButton")
    private WebElement backButton;

//  Action Methods

    public String findAdultTitleText(){
        return findParentTitle.getText();
    }
    public String parentButtonText(){
        return parentButton.getText();
    }
    public String backButtonText(){
        return backButton.getText();
    }
    public void clickParentButton(){
        parentButton.click();
    }
    public void clickBackButton(){
        backButton.click();
    }
}
