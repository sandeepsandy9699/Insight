package com.insight68taf.driverManager;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.insight68taf.utils.PropertyFileLoader;

/**
 * @name : WebDriverManager
 * @author Sandeep
 * @description Webdriver initialization and managing the properties of the
 *              webdriver
 *
 */
public class WebDriverManager {

	private static WebDriver driver = null;
	private static String driverType;

	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final Logger logger = Logger.getLogger(WebDriverManager.class);

	/**
	 * @name : getDriver
	 * @description initializing the driver and returns the webdriver instance
	 * @return - WebDriver
	 */
	@SuppressWarnings("deprecation")
	public static WebDriver getDriver() {
		driverType = PropertyFileLoader.getConfigInstance().getConfigValue("browser");
		logger.info("Initializing Driver :" + driverType);
		switch (driverType) {

		case "chrome":
			driver = drivers.get("Chrome");
			if (driver == null || driver.toString().contains("(null)")) {
				System.setProperty(CHROME_DRIVER_PROPERTY, PropertyFileLoader.getConfigInstance().getDriverPath());
				ChromeOptions options = new ChromeOptions();
				// options.addArguments("--headless");
				// options.addArguments("--disable-gpu");
				options.addArguments("--incognito");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(capabilities);
				drivers.put("Chrome", driver);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					logger.error("InterruptedException:: getDriver :" + e.getMessage());
				}
			}
			break;
		}
		return driver;
	}

	/**
	 * @name : closeDriver
	 * @description close or quit the webdriver
	 * @return - void
	 */
	public static void closeDriver() {
		try {
			if (driver != null)
				driver.quit();
		} catch (Exception e) {
			logger.error("Either Driver is not initialized or closed before" + e.getMessage());
		}
	}

}
