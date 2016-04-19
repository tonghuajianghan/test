/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com,1908783076@qq.com
 * 创建时间：2016年4月19日 上午11:04:21 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package serviceTest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jh.service.UsersServiceI;
import com.jh.service.UsersServiceImpl;
import com.jh.vo.Users;

/** 
 * 使用完成的一套体系测试mybatis
 *
 * @ClassName: UsersServiceITest 
 * @author jh 
 * @date 2016年4月19日 上午11:11:48 
 *  
 */
public class UsersServiceITest {
	
	private UsersServiceI usersServiceI;

	@Test
	public void testGetUserById() {
		//fail("Not yet implemented");
		usersServiceI = new UsersServiceImpl();
		Users users = usersServiceI.getUserById("1");
		System.out.println(users.getName());
	}

}
