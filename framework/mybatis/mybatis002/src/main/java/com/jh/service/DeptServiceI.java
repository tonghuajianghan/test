/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com,1908783076@qq.com
 * 创建时间：2016年4月21日 上午10:15:57 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.service;

import java.util.List;

import com.jh.vo.Dept;
import com.jh.vo.Users;

public interface DeptServiceI {
	/** 
	 * 练习使用resultMap作为返回值
	 *
	 * @Title: getDept 
	 * @Author: jianghan
	 * @param id
	 * @return
	 *    
	 */
	public Dept getDept(String id);
	public List<Dept> getDeptList();
	
	public List<Users> getUsersAssocationDept();
}
