package com.jh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @ClassName: DemoController 
* @Description: TODO 
* @author jh 
* @date 2015-8-11 下午10:22:42 
*  
*/

@Controller
@RequestMapping("/demo")
public class DemoController {
	/** 
	* @Title: login 
	* @Author: jianghan
	* @Description: TODO 前后台传产，验证spring mvc是否
	* 配置成功
	* @return
	*    
	*/
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
