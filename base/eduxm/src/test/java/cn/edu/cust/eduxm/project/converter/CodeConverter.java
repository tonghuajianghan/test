package cn.edu.cust.eduxm.project.converter;

import java.io.File;
import java.util.HashMap;

import cn.edu.cust.codelib.CodeLib;

public class CodeConverter implements Converter {
	
	private static HashMap<String, HashMap<String,String>> codelib;
	
	static{
		try{
			codelib = new CodeLib().loadCodeLibs(new File("src/main/webapp/code/admin/codelibs.json"), new File("src/main/webapp/code"), "text", "id");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private String name;
	
	public CodeConverter(String name){
		this.name = name;
	}

	@Override
	public Object convert(String value) {
		// TODO Auto-generated method stub
		return codelib.get(name).get(value);
		//return null;
	}

}
