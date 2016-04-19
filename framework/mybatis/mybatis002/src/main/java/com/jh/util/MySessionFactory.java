/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com,1908783076@qq.com
 * 创建时间：2016年4月19日 上午10:00:20 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package com.jh.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 我的mybatis会话工厂实现类 ,单例实现SqlSessionFactory
 *
 * @ClassName: MySessionFactory
 * @author jh
 * @date 2016年4月19日 上午10:00:25
 * 
 */
public class MySessionFactory {
	private static MySessionFactory mySessionFactory = null;

	private MySessionFactory() {

	}

	public synchronized static MySessionFactory getInstance() {
		if (mySessionFactory == null) {
			mySessionFactory = new MySessionFactory();
		}
		return mySessionFactory;

	}

	/** 
	 * 从 XML 中构建 SqlSessionFactory
	 *
	 * @Title: getSqlSessionFactory 
	 * @Author: jianghan
	 * @return
	 *    
	 */
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		SqlSessionFactory sqlSessionFactory = null;
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}

}
