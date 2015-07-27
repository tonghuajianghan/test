var title = "专家审核";
var data = {
		xy : null,
		zy : null,
		xl : null
};
var arrMatch=[
    //combobox,combotree
	new Match("c_xmmc","项目名称",textfunction),
	/*new Match("c_person","项目负责人",textfunction),
	new Match("c_year","项目年度",textfunction),
	new Match("c_start_time","项目起始年度",datefunction),
	new Match("c_end_time","项目完成年度",datefunction),
	new Match("c_area","项目所在区域",textfunction),
	new Match("c_range","项目范围",textfunction),
	new Match("c_watershed","项目所在流域",textfunction),
	new Match("c_source","项目来源",textfunction),
	new Match("c_budget","预算科目",textfunction),
	new Match("c_property","项目属性",textfunction),
	new Match("c_department","项目参加单位",textfunction),
	new Match("c_key1","项目设计的水文资料关键词1",textfunction),
	new Match("c_key2","项目设计的水文资料关键词2",textfunction),
	new Match("c_key3","项目设计的水文资料关键词3",textfunction),
	new Match("c_key4","项目设计的水文资料关键词4",textfunction),
	new Match("c_author","作者",textfunction)*/
	//new Match("c_location","源地",selectfunction,"../../code/szd.json",combotree)
	]; 

function submitSerach(pageNumber) {
	loading("获取数据中。。。。。。");
	if(pageNumber == 1) {//重新点击了查询按钮，这时候从第一页开始显示，但是分页显示的可能不是第一页 ，所以需要重新设置下pagination显示的当前页数
		var pg = $("#ProjectInfoTable").datagrid("getPager");
		pg.pagination({pageNumber:1});
	} 
	psize = $("#p_size").val(); 
	var options = {
			url     :'check/CheckProj_list.action?rows='+psize+'&page='+pageNumber,
			success	:	reloadProjectTable,
			error	:	errorTip,
			dataType:	'json'
	};
    $("#serachForm").ajaxSubmit(options);
}
function reloadProjectTable(responseXML, statusText, xhr, form) {
	$('#ProjectInfoTable').datagrid('loadData', responseXML); 
	setLinkbuttonStyle();
	unloading();
}

function reloadTableAfterUpdateOrAdd() {
	$('#ProjectInfoTable').datagrid('reload'); 
}
function errorTip(responseXML, statusText, xhr, form) {
	showResult(obtainTextInTag(responseXML,"<title>"),$(responseXML).find("#msg").text());
	setLinkbuttonStyle();
	unloading();
}

function initPrincipalProj(id){ 
	$('#principalProjTable').datagrid({    
		title:'负责人正在担任的研究项目',
		fitColumns:true,
		url:'PrincipalProj_list.action?projectid='+id,
		method:"post",
		pageSize:10,
		pageList:[10,20,50],
		columns:[[  
		{field:'xmmc',title:'项目名称',width:fixWidth(0.3)},    
		{field:'xmlb',title:'项目类别',width:fixWidth(0.1)},    
		{field:'pzdw',title:'批准单位',width:fixWidth(0.1)},    
		{field:'zzje',title:'资助金额',width:fixWidth(0.05)},    
		{field:'kssj',title:'开始时间',width:fixWidth(0.1),formatter:function(data,value,index){
		    	if(data==null){
		    		return "";
		    	}
		    	return (data+"").substring(0,10);
		    }},          
		{field:'jssj',title:'结束时间',width:fixWidth(0.1),formatter:function(data,value,index){
	        	if(data==null){
	        		return "";
	        	}
	        	return (data+"").substring(0,10);
	        }},      
	    ]],
	    pagination: false,
		rownumbers: false,
		onLoadSuccess:function(data) { //数据加载成功后需要设置linkbutton的样式，
			setLinkbuttonStyle();
			
		}
	});
}
/**
 * 加载成员信息
 */
