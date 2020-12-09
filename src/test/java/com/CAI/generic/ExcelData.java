package com.CAI.generic;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelData
{
	public static XSSFWorkbook wb;
	public static  FileInputStream fi;
	public static XSSFSheet sheet;
	
	//Method used to read the data from the excel file.
public static String getData(String path,int rowno,int columnno,String sheet) throws IOException 
{
	 fi = new FileInputStream(path);
	 wb = new XSSFWorkbook(fi);
	Cell cell = wb.getSheet(sheet).getRow(rowno).getCell(columnno);
	DataFormatter  df = new DataFormatter();
	String data = df.formatCellValue(cell);
	wb.close();
	return data;
	
}
	//Method used to get the row size
public static int getRowSize(String path,String sheet) throws IOException
{
	 fi = new FileInputStream(path); 
	 wb = new XSSFWorkbook(fi);
	int rowsize = wb.getSheet(sheet).getLastRowNum();
	return rowsize;
	
}

	//Method used to get the column size
public static int columnSize(String path,int rowno,String sheet) throws Exception
{
	 fi = new FileInputStream(path); 
	 wb = new XSSFWorkbook(fi);
	int colsize = wb.getSheet(sheet).getRow(rowno).getLastCellNum();
	return colsize;

}

}
