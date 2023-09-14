package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

/**
 * @author Cristian R
 * @description Drag screen view
 */
public class DragScreen extends BaseScreen {
    /** Drag view title */
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Drag-drop-screen\"]/android.view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement textDragElement;

    public DragScreen(AndroidDriver<AndroidElement> driver) { super(driver); }

    /**
     * @return Title from drag screen STRING
     */
    public String getTextTitleDragScreen(){
        return textDragElement.getText();
    }

}
