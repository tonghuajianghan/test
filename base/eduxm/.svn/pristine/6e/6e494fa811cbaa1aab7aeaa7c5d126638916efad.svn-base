package cn.edu.cust.eduxm.project.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 项目负责人承担项目情况类
 * @author 王鹏程 2014-5-2
 *
 */
public class PrincipalProject {
	
	private int id;//承担项目编号
	private int xmid;//外键项目id
	private String xmmc;//项目名称
	private String xmlb;//项目类别
	private Date kssj;//开始时间
	private Date jssj;//结束时间
	private String pzdw;//批准单位
	private String zzje;//资助金额（万）
	private String ssxm;//所属项目
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getXmid() {
		return xmid;
	}
	public void setXmid(int xmid) {
		this.xmid = xmid;
	}
	public String getXmmc() {
		return xmmc;
	}
	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	public String getXmlb() {
		return xmlb;
	}
	public void setXmlb(String xmlb) {
		this.xmlb = xmlb;
	}
	public Date getKssj() {
		return kssj;
	}
	public void setKssj(Date kssj) {
		this.kssj = kssj;
	}
	public Date getJssj() {
		return jssj;
	}
	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}
	public String getPzdw() {
		return pzdw;
	}
	public void setPzdw(String pzdw) {
		this.pzdw = pzdw;
	}
	public String getZzje() {
		return zzje;
	}
	public void setZzje(String zzje) {
		this.zzje = zzje;
	}
	public String getSsxm() {
		return ssxm;
	}
	public void setSsxm(String ssxm) {
		this.ssxm = ssxm;
	}
	
	public void setFields(ResultSet rs) throws SQLException{
		id = rs.getInt("C_CDXM_ID");
		xmid = rs.getInt("C_XM_ID");
		xmmc = rs.getString("C_XMMC");
		xmlb = rs.getString("C_XMLB");
		kssj = rs.getDate("C_KSSJ");
		jssj = rs.getDate("C_JSSJ");
		pzdw = rs.getString("C_PZDW");
		zzje = rs.getString("C_ZZJE");
		ssxm = rs.getString("C_SSXM");
	}
	@Override
	public String toString() {
		return "PrincipalProject [id=" + id + ", xmid=" + xmid + ", xmmc="
				+ xmmc + ", xmlb=" + xmlb + ", kssj=" + kssj + ", jssj=" + jssj
				+ ", pzdw=" + pzdw + ", zzje=" + zzje + ", ssxm=" + ssxm + "]";
	}
	
}
