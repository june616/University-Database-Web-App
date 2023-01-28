package higherEducation.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import higherEducation.model.DegreeLevel;

public class DegreeLevelDao {
  protected ConnectionManager connectionManager;
  private static DegreeLevelDao instance=null;
  protected DegreeLevelDao(){
    connectionManager=new ConnectionManager();
  }
  public static DegreeLevelDao getInstance(){
    if(instance==null){
      instance=new DegreeLevelDao();
    }
    return instance;
  }
  public DegreeLevel getDegreeFromCode(String code) throws SQLException {
    String selectDegreeLevel = "SELECT CREDLEV,CREDDESC FROM DegreeLevel WHERE CREDLEV=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectDegreeLevel);
      selectStmt.setString(1, code.trim());
      results = selectStmt.executeQuery();
      if(results.next()) {
        String CIPTitle = results.getString("CREDDESC");
        DegreeLevel degreeLevel = new DegreeLevel(code, CIPTitle);
        return degreeLevel;
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
