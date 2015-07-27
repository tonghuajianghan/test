package cn.edu.cust.eduxm.expert;

import java.util.HashMap;
import java.util.Map;

import cn.edu.cust.util.search.ColumnType;
import cn.edu.cust.util.search.Search;

public class ExpertInfoSearch extends Search{
	
	private static Map<String, ColumnType> columnsSet;
	
	static{
		columnsSet = new HashMap<String, ColumnType>();
		columnsSet.put("-", ColumnType.STRING);
		columnsSet.put("C_USERNAME", ColumnType.STRING);
		columnsSet.put("C_XM", ColumnType.STRING);
		columnsSet.put("C_XB", ColumnType.STRING);
		columnsSet.put("C_ZC", ColumnType.STRING);
		columnsSet.put("C_ZW", ColumnType.STRING);
		columnsSet.put("C_ZYLY", ColumnType.STRING);
		columnsSet.put("C_YJFX", ColumnType.STRING);
		columnsSet.put("C_CSNY", ColumnType.STRING);
		columnsSet.put("C_SSDW", ColumnType.STRING);
		columnsSet.put("C_DZYJ", ColumnType.STRING);
		columnsSet.put("C_LXDH", ColumnType.STRING);
		columnsSet.put("C_ZPLJ", ColumnType.STRING);
		columnsSet.put("C_ZT", ColumnType.STRING);
		columnsSet.put("C_ZJJJ", ColumnType.STRING);
		columnsSet.put("C_BZ", ColumnType.STRING);
		
	}

	@Override
	protected Map<String, ColumnType> getColumnsSet() {
		// TODO Auto-generated method stub
		return columnsSet;
	}

	@Override
	protected String getTables() {
		// TODO Auto-generated method stub
		return "C_EXPERT";
	}

	@Override
	protected String getProjections() {
		// TODO Auto-generated method stub
		return "*";
	}
	
}
