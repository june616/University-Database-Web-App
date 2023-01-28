package higherEducation.model;

/**
 * Persons is a simple, plain old java objects (POJO).
 * Persons is a parent class, that contains children: administrators, applicants and counselors
 */

public class Persons {
	protected int PersonId;
	protected String userName;
	protected String passCode;
	protected String firstName;
	protected String lastName;
	protected String email;
	
	public Persons(int personId, String userName, String passCode, String firstName, String lastName, String email) {
		super();
		PersonId = personId;
		this.userName = userName;
		this.passCode = passCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Persons(int personId) {
		super();
		PersonId = personId;
	}
	
//	public Persons(String userName, String passCode, String firstName, String lastName, String email) {
//		super();
//		this.userName = userName;
//		this.passCode = passCode;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//	}

	public int getPersonId() {
		return PersonId;
	}

	public void setPersonId(int personId) {
		PersonId = personId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassCode() {
		return passCode;
	}

	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}