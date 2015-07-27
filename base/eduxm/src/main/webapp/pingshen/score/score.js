var title = "专家分组信息";
var data = {
		xy : null,
		zy : null,
		xl : null
};

var arrMatch=[
          	new Match("C_XM_ID","项目id ",textfunction),
          	new Match("C_USERNAME","专家id",textfunction),
          	new Match("C_FS1","分数1",textfunction),
          	new Match("C_FS2","分数2",textfunction),
          	new Match("C_FS3","分数3",textfunction),
          	new Match("C_FS4","分数4",textfunction)
          	]; 

function submitSerach(pageNumber) {
	loading("获取数据中。。。。。。");
	if(pageNumber == 1) {//重新点击了查询按钮，这时候从第一页开始显示，但是分页显示的可能不是第一页 ，所以需要重新设置下pagination显示的当前页数
		var pg = $("#scoreInfoTable").datagrid("getPager");
		pg.pagination({pageNumber:1});
	} 
	psize = $("#p_size").val();
	if(psize==""||psize==null){
		psize=10;
	}
	var options = {
			url     :'../../group/Score_list.action?rows='+psize+'&page='+pageNumber,
			success	:	reloadGroupTable,
			error	:	errorTip,
			dataType:	'json'
	};
    $("#searchForm").ajaxSubmit(options);
}
function reloadGroupTable(responseXML, statusText, xhr, form) {
	$('#scoreInfoTable').datagrid('loadData', responseXML); 
	setLinkbuttonStyle();
	unloading();
}
function reload(){
	$('#ProjectInfoTable').datagrid('reload'); 
}
function errorTip(responseXML, statusText, xhr, form) {
	showResult(obtainTextInTag(responseXML,"<title>"),$(responseXML).find("#msg").text());
	setLinkbuttonStyle();
	unloading();
}

 function initTable() { 
	 getJSON(data, "zy","../../code/zy.json");
	$('#scoreInfoTable').datagrid({    
		title:'分组信息',
 		fitColumns:true,
	    url:'GroupAction_pingshenList.action?search.columns=-&user='+user,
	    pageSize:10,
	    pageList:[10,20,50],
	    columns:[[  
	        {field:'groupName',title:'专家组',width:fixWidth(0.2),formatter:function(data, value, index) {
	        	if(data == null) {
	        		return "";
	        	}	
	        	return (data+"").substring(0,10);
	        }}, 
	        {field:'groupField', title:'专业领域', width:fixWidth(0.2),formatter:function(value,rowData,index){
	        	return getText(value,data.zy);
	        }},
	        {field:'projectCount', title:'项目数', width:fixWidth(0.1)},
	        {field:'dos',title:'操作',width:fixWidth(0.1),align:'left',formatter:function(value,rowData,index){
	        	var s = '<a href="#" name="editLink" onclick="inProject('+"'"+rowData.id+"'"+');">查看</a> ';
	        /*	var s = '<a href="#" name="editLink" onclick="addTab('+"'打分'"+','+"'project.jsp?groupId="+rowData.id+"'"+');">查看</a>';*/
//	        	var s = '<a href="#" name="editLink" onclick="addTab(打分,project.jsp?groupId='+rowData.id+');">查看</a>';
	        	//alert(s);
	        	return s;
	        }}
	    ]],
	    pagination: true,
  		rownumbers: false,
  		onLoadSuccess:function (data) { //数据加载成功后需要设置linkbutton的样式，
  			setLinkbuttonStyle();
  		}
	});
 	var pg = $("#scoreInfoTable").datagrid("getPager");
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
	$("#p_size").val($("#scoreInfoTable").datagrid('options').pageSize);
}
 
	//打开查看项目信息窗口
	function inProject(groupId){
		alert("您将进入第" + groupId + "组");
		 var content = '<iframe scrolling="auto" name="detailsIfram" id="projcetIframe" frameborder="0"  src="project.jsp?groupId='+groupId+'" style="width:100%;height:100%;"/>';
		 
		 $("#dlg").dialog({
			 title:"查看项目信息",
			 height:$(window).height() * 1,
			 width:$(window).width() * 0.99,
			 content:content,
			 draggable:false,
			 modal: true
		/*	buttons:[
			          {text:'完  成',handler:function() {
			        	  $("#dlg").dialog("close");
			          }}
			          ]*/
		 }); 
	 }

	