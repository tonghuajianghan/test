
package cust.servlet.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Htest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Htest() {
        super();

    }
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
		 response.setContentType("text/html;charset = utf-8");	 		
         String name = request.getParameter("name");
         String npw = request.getParameter("npw");   
         String w_titlenext = request.getParameter("w_titlenext");
         //out.println("name=" + name);
         //out.println("<html><body><h1>This is a servlet test.</h1></body></html>");
         request.setAttribute("id", "hhhhh");
         //response.sendRedirect("/Flexigrid/page/servlettest/lianjie.jsp" );//重新寄送       	
         //out.flush();
        
        
         
         ////////输出到next
         
        	 //response.sendRedirect("next.jsp?cl.w_title=" + cl.w_title );//重新寄送       	
        
       
         
	}

}









































