package com.excute.util;

import com.excute.model.User;

public class TestUser {
  public static void main(String[] args) {
	  User user = new User();
	  user.setAge(99);
	  user.setName("hh");
	  System.out.println("age=" + user.getAge());
	  System.out.println("name=" + user.getName());
}
  
  
}