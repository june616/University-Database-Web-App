package higherEducation.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import higherEducation.model.*;

public class CwruRankingDao {
  protected ConnectionManager connectionManager;
  private static CwruRankingDao instance = null;
  protected CwruRankingDao(){
    connectionManager = new ConnectionManager();
  }
  public static CwruRankingDao getInstance() {
    if(instance == null) {
      instance = new CwruRankingDao();
    }
    return instance;
  }

  public CwruRanking create(CwruRanking cwruRank) throws SQLException {
    // 12 attributes (exclude auto-generate key)
    String insertCwruRank =
        "INSERT INTO UniversityApplication.CwruRanking(WorldRank,UniversityName,UNITID,EducationQuality,AlumniEmployment,FacultyQuality,Publications,Influence,Citations,Patents,Score,Year)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertCwruRank,
          Statement.RETURN_GENERATED_KEYS);
      insertStmt.setInt(1, cwruRank.getWorldRank());
      insertStmt.setString(2, cwruRank.getUniversityName());
      insertStmt.setInt(3, cwruRank.getUniversity().getUnitId());
      insertStmt.setInt(4, cwruRank.getEducationQuality());
      insertStmt.setInt(5, cwruRank.getAlumniEmployment());
      insertStmt.setInt(6, cwruRank.getFacultyQuality());
      insertStmt.setInt(7, cwruRank.getPublications());
      insertStmt.setInt(8, cwruRank.getInfluence());
      insertStmt.setInt(9, cwruRank.getCitations());
      insertStmt.setInt(10, cwruRank.getPatents());
      insertStmt.setDouble(11, cwruRank.getScore());
      insertStmt.setString(12, cwruRank.getYear());
      insertStmt.executeUpdate();

      resultKey = insertStmt.getGeneratedKeys();
      int cwruEntryID = -1;
      if(resultKey.next()) {
        cwruEntryID = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      cwruRank.setCwruEntryID(cwruEntryID);
      return cwruRank;
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
      if(resultKey != null) {
        resultKey.close();
      }
    }
  }

//  public CwruRanking updateRank(CwruRanking cwruRank, int newRank) throws SQLException {
//    String updateCwruRank = "UPDATE CwruRanking SET WorldRank=? WHERE CwruEntryID=?;";
//    Connection connection = null;
//    PreparedStatement updateStmt = null;
//    try {
//      connection = connectionManager.getConnection();
//      updateStmt = connection.prepareStatement(updateCwruRank);
//      updateStmt.setInt(1, newRank);
//      updateStmt.setInt(2, cwruRank.getCwruEntryID());
//      updateStmt.executeUpdate();
//      cwruRank.setWorldRank(newRank);
//      return cwruRank;
//    } catch (SQLException e) {
//      e.printStackTrace();
//      throw e;
//    } finally {
//      if(connection != null) {
//        connection.close();
//      }
//      if(updateStmt != null) {
//        updateStmt.close();
//      }
//    }
//  }

  public CwruRanking delete(CwruRanking cwruRank) throws SQLException {
    String deleteCwruRank = "DELETE FROM UniversityApplication.CwruRanking WHERE CwruEntryID=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try{
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteCwruRank);
      deleteStmt.setInt(1, cwruRank.getCwruEntryID());
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

