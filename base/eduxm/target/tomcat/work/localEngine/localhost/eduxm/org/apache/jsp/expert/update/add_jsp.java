package org.apache.jsp.expert.update;

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
      out.write("<title>添加专家</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"../../easyui/themes/default/easyui.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"../../easyui/themes/icon.css\" />\r\n");
      out.write("<link href=\"../../css/bootstrap.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"../../css/jquery.fileupload.css\" type=\"text/css\"\r\n");
      out.write("\trel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/jquery-1.7.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../easyui/jquery.eas\tyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"\r\n");
      out.write("\tsrc=\"../../easyui/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/comm.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/search.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../list/expert.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/imagePreview.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t/* combobox('zyly', '../code/zy.json'); */\r\n");
      out.write("\r\n");
      out.write("\t\t//$(\"#xb\").combobox('reload', '../../code/xb.json');\r\n");
      out.write("\t\t//$(\"#zt\").combobox('reload', '../../code/zt.json');\r\n");
      out.write("\t\t//$(\"#zyly\").combobox('reload', '../../code/zy.json');\r\n");
      out.write("\t\t//combobox('zt', '../../code/zt.json');\r\n");
      out.write("\t\t//combobox('zyly', '../../code/zy.json');\r\n");
      out.write("\t\t$('#xb').combobox({    \r\n");
      out.write("\t\t    url:'../../code/xb.json',    \r\n");
      out.write("\t\t    valueField:'id',    \r\n");
      out.write("\t\t    textField:'text'   \r\n");
      out.write("\t\t});  \r\n");
      out.write("/* \t\t$('#zt').combobox({    \r\n");
      out.write("\t\t    url:'../../code/zt.json',    \r\n");
      out.write("\t\t    valueField:'id',    \r\n");
      out.write("\t\t    textField:'text'   \r\n");
      out.write("\t\t});   */\r\n");
      out.write("\t\t$('#zyly').combobox({    \r\n");
      out.write("\t\t    url:'../../code/zy.json',    \r\n");
      out.write("\t\t    valueField:'id',    \r\n");
      out.write("\t\t    textField:'text'   \r\n");
      out.write("\t\t});  \r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\tfunction submitAddExpert() {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#Expert_add\").form('submit',{\r\n");
      out.write("\t\t\turl : '../expert/Expert_add.action',\r\n");
      out.write("\t\t\tonSubmit : function() {\r\n");
      out.write("\t\t\t\treturn $(this).form(\"validate\");\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif($.trim($(data).find('span').text())!=\"添加成功\"&&$.trim($(data).find('span').text())!=\"用户名已存在\"){\r\n");
      out.write("\t\t \t\t\t$.messager.alert(\"提示信息\",\"添加失败！\",\"info\");\r\n");
      out.write("\t\t \t\t}else{$.messager.alert(\"提示信息\",$(data).find('span').text(),\"info\");\r\n");
      out.write("\t\t \t\t}\r\n");
      out.write("\t\t\t \tparent.reloadTableAfterUpdateOrAdd();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("\tfunction clearForm() {\r\n");
      out.write("\t\t$(\"#Expert_add\").form('clear');\r\n");
      out.write("\t};\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"easyui-panel\">\r\n");
      out.write("\r\n");
      out.write("\t\t<form id=\"Expert_add\" action=\"\" method=\"post\"\r\n");
      out.write("\t\t\tenctype=\"multipart/form-data\">\r\n");
      out.write("\t\t\t<div style=\"padding: 10px 0 10px 1px;\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<table id=\"main_table\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"username\">身份证号</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"username\" maxlength=\"20\" name=\"obj.Username\"\r\n");
      out.write("\t\t\t\t\t\t\tmissingMessage=\"请输入有效身份证号\" invalidMessage=\"身份证号应为18位\"\r\n");
      out.write("\t\t\t\t\t\t\tclass='easyui-validatebox' required=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\tvalidtype=\"length[18,18]\" type=\"text\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"xm\">姓名</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"xm\" maxlength=\"50\" name=\"obj.xm\"\r\n");
      out.write("\t\t\t\t\t\t\tmissingMessage=\"请输入姓名\" class='easyui-validatebox' required=\"true\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<td  rowspan=\"4\"><img id=\"img_prev\" width=\"150\" height=\"150\" src=\"../../images/stuphoto.png\"/>\r\n");
      out.write("\t\t\t\t\t\t</td> \r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"xb\">性别</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<!-- <td><select id=\"college\" name=\"obj.college\" onchange=\"collegeChange()\">\t</select></td> -->\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"xb\" maxlength=\"20\" name=\"obj.xb\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"easyui-combobox\" required=\"true\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"zc\">职称</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<!-- <td><select id=\"major\" name=\"obj.major\"><option value=\"\">-----请先选择学院----</option></select></td> -->\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"zc\" maxlength=\"20\" name=\"obj.zc\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"easyui-validatebox\" required=\"true\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<!-- <td><input type=\"file\" file\" id=\"file\" value=\"添加图片\"\r\n");
      out.write("\t\t\t\t\t\t\tonchange=\"preview(this,'preview','imghead');\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"fileinput-button\" />\r\n");
      out.write("\t\t\t\t\t\t</td> -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"zw\">职务</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"zw\" maxlength=\"50\" name=\"obj.zw\"\r\n");
      out.write("\t\t\t\t\t\t\tmissingMessage=\"请输入职务\" class='easyui-validatebox' required=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\ttype=\"text\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"zyly\">专业领域</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"zyly\" maxlength=\"50\" name=\"obj.zyly\"\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"easyui-combobox\" type=\"text\" required=\"true\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"yjfx\">研究方向</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"yjfx\" maxlength=\"100\" name=\"obj.yjfx\"\r\n");
      out.write("\t\t\t\t\t\t\tclass='easyui-validatebox' required=\"true\" type=\"text\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"csny\">出生年月</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"csny\" maxlength=\"50\" name=\"obj.csny\"\r\n");
      out.write("\t\t\t\t\t\t\tclass='easyui-datebox' type=\"text\" required=\"true\"/ >\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"ssdw\">所属单位</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"ssdw\" maxlength=\"200\" name=\"obj.ssdw\"\r\n");
      out.write("\t\t\t\t\t\t\tclass='easyui-validatebox' required=\"true\" type=\"text\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"dzyj\">电子邮件</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"dzyj\" maxlength=\"100\" name=\"obj.dzyj\"\r\n");
      out.write("\t\t\t\t\t\t\tvalidtype=\"email\" class='easyui-validatebox' type=\"text\"\r\n");
      out.write("\t\t\t\t\t\t\trequired=\"true\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"left\">\r\n");
      out.write("                        \t<span class=\"btn btn-success fileinput-button\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>上传照片</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input id=\"file\" type=\"file\" name=\"file\" onchange=\"imagePreview(this, 'img_prev');\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t</td> \r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"lxdh\">联系电话</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input id=\"lxdh\" maxlength=\"50\" name=\"obj.lxdh\"\r\n");
      out.write("\t\t\t\t\t\t\tclass='easyui-validatebox' required=\"true\" type=\"text\" />\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"zjjj\">专家简介</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"3\"><textarea id=\"zjjj\" style=\"width:99%;height:60px;\" name=\"obj.zjjj\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass='easyui-validatebox' required=\"true\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td><label for=\"bz\">备注</label>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"3\"><textarea id=\"bz\" style=\"width:99%;height:60px;\" name=\"obj.bz\" class='easyui-validatebox'\r\n");
      out.write("\t\t\t\t\t\t\t\t></textarea>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"5\" style=\"text-align: center; padding: 5px\"><a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"easyui-linkbutton\" href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"return submitAddExpert();\">保&nbsp;&nbsp;存</a> <a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"easyui-linkbutton\" href=\"javascript:void(0);\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"return clearForm();\">重&nbsp;&nbsp;置</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- <div style=\"padding: 10px 0 10px 1px; float: left: 20%\">\r\n");
      out.write("\t\t\t<table id=\"table\">\r\n");
      out.write("\t\t\t      <tr> <td><img id=\"imghead\" width=\"150\" height=\"150\" src=\"../../images/stuphoto.png\"/>\r\n");
      out.write("\t\t\t\t\t\t</td> </tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"fileinput-button\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\">上传照片</button>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"file\" name=\"file\" id=\"file\"\r\n");
      out.write("\t\t\t\t\t\t onchange=\"preview(this,'imghead');\" />\r\n");
      out.write("\t\t\t\t\t\t </span>\r\n");
      out.write("\t\t\t\t\t\t </td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</div> -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
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
