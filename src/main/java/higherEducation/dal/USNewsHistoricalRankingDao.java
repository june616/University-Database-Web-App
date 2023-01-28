package higherEducation.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import higherEducation.model.*;

public class USNewsHistoricalRankingDao {
  protected ConnectionManager connectionManager;
  private static USNewsHistoricalRankingDao instance = null;
  protected USNewsHistoricalRankingDao(){
    connectionManager = new ConnectionManager();
  }
  public static USNewsHistoricalRankingDao getInstance() {
    if(instance == null) {
      instance = new USNewsHistoricalRankingDao();
    }
    return instance;
  }

  public USNewsHistoricalRanking create(USNewsHistoricalRanking usNewsRank) throws SQLException {
    // 13 attributes (exclude auto-generate key)
    String insertUSNewsRank =
        "INSERT INTO USNewsHistoricalRanking(UniversityName,UNITID,State,Rank2022,Rank2021,Rank2020,Rank2019,Rank2018,Rank2017,Rank2016,Rank2015,Rank2014,Rank2013)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertUSNewsRank,
          Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, usNewsRank.getUniversityName());
      insertStmt.setInt(2, usNewsRank.getUniversity().getUnitId());
      insertStmt.setString(3, usNewsRank.getState());
      insertStmt.setInt(4, usNewsRank.getRank2022());
      insertStmt.setInt(5, usNewsRank.getRank2021());
      insertStmt.setInt(6, usNewsRank.getRank2020());
      insertStmt.setInt(7, usNewsRank.getRank2019());
      insertStmt.setInt(8, usNewsRank.getRank2018());
      insertStmt.setInt(9, usNewsRank.getRank2017());
      insertStmt.setInt(10, usNewsRank.getRank2016());
      insertStmt.setInt(11, usNewsRank.getRank2015());
      insertStmt.setInt(12, usNewsRank.getRank2014());
      insertStmt.setInt(13, usNewsRank.getRank2013());
      insertStmt.executeUpdate();

