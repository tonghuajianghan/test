package ajaxpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jh
 * @date 2015-8-5
 * @Description: test ajax js 
 */
public class ajaxresponse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ajaxresponse() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter(); 

		String name = request.getParameter("name");
		System.out.println("name:" + name);
		String passward = request.getParameter("ps");
		String okpassward = request.getParameter("cps");
		if (name.equals("zhangsan")) {
			out.print("<p>hello ajax</p>");
		} else {
			out.print("<p>error zhangsan</p>");
		}
		if (passward.equals(okpassward)) {
			out.print("<p>password OK</p>");
		} else {
			out.print("<p>password error</p>");
		}

	}

}
