<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Flexigrid main</title>

<link rel="stylesheet" type="text/css" href="../css/flexigrid.css" />
<script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="../js/flexigrid.js"></script>
</head>
<body>
<p>实现了主要的页面功能，添加了了注释</p>

<!--添加flexgird  -->
<table id="flex1" style="display:none"></table>

<script type="text/javascript">
//加载flexigrid


 $("#flex1").flexigrid({  
	url: '/Flexigrid/src/cust/servlet/control/ServletManager',//数据请求地址,后台代码地址
	dataType: 'json',//请求数据的格式
	//表头 
	colModel : [
		{display: '姜晗', name : 'iso', width : 40, sortable : true, align: 'center'},
		{display: 'Name', name : 'name', width : 180, sortable : true, align: 'left'},
		{display: 'Printable Name', name : 'printable_name', width : 120, sortable : true, align: 'left'},
		{display: 'ISO3', name : 'iso3', width : 130, sortable : true, align: 'left', hide: true},
		{display: 'Number Code', name : 'numcode', width : 80, sortable : true, align: 'right'}
		],
	//按钮 
    buttons : [
		{name: 'Add', bclass: 'add', onpress : test},
	    {name: 'Delete', bclass: 'delete', onpress : test},
		{separator: true}
		],
	searchitems : [
		{display: 'ISO', name : 'iso'},
		{display: 'Name', name : 'name', isdefault: true}
		],
	sortname: "iso",  //默认排序字段名称
	sortorder: "asc", //升序还是降序
	usepager: true,    //是否分页
	title: 'Countries',//标题
	useRp: true,         //use the results per page select box,是否可以动态设置每页显示的结果数
	rp: 9,             //默认分页条数
	showTableToggleBtn: false,  //是否显示【显示隐藏Grid】的按钮
	width: 700,
	//onSubmit: addFormData,//与下面的函数关联，//数据提交时调用的自定义函数 ，数据提交自动调用的函数
	height: 200
}); 

function test(com, grid) {
		if (com == 'Delete') {
			confirm('Delete ' + $('.trSelected', grid).length + ' items?')
		} else if (com == 'Add') {
			alert('Add New Item');
		}
	}



/* function addFormData(){
	var dt = $('#sform').serializeArray();//这个方法 可以根据name属性 序列化表哥中的内容 传到服务器端 
                                        //在服务器端用request.getParamater("这里是你的text的那么属性");
	$("#flex1").flexOptions({params: dt});  //更改flexigrid参数。P：选项参数集合,
	                                       //作用. 当提交时，到后台 -> 表格中直接显示提交的参数
	return true;
}  */


</script>
</body>
</html>