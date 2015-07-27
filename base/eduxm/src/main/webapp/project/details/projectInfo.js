var title = "项目基本信息";
var data = {
		xy : null,
		zy : null,
		xl : null
};
var arrMatch=[
    //combobox,combotree
	new Match("c_zt","状态",textfunction),
	new Match("c_xmmc","项目名称",textfunction),
	new Match("c_sqnd","申请年度",textfunction),
	new Match("c_cgxs","成果形式",textfunction),
	new Match("c_kssj","开始时间",textfunction),
	new Match("c_jssj","结束时间",textfunction)
	new Match("c_jhwcsj","计划完成时间", textfunction),
	new Match("c_xmlb", "项目类别", textfunction),
	new Match("c_yjlx", "研究类型", textfunction),
	new Match("c_xkmc", "学科名称", textfunction),
	new Match("c_xkdm", "学科代码", textfunction),
	new Match("c_tbsj", "填报时间", textfunction),
	new Match("c_ysze", "预算总额", textfunction),
	new Match("c_sqze", "申请总额", textfunction),
	new Match("c_sqmx", "申请明细", textfunction),	
	new Match("c_zcze", "自筹总额", textfunction),
	new Match("c_zcmx", "自筹明细", textfunction),
	new Match("c_sqcn", "申请承诺", textfunction),
	new Match("c_xswyhyj", "学术委员会意见", textfunction),
	new Match("c_fzrdwyj", "负责人单位意见", textfunction),
	new Match("c_sjzt1", "数据状态1", textfunction),
	new Match("c_psfs", "评审分数", textfunction),
	new Match("c_psjg", "评审结果", textfunction),
	new Match("c_jgsm", "结果说明", textfunction),
	new Match("c_sjzt2", "数据状态2", textfunction),
	new Match("c_tbr", "填报人", textfunction),
	new Match("c_bz1", "备注1", textfunction),
	new Match("c_bz2", "备注2", textfunction),
	new Match("c_bz3", "备注3", textfunction),
	new Match("c_bz4", "备注4", textfunction)
	]; 

