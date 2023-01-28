package higherEducation.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import higherEducation.model.*;

public class ApplicantsDao extends PersonsDao {
	protected ConnectionManager connectionManager;
	
	// Single pattern: instantiation is limited to one object.
	private static ApplicantsDao instance = null;
	protected ApplicantsDao() {
		connectionManager = new ConnectionManager();
	}
	public static ApplicantsDao getInstance() {
		if(instance == null) {
			instance = new ApplicantsDao();
		}
		return instance;
	}
	
	public Applicants create(Applicants applicant) throws SQLException{
		create(new Persons(applicant.getPersonId(), applicant.getUserName(), applicant.getPassCode(), applicant.getFirstName(), applicant.getLastName(), applicant.getEmail()));
		String insertApplicant = "INSERT INTO Applicants(PersonId,Gender, DateOfBirth, SeekingCounselors, HighSchool, City, State, ZipCode, RaceEthnicity, ParentEduLevel) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertApplicant);
			insertStmt.setInt(1, applicant.getPersonId());
			insertStmt.setString(2, applicant.getGender().name());
			insertStmt.setTimestamp(3, new Timestamp(applicant.getDateOfBirth().getTime()));
			insertStmt.setBoolean(4, applicant.getSeekingCounselors());
			insertStmt.setString(5, applicant.getHighschool());
			insertStmt.setString(6, applicant.getCity());
			insertStmt.setString(7, applicant.getState());
			insertStmt.setString(8, applicant.getZipCode());
			insertStmt.setString(9, applicant.getRaceEthnicity());
			insertStmt.setString(10, applicant.getParentEduLevel());
			insertStmt.executeUpdate();
			return applicant;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(insertStmt != null) {
				insertStmt.close();
			}
		}
	}
	
	public Applicants updateSeekingCounselors(Applicants applicant, Boolean seekingCounselors ) throws SQLException {
		String updateApplicant = "UPDATE Applicants SET SeekingCounselors=? WHERE PersonId=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateApplicant);
			updateStmt.setBoolean(1,seekingCounselors);
			updateStmt.setInt(2, applicant.getPersonId());
			updateStmt.executeUpdate();
			
			applicant.setSeekingCounselors(seekingCounselors);
			return applicant;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(updateStmt != null) {
				updateStmt.close();
			}
		}
	}
	
	public Applicants delete(Applicants applicant) throws SQLException{
		String deleteApplicant = "DELETE FROM Applicants WHERE PersonId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteApplicant);
			deleteStmt.setInt(1, applicant.getPersonId());
			deleteStmt.executeUpdate();
			deleteStmt.executeUpdate();

			super.delete(applicant);
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}
	
	public Applicants getApplicantByPersonId(int personId) throws SQLException {
		String selectApplicant = "SELECT Applicants.PersonId as PersonId,UserName,"
				+ "PassCode, FirstName,LastName, Email,"
				+ "Gender,DateOfBirth,SeekingCounselors,HighSchool,City,State,ZipCode,"
				+ "RaceEthnicity,ParentEduLevel "
				+ "FROM Applicants INNER JOIN Persons "
				+ "ON Applicants.PersonId = Persons.PersonId "
				+ "WHERE Applicants.PersonId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectApplicant);
			selectStmt.setInt(1, personId);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int resultId = results.getInt("PersonId");
				String userName = results.getString("UserName");
				String passCode = results.getString("PassCode");
				String firstName = results.getString("FirstName");
				String lastName = results.getString("LastName");
				String email = results.getString("Email");
				Applicants.Gender gender = Applicants.Gender.valueOf(results.getString("Gender"));
				Timestamp dob = results.getTimestamp("DateOfBirth");
				Boolean seekingCounselors = results.getBoolean("SeekingCounselors");
				String highSchool = results.getString("HighSchool");
				String city = results.getString("City");
				String state = results.getString("State");
				String zipCode = results.getString("ZipCode");
				String raceEthnicity = results.getString("RaceEthnicity");
				String parentEduLevel = results.getString("ParentEduLevel");
				Applicants applicant = new Applicants(resultId,userName,passCode,firstName,
						lastName,email,gender,dob,seekingCounselors,highSchool,city,state,zipCode,raceEthnicity,parentEduLevel);
				return applicant;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}
}