package com.phptravelscustomer.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {
	private static      XSSFWorkbook excelWBook;
	private static      XSSFSheet    excelWSheet;
	public static String getCellData(int RowNum, int ColNum) throws IOException {
		FileInputStream ExcelFile= new FileInputStream(System.getProperty("user.dir")+"/src/main/resources"+"/customerLogin.xlsx");
		excelWBook = new XSSFWorkbook(ExcelFile);
		 excelWSheet = excelWBook.getSheetAt(0);
		 return excelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
	}

}
