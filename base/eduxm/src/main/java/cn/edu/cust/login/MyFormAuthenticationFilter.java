package cn.edu.cust.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.JdbcUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import cn.edu.cust.rbac.domain.Org;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		Connection conn = dataSource.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			String p = subject.getPrincipal().toString();
			ps = conn.prepareStatement("select c_orgcode from c_user where c_username=?");
			ps.setString(1, p);
			rs = ps.executeQuery();
			if(rs.next()){
				subject.getSession().setAttribute(Org.KEY_ORG, rs.getString(1));
			}
		}finally{
			JdbcUtils.closeResultSet(rs);
			JdbcUtils.closeStatement(ps);
			JdbcUtils.closeConnection(conn);
		}
		return super.onLoginSuccess(token, subject, request, response);
	}

	@Override
	protected AuthenticationToken createToken(ServletRequest request,
			ServletResponse response) {
		// TODO Auto-generated method stub
		String username = getUsername(request);
		String password = getPassword(request);
		boolean rememberMe = isRememberMe(request);
		String host = getHost(request);
		String status = request.getParameter("status");
		return new MyUsernamePasswordToken(username, password, rememberMe,
				host, status);
	}

}
