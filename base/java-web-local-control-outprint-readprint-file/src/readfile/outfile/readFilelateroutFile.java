package readfile.outfile;
import java.io.*;

public class readFilelateroutFile
{
	 public static void main(String args[])throws FileNotFoundException,IOException
	 {
		 
		   File f1 = new File("E:/original.txt");
		   File f2 = new File("E:/file.txt");
		   
		   //二进制格式(字节流)
		   FileInputStream in = new FileInputStream(f1);
		   FileOutputStream out = new FileOutputStream(f2);
		   
		   //字符串格式
		   InputStreamReader inp = new  InputStreamReader(in);
	 	   OutputStreamWriter outp = new   OutputStreamWriter(out);
		   
		   //缓存进内存
		   BufferedReader bufr = new BufferedReader(inp);
		   BufferedWriter bufw = new BufferedWriter(outp);
		  
		   //控制台输出
		   String str = "0";
		   str = bufr.readLine();
		   int printer = Integer.parseInt(str);
		   printer = printer - 1;
		   System.out.println(printer);
		   
		   //文件写入
		   String lineStr;		   
		   //打印不能为空
		   while((lineStr = bufr.readLine()) != null)
		   {
			  //写不出第一行 
			         //写入字符串，开始索引，结束索引
			   bufw.write(lineStr,0,lineStr.length());	
			   //bufw.write(lineStr);
		   }
		   
		   bufr.close();
		   bufw.close();
		   inp.close();
		   outp.close();
		   in.close();
		   out.close();
	 }
	 
}