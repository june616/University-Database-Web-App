package higherEducation.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import higherEducation.model.Campus;
import higherEducation.model.Universities;

public class CampusDao {
  protected ConnectionManager connectionManager;
  private static CampusDao instance=null;
  protected CampusDao(){
    connectionManager=new ConnectionManager();
  }
  public static CampusDao getInstance(){
    if(instance==null){
      instance=new CampusDao();
    }
    return instance;
  }
  public Campus create(Campus campus) throws SQLException {
    String insertCampus="INSERT INTO Campus("
        + "DapipId,UNITID,LocationName,ParentName,ParentDapipId,LocationType,Address,"
        + "GeneralPhone,AdminName,AdminPhone,AdminEmail,Fax) VALUES ("
        + "?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection=null;
    PreparedStatement insertStmt=null;
    try{
      connection=connectionManager.getConnection();
      insertStmt=connection.prepareStatement(insertCampus);
      insertStmt.setString(1,campus.getDapipId());
      insertStmt.setInt(2,campus.getUniversity().getUnitId());
      insertStmt.setString(3,campus.getLocationName());
      insertStmt.setString(4,campus.getParentName());
      insertStmt.setString(5,campus.getParentDapipId());
      insertStmt.setString(6,campus.getLocationType());
      insertStmt.setString(7,campus.getAddress());
      insertStmt.setString(8,campus.getGeneralPhone());
      insertStmt.setString(9,campus.getAdminName());
      insertStmt.setString(10,campus.getAdminPhone());
      insertStmt.setString(11,campus.getAdminEmail());
      insertStmt.setString(12,campus.getFax());
      insertStmt.executeUpdate();
      return campus;
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
  public Campus delete(Campus campus) throws SQLException {
    String deleteCIP = "DELETE FROM Campus WHERE DapipId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteCIP);
      deleteStmt.setString(1, campus.getDapipId());
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
  public List<Campus> getCampusFromUNITID(int unitid) throws SQLException {
    List<Campus> campuses = new ArrayList<Campus>();
    String selectCampus =
        "SELECT DapipId,UNITID,LocationName,ParentName,ParentDapipId,LocationType,Address,"
            + "GeneralPhone,AdminName,AdminPhone,AdminEmail,Fax FROM Campus WHERE UNITID=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectCampus);
      selectStmt.setInt(1, unitid);
      results = selectStmt.executeQuery();
      UniversitiesDao uDao=UniversitiesDao.getInstance();
      while(results.next()) {
        String dapipid = results.getString("DapipId");
        Universities uni=uDao.getUniversityByUnitId(unitid);
        String locationName = results.getString("LocationName");
        String parentName = results.getString("parentName");
        String parentDapipId = results.getString("ParentDapipId");
        String locationType = results.getString("LocationType");
        String address = results.getString("Address");
        String generalPhone = results.getString("GeneralPhone");
        String adminName = results.getString("AdminName");
        String adminPhone = results.getString("AdminPhone");
        String adminEmail = results.getString("AdminEmail");
        String fax = results.getString("Fax");
        Campus campus = new Campus(dapipid,uni, locationName,parentName,parentDapipId,locationType,address,generalPhone,adminName,adminPhone,adminEmail,fax);
        campuses.add(campus);
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
    return campuses;
  }
}
