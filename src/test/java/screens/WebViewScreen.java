package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

public class WebViewScreen extends BaseScreen {
    /** Web view title */
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"docusaurus_skipToContent_fallback\").childSelector(new UiSelector().className(\t\n" +
            "\"android.widget.TextView\"))" )
    private AndroidElement textElement;

    public WebViewScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     *
     * @return title from web view String
     */
    public String getImageText(){
        return textElement.getText();
    }

    /**
     *
     * @return LogInScreen
     */

    public LogInScreen goToLogInScreen(){
        click(logInButton);
        return new LogInScreen(driver);
    }


}
