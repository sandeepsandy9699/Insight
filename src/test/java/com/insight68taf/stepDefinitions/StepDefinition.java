package com.insight68taf.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.insight68taf.driverManager.WebDriverManager;
import com.insight68taf.pageFactories.PageFactory;
import com.insight68taf.pages.AddNewProductPage;
import com.insight68taf.pages.CreateCompanyPage;
import com.insight68taf.pages.SignInPage;
import com.insight68taf.utils.PropertyFileLoader;
import com.insight68taf.utils.SeleniumHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * name StepDefinition
 * 
 * @author Sandeep description Step definitions for Insight68SighIn.feature file
 */
public class StepDefinition {

	WebDriver driver = WebDriverManager.getDriver();
	PageFactory pagefactory = new PageFactory(driver);
	SignInPage signinpage = new SignInPage(driver);
	SeleniumHelper seleniumHelper= new SeleniumHelper(driver);
	AddNewProductPage addnewproductpage = new AddNewProductPage(driver);
	CreateCompanyPage createcompanypage = new CreateCompanyPage(driver);

	@Given("^User is on Insight(\\d+) SignIn page$")
	public void user_is_on_Insight_SignIn_page(int arg1)  {
		driver.get(PropertyFileLoader.getConfigInstance().getqaURL());
	}

	@When("^User provides valid credentials and click on signin button$")
	public void user_provides_valid_credentials_and_click_on_signin_button() {
		String Signin = "Signin";
		seleniumHelper.imageScreenShot(Signin);
		
		signinpage.enterEmail(PropertyFileLoader.getConfigInstance().getEmail());
		signinpage.enterPassword(PropertyFileLoader.getConfigInstance().getPassword());
		signinpage.clickOnSignInButton();
	}

	@Then("^User navigated to Dashboard page$")
	public void user_navigated_to_Dashboard_page()  {
		// signinpage.validateToastMsg();
		signinpage.validateDashboardLabelText();
		String Dashboard = "Dashboard";
		seleniumHelper.imageScreenShot(Dashboard);
	}

	@Then("^User enter Invalid Email as \"([^\"]*)\"$")
	public void user_enter_Invalid_Email_as(String Email) {
		signinpage.enterEmail(Email);
		signinpage.clickOnSignInButton();
	}

	@Then("^Validate Email Error message text$")
	public void validate_Email_Error_message_text() {
		signinpage.validateEmailBlankError();
		signinpage.validateToastMsg();
	}

	@Then("^User enter valid Email and invalid \"([^\"]*)\"$")
	public void user_enter_valid_Email_and_invalid(String Password) {
		signinpage.enterEmail(PropertyFileLoader.getConfigInstance().getEmail());
		signinpage.enterPassword(Password);
		signinpage.clickOnSignInButton();
		signinpage.validateToastMsg();
	}

	@Then("^validate Password Error message text$")
	public void validate_Password_Error_message_text() {
		signinpage.validateBlankPasswordToastMsg();
	}
	
	@Then("^Logout from Insight application$")
	public void logout_from_Insight_application()  {
	    signinpage.clickOnUserAvatarBtn();
	    signinpage.clickOnSignOut();
	}

	// AddNewProduct Step Definition steps

	@Then("^Click on Products Tab$")
	public void click_on_Products_Tab() throws InterruptedException {
		driver.navigate().refresh();
		addnewproductpage.clickOnProductsTab();
	}

	@Then("^Click on Add New Product option$")
	public void click_on_Add_New_Product_option() {
		addnewproductpage.clickOnAddNewProductBtn();
	}

	@Then("^Enter Product name in Product name textbox$")
	public void enter_Product_name_in_Product_name_textbox() {

		addnewproductpage.enterProductName(PropertyFileLoader.getConfigInstance().getProductName());
	}

	@Then("^Enter Product Price in Product price textbox$")
	public void enter_Product_Price_in_Product_price_textbox() {
		addnewproductpage.enterProductPrice(PropertyFileLoader.getConfigInstance().getProductPrice());
	}

	@Then("^Select Trail duration in Trail duration Dropdown$")
	public void select_Trail_duration_in_Trail_duration_Dropdown() {
		addnewproductpage.selectTrailDuration(PropertyFileLoader.getConfigInstance().getTrialDuration());
	}

	@Then("^Select Product duration in Product duration Dropdown$")
	public void select_Product_duration_in_Product_duration_Dropdown() {
		addnewproductpage.selectProductDuration(PropertyFileLoader.getConfigInstance().getProductDuration());
	}

