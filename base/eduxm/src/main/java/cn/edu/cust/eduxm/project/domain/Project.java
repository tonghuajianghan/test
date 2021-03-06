package cn.edu.cust.eduxm.project.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cn.edu.cust.rbac.domain.User;

public class Project {
	private User user;
	private int xm_id;       //项目编号
	private int zjz_id;			//外键 专家组
	//private int fzr_id;			//外键 关联负责人的表    现在从数据库project表中去掉这个字段，改为负责人表中的id跟project的id的值相同就好
	//private int xyh_id;			//外键	校用户    已经修改 改为orgcode 存组织机构  字典代码
	private String orgcode;    //组织机构
	private	int yjbh_id;		//外键	意见编号
	private String zt;          //状态
	private String xmnbbh_id;   //项目内部编号
	private String xmmc;        //项目名称
	private String sqnd;        //申请年度
	private String cgxs;        //成果形式
	private Date kssj;        //开始时间
	private Date jssj;        //结束时间
	private Date jhwcsj;      //计划完成时间
	private String xmlb;        //项目类别
	private String yjlx;        //研究类型
	private String xkmc;        //学科名称
	private String xkdm;        //学科代码
	private Date tbsj;        //填表时间
	//private String yyxzqs;     //意义现状趋势-------------字段对应的值varchar超过3000
	//private String yjnr;        //研究内容                                            字段对应值varchar超过3000
	//private String yjff;        //研究方法                                            字段对应值varchar超过3000
	//private String jctj;        //基础条件                                            字段对应值varchar超过3000
	//private String jdcg;        //进度成果                                            字段对应值varchar超过3000
	//private String ktbj;        //课题备件                                            字段对应值varchar超过3000
	//private String cgyyyc;      //成果应用预测----------- 字段对应值varchar超过3000
	private float ysze;         //预算总额
	private float sqze;         //申请总额
	private String sqmx;        //申请明细
	private float zcze;         //自筹总额
	private String zcmx;        //自筹明细
	private String sqcn;        //申请承诺
	private String xswyhyj;     //学术委员会意见
	private String fzrdwyj;     //负责人单位意见
	private int sjzt1;          //数据状态1
	private float psfs;         //评审分数
	private String psjg;        //评审结果
	private String jgsm;        //结果说明
	private int sjzt2;          //数据状态2
	private int tbr;            //填报人
	private String bz1;         //备注1
	private String bz2;         //备注2
	private String bz3;         //备注3
	private String bz4;         //备注4
	private float fs;			//分数
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getXm_id() {
		return xm_id;
	}

	public void setXm_id(int xm_id) {
		this.xm_id = xm_id;
	}

	public int getZjz_id() {
		return zjz_id;
	}

	public void setZjz_id(int zjz_id) {
		this.zjz_id = zjz_id;
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public int getYjbh_id() {
		return yjbh_id;
	}

	public void setYjbh_id(int yjbh_id) {
		this.yjbh_id = yjbh_id;
	}

	public String getZt() {
		return zt;
	}




	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getXmnbbh_id() {
		return xmnbbh_id;
	}

	public float getFs() {
		return fs;
	}

	public void setFs(float fs) {
		this.fs = fs;
	}

	public void setXmnbbh_id(String xmnbbh_id) {
		this.xmnbbh_id = xmnbbh_id;
	}




	public String getXmmc() {
		return xmmc;
	}




	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}




	public String getSqnd() {
		return sqnd;
	}




	public void setSqnd(String sqnd) {
		this.sqnd = sqnd;
	}




	public String getCgxs() {
		return cgxs;
	}




