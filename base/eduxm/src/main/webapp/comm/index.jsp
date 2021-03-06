<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.*, java.util.*" %>
<%@ page import="cn.edu.cust.custjob.enterprise.EnterpriseRegister" %>
<%@ page import="cn.edu.cust.custjob.vo.*" %>
<% String cp = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>长春理工大学-就业指导系统</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/jquery-easyui-1.3.4/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="<%=cp %>/jquery-easyui-1.3.4/themes/icon.css"/>
<script type="text/javascript" src="<%=cp %>/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="<%=cp %>/jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=cp %>/jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=cp %>/js/comm_index.js"></script>
<script type="text/javascript">
var urls = {
		
		"学生管理":"<%=cp %>/student/admin/Student_list.jsp",
		"学院用户管理":"<%=cp %>/teacher/admin/Teacher_list.jsp",
		"就业计划用企业管理":"<%=cp %>/enterprise/admin/enterprise_list.jsp",
		"地图显示用企业管理":"<%=cp %>/enterprise/admin/EnterpriseMapAdmin_list.jsp",
		"自注册企业管理":"<%=cp %>/enterprise/admin/EnterpriseSRAdmin_list.jsp",
		"招聘信息管理":"<%=cp %>/enterprise/admin/JobAdmin_list.jsp",
		
		"上传营业执照":"<%=cp %>/enterprise/self/blupload.jsp",
		"查看营业执照":"<%=cp%>/enterprise/self/check_bl.jsp",
		"上传组织机构代码证":"<%=cp%>/enterprise/self/olupload.jsp",
		"查看组织机构代码证":"<%=cp%>/enterprise/self/check_ol.jsp",
		
		"发布招聘信息":"<%=cp %>/enterprise/self/EnterpriseSRJob_list.jsp",

		"代码管理":"<%=cp %>/code/admin/codelibs.jsp",
		"就业计划管理":"<%=cp%>/employmentplan/EmploymentPlan_list.jsp",

		"修改企业信息":"<%=cp %>/enterprise/self/loadEntSR.action",
		"查询学生信息":"<%=cp %>/enterprise/self/searchstudents.jsp",
		"代码管理":"<%=cp %>/code/admin/codelibs.jsp",
		

		/*教师就业计划  */
		
		"就业计划":"<%=cp%>/teacher/self/EmploymentPlan_list.jsp",
		
		
		/* 学生部分 */
		"个人基本信息修改":"<%=cp %>/student/self/Student_show.action",
		"上传照片":"<%=cp %>/student/self/stuphoto_upload.jsp",
		

		"就业计划企业管理":"<%=cp %>/teacher/self/enterprise_list.jsp",
		/* "就业计划管理":"", */
		
		<%-- "求职意向":"<%=cp %>/student/self/CareerObjective_list.jsp",
		"计算机能力":"<%=cp  %>/student/self/ComputerSkills_list.jsp",
		"语言能力":"<%=cp %>/student/self/LanguageSkills_list.jsp",
		"培训经历":"<%=cp %>/student/self/Training_list.jsp",
		"获奖情况":"<%=cp %>/student/self/Awards_list.jsp",
		"求职信":"<%=cp %>/student/self/Letter_list.jsp",
		"实践经验":"<%=cp %>/student/self/WorkExperience_list.jsp" , --%>

		"求职意向":"<%=cp %>/student/self/resume/CareerObjective_list.jsp",
		"计算机能力":"<%=cp  %>/student/self/resume/ComputerSkills_list.jsp",
		"语言能力":"<%=cp %>/student/self/resume/LanguageSkills_list.jsp",
		"培训经历":"<%=cp %>/student/self/resume/Training_list.jsp",
		"获奖情况":"<%=cp %>/student/self/resume/Awards_list.jsp",
		"求职信":"<%=cp %>/student/self/resume/Letter_list.jsp",
		"实践经验":"<%=cp %>/student/self/resume/WorkExperience_list.jsp" ,
		
		"企业信息查询":"<%=cp %>/student/self/enterprise_list.jsp"

};

$(function(){
	$(".easyui-tree").tree({
		onClick: function(node){
			if(urls[node.text]){
				addTab(node.text,urls[node.text]);
			}
		}
	});
});
</script>
</head>
<body class="easyui-layout" style="overflow:auto">

<div data-options="region:'north',split:false" style="height:92px;" >
	<div style="background:url(<%=cp %>/images/topsection_bg.png) left top; height:90px; width:100%;">
		<div style="width:100%; position:absolute; top:68px; right:20px; font-size:12px; text-align:right; color:#020e30;">
		今天是<%=new SimpleDateFormat("yyyy年MM月dd日 E").format(new Date()) %>
		<a href="#" class="easyui-linkbutton" data-options="plain:true">修改密码</a>
		<a href="<%=cp %>/logoff.jsp" class="easyui-linkbutton" data-options="plain:true">退出系统</a>
		</div>
	</div>
