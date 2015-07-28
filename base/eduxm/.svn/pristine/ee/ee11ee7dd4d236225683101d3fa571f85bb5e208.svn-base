package cn.edu.cust.eduxm.group.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignExpert {
	
	private int id;
	
	private int teamId;
	
	private String expertId;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getExpertId() {
		return expertId;
	}

	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}
	
	public void setFields(ResultSet rs) throws SQLException{
		this.id=rs.getInt("C_ZJFZ_ID");
		this.teamId=rs.getInt("C_ZJZ_ID");
		this.expertId=rs.getString("C_ZJ_ID");
	}

	

}
