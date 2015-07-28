//hibernate�ṩ��save����ʹ��

package com.test;
import java.io.FileOutputStream;
import java.util.List;

import com.hibernate.vo.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class PoiSql02 {
	public static void main(String[] args) throws Exception {

              
       Configuration cfg = new Configuration();     
       SessionFactory sf = cfg.configure().buildSessionFactory();      
       Session session = sf.openSession();     
       session.beginTransaction();
        
       HSSFWorkbook wb = new HSSFWorkbook();//excel�ļ�
	   HSSFSheet sheet = wb.createSheet("sheet1");//excel��	
	   
	   
	   HSSFRow row0 = sheet.createRow(0); 
	   HSSFCell cell0 = row0.createCell(1);
	   cell0.setCellValue("我的");
		
	   //设置字体  
	   HSSFCellStyle style = wb.createCellStyle();
	   
       HSSFFont font = wb.createFont();  
       font.setFontHeightInPoints((short)12);  
       font.setFontName("Courier New");  
       font.setItalic(false);  
       //font.setBoldweight((short)8); 
       font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
       
       style.setFont(font);  
       cell0.setCellStyle(style); 
	   
       //HQL���
       Query query = session.createQuery("from Money");
       List peList = query.list();         	
       for(int i = 1; i < peList.size() + 1;i++){  		 
  		 Money m =(Money)peList.get(i - 1);
  		 HSSFRow row = sheet.createRow(i); 
  		 for(int j=0;j < 4;j++){
  			HSSFCell cell = row.createCell(j);
  			if(j==0){
  				cell.setCellValue(m.getId());
  			}else if(j==1){
  				cell.setCellValue(m.getMoney());
  			}
  			
  	  		
  		 }
 	     
  	   }
                      
       session.getTransaction().commit();
       session.close();
       sf.close();
         
       FileOutputStream os = new FileOutputStream("e:\\workbook02.xls");
	   wb.write(os);
	   os.close();	
       
	}
}
