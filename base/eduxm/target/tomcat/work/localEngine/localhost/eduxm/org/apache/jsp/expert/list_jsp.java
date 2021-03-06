package org.apache.jsp.expert;

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
      out.write("\r\n");

	String cp = request.getContextPath();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>评审推荐</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../easyui/themes/default/easyui.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../easyui/themes/icon.css\"/>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/jquery-1.7.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/jquery.form.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/comm.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/search.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"../code/code.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"expert.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction reloadTable(){\r\n");
      out.write("\t\t//关闭对话框\r\n");
      out.write("\t\t$(\"#dlg\").window(\"close\");\r\n");
      out.write("\t\t$(\"#expertInfoTable\").datagrid(\"reload\");\r\n");
      out.write("\t}\r\n");
      out.write("\twindow.onload=function(){\r\n");
      out.write("\t\tinitTable();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<input type=\"hidden\" name=\"rows\" id=\"p_size\"/>\r\n");
      out.write("\t<form id=\"searchForm\" action=\"../expert/Expert_getall.action\" method=\"post\">\r\n");
      out.write("\t\t<table id=\"tableid\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"hidden\" name=\"search.logicalopts\" value=\"\" /> &nbsp;&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<select id=\"searchCol\" name=\"search.columns\" onchange=\"change(0,this)\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"-\">---请选择要检索的单元---</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"c_xm\">专家姓名</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"c_xb\">专家性别</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"c_zc\">专家职称</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"c_zw\">专家职务</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"c_zyly\">专业领域</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"c_yjfx\">研究方向</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"c_csny\">出生年月</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"c_ssdw\">所属单位</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"c_dzyj\">电子邮件</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"c_lxdh\">联系电话</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<select id=\"searchOpera\" name=\"search.operators\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"eq\">=</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"ne\">&ne;</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"gt\">&gt;</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"ge\">&ge;</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"lt\">&lt;</option>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"le\">&le;</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"like\">like</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td id=\"td_0\"><input id=\"searchVal\" name=\"search.values\" type=\"text\" /></td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<select name=\"search.orders\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"none\">不排序</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"asc\">升序</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"desc\">降序</option>\r\n");
      out.write("\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t <a class=\"easyui-linkbutton\" iconCls='icon-add' href=\"javascript:addSelect();\">添加检索项</a>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"emailWin\" class=\"easyui-dialog\"  closed=true>\r\n");
      out.write("\t\t\t<div style=\"width:100%;margin:20px 0;\">发 送给：<div id=\"stus\" style=\"width:85%\"></div></div>\r\n");
      out.write("\t\t\t<div style=\"width:100%;margin:20px 0;\" >主题：<input style=\"width:85%\" name=\"title\"  class=\"easyui-validatebox\" required=true/></div>\r\n");
      out.write("\t\t\t<div style=\"width:100%;margin:10px 0;\">内容：<textarea id=\"content\" name=\"content\" class=\"easyui-validatebox\" rows=\"10\" cols=\"70\" style=\"width:85%\" ></textarea></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\t<div style=\"height:40px; width:100%;\">\r\n");
      out.write("\t\t<div style=\"width:100%;  top:68px; right:20px; font-size:12px; text-align:right; color:#020e30;\">\r\n");
      out.write("\t\t\t<a class='easyui-linkbutton' href=\"javascript:void(0);\" iconCls='icon-search' onclick=\"submitSerach(1);\">开始检索</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<table id=\"expertInfoTable\" style=\"position: fixed; top:100px;\"></table>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"dlg\"></div>\r\n");
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
