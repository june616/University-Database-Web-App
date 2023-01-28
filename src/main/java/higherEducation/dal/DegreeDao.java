package higherEducation.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import higherEducation.model.CIP;
import higherEducation.model.Degree;
import higherEducation.model.DegreeLevel;
import higherEducation.model.Universities;

public class DegreeDao {
  protected ConnectionManager connectionManager;
  private static DegreeDao instance=null;
  protected DegreeDao(){
    connectionManager=new ConnectionManager();
  }
  public static DegreeDao getInstance(){
    if(instance==null){
      instance=new DegreeDao();
    }
    return instance;
  }
  public Degree create(Degree degree) throws SQLException {
    String insertDegree="INSERT INTO Degree(UNITID,CIPCODE,CREDLEV) VALUES (?,?,?);";
    Connection connection=null;
    PreparedStatement insertStmt=null;
    ResultSet resultKey = null;
    try{
      connection=connectionManager.getConnection();
      insertStmt=connection.prepareStatement(insertDegree, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setInt(1,degree.getUniversity().getUnitId());
      insertStmt.setString(2,degree.getCip().getCIPCODE());
      insertStmt.setString(3,degree.getDegreeLevel().getCREDLEV());
      insertStmt.executeUpdate();
      resultKey=insertStmt.getGeneratedKeys();
      int degree_id=-1;
      if(resultKey.next()){
        degree_id=resultKey.getInt(1);
      }else{
        throw new SQLException();
      }
      degree.setDegree_id(degree_id);
      return degree;
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
  public Degree delete(Degree degree) throws SQLException {
    String deleteCIP = "DELETE FROM Degree WHERE degree_id=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteCIP);
      deleteStmt.setInt(1, degree.getDegree_id());
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
  public List<Degree> getDegreeFromUNITID(int unitid) throws SQLException {
    List<Degree> degrees = new ArrayList<Degree>();
    String selectDegrees =
        "SELECT UNITID,CIPCODE,CREDLEV FROM Degree WHERE UNITID=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectDegrees);
      selectStmt.setInt(1, unitid);
      results = selectStmt.executeQuery();
      UniversitiesDao uDao=UniversitiesDao.getInstance();
      CIPDao cipDao=CIPDao.getInstance();
      DegreeLevelDao degreeLevelDao=DegreeLevelDao.getInstance();
      while(results.next()) {
        Universities uni=uDao.getUniversityByUnitId(unitid);
        CIP cip = cipDao.getCIPFromCode(results.getString("CIPCODE"));
        DegreeLevel credlev = degreeLevelDao.getDegreeFromCode(results.getString("CREDLEV"));
        Degree degree = new Degree(uni, cip, credlev);
        degrees.add(degree);
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
    return degrees;
  }
}
