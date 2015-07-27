package cn.edu.cust.demo;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {
	
	private final static Logger LOG = Logger.getLogger(MyUserDetailsService.class);

	/**
	 * fullusername就是sso给demo返回的用户信息
	 * 用户信息格式是u_id+空格+u_role+空格+u_email
	 * 方法的第一行即输出了fullusername
	 * 
	 * 用户可以自定义MyDetails的属性，根据具体的业务需求
	 * 
	 */
	public UserDetails loadUserByUsername(String fullusername)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		LOG.info(fullusername);
		
		return new MyDetails(fullusername);
	}

}