//  public CwruRanking getCwruRankByEntryId(int cwruEntryID) throws SQLException {
//    String selectCwruRank = "SELECT CwruEntryID,WorldRank,UniversityName,UNITID,EducationQuality,AlumniEmployment,FacultyQuality,Publications,Influence,Citations,Patents,Score,Year" + "FROM CwruRanking" + "WHERE CwruEntryID=?;";
//    Connection connection = null;
//    PreparedStatement selectStmt = null;
//    ResultSet results = null;
//    try {
//      connection = connectionManager.getConnection();
//      selectStmt = connection.prepareStatement(selectCwruRank);
//      selectStmt.setInt(1, cwruEntryID);
//      results = selectStmt.executeQuery();
//      UniversitiesDao universityDao = UniversitiesDao.getInstance();
//
//      if(results.next()) {
//        int resultCwruEntryID = results.getInt("CwruEntryID");
//        int worldRank = results.getInt("WorldRank");
//        String universityName = results.getString("UniversityName");
//        // directly get unitID from results
//        int unitID = results.getInt("UNITID");
//        int educationQuality = results.getInt("EducationQuality");
//        int alumniEmployment = results.getInt("AlumniEmployment");
//        int facultyQuality = results.getInt("FacultyQuality");
//        int publications = results.getInt("Publications");
//        int influence = results.getInt("Influence");
//        int citations = results.getInt("Citations");
//        int patents = results.getInt("Patents");
//        double score = results.getDouble("Score");
//        String year = results.getString("Year");
//        // get corresponding university using unitID
//        Universities university = universityDao.getUniversityByUnitId(unitID);
//        // pass in university, instead of unitID
//        CwruRanking cwruRank = new CwruRanking(resultCwruEntryID, worldRank, universityName, university, educationQuality, alumniEmployment, facultyQuality, publications, influence, citations, patents, score, year);
//        return cwruRank;
//      }
//    } catch (SQLException e) {
//      e.printStackTrace();
//      throw e;
//    } finally {
//      if(connection != null) {
//        connection.close();
//      }
//      if(selectStmt != null) {
//        selectStmt.close();
//      }
//      if(results != null) {
//        results.close();
//      }
//    }
//    return null;
//  }

  // Get all rankings for a university
  public List<CwruRanking> getCwruRankingForUniversity(Universities university) throws SQLException {
    List<CwruRanking> cwruRankingsCollection = new ArrayList<CwruRanking>();
    String selectCwruRanks = "SELECT CwruEntryID,WorldRank,UniversityName,UNITID,EducationQuality,AlumniEmployment,FacultyQuality,Publications,Influence,Citations,Patents,Score,Year FROM UniversityApplication.CwruRanking WHERE UNITID=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectCwruRanks);
      selectStmt.setInt(1, university.getUnitId());
      results = selectStmt.executeQuery();
      while(results.next()) {
        // no need to get unitID
        int cwruEntryID = results.getInt("CwruEntryID");
        int worldRank = results.getInt("WorldRank");
        String universityName = results.getString("UniversityName");
        int educationQuality = results.getInt("EducationQuality");
        int alumniEmployment = results.getInt("AlumniEmployment");
        int facultyQuality = results.getInt("FacultyQuality");
        int publications = results.getInt("Publications");
        int influence = results.getInt("Influence");
        int citations = results.getInt("Citations");
        int patents = results.getInt("Patents");
        double score = results.getDouble("Score");
        String year = results.getString("Year");
        // just pass in university as parameter
        CwruRanking cwruRanking = new CwruRanking(cwruEntryID, worldRank, universityName, university, educationQuality, alumniEmployment, facultyQuality, publications, influence, citations, patents, score, year);
        cwruRankingsCollection.add(cwruRanking);
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
    return cwruRankingsCollection;
  }


//   Get top ? CwruRanking in Year 2022
//  public List<CwruRanking> getTopCwruRanking(int rankNumber) throws SQLException {
//    List<CwruRanking> cwruRankingsCollection = new ArrayList<CwruRanking>();
//    String selectCwruRanks = "SELECT CwruEntryID,WorldRank,UniversityName,UNITID,EducationQuality,AlumniEmployment,FacultyQuality,Publications,Influence,Citations,Patents,Score,Year FROM UniversityApplication.CwruRanking WHERE Year=2022 AND UNITID IS NOT NULL ORDER BY WorldRank LIMIT ?;";
//    Connection connection = null;
//    PreparedStatement selectStmt = null;
//    ResultSet results = null;
//    try {
//      connection = connectionManager.getConnection();
//      selectStmt = connection.prepareStatement(selectCwruRanks);
//      selectStmt.setInt(1, rankNumber);
//      results = selectStmt.executeQuery();
//      UniversitiesDao universityDao = UniversitiesDao.getInstance();
//      while(results.next()) {
//        int cwruEntryID = results.getInt("CwruEntryID");
//        int worldRank = results.getInt("WorldRank");
//        String universityName = results.getString("UniversityName");
//        // directly get unitID from results
//        int unitID = results.getInt("UNITID");
//        int educationQuality = results.getInt("EducationQuality");
//        int alumniEmployment = results.getInt("AlumniEmployment");
//        int facultyQuality = results.getInt("FacultyQuality");
//        int publications = results.getInt("Publications");
//        int influence = results.getInt("Influence");
//        int citations = results.getInt("Citations");
//        int patents = results.getInt("Patents");
//        double score = results.getDouble("Score");
//        String year = results.getString("Year");
//        // get corresponding university using unitID
//        Universities university = universityDao.getUniversityByUnitId(unitID);
//        // pass in university, instead of unitID
//        CwruRanking cwruRank = new CwruRanking(cwruEntryID, worldRank, universityName, university, educationQuality, alumniEmployment, facultyQuality, publications, influence, citations, patents, score, year);
//        cwruRankingsCollection.add(cwruRank);
//      }
//    } catch (SQLException e) {
//      e.printStackTrace();
//      throw e;
//    } finally {
//      if(connection != null) {
//        connection.close();
//      }
//      if(selectStmt != null) {
//        selectStmt.close();
//      }
//      if(results != null) {
//        results.close();
//      }
//    }
//    return cwruRankingsCollection;
//  }


  //   Get top 50 CwruRanking in Year 2022
  public List<CwruRanking> getTop50CwruRanking() throws SQLException {
    List<CwruRanking> cwruRankingsCollection = new ArrayList<CwruRanking>();
    String selectCwruRanks = "SELECT CwruEntryID,WorldRank,UniversityName,UNITID,EducationQuality,AlumniEmployment,FacultyQuality,Publications,Influence,Citations,Patents,Score,Year FROM UniversityApplication.CwruRanking WHERE Year=2022 AND UNITID IS NOT NULL ORDER BY WorldRank LIMIT 50;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectCwruRanks);
      results = selectStmt.executeQuery();
      UniversitiesDao universityDao = UniversitiesDao.getInstance();
      while(results.next()) {
        int cwruEntryID = results.getInt("CwruEntryID");
        int worldRank = results.getInt("WorldRank");
        String universityName = results.getString("UniversityName");
        // directly get unitID from results
        int unitID = results.getInt("UNITID");
        int educationQuality = results.getInt("EducationQuality");
        int alumniEmployment = results.getInt("AlumniEmployment");
        int facultyQuality = results.getInt("FacultyQuality");
        int publications = results.getInt("Publications");
        int influence = results.getInt("Influence");
        int citations = results.getInt("Citations");
        int patents = results.getInt("Patents");
        double score = results.getDouble("Score");
        String year = results.getString("Year");
        // get corresponding university using unitID
        Universities university = universityDao.getUniversityByUnitId(unitID);
        // pass in university, instead of unitID
        CwruRanking cwruRank = new CwruRanking(cwruEntryID, worldRank, universityName, university, educationQuality, alumniEmployment, facultyQuality, publications, influence, citations, patents, score, year);
        cwruRankingsCollection.add(cwruRank);
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
    return cwruRankingsCollection;
  }

}
