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
	 list.add(p2);//�����ǽ�������뵽list��
	 for(int i=0;i<list.size();i++){//����ѭ������person����ȫ��һһȡ��
	     Person1 p=(Person1)list.get(i);//ע�⣬����һ��Ҫǿ������ת������ΪList��ȡ���Ķ�����Object���͵ģ�ϣ��������������
	     System.out.println(i);
	     System.out.println(p.str);
	 }
}
}
