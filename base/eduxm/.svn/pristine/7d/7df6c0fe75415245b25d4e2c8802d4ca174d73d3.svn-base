package cn.edu.cust.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyJdbcRealm extends JdbcRealm {
	
	private static final Logger log = LoggerFactory.getLogger(MyJdbcRealm.class);

	@Override
	protected Set<String> getRoleNamesForUser(Connection conn, String username)
			throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<String> roleNames = new LinkedHashSet<String>();
		try {
			ps = conn.prepareStatement(userRolesQuery);
			ps.setString(1, username);

			// Execute query
			rs = ps.executeQuery();

			// Loop over results and add each returned role to a set
			if (rs.next()) {

				String roles = rs.getString(1);

				// Add the role to the list of names if it isn't null
				if (roles != null) {
					String[] roleArr = roles.split(",");
					for (String role : roleArr) {
						roleNames.add(role);
					}
				} else {
					if (log.isWarnEnabled()) {
						log.warn("Null role name found while retrieving role names for user ["
								+ username + "]");
					}
				}
			}
		} finally {
			JdbcUtils.closeResultSet(rs);
			JdbcUtils.closeStatement(ps);
		}
		return roleNames;
	}

}
