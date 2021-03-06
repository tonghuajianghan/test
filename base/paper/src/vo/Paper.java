package vo;

import java.sql.Timestamp;


public class Paper{
	private int id;
	private String lwtm;//论文题目
	private String szdw;//所在单位
	private String kwmc;//刊物名称
	private String dyzz;//第一作者
	private String kwqh;//刊物期号
	private String kwjh;//刊物卷号
	private String kwkh;//刊物刊号
	private String kwy1;//刊物页1
	private String kwy2;//刊物页2
	private String kwlb;//刊物类别
	private String kwjb;//刊物级别
	private Timestamp fbrq;//发表日期
	private String jsqk;//经手情况
	private Teacher jsh;//经手号（人）
	private Double yxyz;//影响因子
	private Double sqjl;//申请奖励
	private Teacher djr;//登记人
	private Timestamp djrq;//登记日期


	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Teacher getJsh() {
		return jsh;
	}

	public void setJsh(Teacher jsh) {
		this.jsh = jsh;
	}

	public Teacher getDjr() {
		return djr;
	}

	public void setDjr(Teacher djr) {
		this.djr = djr;
	}

	public String getLwtm() {
		return this.lwtm;
	}

	public void setLwtm(String lwtm) {
		this.lwtm = lwtm;
	}

	public String getSzdw() {
		return this.szdw;
	}

	public void setSzdw(String szdw) {
		this.szdw = szdw;
	}

	public String getKwmc() {
		return this.kwmc;
	}

	public void setKwmc(String kwmc) {
		this.kwmc = kwmc;
	}

	public String getDyzz() {
		return this.dyzz;
	}

	public void setDyzz(String dyzz) {
		this.dyzz = dyzz;
	}

	public String getKwqh() {
		return this.kwqh;
	}

	public void setKwqh(String kwqh) {
		this.kwqh = kwqh;
	}

	public String getKwjh() {
		return this.kwjh;
	}

	public void setKwjh(String kwjh) {
		this.kwjh = kwjh;
	}

	public String getKwkh() {
		return this.kwkh;
	}

	public void setKwkh(String kwkh) {
		this.kwkh = kwkh;
	}

	public String getKwy1() {
		return this.kwy1;
	}

	public void setKwy1(String kwy1) {
		this.kwy1 = kwy1;
	}

	public String getKwy2() {
		return this.kwy2;
	}

	public void setKwy2(String kwy2) {
		this.kwy2 = kwy2;
	}

	public String getKwlb() {
		return this.kwlb;
	}

	public void setKwlb(String kwlb) {
		this.kwlb = kwlb;
	}

	public String getKwjb() {
		return this.kwjb;
	}

	public void setKwjb(String kwjb) {
		this.kwjb = kwjb;
	}

	public Timestamp getFbrq() {
		return this.fbrq;
	}

	public void setFbrq(Timestamp fbrq) {
		this.fbrq = fbrq;
	}

	public String getJsqk() {
		return this.jsqk;
	}

	public void setJsqk(String jsqk) {
		this.jsqk = jsqk;
	}


	public Double getYxyz() {
		return this.yxyz;
	}

	public void setYxyz(Double yxyz) {
		this.yxyz = yxyz;
	}

	public Double getSqjl() {
		return this.sqjl;
	}

	public void setSqjl(Double sqjl) {
		this.sqjl = sqjl;
	}


	public Timestamp getDjrq() {
		return this.djrq;
	}

	public void setDjrq(Timestamp djrq) {
		this.djrq = djrq;
	}
	

}