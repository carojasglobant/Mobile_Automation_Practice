package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import screens.*;
import util.tests.BaseMobileTest;

public class NavigationBottomMenuBarTest extends BaseMobileTest {

	/**
	 * Verify the bottom bar navigation is working properly something.
	 */
	@Test
	public void testFullBottomBarNavigation() {
		String WEBVIEW_SCREEN_CENTER_TEXT ="Next-gen browser and mobile automation test framework for Node.js";
		String LOG_IN_SCREEN_TITLE_TEXT = "Login / Sign up Form";
		String FORM_SCREEN_TITLE_TEXT = "Form components";
		String SWIPE_SCREEN_TITLE_TEXT = "Swipe horizontal";
		String DRAG_SCREEN_TITLE_TEXT = "Drag and Drop";

		log.info("Initializing home screen");
		HomeScreen homeScreen = loadHomeScreen();

		log.info("Changing to web view screen");
		WebViewScreen webViewScreen = homeScreen.goToWebViewScreen();
		log.info("Assertion in webview screen");
		Assert.assertEquals(webViewScreen.getImageText(), WEBVIEW_SCREEN_CENTER_TEXT);

		log.info("Changing to log in screen");
		LogInScreen loginScreen = webViewScreen.goToLogInScreen();
		log.info("Assertion in log in screen");
		Assert.assertEquals(loginScreen.getLogInTitleText(), LOG_IN_SCREEN_TITLE_TEXT);

		log.info("Changing to form screen screen");
		FormsScreen formsScreen = loginScreen.goToFormsScreen();
		log.info("Assertion in form screen");
		Assert.assertEquals(formsScreen.getTextFormScreenTitle(),FORM_SCREEN_TITLE_TEXT);

		log.info("Changing to swipe screen screen");
		SwipeScreen swipeScreen = formsScreen.goToSwipeScreen();
		log.info("Assertion in swipe screen");
		Assert.assertEquals(swipeScreen.getTextTitleSwipeScreen(),SWIPE_SCREEN_TITLE_TEXT);

		log.info("Changing to drag screen screen");
		DragScreen dragScreen = swipeScreen.goToDragScreen();
		log.info("Assertion in drag screen");
		Assert.assertEquals(dragScreen.getTextTitleDragScreen(),DRAG_SCREEN_TITLE_TEXT);





	}
}
