package com.insight68taf.stepDefinitions;

import com.insight68taf.utils.DatabaseConnection;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * name DataBaseStepDefinition
 * 
 * @author Sandeep description Step definitions for DataBase.feature file
 */
public class DataBaseStepDefinition {

	DatabaseConnection dbConnection = DatabaseConnection.getInstance();

	@Given("^User establish connection with the database$")
	public void user_establish_connection_with_the_database() {
		dbConnection.getConnection();
	}

	@When("^Perform and execute the query$")
	public void perform_and_execute_the_query() {

		String query = "select * from employee";
		dbConnection.getResultSet(query);
	}

	@Then("^validate the Result set$")
	public void validate_the_Result_set() {

		dbConnection.validateResult();
		dbConnection.closeConnection();
	}

}
