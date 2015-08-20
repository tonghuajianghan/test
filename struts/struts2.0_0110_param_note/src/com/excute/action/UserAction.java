package com.excute.action;


/** 
* @ClassName: UserAction 
* @Description: TODO 传产调用
* @author jh 
* @date 2015-8-10 下午9:56:16 
*  
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
