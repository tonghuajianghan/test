package cn.edu.cust.eduxm.util;

import cn.edu.cust.util.OraclePage;
import cn.edu.cust.util.Page;

public class PageFactory {
	
	public static Page getPage(){
		return new OraclePage();
	}

}
