package com.excute.action;
/*
 * 用于练习前台通过url传参给后台
 */

public class UserAction {

	private String student;
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}

	 public String execute(){
		  System.out.println("student=" + student);		  
		  return "success";	  
	  }

}
