package com.excute.action;

/**
 * @ClassName: MethodAction
 * @Description: TODO 测试前台直接固定方法， struts.xml提供method action传参的不同
 * @author jh
 * @date 2015-8-10 下午10:12:59
 * 
 */
public class MethodAction {

	/**
	 * @Title: add
	 * @Author: jianghan
	 * @Description: TODO amethodshow!adds.action 动态调用方法
	 * @return
	 * 
	 */
	public String add() {
		return "ad";
	}

	public String adds() {
		return "adds";
	}
	/*
	 * public String execute(){ return "success"; }
	 */
}
