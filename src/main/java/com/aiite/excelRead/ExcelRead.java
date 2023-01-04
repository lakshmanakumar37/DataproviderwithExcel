package com.aiite.excelRead;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelRead {
	
	public String[][] ReadExcelData() throws IOException {
		
		String loc="C:\\Users\\HP\\Desktop\\Javasample.xlsx";
		
		XSSFWorkbook wbook=new XSSFWorkbook(loc);
		
		XSSFSheet wsheet=wbook.getSheetAt(0);
		
		int rowCount=wsheet.getLastRowNum();
		
		int colCount=wsheet.getRow(0).getLastCellNum();
		
		String[][] excelData=new String[rowCount][colCount];
		
		for(int i=1; i<=rowCount;i++) {
			
			XSSFRow rows=wsheet.getRow(i);
			
		for(int j=0;j<colCount;j++) {
			XSSFCell cell=rows.getCell(j);
			
			DataFormatter data=new DataFormatter();
			String values=data.formatCellValue(cell);
			
			excelData[i-1][j]=values;
			
			//System.out.println("The values are:"+values);
			
		}
		}
		wbook.close();
		return excelData;
		
		
	}
	
	@DataProvider
	public String[][] getDataExcel() throws IOException {
		ExcelRead excel=new ExcelRead();
		String[][] dataInExcel=excel.ReadExcelData();
		
		return dataInExcel;
		
	}
	

	
}
