package cn.edu.cust.eduxm.group;

import java.util.HashMap;
import java.util.Map;

import cn.edu.cust.util.search.ColumnType;
import cn.edu.cust.util.search.Search;

public class DecisionSearch extends Search {
	
	private static Map<String, ColumnType> columnsSet;
	
	static{
		columnsSet = new HashMap<String, ColumnType>();
		columnsSet.put("-", ColumnType.STRING);
		columnsSet.put("c_xmlb", ColumnType.STRING);
		columnsSet.put("c_yjlx", ColumnType.STRING);
	}

	@Override
	protected Map<String, ColumnType> getColumnsSet() {
		// TODO Auto-generated method stub
		return columnsSet;
	}

	@Override
	protected String getTables() {
		// TODO Auto-generated method stub
		return "C_PROJECT";
	}

	@Override
	protected String getProjections() {
		// TODO Auto-generated method stub
		return "*";
	}

}
