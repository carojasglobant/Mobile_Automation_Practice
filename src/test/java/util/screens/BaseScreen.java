package util.screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.lang.String.format;
import static java.time.Duration.ofMillis;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Base class for all screens Objects.
 * 
 * @author Cristian Rojas
 *
 */
public abstract class BaseScreen {

	/** Bottom bar home button */
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Home\"]")
	protected AndroidElement homeButton;

	/** Bottom bar webView button */
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Webview\"]")
	protected AndroidElement webViewButton;

	/** Bottom bar log in button */
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Login\"]")
	protected AndroidElement logInButton;

	/** Bottom bar forms button */
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Forms\"]")
	protected AndroidElement formsButton;

	/** Bottom bar swipe button */
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Swipe\"]")
	protected AndroidElement swipeButton;

	/** Bottom bar drag button */
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Drag\"]")
	protected AndroidElement dragButton;

	
	/** The driver. */
	protected final AndroidDriver<AndroidElement> driver;
	
	/** The log. */
	public Logger log = Logger.getLogger(BaseScreen.class);

	/**
	 * Constructor method for standard screens object.
	 * 
	 * @author Cristian R
	 * 
	 * @param driver
	 *            : AndroidDriver
	 */
	public BaseScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
	}


	/**
	 * Wrapper for click  event.
	 * 
	 * @author Hans.Marquez
	 *
	 * @param element : AndroidElement
	 */
	public void click(AndroidElement element) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	
	/**
	 * Wrapper for sendKeys event.
	 * 
	 * @author Hans.Marquez
	 *
	 * @param element : AndroidElement
	 * @param sequence: String
	 */
	public void sendKeys(AndroidElement element, String sequence) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(sequence);
	}
	
	/**
	 * Wrapper for sendKeys event.
	 * 
	 * @author Cristian R
	 *
	 * @param element : AndroidElement
	 */
	public boolean isElementAvailable(AndroidElement element) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
	}



	public void horizontalSwipeByPoints (AndroidElement androidElement, int xpoint, int ypoint) {
		TouchAction touchAction = new TouchAction(driver);
		PointOption swipe = new PointOption();

		swipe.withCoordinates(xpoint,ypoint);

		touchAction
				.press(ElementOption.element(androidElement))
				.waitAction(waitOptions(ofMillis(1000)))
				.moveTo(swipe)
				.release().perform();
	}


}
