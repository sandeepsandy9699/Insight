package com.insight68taf.hooks;

import org.apache.log4j.Logger;

import com.insight68taf.driverManager.WebDriverManager;
import com.insight68taf.utils.SeleniumHelper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	private static final Logger logger = Logger.getLogger(Hooks.class);

	@Before
	public void Before(Scenario scenario) {
		SeleniumHelper.setScenario(scenario);
		logger.info("**********************************************");
		logger.info(" Started Working on Scenario : " + scenario.getName());
		logger.info("**********************************************");
	}

	@After
	public void After(Scenario scenario) {
		SeleniumHelper.setScenario(scenario);
		logger.info("**********************************************");
		logger.info(" Completed Working on Scenario : " + scenario.getName());
		logger.info("**********************************************");
		WebDriverManager.closeDriver();

	}

}
