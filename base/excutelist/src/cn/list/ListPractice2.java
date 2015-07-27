package cn.list;

import java.util.ArrayList;
import java.util.List;

import bean.Person;
import bean.Person1;
import bean.Person2;


public class ListPractice2 {
 public static void main(String[] args) {
	 Person2 p1=new Person2();
	 Person2 p2=new Person2();
	 for(int i=0;i<5;i++){
		 p1.setName("jianghan" + i);
		 p1.setAge(10 + i);
	 }
	 
	 List<Person2> list=new ArrayList<Person2>();
	 list.add(p1);
	 //list.add(p2);//这里是将对象加入到list中
	 for(int i=0;i<list.size();i++){//利用循环，将person对象全部一一取出
	     Person2 p=(Person2)list.get(i);//注意，这里一定要强制类型转换，因为List中取出的对象都是Object类型的，希望对你有所帮助
	     System.out.println(i);	     
	     System.out.println(p.getName());
	     System.out.println(p.getAge());
	     System.out.println(" ");
	 }
}
}
