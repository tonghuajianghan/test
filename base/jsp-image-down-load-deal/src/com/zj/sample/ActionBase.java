package com.zj.sample;

import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//import com.sun.net.httpserver.HttpContext;

public abstract class ActionBase extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -453504160098126354L;
	
	ActionContext context = ActionContext.getContext(); 
	ServletContext  application=(ServletContext )context.get(org.apache.struts2.StrutsStatics.SERVLET_CONTEXT);
	HttpServletRequest request = (HttpServletRequest) context.get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
	HttpServletResponse response = (HttpServletResponse) context.get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
	HttpSession session =request.getSession();
	public String execute() throws Exception{
		String method = request.getParameter("method");
		Method m = this.getClass().getMethod(method);
		return (String) m.invoke(this);
	}
	
}
