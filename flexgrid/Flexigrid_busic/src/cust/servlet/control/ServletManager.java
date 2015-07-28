package cust.servlet.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletManager() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");//接受过来的数据用uft——8表示
		 response.setContentType("text/html;charset = utf-8");	 
		 //request.setAttribute("w_id"+i,widm[i]);
		 request.setAttribute("id" , "hh");
		 request.setAttribute("name", "jianghan" );
        
         
	}

}