	public void setCgxs(String cgxs) {
		this.cgxs = cgxs;
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

	public Date getJhwcsj() {
		return jhwcsj;
	}

	public void setJhwcsj(Date jhwcsj) {
		this.jhwcsj = jhwcsj;
	}

	public void setTbsj(Date tbsj) {
		this.tbsj = tbsj;
	}

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

	public String getXkmc() {
		return xkmc;
	}

	public void setXkmc(String xkmc) {
		this.xkmc = xkmc;
	}

	public String getXkdm() {
		return xkdm;
	}

	public void setXkdm(String xkdm) {
		this.xkdm = xkdm;
	}


	public Date getTbsj() {
		return tbsj;
	}

	/*public String getYyxzqs() {
		return yyxzqs;
	}

	public void setYyxzqs(String yyxzqs) {
		this.yyxzqs = yyxzqs;
	}*/

	/*public String getYjnr() {
		return yjnr;
	}

	public void setYjnr(String yjnr) {
		this.yjnr = yjnr;
	}*/




	/*public String getYjff() {
		return yjff;
	}




	public void setYjff(String yjff) {
		this.yjff = yjff;
	}*/




	/*public String getJctj() {
		return jctj;
	}




	public void setJctj(String jctj) {
		this.jctj = jctj;
	}*/




	/*public String getJdcg() {
		return jdcg;
	}




	public void setJdcg(String jdcg) {
		this.jdcg = jdcg;
	}*/




	/*public String getKtbj() {
		return ktbj;
	}




	public void setKtbj(String ktbj) {
		this.ktbj = ktbj;
	}*/




	/*public String getCgyyyc() {
		return cgyyyc;
	}




	public void setCgyyyc(String cgyyyc) {
		this.cgyyyc = cgyyyc;
	}*/




	public float getYsze() {
		return ysze;
	}




	public void setYsze(float ysze) {
		this.ysze = ysze;
	}




	public float getSqze() {
		return sqze;
	}




	public void setSqze(float sqze) {
		this.sqze = sqze;
	}




	public String getSqmx() {
		return sqmx;
	}




	public void setSqmx(String sqmx) {
		this.sqmx = sqmx;
	}




	public float getZcze() {
		return zcze;
	}




	public void setZcze(float zcze) {
		this.zcze = zcze;
	}




	public String getZcmx() {
		return zcmx;
	}




	public void setZcmx(String zcmx) {
		this.zcmx = zcmx;
	}




	public String getSqcn() {
		return sqcn;
	}




	public void setSqcn(String sqcn) {
		this.sqcn = sqcn;
	}




	public String getXswyhyj() {
		return xswyhyj;
	}




	public void setXswyhyj(String xswyhyj) {
		this.xswyhyj = xswyhyj;
	}




	public String getFzrdwyj() {
		return fzrdwyj;
	}




	public void setFzrdwyj(String fzrdwyj) {
		this.fzrdwyj = fzrdwyj;
	}




	public int getSjzt1() {
		return sjzt1;
	}




	public void setSjzt1(int sjzt1) {
		this.sjzt1 = sjzt1;
	}




	public float getPsfs() {
		return psfs;
	}




	public void setPsfs(float psfs) {
		this.psfs = psfs;
	}




	public String getPsjg() {
		return psjg;
	}




	public void setPsjg(String psjg) {
		this.psjg = psjg;
	}




	public String getJgsm() {
		return jgsm;
	}




	public void setJgsm(String jgsm) {
		this.jgsm = jgsm;
	}




	public int getSjzt2() {
		return sjzt2;
	}




	public void setSjzt2(int sjzt2) {
		this.sjzt2 = sjzt2;
	}




	public int getTbr() {
		return tbr;
	}




	public void setTbr(int tbr) {
		this.tbr = tbr;
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




	public String getBz3() {
		return bz3;
	}




	public void setBz3(String bz3) {
		this.bz3 = bz3;
	}




	public String getBz4() {
		return bz4;
	}




	public void setBz4(String bz4) {
		this.bz4 = bz4;
	}




	public void setFields(ResultSet rs) throws SQLException {
		xm_id = rs.getInt("c_xm_id");
		zjz_id = rs.getInt("c_zjz_id");			
		orgcode = rs.getString("c_orgcode");	
		yjbh_id = rs.getInt("c_yjbh_id");
		xmnbbh_id = rs.getString("c_xmnbbh_id");
		xmmc = rs.getString("c_xmmc");
		sqnd = rs.getString("c_sqnd");
		cgxs = rs.getString("c_cgxs");
		kssj = rs.getDate("c_kssj");
		jssj = rs.getDate("c_jssj");
		jhwcsj = rs.getDate("c_jhwcsj");
		xmlb = rs.getString("c_xmlb");
		yjlx = rs.getString("c_yjlx");
		xkmc = rs.getString("c_xkmc");
		xkdm = rs.getString("c_xkdm");
		tbsj = rs.getDate("c_tbsj");
		//yyxzqs = rs.getString("c_yyzxqs");
		//yjnr = rs.getString("c_yjnr");
		//yjff = rs.getString("c_yjff");
		//jctj = rs.getString("c_jctj");
		//jdcg = rs.getString("c_jdcg");
		//ktbj = rs.getString("c_ktbj");
		//cgyyyc = rs.getString("c_cgyyyc");
		ysze = rs.getFloat("c_ysze");
		sqze = rs.getFloat("c_sqze");
		sqmx = rs.getString("c_sqmx");
		zcze = rs.getFloat("c_zcze");
		zcmx = rs.getString("c_zcmx");
		sqcn = rs.getString("c_sqcn");
		xswyhyj = rs.getString("c_xswyhyj");
		fzrdwyj = rs.getString("c_fzrdwyj");
		sjzt1 = rs.getInt("c_sjzt1");
		psfs = rs.getFloat("c_psfs");
		psjg = rs.getString("c_psjg");
		jgsm = rs.getString("c_jgsm");
		sjzt2 = rs.getInt("c_sjzt2");
		tbr = rs.getInt("c_tbr");
		bz1 = rs.getString("c_bz1");
		bz2 = rs.getString("c_bz2");
		bz3 = rs.getString("c_bz3");
		bz4 = rs.getString("c_bz4");
		zt = rs.getString("c_zt");
		fs = rs.getInt("c_fs");
	}

	@Override
	public String toString() {
		return "Project [user=" + user + ", xm_id=" + xm_id + ", zt=" + zt
				+ ", xmnbbh_id=" + xmnbbh_id + ", xmmc=" + xmmc + ", sqnd="
				+ sqnd + ", cgxs=" + cgxs + ", kssj=" + kssj + ", jssj=" + jssj
				+ ", jhwcsj=" + jhwcsj + ", xmlb=" + xmlb + ", yjlx=" + yjlx
				+ ", xkmc=" + xkmc + ", xkdm=" + xkdm + ", tbsj=" + tbsj
				+ ", ysze=" + ysze + ", sqze=" + sqze
				+ ", sqmx=" + sqmx + ", zcze=" + zcze + ", zcmx=" + zcmx
				+ ", sqcn=" + sqcn + ", xswyhyj=" + xswyhyj + ", fzrdwyj="
				+ fzrdwyj + ", sjzt1=" + sjzt1 + ", psfs=" + psfs + ", psjg="
				+ psjg + ", jgsm=" + jgsm + ", sjzt2=" + sjzt2 + ", tbr=" + tbr
				+ ", bz1=" + bz1 + ", bz2=" + bz2 + ", bz3=" + bz3 + ", bz4="
				+ bz4 + "]";
	}
	
	
	
}
