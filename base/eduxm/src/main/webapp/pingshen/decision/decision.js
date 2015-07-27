var title = "专家决策";
var data = {
		xy : null,
		zy : null,
		xl : null
};

var arrMatch=[
          	new Match("c_xmlb","项目类别",textfunction),
          	new Match("c_yjlx","研究类型",textfunction),
          	]; 

function submitSerach(pageNumber) {
	loading("获取数据中。。。。。。");
	if(pageNumber == 1) {//重新点击了查询按钮，这时候从第一页开始显示，但是分页显示的可能不是第一页 ，所以需要重新设置下pagination显示的当前页数
		var pg = $("#decisionInfoTable").datagrid("getPager");
		pg.pagination({pageNumber:1});
	} 
	psize = $("#p_size").val();
	if(psize==""||psize==null){
		psize=10;
	}
	var options = {
			url     :'Decision_list.action?rows='+psize+'&page='+pageNumber,
			success	:	reloadGroupTable,
			error	:	errorTip,
			dataType:	'json'
	};
    $("#searchForm").ajaxSubmit(options);
}
function reloadGroupTable(responseXML, statusText, xhr, form) {
	$('#decisionInfoTable').datagrid('loadData', responseXML); 
	setLinkbuttonStyle();
	unloading();
}
function reload(){
	$('#decisionInfoTable').datagrid('reload'); 
}
function errorTip(responseXML, statusText, xhr, form) {
	showResult(obtainTextInTag(responseXML,"<title>"),$(responseXML).find("#msg").text());
	setLinkbuttonStyle();
	unloading();
}

 function initTable() { 
	 getJSON(data, "zy","../../code/zy.json");
	 
	 $("#tableid").datagrid({
	 		title:'决策信息',
	 		singleSelect:true,
	 		fitColumns:true,
	 		
	 		columns:[[
				{field:'way',title:'连接方式',width:fixWidth(0.05)},
	 		    {field:'target',title:'专业领域',width:fixWidth(0.15)},
	 		    {field:'method',title:'技术领域',width:fixWidth(0.15)},
	 		    {field:'content',title:'分数线',width:fixWidth(0.1)},
	 		    {field:'passrate',title:'通过率 %',width:fixWidth(0.1)}
	 		]]
	 	});
	 
	$('#decisionInfoTable').datagrid({    
		title:'决策结果',
 		fitColumns:true,
	    url:'Decision_list.action?search.columns=-&user='+user,
	    pageSize:10,
	    pageList:[10,20,50],
	    columns:[[  
	        {field:'xmlb',title:'专业领域',width:fixWidth(0.2),formatter:function(data, value, index) {
	        	if(data == null) {
	        		return "";
	        	}	
	        	return (data+"").substring(0,10);
	        }}, 
	        {field:'yjlx', title:'技术领域', width:fixWidth(0.25),formatter:function(value,rowData,index){
	        	return getText(value,data.zy);
	        }},

	        {field:'psfs',title:'状态',width:fixWidth(0.1),formatter:function (value,row,index){//参数含义value：字段值。row：行记录数据。index: 行索引。 
	        		var val = $("#searchVal").val();
	        		if(val != null && val != ""){
	        			if(value >= val){
		        			return "<font color='green'>通过</font>"
		        		}
		        		if(value < val){
		        			return "<font color='red'>未通过</font>";
		        		}
	        		}
 		    	}
 		    }
	    ]],
	    pagination: true,
  		rownumbers: false,
  		onLoadSuccess:function (data) { //数据加载成功后需要设置linkbutton的样式，
  			setLinkbuttonStyle();
  		}
	});
 	var pg = $("#decisionInfoTable").datagrid("getPager");
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
	$("#p_size").val($("#decisionInfoTable").datagrid('options').pageSize);
}
 

	