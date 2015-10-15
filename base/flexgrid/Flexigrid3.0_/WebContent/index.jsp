<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FlexiGrid</title>

<link rel="stylesheet" href="css/flexigrid/flexigrid.css" type="text/css"></link>
<script type="text/javascript" src="lib/jquery/jquery.js"></script>
<script type="text/javascript" src="flexigrid.pack.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var maiheight = document.documentElement.clientHeight;
	var w = $("#ptable").width() - 3;
	var gapTop =  30;
	var otherpm = 150; //GridHead，toolbar，footer,gridmargin
	var h = maiheight - gapTop - otherpm;

var grid=$("#flex1").flexigrid({
		width: w,
		height: h,
		url: 'flexGridServlet.do',
		dataType: 'json',
		colModel : [
			//{display: '<input type="checkbox" id="checkAll"/>', name : 'check', width : 50, sortable : false, align: 'center',hide: false},
			{display: '编号', name : 'id', width : 50, sortable : true, align: 'center',hide: false},
			{display: '工作名称', name : 'job_name', width : 250, sortable : false, align: 'center'},
			{display: '工作地址', name : 'work_address', width : 100, sortable : true, align: 'center'},
			{display: '工资', name : 'salary', width : 60, sortable : true, align: 'right',process:formatMoney},
			{display: '日期', name : 'date', width : 120, sortable : true, align: 'center'},
			{display: '语言', name : 'language', width : 80, sortable : true, align: 'center'}																
			],
		buttons : [
			{name: '添加', bclass: 'add', onpress : toolbar},
			{name: '删除', bclass: 'delete', onpress : toolbar},
			{name: '修改', bclass: 'modify', onpress : toolbar},				
			{separator: true}
			],
		searchitems : [
			{display: '编号', name : 'id', isdefault: true},
			{display: '工作名称', name : 'job_name'},
			{display: '工作地址', name : 'work_address'},
			{display: '语言', name : 'language'}
			],
		errormsg: '发生异常',
		sortname: "id",
		sortorder: "desc",
		usepager: true,
		title: '信息发布管理',
		pagestat: '显示记录从{from}到{to}，总数 {total} 条',
		useRp: true,
		rp: 10,
		rpOptions: [10, 15, 20, 30, 40, 100], //可选择设定的每页结果数
		nomsg: '没有符合条件的记录存在',
		minColToggle: 1, //允许显示的最小列数
		showTableToggleBtn: true,
		autoload: true, //自动加载，即第一次发起ajax请求
		resizable: false, //table是否可伸缩
		procmsg: '加载中, 请稍等 ...',
		hideOnSubmit: true, //是否在回调时显示遮盖
		blockOpacity: 0.5,//透明度设置
		rowbinddata: true,
		showcheckbox: true
		//gridClass: "bbit-grid"//样式
	});
	
	//$('.trSelected',grid).parent().removeClass("trSelected");
	
	function toolbar(com,grid){
		if (com=='删除'){
			${"action"}.value="delete";
			if($('.trSelected',grid).length==0){
				alert("请选择要删除的数据");
			}else{
				if(confirm('是否删除这 ' + $('.trSelected',grid).length + ' 条记录吗?')){
					 var  ids ="";
				     for(var i=0;i<$('.trSelected',grid).length;i++){
				        ids+=","+$('.trSelected',grid).find("td:first").eq(i).text();//获取id
				      }
				      ids=ids.substring(1);
				      $.ajax({
							type: "POST",
							url: "flexGridServlet.do?action="+${"action"}.value,
							data: "id="+ids,
							dataType:"text",
							success: function(msg){
								if(msg=="success"){
									$("#flex1").flexReload();
								}else{
									alert("有错误发生,msg="+msg);
								}
							},
							error: function(msg){
								alert(msg);
							}
						});
		      	}
		   }
		}else if (com=='添加'){
			${"action"}.value="add";
			alert("flexGridServlet.do?action="+${"action"}.value);
			window.location.href="flexGridServlet.do?action="+${"action"}.value; //是定向url提交数据
		}else if (com=='修改'){
			${"action"}.value="modify";
			if($(".trSelected").length==1){
				alert("flexGridServlet.do?action="+${"action"}.value+"&id="+$('.trSelected',grid).find("td").eq(0).text());
				window.location.href="flexGridServlet.do?action="+${"action"}.value+"&id="+$('.trSelected',grid).find("td").eq(0).text();
				
			}else if($(".trSelected").length>1){
				alert("请选择一个修改,不能同时修改多个");
			}else if($(".trSelected").length==0){
				alert("请选择一个您要修改的记录")
			}
			 
			//$("#flex1").flexReload({});
		}
	}
	function formatMoney(value, pid) {
         return "￥" + parseFloat(value).toFixed(2);
    }
	
			
});
</script>
<style>
        
   .flexigrid div.fbutton .add
       {
           background: url(css/images/add.png) no-repeat center left;
       }

   .flexigrid div.fbutton .delete
       {
           background: url(css/images/close.png) no-repeat center left;
       }
   .flexigrid div.fbutton .modify
       {
           background: url(css/images/modify.png) no-repeat center left;
       }
    
</style>
</head>
<body>
<div id="ptable" style="margin:10px">
	<table id="flex1" style="display:none"></table>
</div>  
<input id="action" type="hidden" name="action" value="null" />
<script>
   		
</script>

</body>
</html>