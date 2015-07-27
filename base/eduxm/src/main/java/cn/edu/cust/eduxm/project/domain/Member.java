package cn.edu.cust.eduxm.project.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 项目成员情况类
 * @author 王鹏程   2014-5-2
 *
 */
/**
 * @author Administrator
 *
 */
public class Member {
	
	private int id;//成员编号
	private int xm_id;//项目表外键
	private String xm;//姓名
	private String xb;//性别
	private Date csny;///出生年月
	private String zyzw;//专业职务
	private String yjzc;//研究专长
	private String xlxw;//学历学位
	private String dw;//单位
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getZyzw() {
		return zyzw;
	}
	public void setZyzw(String zyzw) {
		this.zyzw = zyzw;
	}
	public String getYjzc() {
		return yjzc;
	}
	public void setYjzc(String yjzc) {
		this.yjzc = yjzc;
	}
	public String getXlxw() {
		return xlxw;
	}
	public void setXlxw(String xlxw) {
		this.xlxw = xlxw;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public int getXm_id() {
		return xm_id;
	}
	public void setXm_id(int xm_id) {
		this.xm_id = xm_id;
	}
	
	public Date getCsny() {
		return csny;
	}
	public void setCsny(Date csny) {
		this.csny = csny;
	}
	public void setFields(ResultSet rs) throws SQLException{
		id = rs.getInt("c_cy_id");
		xm_id = rs.getInt("c_xm_id");
		xm = rs.getString("c_xm");
		xb = rs.getString("c_xb");
		csny = rs.getDate("c_csny");
		zyzw = rs.getString("c_zyzw");
		yjzc = rs.getString("c_yjzc");
		xlxw = rs.getString("c_xlxw");
		dw = rs.getString("c_dw");
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", xm_id=" + xm_id + ", xm=" + xm + ", xb="
				+ xb + ", csny=" + csny + ", zyzw=" + zyzw + ", yjzc=" + yjzc
				+ ", xlxw=" + xlxw + ", dw=" + dw + "]";
	}
	
	
}
