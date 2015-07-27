package org.apache.jsp.pingshen.group;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>添加专家分组</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../easyui/themes/default/easyui.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../easyui/themes/icon.css\"/>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/jquery-1.7.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/comm.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/search.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"group.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\tcombobox('groupField', '../../code/zy.json');\r\n");
      out.write("\t});\r\n");
      out.write("\tfunction submitAddGroup() {\r\n");
      out.write("\t\t//使用easyui的表单验证方式\r\n");
      out.write("\t\t$(\"#Group_add\").form('submit',{\r\n");
      out.write("\t\t\t url:'Group_add.action',\r\n");
      out.write("\t\t\t onSubmit:function () {\r\n");
      out.write("\t\t\t\t //var reg = new RegExp('^[^\\\\\\\\\\\\/:*%()~!:;\\'#$?\\\\\"<>|]+$');\r\n");
      out.write("\t\t\t\t var numreg = new RegExp('^[0-9]*$');\r\n");
      out.write("\t\t\t\t $('#groupName').append('<span style>专家组名称不能有特殊符号 \\/:*%()~!:;\\'#$?\\\\\\\"<>|</span>');\r\n");
      out.write("\t\t\t\t\t//if(reg.test($('#groupName').val())){\r\n");
      out.write("\t\t\t\t \t\t\r\n");
      out.write("\t\t\t\t \t\t//$('#groupName').append(\"<span>专家组名称不能有特殊符号 \\/:*%()~!:;\\'#$?\\\\\\\"<>|</span>\");\r\n");
      out.write("\t\t\t\t \t\t//return false;\r\n");
      out.write("\t\t\t\t\t//}\r\n");
      out.write("\t\t\t\t\t//alert($('#year').val().length);\r\n");
      out.write("\t\t\t\t\tif(!(numreg.test($('#year').val())&&($('#year').val().length==4))){\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert(\"提示信息\",\"年度为数字\",\"info\");\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tif(!(numreg.test($('#maxManCount').val()))){\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert(\"提示信息\",\"最多人数为数字\",\"info\");\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tif(!(numreg.test($('#maxProjectCount').val()))){\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert(\"提示信息\",\"最多项目数为数字\",\"info\");\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\treturn $(this).form(\"validate\");\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t},\r\n");
      out.write("\t \tsuccess:function(data){\r\n");
      out.write("\t \t\tif($.trim($(data).find('span').text())!=\"添加成功\"){\r\n");
      out.write("\t \t\t\t$.messager.alert(\"提示信息\",\"添加失败！\",\"info\");\r\n");
      out.write("\t \t\t}else{\r\n");
      out.write("\t \t\t\t$.messager.alert(\"提示信息\",$(data).find('span').text(),\"info\");\r\n");
      out.write("\t \t\t}\r\n");
      out.write("\t\t \tparent.reloadTableAfterUpdateOrAdd();\r\n");
      out.write("\t\t }\r\n");
      out.write("\t\t}); \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//重置\r\n");
      out.write("\tfunction clearForm() {\r\n");
      out.write("\t\t$(\"#Group_add\").form('clear');\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"easyui-panel\"  >\r\n");
      out.write("\t <div style=\"padding:10px 0 10px 1px\">\r\n");
      out.write("\t \t<form id=\"Group_add\" method=\"post\" >\r\n");
      out.write("\t\t<table id=\"main_table\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><label for=\"groupName\">专家组名称</label></td>\r\n");
      out.write("\t\t\t\t<td><input id=\"groupName\" maxlength=\"50\" name=\"obj.groupName\" missingMessage=\"请输入专家组名称\" class='easyui-validatebox' required=\"true\" type=\"text\"/></td>\r\n");
      out.write("\t\t\t\t<td><label for=\"groupField\">专业领域</label></td>\r\n");
      out.write("\t\t\t\t<td><input id=\"groupField\" name=\"obj.groupField\" class=\"easyui-combobox\" required=\"true\"/></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><label for=\"year\">年度</label></td>\r\n");
      out.write("\t\t\t\t<!-- <td><select id=\"college\" name=\"obj.college\" onchange=\"collegeChange()\">\t</select></td> -->\r\n");
      out.write("\t\t\t\t<td><input id=\"year\" maxlength=\"4\" name=\"obj.year\" />\t</td>\r\n");
      out.write("\t\t\t\t<td><label for=\"maxManCount\">最多人数</label></td>\r\n");
      out.write("\t\t\t\t<td><input id=\"maxManCount\" name=\"obj.maxManCount\" class=\"easyui-validatebox\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><label for=\"maxProjectCount\">最多项目数</label></td>\r\n");
      out.write("\t\t\t\t<td><input id=\"maxProjectCount\" name=\"obj.maxProjectCount\" class=\"easyui-validatebox\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"110px\">\r\n");
      out.write("\t\t\t\t<td><label for=\"remark\">备注</label></td>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<div class=\"easyui-layout\" fit=\"true\">\r\n");
      out.write("                        <div split=\"true\" style=\"height:100px;\">\r\n");
      out.write("                            <textarea id=\"remark\" maxlength=\"200\" name=\"obj.remark\" style=\"border:1px solid gray;width:98%;height:100%;resize:none\"></textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"110px\">\r\n");
      out.write("\t\t\t\t<td><label for=\"remark\">专家分组说明</label></td>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<div class=\"easyui-layout\" fit=\"true\">\r\n");
      out.write("                        <div split=\"true\" style=\"height:100px;\">\r\n");
      out.write("                            <textarea id=\"groupExplain\" maxlength=\"200\" name=\"obj.groupExplain\" style=\"border:1px solid gray;width:98%;height:100%;resize:none\"></textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"4\" style=\"text-align: center; padding: 5px\"> \r\n");
      out.write("\t\t\t\t\t<a class=\"easyui-linkbutton\" href=\"javascript:void(0);\" onclick=\"return submitAddGroup();\">保&nbsp;&nbsp;存</a>\r\n");
      out.write("\t\t\t\t\t<a class=\"easyui-linkbutton\" href=\"javascript:void(0);\" onclick=\"return clearForm();\">重&nbsp;&nbsp;置</a>\r\n");
      out.write("\t\t\t\t</td> \r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t </div>\r\n");
      out.write("</div>\r\n");
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
