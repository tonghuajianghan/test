<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>second_submit page</title>

<link rel="stylesheet" type="text/css" href="../css/flexigrid.css" />
<script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="../js/flexigrid.js"></script>
</head>
<body>
<p>主要实验与后台的交互</p>

<div>
      <jsp:useBean id="beanbasic" class="vo.BeanBasic"></jsp:useBean>
       <jsp:getProperty property="id" name="beanbasic"/>
       <jsp:getProperty property="name" name="beanbasic"/>
       <jsp:setProperty property="id" name="beanbasic" value="12"/>
       <jsp:setProperty property="name" name="beanbasic" value="jianghan"/>
       
       <jsp:setProperty property="id" name="beanbasic" value="123"/>
       <jsp:setProperty property="name" name="beanbasic" value="hhhhhhhhhh"/>
  <%--      
       <p>conturies</p>hhhhhhhhhhhhhh<br>
       <jsp:useBean id="beanbasic2" class=vo.Conturies></jsp:useBean>
       <jsp:getProperty property="id" name="beanbasic"/><br>
       <jsp:getProperty property="name" name="beanbasic"/>
       <br><br><br>
   --%>
       
</div> 
 <table id="flex1" style="display:none">
  	<tbody>
				<tr>
					<td>This is data 1 with overflowing content</td>
					<td>This is data 2</td>
					<td>This is data 3</td>
					<td>This is data 4</td>
				</tr>
				<tr>
					<td>This is data 1</td>
					<td>This is data 2</td>
					<td>This is data 3</td>
					<td>This is data 4</td>
				</tr>
			   
				<tr>
				   <td>				       
				       <jsp:getProperty property="id" name="beanbasic"/>
				   </td>
				   <td>
				       <jsp:getProperty property="name" name="beanbasic"/>
				   </td>
				   <td>
				    <%--   <jsp:getProperty property="printtable" name="contury"/> --%>
				   </td>
				</tr> 
	</tbody>
</table>

<script type="text/javascript">
//加载flexigrid


 $("#flex1").flexigrid({  
	url: 'savefile.xml',  //数据请求地址,后台代码地址
	dataType: 'xml',  //请求数据的格式
	colModel : [
		{display: 'id', name : 'iso', width : 40, sortable : true, align: 'center'},
		{display: 'Name', name : 'name', width : 180, sortable : true, align: 'left'},
		{display: 'Printable Name', name : 'printable_name', width : 120, sortable : true, align: 'left'},
		{display: 'ISO3', name : 'iso3', width : 130, sortable : true, align: 'left', hide: true},
		{display: 'Number Code', name : 'numcode', width : 80, sortable : true, align: 'right'}
		],
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
	showTableToggleBtn: true,  //是否显示【显示隐藏Grid】的按钮
	width: 700,
	//onSubmit: addFormData,//与下面的函数关联，//数据提交时调用的自定义函数 
	height: 200
}); 

function test(com, grid) {
		if (com == 'Delete') {
			if($('.trSelected',grid).length>0){  //.trselected所选的一个列名
				   if(confirm('Delete ' + $('.trSelected',grid).length + ' items?')){
		            var items = $('.trSelected',grid);
		            var itemlist ='';
		        	for(i=0;i<items.length;i++){
						itemlist+= items[i].id.substr(3)+",";
					}
					$.ajax({
					   type: "POST",
					   dataType: "json",
					   url: "delete.php",
					   data: "items="+itemlist,
					   success: function(data){
					   	alert("Query: "+data.query+" - Total affected rows: "+data.total);
					   $("#flex1").flexReload();
					   }
					 });
					}
					} else {
						return false;
					} 
		} else if (com == 'Add') {
			alert('Add New Item');
		}
	}



/* function addFormData(){
	var dt = $('#sform').serializeArray();
	$("#flex1").flexOptions({params: dt});  //更改flexigrid参数。P：选项参数集合    ，更改选项的参数
	return true;
}  */


</script> 
</body>
</html>