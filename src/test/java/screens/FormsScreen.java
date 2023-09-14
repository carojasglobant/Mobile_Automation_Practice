package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

/**
 * @author Cristian R
 * @description Forms screen view class
 */
public class FormsScreen extends BaseScreen {

    /** Form Screen title */

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Forms-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement textFormElement;
    public FormsScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     *
     * @return Title from form screen view STRING
     */
    public String getTextFormScreenTitle(){
        return textFormElement.getText();
    }


    /**
     *
     * @return SwipeScreen view instance
     */
    public SwipeScreen goToSwipeScreen(){
        click(swipeButton);
        return new SwipeScreen(driver);
    }
}
