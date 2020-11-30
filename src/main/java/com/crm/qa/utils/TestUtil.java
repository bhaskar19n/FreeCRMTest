package com.crm.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.FileUtils;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
public static long PAGE_LOAD_TIMEOUT=100;
public static long IMPLICIT_WAIT=100;

public static String TESTDATA_PATH="E:\\Selenium2020\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\TestData\\CRM TestData.xlsx";
 static Workbook book;
static Sheet sheet;

public static Object[][] getTestData(String sheetName) {
	FileInputStream file = null;
	try {
		file= new FileInputStream(TESTDATA_PATH);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		book= WorkbookFactory.create(file);
	} catch (EncryptedDocumentException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sheet=book.getSheet(sheetName);
	Object[][] data = new Object[(sheet.getLastRowNum())][sheet.getRow(0).getLastCellNum()];
	System.out.println("last cell value="+sheet.getRow(0).getLastCellNum());
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < data.length+1; k++) {
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			System.out.println("Excel cell values ="+data[i][k]);
			
		}
		
	}
	return data;
	
}
//Called from WebEventListener onException
public static void takeScreenshotAtEndOfTest() throws IOException {
	File screenshotFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir= System.getProperty("user.dr");
	
		FileUtils.copyFile(screenshotFile, new File(currentDir + "/Failures/"+ "/screenshots/" + System.currentTimeMillis() + ".png"));
	
	
}

}
