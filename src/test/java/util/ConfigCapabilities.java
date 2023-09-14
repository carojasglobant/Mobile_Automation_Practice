package util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileNotFoundException;
import java.io.FileReader;

import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Class for capabilities configuration from external file.
 * 
 * @author Cristian R
 *
 */
public class ConfigCapabilities {

	private static final String DEVICE_NAME = "appium:deviceName";
	private static final String PLATFORM_NAME = "platformName";
	private static final String PLATFORM_VERSION = "appium:platformVersion";
	private static final String APP_PACKAGE = "appium:appPackage";
	private static final String APP_ACTIVITY = "appium:appActivity";
	private static final String JSON_FILE_PATH = "src/test/resources/mobile_capabilities.json";
	private static final String APP = "appium:app";
	private static final String AUTOMATION_NAME = "appium:automationName";
	private static JsonParser parser = new JsonParser();

	/**
	 * SetUp's application.
	 * 
	 * @author Cristian R
	 * 
	 * @param capabilities
	 *            : DesiredCapabilities
	 */
	public static void applicationSetUp(DesiredCapabilities capabilities) {
		capabilities.setCapability("appPackage", getJsonDataProperty(APP_PACKAGE));
		capabilities.setCapability("appActivity", getJsonDataProperty(APP_ACTIVITY));
		capabilities.setCapability("app", getJsonDataProperty(APP));
	}

	/**
	 * Device SetUp.
	 * 
	 * @author Cristian R
	 * 
	 * @param capabilities
	 *            : DesiredCapabilities
	 */
	public static void deviceSetUp(DesiredCapabilities capabilities) {
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getJsonDataProperty(DEVICE_NAME));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getJsonDataProperty(PLATFORM_VERSION));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getJsonDataProperty(PLATFORM_NAME));
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, getJsonDataProperty(AUTOMATION_NAME));
	}

	/**
	 * Method for get data form JSON file.
	 * 
	 * @author Cristian R
	 *
	 * @param property
	 *            : String
	 * @return String
	 */
	private static String getJsonDataProperty(String property) {
		try {
			Object obj = parser.parse(new FileReader(JSON_FILE_PATH));
			JsonObject jsonObject = (JsonObject) obj;
			return jsonObject.get(property)
				.getAsString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