      resultKey = insertStmt.getGeneratedKeys();
      int usNewsEntryID = -1;
      if(resultKey.next()) {
        usNewsEntryID = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      usNewsRank.setUsnewsEntryID(usNewsEntryID);
      return usNewsRank;
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

  // update the rank 2022 based on entry id
//  public USNewsHistoricalRanking updateRank(USNewsHistoricalRanking usNewsRank, int newRank) throws SQLException {
//    String updateUSNewsRank = "UPDATE USNewsHistoricalRanking SET Rank2022=? WHERE USNewsEntryID=?;";
//    Connection connection = null;
//    PreparedStatement updateStmt = null;
//    try {
//      connection = connectionManager.getConnection();
//      updateStmt = connection.prepareStatement(updateUSNewsRank);
//      updateStmt.setInt(1, newRank);
//      updateStmt.setInt(2, usNewsRank.getUsnewsEntryID());
//      updateStmt.executeUpdate();
//      usNewsRank.setRank2022(newRank);
//      return usNewsRank;
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

  public USNewsHistoricalRanking delete(USNewsHistoricalRanking usNewsRank) throws SQLException {
    String deleteUSNewsRank = "DELETE FROM USNewsHistoricalRanking WHERE usNewsEntryID=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try{
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteUSNewsRank);
      deleteStmt.setInt(1, usNewsRank.getUsnewsEntryID());
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

//  public USNewsHistoricalRanking getUSNewsRankByEntryId(int usNewsEntryID) throws SQLException {
//    String selectUSNewsRank = "SELECT USNewsEntryID,UniversityName,UNITID,State,Rank2022,Rank2021,Rank2020,Rank2019,Rank2018,Rank2017,Rank2016,Rank2015,Rank2014,Rank2013" + "FROM USNewsHistoricalRanking" + "WHERE USNewsEntryID=?;";
//    Connection connection = null;
//    PreparedStatement selectStmt = null;
//    ResultSet results = null;
//    try {
//      connection = connectionManager.getConnection();
//      selectStmt = connection.prepareStatement(selectUSNewsRank);
//      selectStmt.setInt(1, usNewsEntryID);
//      results = selectStmt.executeQuery();
//      UniversitiesDao universityDao = UniversitiesDao.getInstance();
//
//      if(results.next()) {
//        int resultUSNewsEntryID = results.getInt("usNewsEntryID");
//        String universityName = results.getString("UniversityName");
//        // directly get unitID from results
//        int unitID = results.getInt("UNITID");
//        String state = results.getString("State");
//        int rank2022 = results.getInt("Rank2022");
//        int rank2021 = results.getInt("Rank2021");
//        int rank2020 = results.getInt("Rank2020");
//        int rank2019 = results.getInt("Rank2019");
//        int rank2018 = results.getInt("Rank2018");
//        int rank2017 = results.getInt("Rank2017");
//        int rank2016 = results.getInt("Rank2016");
//        int rank2015 = results.getInt("Rank2015");
//        int rank2014 = results.getInt("Rank2014");
//        int rank2013 = results.getInt("Rank2013");
//        // get corresponding university using unitID
//        Universities university = universityDao.getUniversityByUnitId(unitID);
//        // pass in university, instead of unitID
//        USNewsHistoricalRanking usNewsRank = new USNewsHistoricalRanking(resultUSNewsEntryID, universityName, university, state, rank2022, rank2021, rank2020, rank2019, rank2018, rank2017, rank2016, rank2015, rank2014, rank2013);
//        return usNewsRank;
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
  public List<USNewsHistoricalRanking> getUSNewsHistoricalRankingForUniversity(Universities university) throws SQLException {
    List<USNewsHistoricalRanking> USNewsHistoricalRankingsCollection = new ArrayList<USNewsHistoricalRanking>();
    String selectUSNewsRanks = "SELECT USNewsEntryID,UniversityName,UNITID,State,Rank2022,Rank2021,Rank2020,Rank2019,Rank2018,Rank2017,Rank2016,Rank2015,Rank2014,Rank2013 FROM UniversityApplication.USNewsHistoricalRanking WHERE UNITID=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectUSNewsRanks);
      selectStmt.setInt(1, university.getUnitId());
      results = selectStmt.executeQuery();
      while(results.next()) {
        // no need to get unitID
        int resultUSNewsEntryID = results.getInt("usNewsEntryID");
        String universityName = results.getString("UniversityName");
        String state = results.getString("State");
        int rank2022 = results.getInt("Rank2022");
        int rank2021 = results.getInt("Rank2021");
        int rank2020 = results.getInt("Rank2020");
        int rank2019 = results.getInt("Rank2019");
        int rank2018 = results.getInt("Rank2018");
        int rank2017 = results.getInt("Rank2017");
        int rank2016 = results.getInt("Rank2016");
        int rank2015 = results.getInt("Rank2015");
        int rank2014 = results.getInt("Rank2014");
        int rank2013 = results.getInt("Rank2013");
        // just pass in university as parameter
        USNewsHistoricalRanking USNewsHistoricalRanking = new USNewsHistoricalRanking(resultUSNewsEntryID, universityName, university, state, rank2022, rank2021, rank2020, rank2019, rank2018, rank2017, rank2016, rank2015, rank2014, rank2013);
        USNewsHistoricalRankingsCollection.add(USNewsHistoricalRanking);
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
    return USNewsHistoricalRankingsCollection;
  }

  //   Get top 50 USNewsHistoricalRanking in Year 2022
  public List<USNewsHistoricalRanking> getTop50USNewsHistoricalRanking() throws SQLException {
    List<USNewsHistoricalRanking> usNewsHistoricalRankingsCollection = new ArrayList<USNewsHistoricalRanking>();
    String selectUSNewsHistoricalRanks = "SELECT USNewsEntryID,UniversityName,UNITID,State,Rank2022,Rank2021,Rank2020,Rank2019,Rank2018,Rank2017,Rank2016,Rank2015,Rank2014,Rank2013 FROM UniversityApplication.USNewsHistoricalRanking WHERE UNITID IS NOT NULL AND Rank2022 > 0 ORDER BY Rank2022 LIMIT 50;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectUSNewsHistoricalRanks);
      results = selectStmt.executeQuery();
      UniversitiesDao universityDao = UniversitiesDao.getInstance();
      while(results.next()) {
        int usNewsEntryID = results.getInt("USNewsEntryID");
        String universityName = results.getString("UniversityName");
        // directly get unitID from results
        int unitID = results.getInt("UNITID");
        String state = results.getString("State");
        int rank2022 = results.getInt("Rank2022");
        int rank2021 = results.getInt("Rank2021");
        int rank2020 = results.getInt("Rank2020");
        int rank2019 = results.getInt("Rank2019");
        int rank2018 = results.getInt("Rank2018");
        int rank2017 = results.getInt("Rank2017");
        int rank2016 = results.getInt("Rank2016");
        int rank2015 = results.getInt("Rank2015");
        int rank2014 = results.getInt("Rank2014");
        int rank2013 = results.getInt("Rank2013");
        // get corresponding university using unitID
        Universities university = universityDao.getUniversityByUnitId(unitID);
        // pass in university, instead of unitID
        USNewsHistoricalRanking usNewsRank = new USNewsHistoricalRanking(usNewsEntryID, universityName, university, state, rank2022, rank2021, rank2020, rank2019, rank2018, rank2017, rank2016, rank2015, rank2014, rank2013);
        usNewsHistoricalRankingsCollection.add(usNewsRank);
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
    return usNewsHistoricalRankingsCollection;
  }

}
