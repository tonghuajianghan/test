﻿var title = "专家审核";
/*var data = {
		xy : null,
		zy : null,
		xl : null
};*/
var arrMatch=[
    //combobox,combotree
	new Match("c_xmmc","项目名称","textfunction"),
	new Match("c_jhwcsj","计划完成时间","datefunction"),
	new Match("c_tbsj","填报时间","datefunction"),
	new Match("c_kssj","开始时间","datefunction"),
	new Match("c_yjlx","研究类型","textfunction"),
	new Match("c_cgxs","成果形式","textfunction"),
	new Match("c_ysze","预算总额","textfunction"),
	new Match("c_sqnd","申请年度","textfunction"),
	]; 

function submitSerach(pageNumber,url) {
	loading("获取数据中。。。。。。");
	if(pageNumber == 1) {//重新点击了查询按钮，这时候从第一页开始显示，但是分页显示的可能不是第一页 ，所以需要重新设置下pagination显示的当前页数
		var pg = $("#ProjectInfoTable").datagrid("getPager");
		pg.pagination({pageNumber:1});
	} 
	psize = $("#p_size").val(); 
	url += '?rows='+psize+'&page='+pageNumber;
	var options = {
			url     :	url,
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

function reload(){
	$('#ProjectInfoTable').datagrid('reload'); 
}
function errorTip(responseXML, statusText, xhr, form) {
	showResult(obtainTextInTag(responseXML,"<title>"),$(responseXML).find("#msg").text());
	setLinkbuttonStyle();
	unloading();
}
/**
 * 
 *  确认提交后要修改的临时状态，即将c0改为c1或则将b0改为b1
 */
function confirmShoolSub(){
	$.messager.confirm('确认','确认提交对当前页面的修改，提交后将不得修改，并且您将不能看到已通过和未通过的项目信息',function(r){
		 if(r) {
			loading("传输数据中，请稍后。。。");
			//获得已经修改项目的id    下面的for循环将未审评的项目给滤除掉了。留下了状态中间为0的项目
			/*var rows = $("#ProjectInfoTable").datagrid('getRows');
			for(var i = 0; i < rows.length; i++){
				if(rows[i].zt.substr(1,1) != "0"){
					rows.splice(i,1);
					alert(rows.length);
					i--;
				}
			}*/
			$.post("CheckProj_schoolConfirm.action",function (json) {
				 if(json['errormsg'] == null){
					 alert("操作成功");
				 }else{
					 alert(json['errormsg']);
				 }
			 });
			unloading();
			reload();
		 }
	 });
}
/**
 * 
 *  确认提交后要修改的临时状态，即将c0改为c1或则将b0改为b1
 */
function confirmEduSub(){
	$.messager.confirm('确认','确认提交对当前页面的修改，提交后将不得修改，并且您将不能看到已通过和未通过的项目信息',function(r){
		if(r) {
			loading("传输数据中，请稍后。。。");
			$.post("CheckProj_eduConfirm.action",function (json) {
				if(json['errormsg'] == null){
					alert("操作成功");
				}else{
					alert(json['errormsg']);
				}
			});
			unloading();
			reload();
		}
	});
}
function initSchoolList(){ 
	loadSearchTable('tableid', arrMatch);
	
	$('#ProjectInfoTable').datagrid({    
		title:'项目资料信息',
		fitColumns:true,
		url:'CheckProj_schoolList.action?search.columns=-',
		method:"post",
		pageSize:10,
		pageList:[10,20,50],
		columns:[[  
		{field:'xmmc',title:'项目名称',width:fixWidth(0.35)},    
		{field:'yjlx',title:'研究类型',width:fixWidth(0.1)},    
		{field:'kssj',title:'开始时间',width:fixWidth(0.1),formatter:function(data,value,index){
		    	if(data==null){
		    		return "";
		    	}
		    	return (data+"").substring(0,10);
		    }},          
		{field:'jhwcsj',title:'计划完成时间',width:fixWidth(0.1),formatter:function(data,value,index){
	        	if(data==null){
	        		return "";
	        	}
	        	return (data+"").substring(0,10);
	        }},      
		{field:'zt',title:'评审结果',width:fixWidth(0.1),
	        	formatter:function (value,row,index){//参数含义value：字段值。row：行记录数据。index: 行索引。 
	        		if(value == 'b09'){
	        			return "<font color='green'>通过</font>"
	        		}
	        		if(value == 'b00'){
	        			return "<font color='red'>未通过</font>";
	        		}
	        		if(value == 'a19'){
	        			return "<b>未审核</b>"
	        		}
	        		else{
	        			return "数据异常";
	        		}
	        	}
        },
	    {field:'dos',title:'操作',width:fixWidth(0.2),align:'left',formatter:function(value,rowData,index){
	    	var l = '<a href="#" name="detailsLink" onclick="projectDetails('+"'"+rowData.xm_id+"'"+');">查看</a>';
	    	var s = '<a href="#" name="editLink" onclick="schoolPass('+"'"+rowData.xm_id+"'"+');">通过</a>';
	    	var c = '<a href="#" name="delLink" onclick="schoolNoPass('+"'"+rowData.xm_id+"'"+');">不通过</a>';
	    	return l+s+c;
	    }},
	    ]],
	    toolbar:[
	        {text:'结束审核', iconCls:'icon-add', handler: function(){confirmShoolSub();}}
	    	/*{text:'批量删除', iconCls:'icon-cancel', handler: function(){delProject(author,isAdmin);}},
	    	{text:'只看自己', iconCls:'icon-search', handler: function(){
	    	}}*/
	    ],
	    pagination: true,
		rownumbers: false,
		onLoadSuccess:function(data) { //数据加载成功后需要设置linkbutton的样式，
			setLinkbuttonStyle();
			
		}
	});
 	var pg = $("#ProjectInfoTable").datagrid("getPager");
	if(pg) {    
		var url = "CheckProj_schoolList.action";
	    $(pg).pagination({
<<<<<<< .mine
	        onRefresh:function(pageNumber,pageSize){
	        	alert("on refresh.");
=======
	    	
	        onRefresh:function(pageNumber,pageSize){ 
>>>>>>> .r1468
	        	submitSerach(pageNumber,url); 
	        	setLinkbuttonStyle();
	        },    
	        onChangePageSize:function(pageSize){  
	        	$("#p_size").val(pageSize);
	        	submitSerach(1,url);//更改分页单位后，设置为显示第一页
	        	setLinkbuttonStyle();
	        },    
	        onSelectPage:function(pageNumber,pageSize){ 
	       		submitSerach(pageNumber,url);
	       		setLinkbuttonStyle();
	       	}    
	    });    
	 }
	$("#p_size").val($("#ProjectInfoTable").datagrid('options').pageSize);//将每页大小记录下来，放在隐藏域中
}
function initEduList(){ 
	loadSearchTable('tableid', arrMatch);
	$('#ProjectInfoTable').datagrid({    
		title:'项目资料信息',
		fitColumns:true,
		url:'CheckProj_eduList.action?search.columns=-',
		method:"post",
		pageSize:10,
		pageList:[10,20,50],
		columns:[[  
		          {field:'xmmc',title:'项目名称',width:fixWidth(0.35)},    
		          {field:'yjlx',title:'研究类型',width:fixWidth(0.1)},    
		          {field:'kssj',title:'开始时间',width:fixWidth(0.1),formatter:function(data,value,index){
		        	  if(data==null){
		        		  return "";
		        	  }
		        	  return (data+"").substring(0,10);
		          }},          
		          {field:'jhwcsj',title:'计划完成时间',width:fixWidth(0.1),formatter:function(data,value,index){
		        	  if(data==null){
		        		  return "";
		        	  }
		        	  return (data+"").substring(0,10);
		          }},      
		          {field:'zt',title:'评审结果',width:fixWidth(0.1),
		        	  formatter:function (value,row,index){//参数含义value：字段值。row：行记录数据。index: 行索引。 
		        		  if(value == 'c09'){
		        			  return "<font color='green'>通过</font>"
		        		  }
		        		  if(value == 'c00'){
		        			  return "<font color='red'>未通过</font>";
		        		  }
		        		  if(value == 'b19'){
		        			  return "<b>未审核</b>"
		        		  }
		        		  else{
		        			  return "数据异常";
		        		  }
		        	  }
		          },
		          {field:'dos',title:'操作',width:fixWidth(0.2),align:'left',formatter:function(value,rowData,index){
		        	  var l = '<a href="#" name="detailsLink" onclick="projectDetails('+"'"+rowData.xm_id+"'"+');">查看</a>';
		        	  var s = '<a href="#" name="editLink" onclick="eduPass('+"'"+rowData.xm_id+"'"+');">通过</a>';
		        	  var c = '<a href="#" name="delLink" onclick="eduNoPass('+"'"+rowData.xm_id+"'"+');">不通过</a>';
		        	  return l+s+c;
		          }},
		          ]],
		          toolbar:[
		                   {text:'结束审核', iconCls:'icon-add', handler: function(){confirmEduSub();}}
		                   /*{text:'批量删除', iconCls:'icon-cancel', handler: function(){delProject(author,isAdmin);}},
	    	{text:'只看自己', iconCls:'icon-search', handler: function(){
	    	}}*/
		                   ],
		                   pagination: true,
		                   rownumbers: false,
		                   onLoadSuccess:function(data) { //数据加载成功后需要设置linkbutton的样式，
		                	   setLinkbuttonStyle();
		                	   
		                   }
	});
	var pg = $("#ProjectInfoTable").datagrid("getPager");
	if(pg) {    
		var url = "CheckProj_eduList.action";
		$(pg).pagination({
	        onRefresh:function(pageNumber,pageSize){ 
	        	submitSerach(pageNumber,url); 
	        	setLinkbuttonStyle();
	        },    
	        onChangePageSize:function(pageSize){  
	        	$("#p_size").val(pageSize);
	        	submitSerach(1,url);//更改分页单位后，设置为显示第一页
	        	setLinkbuttonStyle();
	        },    
	        onSelectPage:function(pageNumber,pageSize){ 
	       		submitSerach(pageNumber,url);
	       		setLinkbuttonStyle();
	       	}    
		});    
	}
	$("#p_size").val($("#ProjectInfoTable").datagrid('options').pageSize);//将每页大小记录下来，放在隐藏域中
}
//打开查看项目信息窗口
function projectDetails(projectId){
	 var content = '<iframe scrolling="auto" name="detailsIfram" id="projcetIframe" frameborder="0"  src="../details/innerIndex.jsp?projectId='+projectId+'" style="width:100%;height:100%;"/>';
	 $("#dlg").dialog({
		 title:"查看项目信息",
		 height:$(window).height() * 1,
		 width:$(window).width() * 0.9,
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
/**
 * 改变project的状态   教育厅审核
 * @param xm_id 项目的id
 * @param zt  将要改成的状态
 * @returns
 */
function eduPass(xm_id){
	var url = "CheckProj_eduPass.action";
	submitPost(url,xm_id);
}
function eduNoPass(xm_id){
	var url = "CheckProj_eduNoPass.action";
	submitPost(url,xm_id);
}
/**
 * 改变project的状态  school的审核 通过
 * @param xm_id 项目的id
 * @param zt  将要改成的状态
 * @returns
 */
function shoolPass(xm_id){
	var url = "CheckProj_shoolPass.action";
	submitPost(url,xm_id);
}
function shoolNoPass(xm_id){
	var url = "CheckProj_shoolNoPass.action";
	submitPost(url,xm_id);
}

function submitPost(url,xm_id){
	loading("正在提交数据");
	$.post(url,{"projectid":xm_id},function(json){
		unloading();
		if(json["errormsg"]== null){
			//成功
			reload();
		}else{
			//失败
			alert("提交失败，请重新操作");
		}
	});
}
