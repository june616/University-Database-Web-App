package higherEducation.model;

import java.util.Date;

/**
 * Applicants is a child class to Persons
 */

public class Applicants extends Persons {
	protected Gender gender;
	protected Date dateOfBirth;
	protected Boolean SeekingCounselors;
	protected String highschool;
	protected String city;
	protected String state;
	protected String zipCode;
	protected String raceEthnicity;
	protected String ParentEduLevel;
	
	public enum Gender {
		female, male, unidentified
	}

	public Applicants(int personId, String userName, String passCode, String firstName, String lastName, String email,
			Gender gender, Date dateOfBirth, Boolean seekingCounselors, String highschool, String city, String state,
			String zipCode, String raceEthnicity, String parentEduLevel) {
		super(personId, userName, passCode, firstName, lastName, email);
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		SeekingCounselors = seekingCounselors;
		this.highschool = highschool;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.raceEthnicity = raceEthnicity;
		ParentEduLevel = parentEduLevel;
	}
	
	public Applicants(int personId) {
		super(personId);
	}
	
//	public Applicants(String userName, String passCode, String firstName, String lastName, String email,
//			Gender gender, Date dateOfBirth, Boolean seekingCounselors, String highschool, String city, String state,
//			String zipCode, String raceEthnicity, String parentEduLevel) {
//		super(userName, passCode, firstName, lastName, email);
//		this.gender = gender;
//		this.dateOfBirth = dateOfBirth;
//		SeekingCounselors = seekingCounselors;
//		this.highschool = highschool;
//		this.city = city;
//		this.state = state;
//		this.zipCode = zipCode;
//		this.raceEthnicity = raceEthnicity;
//		ParentEduLevel = parentEduLevel;
//	}
	

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Boolean getSeekingCounselors() {
		return SeekingCounselors;
	}

	public void setSeekingCounselors(Boolean seekingCounselors) {
		SeekingCounselors = seekingCounselors;
	}

	public String getHighschool() {
		return highschool;
	}

	public void setHighschool(String highschool) {
		this.highschool = highschool;
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

	public String getParentEduLevel() {
		return ParentEduLevel;
	}

	public void setParentEduLevel(String parentEduLevel) {
		ParentEduLevel = parentEduLevel;
	}
	
	
	
}