package util.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import screens.HomeScreen;
import screens.LogInScreen;
import screens.SignUpScreen;
import util.ConfigCapabilities;

/**
 * Base class for Test classes.
 * 
 * @author Cristian R
 *
 */
public abstract class BaseMobileTest {

	protected HomeScreen homeScreen;
	public static AndroidDriver<AndroidElement> driver;
	public Logger log = Logger.getLogger(BaseMobileTest.class);

	public void setUpStartApp() {
		homeScreen = new HomeScreen(getDriver());
	}

	/**
	 * SetUp before to run suite of test.
	 * 
	 * @author Cristian R
	 * 
	 */
	@BeforeMethod(alwaysRun = true)
	public void environmentSetUp() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		ConfigCapabilities.deviceSetUp(capabilities);
		ConfigCapabilities.applicationSetUp(capabilities);
		try {
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723"), capabilities);
		} catch (MalformedURLException exception) {
			exception.printStackTrace();
		}
		setUpStartApp();
	}

	/**
	 * Close the application after completing the test.
	 * 
	 * @author Cristian R
	 * 
	 */
	@AfterMethod(alwaysRun = true)
	public void mobileApplicationEnd() {
		driver.quit();
	}

	/**
	 * return the driver.
	 * 
	 * @author Cristian R
	 * 
	 * @return driver
	 */
	public AndroidDriver<AndroidElement> getDriver() {
		return driver;
	}

	/**
	 * return HomeScreen.
	 *
	 * @author Cristian R
	 *
	 * @return HomeScreen
	 */
	protected HomeScreen loadHomeScreen() {
		return homeScreen.loadHomeScreen();
	}


}
