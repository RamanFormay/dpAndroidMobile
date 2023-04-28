package org.dudeperfect.pageObjects.onBoarding;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class AgeGatePage {
    AndroidDriver driver;

    public AgeGatePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "tv.kidoodle.android.dudeperfect:id/title")
    private WebElement title;

    @AndroidFindBy(id = "tv.kidoodle.android.dudeperfect:id/description")
    private WebElement description;


    @AndroidFindBy(id = "tv.kidoodle.android.dudeperfect:id/kidButton")
    private WebElement youthButton;

    @AndroidFindBy(id = "tv.kidoodle.android.dudeperfect:id/adultButton")
    private WebElement adultButton;

//  ACTION METHODS
    public String getTitleText(){
        return title.getText();
    }
    public String getDescriptionText(){
        return description.getText();
    }
    public String youthButtonText(){
        return youthButton.getText();
    }
    public String adultButtonText(){
        return adultButton.getText();
    }
    public void clickAdultButton() {
        adultButton.click();
    }
    public void clickYouthButton() {
        youthButton.click();
    }

}
