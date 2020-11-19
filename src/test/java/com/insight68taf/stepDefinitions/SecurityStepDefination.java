package com.insight68taf.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.zaproxy.clientapi.core.ClientApiException;

import com.insight68taf.driverManager.WebDriverManager;
import com.insight68taf.pageFactories.PageFactory;
import com.insight68taf.pages.SignInPage;
import com.insight68taf.security.owaspzap.api.ZapApi;
import com.insight68taf.security.owaspzap.zap.Zap;
import com.insight68taf.utils.PropertyFileLoader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * name SecurityStepDefination
 * 
 * @author Sandeep description Step definitions for Security.feature file
 */

public class SecurityStepDefination {

	WebDriver driver = WebDriverManager.getDriver();
	PageFactory pagefactory = new PageFactory(driver);
	SignInPage signinpage = new SignInPage(driver);

	ZapApi zapApi;
	Zap zap;

	@Given("^User navigated to insight(\\d+) application$")
	public void user_navigated_to_insight_application(int arg1) {

		driver.get(PropertyFileLoader.getConfigInstance().getqaURL());
		
		 zapApi = new ZapApi(PropertyFileLoader.getConfigInstance().getqaURL()); 
		 zap = new Zap(zapApi);
		 
	}

	@When("^User provides credentials and click on signin button$")
	public void user_provides_credentials_and_click_on_signin_button() {

		signinpage.enterEmail(PropertyFileLoader.getConfigInstance().getEmail());
		signinpage.enterPassword(PropertyFileLoader.getConfigInstance().getPassword());
		signinpage.clickOnSignInButton();
	}

	@Then("^Using the OWSAP ZAP application gets scaned and generate Report$")
	public void using_the_OWSAP_ZAP_application_gets_scaned_and_generate_Report()
			throws ClientApiException, InterruptedException {

		zap.doSpidering();
		zap.doPassiveScan();
		zap.doActiveScan();
		zapApi.generateHtmlReport("Security_Report.html");
	}

}
