package org.apache.jsp.project.details;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;

public final class innerIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

	String cp = request.getContextPath();
	String projectId = request.getParameter("projectId");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>innerIndex</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../easyui/themes/default/easyui.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../easyui/themes/icon.css\"/>\r\n");
      out.write("\t\t\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"../../js/jquery-1.7.1.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"../../js/jquery.form.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"../../easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"../../easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"../../js/comm.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"../../js/search.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"project.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"../../js/index.js\"></script> \r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\twindow.onload=function(){\r\n");
      out.write("\t\t$('#main-center').tabs({\r\n");
      out.write("\t\t    border:false,\r\n");
      out.write("\t\t    onSelect:function(title){\r\n");
      out.write("\t\t        if(title == \"项目成员信息\"){\r\n");
      out.write("\t\t        \tinitMember('");
      out.print(projectId);
      out.write("');\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t        if(title == \"负责人承担项目信息\"){\r\n");
      out.write("\t\t        \tinitPrincipalProj('");
      out.print(projectId);
      out.write("');\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t        if(title == \"负责人和成员近期的研究成果信息\"){\r\n");
      out.write("\t\t        \tinitAchievementBefore('");
      out.print(projectId);
      out.write("');\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"easyui-layout\" style=\"overflow: auto\">\r\n");
      out.write("\t<div data-options=\"region:'center',split:false,overflow:true\">\r\n");
      out.write("\t\t<div id=\"main-center\" class=\"easyui-tabs\" fit=\"true\" border=\"false\">\r\n");
      out.write("\t\t\t<div title=\"项目信息\" style=\"padding: 20px;\" closable=\"false\" href=\"Project_details.action?obj.xm_id=");
      out.print(projectId);
      out.write("\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div title=\"项目负责人信息\" style=\"padding: 20px;\" closable=\"false\" href=\"Principal_load.action?projectid=");
      out.print(projectId);
      out.write("\"></div>\r\n");
      out.write("\t\t\t<div title=\"项目成员信息\" style=\"padding: 20px;\" closable=\"false\">\r\n");
      out.write("\t\t\t\t<table id=\"memberTable\" style=\"position: fixed; top:100px;\"></table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div title=\"负责人承担项目信息\" style=\"padding: 20px;\" closable=\"false\" >\r\n");
      out.write("\t\t\t\t<table id=\"principalProjTable\" style=\"position: fixed; top:100px;\"></table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div title=\"负责人和成员近期的研究成果信息\" style=\"padding: 20px;\" closable=\"false\"  href=\"\">\r\n");
      out.write("\t\t\t\t<table id=\"achievementBeforeTable\" style=\"position: fixed; top:100px;\"></table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
