package cn.list;

import java.util.ArrayList;
import java.util.List;

import bean.Person;


public class ListPractice {
 public static void main(String[] args) {
	 Person p1=new Person();
	 Person p2=new Person();
	 List list=new ArrayList();
	 list.add(p1);
	 list.add(p2);//这里是将对象加入到list中
	 for(int i=0;i<list.size();i++){//利用循环，将person对象全部一一取出
	     Person p=(Person)list.get(i);//注意，这里一定要强制类型转换，因为List中取出的对象都是Object类型的，希望对你有所帮助
	     System.out.print(i);
	 }
}
}
