package com.gdr.qa.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelTestData {

	// create global variable
	static Workbook book;
	static Sheet sheet;

	public static String TestData_Sheet_Path = "/home/niveditah/eclipse-workspace/GoodrTest/src/main/java/com/gdr/qa/Testdata/TestData.ods";

	
	
	public static Object[][] getTestData(String sheetname) {

		FileInputStream file = null;

		try {

			file = new FileInputStream(TestData_Sheet_Path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try

		{
		book = WorkbookFactory.create(file);

		// name of the sheet and starting from

		// for getting data line by line per cell we can just change the no of rows and
		// cols
		// we can use for loop to directly traverse

			}
		catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet= book.getSheet(sheetname);
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum();i++)
		{
		for (int k=0; k< sheet.getRow(0).getLastCellNum(); k++)
		{
			data[i][k]= sheet.getRow(i+1).getCell(k).toString();
			
		}
		}
		return data;
	}

}
