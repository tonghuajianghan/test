<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:directive.page import="dao.Student"/>
<jsp:directive.page import="dao.StudentDAO"/>
<%
// js传过来的参数列表：
// page:页数
// rp:每页显示多少条
// sortname：排序的字段名称
// sortorder: 排序的方向；比如：asc，desc；
// query : 查询的条件
// qtype ：查询的类型

String rp=request.getParameter("rp"); //每页显示的数据数
String pageString=request.getParameter("page");//获取 flexgrid传过来的页数。
String query=request.getParameter("query");//获取 查询的条件
query = java.net.URLDecoder.decode(query , "UTF-8");//解码

String qtype=request.getParameter("qtype");//获取 查询的类型
String sortorder=request.getParameter("sortorder");//获取 查询的类型
if(pageString == null || pageString.length() == 0) {
	pageString = "1";
}
// 读取数据
StudentDAO sDao=new StudentDAO();
List<Student> custList = new ArrayList<Student>();//定义一个list
custList= sDao.findPagedAll(Integer.parseInt(pageString), Integer.parseInt(rp),qtype,query,sortorder);//根据页数和每页显示数量  查出数据集合
int tatolPage=sDao.getTotalPage(Integer.parseInt(rp),qtype,query,sortorder); //总页数
int totalCount =sDao.getStudentTotalCount(qtype,query,sortorder); //记录总数
String a ="";//用来拼接数据
int list_size =custList.size();

if(list_size>0)
{
for(int i = 0; i < list_size; i++)
{
Student student = custList.get(i);
a =  a+ "{id:'ZW',cell:['"+student.getId()+"','"+student.getUsername()+"','"+student.getPassword()+"','"+student.getAge()+"','"+student.getAddress()+"']},";	 
}
}else{
a = ",";
}
a =  a.substring(0,a.length()-1);
out.println("{");
out.println("page: "+pageString+",");
out.println("total: "+totalCount+",");
out.println("rows: [");		 
out.println(a);
out.println("]}");
%>
