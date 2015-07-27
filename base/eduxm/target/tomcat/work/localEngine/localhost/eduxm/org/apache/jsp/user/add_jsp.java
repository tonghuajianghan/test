package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;
import cn.edu.cust.rbac.dao.UserDAO;
import cn.edu.cust.rbac.domain.User;

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
      out.write("<title>添加专家分组</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"../easyui/themes/default/easyui.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../easyui/themes/icon.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/jquery-1.7.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"../easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/comm.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/search.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"user.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\t//combobox('roles', '../code/js.json');\r\n");
      out.write("\t\t//combobox('orgcode', '../code/org.json');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#roles').combobox({    \r\n");
      out.write("\t\t    url:'../code/js.json',    \r\n");
      out.write("\t\t    valueField:'id',    \r\n");
      out.write("\t\t    textField:'text'   \r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$('#orgcode').combobox({    \r\n");
      out.write("\t\t    url:'../code/org.json',    \r\n");
      out.write("\t\t    valueField:'id',    \r\n");
      out.write("\t\t    textField:'text'   \r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tfunction addpassword() {\r\n");
      out.write("\t\t    var password = document.getElementById(\"username\").value;\r\n");
      out.write("\t\t\tvar p_length = password.length;\t\r\n");
      out.write("\t\t\t if(p_length != 18){\r\n");
      out.write("\t\t\t\t$.messager.alert(\"添加失败！\",\"请输入正确证件数字位\");\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\tvar p_part = password.substring(p_length - 6,p_length);\r\n");
      out.write("\t\t\t//$.messager.alert(p_part);\r\n");
      out.write("\t\t\tdocument.getElementById(\"password\").value = p_part; \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction submitAddUser() {\r\n");
      out.write("\t   \r\n");
      out.write("\t\t//document.getElementById(\"insert\").innerHTML(insertText);\r\n");
      out.write("\t\t//使用easyui的表单验证方式\r\n");
      out.write("\t\t$(\"#User_add\")\r\n");
      out.write("\t\t.form(\r\n");
      out.write("\t\t\t\t'submit',\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\turl : '../user/user_add.action',\r\n");
      out.write("\t\t\t\t\tonSubmit:function(){ \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t    },  \r\n");
      out.write("\t\t\t\t\tsuccess : function(data) {\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\tif ($.trim($(data).find('span').text()) != \"添加成功\") {\r\n");
      out.write("\t\t\t\t\t\t\t$.messager.alert(\"提示信息\", \"添加失败！\", \"info\");\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t$.messager.alert(\"提示信息\",$(data).find('span').text(),\"info\");\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tparent.reloadTableAfterUpdateOrAdd();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//重置\r\n");
      out.write("\tfunction clearForm() {\r\n");
      out.write("\t\t$(\"#User_add\").form('clear');\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"easyui-panel\">\r\n");
      out.write("\t\t<div style=\"padding: 10px 0 10px 1px\">\r\n");
      out.write("\t\t\t<form id=\"User_add\" method=\"post\">\r\n");
      out.write("\t\t\t\t<table id=\"main_table\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"username\">用户名称</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"username\" maxlength=\"50\" name=\"obj.username\"\r\n");
      out.write("\t\t\t\t\t\t\tmissingMessage=\"请输入用户组名称\" class='easyui-validatebox' type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\trequired=\"true\" onchange=\"addpassword()\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"roles\">用户角色</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"roles\" name=\"obj.roles\"\r\n");
      out.write("\t\t\t\t\t\t\trequired=\"true\" class=\"easyui-combobox\" type=\"text\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"orgcode\">组织</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"orgcode\" maxlength=\"50\" name=\"obj.orgcode\"\r\n");
      out.write("\t\t\t\t\t\t\trequired=\"true\" class=\"easyui-validatebox\" type=\"text\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<input id=\"password\" maxlength=\"200\" name=\"obj.password\"\r\n");
      out.write("\t\t\t\t\t\t\tclass='easyui-validatebox' type=\"hidden\" />\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<!-- <td><label for=\"password\">密码</label></td> -->\r\n");
      out.write("\t\t\t\t\t\t<!-- <td>密码为用户名后六位</td> -->\r\n");
      out.write("\t\t\t\t\t\t<!-- <input id=\"password\" maxlength=\"200\" name=\"obj.password\"  class='easyui-validatebox' type=\"hidden\"/> -->\r\n");
      out.write("\t\t\t\t\t\t<!-- <td><label for=\"orgcode\">组织</label></td>\r\n");
      out.write("\t\t\t\t<td><input id=\"orgcode\" maxlength=\"50\" name=\"obj.orgcode\" class=\"easyui-validatebox\" type=\"text\"/></td> -->\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"4\" style=\"text-align: center; padding: 5px\"><a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"easyui-linkbutton\" href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"return submitAddUser();\">保&nbsp;&nbsp;存</a> <a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"easyui-linkbutton\" href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"return clearForm();\">重&nbsp;&nbsp;置</a></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
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
