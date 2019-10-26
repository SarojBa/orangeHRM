package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;



public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 15;
	public static String TESTDATA_SHEET_PATH = "C:/Users/saroj/imp_workspace/OrangeHRM/src/main/java/com/qa/testdata/OrangeHRMTestData.xlsx";

	static XSSFWorkbook book;
	static XSSFSheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			book = new XSSFWorkbook(file);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum();i++){
			
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++){
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
        Date date = new Date();
        
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + dateFormat.format(date)+ ".png"));
	}

}
