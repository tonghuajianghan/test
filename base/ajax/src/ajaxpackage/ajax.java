package ajaxpackage;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Servlet implementation class ComeBack
 */
public class ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//接受过来的数据用uft——8表示
		response.setContentType("text/html;charset=utf-8");//发送过来的数据用uft——8表示
		PrintWriter out=response.getWriter();	//	
		String name=request.getParameter("username");
		System.out.println(name);
		String passward=request.getParameter("psw");
		String okpassward=request.getParameter("confpsw");
		if(name.equals("zhangsan")){
			out.print("用户名已存在");//返回字符到jsp界面中由那边的
		}else{
			out.print("用户名可用");
		}
		if(passward.equals(okpassward))
		{
			out.print("输入相同");
		}else{
			out.print("密码与确认密码输入不相同，请重新输入");
		}
		
	}

}
