package com.insight68taf.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.insight68taf.driverManager.AndroidDriverManager;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/**
 * @author Sandeep This class methods are used to Perform mobile specific
 *         operations
 */
public class AndroidHelper {

	private static final Logger logger = Logger.getLogger(AndroidHelper.class);
	public AndroidDriver<AndroidElement> driver;
	Properties properties;

	/**
	 * @name : AndroidHelper
	 * @description constructor of present class
	 * @param driver
	 *            - instance of AndroidDriver
	 */
	public AndroidHelper(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	// ******************* Android Action Methods
	// ******************************************
	/**
	 * @name : getDriver
	 * @return
	 * @description open the driver
	 * @return void
	 */
	protected AndroidDriver<AndroidElement> getDriver() {
		return driver;
	}

	/**
	 * @name listEleSwipe
	 * @param element
	 * @param index
	 */
	public void listEleSwipe(List<AndroidElement> element, int index) {
		Point d = element.get(index).getLocation();
		int startX = d.getX();
		int startY = d.getY();
		int endY = d.getX() / 2;
		new TouchAction<>(driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(startX, endY))
				.release().perform();
		logger.info("SwipeUp action Performed Successfully.");
	}

	/**
	 * @name : swipeUp
	 * @Description - By using this method we can swipe the screen from bottom to
	 *              top
	 */
	public void swipeUp() {
		Dimension size = driver.manage().window().getSize();
		int startX = size.getWidth() / 2;
		int startY = (int) (size.getHeight() * 0.50);
		int endY = (int) (size.getHeight() * 0.20);
		new TouchAction<>(driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10))).moveTo(PointOption.point(startX, endY))
				.release().perform();
		System.out.println(startX + ":" + startY + ":" + endY);
		logger.info("SwipeUp action Performed Successfully.");
	}

	/**
	 * @name : swipeDown
	 * @Description - By using this method we can swipe the screen from top to
	 *              bottom
	 */

	public void swipeDown() {
		Dimension size = driver.manage().window().getSize();
		int startX = size.width / 2;
		int startY = (int) (size.getHeight() * 0.20);
		int endY = (int) (size.getHeight() * 0.50);
		new TouchAction<>(driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(startX, endY))
				.release().perform();
		logger.info("SwipeDown action Performed Successfully.");
	}

	/**
	 * @name swipeLeft
	 * @description By using this method we can swipe the screen horizontally left
	 */
	@SuppressWarnings("rawtypes")
	public void swipeLeft() {
		Dimension size = driver.manage().window().getSize();
		int startx = (int) (size.width * 0.70);
		int endx = (int) (size.width * 0.02);
		int starty = size.height / 2;
		new TouchAction(driver).press(PointOption.point(startx, starty))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endx, starty))
				.release().perform();
		logger.info("Swipe Left action performed Successfully.");
	}

	/**
	 * @name swipeRight
	 * @description By using this method we can swipe the screen horizontally right
	 */
	@SuppressWarnings("rawtypes")
	public void swipeRight() {
		Dimension size = driver.manage().window().getSize();
		int startx = (int) (size.width / 0.02);
		int endx = (int) (size.width * 0.70);
		int starty = size.height / 2;
		new TouchAction(driver).press(PointOption.point(startx, starty))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endx, starty))
				.release().perform();
		logger.info("Swipe Right action performed Successfully.");

	}

	/**
	 * @name closeKeyBoard
	 * @Description - By using this method we can hide the Keyboard
	 */
	public void closeKeyBoard() {
		driver.hideKeyboard();
		logger.info("Keyboard closed Successfully.");
	}

	/**
	 * @name runAppInBkGrnd
	 * @description by using this method we can run the app in background for a
	 *              particular period of time
	 * @param timeType
	 *            - seconds/minutes
	 * @param time
	 *            - Duration of the time that the app to be in background(Default
	 *            time is 1Sec)
	 */
	public void runAppInBkGrnd(String durationType, int duration) {

		if (durationType.equals("seconds")) {
			driver.runAppInBackground(Duration.ofSeconds(duration));
			logger.info("App Running in the Background");
			driver.launchApp();
			logger.info("App Running in the Foreground");
		} else if (durationType.equals("minutes")) {
			driver.runAppInBackground(Duration.ofMinutes(duration));
			logger.info("App Running in the Background");
			driver.launchApp();
			logger.info("App Running in the Foreground");
		}

	}

	/**
	 * @name lockScreen
	 * @description By using this method we can lock the screen(Emulator or Real
	 *              Device)
	 */
	public void lockScreen() {
		driver.lockDevice();
		logger.info("Device Screen Locked Successfully.");
	}

	/**
	 * @name unLockScreen
	 * @description By using this method we can UnLock the screen (Emulator or Real
	 *              Device)
	 */
	public void unLockScreen() {
		driver.unlockDevice();
		logger.info("Device Screen UnLocked Successfully.");
	}

	/**
	 * @name clickHomeButton
	 * @description By using this method we can click the Device Home Button
	 *              (Emulator or Real Device)
	 */
	public void clickHomeButton() {
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		logger.info("Device Home Button Clicked Successfully.");
	}

	/**
	 * @name clickDeviceBackButton
	 * @description By using this method we can click the Device Back Button
	 *              (Emulator or Real Device)
	 */
	public void clickDeviceBackButton() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		logger.info("Device Back Button Clicked Successfully.");
	}

	/**
	 * @name clickDevicePowerButton
	 * @description By using this method we can click the Device Power Button
	 *              (Emulator or Real Device)
	 */
	public void clickDevicePowerButton() {
		driver.pressKey(new KeyEvent(AndroidKey.POWER));
		logger.info("Device Power Button Clicked Successfully.");
	}

	/**
	 * @name clickDeviceRecentButton
	 * @description By using this method we can click the Device Recent Button
	 *              (Emulator or Real Device)
	 */
	public void clickDeviceRecentButton() {
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		logger.info("Device Recent Button Clicked Successfully.");
	}

	// **** Helper Methods Starts from here********************

	/**
	 * @name : click
	 * @description click on an element when an element passed as String
	 * @param element
	 *            - PO
	 * @param description
	 *            - text to log information
	 * @return void
	 */
	protected void click(String element, String description) {
		logger.info("Into click by using locatior :" + element.toString());
		WebElement tempWebElement = null;
		try {
			tempWebElement = getElement(element);
			WebDriverWait wait = new WebDriverWait(driver,
					PropertyFileLoader.getConfigInstance().getAndroidDriverWait());
			if (isExists(tempWebElement)) {
				wait.until(ExpectedConditions.elementToBeClickable(tempWebElement));
				tempWebElement.click();
				logger.info(description + "is clicked");
			} else {
				logger.info(description + "is NOT clicked");
			}
		} catch (Exception e) {
			logger.error("Exception:: " + e.getMessage() + " generated while working with Click and element "
					+ element.toString());
			raiseException();
		}

	}

	/**
	 * @name : click
	 * @description click on an element when an element passed as WebElement
	 * @param element
	 *            - PO
	 * @param description
	 *            - text to log information
	 */
	protected void click(WebElement element, String description) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,
					PropertyFileLoader.getConfigInstance().getAndroidDriverWait());

			if (isExists(element)) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				logger.info(description + " is clicked");
			} else {
				logger.info(description + " is NOT clicked");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			raiseException();
		}
	}

	/**
	 * @name : getElement
	 * @description return the WebElement
	 * @param strElement
	 *            - type of locator and value of locator separated by ";"
	 * @return WebElement
	 */
	protected WebElement getElement(String strElement) {
		WebElement tempWebElement = null;
		WebDriverWait wait = new WebDriverWait(driver, PropertyFileLoader.getConfigInstance().getAndroidDriverWait());
		try {
			logger.info("Into getElement and working on : " + strElement);

			String tempElementPrefix, tempElementId;
			String[] tempElement;

			tempElement = strElement.split(";");
			tempElementPrefix = tempElement[0];
			tempElementId = tempElement[1];

			if (tempElementPrefix.toLowerCase().trim().startsWith("xpath")) {
				tempWebElement = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(tempElementId))));
			} else if (tempElementPrefix.toLowerCase().trim().startsWith("id")) {
				tempWebElement = wait.until(ExpectedConditions.presenceOfElementLocated((By.id(tempElementId))));
			} else if (tempElementPrefix.toLowerCase().trim().startsWith("link")) {
				tempWebElement = wait.until(ExpectedConditions.presenceOfElementLocated((By.linkText(tempElementId))));
			} else if (tempElementPrefix.toLowerCase().trim().startsWith("css")) {
				tempWebElement = wait
						.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(tempElementId))));
			} else if (tempElementPrefix.toLowerCase().trim().startsWith("name")) {
				tempWebElement = wait.until(ExpectedConditions.presenceOfElementLocated((By.name(tempElementId))));
			} else if (tempElementPrefix.toLowerCase().trim().startsWith("tag")) {
				tempWebElement = wait.until(ExpectedConditions.presenceOfElementLocated((By.tagName(tempElementId))));
			} else if (tempElementPrefix.toLowerCase().trim().startsWith("class")) {
				tempWebElement = wait.until(ExpectedConditions.presenceOfElementLocated((By.className(tempElementId))));
			}
			logger.info("Into getElement WebElement returned is : " + tempWebElement.toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
			raiseException();
		}
		return tempWebElement;

	}

	/**
	 * @name : isExists
	 * @description verifying is an element exists or not
	 * @param element
	 *            - PO
	 * @return Boolean
	 */
	protected boolean isExists(WebElement element) {

		boolean eleExists = false;
		try {
			if (element.getText() != null) {
				eleExists = true;
				logger.info("element is present");
			}
		} catch (NoSuchElementException e) {
			logger.error("element is not present");
			raiseException();
		}
		return eleExists;

	}

	/**
	 * @name : raiseException
	 * @description send the fail condition when exception raised
	 * @return void
	 */
	protected void raiseException() {

		takeScreenShot();
		cleanup();
		Assert.assertTrue(false);
		// Reporter.addScreenCaptureFromPath("imagePath");

	}

	/**
	 * @name : raiseException
	 * @description send the fail condition when exception raised
	 * @param assertionMsg
	 *            -
	 */
	protected void raiseException(String assertionMsg) {

		takeScreenShot();
		// cleanup();

		Assert.assertTrue(assertionMsg, false);
		// Reporter.addScreenCaptureFromPath("imagePath");

	}

	protected void takeScreenShot() {
		Random rand = new Random();
		try {
			// This takes a screenshot from the driver at save it to the specified location
			String screenshotName = "screenshotName";

			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Building up the destination path for the screenshot to save
			// Also make sure to create a folder 'screenshots' with in the cucumber-report
			// folder
			System.out.println("target screenshot : " + (System.getProperty("user.dir")
					+ "/target/cucumber-reports/screenshots/" + screenshotName + "_" + rand.nextInt(10000) + ".png"));

			File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/"
					+ screenshotName + "_" + rand.nextInt(10000) + ".png");

			destinationPath.getParentFile().mkdirs();
			destinationPath.createNewFile();
			// Copy taken screenshot from source location to destination location
			Files.copy(sourcePath, destinationPath);
			System.out.println("before reporter screenshot : " + destinationPath + "," + sourcePath);
			// This attach the specified screenshot to the test
			Reporter.addScreenCaptureFromPath(destinationPath.toString());

		} catch (IOException e) {

			System.out.println("Into Screenshot exception");
		}

	}

	/**
	 * @name : cleanup
	 * @description close the driver
	 * @return void
	 */
	protected void cleanup() {
		AndroidDriverManager.closeDriver();
		;

	}

	/**
	 * @name : isEnabled
	 * @description verifying element is enabled or not
	 * @param element
	 *            - PO
	 * @return Boolean
	 */
	public boolean isEnabled(WebElement element) {
		boolean temp = false;
		try {
			if (element.isEnabled()) {
				temp = true;
				return temp;
			}
		} catch (Exception e) {
			raiseException();
		}
		return temp;

	}

	/**
	 * @name : getElementAttribute
	 * @description return the value of attribute
	 * @param element
	 *            - PO
	 * @param attributeName
	 *            - name of the attribute
	 * @return String
	 */
	public String getElementAttribute(WebElement element, String attributeName) {

		String txtValue = "";
		try {
			if (this.isExists(element)) {
				txtValue = element.getAttribute(attributeName);
			} else
				return null;

		} catch (Exception e) {
			raiseException();
		}
		return txtValue;
	}

	/**
	 * @name : enterText
	 * @description enter text into the element
	 * @param element
	 *            - PO
	 * @param strText
	 *            - text to enter
	 * @param description
	 *            -
	 * @return void
	 */
	protected void enterText(WebElement element, String strText, String description) {
		logger.info("Into enterText by using input text " + strText + " and locator element :" + element.toString());
		try {
			WebDriverWait wait = new WebDriverWait(driver,
					PropertyFileLoader.getConfigInstance().getAndroidDriverWait());

			if (isExists(element)) {
				if (isEnabled(element)) {
					wait.until(ExpectedConditions.elementToBeClickable(element));
					element.click();
					element.clear();
					element.sendKeys(strText);
					logger.info("Enter text: " + strText);
				}
			}
		} catch (Exception e) {
			logger.error("Exception generated while working with enterText by using input text " + strText
					+ " and locator element :" + element.toString());
			raiseException();
		}
	}

	/**
	 * @name : getText
	 * @description return the text form element when an element passed as String
	 * @param element
	 *            - PO
	 * @param description
	 *            - text to log information
	 * @return String
	 */
	protected String getText(String element, String description) {
		WebElement temEle;
		String text = "";
		WebDriverWait wait = new WebDriverWait(driver, PropertyFileLoader.getConfigInstance().getAndroidDriverWait());
		try {
			temEle = getElement(element);
			if (isExists(temEle)) {
				wait.until(ExpectedConditions.visibilityOf(temEle));
				text = temEle.getText();
			} else {
				logger.info(description + " is not retrieved");
			}
		} catch (Exception e) {
			logger.info("Element is not displayed");
			raiseException();
		}

		return text;
	}

	/**
	 * @name : getText
	 * @description return the text of element
	 * @param element
	 *            - PO
	 * @param attributeName
	 *            - name of the attribute
	 * @return String
	 */
	public String getText(WebElement element, String description) {

		String txtValue = "";
		try {
			if (this.isExists(element)) {
				txtValue = element.getText();
				logger.info(description + " is Retrieved");
			} else
				logger.info(description + " is not Retrieved");
			return null;

		} catch (Exception e) {
			raiseException();
			logger.info(description + " is not Retrieved");
		}
		return txtValue;
	}

	/**
	 * @name : getAssertData
	 * @param element-
	 *            PO
	 * @param attributeName
	 *            - name of the attribute
	 * @return String
	 */
	public void assertData(String expectedVal, String actualVal) {
		try {
			Assert.assertEquals(expectedVal, actualVal);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			raiseException();
		}
	}

	/**
	 * @name : pause
	 * @description providing time delay explicitly
	 * @return void
	 */
	protected void pause() {

		try {
			Thread.sleep(PropertyFileLoader.getConfigInstance().getPause());
		} catch (InterruptedException e) {
			raiseException();
		}
	}

}