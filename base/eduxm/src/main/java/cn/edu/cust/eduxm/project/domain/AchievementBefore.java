package cn.edu.cust.eduxm.project.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 负责人和成员近期的研究成果类
 * @author 王鹏程 2014-5-2
 *
 */
public class AchievementBefore{
	
	private int id;// 成果编号
	private int xmid;//外键项目id
	private String cgmc;// 成果名称
	private String cgzz;// 成果作者
	private String cgxs;// 成果形式
	private String fbkw;// 发表刊物
	private Date fbsj;// 发表时间
	private String bz1;// 备注一
	private String bz2;// 备注二
	
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

	public String getCgmc() {
		return cgmc;
	}
	public void setCgmc(String cgmc) {
		this.cgmc = cgmc;
	}
	public String getCgzz() {
		return cgzz;
	}
	public void setCgzz(String cgzz) {
		this.cgzz = cgzz;
	}
	public String getCgxs() {
		return cgxs;
	}
	public void setCgxs(String cgxs) {
		this.cgxs = cgxs;
	}
	public String getFbkw() {
		return fbkw;
	}
	public void setFbkw(String fbkw) {
		this.fbkw = fbkw;
	}
	public Date getFbsj() {
		return fbsj;
	}
	public void setFbsj(Date fbsj) {
		this.fbsj = fbsj;
	}
	public String getBz1() {
		return bz1;
	}
	public void setBz1(String bz1) {
		this.bz1 = bz1;
	}
	public String getBz2() {
		return bz2;
	}
	public void setBz2(String bz2) {
		this.bz2 = bz2;
	}
	
	
	public void setFields(ResultSet rs) throws SQLException{
		id = rs.getInt("c_cg_id");
		xmid = rs.getInt("c_xm_id");
		cgmc = rs.getString("c_cgmc");
		cgzz = rs.getString("c_cgzz");
		cgxs = rs.getString("c_cgxs");
		fbkw = rs.getString("c_fbkw");
		fbsj = rs.getDate("c_fbsj");
		bz1 = rs.getString("c_bz1");
		bz2 = rs.getString("c_bz2");
	}
	@Override
	public String toString() {
		return "AchievementBefore [id=" + id + ", xmid=" + xmid + ", cgmc="
				+ cgmc + ", cgzz=" + cgzz + ", cgxs=" + cgxs + ", fbkw=" + fbkw
				+ ", fbsj=" + fbsj + ", bz1=" + bz1 + ", bz2=" + bz2 + "]";
	}
	
}
