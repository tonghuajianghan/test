package org.apache.jsp.pingshen.score;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>评审打分专家组页面</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../easyui/themes/default/easyui.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../easyui/themes/icon.css\"/>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/jquery-1.7.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/jquery.form.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/comm.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/search.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"../../code/code.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"score.js\"></script>\r\n");
      out.write("<!-- <script type=\"text/javascript\" src=\"../../js/index.js\"></script> -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction reloadTable(){\r\n");
      out.write("\t\t//关闭对话框\r\n");
      out.write("\t\t$(\"#dlg\").window(\"close\");\r\n");
      out.write("\t\t$(\"#scoreInfoTable\").datagrid(\"reload\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tvar user='");
      out.print(request.getRemoteUser());
      out.write("';\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\twindow.onload=function(){\r\n");
      out.write("\t\tinitTable(user);\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction addTab(title, href) {\r\n");
      out.write("\t\talert(\"title:\"+title);\r\n");
      out.write("// \t\talert(\"href:\"+href);\r\n");
      out.write("\t\tvar tt = $('#main-center');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar content = '<iframe frameborder=\"0\" src=\"' + href\r\n");
      out.write("\t\t\t\t+ '\" style=\"width:100%;height:100%;\"></iframe>';\r\n");
      out.write("\t\t\r\n");
      out.write("// \t\talert($('#main-center').tabs('select',title));\r\n");
      out.write("// \t\tif (tt.tabs('exists', title)) { //如果用户选择的已经存在则执行更新\r\n");
      out.write("// \t\t\ttt.tabs('select', title);\r\n");
      out.write("// \t\t\tvar tab = tt.tabs('getSelected'); // get selected panel\r\n");
      out.write("// \t\t\t$('#main-center').tabs('update', {\r\n");
      out.write("// \t\t\t\ttab : tab,\r\n");
      out.write("// \t\t\t\toptions : {\r\n");
      out.write("// \t\t\t\t\ttitle : title,\r\n");
      out.write("// \t\t\t\t\tclosable : true,\r\n");
      out.write("// \t\t\t\t\tcontent : content\r\n");
      out.write("// \t\t\t\t}\r\n");
      out.write("// \t\t\t});\r\n");
      out.write("// \t\t} else {\r\n");
      out.write("\t\t\t$('#main-center').tabs('add', {\r\n");
      out.write("\t\t\t\ttitle : title,\r\n");
      out.write("\t\t\t\tclosable : true,\r\n");
      out.write("\t\t\t\tcontent : content\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\talert(tt.html());\r\n");
      out.write("// \t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<table id=\"scoreInfoTable\" style=\"position: fixed; top:100px;\"></table>\r\n");
      out.write("\t<div id=\"dlg\"></div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
