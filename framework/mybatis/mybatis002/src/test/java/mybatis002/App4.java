package mybatis002;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jh.dao.UsersMapper;
import com.jh.vo.Users;

/**
 * Hello world! 
 * mvn项目quick start 项目自动生成的开始类
 * 直观的总体测试类，可以看清整个执行过程
 */
public class App4 {
	public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
			//删除
			usersMapper.deleteByPrimaryKey("1");
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}