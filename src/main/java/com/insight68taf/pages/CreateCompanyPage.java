package com.insight68taf.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.insight68taf.utils.SeleniumHelper;

/**
 * @author Sandeep
 * @description CreateCompanyPage Locators and Methods
 */
public class CreateCompanyPage extends SeleniumHelper {

	WebDriver driver;
	private static final Logger logger = Logger.getLogger(SignInPage.class);

	public CreateCompanyPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Company Management')]")
	private WebElement createManagementTab;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Create Company')]")
	private WebElement createCompanyBtn;

	@FindBy(how = How.XPATH, using = "//select[@id='role']")
	private WebElement role;

	@FindBy(how = How.XPATH, using = "//select[@id='client_master']")
	private WebElement clientMaster;

	@FindBy(how = How.XPATH, using = "//select[@id='site_admin']")
	private WebElement siteAdmin;

	@FindBy(how = How.XPATH, using = "//input[@id='organizationName']")
	private WebElement companyname;

	@FindBy(how = How.XPATH, using = "//input[@id='firstname']")
	private WebElement firstname;

	@FindBy(how = How.XPATH, using = "//input[@id='lastname']")
	private WebElement latsname;

	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	private WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	private WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@id='passwordConfirm']")
	private WebElement confirmPwd;

	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	private WebElement country;

	@FindBy(how = How.XPATH, using = "//select[@id='state']")
	private WebElement state;

	@FindBy(how = How.XPATH, using = "//select[@id='city']")
	private WebElement city;

	@FindBy(how = How.XPATH, using = "//input[@id='location']")
	private WebElement loaction;

	@FindBy(how = How.XPATH, using = "//input[@id='mobilenumber']")
	private WebElement mobileNumber;

	@FindBy(how = How.XPATH, using = "//button[@class='btn-publish']")
	private WebElement submitBtn;

	// Blank Error messages

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'Organization name is required')]")
	private WebElement companyBlankErrMsg;

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'First name is required')]")
	private WebElement firstNameBlankErrMsg;

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'Last name is required')]")
	private WebElement lastNameBlankErrMsg;

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'Email is required')]")
	private WebElement emailBlankErrMsg;

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'Password is required')]")
	private WebElement passwordBlankErrMsg;

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'Confirm password is required')]")
	private WebElement confirmPwdBlankErrMsg;

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'Country is required')]")
	private WebElement counrtyBlankErrMsg;

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'State is required')]")
	private WebElement stateBlankErrMsg;

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'City is required')]")
	private WebElement cityBlankErrMsg;

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'Location is required')]")
	private WebElement locationBlankErrMsg;

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'Mobile number is required')]")
	private WebElement mobileNumberBlankErrMsg;

	// Invalid Error messages

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'Organization name must be at least 4 character long')]")
	private WebElement companyInvalidErrMsg;

	@FindBy(how = How.XPATH, using = "(//div[@class='ng-star-inserted'])[1]")
	private WebElement firstNameInvalidErrMsg;

	@FindBy(how = How.XPATH, using = "(//div[@class='ng-star-inserted'])[2]")
	private WebElement lastNameInvalidErrMsg;

	@FindBy(how = How.XPATH, using = "(//div[@class='ng-star-inserted'])[3]")
	private WebElement emailInvalidErrMsg;

	@FindBy(how = How.XPATH, using = "(//div[@class='ng-star-inserted'])[4]")
	private WebElement passwordInvalidErrMsg;

	@FindBy(how = How.XPATH, using = "(//div[@class='ng-star-inserted'])[6]")
	private WebElement confirmPwdInvalidErrMsg;

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'Location must be at least 4 character long')]")
	private WebElement locationInvalidErrMsg;

	@FindBy(how = How.XPATH, using = "(//div[@class='ng-star-inserted'])[8]")
	private WebElement mobileNumberInvalidErrMsg;

	public void selectTheRole(String roleType) {
		logger.info("Selecting the role as : " + roleType + " on Create Company page");
		selectListValuebyVisbileText(role, roleType, "Selected the role");
	}

	public void selectClientMaster(String clientMasterType) {
		logger.info("Selecting the client master as : " + clientMasterType + " on Create Company page");
		selectListValuebyVisbileText(clientMaster, clientMasterType, "Selected the client master");
	}

	public void selectSiteAdmin(String siteAdminType) {
		logger.info("Selecting the Site Admin as : " + siteAdminType + " on Create Company page");
		selectListValuebyVisbileText(siteAdmin, siteAdminType, "Selected the site Admin");
	}

	public void enterComapnyName(String companyName) {
		logger.info("Enters company name as : " + companyName + " on Create Company page");
		enterText(companyname, companyName, "Entered company Name");
	}

	public void enterFirstName(String firstName) {
		logger.info("Entering first name as : " + firstName + " on Create Company page");
		enterText(firstname, firstName, "Entered first name :");
	}

	public void enterLastName(String lastName) {
		logger.info("Entering last name as : " + lastName + " on Create Company page");
		enterText(latsname, lastName, "Entered last name :");
	}

	public void enterEmail(String emailAddress) {
		logger.info("Entering email address as : " + emailAddress + " on Create Company page");
		enterText(email, emailAddress, "Entered email address :");
	}

	public void enterPassword(String Pwd) {
		logger.info("Entering Password as : " + Pwd + "  on Create Company page");
		enterText(password, Pwd, "Entered Password :");
	}

	public void enterConfirmPwd(String ConfirmPassword) {
		logger.info("Entering Confirm Password as : " + ConfirmPassword + "  on Create Company page");
		enterText(confirmPwd, ConfirmPassword, "Entered Confirm Password:");
	}

	public void selectCountry(String countryName) {
		logger.info("Selecting the country name as : " + countryName + " on Create Company page");
		selectListValuebyVisbileText(country, countryName, "Selected the Country name :");
	}

	public void selectState(String stateName) {
		logger.info("Selecting the state name as : " + stateName + " on Create Company page");
		selectListValuebyVisbileText(state, stateName, "Selected the state name :");
	}

	public void selectCity(String cityName) {
		logger.info("Selecting the city name as : " + cityName + " on Create Company page");
		selectListValuebyVisbileText(city, cityName, "Selected the City name :");
	}

	public void enterLocation(String location) {
		logger.info("Entering location as : " + location + "  on Create Company page");
		enterText(loaction, location, "Enters location :");
	}

	public void enterMobileNumber(String mobileNmbr) {
		logger.info("Entering the mobile number as : " + mobileNmbr + "  on Create Company page");
		enterText(mobileNumber, mobileNmbr, "Enters mobile number :");
	}

	public void clickOnSubmitButton() {
		logger.info("Clicking on Submit Button on Create Company page");
		clickWithJavaScriptExecutor(submitBtn, "Click on Publish Button on Create Company page");
		waitForPageLoad();
	}

	public void clickOnCreateManagementTab() {
		waitForPageLoad();
		waitForPageLoad();
		logger.info("Clicking on Create Management Tab Dashboard page");
		clickWithJavaScriptExecutor(createManagementTab, "Click on Create Management Tab Dashboard page");
		// waitForPageLoad();
	}

	public void clickOnCreateCompanyBtn() {
		waitForPageLoad();
		logger.info("Clicking on Create Company Button on Create Company page");
		clickWithJavaScriptExecutor(createCompanyBtn, "Click on Create Company Button on Create Company page");
		waitForPageLoad();
	}

}
