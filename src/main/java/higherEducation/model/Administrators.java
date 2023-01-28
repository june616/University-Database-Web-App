package higherEducation.model;

import java.sql.Timestamp;


public class Administrators extends Persons {
	protected Timestamp lastLogin;	
	
	public Administrators(int personId, String userName,String passCode, String firstName,
			String lastName, String email, Timestamp lastLogin) {
		super(personId, userName, passCode, firstName, lastName, email);
		this.lastLogin = lastLogin;
	}
	
	public Administrators(int personId) {
		super(personId);
	}
	
//	public Administrators(String userName,String passCode, String firstName,
//			String lastName, String email, Timestamp lastLogin) {
//		super(userName, passCode, firstName, lastName, email);
//		this.lastLogin = lastLogin;
//	}
	
	public Timestamp getLastLogin() {
		return this.lastLogin;
	}
	
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
}