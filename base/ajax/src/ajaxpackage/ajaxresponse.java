package ajaxpackage;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ajax应用
 * ajax传输数据servlet接收数据
 * servlet回传给ajax数据
 * ajax负责显示
 */
public class ajaxresponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ajaxresponse() {
        super();    
    }	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");//接受过来的数据用uft——8表示
		response.setContentType("text/html;charset=utf-8");//发送过来的数据用uft——8表示
		
		PrintWriter out=response.getWriter();	//	
		
		String name=request.getParameter("name");		
		String passward=request.getParameter("ps");
		String okpassward=request.getParameter("cps");
		if(name.equals("zhangsan")){
			out.print("<p>用户名已存在</p>");//返回字符到jsp界面中由那边的
		}else{						
			out.print("<p>用户名可用</p>");
		}
		if(passward.equals(okpassward))
		{
			out.print("<p>输入相同</p>");
		}else{
			out.print("<p>密码与确认密码输入不相同，请重新输入</p>");
		}
		
	}

}
