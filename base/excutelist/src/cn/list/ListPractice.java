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
	 list.add(p2);//�����ǽ�������뵽list��
	 for(int i=0;i<list.size();i++){//����ѭ������person����ȫ��һһȡ��
	     Person p=(Person)list.get(i);//ע�⣬����һ��Ҫǿ������ת������ΪList��ȡ���Ķ�����Object���͵ģ�ϣ��������������
	     System.out.print(i);
	 }
}
}
