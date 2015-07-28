package cn.edu.cust.eduxm.group.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Group {
	//id
	private int id;
	//分组名称
	private String groupName;
	//专业领域
	private String groupField;
	//年度
	private String year;
	//组长
	private int headman;
	//分组说明
	private String groupExplain;
	//备注
	private String remark;
	//最多人数
	private int maxManCount;
	//最多项目数
	private int maxProjectCount;
	//项目数
	private int projectCount;
	//专家人数
	private int manCount;

	public int getProjectCount() {
		return projectCount;
	}

	public void setProjectCount(int projectCount) {
		this.projectCount = projectCount;
	}

	public int getManCount() {
		return manCount;
	}

	public void setManCount(int manCount) {
		this.manCount = manCount;
	}

	public int getMaxManCount() {
		return maxManCount;
	}

	public void setMaxManCount(int maxManCount) {
		this.maxManCount = maxManCount;
	}

	public int getMaxProjectCount() {
		return maxProjectCount;
	}

	public void setMaxProjectCount(int maxProjectCount) {
		this.maxProjectCount = maxProjectCount;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupField() {
		return groupField;
	}

	public void setGroupField(String groupField) {
		this.groupField = groupField;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGroupExplain() {
		return groupExplain;
	}

	public void setGroupExplain(String groupExplain) {
		this.groupExplain = groupExplain;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public void setFields(ResultSet rs) throws SQLException{
		this.id=rs.getInt("C_ZJZ_ID");
		this.groupName=rs.getString("C_ZJZMC");
		this.groupField=rs.getString("C_ZYLY");
		this.year=rs.getString("C_ND");
		this.headman=rs.getInt("C_ZZ");
		this.groupExplain=rs.getString("C_ZJZSM");
		this.remark=rs.getString("C_BZ");
		this.maxManCount=rs.getInt("C_ZDRS");
		this.maxProjectCount=rs.getInt("C_ZDXMS");
		this.projectCount=rs.getInt("C_XMS");
		this.manCount=rs.getInt("C_RS");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHeadman() {
		return headman;
	}

	public void setHeadman(int headman) {
		this.headman = headman;
	}
	
}
