package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.release();
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
      out.write('\n');
      out.write('\n');
 String cp = request.getContextPath(); 
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-\n");
      out.write("transitional.dtd\">\n");
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("\t<title>修改用户信息</title>\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../easyui/themes/default/easyui.css\"/>\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../easyui/themes/icon.css\"/>\n");
      out.write("\t<script type=\"text/javascript\" src=\"../js/jquery-1.7.1.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"../easyui/jquery.easyui.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"../easyui/locale/easyui-lang-zh_CN.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"../js/comm.js\"></script> \n");
      out.write("\t<script type=\"text/javascript\" src=\"../js/search.js\"></script> \n");
      out.write("\t");
      out.write("\n");
      out.write("\t\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function() {\n");
      out.write("\t\t//combobox('roles', '../code/js.json');\n");
      out.write("\t\t//combobox('orgcode', '../code/org.json');\n");
      out.write("\t\t\n");
      out.write("\t\t$('#roles').combobox({    \n");
      out.write("\t\t    url:'../code/js.json',    \n");
      out.write("\t\t    valueField:'id',    \n");
      out.write("\t\t    textField:'text'   \n");
      out.write("\t\t});\n");
      out.write("\t\t$('#orgcode').combobox({    \n");
      out.write("\t\t    url:'../code/org.json',    \n");
      out.write("\t\t    valueField:'id',    \n");
      out.write("\t\t    textField:'text'   \n");
      out.write("\t\t});\n");
      out.write("\t});\t\t\n");
      out.write("\t\tfunction submitAddUser() {\n");
      out.write("\t\t\tvar password = document.getElementById(\"username\").value;\n");
      out.write("\t\t\tvar p_length = password.length;\t\n");
      out.write("\t\t\tvar p_part = password.substring(p_length - 6,p_length);\n");
      out.write("\t\t\t//$.messager.alert(p_part);\n");
      out.write("\t\t\tdocument.getElementById(\"password\").value = p_part; \n");
      out.write("\t\t\t\n");
      out.write("\t\t\t$(\"#User_update\").form('submit',{\n");
      out.write("\t\t\t\turl : '../user/user_update.action',\n");
      out.write("\t\t\t\tonSubmit : function() {\n");
      out.write("\t\t\t\t\t/* var numreg = new RegExp('^[0-9]*$');\n");
      out.write("\t\t\t\t\t $('#username').append('<span style>专家组名称不能有特殊符号 \\/:*%()~!:;\\'#$?\\\\\\\"<>|</span>'); */\n");
      out.write("\t\t\t\t\t\t//if(reg.test($('#groupName').val())){\n");
      out.write("\t\t\t\t\t \t\t\n");
      out.write("\t\t\t\t\t \t\t//$('#groupName').append(\"<span>专家组名称不能有特殊符号 \\/:*%()~!:;\\'#$?\\\\\\\"<>|</span>\");\n");
      out.write("\t\t\t\t\t \t\t//return false;\n");
      out.write("\t\t\t\t\t\t//}\n");
      out.write("\t\t\t\t\t\t//alert($('#year').val().length);\n");
      out.write("\t\t\t\t\t\t//if(numreg.test($('#year').val())&&($('#year').val().length==4)){\n");
      out.write("\t\t\t\t\t\t\t//return $(this).form(\"validate\");\n");
      out.write("\t\t\t\t\t\t//}\n");
      out.write("\t\t\t\t\t\t//$.messager.alert(\"提示信息\",\"年度为数字\",\"info\");\n");
      out.write("\t\t\t\t\t\t//return false;\n");
      out.write("\t\t\t\t},\n");
      out.write("\t\t\t\tsuccess : function(data) {\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\tif($.trim($(data).find('span').text())!=\"修改成功\"){\n");
      out.write("\t\t\t \t\t\t$.messager.alert(\"提示信息\",\"修改失败！\",\"info\");\n");
      out.write("\t\t\t \t\t}else{\n");
      out.write("\t\t\t \t\t\t$.messager.alert(\"提示信息\",$(data).find('span').text(),\"info\");\n");
      out.write("\t\t\t \t\t}\n");
      out.write("\t\t\t\t \tparent.reloadTableAfterUpdateOrAdd();\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t}\n");
      out.write("\t\t//重置\n");
      out.write("\t\tfunction clearForm() {\n");
      out.write("\t\t\t$(\"#User_update\").form('clear');\n");
      out.write("\t\t} \n");
      out.write("\t\t\n");
      out.write("\t</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"easyui-panel\" >\n");
      out.write("\t <div style=\"padding:10px 0 10px 1px\">\n");
      out.write("\t \t<form id=\"User_update\" action=\"\" method=\"post\">\n");
      out.write("\t \t");
      out.write("\n");
      out.write("\t\t<table id=\"main_table\">\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><label for=\"username\">用户名</label></td>\n");
      out.write("\t\t\t\t<td><input id=\"username\" maxlength=\"20\" name=\"obj.Username\" readonly=\"readonly\" value=\"");
      if (_jspx_meth_s_005fproperty_005f0(_jspx_page_context))
        return;
      out.write("\"  missingMessage=\"请输入用户名\" class='easyui-validatebox' required=\"true\" type=\"text\"/></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\t\n");
      out.write("\t\t\t\t<td><label for=\"roles\">用户角色</label></td>\n");
      out.write("\t\t\t\t<td><input id=\"roles\" name=\"obj.roles\" class=\"easyui-combobox\" value=\"");
      if (_jspx_meth_s_005fproperty_005f1(_jspx_page_context))
        return;
      out.write("\" type=\"text\"/></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\t\n");
      out.write("\t\t\t\t<td><label for=\"orgcode\">组织</label></td>\n");
      out.write("\t\t\t\t<td><input id=\"orgcode\" value=\"");
      if (_jspx_meth_s_005fproperty_005f2(_jspx_page_context))
        return;
      out.write("\" maxlength=\"50\" name=\"obj.orgcode\" class=\"easyui-validatebox\" type=\"text\"/></td>\n");
      out.write("\t\t\t    \n");
      out.write("\t\t\t    <input id=\"password\" maxlength=\"200\" name=\"obj.password\"  class='easyui-validatebox' type=\"hidden\"/>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td colspan=\"4\" style=\"text-align: center; padding: 5px\">  \t\t\t  \n");
      out.write("\t\t\t\t\t <a class=\"easyui-linkbutton\" href=\"javascript:void(0);\" onclick=\"return submitAddUser();\">保　存</a> \n");
      out.write("\t\t\t\t\t<a class=\"easyui-linkbutton\" href=\"javascript:void(0);\" onclick=\"return clearForm();\">重　置</a>\n");
      out.write("\t\t\t\t</td> \n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t \t</form>\n");
      out.write("\t </div>\n");
      out.write("</div>\n");
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

  private boolean _jspx_meth_s_005fproperty_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f0 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f0.setParent(null);
    // /user/update.jsp(87,91) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f0.setValue("obj.username");
    int _jspx_eval_s_005fproperty_005f0 = _jspx_th_s_005fproperty_005f0.doStartTag();
    if (_jspx_th_s_005fproperty_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f1 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f1.setParent(null);
    // /user/update.jsp(91,74) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f1.setValue("obj.roles");
    int _jspx_eval_s_005fproperty_005f1 = _jspx_th_s_005fproperty_005f1.doStartTag();
    if (_jspx_th_s_005fproperty_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f2 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f2.setParent(null);
    // /user/update.jsp(95,35) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f2.setValue("obj.orgcode");
    int _jspx_eval_s_005fproperty_005f2 = _jspx_th_s_005fproperty_005f2.doStartTag();
    if (_jspx_th_s_005fproperty_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f2);
    return false;
  }
}
