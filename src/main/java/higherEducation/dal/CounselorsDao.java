package higherEducation.dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import higherEducation.model.*;


public class CounselorsDao extends PersonsDao {
	
	private static CounselorsDao instance = null;
	protected CounselorsDao() {
		super();
	}
	public static CounselorsDao getInstance() {
		if(instance == null) {
			instance = new CounselorsDao();
		}
		return instance;
	}
	
	public Counselors create(Counselors counselor) throws SQLException {
		// Insert into the superclass table first.
		create(new Persons(counselor.getPersonId(),counselor.getUserName(), counselor.getPassCode(),counselor.getFirstName(),
				counselor.getLastName(),counselor.getEmail()));

		String insertCounselor = "INSERT INTO Counselors(PersonId,Gender,YearsOfExperience,AcceptingNewStudent,City,State,ZipCode,RaceEthnicity) VALUES(?,?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertCounselor);
			insertStmt.setInt(1,counselor.getPersonId());
			insertStmt.setString(2, counselor.getGender().name());
			insertStmt.setInt(3, counselor.getYearsOfExperience());
			insertStmt.setBoolean(4, counselor.getAcceptingNewStudent());
			insertStmt.setString(5, counselor.getCity());
			insertStmt.setString(6, counselor.getState());
			insertStmt.setString(7, counselor.getZipCode());
			insertStmt.setString(8, counselor.getRaceEthnicity());
			insertStmt.executeUpdate();
			return counselor;
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
	
	
	public Counselors delete(Counselors counselor) throws SQLException {
		String deleteCounselor = "DELETE FROM Applicants WHERE PersonId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteCounselor);
			deleteStmt.setInt(1, counselor.getPersonId());
			deleteStmt.executeUpdate();
			super.delete(counselor);

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

	
	public Counselors getCounselorByPersonId(int personId) throws SQLException {
		String selectCounselor = "SELECT Counselors.PersonId,UserName,PassCode,FirstName,LastName,Email,"
				+ "Gender,YearsOfExperience,AcceptingNewStudent,City,State,ZipCode,RaceEthnicity "
				+ "FROM Counselors INNER JOIN Persons "
				+ "ON Counselors.PersonId = Persons.PersonId "
				+ "WHERE Counselors.PersonId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectCounselor);
			selectStmt.setInt(1, personId);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int resultId = results.getInt("PersonId");
				String userName = results.getString("UserName");
				String passCode = results.getString("PassCode");
				String firstName = results.getString("FirstName");
				String lastName = results.getString("LastName");
				String email = results.getString("Email");
				Counselors.Gender gender = Counselors.Gender.valueOf(results.getString("Gender"));
				int yearsOfExperience = results.getInt("YearsOfExperience");
				Boolean acceptingNewStudent = results.getBoolean("AcceptingNewStudent");
				String city = results.getString("City");
				String state = results.getString("State");
				String zipCode = results.getString("ZipCode");
				String raceEthnicity = results.getString("RaceEthnicity");
				Counselors counselor = new Counselors(resultId,userName,passCode,firstName,
						lastName,email,gender,yearsOfExperience,acceptingNewStudent, city,state,zipCode,raceEthnicity);
				return counselor;
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
