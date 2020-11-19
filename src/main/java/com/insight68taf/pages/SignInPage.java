package com.insight68taf.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.insight68taf.utils.PropertyFileLoader;
import com.insight68taf.utils.SeleniumHelper;

/**
 * @author Sandeep
 * @description SignInPage Locators and Methods
 */
public class SignInPage extends SeleniumHelper {

	private static final Logger logger = Logger.getLogger(SignInPage.class);
	WebDriver driver;
	WebDriverWait wait;

	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Email']")
	private WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Password']")
	private WebElement password;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement signInBtn;

	@FindBy(how = How.XPATH, using = "//a[text()=' Forgot Password?']")
	private WebElement forgotPwdLink;

	@FindBy(how = How.XPATH, using = "//button[@id='navbarDropdown']")
	private WebElement userAvatarBtn;

	@FindBy(how = How.XPATH, using = "//a[@class='dropdown-item pointer']")
	private WebElement signOut;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Dashboard')]")
	private WebElement dashboardLabelText;

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'Email is required')]")
	private WebElement emailBlankErrMsg;
	@FindBy(how = How.XPATH, using = "//small[contains(text(),'Email must be a valid email address')]")
	private WebElement emailInvalidErrMsg;
	@FindBy(how = How.XPATH, using = "(//div[@id='toast-container']//div)[3]")
	private WebElement ToastMessage;

	public void enterEmail(String emailAddress) {
		logger.info("Enters email as : " + emailAddress + " on SignInPage");
		enterText(email, emailAddress, "Enters email");
	}

	public void enterPassword(String pwd) {
		logger.info("Enters password as : " + pwd + " on SignInPage");
		enterText(password, pwd, "Enters Password :");
	}

	public void clickOnSignInButton() {
		logger.info("Clicking on SignIn Button on SignInPage");
		click(signInBtn, "Click on SignIn Button on SignInPage");
		//waitForPageLoad();
	}

	public void validateEmailBlankError() {
		logger.info("validate Email address Error Message text ");
		String emailBlankErrText = emailBlankErrMsg.getText();
		System.out.println("Email address Error Message text is    " + emailBlankErrText);
		assertData(PropertyFileLoader.getMessageInstance().getEmailBlankError(), emailBlankErrText);
	}

	public void validateBlankPasswordToastMsg() {
		logger.info("validate Blank Password Toast message text ");
		String ToastMessageText = ToastMessage.getText();
		System.out.println("Toast message is       " + ToastMessageText);
		assertData(PropertyFileLoader.getMessageInstance().getpwdBlankToastMsg(), ToastMessageText);
	}

	public void validateDashboardLabelText() {
		waitForPageLoad();
		logger.info("validate Dashboard Label Text on DashboardPage");
		String dashboardLabel = dashboardLabelText.getText();
		logger.info("Dashboard Label Text is    " + dashboardLabel);
		assertData(PropertyFileLoader.getConfigInstance().getdashboardLabelText(), dashboardLabel);
		waitForPageLoad();
	}

	public void validateToastMsg() {
		logger.info("validate Toast message text ");
		String ToastMessageText = ToastMessage.getText();
		System.out.println("Toast message is       " + ToastMessageText);
	}

	public void clickOnUserAvatarBtn() {
		waitForPageLoad();
		logger.info("Clicking on User avatar icon on SignInPage");
		click(userAvatarBtn, "Click on User avatar icon on SignInPage");
	}
	
	public void clickOnSignOut() {
		logger.info("Clicking on SignOut button on SignInPage");
		click(signOut, "Click on SignOut button on SignInPage");
	}
	
}