function initMember(id){ 
	$('#memberTable').datagrid({    
		title:'项目成员',
		fitColumns:true,
		url:'Member_list.action?projectid='+id,
		pageSize:10,
		pageList:[10,20,50],
		columns:[[  
		{field:'xm',title:'姓名',width:fixWidth(0.1)},    
		{field:'xb',title:'性别',width:fixWidth(0.1)},    
		{field:'zyzw',title:'专业职务',width:fixWidth(0.1)},    
		{field:'yjzc',title:'研究专长',width:fixWidth(0.1)},    
		{field:'xlxw',title:'学历学位',width:fixWidth(0.1)},    
		{field:'dw',title:'单位',width:fixWidth(0.1)},    
		{field:'csny',title:'出生年月',width:fixWidth(0.1),formatter:function(data,value,index){
		    	if(data==null){
		    		return "";
		    	}
		    	return (data+"").substring(0,10);
		    }}          
	    ]],
	    pagination: false,
		rownumbers: false,
		onLoadSuccess:function(data) { //数据加载成功后需要设置linkbutton的样式，
			setLinkbuttonStyle();
			
		}
	});
}
/**
 * 加载成员信息
 */
function initAchievementBefore(id){ 
	 getJSON(data, "zy","../../code/cgxs.json");
	
	$('#achievementBeforeTable').datagrid({    
		title:'项目成员',
		fitColumns:true,
		url:'AchievementBefore_list.action?projectid='+id,
		method:'post',
		pageSize:10,
		pageList:[10,20,50],
		columns:[[  
		          {field:'cgmc',title:'成果名称',width:fixWidth(0.4)},    
		          {field:'cgzz',title:'成果作者',width:fixWidth(0.1)},    
		          {field:'cgxs',title:'成果形式',width:fixWidth(0.1),formatter:function(value,rowData,index){
		        	  return getText(value,data.zy);
			       }},    
		          {field:'fbkw',title:'发表刊物',width:fixWidth(0.1)},    
		          {field:'fbsj',title:'发表时间',width:fixWidth(0.1),formatter:function(data,value,index){
		        	  if(data==null){
		        		  return "";
		        	  }
		        	  return (data+"").substring(0,10);
		          }},
		          {field:'bz1',title:'备注1',width:fixWidth(0.1)},
		          {field:'bz2',title:'备注2',width:fixWidth(0.1)},  
		          ]],
		          pagination: false,
		          rownumbers: false,
		          onLoadSuccess:function(data) { //数据加载成功后需要设置linkbutton的样式，
		        	  setLinkbuttonStyle();
		        	  
		          }
	});
}
 /**
  * 只显示作者是自己的记录
  * @param author
  */
function showMyselfList(author){
	$("#searchCol").val("c_author");//这些字段都是在project_list.jsp中的。自己查看
	$("#searchOpera").val("eq");
	$("#searchVal").val(author);
	submitSerach(1);
}
/**
 * 查看所有人的记录
 */
function showAllList(){
	$("#searchCol").val("");//这些字段都是在project_list.jsp中的。自己查看
	$("#searchOpera").val("");
	$("#searchVal").val("");
	$("#ProjectInfoTable").datagrid("reload");
}

	/*上传文件*/
function showUploadPage(dir,author) {
	var content = '<iframe id="metIframe" frameborder="0"  src="../upload.jsp?type=project&author='+author+'&dir='+dir+'" style="width:100%;height:100%;"/>';
	$("#dlg").dialog({
		title:'上传项目资料',
		height:400,
		width:550,
		modal:true,
		content:content,
		buttons:[
		    {text:'完  成',handler:function () {
		        $("#dlg").dialog("close"); 
		    }}
		]
	});
}

//显示项目信息窗口
function showAddPage(){
	 var content = '<iframe id="metIframe" frameborder="0"  src="Project_add.jsp" style="width:100%;height:100%;"/>';
		 $("#dlg").dialog({
			 title	:"添加项目信息",
			 height:$(window).height() * 0.85,
			 width:$(window).width() * 0.7,
			 modal:true,
			 content:content,
			 buttons:[
			          {text:'完  成',handler:function() {
			        	  $("#dlg").dialog("close");
			          }}
			          ]
		 });
	 }

 //用来显示添加，编辑项目信息状态。关闭添加，编辑项目对话框
