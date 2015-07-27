package org.apache.jsp.expert.check;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

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

      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
      out.write("\n");
      out.write("\n");
 String cp = request.getContextPath(); 
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("\t\n");
      out.write("\t<title>专家审核</title>\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../easyui/themes/default/easyui.css\"/>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../easyui/themes/icon.css\"/>\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/jquery-1.7.1.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../../easyui/jquery.easyui.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/jquery.form.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../../easyui/locale/easyui-lang-zh_CN.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/comm.js\"></script> \n");
      out.write("<script type=\"text/javascript\" src=\"../../js/search.js\"></script> \n");
      out.write("<script type=\"text/javascript\" src=\"../../code/code.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"expert.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t/* $(document).ready(function() {\n");
      out.write("\n");
      out.write("// \t\tcombobox('xb', '../code/xb.json');\n");
      out.write("// \t\tcombobox('zyly', '../../code/zy.json');\n");
      out.write("// \t\tcombobox('zt', '../code/zt.json');\n");
      out.write("\t}); */\n");
      out.write("\tfunction reloadTable(){\n");
      out.write("\t\t//关闭对话框\n");
      out.write("\t\t$(\"#dlg\").window(\"close\");\n");
      out.write("\t\t$(\"#expertInfoTable\").datagrid(\"reload\");\n");
      out.write("\t}\n");
      out.write("\twindow.onload=function(){\n");
      out.write("\t\tinitTable();\n");
      out.write("\t}\n");
      out.write("\t</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<input type=\"hidden\" name=\"rows\" id=\"p_size\"/>\n");
      out.write("\t<form id=\"searchForm\" action=\"../expert/Expert_list.action\" method=\"post\">\n");
      out.write("\t\t<table id=\"tableid\">\n");
      out.write("\t\t</table>\n");
      out.write("\t\t\n");
      out.write("\t\t<div id=\"emailWin\" class=\"easyui-dialog\"  closed=true>\n");
      out.write("\t\t\t<div style=\"width:100%;margin:20px 0;\">发 送给：<div id=\"stus\" style=\"width:85%\"></div></div>\n");
      out.write("\t\t\t<div style=\"width:100%;margin:20px 0;\" >主题：<input style=\"width:85%\" name=\"title\"  class=\"easyui-validatebox\" required=true/></div>\n");
      out.write("\t\t\t<div style=\"width:100%;margin:10px 0;\">内容：<textarea id=\"content\" name=\"content\" class=\"easyui-validatebox\" rows=\"10\" cols=\"70\" style=\"width:85%\" ></textarea></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</form>\n");
      out.write("\n");
      out.write("\t<div style=\"height:40px; width:100%;\">\n");
      out.write("\t\t<div style=\"width:100%;  top:68px; right:20px; font-size:12px; text-align:right; color:#020e30;\">\n");
      out.write("\t\t\t<a class='easyui-linkbutton' href=\"javascript:void(0);\" iconCls='icon-search' onclick=\"submitSerach(1);\">开始检索</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<table id=\"expertInfoTable\" style=\"position: fixed; top:100px;\"></table>\n");
      out.write("\t\n");
      out.write("\t<div id=\"dlg\"></div>\n");
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
