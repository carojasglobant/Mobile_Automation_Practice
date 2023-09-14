package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

public class SignUpScreen extends BaseScreen {
    public SignUpScreen(AndroidDriver<AndroidElement> driver) { super(driver);}

    /** The email text box. */
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-email\"]")
    private AndroidElement userTextBoxSignUp;

    /** The password text box. */
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-password\"]")
    private AndroidElement passwordTextBoxSignUp;

    /** The password confirm text box. */
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-repeat-password\"]")
    private AndroidElement confirmPasswordTextBoxSignUp;

    /** The sign-up button. */
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-SIGN UP\"]/android.view.ViewGroup/android.widget.TextView")
    private AndroidElement signUpButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/message\")")
    private AndroidElement signUpExitTextMessage;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
    private AndroidElement signUpOkPopUpButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-login-container\"]")
    private AndroidElement logInChangeCardButton;




    /**
     * Fill in sign up data.
     *
     * @param user     :String
     * @param password :String
     */
    public void fillInSignUpData(String user, String password) {
        sendKeys(userTextBoxSignUp, user);
        sendKeys(passwordTextBoxSignUp, password);
        sendKeys(confirmPasswordTextBoxSignUp, password);
        click(signUpButton);
    }

    public LogInScreen clickChangeLogInCard(){
        click(logInChangeCardButton);
        return new LogInScreen(driver);
    }


    public String getExitMessagePopUp(){
        return signUpExitTextMessage.getText();
    }


    public void clickOkButton(){
        click(signUpOkPopUpButton);
    }

}
