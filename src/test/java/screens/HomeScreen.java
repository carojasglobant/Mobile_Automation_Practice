package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import util.screens.BaseScreen;

/**
 * Home screen class
 * @author Cristian R
 */
public class HomeScreen extends BaseScreen {


    public HomeScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public HomeScreen loadHomeScreen(){
        return new HomeScreen(driver);
    }

    /**
     * Change the view to a WebViewScreen
     * @return WebViewScreen
     */
    public WebViewScreen goToWebViewScreen(){
        click(webViewButton);
        return new WebViewScreen(driver);
    }

    /**
     * Change the view to a LogInScreen
     * @return LoginScreen
     */
    public LogInScreen goToLogInScreen(){
        click(logInButton);
        return new LogInScreen(driver);
    }

    /**
     * Change the view to a SwipeScreen
     * @return SwipeScreen
     */
    public SwipeScreen goToSwipeScreen(){
        click(swipeButton);
        return new SwipeScreen(driver);
    }

}
