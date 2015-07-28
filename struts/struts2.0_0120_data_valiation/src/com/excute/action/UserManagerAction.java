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
  //问题
  //前台只负责向user中写入
  //因此当用user.getAge()接受时会报错
  
  public String execute(){
    
	 
	 System.out.println("name=" + user);
	 System.out.println("age=" + user);
	 return "success";
  }
  
}
