package com.insight68taf.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @name : PropertyFileLoader
 * @author Sandeep
 * @description reads the config properties file and returns the specific value
 *
 */
public class PropertyFileLoader {

	private static final Logger logger = Logger.getLogger(PropertyFileLoader.class);

	private static PropertyFileLoader configInstance = null;
	private Properties configProperties;

	private static PropertyFileLoader messageInstance = null;
	private Properties messageProperties;

	/**
	 * This is used to load the property file based on input
	 * 
	 * @param path
	 *            path of the property file
	 * @throws IOException
	 */
	protected PropertyFileLoader(String filePath) throws IOException {
		// File file = new File(filePath);
		BufferedReader reader;
		if (filePath.contains("configurations")) {
			reader = new BufferedReader(new FileReader(filePath));
			configProperties = new Properties();
			try {
				configProperties.load(reader);
				reader.close();
				logger.info("loaded the property file");
			} catch (IOException e) {
				logger.error("IOException:: PropertyFileLoader:: " + e.getMessage());
			}
		} else if (filePath.contains("messages")) {
			reader = new BufferedReader(new FileReader(filePath));
			messageProperties = new Properties();
			try {
				messageProperties.load(reader);
				reader.close();
			} catch (IOException e) {
				logger.error("IOException:: PropertyFileLoader:: " + e.getMessage());
			}
		}

	}

	/**
	 * This is used to get the configure property file instance, help you to get the
	 * property value
	 * 
	 * @param path
	 *            file path
	 * @return PropertyFileLoader instance
	 */
	public static PropertyFileLoader getConfigInstance() {
		if (configInstance == null) {
			try {
				configInstance = new PropertyFileLoader("src/test/resources/configurations.properties");
			} catch (IOException ioe) {
				logger.error("getConfigInstance :: IOException :: " + ioe.getMessage());
			} catch (Exception ex) {
				logger.error("getConfigInstance :: Exception :: " + ex.getMessage());
			}
		}
		return configInstance;
	}

	/**
	 * This is used to get the message property file instance, help you to get the
	 * property value
	 * 
	 * @param path
	 *            file path
	 * @return PropertyFileLoader instance
	 */
	public static PropertyFileLoader getMessageInstance() {
		if (messageInstance == null) {
			try {
				messageInstance = new PropertyFileLoader("src/test/resources/messages.properties");
			} catch (IOException ioe) {
				logger.error("getMessageInstance :: IOException :: " + ioe.getMessage());
			} catch (Exception ex) {
				logger.error("getMessageInstance :: Exception :: " + ex.getMessage());
			}
		}
		return messageInstance;
	}

	/**
	 * This method is used to get the value based on specified key from the Config
	 * property file
	 * 
	 * @param key
	 * @return value as string
	 */
	public String getConfigValue(String key) {
		if (configProperties.getProperty(key) != null)
			return configProperties.getProperty(key);
		else
			throw new RuntimeException(key + " not specified in the Configuration.properties file.");
	}

	/**
	 * This method is used to get the value based on specified key from the message
	 * property file
	 * 
	 * @param key
	 * @return value as string
	 */
	public String getMessageValue(String key) {
		if (messageProperties.getProperty(key) != null)
			return messageProperties.getProperty(key);
		else
			throw new RuntimeException(key + " not specified in the Messages.properties file.");
	}

