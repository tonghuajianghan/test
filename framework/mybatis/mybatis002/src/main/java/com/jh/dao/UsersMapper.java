/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com,1908783076@qq.com
 * 创建时间：2016年4月18日 下午9:16:12 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dao;

import com.jh.vo.Users;

/** 
 * 用于调用User.xml的接口
 *
 * @ClassName: UsersMapper 
 * @author jh 
 * @date 2016年4月18日 下午9:18:04 
 *  
 */
public interface UsersMapper {
	
	/** 
	 * 根据主键查询用户表
	 *
	 * @Title: selectByPrimaryKey 
	 * @Author: jianghan
	 * @param id
	 * @return
	 *    
	 */
	public Users selectByPrimaryKey(String id);
	
	/** 
	 * 根据主键删除用户表
	 *
	 * @Title: deleteByPrimaryKey 
	 * @Author: jianghan
	 * @param id
	 * @return
	 *    
	 */
	public int deleteByPrimaryKey(String id);
	
	public void insertUsers(Users users);
	
	public void updateUsers(Users users);
}
