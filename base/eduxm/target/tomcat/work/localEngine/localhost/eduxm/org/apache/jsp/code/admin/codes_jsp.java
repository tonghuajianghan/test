package org.apache.jsp.code.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class codes_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
String filename=request.getParameter("filename"); 
      out.write("\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("<title>代码库管理详细</title>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../easyui/themes/default/easyui.css\"/>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../easyui/themes/icon.css\"/>\n");
      out.write("\t\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/jquery-1.7.1.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../../easyui/jquery.easyui.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../../easyui/locale/easyui-lang-zh_CN.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/comm.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"codes.js\"></script>\t\t\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div style=\"margin:10px 0;\">\n");
      out.write("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-add'\" onclick=\"add()\">添加节点</a>\n");
      out.write("\t\t<!-- <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"addChildren()\">添加子节点</a>\n");
      out.write("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"edit()\">编辑</a>\n");
      out.write("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"removeit()\">删除</a> -->\n");
      out.write("</div>\n");
      out.write("<table id=\"tg\"  style=\"height:420%\"></table> \n");
      out.write("<div id=\"appendFileDlg\" class=\"easyui-dialog\" title=\"编辑节点\" style=\"width: 400px; height: 200px; padding: 10px\">\n");
      out.write("\t<form id=\"appendFileForm\" method=\"post\" action=\"\">\n");
      out.write("\t\t<input id=\"hfilename\" type=\"hidden\" name=\"filename\" value=\"");
      out.print(filename);
      out.write("\"/>\n");
      out.write("\t\t<input type=\"hidden\" id=\"hpId\" value=\"\" name=\"parentId\"/>\n");
      out.write("\t\t<input type=\"hidden\" id=\"oldId\" value=\"\" name=\"oldId\"/>\n");
      out.write("\t\t<table>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>代码：</td>\n");
      out.write("\t\t\t\t<td><input id=\"nodeId\" class=\"easyui-validatebox\" type=\"text\" name=\"obj.id\" data-options=\"required:true\" /></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>名称：</td>\n");
      out.write("\t\t\t\t<td><input id=\"nodeText\" class=\"easyui-validatebox\" type=\"text\" name=\"obj.text\" data-options=\"required:true\" /></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>拼音：</td>\n");
      out.write("\t\t\t\t<td><input id=\"nodePinyin\" class=\"easyui-validatebox\" type=\"text\" name=\"obj.pinyin\"  /></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t</form>\n");
      out.write("\t<div style=\"text-align: center; padding: 5px\">\n");
      out.write("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"submitAppendFileForm()\">提交</a>\n");
      out.write("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick='$(\"#appendFileDlg\").form(\"clear\"); '>重置</a>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("\t\n");
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
