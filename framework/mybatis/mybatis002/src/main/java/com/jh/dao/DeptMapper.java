/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com,1908783076@qq.com
 * 创建时间：2016年4月19日 下午11:19:10 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.dao;

import java.util.List;

import com.jh.vo.Dept;
import com.jh.vo.Users;

public interface DeptMapper {
	public Dept selectByPrimaryKey(String id);
	public List<Dept> selectDeptList();
	public List<Users> selectDeptAndUsers();
	public List<Dept> selectDeptCollectionUsers();

}
