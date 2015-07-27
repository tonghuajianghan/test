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
		request.setCharacterEncoding("utf-8");//���ܹ�����������uft����8��ʾ
		response.setContentType("text/html;charset=utf-8");//���͹�����������uft����8��ʾ
		//PrintWriter out=response.getWriter();	//	
		String name=request.getParameter("upfile");
		System.out.println(name);
		   File f1 = new File(name);
		   File f2 = new File("D:/file.txt");
		   
		   //�����Ƹ�ʽ(�ֽ���)
		   FileInputStream in = new FileInputStream(f1);
		   FileOutputStream out = new FileOutputStream(f2);
		   
		   //�ַ�����ʽ
		   InputStreamReader inp = new  InputStreamReader(in);
	 	   OutputStreamWriter outp = new   OutputStreamWriter(out);
		   
		   //������ڴ�
		   BufferedReader bufr = new BufferedReader(inp);
		   BufferedWriter bufw = new BufferedWriter(outp);
		  
		   //����̨���
		   String str = "0";
		   str = bufr.readLine();
		   int printer = Integer.parseInt(str);
		   printer = printer - 1;
		   System.out.println(printer);
		   
		   //�ļ�д��
		   String lineStr;		   
		   //��ӡ����Ϊ��
		   while((lineStr = bufr.readLine()) != null)
		   {
			  //д������һ�� 
			         //д���ַ�������ʼ��������������
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
