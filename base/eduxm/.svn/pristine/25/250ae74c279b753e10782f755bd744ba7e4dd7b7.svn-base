var title = "专家推荐信息";
var data = {
		xy : null,
		zy : null,
		xl : null,
		zt : null
};
var arrMatch=[
    //combobox,combotree
	new Match("C_USERNAME","身份证号","textfunction"),
	new Match("C_XM","专家姓名 ","textfunction"),
	new Match("C_XB","专家性别","selectfunction","../../code/xb.json","combobox"),
	new Match("C_ZC","专家职称","textfunction"),
	new Match("C_ZW","专家职务","textfunction"),
	new Match("C_ZYLY","专业领域","selectfunction","../../code/zy.json","combobox"),
	new Match("C_YJFX","研究方向","textfunction"),
	new Match("C_CSNY","出生年月","datefunction"),
	new Match("C_SSDW","所属单位","textfunction"),
	new Match("C_DZYJ","电子邮件","textfunction"),
	new Match("C_LXDH","联系电话","textfunction"),
	new Match("C_ZT","专家状态","selectfunction","../../code/zt.json","combobox"),
	]; 

function submitSerach(pageNumber) {
	loading("获取数据中。。。。。。");
	if(pageNumber == 1) {//重新点击了查询按钮，这时候从第一页开始显示，但是分页显示的可能不是第一页 ，所以需要重新设置下pagination显示的当前页数
		var pg = $("#expertInfoTable").datagrid("getPager");
		pg.pagination({pageNumber:1});
	} 
	psize = $("#p_size").val();
	if(psize==""||psize==null){
		psize=10;
	}
	var options = {
			url     :'../check/Expert_list.action?rows='+psize+'&page='+pageNumber,
			success	:	reloadGroupTable,
			error	:	errorTip,
			dataType:	'json'
	};
    $("#searchForm").ajaxSubmit(options);
}
function reloadGroupTable(responseXML, statusText, xhr, form) {
	$('#expertInfoTable').datagrid('loadData', responseXML); 
	setLinkbuttonStyle();
	unloading();
}
function reloadTableAfterUpdateOrAdd() {
	$('#expertInfoTable').datagrid('reload'); 
}
function errorTip(responseXML, statusText, xhr, form) {
	showResult(obtainTextInTag(responseXML,"<title>"),$(responseXML).find("#msg").text());
	setLinkbuttonStyle();
	unloading();
}

 function initTable() {
	 loadSearchTable('tableid', arrMatch);
	getJSON(data, "zy","../../code/zy.json");
	getJSON(data, "zt","../../code/zt.json");
	 
	$('#expertInfoTable').datagrid({    
		title:'专家信息',
 		fitColumns:true,
	    url:'../check/Expert_list.action?search.columns=-',
	    pageSize:10,
	    pageList:[10,20,50],
	    columns:[[  
	        {field:'ok',checkbox:true},   
	        {field:'username',title:'身份证号',width:fixWidth(0.1)},
	        {field:'xm',title:'姓名',width:fixWidth(0.1)},    
	        {field:'xb',title:'性别',width:fixWidth(0.1)},  
	        {field:'zc',title:'职称',width:fixWidth(0.1)}, 
	        {field:'zw',title:'职务',width:fixWidth(0.1)}, 
//	        {field:'zyly',title:'专业领域',width:fixWidth(0.1)}
	        {field:'zyly',title:'专业领域',width:fixWidth(0.1),formatter:function(value,rowData,index){
	        	return getText(value,data.zy);
	        }},
	        {field:'yjfx',title:'研究方向',width:fixWidth(0.1)},
	       // {field:'csny',title:'出生年月',width:fixWidth(0.1)},
	        {field:'ssdw',title:'单位',width:fixWidth(0.1)},
	        //{field:'dzyj',title:'电子邮件',width:fixWidth(0.1)},
	        {field:'lxdh',title:'联系电话',width:fixWidth(0.1)},
	        //{field:'bz',title:'备注',width:fixWidth(0.1)}
	        {field:'zt',title:'状态',width:fixWidth(0.1),formatter:function(value,row,index){
	        	return getText(value,data.zt);
	        }},
	      
	        {field:'dos',title:'操作',width:fixWidth(0.25),align:'left',formatter:function(value,rowData,index){
	        	var l = '<a href="#" name="detailsLink" onclick="expertDetails('+"'"+rowData.username+"'"+');">查看</a>';
		    	var s = '<a href="#" name="editLink" onclick="changeZt('+"'"+rowData.username+"','1'"+');">通过</a>';
		    	var c = '<a href="#" name="delLink" onclick="changeZt('+"'"+rowData.username+"','0'"+');">不通过</a>';
		    	
		    	return l+s+c;
	        }}
	    ]],
	    
	    pagination: true,
  		rownumbers: false,
  		onLoadSuccess:function (data) { //数据加载成功后需要设置linkbutton的样式，
  			setLinkbuttonStyle();
  		}
	});
 	var pg = $("#expertInfoTable").datagrid("getPager");
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
	$("#p_size").val($("#expertInfoTable").datagrid('options').pageSize);
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
 //用来显示添加，编辑专家组信息状态。关闭添加，编辑会议资料对话框
 function closeDlg(callbackData) {
	$("#dlg").dialog("close");
	$("#expertInfoTable").datagrid("reload");
	showResult(obtainTextInTag(callbackData,"<title>"),$(callbackData).find("#msg").text());
 }
 
 function delOneMet(username) {
	 $.messager.confirm('确认','删除不可恢复，您确认想要删除记录吗？',function(r){
		 if(r) {
			loading("传输数据中，请稍后。。。");
			 $.post("../expert/Expert_del.action",{usernames:username},function (callbackData) {
				 showResult(obtainTextInTag(callbackData,"<title>")  ,$(callbackData).find("#msg").text());
				 $("#expertInfoTable").datagrid("reload");
				 unloading();
			 }); 
		 }
	 });
 }
 
 function changeZt(usernames,zt){
	 loading("正在提交数据....");
	 var url="../check/Expert_changeZt.action";
	 $.post(url,{"usernames":usernames,"zt":zt},function(json){
		 unloading();
			if(json["errormsg"]== null){		
				reload();
			}else{
				//失败
				alert("提交失败，请重新操作");
			}
	 })
 }
 function reload(){
		$('#expertInfoTable').datagrid('reload'); 
	}

 //打开专家推荐信息窗口
 function expertDetails(ExpertUsername){
	 
	 var content = '<iframe scrolling="auto" name="editIfram" id="expertIframe" frameborder="0"  src="../../expert/check/Expert_details.action?usernames='+ExpertUsername+'" style="width:100%;height:100%;"/>';
	 $("#dlg").dialog({
		 title:"查看专家信息",
		 height:$(window).height() * 0.9,
		 width:$(window).width() * 0.8,
		 content:content,
		 modal: true,
		 
	 }); 
 }
 
