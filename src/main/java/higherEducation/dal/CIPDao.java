package higherEducation.dal;

import higherEducation.model.CIP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CIPDao {
  protected ConnectionManager connectionManager;
  private static CIPDao instance=null;
  protected CIPDao(){
    connectionManager=new ConnectionManager();
  }
  public static CIPDao getInstance(){
    if(instance==null){
      instance=new CIPDao();
    }
    return instance;
  }
  public CIP create(CIP cip) throws SQLException{
    String insertCIP="INSERT INTO CIP(CIPCODE,CIPTitle,CIPDefinition) VALUES (?,?,?);";
    Connection connection=null;
    PreparedStatement insertStmt=null;
    try{
      connection=connectionManager.getConnection();
      insertStmt=connection.prepareStatement(insertCIP);
      insertStmt.setString(1,cip.getCIPCODE());
      insertStmt.setString(2,cip.getCIPTitle());
      insertStmt.setString(3,cip.getCIPDefinition());
      insertStmt.executeUpdate();
      return cip;
    }catch (SQLException e){
      e.printStackTrace();
      throw e;
    }finally{
      if(connection!=null){
        connection.close();
      }
      if(insertStmt!=null){
        insertStmt.close();
      }
    }
  }
  public CIP delete(CIP cip) throws SQLException {
    String deleteCIP = "DELETE FROM CIP WHERE CIPCODE=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteCIP);
      deleteStmt.setString(1, cip.getCIPCODE());
      deleteStmt.executeUpdate();
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
  public CIP getCIPFromCode(String cipcode) throws SQLException {
    String selectCIP = "SELECT CIPCODE,CIPTitle,CIPDefinition FROM CIP WHERE CIPCODE=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectCIP);
      selectStmt.setString(1, cipcode);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultCIPCODE = results.getString("CIPCODE");
        String CIPTitle = results.getString("CIPTitle");
        String CIPDefinition = results.getString("CIPDefinition");
        CIP cip = new CIP(resultCIPCODE, CIPTitle, CIPDefinition);
        return cip;
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
