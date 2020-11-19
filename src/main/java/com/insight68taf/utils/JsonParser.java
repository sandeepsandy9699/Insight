package com.insight68taf.utils;

import java.io.FileReader;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This class is used to parse the given JSON file
 * 
 * @author Yugendhar.
 *
 */
public class JsonParser {

	private static final Logger logger = Logger.getLogger(JsonParser.class);

	/**
	 * This method is used to read the JSON file from the given location and serve
	 * the object
	 * 
	 * @param filePath
	 * @return Object
	 */
	public static Object readJson(String filePath) {
		JSONParser parser = new JSONParser();
		Object object = null;
		try {
			object = parser.parse(new FileReader(filePath));
		} catch (Exception e) {
			logger.error("Exception:: " + e.getMessage());
		}
		return object;
	}

	/**
	 * This method is used to parse and get the JSON Object
	 * 
	 * @param filePath
	 * @return JSONObject
	 */
	public static JSONObject getJsonObject(String filePath) {
		JSONObject jsonObject = new JSONObject();
		Object object = readJson(filePath);
		if (object != null && object instanceof JSONObject) {
			jsonObject = (JSONObject) object;
		}
		return jsonObject;
	}

	/**
	 * This method is used to parse and get the JSON Array
	 * 
	 * @param filePath
	 * @return JSONArray
	 */
	public static JSONArray getJsonArray(String path) {
		JSONArray jsonArray = new JSONArray();
		Object object = readJson(path);
		if (object != null && object instanceof JSONArray) {
			jsonArray = (JSONArray) object;
		}
		return jsonArray;
	}

	/*
	 * @SuppressWarnings("unchecked") public static void iterateJsonArray(JSONArray
	 * jsonArray,int index) { jsonArray.forEach(item -> { // JSONObject obj =
	 * (JSONObject) item; //Need to write spec logic }); }
	 */
}