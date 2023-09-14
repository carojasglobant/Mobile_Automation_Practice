package tests;

import Data.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LogInScreen;
import util.RandomEmailGenerator;
import util.tests.BaseMobileTest;

public class SuccessfulLogInTest extends BaseMobileTest {

    /**
     * Complete log in test
     * @param password : password in the account
     */
    @Test(dataProvider = "sign-up-valid-data", dataProviderClass = TestDataProvider.class)
    public void logInTest(String password){
        String SUCCESSFUL_LOG_IN_MESSAGE = "You are logged in!";
        String LOG_IN_SCREEN_TITLE_TEXT = "Login / Sign up Form";

        String emailGenerated = RandomEmailGenerator.generateRandomEmail();
        log.info("Email generated: "+emailGenerated);

        log.info("Initializing home screen");
        HomeScreen homeScreen = loadHomeScreen();
        LogInScreen loginScreen = homeScreen.goToLogInScreen();

        // assert we are in log in page
        Assert.assertEquals(loginScreen.getLogInTitleText(), LOG_IN_SCREEN_TITLE_TEXT);
        loginScreen.fillInSignUpData(emailGenerated, password);
        log.info("Assert the pop up message");
        Assert.assertEquals(loginScreen.getPopUpMessage(), SUCCESSFUL_LOG_IN_MESSAGE);
        loginScreen.clickOkButton();
    }
}
