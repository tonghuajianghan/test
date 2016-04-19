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
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		//mybatis 的配置文件
		String resource = "mybatis-config.xml";
		Reader reader;//涉及到io，因此需要catch io 异常
		try {
			//使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
			reader = Resources.getResourceAsReader(resource);
			 //构建sqlSession的工厂
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//创建能执行映射文件中sql的sqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//用mybatis实现借口
			UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
			Users user = usersMapper.selectByPrimaryKey("1");
			System.out.println(user.getName());
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}