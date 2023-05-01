package org.dudeperfect.pageObjects.onBoarding;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class YearOfBirthPage {
    AndroidDriver driver;

    public YearOfBirthPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/title")
    private WebElement yobTitle;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/description")
    private WebElement yobDescription;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/yearOfBirth")
    private WebElement yobInputField;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/edittextError")
    private WebElement errorText;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/checkBox")
    private WebElement checkboxSelection;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/textview1")
    private WebElement tosText1;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/privacyPolicyHyperlink")
    private WebElement tosText2;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/textview3")
    private WebElement tosText3;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/textview4")
    private WebElement tosText4;
    @AndroidFindBy(id="tv.kidoodle.android.dudeperfect:id/confirmButton")
    private WebElement continueButton;

//   Action Methods
    public String getYobTitle(){
        return yobTitle.getText();
    }
    public String getYobDescription(){
        return yobDescription.getText();
    }

    public String getErrorHintText(){
        return errorText.getText();
    }
    public String getPrivacyPolicy(){
        return tosText1.getText()+" "+tosText2.getText()+" "+"\n"+tosText3.getText()+" "+tosText4.getText();
    }
    public String getContinueButtonText(){
        return continueButton.getText();
    }
    public boolean continueButton(){
        return continueButton.isEnabled();
    }
    public void InputField(String year){
       yobInputField.sendKeys(String.valueOf(year));
    }
    public void selectCheckbox(){
        checkboxSelection.click();
    }
    public void clickContinueButton(){
        continueButton.click();
    }

}
