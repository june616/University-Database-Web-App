package higherEducation.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import higherEducation.model.*;

public class ShanghaiRankingDao {
  protected ConnectionManager connectionManager;
  private static ShanghaiRankingDao instance = null;
  protected ShanghaiRankingDao(){
    connectionManager = new ConnectionManager();
  }
  public static ShanghaiRankingDao getInstance() {
    if(instance == null) {
      instance = new ShanghaiRankingDao();
    }
    return instance;
  }

  public ShanghaiRanking create(ShanghaiRanking shanghaiRank) throws SQLException {
    // 11 attributes (exclude auto-generate key)
    String insertshanghaiRank =
        "INSERT INTO ShanghaiRanking(WorldRank,UniversityName,UNITID,Score,Alumni,Award,Hici,NS,Pub,Pcp,Year)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertshanghaiRank,
          Statement.RETURN_GENERATED_KEYS);
      insertStmt.setInt(1, shanghaiRank.getWorldRank());
      insertStmt.setString(2, shanghaiRank.getUniversityName());
      insertStmt.setInt(3, shanghaiRank.getUniversity().getUnitId());
      insertStmt.setDouble(4, shanghaiRank.getScore());
      insertStmt.setDouble(5, shanghaiRank.getAlumni());
      insertStmt.setDouble(6, shanghaiRank.getAward());
      insertStmt.setDouble(7, shanghaiRank.getHici());
      insertStmt.setDouble(8, shanghaiRank.getNs());
      insertStmt.setDouble(9, shanghaiRank.getPub());
      insertStmt.setDouble(10, shanghaiRank.getPcp());
      insertStmt.setString(11, shanghaiRank.getYear());
      insertStmt.executeUpdate();

