package readfile.outfile;
import java.io.*;

public class readFilelateroutFile
{
	 public static void main(String args[])throws FileNotFoundException,IOException
	 {
		 
		   File f1 = new File("E:/original.txt");
		   File f2 = new File("E:/file.txt");
		   
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