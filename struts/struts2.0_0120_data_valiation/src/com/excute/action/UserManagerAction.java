package com.excute.action;

import com.excute.model.User;

public class UserManagerAction {
  private User user;
  
  
  public User getUser() {
	return user;
  }
  public void setUser(User user) {
		this.user = user;
  }
  public void add(){
	  user.setAge(12);
	  user.setName("jh");
  }
  //����
  //ǰֻ̨������user��д��
  //��˵���user.getAge()����ʱ�ᱨ��
  
  public String execute(){
    
	 
	 System.out.println("name=" + user);
	 System.out.println("age=" + user);
	 return "success";
  }
  
}
