//hibernate提供的save方法使用

package com.test;
import java.io.FileOutputStream;
import java.util.List;

import com.hibernate.vo.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class PoiSql {
	public static void main(String[] args) throws Exception {

              
       Configuration cfg = new Configuration();     
       SessionFactory sf = cfg.configure().buildSessionFactory();      
       Session session = sf.openSession();     
       session.beginTransaction();
        
       HSSFWorkbook wb = new HSSFWorkbook();
	   HSSFSheet sheet = wb.createSheet("sheet1");				   
										       
       //HQL语句
       Query query = session.createQuery("from Student");
       List<Student>  peList = query.list();
       System.out.println("mark:"+peList.size());
  	
       for(int i = 0; i < peList.size();i++){
  		 Student stu =(Student)peList.get(i);  		  		 
  		 HSSFRow row = sheet.createRow(i); 
  		 for(int j=0;j < 4;j++){
  			HSSFCell cell = row.createCell(j);
  			if(j==0){
  				cell.setCellValue(stu.getId());
  			}else if(j==1){
  				cell.setCellValue(stu.getName());
  			}else if(j==2){
  				cell.setCellValue(stu.getAge());
  			}
  			
  	  		
  		 }
 	     
  	   }
                      
       session.getTransaction().commit();
       session.close();
       sf.close();
       
       FileOutputStream os = new FileOutputStream("e:\\workbook03.xls");
	   wb.write(os);
	   os.close();	
       
	}
}
