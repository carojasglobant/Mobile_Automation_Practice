package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseScreen;

/**
 * Swipe Screen
 * @author Cristian R
 */
public class SwipeScreen extends BaseScreen {

    /** Screen view title */
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Swipe-screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement textSwipeElement;

    /** Card One in Swipe Screen */
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"card\"])[1]")
    private AndroidElement cardOne;

    /** Card Two in Swipe Screen */
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"card\"])[2]")
    private AndroidElement cardTwo;

    /** Card three in Swipe Screen */
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"card\"])[3]")
    private AndroidElement cardThree;

    /** Dot one*/
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
    private AndroidElement dotNumberOne;

    /** Dot two*/
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
    private AndroidElement dotNumberTwo;
    public SwipeScreen(AndroidDriver<AndroidElement> driver) { super(driver); }



    /**
     *
     * @return Swipe view title STRING
     */
    public String getTextTitleSwipeScreen(){
        return textSwipeElement.getText();
    }

    /**
     *
     * @return DragScreen Screen
     */
    public DragScreen goToDragScreen(){
        click(dragButton);
        return new DragScreen(driver);
    }

    /**
     *  Swipe card one to the right
     */
    public void swipeRight(){
        horizontalSwipeByPoints(cardOne, -100, 0);
    }

    /**
     *  Swipe card two to the left
     */
    public void swipeLeft(){
        horizontalSwipeByPoints(cardTwo, 100, 0);
    }

    /**
     *
     * @return an array [height,width] card One
     */
    public int[] getSizeOfElement(AndroidElement element){
        int elementHeight = element.getSize().getHeight();
        int elementWidth = element.getSize().getWidth();
        return new int[]{elementHeight, elementWidth};
    }

    /**
     *
     * @param cardNumber : number of the three cards
     * @return position 0 is height, position 1 is width
     */
    public int[] getCardSize(int cardNumber){
        switch (cardNumber){
            case 1:
                return getSizeOfElement(cardOne);
            case 2:
                return getSizeOfElement(cardTwo);
            case 3:
                return getSizeOfElement(cardThree);
            default:
                return null;
        }
    }

    /**
     *
     * @param dotNumber : number to identify the dot element
     * @return [ dotHeight, dotWidth ]
     */
    public int[] getDotSize(int dotNumber){
        switch (dotNumber){
            case 1:
                return getSizeOfElement(dotNumberOne);
            case 2:
                return getSizeOfElement(dotNumberTwo);
            default:
                return null;
        }
    }



    public double getSizeWidth(){
        return cardOne.getSize().getWidth();
    }
}
