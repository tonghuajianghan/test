package com.test;

import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;

public class Nation {
	public static void main(String[] args) throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();// 创建excel文档
		HSSFSheet sheet = wb.createSheet("sheet1");//创建一个单一页面

		//第一行
		Region region1 = new Region(0, (short) 0, 0, (short) 12);
		sheet.addMergedRegion(region1);		
		HSSFRow row0 = sheet.createRow(0);//创建第一列
		HSSFCell cell00 = row0.createCell(0);//创建第一个单元格
		cell00.setCellValue("长  春  理  工  大  学  在  校  生  宗  教  信  仰  情  况");
		
		//sheet.setColumnWidth(0, 6766); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		
		
		
		HSSFRow row1 = sheet.createRow(1);//创建第二列
		
		HSSFCell cell10 = row1.createCell(0);
		HSSFCell cell11 = row1.createCell(1);
		HSSFCell cell12 = row1.createCell(2);
		HSSFCell cell13 = row1.createCell(3);
		HSSFCell cell14 = row1.createCell(4);
		HSSFCell cell15 = row1.createCell(5);
		HSSFCell cell16 = row1.createCell(6);
		HSSFCell cell17 = row1.createCell(7);
		HSSFCell cell18 = row1.createCell(8);
		HSSFCell cell19 = row1.createCell(9);
		HSSFCell cell110 = row1.createCell(10);
		HSSFCell cell111 = row1.createCell(11);
		HSSFCell cell112 = row1.createCell(12);
		
		cell10.setCellValue("序号");
		cell11.setCellValue("学院");
		cell12.setCellValue("班级");
		cell13.setCellValue("姓名");
		cell14.setCellValue("性别");
		cell15.setCellValue("民族");
		cell16.setCellValue("宗教");
		cell17.setCellValue("何时入教");
		cell18.setCellValue("信教原因");
		cell19.setCellValue("是否定期参加宗教活动");
		cell110.setCellValue("是否传教");
		cell111.setCellValue("家庭住址（省、市、县）");
		cell112.setCellValue("备注");
		
		

		// 设置
		HSSFCellStyle style = wb.createCellStyle();
		
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 设置居中
		cell00.setCellStyle(style);
		
		sheet.setColumnWidth(9, 4950); //第一个参数代表列id(从0开始),第2个参数代表宽度值
		sheet.setColumnWidth(11, 4850);
		//设置字体
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setFontName("Courier New");
		font.setItalic(false);
		// font.setBoldweight((short)8);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		style.setFont(font);
		//cell0.setCellStyle(style);
		
		FileOutputStream os = new FileOutputStream("e:\\workbook02.xls");
		wb.write(os);
		os.close();
	}
}
