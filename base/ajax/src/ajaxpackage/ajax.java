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
		request.setCharacterEncoding("utf-8");//���ܹ�����������uft����8��ʾ
		response.setContentType("text/html;charset=utf-8");//���͹�����������uft����8��ʾ
		PrintWriter out=response.getWriter();	//	
		String name=request.getParameter("username");
		System.out.println(name);
		String passward=request.getParameter("psw");
		String okpassward=request.getParameter("confpsw");
		if(name.equals("zhangsan")){
			out.print("�û����Ѵ���");//�����ַ���jsp���������Ǳߵ�
		}else{
			out.print("�û�������");
		}
		if(passward.equals(okpassward))
		{
			out.print("������ͬ");
		}else{
			out.print("������ȷ���������벻��ͬ������������");
		}
		
	}

}
