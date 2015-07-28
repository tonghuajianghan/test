//许可表
package vo;

import java.sql.Timestamp;

public class PERMISSION {
	private int ID;
	private String info;
	private Timestamp ENDDATE;// 停止时间
	private Timestamp START;// 开始时间
	private int ROLE_ID;
	private int OPERATOR_ID;
	private int ORG_ID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Timestamp getENDDATE() {
		return ENDDATE;
	}

	public void setENDDATE(Timestamp eNDDATE) {
		ENDDATE = eNDDATE;
	}

	public Timestamp getSTART() {
		return START;
	}

	public void setSTART(Timestamp sTART) {
		START = sTART;
	}

	public int getROLE_ID() {
		return ROLE_ID;
	}

	public void setROLE_ID(int rOLE_ID) {
		ROLE_ID = rOLE_ID;
	}

	public int getOPERATOR_ID() {
		return OPERATOR_ID;
	}

	public void setOPERATOR_ID(int oPERATOR_ID) {
		OPERATOR_ID = oPERATOR_ID;
	}

	public int getORG_ID() {
		return ORG_ID;
	}

	public void setORG_ID(int oRG_ID) {
		ORG_ID = oRG_ID;
	}

}