</div>

<div data-options="region:'west',title:'导航',split:true" style="width:220px;">
	<div class="easyui-accordion" fit="true" border="false"> 
	<%if(request.isUserInRole("s")){ %>
		<ul id="tree" class="easyui-tree">
			<li>
				<span>个人信息修改</span>
				<ul>
					<li>个人基本信息修改</li>
					<li>上传照片</li>
				</ul>
			</li>
				<li>
				<span>信息查询</span>
				<ul>
					<li>招聘会查询</li>
					<li>企业信息查询</li>
		    		<li>招聘职位查询</li>
					<li>签约信息查询</li>
		    		<li>文章查询</li>
				</ul>
			</li>
				<li>
				<span>简历维护</span>
				<ul>
					<li>求职意向</li>
					<li>计算机能力</li>
		    		<li>语言能力</li>
					<li>培训经历</li>
					<li>实践经验</li>
		    		<li>获奖情况</li>
		    		<li>求职信</li>
				</ul>
			</li>
		</ul>
<!-- 		<div title="个人信息修改" selected="true" style="overflow:auto;"> 
			<ul class="easyui-tree">
				<li>个人基本信息修改</li>
				<li>上传照片</li>
	    	</ul>
    	</div>
    	<div title="信息查询" selected="false" style="overflow:auto;"> 
			<ul class="easyui-tree">
				<li>招聘会查询</li>
				<li>企业信息查询</li>
	    		<li>招聘职位查询</li>
				<li>签约信息查询</li>
	    		<li>文章查询</li>
	    	</ul>
	    </div>
	    	
		<div title="简历维护" selected="false" style="overflow:auto;"> 
			<ul class="easyui-tree">
				<li>求职意向</li>
					<li>计算机能力</li>
		    		<li>语言能力</li>
					<li>培训经历</li>
					<li>实践经验</li>
		    		<li>获奖情况</li>
		    		<li>求职信</li>
	    	</ul>
	    </div> -->
	<%} %>
	<%if(request.isUserInRole("a")){ %>
		<ul id="tree" class="easyui-tree">
			<li>学生管理</li>
			<li>学院用户管理</li>
			<li>
				<span>企业管理</span>
				<ul>
					<li>就业计划用企业管理</li>
					<li>地图显示用企业管理</li>
					<li>
						<span>自注册企业管理</span>
						<ul>
						<!-- 	<li>企业信息管理 </li> -->
							<li>招聘信息管理</li>
						</ul>
					</li>
				</ul>
			</li>
			<li>就业计划管理</li>
			<li>信息发布</li>
			<li>代码管理</li>
		</ul>
	<%} %>
	<%if(request.isUserInRole("e")){ 
		//判断是否激活
		EnterpriseRegister reg = new EnterpriseRegister();
		reg.obtainRegInfo();
		EnterpriseSR sr = reg.getObj();
		
		if(sr.isActive()) { //企业已经激活，则不用关心营业执照是否上传
			%>
			<ul class="easyui-tree">
				<li>查看营业执照</li>
				<li>查看组织机构代码证</li>
				<li>修改企业信息</li>
				<li>发布招聘信息</li>
				<li>查询学生信息</li>
			</ul>
			<%
		}else if(sr.getBlContentType() == null || sr.getBlContentType().trim().equals("") || sr.getOlContentType() == null || sr.getBlContentType().trim().equals("")) {
			//没有上传执照，没有上传组织机构代码证
			//在首页那个tab里面显示上传营业执照的页面
			%>
				<ul class="easyui-tree">
					<li>上传营业执照</li>
					<li>上传组织机构代码证</li>
				</ul>
			<%
		}else { //企业已经上传过营业执照，但是还没有通过管理员的审核，这时候显示企业上传的营业执照
			%>
			<ul class="easyui-tree">
				<li>查看营业执照</li>
				<li>查看组织机构代码证</li>
			</ul> 
			<%
		}
	%>

	<%} %>
	<%if(request.isUserInRole("t")){ %>
		<ul class="easyui-tree">
			<li>就业计划企业管理</li>
		<!-- 	<li>就业计划管理</li> -->
			<li>就业计划</li>
		</ul>
	<%} %>
	</div>
</div>

<div data-options="region:'center',split:false,overflow:true">
	<div id="main-center" class="easyui-tabs" fit="true" border="false">
		<div title="欢迎" style="padding:20px;" closable="false">  
			<h3>欢迎使用就业指导系统！当前用户是：<%=request.getRemoteUser() %></h3>
			<!-- <img src="../images/bg1.jpg"  alt="欢迎使用就业指导系统" /> -->
		</div>  
	</div>      
</div>

</body>
</html>