package com.test;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteExcel02{
	public static void main(String[] args)throws Exception{
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");
		
		//第一行
		HSSFRow row = sheet.createRow(0);
		//第一行，单元格                             第一列，   
		HSSFCell cell = row.createCell(0);
		
		cell.setCellValue(234);
				
		FileOutputStream os = new FileOutputStream("e:\\workbook2.xls");
		wb.write(os);
		os.close();							
		
	}
}








































