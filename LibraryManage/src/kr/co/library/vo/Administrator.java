package kr.co.library.vo;

public class Administrator {
	private String administratorId;
	private String administratorPw;
	private char administratorSection;



public Administrator(){}



public Administrator(String administratorId, String administratorPw, char administratorSection) {
	super();
	this.administratorId = administratorId;
	this.administratorPw = administratorPw;
	this.administratorSection = administratorSection;
}



public String getAdministratorId() {
	return administratorId;
}



public void setAdministratorId(String administratorId) {
	this.administratorId = administratorId;
}



public String getAdministratorPw() {
	return administratorPw;
}



public void setAdministratorPw(String administratorPw) {
	this.administratorPw = administratorPw;
}



public char getAdministratorSection() {
	return administratorSection;
}



public void setAdministratorSection(char administratorSection) {
	this.administratorSection = administratorSection;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((administratorId == null) ? 0 : administratorId.hashCode());
	result = prime * result + ((administratorPw == null) ? 0 : administratorPw.hashCode());
	result = prime * result + administratorSection;
	return result;
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Administrator other = (Administrator) obj;
	if (administratorId == null) {
		if (other.administratorId != null)
			return false;
	} else if (!administratorId.equals(other.administratorId))
		return false;
	if (administratorPw == null) {
		if (other.administratorPw != null)
			return false;
	} else if (!administratorPw.equals(other.administratorPw))
		return false;
	if (administratorSection != other.administratorSection)
		return false;
	return true;
}



@Override
public String toString() {
	return "administrator [administratorId=" + administratorId + ", administratorPw=" + administratorPw
			+ ", administratorSection=" + administratorSection + "]";
}



}