	/**
	 * @name : ConfigFileReader
	 * @description loads the config file to get the properties
	 */
	public void loadFile(String filePath) {
		logger.info("Into Config file reader");
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			configProperties = new Properties();
			try {
				configProperties.load(reader);
				reader.close();
			} catch (IOException e) {
				logger.error("IOException:: loadFile:: " + e.getMessage());
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException:: loadFile:: properties not found " + filePath);
			throw new RuntimeException("Configuration.properties not found at " + filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @name : getDriverPath
	 * @description get the location of the driver
	 * @return - String driverPath
	 */
	@SuppressWarnings("unused")
	public String getDriverPath() {
		String driverPath = System.getProperty("user.dir") + configProperties.getProperty("driverpath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	/**
	 * @name : getImplicitlyWait
	 * @description get the specified time, from the property of implicitlywait
	 * @return - long
	 */
	public long getImplicitlyWait() {
		String implicitlyWait = configProperties.getProperty("implicitlywait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
	}

	/**
	 * @name : getApplicationUrl
	 * @description get the application url, from the property of APP_URL
	 * @return - string
	 */
	public String getApplicationUrl() {
		String url = null;
		try {
			logger.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			logger.info(System.getenv("APP_URL"));
			url = System.getenv("APP_URL");
			logger.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		} catch (Exception e) {
			url = null;
		}
		if (url == null) {
			url = configProperties.getProperty("url");
		}
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	/**
	 * @name : getApiGatewayUrl
	 * @description get the Gateway url, from the property of apigateway
	 * @return - string
	 */
	public String getApiGatewayUrl() {
		String url = configProperties.getProperty("apigateway");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	/**
	 * @name : getKeyStatus
	 * @description get the Json key status, from the property of Jsonkeys
	 * @return - string
	 */
	public String getKeyStatus() {
		String url = configProperties.getProperty("Jsonkeys");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	/**
	 * @name : getWebDriverWait
	 * @description get the webdriver wait, from the property of webdriverwait
	 * @return - int
	 */
	public int getWebDriverWait() {
		String webdriverwait = configProperties.getProperty("webdriverwait");
		if (webdriverwait != null)
			return Integer.parseInt(webdriverwait);
		else
			throw new RuntimeException("webdriverwait not specified in the Configuration.properties file.");
	}

	/**
	 * @name : getPause
	 * @description get the pause time, from the property of pause
	 * @return - long
	 */
	public long getPause() {
		String pause = configProperties.getProperty("pause");
		if (pause != null)
			return Long.parseLong(pause);
		else
			throw new RuntimeException("pause not specified in the Configuration.properties file.");
	}

	/**
	 * @name : getPageLoadPause
	 * @description get the page load pause time, from the property of pageloadpause
	 * @return - long
	 */
	public long getPageLoadPause() {
		String pageloadpause = configProperties.getProperty("pageloadpause");
		if (pageloadpause != null)
			return Long.parseLong(pageloadpause);
		else
			throw new RuntimeException("pageloadpause not specified in the Configuration.properties file.");
	}

	/**
	 * @name : getElementsLoadTime
	 * @description get the elements load time, from the property of
	 *              elementsloadtime
	 * @return - long
	 */
	public long getElementsLoadTime() {
		String elementsloadtime = configProperties.getProperty("elementsloadtime");
		if (elementsloadtime != null)
			return Long.parseLong(elementsloadtime);
		else
			throw new RuntimeException("elementsloadtime not specified in the Configuration.properties file.");
	}

	/**
	 * @name : getBrowser
	 * @description get the browser name, from the property of browser
	 * @return - String
	 */
	public String getBrowser() {
		String browserName = configProperties.getProperty("browser");
		if (browserName != null)
			return browserName;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	/**
	 * @name : getBrowserWindowSize
	 * @description get the window Maximize, from the property of windowMaximize
	 * @return - Boolean
	 */
	public Boolean getBrowserWindowSize() {
		String windowSize = configProperties.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}

	/**
	 * @name : getReportConfigPath
	 * @description get the report config file Path, from the property of
	 *              reportConfigPath
	 * @return - String
	 */
	public String getReportConfigPath() {
		String reportConfigPath = configProperties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	/**
	 * @name : getObjectRepoPath
	 * @description get the Object repository file Path, from the property of
	 *              ObjectRepoPath
	 * @return - String
	 */
	public String getObjectRepoPath() {
		String objectConfigPath = configProperties.getProperty("ObjectRepoPath");
		if (objectConfigPath != null)
			return objectConfigPath;
		else
			throw new RuntimeException(
					"Object Repo Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	/**
	 * @name : getDocumentType
	 * @description get the template file type, from the property of template
	 * @return - String
	 */
	@SuppressWarnings("unused")
	public String getDocumentType() {
		String template = System.getProperty("user.dir") + configProperties.getProperty("template");
		if (template != null)
			return template;
		else
			throw new RuntimeException("template is not specified in the Configuration.properties file.");
	}

	/**
	 * @name : getRegularExpProperty
	 * @description get the regular expression property, from the property of
	 *              property
	 * @return - String
	 */
	public String getRegularExpProperty(String property) {
		String objectConfigPath = configProperties.getProperty(property);
		if (objectConfigPath != null)
			return objectConfigPath;
		else
			throw new RuntimeException(
					"Object Repo Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	//

	/**
	 * @name : getAndroidDriverWait
	 * @description get the webdriver wait, from the property of webdriverwait
	 * @return - int
	 */
	public int getAndroidDriverWait() {
		String androiddriverwait = configProperties.getProperty("androiddriverwait");
		if (androiddriverwait != null)
			return Integer.parseInt(androiddriverwait);
		else
			throw new RuntimeException("webdriverwait not specified in the Configuration.properties file.");
	}

	/**
	 * @name : getAppName
	 * @description get the apk Name property, from the property file
	 * @return - String
	 */
	public String getApkName() {
		String appName = configProperties.getProperty("app_name");
		if (appName != null)
			return appName;
		else
			throw new RuntimeException(
					"Object Repo Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	/**
	 * @name : getDeviceType
	 * @description get the device type property, from the property file
	 * @return - String
	 */
	public String getDeviceType() {
		String deviceType = configProperties.getProperty("devicetype");
		if (deviceType != null)
			return deviceType;
		else
			throw new RuntimeException(
					"Object Repo Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	/************** Rest Assured Related Start ***********************************/
	/**
	 * @name : getStatusCode
	 * @description get the status code, from the property file
	 * @return - String
	 */
	public int getStatusCode() {
		String statusCode = configProperties.getProperty("statuscode");
		int status = Integer.parseInt(statusCode);
		if (status != 0)
			return status;
		else
			throw new RuntimeException("Status Code Key value in Configuration.properties is not matched : " + status);
	}

	/**
	 * @name : getStatusLine
	 * @description get the status code, from the property file
	 * @return - String
	 */
	public String getStatusLine() {
		String statusLine = configProperties.getProperty("statusline");
		if (statusLine != null)
			return statusLine;
		else
			throw new RuntimeException(
					"Status Line Key value in Configuration.properties is not matched : " + statusLine);
	}

	/**
	 * @name : getStatusLine
	 * @description get the status code, from the property file
	 * @return - String
	 */
	public String getContentType() {
		String contentType = configProperties.getProperty("contenttype");
		if (contentType != null)
			return contentType;
		else
			throw new RuntimeException(
					"Content Type Key value in Configuration.properties is not matched : " + contentType);
	}

	/************** Rest Assured Related End ***********************************/

	/************** Security Related Start ***********************************/

	/**
	 * @name : getZAPTargetURL
	 * @description get the ZAP Target URL, from the property file
	 * @return - String
	 */
	public String getZAPTargetURL() {
		String zapTarget = configProperties.getProperty("zaptargeturl");
		if (zapTarget != null)
			return zapTarget;
		else
			throw new RuntimeException(
					"ZAP Target URL Key value in Configuration.properties is not matched : " + zapTarget);
	}

	/**
	 * @name : getZAPAddress
	 * @description get the ZAP Address, from the property file
	 * @return - String
	 */
	public String getZAPAddress() {
		String zapAddress = configProperties.getProperty("zapaddress");
		if (zapAddress != null)
			return zapAddress;
		else
			throw new RuntimeException(
					"ZAP Address Key value in Configuration.properties is not matched : " + zapAddress);
	}

	/**
	 * @name : getZAPPort
	 * @description get the ZAP Port, from the property file
	 * @return - String
	 */
	public int getZAPPort() {
		int zapPort = Integer.parseInt(configProperties.getProperty("zapport"));
		if (zapPort != 0)
			return zapPort;
		else
			throw new RuntimeException("ZAP Port Key value in Configuration.properties is not matched : " + zapPort);
	}

	/************** Security Related END ***********************************/

	/** ########### ENVIRONMENT PROPERTY CONFIG START ########### */

	/**
	 * @name : getDriverPath
	 * @description get the location of the driver
	 * @return - String driverPath
	 */

	public String getqaURL() {
		String driverPath = configProperties.getProperty("qaURL");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("qa url in the Configuration.properties file.");
	}

	// SignIn

	/**
	 * @name : getEmail
	 * @description get the email
	 * @return - String email
	 */
	public String getEmail() {
		String userName = configProperties.getProperty("email");
		if (userName != null)
			return userName;
		else
			throw new RuntimeException("eamil in the Configuration.properties file.");
	}

	/**
	 * @name : getPassword
	 * @description get the user password
	 * @return - String password
	 */
	public String getPassword() {
		String password = configProperties.getProperty("password");
		if (password != null)
			return password;
		else
			throw new RuntimeException("password in the Configuration.properties file.");
	}

	/**
	 * @name : getdashboardLabelText
	 * @description get the user validate dashboard Label Text in Dashboard page
	 * @return - String getdashboardLabelText
	 */
	public String getdashboardLabelText() {
		String dashboardLabelText = configProperties.getProperty("dashboardLabelText");
		if (dashboardLabelText != null)
			return dashboardLabelText;
		else
			throw new RuntimeException("validate dashboardLabelText in the Configuration.properties file.");
	}

	// Add New Product

	/**
	 * @name : getProductName
	 * @description get the Product Name
	 * @return - String productName
	 */
	public String getProductName() {
		String productName = configProperties.getProperty("productName");
		if (productName != null)
			return productName;
		else
			throw new RuntimeException("productName in the Configuration.properties file.");
	}

	/**
	 * @name : getProductPrice
	 * @description get the Product Price
	 * @return - String productPrice
	 */
	public String getProductPrice() {
		String productPrice = configProperties.getProperty("productPrice");
		if (productPrice != null)
			return productPrice;
		else
			throw new RuntimeException("productPrice in the Configuration.properties file.");
	}

	/**
	 * @name : getTrialDuration
	 * @description get the Trial Duration
	 * @return - String trialDuration
	 */
	public String getTrialDuration() {
		String trialDuration = configProperties.getProperty("trialDuration");
		if (trialDuration != null)
			return trialDuration;
		else
			throw new RuntimeException("trialDuration in the Configuration.properties file.");
	}

	/**
	 * @name : getProductDuration
	 * @description get the Product Duration
	 * @return - String productDuration
	 */
	public String getProductDuration() {
		String productDuration = configProperties.getProperty("productDuration");
		if (productDuration != null)
			return productDuration;
		else
			throw new RuntimeException("productDuration in the Configuration.properties file.");
	}

	/**
	 * @name : getProductUrl
	 * @description get the Product Url
	 * @return - String productUrl
	 */
	public String getProductUrl() {
		String productUrl = configProperties.getProperty("productUrl");
		if (productUrl != null)
			return productUrl;
		else
			throw new RuntimeException("productUrl in the Configuration.properties file.");
	}

	/**
	 * @name : getUploadImage
	 * @description get the Upload Image
	 * @return - String uploadImage
	 */
	public String getUploadImage() {
		String uploadImage = configProperties.getProperty("uploadImage");
		if (uploadImage != null)
			return uploadImage;
		else
			throw new RuntimeException("uploadImage in the Configuration.properties file.");
	}

	/**
	 * @name : getUploadIcon
	 * @description get the Upload Icon
	 * @return - String uploadIcon
	 */
	public String getUploadIcon() {
		String uploadIcon = configProperties.getProperty("uploadIcon");
		if (uploadIcon != null)
			return uploadIcon;
		else
			throw new RuntimeException("uploadIcon in the Configuration.properties file.");
	}

	/**
	 * @name : getProductDescription
	 * @description get the Product Description
	 * @return - String productDescription
	 */
	public String getProductDescription() {
		String productDescription = configProperties.getProperty("productDescription");
		if (productDescription != null)
			return productDescription;
		else
			throw new RuntimeException("productDescription in the Configuration.properties file.");
	}

	// Create Company

	/**
	 * @name : getRoleType
	 * @description get the Role Type
	 * @return - String roleType
	 */
	public String getRoleType() {
		String roleType = configProperties.getProperty("roleType");
		if (roleType != null)
			return roleType;
		else
			throw new RuntimeException("roleType in the Configuration.properties file.");
	}

	/**
	 * @name : getCompanyName
	 * @description get the Company Name
	 * @return - String companyName
	 */
	public String getCompanyName() {
		String companyName = configProperties.getProperty("companyName");
		if (companyName != null)
			return companyName;
		else
			throw new RuntimeException("companyName in the Configuration.properties file.");
	}

	/**
	 * @name : getFirstName
	 * @description get the First Name
	 * @return - String firstName
	 */
	public String getFirstName() {
		String firstName = configProperties.getProperty("firstName");
		if (firstName != null)
			return firstName;
		else
			throw new RuntimeException("firstName in the Configuration.properties file.");
	}

	/**
	 * @name : getLastName
	 * @description get the Last Name
	 * @return - String lastName
	 */
	public String getLastName() {
		String lastName = configProperties.getProperty("lastName");
		if (lastName != null)
			return lastName;
		else
			throw new RuntimeException("lastName in the Configuration.properties file.");
	}

	/**
	 * @name : getCCEmail
	 * @description get the Create Company Email
	 * @return - String CCEmail
	 */
	public String getCC_Email() {
		String CCEmail = configProperties.getProperty("cc_email");
		if (CCEmail != null)
			return CCEmail;
		else
			throw new RuntimeException("cc_email in the Configuration.properties file.");
	}

	/**
	 * @name : getCC_Password
	 * @description get the Create Company Password
	 * @return - String cc_password
	 */
	public String getCC_Password() {
		String cc_password = configProperties.getProperty("cc_password");
		if (cc_password != null)
			return cc_password;
		else
			throw new RuntimeException("cc_password in the Configuration.properties file.");
	}

	/**
	 * @name : getCC_ConfirmPassword
	 * @description get the Create Company Confirm Password
	 * @return - String cc_confirmPassword
	 */
	public String getCC_ConfirmPassword() {
		String cc_confirmPassword = configProperties.getProperty("cc_confirmPassword");
		if (cc_confirmPassword != null)
			return cc_confirmPassword;
		else
			throw new RuntimeException("cc_confirmPassword in the Configuration.properties file.");
	}

	/**
	 * @name : getSelectCountry
	 * @description get the Select Country
	 * @return - String selectCountry
	 */
	public String getSelectCountry() {
		String selectCountry = configProperties.getProperty("selectCountry");
		if (selectCountry != null)
			return selectCountry;
		else
			throw new RuntimeException("selectCountry in the Configuration.properties file.");
	}

	/**
	 * @name : getSelectState
	 * @description get the Select State
	 * @return - String selectState
	 */
	public String getSelectState() {
		String selectState = configProperties.getProperty("selectState");
		if (selectState != null)
			return selectState;
		else
			throw new RuntimeException("selectState in the Configuration.properties file.");
	}

	/**
	 * @name : getSelectCity
	 * @description get the Select City
	 * @return - String selectCity
	 */
	public String getSelectCity() {
		String selectCity = configProperties.getProperty("selectCity");
		if (selectCity != null)
			return selectCity;
		else
			throw new RuntimeException("selectCity in the Configuration.properties file.");
	}

	/**
	 * @name : getLocation
	 * @description get the Location
	 * @return - String location
	 */
	public String getLocation() {
		String location = configProperties.getProperty("location");
		if (location != null)
			return location;
		else
			throw new RuntimeException("location in the Configuration.properties file.");
	}

	/**
	 * @name : getMobileNumber
	 * @description get the Mobile Number
	 * @return - String mobileNumber
	 */
	public String getMobileNumber() {
		String mobileNumber = configProperties.getProperty("mobileNumber");
		if (mobileNumber != null)
			return mobileNumber;
		else
			throw new RuntimeException("mobileNumber in the Configuration.properties file.");
	}

	/** ########### ENVIRONMENT PROPERTY CONFIG END ########### */

	/** ########### MESSAGE PROPERTY CONFIG ########### */

	/**
	 * @name : getEmailBlankError
	 * @description get the Email Error message Text in SignIn Page
	 * @return - String emailErrorText
	 */
	public String getEmailBlankError() {
		String emailErrorText = messageProperties.getProperty("emailBlankError");
		if (emailErrorText != null)
			return emailErrorText;
		else
			throw new RuntimeException("userName Error message text in the messages.properties file");
	}

	/**
	 * @name : getpwdBlankToastMsg
	 * @description get the Blank Password toast message text
	 * @return - String pwdBlankToastMsg
	 */
	public String getpwdBlankToastMsg() {
		String pwdBlankToastMsg = messageProperties.getProperty("pwdBlankToastMessage1");
		if (pwdBlankToastMsg != null)
			return pwdBlankToastMsg;
		else
			throw new RuntimeException("Blank Password toast message text in the messages.properties file");
	}

}
