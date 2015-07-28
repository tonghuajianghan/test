package cust.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("mark1");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset = utf-8");	 
        out.println("<html><body>");
        String number = request.getParameter("number");
        System.out.println(number);
        double n = 0;
        try{
       	 n = Double.parseDouble(number);
       	 out.println("<br>" + Math.sqrt(n));
        }catch(NumberFormatException e){
       	 out.println("<h1>input number letter please</h1>");
        }
        out.println("</body></html>");
        System.out.print("oooooooooooo");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset = utf-8");	 		
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd"); 
        if(name.equals("jh") && pwd.equals("123")){
        	//response.sendRedirect("/HelloWorld.jsp");
        	request.getRequestDispatcher("HelloWorld.jsp").forward(request, response);
        	System.out.println(name);
            System.out.println(pwd);
        }else{
        	System.out.println("请输入正确用户名或密码");
        }
	}

}
