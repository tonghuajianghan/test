package cn.edu.cust.demo;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

public class MyAuthentication implements AuthenticationProvider {
	private static Logger log = Logger.getLogger(MyAuthentication.class);
	public Authentication authenticate(Authentication arg0)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		log.info("user:" + arg0.getPrincipal() + "," + arg0.getName());
		String user = (String)arg0.getPrincipal();
		final String pass = (String)arg0.getCredentials();
		if("test".equals(user)){
			return new Authentication(){

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public Collection<GrantedAuthority> getAuthorities() {
					// TODO Auto-generated method stub
					ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
					roles.add(new GrantedAuthority(){

						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;

						public String getAuthority() {
							// TODO Auto-generated method stub
							return "ROLE_comm";
						}
						
					});
					return roles;
				}

				public Object getCredentials() {
					// TODO Auto-generated method stub
					return pass;
				}

				public Object getDetails() {
					// TODO Auto-generated method stub
					return null;
				}

				public Object getPrincipal() {
					// TODO Auto-generated method stub
					return "test";
				}

				public boolean isAuthenticated() {
					// TODO Auto-generated method stub
					return true;
				}

				public void setAuthenticated(boolean arg0)
						throws IllegalArgumentException {
					// TODO Auto-generated method stub
					
				}

				public String getName() {
					// TODO Auto-generated method stub
					return "test";
				}
				
			};
		}
		return null;
	}

	public boolean supports(Class<? extends Object> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
