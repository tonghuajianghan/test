package cn.list;

import java.util.ArrayList;
import java.util.List;

import bean.Person;
import bean.Person1;


public class ListPractice1 {
 public static void main(String[] args) {
	 Person1 p1=new Person1("name1");
	 Person1 p2=new Person1("name2");
	 List list=new ArrayList();
	 list.add(p1);
	 list.add(p2);//这里是将对象加入到list中
	 for(int i=0;i<list.size();i++){//利用循环，将person对象全部一一取出
	     Person1 p=(Person1)list.get(i);//注意，这里一定要强制类型转换，因为List中取出的对象都是Object类型的，希望对你有所帮助
	     System.out.println(i);
	     System.out.println(p.str);
	 }
}
}
