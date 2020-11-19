package com.insight68taf.pageFactories;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.insight68taf.pages.AddNewProductPage;
import com.insight68taf.pages.CreateCompanyPage;
import com.insight68taf.pages.SignInPage;

/**
 * @author Sandeep
 * @description We use PageFactory for Page Factory pattern to initialize
 *              WebElements which are defined in Page Objects
 */

public class PageFactory {

	private static final Logger logger = Logger.getLogger(PageFactory.class);

	private SignInPage signinpage;
	private AddNewProductPage addnewproductpage;
	private CreateCompanyPage createcompanypage;

	private WebDriver driver;

	/***
	 * Constructor
	 * 
	 * @param driver
	 *            an instance of WebDriver
	 */
	public PageFactory(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @description Create object of SignInPage Class
	 * @return Instantiate the SignInPage Class
	 */
	public SignInPage getSignInPage() {
		logger.info("Initializing SignInPage");
		return (signinpage == null) ? signinpage = new SignInPage(driver) : signinpage;
	}

	/**
	 * @description Create object of AddNewProductPage Class
	 * @return Instantiate the AddNewProductPage Class
	 */
	public AddNewProductPage getAddNewProductPage() {
		logger.info("Initializing AddNewProductPage");
		return (addnewproductpage == null) ? addnewproductpage = new AddNewProductPage(driver) : addnewproductpage;
	}

	/**
	 * @description Create object of CreateCompanyPage Class
	 * @return Instantiate the CreateCompanyPage Class
	 */
	public CreateCompanyPage getCreateCompanyPage() {
		logger.info("Initializing CreateCompanyPage");
		return (createcompanypage == null) ? createcompanypage = new CreateCompanyPage(driver) : createcompanypage;
	}

}
