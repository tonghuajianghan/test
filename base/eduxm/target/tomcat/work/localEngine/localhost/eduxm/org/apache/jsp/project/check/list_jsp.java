package org.apache.jsp.project.check;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.release();
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
      out.write("\n");
 String cp = request.getContextPath(); 
	String type = request.getParameter("type").trim();

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
      out.write("\t\n");
      out.write("\t<title>专家审核</title>\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../easyui/themes/default/easyui.css\"/>\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../easyui/themes/icon.css\"/>\n");
      out.write("\t\t\n");
      out.write("\t<script type=\"text/javascript\" src=\"../../js/jquery-1.7.1.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"../../js/jquery.form.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"../../easyui/jquery.easyui.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"../../easyui/locale/easyui-lang-zh_CN.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"../../my97date/WdatePicker.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"../../js/comm.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"../../js/search.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"list.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("\twindow.onload=function(){\n");
      out.write("\t\t\t");
if(type.equals("edu")){
      out.write("\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_shiro_005fhasPermission_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t");
} 
      out.write("\t\n");
      out.write("\t\t\t");
if(type.equals("bdw")){ 
      out.write("\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_shiro_005fhasPermission_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t");
} 
      out.write("\t\t\t\t\t\n");
      out.write("\t\t}\n");
      out.write("\t\tfunction reloadTable(){\n");
      out.write("\t\t\t//关闭对话框\n");
      out.write("\t\t\t$(\"#dlg\").window(\"close\");\n");
      out.write("\t\t\t$(\"#ProjectInfoTable\").datagrid(\"reload\");\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<input type=\"hidden\" name=\"rows\" id=\"p_size\"/>\n");
      out.write("\t<form id=\"serachForm\" action=\"../../check/Project_list.action\" method=\"post\">\n");
      out.write("\t\t<table id=\"tableid\"></table>\n");
      out.write("\t\t\n");
      out.write("\t\t<div id=\"emailWin\" class=\"easyui-dialog\" closed=true>\n");
      out.write("\t\t\t<div style=\"width:100%;margin:20px 0;\">发 送给：<div id=\"stus\" style=\"width:85%\"></div></div>\n");
      out.write("\t\t\t<div style=\"width:100%;margin:20px 0;\" >主题：<input style=\"width:85%\" name=\"title\"  class=\"easyui-validatebox\" required=true/></div>\n");
      out.write("\t\t\t<div style=\"width:100%;margin:10px 0;\">内容：<textarea id=\"content\" name=\"content\" class=\"easyui-validatebox\" rows=\"10\" cols=\"70\" style=\"width:85%\" ></textarea></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</form>\n");
      out.write("\n");
      out.write("\t<div style=\"height:40px; width:100%;\">\n");
      out.write("\t\t<div style=\"width:100%;  top:68px; right:20px; font-size:12px; text-align:right; color:#020e30;\">\n");
      out.write("\t\t");
if(type.equals("edu")){
      out.write("\n");
      out.write("\t\t\t<a class='easyui-linkbutton' href=\"javascript:void(0);\" iconCls='icon-search' onclick=\"submitSerach(1,'CheckProj_eduList.action');\">开始检索</a>\n");
      out.write("\t\t");
} 
      out.write("\t\n");
      out.write("\t\t");
if(type.equals("bdw")){ 
      out.write('\n');
      out.write('	');
      out.write('	');
      if (_jspx_meth_shiro_005fhasPermission_005f2(_jspx_page_context))
        return;
      out.write('\n');
      out.write('	');
      out.write('	');
} 
      out.write("\t\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<table id=\"ProjectInfoTable\" style=\"position: fixed; top:100px;\"></table>\n");
      out.write("\t\n");
      out.write("\t<div id=\"dlg\"></div>\n");
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

  private boolean _jspx_meth_shiro_005fhasPermission_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_005fhasPermission_005f0 = (org.apache.shiro.web.tags.HasPermissionTag) _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_005fhasPermission_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasPermission_005f0.setParent(null);
    // /project/check/list.jsp(30,4) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f0.setName("edush");
    int _jspx_eval_shiro_005fhasPermission_005f0 = _jspx_th_shiro_005fhasPermission_005f0.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\tinitEduList();\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_005fhasPermission_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasPermission_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f0);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasPermission_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_005fhasPermission_005f1 = (org.apache.shiro.web.tags.HasPermissionTag) _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_005fhasPermission_005f1.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasPermission_005f1.setParent(null);
    // /project/check/list.jsp(35,4) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f1.setName("bdwsh");
    int _jspx_eval_shiro_005fhasPermission_005f1 = _jspx_th_shiro_005fhasPermission_005f1.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\tinitSchoolList();\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_005fhasPermission_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasPermission_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f1);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasPermission_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_005fhasPermission_005f2 = (org.apache.shiro.web.tags.HasPermissionTag) _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_005fhasPermission_005f2.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasPermission_005f2.setParent(null);
    // /project/check/list.jsp(66,2) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f2.setName("bdwsh");
    int _jspx_eval_shiro_005fhasPermission_005f2 = _jspx_th_shiro_005fhasPermission_005f2.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t<a class='easyui-linkbutton' href=\"javascript:void(0);\" iconCls='icon-search' onclick=\"submitSerach(1,'CheckProj_schoolList.action');\">开始检索</a>\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_shiro_005fhasPermission_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasPermission_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f2);
    return false;
  }
}
