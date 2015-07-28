package cn.edu.cust.login;

import org.apache.shiro.authc.UsernamePasswordToken;

public class MyUsernamePasswordToken extends UsernamePasswordToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String status;

	public MyUsernamePasswordToken(String username, String password,
			boolean rememberMe, String host, String status) {
		super(username, password, rememberMe, host);
		// TODO Auto-generated constructor stub
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
