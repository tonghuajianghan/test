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
	 //list.add(p2);//�����ǽ�������뵽list��
	 for(int i=0;i<list.size();i++){//����ѭ������person����ȫ��һһȡ��
	     Person2 p=(Person2)list.get(i);//ע�⣬����һ��Ҫǿ������ת������ΪList��ȡ���Ķ�����Object���͵ģ�ϣ��������������
	     System.out.println(i);	     
	     System.out.println(p.getName());
	     System.out.println(p.getAge());
	     System.out.println(" ");
	 }
}
}
