package vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Person {
	private int id;
	private int xh;// 序号
	private int nbbh;// 内部编号
	private String xmbh;// 姓名编号
	private int djnd = 1;//到今年底
	private String xm;// 姓名
	private String xb;// 性别
	private Timestamp csrq;//出生日期
	private String xl_val;
	private String zc_val;
	private String sxzy;
	private String cdrw;
	private String szdw_val;
	private String sf_val;
	private String xw;
	private Timestamp djbdate;
	private int jsr;
	private Timestamp logindate;
	private int xgr;
	private Timestamp ModifyDate;
	private Boolean flg;
	private Timestamp deleteDate;
	private String sfzh;
	private BigDecimal gzl;
	private String payCode;
	
	public Person(){
		super();
		this.djnd = 1;
	}

	public Person(Person p) {
		this.djnd = p.getDjnd() + 1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getXh() {
		return xh;
	}

	public void setXh(int xh) {
		this.xh = xh;
	}

	public int getNbbh() {
		return nbbh;
	}

	public void setNbbh(int nbbh) {
		this.nbbh = nbbh;
	}

	public String getXmbh() {
		return xmbh;
	}

	public void setXmbh(String xmbh) {
		this.xmbh = xmbh;
	}

	public int getDjnd() {
		return djnd;
	}

	public void setDjnd(int djnd) {
		this.djnd = djnd;
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

	public Timestamp getCsrq() {
		return csrq;
	}

	public void setCsrq(Timestamp csrq) {
		this.csrq = csrq;
	}

	public String getXl_val() {
		return xl_val;
	}

	public void setXl_val(String xl_val) {
		this.xl_val = xl_val;
	}

	public String getZc_val() {
		return zc_val;
	}

	public void setZc_val(String zc_val) {
		this.zc_val = zc_val;
	}

	public String getSxzy() {
		return sxzy;
	}

	public void setSxzy(String sxzy) {
		this.sxzy = sxzy;
	}

	public String getCdrw() {
		return cdrw;
	}

	public void setCdrw(String cdrw) {
		this.cdrw = cdrw;
	}

	public String getSzdw_val() {
		return szdw_val;
	}

	public void setSzdw_val(String szdw_val) {
		this.szdw_val = szdw_val;
	}

	public String getSf_val() {
		return sf_val;
	}

	public void setSf_val(String sf_val) {
		this.sf_val = sf_val;
	}

	public String getXw() {
		return xw;
	}

	public void setXw(String xw) {
		this.xw = xw;
	}

	public Timestamp getDjbdate() {
		return djbdate;
	}

	public void setDjbdate(Timestamp djbdate) {
		this.djbdate = djbdate;
	}

	public int getJsr() {
		return jsr;
	}

	public void setJsr(int jsr) {
		this.jsr = jsr;
	}

	public Timestamp getLogindate() {
		return logindate;
	}

	public void setLogindate(Timestamp logindate) {
		this.logindate = logindate;
	}

	public int getXgr() {
		return xgr;
	}

	public void setXgr(int xgr) {
		this.xgr = xgr;
	}

	public Timestamp getModifyDate() {
		return ModifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		ModifyDate = modifyDate;
	}

	public Boolean getFlg() {
		return flg;
	}

	public void setFlg(Boolean flg) {
		this.flg = flg;
	}

	public Timestamp getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Timestamp deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getSfzh() {
		return sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public BigDecimal getGzl() {
		return gzl;
	}

	public void setGzl(BigDecimal gzl) {
		this.gzl = gzl;
	}

	public String getPayCode() {
		return payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}
	

}