	@Then("^Browse the Product image$")
	public void browse_the_Product_image() {
		addnewproductpage.clickOnChooseimage();
		addnewproductpage.uploadImage(PropertyFileLoader.getConfigInstance().getUploadImage());
	}

	@Then("^Enter Product url if needed$")
	public void enter_Product_url_if_needed() {
		addnewproductpage.enterProductURL(PropertyFileLoader.getConfigInstance().getProductUrl());
	}

	@Then("^Browse the Product icon$")
	public void browse_the_Product_icon() {
		addnewproductpage.clickOnChooseicon();
		addnewproductpage.uploadIcon(PropertyFileLoader.getConfigInstance().getUploadIcon());
	}

	@Then("^Enter Product description in Product description textbox$")
	public void enter_Product_description_in_Product_description_textbox() {
		addnewproductpage.enterProductDescription(PropertyFileLoader.getConfigInstance().getProductDescription());
	}

	@Then("^Click on Publish button$")
	public void click_on_Publish_button() {
		addnewproductpage.clickOnPublishButton();
		//signinpage.validateToastMsg();
	}

	// Create Company Step Definition steps

	@Then("^Click on Company Mangement Tab$")
	public void click_on_Company_Mangement_Tab() {
		createcompanypage.clickOnCreateManagementTab();
	}

	@Then("^Click on Create Company option$")
	public void click_on_Create_Company_option() {
		createcompanypage.clickOnCreateCompanyBtn();
	}

	@Then("^Select role in Dropdown$")
	public void select_role_in_Dropdown() {
		createcompanypage.selectTheRole(PropertyFileLoader.getConfigInstance().getRoleType());
	}

	@Then("^Enter Company name in Company name textbox$")
	public void enter_Company_name_in_Company_name_textbox() {
		createcompanypage.enterComapnyName(PropertyFileLoader.getConfigInstance().getCompanyName());
	}

	@Then("^Enter First name in First name text box$")
	public void enter_First_name_in_First_name_text_box() {
		createcompanypage.enterFirstName(PropertyFileLoader.getConfigInstance().getFirstName());
	}

	@Then("^Enter Last name in Last name text box$")
	public void enter_Last_name_in_Last_name_text_box() {
		createcompanypage.enterLastName(PropertyFileLoader.getConfigInstance().getLastName());
	}

	@Then("^Enter Email Address in Email text box$")
	public void enter_Email_Address_in_Email_text_box() {
		createcompanypage.enterEmail(PropertyFileLoader.getConfigInstance().getCC_Email());
	}

	@Then("^Enter Password in Password text box$")
	public void enter_Password_in_Password_text_box() {
		createcompanypage.enterPassword(PropertyFileLoader.getConfigInstance().getCC_Password());
	}

	@Then("^Enter Confirm Password in Confirm Password text box$")
	public void enter_Confirm_Password_in_Confirm_Password_text_box() {
		createcompanypage.enterConfirmPwd(PropertyFileLoader.getConfigInstance().getCC_ConfirmPassword());
	}

	@Then("^Click on Country dropdown and select country$")
	public void click_on_Country_dropdown_and_select_country() {
		createcompanypage.selectCountry(PropertyFileLoader.getConfigInstance().getSelectCountry());
	}

	@Then("^Click on State dropdown and select State$")
	public void click_on_State_dropdown_and_select_State() {
		createcompanypage.selectState(PropertyFileLoader.getConfigInstance().getSelectState());
	}

	@Then("^Click on City dropdown and select City$")
	public void click_on_City_dropdown_and_select_City() {
		createcompanypage.selectCity(PropertyFileLoader.getConfigInstance().getSelectCity());
	}

	@Then("^Enter Location in Location text box$")
	public void enter_Location_in_Location_text_box() {
		createcompanypage.enterLocation(PropertyFileLoader.getConfigInstance().getLocation());
	}

	@Then("^Enter Mobile number in Mobile number text box$")
	public void enter_Mobile_number_in_Mobile_number_text_box() {
		createcompanypage.enterMobileNumber(PropertyFileLoader.getConfigInstance().getMobileNumber());
	}

	@Then("^Click on Submit button$")
	public void click_on_Submit_button() {
		createcompanypage.clickOnSubmitButton();
		//signinpage.validateToastMsg();
	}

}
