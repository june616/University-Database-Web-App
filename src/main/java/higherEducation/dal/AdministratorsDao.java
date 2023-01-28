package higherEducation.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import higherEducation.model.*;

public class AdministratorsDao extends PersonsDao {
protected ConnectionManager connectionManager;
	
	// Single pattern: instantiation is limited to one object.
	private static AdministratorsDao instance = null;
	protected AdministratorsDao() {
		connectionManager = new ConnectionManager();
	}
	public static AdministratorsDao getInstance() {
		if(instance == null) {
			instance = new AdministratorsDao();
		}
		return instance;
	}
	
	public Administrators create(Administrators administrator) throws SQLException{
		create(new Persons(administrator.getPersonId(), administrator.getUserName(), administrator.getPassCode(), administrator.getFirstName(), administrator.getLastName(), administrator.getEmail()));
		String insertAdministrator = "INSERT INTO Administrators(PersonId,LastLogin) "
				+ "VALUES(?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertAdministrator);
			insertStmt.setInt(1, administrator.getPersonId());
			insertStmt.setTimestamp(2, administrator.getLastLogin());
			insertStmt.executeUpdate();
			return administrator;
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
	
	public Administrators delete(Administrators administrator) throws SQLException {
		String deleteAdministrator = "DELETE FROM Administrators WHERE PersonId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteAdministrator);
			deleteStmt.setInt(1, administrator.getPersonId());
			deleteStmt.executeUpdate();
			deleteStmt.executeUpdate();
			super.delete(administrator);
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
	
	public Administrators updateLastLogin(Administrators administrator, Timestamp lastLogin) throws SQLException {
		String updateAdministrator = "UPDATE Administrators SET LastLogin=? WHERE PersonId=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateAdministrator);
			updateStmt.setTimestamp(1, lastLogin);
			updateStmt.setInt(2, administrator.getPersonId());
			updateStmt.executeUpdate();
			administrator.setLastLogin(lastLogin);
			return administrator;
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
	
	public Administrators getAdministratorByPersonId(int personId) throws SQLException {
		String selectAdministrator = "SELECT Administrators.PersonId as PersonId,UserName,PassCode,FirstName,LastName,Email,LastLogin "
				+ "FROM Administrators INNER JOIN Persons "
				+ "ON Administrators.PersonId = Persons.PersonId "
				+ "WHERE Administrators.PersonId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectAdministrator);
			selectStmt.setInt(1, personId);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int resultId = results.getInt("PersonId");
				String userName = results.getString("UserName");
				String passCode = results.getString("PassCode");
				String firstName = results.getString("FirstName");
				String lastName = results.getString("LastName");
				String email = results.getString("Email");
				Timestamp lastLogin = results.getTimestamp("LastLogin");
				Administrators administrator = new Administrators(resultId,userName,passCode,firstName,
						lastName,email,lastLogin);
				return administrator;
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