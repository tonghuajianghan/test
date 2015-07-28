package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fuser;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fprincipal_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fshiro_005fuser = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fshiro_005fprincipal_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fshiro_005fuser.release();
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.release();
    _005fjspx_005ftagPool_005fshiro_005fprincipal_005fnobody.release();
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

	String cp = request.getContextPath();

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>科研项目管理平台</title>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"easyui/themes/default/easyui.css\"/>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"easyui/themes/icon.css\"/>\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-1.7.1.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"easyui/jquery.easyui.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"easyui/locale/easyui-lang-zh_CN.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/index.js\"></script> \n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tvar urls = {\n");
      out.write("\t\t\"项目申报\":\"");
      out.print(cp);
      out.write("/other/project/Project_list.jsp\",\n");
      out.write("\t\t\"本单位审核\":\"");
      out.print(cp);
      out.write("/project/check/list.jsp?type=bdw\",\n");
      out.write("\t\t\"教育厅审核\":\"");
      out.print(cp);
      out.write("/project/check/list.jsp?type=edu\",\n");
      out.write("\t\t\"评审分组\":\"pingshen/group/list.jsp\",\n");
      out.write("\t\t\"评审打分\":\"pingshen/score/list.jsp\",\n");
      out.write("\t\t\"评审决策\":\"pingshen/decision/list.jsp\",\n");
      out.write("\t\t\"专家推荐\":\"expert/list/list.jsp\",\n");
      out.write("\t\t\"专家审核\":\"");
      out.print(cp);
      out.write("/expert/check/list.jsp\",\n");
      out.write("\t\t\"用户管理\":\"");
      out.print(cp);
      out.write("/user/list.jsp\",\n");
      out.write("\t\t\"代码管理\":\"code/admin/codelibs.jsp\"\n");
      out.write("\t\t//\"项目打分\"：\"pingshen/score/project.jsp\"\n");
      out.write("\t};\n");
      out.write("\n");
      out.write("\tString.prototype.trim = function() {\n");
      out.write("\t\treturn this.replace(/(^\\s*)|(\\s*$)/g, \"\");\n");
      out.write("\t}\n");
      out.write("\t$(function() {\n");
      out.write("\t\t$(\".easyui-tree\").tree({\n");
      out.write("\t\t\tonClick : function(node) {\n");
      out.write("\t\t\t\tif (urls[node.text.trim()]) {\n");
      out.write("\t\t\t\t\taddTab(node.text, urls[node.text.trim()]);\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\t//打开修改密码窗口\n");
      out.write("\tfunction editUser(user) {\n");
      out.write("\t\tvar content = '<iframe scrolling=\"auto\" name=\"editIfram\" id=\"userIframe\" frameborder=\"0\"  src=\"other/User_load.action?users='\n");
      out.write("\t\t\t\t+ user + '\" style=\"width:100%;height:100%;\"/>'\n");
      out.write("\t\t$(\"#dlg\").dialog({\n");
      out.write("\t\t\ttitle : \"更新用户信息\",\n");
      out.write("\t\t\theight : $(window).height() * 0.5,\n");
      out.write("\t\t\twidth : $(window).width() * 0.35,\n");
      out.write("\t\t\tcontent : content,\n");
      out.write("\t\t\tmodal : true,\n");
      out.write("\t\t\tbuttons : [ {\n");
      out.write("\t\t\t\ttext : '返  回',\n");
      out.write("\t\t\t\thandler : function() {\n");
      out.write("\t\t\t\t\t$(\"#dlg\").dialog(\"close\");\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t} ]\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfunction logoff(){\n");
      out.write("\t\t\n");
      out.write("\t\twindow.location.href=\"logout\";\n");
      out.write("\t\t\n");
      out.write("\t}\n");
      out.write("\t$(function(){\n");
      out.write("\t\t$(\".easyui-tree\").tree({\n");
      out.write("\t\t\tonClick: function(node){\n");
      out.write("\t\t\t\tif(urls[node.text]){\n");
      out.write("\t\t\t\t\taddTab(node.text,urls[node.text]);\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body class=\"easyui-layout\" style=\"overflow: auto\">\n");
      out.write("\n");
      out.write("\t<div data-options=\"region:'north',split:false\" style=\"height: 92px;\">\n");
      out.write("\t\t<div\n");
      out.write("\t\t\tstyle=\"background:url(");
      out.print(cp);
      out.write("/images/banner.jpg) left top; height:90px; width:100%;\">\n");
      out.write("\t\t\t<div\n");
      out.write("\t\t\t\tstyle=\"width: 100%; position: absolute; top: 68px; right: 20px; font-size: 12px; text-align: right; color: #020e30;\">\n");
      out.write("\t\t\t\t今天是");
      out.print(new SimpleDateFormat("yyyy年MM月dd日 E").format(new Date()));
      out.write("\n");
      out.write("\t\t\t\t");
      //  shiro:user
      org.apache.shiro.web.tags.UserTag _jspx_th_shiro_005fuser_005f0 = (org.apache.shiro.web.tags.UserTag) _005fjspx_005ftagPool_005fshiro_005fuser.get(org.apache.shiro.web.tags.UserTag.class);
      _jspx_th_shiro_005fuser_005f0.setPageContext(_jspx_page_context);
      _jspx_th_shiro_005fuser_005f0.setParent(null);
      int _jspx_eval_shiro_005fuser_005f0 = _jspx_th_shiro_005fuser_005f0.doStartTag();
      if (_jspx_eval_shiro_005fuser_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<a href=\"#\" onclick=\"editUser('");
          out.print(request.getRemoteUser());
          out.write("');\"\n");
          out.write("\t\t\t\t\t\tclass=\"easyui-linkbutton\" data-options=\"plain:true\">修改密码</a> <a\n");
          out.write("\t\t\t\t\t\thref=\"#\" onclick=\"logoff();\" class=\"easyui-linkbutton\"\n");
          out.write("\t\t\t\t\t\tdata-options=\"plain:true\">退出系统</a>\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_shiro_005fuser_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_shiro_005fuser_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fshiro_005fuser.reuse(_jspx_th_shiro_005fuser_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fshiro_005fuser.reuse(_jspx_th_shiro_005fuser_005f0);
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<div data-options=\"region:'west',title:'导航',split:true\"\n");
      out.write("\t\tstyle=\"width: 220px;\">\n");
      out.write("\t\t<div class=\"easyui-accordion\" fit=\"true\" border=\"false\">\n");
      out.write("\t\t\t<ul id=\"tree\" class=\"easyui-tree\">\t\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_shiro_005fhasPermission_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_shiro_005fhasPermission_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_shiro_005fhasPermission_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_shiro_005fhasPermission_005f3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_shiro_005fhasPermission_005f4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_shiro_005fhasPermission_005f5(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_shiro_005fhasPermission_005f6(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_shiro_005fhasPermission_005f7(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_shiro_005fhasPermission_005f8(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_shiro_005fhasPermission_005f9(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div data-options=\"region:'center',split:false,overflow:true\">\n");
      out.write("\t\t<div id=\"main-center\" class=\"easyui-tabs\" fit=\"true\" border=\"false\">\n");
      out.write("\t\t\t<div title=\"欢迎\" style=\"padding: 20px;\" closable=\"false\">\n");
      out.write("\t\t\t\t<h3>欢迎使用科研项目管理平台！");
      if (_jspx_meth_shiro_005fuser_005f1(_jspx_page_context))
        return;
      out.write("</h3>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div id=\"dlg\"></div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
    // /index.jsp(107,4) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f0.setName("xmsb");
    int _jspx_eval_shiro_005fhasPermission_005f0 = _jspx_th_shiro_005fhasPermission_005f0.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<li>项目申报</li>\n");
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
    // /index.jsp(110,4) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f1.setName("bdwsh");
    int _jspx_eval_shiro_005fhasPermission_005f1 = _jspx_th_shiro_005fhasPermission_005f1.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<li>本单位审核</li>\n");
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
    // /index.jsp(113,4) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f2.setName("edush");
    int _jspx_eval_shiro_005fhasPermission_005f2 = _jspx_th_shiro_005fhasPermission_005f2.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<li>教育厅审核</li>\n");
        out.write("\t\t\t\t");
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

  private boolean _jspx_meth_shiro_005fhasPermission_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_005fhasPermission_005f3 = (org.apache.shiro.web.tags.HasPermissionTag) _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_005fhasPermission_005f3.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasPermission_005f3.setParent(null);
    // /index.jsp(116,4) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f3.setName("psfz");
    int _jspx_eval_shiro_005fhasPermission_005f3 = _jspx_th_shiro_005fhasPermission_005f3.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<li>评审分组</li>\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_005fhasPermission_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasPermission_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f3);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasPermission_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_005fhasPermission_005f4 = (org.apache.shiro.web.tags.HasPermissionTag) _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_005fhasPermission_005f4.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasPermission_005f4.setParent(null);
    // /index.jsp(119,4) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f4.setName("psdf");
    int _jspx_eval_shiro_005fhasPermission_005f4 = _jspx_th_shiro_005fhasPermission_005f4.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<li>评审打分</li>\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_005fhasPermission_005f4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasPermission_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f4);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasPermission_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_005fhasPermission_005f5 = (org.apache.shiro.web.tags.HasPermissionTag) _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_005fhasPermission_005f5.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasPermission_005f5.setParent(null);
    // /index.jsp(122,4) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f5.setName("psjc");
    int _jspx_eval_shiro_005fhasPermission_005f5 = _jspx_th_shiro_005fhasPermission_005f5.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<li>评审决策</li>\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_005fhasPermission_005f5.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasPermission_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f5);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasPermission_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_005fhasPermission_005f6 = (org.apache.shiro.web.tags.HasPermissionTag) _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_005fhasPermission_005f6.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasPermission_005f6.setParent(null);
    // /index.jsp(125,4) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f6.setName("zjtj");
    int _jspx_eval_shiro_005fhasPermission_005f6 = _jspx_th_shiro_005fhasPermission_005f6.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<li>专家推荐</li>\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_005fhasPermission_005f6.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasPermission_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f6);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasPermission_005f7(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_005fhasPermission_005f7 = (org.apache.shiro.web.tags.HasPermissionTag) _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_005fhasPermission_005f7.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasPermission_005f7.setParent(null);
    // /index.jsp(128,4) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f7.setName("zjsh");
    int _jspx_eval_shiro_005fhasPermission_005f7 = _jspx_th_shiro_005fhasPermission_005f7.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<li>专家审核</li>\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_005fhasPermission_005f7.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasPermission_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f7);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasPermission_005f8(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_005fhasPermission_005f8 = (org.apache.shiro.web.tags.HasPermissionTag) _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_005fhasPermission_005f8.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasPermission_005f8.setParent(null);
    // /index.jsp(131,4) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f8.setName("yhgl");
    int _jspx_eval_shiro_005fhasPermission_005f8 = _jspx_th_shiro_005fhasPermission_005f8.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<li>用户管理</li>\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_005fhasPermission_005f8.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasPermission_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f8);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasPermission_005f9(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasPermission
    org.apache.shiro.web.tags.HasPermissionTag _jspx_th_shiro_005fhasPermission_005f9 = (org.apache.shiro.web.tags.HasPermissionTag) _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.get(org.apache.shiro.web.tags.HasPermissionTag.class);
    _jspx_th_shiro_005fhasPermission_005f9.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasPermission_005f9.setParent(null);
    // /index.jsp(134,4) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasPermission_005f9.setName("dmgl");
    int _jspx_eval_shiro_005fhasPermission_005f9 = _jspx_th_shiro_005fhasPermission_005f9.doStartTag();
    if (_jspx_eval_shiro_005fhasPermission_005f9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<li>代码管理</li>\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_shiro_005fhasPermission_005f9.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasPermission_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasPermission_0026_005fname.reuse(_jspx_th_shiro_005fhasPermission_005f9);
    return false;
  }

  private boolean _jspx_meth_shiro_005fuser_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:user
    org.apache.shiro.web.tags.UserTag _jspx_th_shiro_005fuser_005f1 = (org.apache.shiro.web.tags.UserTag) _005fjspx_005ftagPool_005fshiro_005fuser.get(org.apache.shiro.web.tags.UserTag.class);
    _jspx_th_shiro_005fuser_005f1.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fuser_005f1.setParent(null);
    int _jspx_eval_shiro_005fuser_005f1 = _jspx_th_shiro_005fuser_005f1.doStartTag();
    if (_jspx_eval_shiro_005fuser_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("当前用户是：");
        if (_jspx_meth_shiro_005fprincipal_005f0(_jspx_th_shiro_005fuser_005f1, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_shiro_005fuser_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fuser_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fuser.reuse(_jspx_th_shiro_005fuser_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fuser.reuse(_jspx_th_shiro_005fuser_005f1);
    return false;
  }

  private boolean _jspx_meth_shiro_005fprincipal_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_shiro_005fuser_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:principal
    org.apache.shiro.web.tags.PrincipalTag _jspx_th_shiro_005fprincipal_005f0 = (org.apache.shiro.web.tags.PrincipalTag) _005fjspx_005ftagPool_005fshiro_005fprincipal_005fnobody.get(org.apache.shiro.web.tags.PrincipalTag.class);
    _jspx_th_shiro_005fprincipal_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fprincipal_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_shiro_005fuser_005f1);
    int _jspx_eval_shiro_005fprincipal_005f0 = _jspx_th_shiro_005fprincipal_005f0.doStartTag();
    if (_jspx_th_shiro_005fprincipal_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fprincipal_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fprincipal_005fnobody.reuse(_jspx_th_shiro_005fprincipal_005f0);
    return false;
  }
}
