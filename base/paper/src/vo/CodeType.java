package vo;

import java.util.Set;

public class CodeType {
    
	private String ctype;//代码类型
	private Set<Code> codes;//关联code
	
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public Set<Code> getCodes() {
		return codes;
	}
	public void setCodes(Set<Code> codes) {
		this.codes = codes;
	}
	
	
	
	

}
