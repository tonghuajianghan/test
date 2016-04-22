/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com,1908783076@qq.com
 * 创建时间：2016年4月21日 上午10:16:30 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jh.dao.DeptMapper;
import com.jh.util.MySessionFactory;
import com.jh.vo.Dept;
import com.jh.vo.Users;

public class DeptServiceImpl implements DeptServiceI {
	@Override
	public Dept getDept(String id){
		SqlSession sqlSession = null;
		DeptMapper deptMapper = null;
		Dept dept = null;
		try {
			sqlSession = MySessionFactory.getInstance().getSqlSessionFactory().openSession();
			deptMapper = sqlSession.getMapper(DeptMapper.class);
			dept = deptMapper.selectByPrimaryKey(id);
		} finally {
			sqlSession.close();
		}
		return dept;
	}

	@Override
	public List<Dept> getDeptList() {
		SqlSession sqlSession = null;
		DeptMapper deptMapper = null;
		List<Dept> deptList = null;
		try {
			sqlSession = MySessionFactory.getInstance().getSqlSessionFactory().openSession();
			deptMapper = sqlSession.getMapper(DeptMapper.class);
			deptList = deptMapper.selectDeptList();
		} finally {
			sqlSession.close();
		}
		return deptList;
	}

	@Override
	public List<Users> getUsersAssocationDept() {
		SqlSession sqlSession = null;
		DeptMapper deptMapper = null;
		List<Users> usersList = null;
		try {
			sqlSession = MySessionFactory.getInstance().getSqlSessionFactory().openSession();
			deptMapper = sqlSession.getMapper(DeptMapper.class);
			usersList = deptMapper.selectDeptAndUsers();
		} finally {
			sqlSession.close();
		}
		return usersList;
	}

	@Override
	public List<Dept> getDeptCollectionUsers() {
		SqlSession sqlSession = null;
		DeptMapper deptMapper = null;
		List<Dept> deptList = null;
		try {
			sqlSession = MySessionFactory.getInstance().getSqlSessionFactory().openSession();
			deptMapper = sqlSession.getMapper(DeptMapper.class);
			deptList = deptMapper.selectDeptCollectionUsers();
		} finally {
			sqlSession.close();
		}
		return deptList;
	}
}
