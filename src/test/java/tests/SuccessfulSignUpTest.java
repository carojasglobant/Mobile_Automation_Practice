package tests;

import Data.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LogInScreen;
import screens.SignUpScreen;
import util.RandomEmailGenerator;
import util.tests.BaseMobileTest;

public class SuccessfulSignUpTest extends BaseMobileTest {

    /**
     * Complete Sign up test
     * @param password
     */
    @Test(dataProvider = "sign-up-valid-data", dataProviderClass = TestDataProvider.class)
    public void signUpTest(String password){
        String LOG_IN_SCREEN_TITLE_TEXT = "Login / Sign up Form";
        String SUCCESFUL_MESSAGE_TEXT = "You successfully signed up!";

        HomeScreen homeScreen = loadHomeScreen();
        log.info("Change to log in Screen");
        LogInScreen loginScreen = homeScreen.goToLogInScreen();

        String emailGenerated = RandomEmailGenerator.generateRandomEmail();
        log.info("Email generated: "+emailGenerated);

        // assert we are in log in page
        Assert.assertEquals(loginScreen.getLogInTitleText(), LOG_IN_SCREEN_TITLE_TEXT);

        log.info("Change to sign up card");
        SignUpScreen signUpScreen = loginScreen.clickChangeSignUpCard();
        signUpScreen.fillInSignUpData(emailGenerated, password);
        Assert.assertEquals(signUpScreen.getExitMessagePopUp(), SUCCESFUL_MESSAGE_TEXT);
        log.info("Click OK button");
        signUpScreen.clickOkButton();

    }
}
