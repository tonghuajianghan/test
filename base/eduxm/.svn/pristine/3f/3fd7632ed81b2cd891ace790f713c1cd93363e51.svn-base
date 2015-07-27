var title = "评审打分之项目信息";
var arrMatch=[
              //combobox,combotree
          	new Match("c_xmmc","项目名称",textfunction),
          	new Match("c_psfs","评审分数",textfunction),
          	]; 
function submitSerach(pageNumber) {
	alert("ldskfl");
	loading("获取数据中。。。。。。");
	if(pageNumber == 1) {//重新点击了查询按钮，这时候从第一页开始显示，但是分页显示的可能不是第一页 ，所以需要重新设置下pagination显示的当前页数
		var pg = $("#ProjectInfoTable").datagrid("getPager");
		pg.pagination({pageNumber:1});
	} 
	psize = $("#p_size").val(); 
	var options = {
			url     :'ProjectInfoAction_list.action?rows='+psize+'&page='+pageNumber,
			success	:	reloadProjectTable,
			error	:	errorTip,
			dataType:	'json'
	};
	alert("执行完成");
    $("#searchForm").ajaxSubmit(options);
    alert("skdjfk");
}
function reloadProjectTable(responseXML, statusText, xhr, form) {
	alert("reload");
	$('#ProjectInfoTable').datagrid('loadData', responseXML); 
	setLinkbuttonStyle();
	unloading();
}
function reload(){
	$("#dlg").window("close");
	$('#ProjectInfoTable').datagrid('reload'); 
}
function msgshow(title,value,info){
/*	$.messager.show({
        title:title,
        msg:value,
        showType:'show'
    });*/
	 $.messager.show({
		 title:title,
	     msg:value,
         showType:'fade',
         style:{
             right:'',
             bottom:''
         }
     });
}
function errorTip(responseXML, statusText, xhr, form) {
	showResult(obtainTextInTag(responseXML,"<title>"),$(responseXML).find("#msg").text());
	setLinkbuttonStyle();
	unloading();
}

//以下为Project.jsp页面的js
	function initList(groupId){ 
 		$("#tableid").datagrid({
 			title:'专家组检索',
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
 
		$('#ProjectInfoTable').datagrid({    
			title:'项目资料信息',
			fitColumns:true,
			url:'ProjectInfoAction_list.action?search.columns=-&groupId='+groupId,
			method:"post",
			pageSize:10,
			pageList:[10,20,50],
			columns:[[  
			{field:'xmmc',title:'项目名称',width:fixWidth(0.35)},    
			{field:'psfs',title:'评审分数',width:fixWidth(0.35)},    
		    {field:'dos',title:'操作',width:fixWidth(0.2),align:'left',formatter:function(value,rowData,index){
		    	var l = '<a href="#" name="editLink" onclick="scoreDetails('+"'"+rowData.xm_id+"'"+');">打分</a>';
		    	return l;
		    }}
		    ]],
		    pagination: true,
			rownumbers: false,
			onLoadSuccess:function(data) { //数据加载成功后需要设置linkbutton的样式，
				setLinkbuttonStyle();
				
			}
		});
		var pg = $("#ProjectInfoTable").datagrid("getPager");
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
		$("#p_size").val($("#ProjectInfoTable").datagrid('options').pageSize);//将每页大小记录下来，放在隐藏域中
	}
	//打开查看项目信息窗口
	function scoreDetails(projectId){
		 var content = '<iframe scrolling="auto" name="scoreIfram" id="scoreIframe" frameborder="0"  src="../score/score.jsp?projectId='+projectId+'" style="width:100%;height:100%;"/>';
		 $("#dlg").dialog({
			 title:"专家打分页面",
			 height:$(window).height() * 0.8,
			 width:$(window).width() * 0.7,
			 content:content,
			 modal: true
		 }); 
	 }
