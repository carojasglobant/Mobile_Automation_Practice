package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;


/**
 * Log in screen.
 * 
 * @author Cristian R
 *
 */
public class LogInScreen extends BaseScreen {

	/**
	 * Constructor method.
	 *
	 * @author Cristian R
	 * @param driver the driver
	 */
	public LogInScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	/** Log In view title */
	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
	private AndroidElement textLogInElement;

	/** Change card to Sign up Button */
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-sign-up-container\"]")
	private AndroidElement signUpChangeCardButton;

	/** The email text box. */
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-email\"]")
	private AndroidElement userTextBoxLogIn;

	/** The password text box. */
	@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"input-password\"]")
	private AndroidElement passwordTextBoxLogIn;

	/** Log in button */
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]")
	private AndroidElement logInUserButton;

	/** Pop up success message */
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/message\")")
	private AndroidElement popUpTextMessage;

	/** Pop up ok button */
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	private AndroidElement popUpOkButton;


	public String getLogInTitleText(){
		return textLogInElement.getText();
	}


	public FormsScreen goToFormsScreen(){
		click(formsButton);
		return new FormsScreen(driver);
	}

	public SignUpScreen clickChangeSignUpCard(){
		click(signUpChangeCardButton);
		return new SignUpScreen(driver);
	}



	/**
	 * Fill in sign up data.
	 *
	 * @param user     :String
	 * @param password :String
	 */
	public void fillInSignUpData(String user, String password) {
		sendKeys(userTextBoxLogIn, user);
		sendKeys(passwordTextBoxLogIn, password);
		click(logInUserButton);
	}

	public String getPopUpMessage(){
		return popUpTextMessage.getText();
	}

	public void clickOkButton(){
		click(popUpOkButton);
	}

}
