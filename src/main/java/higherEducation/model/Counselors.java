package higherEducation.model;

public class Counselors extends Persons {
	protected Gender gender;
	protected int yearsOfExperience;
	protected Boolean acceptingNewStudent;
	protected String city;
	protected String state;
	protected String zipCode;
	protected String raceEthnicity;
	
	public enum Gender {
		female, male, unidentified
	}

	public Counselors(int personId, String userName, String passCode, String firstName, String lastName, String email,
			Gender gender, int yearsOfExperience, Boolean acceptingNewStudent, String city, String state,
			String zipCode, String raceEthnicity) {
		super(personId, userName, passCode, firstName, lastName, email);
		this.gender = gender;
		this.yearsOfExperience = yearsOfExperience;
		this.acceptingNewStudent = acceptingNewStudent;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.raceEthnicity = raceEthnicity;
	}
	
	public Counselors(int personId) {
		super(personId);
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public Boolean getAcceptingNewStudent() {
		return acceptingNewStudent;
	}

	public void setAcceptingNewStudent(Boolean acceptingNewStudent) {
		this.acceptingNewStudent = acceptingNewStudent;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getRaceEthnicity() {
		return raceEthnicity;
	}

	public void setRaceEthnicity(String raceEthnicity) {
		this.raceEthnicity = raceEthnicity;
	}
	
	
	
}