function submitSerach(pageNumber) {
	loading("获取数据中。。。。。。");
	if(pageNumber == 1) {//重新点击了查询按钮，这时候从第一页开始显示，但是分页显示的可能不是第一页 ，所以需要重新设置下pagination显示的当前页数
		var pg = $("#projectInfoTable").datagrid("getPager");
		pg.pagination({pageNumber:1});
	} 
	psize = $("#p_size").val();
	if(psize==""||psize==null){
		psize=10;
	}
	var options = {
			url     :'../../project/Project_list.action?rows='+psize+'&page='+pageNumber,
			success	:	reloadGroupTable,
			error	:	errorTip,
			dataType:	'json'
	};
    $("#searchForm").ajaxSubmit(options);
}
function reloadGroupTable(responseXML, statusText, xhr, form) {
	$('#projectInfoTable').datagrid('loadData', responseXML); 
	setLinkbuttonStyle();
	unloading();
}
function reloadTableAfterUpdateOrAdd() {
	$('#projectInfoTable').datagrid('reload'); 
}
function errorTip(responseXML, statusText, xhr, form) {
	showResult(obtainTextInTag(responseXML,"<title>"),$(responseXML).find("#msg").text());
	setLinkbuttonStyle();
	unloading();
}

 function initTable() { 
	 $("#tableid").datagrid({
 		title:'负责人检索',
 		singleSelect:true,
 		fitColumns:true,
 		
 		columns:[[
			{field:'way',title:'连接方式',width:fixWidth(0.1)},
 		    {field:'target',title:'检索项',width:fixWidth(0.2)},
 		    {field:'method',title:'运算',width:fixWidth(0.1)},
 		    {field:'content',title:'内容',width:fixWidth(0.23)},
 		    {field:'sort',title:'排序',width:fixWidth(0.15)},
 		    {field:'dos',title:'操作',width:fixWidth(0.2)}
 		]]
 	});

	$('#projectInfoTable').datagrid({    
		title:'负责人信息',
 		fitColumns:true,
	    url:'../../project/Project_list.action?search.columns=-',
	    pageSize:10,
	    pageList:[10,20,50],
	    columns:[[  
	        {field:'ok',checkbox:true},   
	        {field:'c_zt',title:'状态',width:fixWidth(0.1)},    
	        {field:'c_xmmc',title:'项目名称',width:fixWidth(0.1)},  
	        {field:'c_sqnd',title:'申请年度',width:fixWidth(0.1)}, 
	        {field:'c_cgxs',title:'成果形式',width:fixWidth(0.1)}, 
	        {field:'c_kssj',title:'开始时间',width:fixWidth(0.1)},
	        {field:'c_jssj',title:'结束时间',width:fixWidth(0.1)},
	        {field:'c_jhwcsj',title:'计划完成时间',width:fixWidth(0.1)},
	        {field:'c_xmlb',title:'项目类别',width:fixWidth(0.1)},
	        {field:'c_yjlx',title:'研究类型',width:fixWidth(0.1)},
	        {field:'c_xkmc',title:'学科名称',width:fixWidth(0.1)},
	        {field:'c_xkdm',title:'学科代码',width:fixWidth(0.1)},
	        {field:'c_tbsj',title:'填报时间',width:fixWidth(0.1)},
	        {field:'c_ysze',title:'预算总额',width:fixWidth(0.1)},
	        {field:'c_sqze',title:'申请总额',width:fixWidth(0.1)},
	        {field:'c_sqmx',title:'申请明细',width:fixWidth(0.1)},
	        {field:'c_zcze',title:'自筹总额',width:fixWidth(0.1)},
	        {field:'c_zcmx',title:'自筹明细',width:fixWidth(0.1)},
	        {field:'c_sqcn',title:'申请承诺',width:fixWidth(0.1)},
	        {field:'c_xswyhyj',title:'学术委员会意见',width:fixWidth(0.1)},
	        {field:'c_fzrdwyj',title:'负责人单位意见',width:fixWidth(0.1)},
	        {field:'c_sjzt1',title:'数据状态1',width:fixWidth(0.1)},
	        {field:'c_psfs',title:'评审分数',width:fixWidth(0.1)},
	        {field:'c_psjg',title:'评审结果',width:fixWidth(0.1)},
	        {field:'c_jgsm',title:'结果说明',width:fixWidth(0.1)},
	        {field:'c_sjzt2',title:'数据状态2',width:fixWidth(0.1)},
	        {field:'c_tbr',title:'填报人',width:fixWidth(0.1)},
	        {field:'c_bz1',title:'备注1',width:fixWidth(0.1)},
	        {field:'c_bz2',title:'备注2',width:fixWidth(0.1)},
	        {field:'c_bz3',title:'备注3',width:fixWidth(0.1)},
	        {field:'c_bz4',title:'备注4',width:fixWidth(0.1)},
	        {field:'c_sfdrqtxm',title:'是否担任其他项目',width:fixWidth(0.1)},
	        {field:'dos',title:'操作',width:fixWidth(0.25),align:'left',formatter:function(value,rowData,index){
	        	var s = '<a href="#" name="editLink" onclick="editGroup('+"'"+rowData.id+"'"+');">编辑</a> ';
	        	var c = '<a href="#" name="delLink" onclick="delOneMet('+"'"+rowData.id+"'"+')">删除</a>';
	        	return s+c;
	        }}
	    ]],
	    toolbar:[
	        {text:'增加', iconCls:'icon-add', handler: showAddPage }

	    ],
	    pagination: true,
  		rownumbers: false,
  		onLoadSuccess:function (data) { //数据加载成功后需要设置linkbutton的样式，
  			setLinkbuttonStyle();
  		}
	});
 	var pg = $("#projectInfoTable").datagrid("getPager");
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
	$("#p_size").val($("#projectInfoTable").datagrid('options').pageSize);
}
 
	$(document).ready(function () {
	
		
	});

 //显示添加负责人窗口
 function showAddPage() {
	 var content = '<iframe id="groupIframe" frameborder="0"  src="projectInfo_add.jsp" style="width:100%;height:100%;"/>';
	 $("#dlg").dialog({
		 title	:"添加负责人信息",
		 height:$(window).height() * 0.8,
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
 /**
  * 只显示作者是自己的记录
  * @param author
  */
function showMyselfList(author){
	$("#searchCol").val("c_author");
	$("#searchOpera").val("eq");
	$("#searchVal").val(author);
	submitSerach(1);
}
 //用来显示添加，编辑负责人信息状态。关闭添加，编辑会议资料对话框
 function closeDlg(callbackData) {
	$("#dlg").dialog("close");
	$("#projectInfoTable").datagrid("reload");
	showResult(obtainTextInTag(callbackData,"<title>"),$(callbackData).find("#msg").text());
 }
 
 function delOneMet(GroupId) {
	 $.messager.confirm('确认','删除不可恢复，您确认想要删除记录吗？',function(r){
		 if(r) {
			 loading("传输数据中，请稍后。。。");
			 $.post("../../project/project_del.action",{ids:GroupId},function (callbackData) {
				 showResult(obtainTextInTag(callbackData,"<title>")  ,$(callbackData).find("#msg").text());
				 $("#projectInfoTable").datagrid("reload");
				 unloading();
			 }); 
		 }
	 });
 }
 
//删除选中负责人，一个或多个
 function delMet(author,isAdmin) {
	//获取所有选中行
	var rows = $("#projectInfoTable").datagrid("getSelections");
	if(rows.length == 0) {
		$.messager.alert("提示","请选择你要删除的项！");
		return ;
	}
	
	$.messager.confirm('确认','所有被选中的记录都将被彻底删除，并且不可恢复，您确认想要删除记录吗？',function(r){    
		if (r){  
			loading("传输数据中，请稍后。。。");
			var ids = [];
			var undelete = "负责人为："; //提示给用户不能删除的文件的信息
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
				 $.post("../../project/Project_del.action",$.param({ids:ids}, true),function (callbackData) {
					 showResult(obtainTextInTag(callbackData,"<title>"),$(callbackData).find("#msg").text());
					 $("#projectInfoTable").datagrid("reload");
				 }); 
			 }
			 unloading();
		}    
	}); 
 }
 //打开开编辑负责人信息窗口
 function editGroup(GroupId){
	 alert(GroupId);
	 var content = '<iframe scrolling="auto" name="editIfram" id="groupIframe" frameborder="0"  src="../../project/Project_load.action?ids='+GroupId+'" style="width:100%;height:100%;"/>';
	 $("#dlg").dialog({
		 title:"更新负责人信息",
		 height:$(window).height() * 0.9,
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
 
/*上传文件*/
function uploadGroup(dir,author) {
	var content = '<iframe id="groupIframe" frameborder="0"  src="../upload.jsp?type=meeting&author='+author+'&dir='+dir+'" style="width:100%;height:100%;"></iframe>';
	$("#dlg").dialog({
		title:'上传会议资料',
		height:450,
		width:650,
		modal:true,
		content:content,
		buttons:[
		    {text:'完  成',handler:function () {
		        $("#dlg").dialog("close"); 
		    }}
		]
	});
}	

