package cn.edu.cust.rbac.domain;

import org.apache.shiro.SecurityUtils;

public class Org {
	
	public static final String KEY_ORG = "session_key_org_code";
	
	public static String getOrgCodeFromSession(){
		return (String)SecurityUtils.getSubject().getSession().getAttribute(KEY_ORG);
	}

}
