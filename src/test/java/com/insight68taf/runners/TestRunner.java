package com.insight68taf.runners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.insight68taf.utils.PropertyFileLoader;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = { "src/test/resources/features/" }, glue = { "com.insight68taf.stepDefinitions",
		"com.insight68taf.hooks" }, plugin = { "pretty",
				"com.cucumber.listener.ExtentCucumberFormatter:target/insight68taf_extent_Report.html",
				"html:target/insight68taf_html_reports", "json:target/insight68taf_results.json",
				"pretty:target/insight68taf_pretty_results.txt", "usage:target/insight68taf_usage_results.json",
				"junit:target/insight68taf_results.xml", }, dryRun = false, tags = 
			{"@FTC, @AddNewProduct, @UAT, @API_GET , @API_POST, @Database , @Security" }, monochrome = true)

// @FTC, @AddNewProduct, @UAT, @API_GET , @API_POST, @Database , @Security

public class TestRunner {

	private static final Logger logger = Logger.getLogger(TestRunner.class);

	@AfterClass
	public static void writeExtentReport() {
		String line = null;
		BufferedReader bufferedReader = null;
		Reporter.loadXMLConfig(new File(PropertyFileLoader.getConfigInstance().getReportConfigPath()));
		Reporter.setSystemInfo("Organisation Name", "Insight68");
		Reporter.setSystemInfo("User Name", "Insight68");
		Reporter.setSystemInfo("Application Name", "Insight68 Application");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "Testing");
		try {
			File logFile = new File("target/logfile.log");
			bufferedReader = new BufferedReader(new FileReader(logFile));
			while ((line = bufferedReader.readLine()) != null) {
				Reporter.setTestRunnerOutput(line.toString() + "<br/>");
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException:: writeExtentReport:: " + e.getMessage());
		} catch (IOException e) {
			logger.error("IOException:: writeExtentReport:: " + e.getMessage());
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				logger.error("IOException:: writeExtentReport:: finally " + e.getMessage());
			}
		}
	}

}
