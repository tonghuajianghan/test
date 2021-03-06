/*------------------------------------------------------------------------- 
 * 版权所有：
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com,1908783076@qq.com
 * 创建时间：2016年4月21日 上午10:24:54 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package serviceTest;

import java.util.List;

import org.junit.Test;

import com.jh.service.DeptServiceI;
import com.jh.service.DeptServiceImpl;
import com.jh.vo.Dept;
import com.jh.vo.Users;

public class DeptServiceITest {
	
	private DeptServiceI deptServiceI;

	//@Test
	public void testGetDept() {
		//fail("Not yet implemented");
		deptServiceI = new DeptServiceImpl();
		Dept dept = deptServiceI.getDept("1");
		System.out.println(dept.getName());
	}

	//@Test
	public void testGetDeptList(){
		deptServiceI = new DeptServiceImpl();
		List<Dept> deptList = deptServiceI.getDeptList();
		for(Dept dept : deptList){
			System.out.println(dept.getName());
		}
	}
	
	@Test
	public void testGetUsersAssocationDept(){
		deptServiceI = new DeptServiceImpl();
		List<Users> usersList = deptServiceI.getUsersAssocationDept();
		for(Users users : usersList){
			System.out.println(users.getDept().getName());
		}
	}
	
	//@Test
	public void testgetDeptCollectionUsers(){
		deptServiceI = new DeptServiceImpl();
		List<Dept> deptList = deptServiceI.getDeptCollectionUsers();
		for(Dept dept : deptList){
			System.out.println(dept.getUsers().get(0).getName());
		}
	}
}
