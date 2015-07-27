package cn.edu.cust.eduxm.group;

import java.util.HashMap;
import java.util.Map;

import cn.edu.cust.util.search.ColumnType;
import cn.edu.cust.util.search.Search;

public class GroupInfoSearch extends Search{
	
	private static Map<String, ColumnType> columnsSet;
	
	static{
		columnsSet = new HashMap<String, ColumnType>();
		columnsSet.put("-", ColumnType.STRING);
		columnsSet.put("C_ZJZ_ID", ColumnType.INT);
		columnsSet.put("C_ZJZMC", ColumnType.STRING);
		columnsSet.put("C_ZYLY", ColumnType.STRING);
		columnsSet.put("C_ND", ColumnType.STRING);
		columnsSet.put("C_ZZ", ColumnType.INT);
		columnsSet.put("C_ZJZSM", ColumnType.STRING);
		columnsSet.put("C_BZ", ColumnType.STRING);
		columnsSet.put("C_ZDRS", ColumnType.INT);
		columnsSet.put("C_ZDXMS", ColumnType.INT);
		
	}

	@Override
	protected Map<String, ColumnType> getColumnsSet() {
		// TODO Auto-generated method stub
		return columnsSet;
	}

	@Override
	protected String getTables() {
		// TODO Auto-generated method stub
		return "C_GROUP";
	}

	@Override
	protected String getProjections() {
		// TODO Auto-generated method stub
		return "*";
	}
	
	public String buildSQLToCrew(String groupField){
		return "select * from C_EXPERT where c_zyly='"+groupField+"'";
	}
	
	//评审打分——获得评审所在评审组
	public String buildSQLToGroupList(String zjid){
//		select * from c_group join c_group_expert on c_group.c_zjz_id=c_group_expert.c_zjz_id and c_group_expert.c_zj_id='ff'
		return "select * from c_group where c_zjz_id in (select c_zjz_id from c_group_expert where c_zj_id='"+zjid+"')";
	}
	
	
}
