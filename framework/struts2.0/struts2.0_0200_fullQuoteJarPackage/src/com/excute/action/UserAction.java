package com.excute.action;
/*
 * ������ϰǰ̨ͨ��url���θ���̨
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
