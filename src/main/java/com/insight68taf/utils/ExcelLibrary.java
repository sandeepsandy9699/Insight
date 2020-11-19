package com.insight68taf.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * The ExcelLibrary class is used to read the data from the excel sheet
 *
 * @author Yugendhar Utkam
 * @version 1.0
 * 
 */
public class ExcelLibrary {
	private static final Logger logger = Logger.getLogger(ExcelLibrary.class);
	static Map<String, Workbook> workbooktable = new HashMap<String, Workbook>();
	public static List<String> list = new ArrayList<String>();

	/**
	 * To get the excel sheet workbook
	 */
	public static Workbook getWorkbook(String path) {
		Workbook workbook = null;
		if (workbooktable.containsKey(path)) {
			workbook = workbooktable.get(path);
		} else {
			try {
				File file = new File(path);
				workbook = WorkbookFactory.create(file);
				workbooktable.put(path, workbook);
			} catch (FileNotFoundException e) {
				logger.error("Exception:: FileNotFoundException: " + e.getMessage());
			} catch (InvalidFormatException e) {
				logger.error("Exception:: InvalidFormatException: " + e.getMessage());
			} catch (IOException e) {
				logger.error("Exception:: IOException: " + e.getMessage());
			} catch (Exception e) {
				logger.error("Exception:: " + e.getMessage());
			}

		}
		return workbook;
	}

	/**
	 * To get the number of sheets in excel suite
	 */
	public static List<String> getNumberOfSheetsinSuite(String testPath) {
		List<String> listOfSheets = new ArrayList<String>();
		Workbook workbook = getWorkbook(testPath);
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			listOfSheets.add(workbook.getSheetName(i));
		}
		return listOfSheets;
	}

	/**
	 * Get the total rows present in excel sheet
	 */
	public static int getRows(String testSheetName, String pathOfFile) throws InvalidFormatException, IOException {
		Workbook workbook = getWorkbook(pathOfFile);
		logger.info("Getting total number of rows");
		Sheet sheet = workbook.getSheet(testSheetName);
		return sheet.getLastRowNum();
	}

	/**
	 * Get the total columns inside excel sheet
	 */
	public static int getColumns(String testSheetName, String pathOfFile) throws InvalidFormatException, IOException {
		Workbook workbook = getWorkbook(pathOfFile);
		logger.info("Getting total number of columns");
		Sheet sheet = workbook.getSheet(testSheetName);
		return sheet.getRow(0).getLastCellNum();

	}

	/**
	 * Get the column names inside excel sheet
	 */
	public static List<String> getColumnNames(String testSheetName, String pathOfFile, int j)
			throws InvalidFormatException, IOException {
		Workbook workbook = getWorkbook(pathOfFile);
		Sheet sheet = workbook.getSheet(testSheetName);

		for (int i = 0; i <= j; i++) {
			if (sheet.getRow(0).getCell(i) != null) {
				list.add(sheet.getRow(0).getCell(i).getStringCellValue().toString());
			}
		}

		return list;

	}

	/**
	 * Read the content of the cell
	 */
	public static String readCell(int rowNum, int colNum, String testSheetName, String pathOfFile) {
		Workbook workbook;
		String cellValue = null;

		workbook = getWorkbook(pathOfFile);
		Sheet sheet = workbook.getSheet(testSheetName);
		Row row = sheet.getRow(rowNum);
		if (row != null) {
			Cell cell = row.getCell(colNum);
			if (cell != null) {
				DataFormatter dataFormatter = new DataFormatter();
				String data = dataFormatter.formatCellValue(cell);
				cellValue = data;
			}
		}
		return cellValue;
	}

	/**
	 * This method is used to write the test result at the last for the column by
	 * row
	 */
	public static void writeColumn(String testSheetName, String pathOfFile, List<String> result) {
		try {
			Workbook workbook = getWorkbook(pathOfFile);
			Sheet sheet = workbook.getSheet(testSheetName);
			for (int i = 0; i < result.size(); i++) {
				Row row = sheet.getRow(i + 1);
				Cell cell = row.createCell(getColumns(testSheetName, testSheetName) + 1);
				cell.setCellValue(result.get(i));
			}
			FileOutputStream outputStream = new FileOutputStream(pathOfFile);
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
		} catch (IOException ex) {
			logger.error("Exception:: writeColumn : " + ex.getMessage());
		} catch (Exception e) {
			logger.error("Exception:: writeColumn : " + e.getMessage());
		}

	}

	/**
	 * To clear the worktable and list
	 */
	public void clean() {
		workbooktable.clear();
		list.clear();
	}

	/**
	 * Get the total number of rows for each column inside excel sheet
	 */
	public static void getNumberOfRowsPerColumn(String testSheetName, String pathOfFile, int j)
			throws InvalidFormatException, IOException {
		Workbook workbook = getWorkbook(pathOfFile);
		Sheet sheet = workbook.getSheet(testSheetName);
		int totColumns = sheet.getRow(0).getLastCellNum();
		for (int i = 0; i <= totColumns; i++) {
			if (sheet.getRow(0).getCell(i) != null) {
				list.add(sheet.getRow(0).getCell(i).getStringCellValue().toString());
			}
		}
	}

	/**
	 * To get the number of sheets in test data sheet
	 */
	/*
	 * public static List<String> getNumberOfSheetsinTestDataSheet(String testPath)
	 * { List<String> listOfSheets = new ArrayList<String>();
	 * 
	 * Workbook workbook = getWorkbook(testPath); for (int i = 0; i <
	 * workbook.getNumberOfSheets(); i++) { if
	 * (!(workbook.getSheetName(i)).equalsIgnoreCase(config
	 * .getConfigValues("TestCase_SheetName"))) {
	 * listOfSheets.add(workbook.getSheetName(i));
	 * 
	 * } } return listOfSheets;
	 * 
	 * }
	 */

}