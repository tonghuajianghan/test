/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com
 * 创建时间：2015-8-19 下午10:21:35 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理
 * 
 * @ClassName: UserController
 * @Description: TODO
 * @author jh
 * @date 2015-8-19 下午10:21:41
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	/** 
	* @Title: userManager 
	* @Author: jianghan
	* @Description: TODO 返回用户管理界面
	* @return
	*    
	*/
	
	
	@RequestMapping("/uM")
	public String userManager(){
		return "userpage/userManager";
	}

}
