package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');

String cp = request.getContextPath();

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<title>科研项目管理平台</title>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(cp );
      out.write("/easyui/themes/default/easyui.css\"/>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(cp );
      out.write("/easyui/themes/icon.css\"/>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(cp );
      out.write("/js/jquery-1.7.1.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(cp );
      out.write("/easyui/jquery.easyui.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(cp );
      out.write("/easyui/locale/easyui-lang-zh_CN.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function check(){\n");
      out.write("\tif(window != top)\n");
      out.write("\t\ttop.location = \"");
      out.print(cp);
      out.write("/index.jsp\";\n");
      out.write("}\n");
      out.write("function submitForm() {\n");
      out.write("\t\n");
      out.write("\tif(!$(\"#loginForm\").form(\"validate\")) {\n");
      out.write("\t\treturn;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t$('#loginForm').submit();\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body class=\"easyui-layout\" id=\"tbody\" onload=\"check();\">\n");
      out.write("\t<div region=\"center\" style=\"background: #DEDEE0 url(images/bodybg.jpg);\" >\n");
      out.write("\t\t<center><br/><br/><br/><h1>科研项目管理平台</h1></center>\n");
      out.write("\t\t<div class=\"easyui-dialog\" title=\"用 户 登 陆\" style=\"width:400px;height:300px;padding-top:18%;text-align: center;\"\n");
      out.write("\t\t\t buttons=\"#dlg-buttons\" resizable=\"false\" draggable=\"false\" closable=\"false\">\n");
      out.write("\t\t\t<form id=\"loginForm\" action='' method=\"post\">\n");
      out.write("\t\t\t\t<div style=\"padding:10px;\">\n");
      out.write("\t\t\t\t\t用户名&nbsp;:&nbsp;<input class=\"easyui-validatebox\" type=\"text\" name=\"username\"\n");
      out.write("\t\t\t\t\tdata-options=\"required:true\"  />\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div style=\"padding:10px;\">\n");
      out.write("\t\t\t\t\t密　码&nbsp;:&nbsp;<input class=\"easyui-validatebox\" id=\"pwd\" type=\"password\" name=\"password\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdata-options=\"required:true\" />\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<div id=\"dlg-buttons\">\n");
      out.write("\t\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"submitForm();\">登录</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
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
