package cn.edu.cust.eduxm.group.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Score {
	private int xm_id;       	 //项目id
	private String zjid; //专家id
	private int fs1;		//分数1
	private int fs2;		//分数2
	private int fs3;		//分数3
	private int fs4;		//分数4
	private int zf;			//总分
	
	public int getXm_id() {
		return xm_id;
	}

	public void setXm_id(int xm_id) {
		this.xm_id = xm_id;
	}

	public String getZjid() {
		return zjid;
	}

	public void setZjid(String zjid) {
		this.zjid = zjid;
	}

	public int getFs1() {
		return fs1;
	}

	public void setFs1(int fs1) {
		this.fs1 = fs1;
	}

	public int getFs2() {
		return fs2;
	}

	public void setFs2(int fs2) {
		this.fs2 = fs2;
	}

	public int getFs3() {
		return fs3;
	}

	public void setFs3(int fs3) {
		this.fs3 = fs3;
	}

	public int getFs4() {
		return fs4;
	}

	public void setFs4(int fs4) {
		this.fs4 = fs4;
	}
	
	public int getZf() {
		return zf;
	}
	
	public void setZf(int zf) {
		this.zf = zf;
	}

	public void setFields(ResultSet rs) throws SQLException{
		this.xm_id = rs.getInt("c_xm_id");
		this.zjid = rs.getString("c_zj_id");
		this.fs1 = rs.getInt("c_fs1");
		this.fs2 = rs.getInt("c_fs2");
		this.fs3 = rs.getInt("c_fs3");
		this.fs4 = rs.getInt("c_fs4");
		this.zf = rs.getInt("c_zf");
	}
}
