var title = "专家组信息";
var data = {
		xy : null,
		zy : null,
		xl : null
};
var arrMatch=[
    //combobox,combotree
	new Match("C_ZJZMC","专家组名称 ","textfunction"),
	//new Match("C_ZYLY","专业领域",textfunction),
	new Match("C_ZYLY","专业领域","selectfunction","../../code/zy.json","combobox"),
	new Match("C_ND","年度","textfunction"),
	new Match("C_ZZ","组长","textfunction"),
	new Match("C_USERNAME","用户名","textfunction"),
	new Match("C_XM","姓名","textfunction")
	]; 

function submitSerach(pageNumber) {
	loading("获取数据中。。。。。。");
	if(pageNumber == 1) {//重新点击了查询按钮，这时候从第一页开始显示，但是分页显示的可能不是第一页 ，所以需要重新设置下pagination显示的当前页数
		var pg = $("#groupInfoTable").datagrid("getPager");
		pg.pagination({pageNumber:1});
	} 
	psize = $("#p_size").val();
	if(psize==""||psize==null){
		psize=10;
	}
	var options = {
			url     :'Group_list.action?rows='+psize+'&page='+pageNumber,
			success	:	reloadGroupTable,
			error	:	errorTip,
			dataType:	'json'
	};
    $("#searchForm").ajaxSubmit(options);
}
function reloadGroupTable(responseXML, statusText, xhr, form) {
	$('#groupInfoTable').datagrid('loadData', responseXML); 
	setLinkbuttonStyle();
	unloading();
}
function reloadTableAfterUpdateOrAdd() {
	$('#groupInfoTable').datagrid('reload'); 
}
function errorTip(responseXML, statusText, xhr, form) {
	showResult(obtainTextInTag(responseXML,"<title>"),$(responseXML).find("#msg").text());
	setLinkbuttonStyle();
	unloading();
}

 function initTable() { 
	 getJSON(data, "zy","../../code/zy.json");
	 loadSearchTable('tableid', arrMatch);
//	 $("#tableid").datagrid({
// 		title:'专家组检索',
// 		singleSelect:true,
// 		fitColumns:true,
// 		
// 		columns:[[
//			{field:'way',title:'连接方式',width:fixWidth(0.1)},
// 		    {field:'target',title:'检索项',width:fixWidth(0.2)},
// 		    {field:'method',title:'运算',width:fixWidth(0.1)},
// 		    {field:'content',title:'内容',width:fixWidth(0.23)},
// 		    {field:'sort',title:'排序',width:fixWidth(0.15)},
// 		    {field:'dos',title:'操作',width:fixWidth(0.2)}
// 		]]
// 	});
	//alert(window.location.href);
	//$.post('../../group/Group_list.action?search.columns=-');
	$('#groupInfoTable').datagrid({    
		title:'专家组信息',
 		fitColumns:true,
	    url:'Group_list.action?search.columns=-',
	    pageSize:10,
	    pageList:[10,20,50],
	    columns:[[  
	        {field:'ok',checkbox:true},   
	        {field:'groupName',title:'专家组名称',width:fixWidth(0.1)},    
	        {field:'groupField',title:'专业领域',width:fixWidth(0.1),formatter:function(value,rowData,index){
	        	return getText(value,data.zy);
	        }},  
	        {field:'year',title:'年度',width:fixWidth(0.05)}, 
	        {field:'headman',title:'组长',width:fixWidth(0.05),formatter:function(value,rowData,index){
	        	if(value==0){
	        		return "无";
	        	}
	        }}, 
	        {field:'manCount',title:'人数',width:fixWidth(0.05)}, 
	        {field:'projectCount',title:'项目数',width:fixWidth(0.05)}, 
	        {field:'groupExplain',title:'专家组说明',width:fixWidth(0.2)},
	        {field:'remark',title:'备注',width:fixWidth(0.1)},
	        {field:'dos',title:'操作',width:fixWidth(0.25),align:'left',formatter:function(value,rowData,index){
	        	var s = '<a href="#" name="editLink" onclick="editGroup('+"'"+rowData.id+"'"+');">编辑</a>';
	        	var c = '<a href="#" name="delLink" onclick="delOneGroup('+"'"+rowData.id+"'"+')">删除</a>';
	        	var a = '<a href="#" name="editLink" onclick="assignCrew('+"'"+rowData.id+"'"+','+"'"+rowData.groupField+"'"+')">分配专家</a>';
	        	var b = '<a href="#" name="editLink" onclick="assignProject('+"'"+rowData.id+"'"+','+"'"+rowData.groupField+"'"+')">分配项目</a>';
	        	return s+c+a+b;
	        }}
	    ]],
	    toolbar:[
	        {text:'增加', iconCls:'icon-add', handler: showAddPage },
	        {text:'批量删除', iconCls:'icon-cancel', handler: delGroup}
	    ],
	    pagination: true,
  		rownumbers: false,
  		onLoadSuccess:function (data) { //数据加载成功后需要设置linkbutton的样式，
  			setLinkbuttonStyle();
  		}
	});
 	var pg = $("#groupInfoTable").datagrid("getPager");
	if(pg) {    
	    $(pg).pagination({
	        onRefresh:function(pageNumber,pageSize){ 
	        	submitSerach(pageNumber); 
	        	setLinkbuttonStyle();
	        },    
	        onChangePageSize:function(pageSize){  
	        	$("#p_size").val(pageSize);
	        	submitSerach(1);//更改分页单位后，设置为显示第一页
	        	setLinkbuttonStyle();
	        },    
	        onSelectPage:function(pageNumber,pageSize){ 
	       		submitSerach(pageNumber);
	       		setLinkbuttonStyle();
	       	}    
	    });    
	 } 
	$("#p_size").val($("#groupInfoTable").datagrid('options').pageSize);
}
 
	$(document).ready(function () {
		//alert($("#groupInfoTable").datagrid('options').pageSize);
		
	});

 //显示添加学生窗口
 function showAddPage() {
	 var content = '<iframe id="groupIframe" frameborder="0"  src="add.jsp" style="width:100%;height:100%;"/>';
	 $("#dlg").dialog({
		 title	:"添加专家组信息",
		 height:$(window).height() * 1.03,
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
 //用来显示添加，编辑专家组信息状态。关闭添加，编辑会议资料对话框
 function closeDlg(callbackData) {
	$("#dlg").dialog("close");
	$("#groupInfoTable").datagrid("reload");
	showResult(obtainTextInTag(callbackData,"<title>"),$(callbackData).find("#msg").text());
 }
 
 function delOneGroup(GroupId) {
//	 alert(GroupId);
	 $.messager.confirm('确认','删除不可恢复，您确认想要删除记录吗？',function(r){
		 if(r) {
			 loading("传输数据中，请稍后。。。");
			 $.post("Group_del.action",{ids:GroupId},function (callbackData) {
//				 showResult(obtainTextInTag(callbackData,"<title>")  ,$(callbackData).find("#msg").text());
				 if(callbackData.indexOf("删除成功")>-1){
					 $.messager.alert("提示信息","删除成功","info");
					 $("#groupInfoTable").datagrid("reload");
					 unloading();
				 }else{
					 $.messager.alert("提示信息","此组不能删除,组中有子记录！");
					 unloading();
				 }
			 }); 
		 }
	 });
 }
 
//删除选中学生，一个或多个
 function delGroup() {
	//获取所有选中行
	var rows = $("#groupInfoTable").datagrid("getSelections");
	if(rows.length == 0) {
		$.messager.alert("提示","请选择你要删除的项！");
		return ;
	}
	
	$.messager.confirm('确认','所有被选中的记录都将被彻底删除，并且不可恢复，您确认想要删除记录吗？',function(r){    
		if (r){  
			loading("传输数据中，请稍后。。。");
			var ids = [];
			//var undelete = "专家分组名称为："; //提示给用户不能删除的文件的信息
			var flag = false;
			 for(i = 0 ; i < rows.length ; i++ ) {
				 var row = rows[i];
				 //if(row.author == author || isAdmin){
				ids.push(row.id);
				 /*}else{
					 undelete +=" '"+row.name+"' ";
					 flag = true;
				 }*/
			 }
			 /*if(flag){
				 	undelete += " 的作者不是您本人，您将不能删除";
				 	alert(undelete);
				 }*/
			 if(ids.length>0){
				 //判断是否有要删除的id，没有就不执行下列代码
				 $.post("Group_del.action",$.param({ids:ids}, true),function (callbackData) {
					 if(callbackData.indexOf("删除成功")>-1){
						 $.messager.alert("提示信息","删除成功","info");
						 $("#groupInfoTable").datagrid("reload");
						 unloading();
					 }else{
						 $.messager.alert("提示信息","删除失败,某些组中有子记录不能被删除！");
						 unloading();
					 }
				 }); 
			 }
			 unloading();
		}    
	}); 
 }
 //打开开编辑专家组信息窗口
 function editGroup(GroupId){
	 //alert(GroupId);
	 var content = '<iframe scrolling="auto" name="editIfram" id="groupIframe" frameborder="0"  src="Group_load.action?ids='+GroupId+'" style="width:100%;height:100%;"/>';
	 $("#dlg").dialog({
		 title:"更新专家组信息",
		 height:$(window).height() * 1.03,
		 width:$(window).width() * 0.7,
		 content:content,
		 modal: true,
		 buttons:[
	          {text:'完  成',handler:function() {
	        	  $("#dlg").dialog("close");
	          }}
	          ]
	 }); 
 }
 //分配组员
 function assignCrew(GroupId,GroupField){
	//alert(GroupId);
//	 alert("GroupId"+GroupId);
	 //alert("GroupField"+GroupField);
//	 alert('../../pingshen/group/assignCrew.jsp?GroupId='+GroupId+'&GroupField='+GroupField);
	 var content = '<iframe scrolling="auto" name="assignCrewIfram" id="groupIframe" frameborder="0"  src="assignCrew.jsp?GroupId='+GroupId+'&GroupField='+GroupField+'" style="width:100%;height:100%;"/>';
	 $("#dlg").dialog({
		 title:"分配组员",
		 height:$(window).height(),
		 width:$(window).width(),
		 content:content,
		 draggable:false,
		 modal: true,
		 buttons:[
		   {text:'完  成',handler:function() {
		      $("#dlg").dialog("close");
		   }}
		 ],
 		 onClose: function() { 
 			 $('#groupInfoTable').datagrid('reload');
 		 }
	 }); 
 }
 //分配项目
 function assignProject(GroupId,GroupField){
	 //alert(GroupId);
//	 alert("GroupId"+GroupId);
	 //alert("GroupField"+GroupField);
//	 alert('../../pingshen/group/assignCrew.jsp?GroupId='+GroupId+'&GroupField='+GroupField);
	 var content = '<iframe scrolling="auto" name="assignCrewIfram" id="groupIframe" frameborder="0"  src="assignProject.jsp?GroupId='+GroupId+'&GroupField='+GroupField+'" style="width:100%;height:100%;"/>';
	 $("#dlg").dialog({
		 title:"分配项目",
		 height:$(window).height(),
		 width:$(window).width(),
		 content:content,
		 draggable:false,
		 modal: true,
		 buttons:[
		          {text:'完  成',handler:function() {
		        	  $("#dlg").dialog("close");
		          }}
		          ],
		  		 onClose: function() { 
		 			 $('#groupInfoTable').datagrid('reload');
		 		 }
	 }); 
 }
 

