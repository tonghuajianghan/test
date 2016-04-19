/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com,1908783076@qq.com
 * 创建时间：2016年4月19日 上午10:25:10 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.service;

import com.jh.vo.Users;

/** 
 * 	users service 实现借口
 *
 * @ClassName: UsersServiceI 
 * @author jh 
 * @date 2016年4月19日 上午10:25:59 
 *  
 */
public interface UsersServiceI {
	public Users getUserById(String id);
	public void insertUsers(Users users);
}
