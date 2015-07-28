package cn.edu.cust.eduxm.project;

import java.util.HashMap;
import java.util.Map;

import cn.edu.cust.util.search.ColumnType;
import cn.edu.cust.util.search.Search;


public class PrincipalSearch extends Search {
private static Map<String, ColumnType> columnsSet;
	
	static{
		columnsSet = new HashMap<String, ColumnType>();
		columnsSet.put("-", ColumnType.STRING);
		columnsSet.put("c_xm_id ", ColumnType.INT);
		columnsSet.put("c_zjz_id ", ColumnType.INT);
		columnsSet.put("c_xyh_id", ColumnType.INT);
		columnsSet.put("c_yjbh_id", ColumnType.INT);
		columnsSet.put("c_zt", ColumnType.STRING);
		columnsSet.put("c_xmnbbh_id", ColumnType.INT);
		columnsSet.put("c_xmmc", ColumnType.STRING);
		columnsSet.put("c_sqnd ", ColumnType.STRING);
		columnsSet.put("c_cgxs", ColumnType.STRING);
		columnsSet.put("c_kssj", ColumnType.DATE);
		columnsSet.put("c_jssj", ColumnType.DATE);
		columnsSet.put("c_jhwcsj", ColumnType.DATE);
		columnsSet.put("c_xmlb", ColumnType.STRING);
		columnsSet.put("c_yjlx", ColumnType.STRING);
		columnsSet.put("c_xkmc", ColumnType.STRING);
		columnsSet.put("c_xkdm", ColumnType.STRING);
		columnsSet.put("c_tbsj", ColumnType.DATE);
		columnsSet.put("c_ysze", ColumnType.FLOAT);
		columnsSet.put("c_sqze", ColumnType.FLOAT);
		columnsSet.put("c_sqmx", ColumnType.STRING);
		columnsSet.put("c_zcze", ColumnType.FLOAT);
		columnsSet.put("c_zcmx", ColumnType.STRING);
		columnsSet.put("c_sqcn", ColumnType.STRING);
		columnsSet.put("c_xswyhyj", ColumnType.STRING);
		columnsSet.put("c_fzrdwyj", ColumnType.STRING);
		columnsSet.put("c_shzt1", ColumnType.INT);
		columnsSet.put("c_psfs", ColumnType.FLOAT);
		columnsSet.put("c_psjg", ColumnType.STRING);
		columnsSet.put("c_jgsm", ColumnType.STRING);
		columnsSet.put("c_tbr", ColumnType.INT);
		columnsSet.put("c_bz1", ColumnType.STRING);
		columnsSet.put("c_bz2", ColumnType.STRING);
		columnsSet.put("c_bz3", ColumnType.STRING);
		columnsSet.put("c_bz4", ColumnType.STRING);
	}

	@Override
	protected Map<String, ColumnType> getColumnsSet() {
		// TODO Auto-generated method stub
		return columnsSet;
	}

	@Override
	protected String getTables() {
		// TODO Auto-generated method stub
		return "C_PRINCIPAL";
	}

	@Override
	protected String getProjections() {
		// TODO Auto-generated method stub
		return "*";
	}
}
