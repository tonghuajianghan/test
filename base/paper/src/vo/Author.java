package vo;

import java.sql.Timestamp;

/**
 * Author entity. @author MyEclipse Persistence Tools
 */

public class Author implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer type;
	private Paper paper;
	private String xm;
	private String zc;//职称
	private String ssdw;//所属单位
	private String sex;
	private Timestamp birth;
	private String diploma;
	private String ryxh;//人员序号

	// Constructors

	/** default constructor */
	public Author() {
	}

	/** minimal constructor */
	public Author(Paper paper) {
		this.paper = paper;
	}

	/** full constructor */
	public Author(Integer type, Paper paper, String xm, String zc,
			String ssdw, String sex, Timestamp birth, String diploma,
			String ryxh) {
		this.type = type;
		this.paper = paper;
		this.xm = xm;
		this.zc = zc;
		this.ssdw = ssdw;
		this.sex = sex;
		this.birth = birth;
		this.diploma = diploma;
		this.ryxh = ryxh;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Paper getPaper() {
		return this.paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getZc() {
		return this.zc;
	}

	public void setZc(String zc) {
		this.zc = zc;
	}

	public String getSsdw() {
		return this.ssdw;
	}

	public void setSsdw(String ssdw) {
		this.ssdw = ssdw;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getBirth() {
		return this.birth;
	}

	public void setBirth(Timestamp birth) {
		this.birth = birth;
	}

	public String getDiploma() {
		return this.diploma;
	}

	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}

	public String getRyxh() {
		return this.ryxh;
	}

	public void setRyxh(String ryxh) {
		this.ryxh = ryxh;
	}

}