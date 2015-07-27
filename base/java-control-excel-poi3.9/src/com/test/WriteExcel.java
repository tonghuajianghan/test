package com.test;

import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

public class WriteExcel {

public static void main(String[] args) throws Exception {
    // ����Excel�Ĺ������ Workbook,��Ӧ��һ��excel�ĵ�
    HSSFWorkbook wb = new HSSFWorkbook();

    // ����Excel�Ĺ���sheet,��Ӧ��һ��excel�ĵ���tab
    HSSFSheet sheet = wb.createSheet("sheet1");

    // ����excelÿ�п��
    sheet.setColumnWidth(0, 4000);
    sheet.setColumnWidth(1, 3500);
    sheet.setColumnWidth(2,7000);

    // ����������ʽ
    HSSFFont font = wb.createFont();
    font.setFontName("Verdana");
    font.setBoldweight((short) 100);
    font.setFontHeight((short) 300);
    font.setColor(HSSFColor.BLUE.index);

    // ������Ԫ����ʽ
    HSSFCellStyle style = wb.createCellStyle();
    style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
    style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
    style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

    // ���ñ߿�
    style.setBottomBorderColor(HSSFColor.RED.index);
    style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    style.setBorderRight(HSSFCellStyle.BORDER_THIN);
    style.setBorderTop(HSSFCellStyle.BORDER_THIN);

    style.setFont(font);// ��������

    //��������
    
    // ����Excel��sheet��һ��
    HSSFRow row = sheet.createRow(0);
    row.setHeight((short) 500);// �趨�еĸ߶�
    // ����һ��Excel�ĵ�Ԫ��
    HSSFCell cell = row.createCell(0);

    // �ϲ���Ԫ��(startRow��endRow��startColumn��endColumn)
    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));

    // ��Excel�ĵ�Ԫ��������ʽ�͸�ֵ
    cell.setCellStyle(style);
    //cell.setCellValue("123");
    double hh = 123;
    cell.setCellValue(hh);

    // ���õ�Ԫ�����ݸ�ʽ
    HSSFCellStyle style1 = wb.createCellStyle();
    style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("h:mm:ss"));

    style1.setWrapText(true);// �Զ�����

    row = sheet.createRow(1);

    // ���õ�Ԫ�����ʽ��ʽ

    cell = row.createCell(0);
    cell.setCellStyle(style1);
    cell.setCellValue(new Date());

    // ����������
    HSSFHyperlink link = new HSSFHyperlink(HSSFHyperlink.LINK_URL);
    link.setAddress("http://www.baidu.com");
    cell = row.createCell(1);
    cell.setCellValue("�ٶ�");
    cell.setHyperlink(link);// �趨��Ԫ�������

    FileOutputStream os = new FileOutputStream("e:\\workbook.xls");
    wb.write(os);
    os.close();
}

}

