<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="org.hibernate.cfg.Configuration,org.hibernate.Query,org.hibernate.SessionFactory,org.hibernate.Session"%>
<%@ page import="com.hibernate.vo.*,java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>achieve01</title>

<link rel="stylesheet" type="text/css" href="../css/flexigrid.css" />
<script type="text/javascript" src="../js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="../js/flexigrid.js"></script>
</head>
<body>
<p>主要实验与后台的交互</p>

<table id="flex1" style="display:none">
  	<tbody>												  
		 		    <%
				       Configuration cfg = new Configuration();     
				       SessionFactory sf = cfg.configure().buildSessionFactory();      
				       Session session1 = sf.openSession();     
				       session1.beginTransaction();
				    
				       //HQL语句
				       Query query = session1.createQuery("from Student");
				       List  peList = query.list();
				       //System.out.println("mark:"+peList.size());
				  	
				       for(int i = 1; i < peList.size();i++){
				  		 //System.out.println("mark "+i);
				  		 Student stu =(Student)peList.get(i);
				  		 //System.out.println(stu.getName());
				  	%>
				  	   <tr>
				  	     <td>
				  	       <%=stu.getId()%>
				  	     </td>
				  	     <td>
				  	       <%=stu.getName() %>
				  	     </td> 				  	     
				  	     <td>
				  	       <%=stu.getAge()%>
				  	     </td>  
				  	   </tr>  
				  	<%	 
				  	   }
				       
				       session1.getTransaction().commit();
				       session1.close();
				       sf.close();
				    %> 				    								
				
			</tbody>
</table>

<script type="text/javascript">
//加载flexigrid


 $("#flex1").flexigrid({  
	//url: 'add.jsp',//数据请求地址,后台代码地址,加载add.jsp后，回到achieve01.jsp页面
	dataType: 'json',//请求数据的格式
	colModel : [         
		{display: 'id', name : 'iso', width : 70, sortable : true, align: 'center'},
		{display: 'Name', name : 'name', width : 180, sortable : true, align: 'left'},
		{display: 'age', name : 'printable_name', width : 120, sortable : true, align: 'left'},
		],
    buttons : [
		{name: 'Add', bclass: 'add', onpress : test},
	    {name: 'Delete', bclass: 'delete', onpress : test},
	    {name: 'Update', bclass: 'update', onpress : test},
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
	//autoload: true, //自动加载，即第一次发起ajax请求 
}); 

function test(com, grid) {
		if (com == 'Delete') {
			if(confirm('Delete ' + $('.trSelected', grid).length + ' items?')){								 
				 var  ids ="";
                 for(var i=0;i<$('.trSelected',grid).length;i++){                     
                    ids+=","+$('.trSelected',grid).find("td:first").eq(i).text();//获取id 
                    
                    $.post("delete.jsp", { ids:ids}  );
                    //document.write(ids);//终端当前执行，转换到另一个页面                                    
                  }                    
			}			
		} else if (com == 'Add') {
			alert('Add New Item');
		    // collect the data
            var EmpID = prompt("姜晗","怀念 ");//返回提示框中输入的数值
            var id = prompt("id","-");
            var age = prompt("age","-");
            //document.write(EmpID);
            // call the ajax to save the data to the session 
            //用$.get时候，add.jsp得到的数据乱码
            $.post("add.jsp", { name: EmpID, id: id,age:age },function(){
                // when ajax returns (callback), update the grid to refresh the data
                $(".flex1").flexReload();}
            		
            );
			
		}else if (com == 'Update'){//与名字相同
			alert('update');
			var  uids ="";
            for(var i=0;i<$('.trSelected',grid).length;i++){                     
               uids+=","+$('.trSelected',grid).find("td:first").eq(i).text();//获取id                
               $.post("update.jsp", { uids:uids}  );                                              
             }
		}
	}



function addFormData(){
	var dt = $('#sform').serializeArray();
	$("#flex1").flexOptions({params: dt});  //更改flexigrid参数。P：选项参数集合    ，更改选项的参数
	return true;
}  


</script>
</body>
</html>