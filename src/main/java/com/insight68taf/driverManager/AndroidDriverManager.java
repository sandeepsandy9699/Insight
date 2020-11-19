package com.insight68taf.driverManager;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.insight68taf.utils.PropertyFileLoader;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @name : AndroidDriverManager
 * @author Sandeep
 * @description AndroidDriver initialization and managing the properties of the
 *              AndroidDriver
 *
 */
public class AndroidDriverManager {

	public static AndroidDriver<AndroidElement> driver;
	public static String platformType = null;
	private static DesiredCapabilities dc;
	private static final Logger logger = Logger.getLogger(AndroidDriverManager.class);

	public AndroidDriverManager() {

	}

	/**
	 * @name : getDriver
	 * @description initializing the driver and returns the AndroidDriver instance
	 * @return - AndroidDriver
	 */

	public static AndroidDriver<AndroidElement> getDriver() {

		String brw = PropertyFileLoader.getConfigInstance().getConfigValue("devicetype");
		if (brw.contentEquals("emulator")) {
			File f = new File("F:\\Appium\\Staf_SBM\\src\\test\\resources\\Apps");
			File fs = new File(f, PropertyFileLoader.getConfigInstance().getConfigValue("app_name"));

			// Desired capabilities to invoke app in Emulator
			dc = new DesiredCapabilities();
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "sbm_pie");
			dc.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

		} else if (brw.contentEquals("realdevice")) {
			// Desired capabilities to invoke app in Real Device
			dc = new DesiredCapabilities();
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
			// dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
			dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.dristia.SAM");
			dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.dristia.sam.activities.Welcome");
		}
		try {
			// Establishing connection to the Appium server
			driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * @name : closeDriver
	 * @description close or quit the AndroidDriver
	 * @return - void
	 */
	public static void closeDriver() {
		try {
			driver.quit();
			// driver.close();
		} catch (Exception e) {
			logger.error("Either Driver is not initialized or closed before");
		}

	}

}
