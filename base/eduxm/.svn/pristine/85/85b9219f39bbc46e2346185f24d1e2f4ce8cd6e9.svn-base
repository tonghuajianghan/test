package cn.edu.cust.eduxm.project.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 项目负责人
 * @author 王鹏程 2014-5-2
 *
 */
public class Principal {
	
	private int id;//负责人编号
	private String fzrxm;//负责人姓名
	private String xb;//性别
	private String mz;//民族
	private Date csny;//出生年月
	private String xzzw;//行政职务
	private String ywzw;//业务职务
	private String yjzc;//研究专长
	private String zhxl;//最后学历
	private String zhxw;//最后学位、、、、、、、、
	private String drds;//担任导师
	private String gzdw;//工作单位
	private String lxdh;//联系电话
	private String txdz;//通讯地址
	private String yb;//邮编
	private String sfdrqtxm;//是否担任其他项目
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFzrxm() {
		return fzrxm;
	}
	public void setFzrxm(String fzrxm) {
		this.fzrxm = fzrxm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public Date getCsny() {
		return csny;
	}
	public void setCsny(Date csny) {
		this.csny = csny;
	}
	public String getXzzw() {
		return xzzw;
	}
	public void setXzzw(String xzzw) {
		this.xzzw = xzzw;
	}
	public String getYwzw() {
		return ywzw;
	}
	public void setYwzw(String ywzw) {
		this.ywzw = ywzw;
	}
	public String getYjzc() {
		return yjzc;
	}
	public void setYjzc(String yjzc) {
		this.yjzc = yjzc;
	}
	public String getZhxl() {
		return zhxl;
	}
	public void setZhxl(String zhxl) {
		this.zhxl = zhxl;
	}
	public String getDrds() {
		return drds;
	}
	public void setDrds(String drds) {
		this.drds = drds;
	}
	public String getGzdw() {
		return gzdw;
	}
	public void setGzdw(String gzdw) {
		this.gzdw = gzdw;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getTxdz() {
		return txdz;
	}
	public void setTxdz(String txdz) {
		this.txdz = txdz;
	}
	public String getYb() {
		return yb;
	}
	public void setYb(String yb) {
		this.yb = yb;
	}
	public String getSfdrqtxm() {
		return sfdrqtxm;
	}
	public void setSfdrqtxm(String sfdrqtxm) {
		this.sfdrqtxm = sfdrqtxm;
	}
	
	public String getZhxw() {
		return zhxw;
	}
	public void setZhxw(String zhxw) {
		this.zhxw = zhxw;
	}
	public void setFields(ResultSet rs) throws SQLException{
		id = rs.getInt("c_fzr_id");
		fzrxm = rs.getString("c_fzrxm");
		xb = rs.getString("c_xb");
		mz = rs.getString("c_mz");
		csny = rs.getDate("c_csny");
		xzzw = rs.getString("c_xzzw");
		ywzw = rs.getString("c_ywzw");
		yjzc = rs.getString("c_yjzc");
		zhxl = rs.getString("c_zhxl");
		zhxl = rs.getString("c_zhxw");
		drds = rs.getString("c_drds");
		gzdw = rs.getString("c_gzdw");
		lxdh = rs.getString("c_lxdh");
		txdz = rs.getString("c_txdz");
		yb = rs.getString("c_yb");
		sfdrqtxm = rs.getString("c_sfdrqtxm");
		
	}
	@Override
	public String toString() {
		return "Principal [id=" + id + ", fzrxm=" + fzrxm + ", xb=" + xb
				+ ", mz=" + mz + ", csny=" + csny + ", xzzw=" + xzzw
				+ ", ywzw=" + ywzw + ", yjzc=" + yjzc + ", zhxl=" + zhxl
				+ ", zhxw=" + zhxw + ", drds=" + drds + ", gzdw=" + gzdw
				+ ", lxdh=" + lxdh + ", txdz=" + txdz + ", yb=" + yb
				+ ", sfdrqtxm=" + sfdrqtxm + "]";
	}
	
}
