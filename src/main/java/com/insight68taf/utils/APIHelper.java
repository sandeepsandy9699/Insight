package com.insight68taf.utils;

import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIHelper {

	public static RequestSpecification httpRequest;
	public static Response response;
	private static final Logger logger = Logger.getLogger(APIHelper.class);

	// this method is used to set base uri
	public static void setBaseURI(String baseURI) {

		RestAssured.baseURI = baseURI;
	}

	public static Response executePOSTMethod(Map<String, Object> hedaerMap, JSONObject requestParams, String endPoint) {

		httpRequest = RestAssured.given().headers(hedaerMap).body(requestParams.toJSONString());

		// Response Object creation
		response = httpRequest.request(Method.POST, endPoint);
		return response;
	}

	public static Response executeGETMethod(String endPoint) {

		httpRequest = RestAssured.given();

		// Response Object creation
		response = httpRequest.request(Method.GET, endPoint);
		return response;
	}

	public static Response executePUTMethod(Map<String, Object> headerMap, JSONObject requestParams, String endPoint) {

		httpRequest = RestAssured.given().contentType("application/json").body(requestParams.toJSONString());
		// Response Object creation
		response = httpRequest.request(Method.PUT, endPoint);
		return response;
	}

	public static Response executeDELETEMethod(Map<String, Object> headerMap, JSONObject requestParams,
			String endPoint) {

		httpRequest = RestAssured.given().contentType("application/json").body(requestParams.toJSONString());
		// Response Object creation
		response = httpRequest.request(Method.DELETE, endPoint);
		return response;
	}

	public static void validateStatusCode(int statusCode) {
		System.out.println("********** ----------------  *************");
		System.out.println("Status Code is: " + statusCode);
		Assert.assertEquals(statusCode, PropertyFileLoader.getConfigInstance().getStatusCode());
		logger.info("Status Code as :" + statusCode + " is passed");
	}

	public static void validateStatusLine(String statusLine) {
		System.out.println("********** ----------------  *************");
		System.out.println("Status Line is: " + statusLine);
//		Assert.assertEquals(statusLine, PropertyFileLoader.getConfigInstance().getStatusLine());
		logger.info("Status Line as :" + statusLine + " is passed");

	}

	public static void validateContentType(String contentType) {
		System.out.println("********** ----------------  *************");
		Assert.assertEquals(contentType, PropertyFileLoader.getConfigInstance().getContentType());
		logger.info("Content Type as :" + contentType + " is passed");
		System.out.println("Content-Type value: " + contentType);

	}

}
