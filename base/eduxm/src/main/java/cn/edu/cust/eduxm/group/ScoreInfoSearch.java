package cn.edu.cust.eduxm.group;

import java.util.HashMap;
import java.util.Map;

import cn.edu.cust.util.search.ColumnType;
import cn.edu.cust.util.search.Search;

public class ScoreInfoSearch extends Search {
	private static Map<String, ColumnType> columnsSet;
	
	static{
		columnsSet = new HashMap<String, ColumnType>();
		columnsSet.put("-", ColumnType.STRING);
		columnsSet.put("C_XMFS_ID", ColumnType.INT);
		columnsSet.put("C_XM_ID", ColumnType.INT);
		columnsSet.put("C_USERNAME", ColumnType.STRING);
		columnsSet.put("C_FS1", ColumnType.INT);
		columnsSet.put("C_FS2", ColumnType.INT);
		columnsSet.put("C_FS3", ColumnType.INT);
		columnsSet.put("C_FS4", ColumnType.INT);
		
		
	}

	@Override
	protected Map<String, ColumnType> getColumnsSet() {
		return columnsSet;
	}

	@Override
	protected String getTables() {
		return "C_GROUP";
	}

	@Override
	protected String getProjections() {
		return "*";
	}
	
	//sql语句获取分组信息——拼最大项目数（group）、专业
	public String buildSQLToGroupList(String zjid){
		
		return "select * from c_group where c_zjz_id = (select c_zjz_id from c_group_expert where c_zj_id='"+zjid+"')";
	}
	
	
	
}