      resultKey = insertStmt.getGeneratedKeys();
      int shanghaiEntryID = -1;
      if(resultKey.next()) {
        shanghaiEntryID = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      shanghaiRank.setShanghaiEntryID(shanghaiEntryID);
      return shanghaiRank;
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

//  public ShanghaiRanking updateRank(ShanghaiRanking shanghaiRank, int newRank) throws SQLException {
//    String updateShanghaiRank = "UPDATE ShanghaiRanking SET WorldRank=? WHERE ShanghaiEntryID=?;";
//    Connection connection = null;
//    PreparedStatement updateStmt = null;
//    try {
//      connection = connectionManager.getConnection();
//      updateStmt = connection.prepareStatement(updateShanghaiRank);
//      updateStmt.setInt(1, newRank);
//      updateStmt.setInt(2, shanghaiRank.getShanghaiEntryID());
//      updateStmt.executeUpdate();
//      shanghaiRank.setWorldRank(newRank);
//      return shanghaiRank;
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

  public ShanghaiRanking delete(ShanghaiRanking shanghaiRank) throws SQLException {
    String deleteShanghaiRank = "DELETE FROM ShanghaiRanking WHERE ShanghaiEntryID=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try{
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteShanghaiRank);
      deleteStmt.setInt(1, shanghaiRank.getShanghaiEntryID());
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

//  public ShanghaiRanking getShanghaiRankByEntryId(int shanghaiEntryID) throws SQLException {
//    String selectShanghaiRank = "SELECT ShanghaiEntryID,WorldRank,UniversityName,UNITID,Score,Alumni,Award,Hici,NS,Pub,Pcp,Year" + "FROM ShanghaiRanking" + "WHERE ShanghaiEntryID=?;";
//    Connection connection = null;
//    PreparedStatement selectStmt = null;
//    ResultSet results = null;
//    try {
//      connection = connectionManager.getConnection();
//      selectStmt = connection.prepareStatement(selectShanghaiRank);
//      selectStmt.setInt(1, shanghaiEntryID);
//      results = selectStmt.executeQuery();
//      UniversitiesDao universityDao = UniversitiesDao.getInstance();
//
//      if(results.next()) {
//        int resultShanghaiEntryID = results.getInt("ShanghaiEntryID");
//        int worldRank = results.getInt("WorldRank");
//        String universityName = results.getString("UniversityName");
//        // directly get unitID from results
//        int unitID = results.getInt("UNITID");
//        double score = results.getDouble("Score");
//        double alumni = results.getDouble("Alumni");
//        double award = results.getDouble("Award");
//        double hici = results.getDouble("Hici");
//        double ns = results.getDouble("NS");
//        double pub = results.getDouble("Pub");
//        double pcp = results.getDouble("Pcp");
//        String year = results.getString("Year");
//        // get corresponding university using unitID
//        Universities university = universityDao.getUniversityByUnitId(unitID);
//        // pass in university, instead of unitID
//        ShanghaiRanking shanghaiRank = new ShanghaiRanking(resultShanghaiEntryID, worldRank, universityName, university, score, alumni, award, hici, ns, pub, pcp, year);
//        return shanghaiRank;
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
  public List<ShanghaiRanking> getShanghaiRankingForUniversity(Universities university) throws SQLException {
    List<ShanghaiRanking> shanghaiRankingsCollection = new ArrayList<ShanghaiRanking>();
    String selectShanghaiRanks = "SELECT ShanghaiEntryID,WorldRank,UniversityName,UNITID,Score,Alumni,Award,Hici,NS,Pub,Pcp,Year FROM UniversityApplication.ShanghaiRanking WHERE UNITID=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectShanghaiRanks);
      selectStmt.setInt(1, university.getUnitId());
      results = selectStmt.executeQuery();
      while(results.next()) {
        // no need to get unitID
        int resultShanghaiEntryID = results.getInt("ShanghaiEntryID");
        int worldRank = results.getInt("WorldRank");
        String universityName = results.getString("UniversityName");
        double score = results.getDouble("Score");
        double alumni = results.getDouble("Alumni");
        double award = results.getDouble("Award");
        double hici = results.getDouble("Hici");
        double ns = results.getDouble("NS");
        double pub = results.getDouble("Pub");
        double pcp = results.getDouble("Pcp");
        String year = results.getString("Year");
        // just pass in university as parameter
        ShanghaiRanking shanghaiRanking = new ShanghaiRanking(resultShanghaiEntryID, worldRank, universityName, university, score, alumni, award, hici, ns, pub, pcp, year);
        shanghaiRankingsCollection.add(shanghaiRanking);
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
    return shanghaiRankingsCollection;
  }

  //   Get top ? ShanghaiRanking in Year 2022
//  public List<ShanghaiRanking> getTopShanghaiRanking(int rankNumber) throws SQLException {
//    List<ShanghaiRanking> shanghaiRankingsCollection = new ArrayList<ShanghaiRanking>();
//    String selectShanghaiRanks = "SELECT ShanghaiEntryID,WorldRank,UniversityName,UNITID,Score,Alumni,Award,Hici,NS,Pub,Pcp,Year FROM UniversityApplication.ShanghaiRanking WHERE Year=2022 AND UNITID IS NOT NULL ORDER BY WorldRank LIMIT ?;";
//    Connection connection = null;
//    PreparedStatement selectStmt = null;
//    ResultSet results = null;
//    try {
//      connection = connectionManager.getConnection();
//      selectStmt = connection.prepareStatement(selectShanghaiRanks);
//      selectStmt.setInt(1, rankNumber);
//      results = selectStmt.executeQuery();
//      UniversitiesDao universityDao = UniversitiesDao.getInstance();
//      while(results.next()) {
//        int resultShanghaiEntryID = results.getInt("ShanghaiEntryID");
//        int worldRank = results.getInt("WorldRank");
//        String universityName = results.getString("UniversityName");
//        // directly get unitID from results
//        int unitID = results.getInt("UNITID");
//        double score = results.getDouble("Score");
//        double alumni = results.getDouble("Alumni");
//        double award = results.getDouble("Award");
//        double hici = results.getDouble("Hici");
//        double ns = results.getDouble("NS");
//        double pub = results.getDouble("Pub");
//        double pcp = results.getDouble("Pcp");
//        String year = results.getString("Year");
//        // get corresponding university using unitID
//        Universities university = universityDao.getUniversityByUnitId(unitID);
//        // pass in university, instead of unitID
//        ShanghaiRanking shanghaiRank = new ShanghaiRanking(resultShanghaiEntryID, worldRank, universityName, university, score, alumni, award, hici, ns, pub, pcp, year);
//        shanghaiRankingsCollection.add(shanghaiRank);
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
//    return shanghaiRankingsCollection;
//  }

  //   Get top 50 ShanghaiRanking in Year 2022
  public List<ShanghaiRanking> getTop50ShanghaiRanking() throws SQLException {
    List<ShanghaiRanking> shanghaiRankingsCollection = new ArrayList<ShanghaiRanking>();
    String selectShanghaiRanks = "SELECT ShanghaiEntryID,WorldRank,UniversityName,UNITID,Score,Alumni,Award,Hici,NS,Pub,Pcp,Year FROM UniversityApplication.ShanghaiRanking WHERE Year=2022 AND UNITID IS NOT NULL ORDER BY WorldRank LIMIT 50;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectShanghaiRanks);
      results = selectStmt.executeQuery();
      UniversitiesDao universityDao = UniversitiesDao.getInstance();
      while(results.next()) {
        int resultShanghaiEntryID = results.getInt("ShanghaiEntryID");
        int worldRank = results.getInt("WorldRank");
        String universityName = results.getString("UniversityName");
        // directly get unitID from results
        int unitID = results.getInt("UNITID");
        double score = results.getDouble("Score");
        double alumni = results.getDouble("Alumni");
        double award = results.getDouble("Award");
        double hici = results.getDouble("Hici");
        double ns = results.getDouble("NS");
        double pub = results.getDouble("Pub");
        double pcp = results.getDouble("Pcp");
        String year = results.getString("Year");
        // get corresponding university using unitID
        Universities university = universityDao.getUniversityByUnitId(unitID);
        // pass in university, instead of unitID
        ShanghaiRanking shanghaiRank = new ShanghaiRanking(resultShanghaiEntryID, worldRank, universityName, university, score, alumni, award, hici, ns, pub, pcp, year);
        shanghaiRankingsCollection.add(shanghaiRank);
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
    return shanghaiRankingsCollection;
  }

}
