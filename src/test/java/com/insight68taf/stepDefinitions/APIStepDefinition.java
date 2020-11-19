package com.insight68taf.stepDefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.insight68taf.utils.APIHelper;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * name APIStepDefinition
 * 
 * @author Sandeep description Step definitions for API.feature file
 */
public class APIStepDefinition {

	private Response response = null;

	@Given("^To initiate base uri and required headers$")
	public void to_initiate_base_uri_and_required_headers(DataTable dt) {
		List<List<String>> URI = dt.raw();
		String baseURI = URI.get(0).get(0).toString();
		RestAssured.baseURI = baseURI;
	}

	@Then("^Create Request object for GET method$")
	public void create_Request_object_for_GET_method(DataTable dt) {
		List<List<String>> endpoint = dt.raw();
		response = APIHelper.executeGETMethod(endpoint.get(0).get(0).toString());
		response.getBody().prettyPrint();

	}

	@SuppressWarnings("unchecked")
	@Then("^Create Request object for PUT method$")
	public void create_Request_object_for_PUT_method(DataTable dt) {
		List<Map<String, String>> data = dt.asMaps(String.class, String.class);
		System.out.println("*************** Actual Data Table - data value as-- " + data);
		// Response Object creation
		JSONObject requestParams = null;
		for (int i = 0; i < data.size(); i++) {
			requestParams = new JSONObject();
			requestParams.put("username", data.get(i).get("username"));
			requestParams.put("productId", data.get(i).get("productId"));
			requestParams.put("endDate", data.get(i).get("endDate"));

			Map<String, Object> headerMap = new HashMap<String, Object>();
			headerMap.put("Content-Type", data.get(i).get("contenttype"));

			response = APIHelper.executePUTMethod(headerMap, requestParams, data.get(i).get("EndPoint"));
			response.getBody().prettyPrint();
		}
	}

	@SuppressWarnings("unchecked")
	@Then("^Create Request object for DELETE method$")
	public void create_Request_object_for_DELETE_method(DataTable dt) {
		List<Map<String, String>> data = dt.asMaps(String.class, String.class);
		System.out.println("*************** Actual Data Table - data value as-- " + data);
		// Response Object creation
		JSONObject requestParams = null;
		for (int i = 0; i < data.size(); i++) {
			requestParams = new JSONObject();
			requestParams.put("username", data.get(i).get("username"));
			requestParams.put("productId", data.get(i).get("productId"));

			Map<String, Object> headerMap = new HashMap<String, Object>();
			headerMap.put("Content-Type", data.get(i).get("contenttype"));

			response = APIHelper.executeDELETEMethod(headerMap, requestParams, data.get(i).get("EndPoint"));
			response.getBody().prettyPrint();
		}

	}

	@And("^Validate the Response status code and status line$")
	public void validate_the_Response_status_code_and_status_line() {
		int statusCode = response.getStatusCode();
		String statusLine = response.getStatusLine();
		String contentType = response.header("Content-Type");
		APIHelper.validateStatusCode(statusCode);
		APIHelper.validateContentType(contentType);
		APIHelper.validateStatusLine(statusLine);
	}

	// POST
	@SuppressWarnings("unchecked")
	@Then("^Create Request object creation for POST method and get Responce with following data$")
	public void create_Request_object_creation_for_POST_method_and_get_Responce_with_following_data(DataTable dt) {

		List<Map<String, String>> data = dt.asMaps(String.class, String.class);
		System.out.println("*************** Actual Data Table - data value as-- " + data);
		// Response Object creation
		JSONObject requestParams = null;
		for (int i = 0; i < data.size(); i++) {
			requestParams = new JSONObject();
			requestParams.put("firstname", data.get(i).get("firstname"));
			requestParams.put("lastname", data.get(i).get("lastname"));
			requestParams.put("email", data.get(i).get("email"));
			requestParams.put("mobilenumber", data.get(i).get("mobilenumber"));
			requestParams.put("extensionNumber", data.get(i).get("extensionNumber"));
			requestParams.put("username", data.get(i).get("username"));
			requestParams.put("password", data.get(i).get("password"));
			requestParams.put("passwordConfirm", data.get(i).get("passwordConfirm"));
			requestParams.put("country", data.get(i).get("country"));
			requestParams.put("state", data.get(i).get("state"));
			requestParams.put("city", data.get(i).get("city"));
			requestParams.put("authorities", data.get(i).get("authorities"));
			Map<String, Object> headerMap = new HashMap<String, Object>();
			headerMap.put("Content-Type", data.get(i).get("contenttype"));
			response = APIHelper.executePOSTMethod(headerMap, requestParams, data.get(i).get("EndPoint"));
			response.getBody().prettyPrint();

		}

	}

}
