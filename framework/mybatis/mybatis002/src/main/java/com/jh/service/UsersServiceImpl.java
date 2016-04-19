/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com,1908783076@qq.com
 * 创建时间：2016年4月19日 上午10:25:52 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.service;

import org.apache.ibatis.session.SqlSession;

import com.jh.dao.UsersMapper;
import com.jh.util.MySessionFactory;
import com.jh.vo.Users;

/**
 * users service 接口实现类 实现对用户表users 的逻辑处理
 *
 * @ClassName: UsersServiceImpl
 * @author jh
 * @date 2016年4月19日 上午10:26:18
 * 
 */
public class UsersServiceImpl implements UsersServiceI {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jh.service.UsersServiceI#getUserById(java.lang.String)
	 * 使用mybatis来实现接口
	 */
	@Override
	public Users getUserById(String id) {
		SqlSession sqlSession = null;
		UsersMapper usersMapper = null;
		try {
			sqlSession = MySessionFactory.getInstance().getSqlSessionFactory().openSession();
			usersMapper = sqlSession.getMapper(UsersMapper.class);
		} finally {
			sqlSession.close();
		}
		return usersMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertUsers(Users users) {
		SqlSession sqlSession = null;
		UsersMapper usersMapper = null;
		try {
			sqlSession = MySessionFactory.getInstance().getSqlSessionFactory().openSession();
			usersMapper = sqlSession.getMapper(UsersMapper.class);
			usersMapper.insertUsers(users);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
}
