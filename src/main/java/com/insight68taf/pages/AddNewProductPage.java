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
 * @description AddNewProduct Page Locators and Methods
 */
public class AddNewProductPage extends SeleniumHelper {

	WebDriver driver;
	private static final Logger logger = Logger.getLogger(AddNewProductPage.class);

	public AddNewProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Add New Product WebElemnts
	 */
	@FindBy(how = How.XPATH, using = "//input[@id='productName']")
	private WebElement productname;

	@FindBy(how = How.XPATH, using = "//input[@id='productPrice']")
	private WebElement productprice;

	@FindBy(how = How.XPATH, using = "//select[@id='trialDuration']")
	private WebElement trailduration;

	@FindBy(how = How.XPATH, using = "//select[@id='productDuration']")
	private WebElement productduration;

	@FindBy(how = How.XPATH, using = "//input[@id='productUrl']")
	private WebElement producturl;

	@FindBy(how = How.XPATH, using = "//textarea[@id='productDescription']")
	private WebElement productdescription;

	@FindBy(how = How.XPATH, using = "//label[text()='Choose image']")
	private WebElement chooseimage;

	@FindBy(how = How.XPATH, using = "//label[text()='Choose icon']")
	private WebElement chooseicon;

	@FindBy(how = How.XPATH, using = "//button[@class='btn-publish']")
	private WebElement publishBtn;

	@FindBy(how = How.XPATH, using = "//small[@class='note-color']")
	private WebElement note;

	@FindBy(how = How.XPATH, using = "//a[text()='Products']")
	private WebElement productsTab;

	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Add New Product')]")
	private WebElement addNewProductBtn;

	// Blank Error messages

	@FindBy(how = How.XPATH, using = "(//div[@class='ng-star-inserted'])[1]")
	private WebElement productnameBlankErrMsg;

	@FindBy(how = How.XPATH, using = "(//div[@class='ng-star-inserted'])[2]")
	private WebElement productpriceBlankErrMsg;

	@FindBy(how = How.XPATH, using = "(//div[@class='ng-star-inserted'])[3]")
	private WebElement productdescriptionBlankErrMsg;

	// Invalid Error messages

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'Product name should be minimum 2 characters')]")
	private WebElement productnameInvalidErrMsg;

	@FindBy(how = How.XPATH, using = "//small[contains(text(),'Product description must be at least 16 characters long')]")
	private WebElement productdescriptionInvalidErrMsg;

	/**
	 * Add New Product page methods
	 */
	public void enterProductName(String productName) {
		// waitForPageLoad();
		logger.info("Enters prouct name as : " + productName + " on Add New Product page");
		enterText(productname, productName, "Enters Product Name");
	}

	public void enterProductPrice(String productPrice) {
		logger.info("Enters product price as : " + productPrice + " on Add New Product page");
		enterText(productprice, productPrice, "Enters Product Price :");
	}

	public void selectTrailDuration(String trailDurationText) {
		logger.info("Selected the trail duration as : " + trailDurationText + " on Add New Product page");
		selectListValuebyVisbileText(trailduration, trailDurationText, "Selected the trail duration");
	}

	public void selectProductDuration(String productDurationText) {
		logger.info("Selected the product duration as : " + productDurationText + " on Add New Product page");
		selectListValuebyVisbileText(productduration, productDurationText, "Selected the trail duration");
	}

	public void enterProductURL(String productURL) {
		logger.info("Enters productURL as : " + productURL + " on Add New Product page");
		enterText(producturl, productURL, "Enters Product URL :");
	}

	public void enterProductDescription(String productDescription) {
		logger.info("Enters product description as : " + productDescription + " on Add New Product page");
		enterText(productdescription, productDescription, "Enters Product URL :");
	}

	public void uploadImage(String imagePath) {
		logger.info("Uploading product image as : " + imagePath + "  on Add New Product page");
		uploadFile(chooseimage, imagePath, "Uploaded product image");
	}

	public void uploadIcon(String iconPath) {
		logger.info("Uploading product icon as : " + iconPath + "  on Add New Product page");
		uploadFile(chooseicon, iconPath, "Uploaded product icon");
	}

	public void clickOnPublishButton() {
		logger.info("Clicking on Publish Button on Add New Product page");
		clickWithJavaScriptExecutor(publishBtn, "Click on Publish Button on Add New Product page");
		//waitForPageLoad();
	}

	public void clickOnProductsTab() throws InterruptedException {
		waitForPageLoad();
		logger.info("Clicking on productsTab on Dashboard page");
		clickWithJavaScriptExecutor(productsTab, "Click on productsTab on Dashboard page");
		waitForPageLoad();
	}

	public void clickOnAddNewProductBtn() {
		waitForPageLoad();
		logger.info("Clicking on Add New Product Buttton on Products page");
		clickWithJavaScriptExecutor(addNewProductBtn, "Click on Add New Product Buttton on Products page");
		waitForPageLoad();
	}

	public void clickOnChooseimage() {
		logger.info("Clicking on chooseimage Button on Add New Product page");
		click(chooseimage, "Click on chooseimage Button on Add New Product page");
		waitForPageLoad();
	}

	public void clickOnChooseicon() {
		logger.info("Clicking on chooseicon Button on Add New Product page");
		click(chooseicon, "Click on chooseicon Button on Add New Product page");
		waitForPageLoad();
	}
}
