package network_term_project;

/*
 * 	ID와 패스워드의 정보가 저장되어 있는 class
 */

public class ID_PassWord {
	private String ID;
	private String ID_Start;
	static private String PW;
	static private String PW_Start;
	
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getID_Start() {
		return ID_Start;
	}
	public void setID_Start(String ID_Start) {
		this.ID_Start = ID_Start;
	}
	
	public String getPW() {
		return PW;
	}
	public void setPW(String PW) {
		this.PW = PW;
	}
	
	public String getPW_Start() {
		return PW_Start;
	}
	public void setPW_Start(String PW_Start) {
		this.PW_Start = PW_Start;
	}

}
