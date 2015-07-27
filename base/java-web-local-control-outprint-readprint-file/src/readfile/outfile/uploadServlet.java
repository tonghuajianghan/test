package readfile.outfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class upload
 */
@WebServlet("/upload")
public class uploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public uploadServlet() {
        super();        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//接受过来的数据用uft——8表示
		response.setContentType("text/html;charset=utf-8");//发送过来的数据用uft——8表示
		//PrintWriter out=response.getWriter();	//	
		String name=request.getParameter("upfile");
		System.out.println(name);
		   File f1 = new File(name);
		   File f2 = new File("D:/file.txt");
		   
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
