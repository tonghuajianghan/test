//��֯
package vo;

public class ORG {
	private int id;
	private int LAYER;//��
	private String NAME;
	//private int ORG_ID;
	private String type;
	private java.util.Set teacher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLAYER() {
		return LAYER;
	}

	public void setLAYER(int lAYER) {
		LAYER = lAYER;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	/*public int getORG_ID() {
		return ORG_ID;
	}

	public void setORG_ID(int oRG_ID) {
		ORG_ID = oRG_ID;
	}*/

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public java.util.Set getTeacher() {
		return teacher;
	}

	public void setTeacher(java.util.Set teacher) {
		this.teacher = teacher;
	}
    
	
}
