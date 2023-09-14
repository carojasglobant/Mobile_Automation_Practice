package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.SwipeScreen;
import util.tests.BaseMobileTest;

public class SwipeCardsTest extends BaseMobileTest {

    /**
     * Swiping the cards in the swipe screen
     */
    @Test
    public void swipeCardsTest(){
        String SWIPE_SCREEN_TITLE_TEXT = "Swipe horizontal";


        log.info("Initializing home screen");
        HomeScreen homeScreen = loadHomeScreen();

        SwipeScreen swipeScreen = homeScreen.goToSwipeScreen();
        log.info("Assertion in swipe screen");
        Assert.assertEquals(swipeScreen.getTextTitleSwipeScreen(),SWIPE_SCREEN_TITLE_TEXT);


        log.info("Assert the card one is in the middle");
        log.info( swipeScreen.getCardSize(1)[1]);
        Assert.assertTrue( swipeScreen.getCardSize(1)[0] > swipeScreen.getCardSize(2)[0]);
        Assert.assertTrue( swipeScreen.getCardSize(1)[1] >= swipeScreen.getCardSize(2)[1]);

        log.info("Swipe card one to the right");

        swipeScreen.swipeRight();

        log.info("Assert the card one is hidden");
        Assert.assertTrue( swipeScreen.getCardSize(1)[0] < swipeScreen.getCardSize(2)[0]);
        Assert.assertTrue( swipeScreen.getCardSize(1)[1] <= swipeScreen.getCardSize(2)[1]);

        log.info("Assert the dot two is selected");
        Assert.assertTrue(swipeScreen.getDotSize(1)[0] < swipeScreen.getDotSize(2)[0]);
        Assert.assertTrue(swipeScreen.getDotSize(1)[1] < swipeScreen.getDotSize(2)[1]);


        log.info("Assert the three is hidden");
        Assert.assertTrue( swipeScreen.getCardSize(2)[0] > swipeScreen.getCardSize(3)[0]);
        Assert.assertTrue( swipeScreen.getCardSize(2)[1] >= swipeScreen.getCardSize(3)[1]);


        swipeScreen.swipeLeft();

        log.info("Assert the card one is in the middle again");
        Assert.assertTrue( swipeScreen.getCardSize(1)[0] > swipeScreen.getCardSize(2)[0]);
        Assert.assertTrue( swipeScreen.getCardSize(1)[1] >= swipeScreen.getCardSize(2)[1]);

        log.info("Assert the dot one is selected");
        Assert.assertTrue(swipeScreen.getDotSize(1)[0] > swipeScreen.getDotSize(2)[0]);
        Assert.assertTrue(swipeScreen.getDotSize(1)[1] > swipeScreen.getDotSize(2)[1]);

    }
}
