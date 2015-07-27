package cn.edu.cust.demo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4660407095933835689L;
	
	private String id;
	private ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	private String email;
	
	public MyDetails(String fullusername){
		int start = 0;
		int end = fullusername.indexOf(' ');
		id = fullusername.substring(start, end);
		start = end + 1;
		end = fullusername.indexOf(' ', start);
		authorities.add(new SimpleGrantedAuthority("ROLE_" + fullusername.substring(start, end++)));
		email = fullusername.substring(end);
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getEmail() {
		return email;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
