package com.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.hibernate.vo.Student;

@WebServlet("/FlexiGridServlet")
public class FlexiGridServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FlexiGridServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String EmpID=request.getParameter("EmpID");
		Student s = new Student();
		
		s.setId(11);
		s.setName(EmpID);
		System.out.println("³É¹¦");
		 
		 Configuration cfg = new Configuration();
		 SessionFactory sf = cfg.configure().buildSessionFactory();
		 Session session = sf.openSession();
		 session.beginTransaction();
		 session.save(s);
		 session.getTransaction().commit();
		 session.close();
		 sf.close();
	}

}
