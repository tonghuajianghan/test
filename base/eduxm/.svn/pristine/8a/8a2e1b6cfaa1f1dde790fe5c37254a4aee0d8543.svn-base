package cn.edu.cust.eduxm.group.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Decision {
	private String xmlb;    //项目类别
	private String yjlx;    //研究类型
	private float psfs;
	private float passrate;
	
	public String getXmlb() {
		return xmlb;
	}

	public void setXmlb(String xmlb) {
		this.xmlb = xmlb;
	}

	public String getYjlx() {
		return yjlx;
	}

	public void setYjlx(String yjlx) {
		this.yjlx = yjlx;
	}
	

	public float getPsfs() {
		return psfs;
	}

	public void setPsfs(float psfs) {
		this.psfs = psfs;
	}
	
	public float getPassrate() {
		return passrate;
	}

	public void setPassrate(float passrate) {
		this.passrate = passrate;
	}

	public void setFields(ResultSet rs) throws SQLException{
		this.xmlb = rs.getString("c_xmlb");
		this.yjlx = rs.getString("c_yjlx");
		this.psfs = rs.getFloat("c_psfs");
	}
	
}