function closeDlg(callbackData){
	$("#dlg").dialog("close");
	$("#ProjectInfoTable").datagrid("reload");
	showResult(obtainTextInTag(callbackData,"<title>"),$(callbackData).find("#msg").text());
 }

function active(isActive){
	 var rows = $("#ProjectInfoTable").datagrid("getSelections");
	 
	 if(rows.length == 0) {
		 $.messager.alert("提示","请至少选中一项！");
		 return ;
	 }
	 var info = isActive ? "确定激活吗" : "确定取消激活吗?";
	 $.messager.confirm('确认',info,function(r){
		 if(r) {
			 loading("正在传输数据。。。。");
			 var ids = [];
			 for(i = 0 ; i < rows.length ; i++ ) {
				 var row = rows[i];
				 ids.push(row.id);
			 }
			 $.post("admin/Student_active.action",$.param({ids:ids, flag:isActive}, true),function (callbackData) {
				 showResult(obtainTextInTag(callbackData,"<title>") ,$(callbackData).find("#msg").text());
				 unloading();
			 }); 
		 }
	 });
 }
 
 
function delOneProject(projectId){
	 $.messager.confirm('确认','删除不可恢复，您确认想要删除记录吗？',function(r){
		 if(r) {
			 loading("传输数据中，请稍后。。。");
			 $.post("Project_del.action",{ids:projectId},function (callbackData) {
				 showResult(obtainTextInTag(callbackData,"<title>")  ,$(callbackData).find("#msg").text());
				 $("#ProjectInfoTable").datagrid("reload");
				 unloading();
			 }); 
		 }
	 });
 }
  
 
//删除选中项目，一个或多个
function delProject(author,isAdmin){
	//获取所有选中行
	rows = $("#ProjectInfoTable").datagrid("getSelections");
	if(rows.length == 0) {
		$.messager.alert("提示","请选择你要删除的项！");
		return ;
	}
	
	$.messager.confirm('确认','所有被选中的记录都将被彻底删除，并且不可恢复，您确认想要删除记录吗？',function(r){    
		if (r){  
			loading("传输数据中，请稍后。。。");
			var ids = [];
			var undelete = "项目名称为："; //提示给用户不能删除的文件的信息
			var flag = false;
			 for(i = 0 ; i < rows.length ; i++ ) {
				 var row = rows[i];
				 if(row.author == author || isAdmin){
					 ids.push(row.id);
				 }else{
					 undelete +=" '"+row.name+"' ";
					 flag = true;
				 }
			 }
			 if(flag){
				 	undelete += " 的作者不是您本人，您将不能删除";
				 	alert(undelete);
				 }
			 if(ids.length>0){
				 //判断是否有要删除的id，没有就不执行下列代码
				 $.post("Project_del.action",$.param({ids:ids}, true),function (callbackData) {
					 showResult(obtainTextInTag(callbackData,"<title>"),$(callbackData).find("#msg").text());
					 $("#ProjectInfoTable").datagrid("reload");
				 }); 
			 }
			 unloading();
		}    
	}); 
 }

 //打开开编辑项目信息窗口
function editProject(projectId){
	 var content = '<iframe scrolling="auto" name="editIfram" id="projcetIframe" frameborder="0"  src="other/Project_load.action?ids='+projectId+'" style="width:100%;height:100%;"/>';
	 $("#dlg").dialog({
		 title:"更新项目信息",
		 height:$(window).height() * 0.9,
		 width:$(window).width() * 0.7,
		// href:'admin/Student_load.action?ids=' + stuId,
		 content:content,
		 modal: true,
		 buttons:[
		          {text:'完  成',handler:function() {
		        	  $("#dlg").dialog("close");
		          }}
		          ]
	 }); 
 }

