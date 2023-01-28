package higherEducation.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import higherEducation.model.*;

public class TimesRankingDao {
  protected ConnectionManager connectionManager;
  private static TimesRankingDao instance = null;
  protected TimesRankingDao(){
    connectionManager = new ConnectionManager();
  }
  public static TimesRankingDao getInstance() {
    if(instance == null) {
      instance = new TimesRankingDao();
    }
    return instance;
  }

  public TimesRanking create(TimesRanking timesRank) throws SQLException {
    // 14 attributes (exclude auto-generate key)
    String insertTimesRank =
        "INSERT INTO TimesRanking(WorldRank,UniversityName,UNITID,Teaching,International,Research,Citations,Income,Score,StudentNumber,StudentStaffRatio,InternationalStudentRatio,FemaleStudentRatio,Year)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertTimesRank,
          Statement.RETURN_GENERATED_KEYS);
      insertStmt.setInt(1, timesRank.getWorldRank());
      insertStmt.setString(2, timesRank.getUniversityName());
      insertStmt.setInt(3, timesRank.getUniversity().getUnitId());

      insertStmt.setDouble(4, timesRank.getTeaching());
      insertStmt.setDouble(5, timesRank.getInternational());
      insertStmt.setDouble(6, timesRank.getResearch());
      insertStmt.setDouble(7, timesRank.getCitations());
      insertStmt.setDouble(8, timesRank.getIncome());
      insertStmt.setDouble(9, timesRank.getScore());
      insertStmt.setInt(10, timesRank.getStudentNumber());
      insertStmt.setDouble(11, timesRank.getStudentStaffRatio());
      insertStmt.setDouble(12, timesRank.getInternationalStudentRatio());
      insertStmt.setDouble(13, timesRank.getFemaleStudentRatio());
      insertStmt.setString(14, timesRank.getYear());
      insertStmt.executeUpdate();

      resultKey = insertStmt.getGeneratedKeys();
      int timesEntryID = -1;
      if(resultKey.next()) {
        timesEntryID = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      timesRank.setTimesEntryID(timesEntryID);
      return timesRank;
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

//  public TimesRanking updateRank(TimesRanking timesRank, int newRank) throws SQLException {
//    String updateTimesRank = "UPDATE TimesRanking SET WorldRank=? WHERE TimesEntryID=?;";
//    Connection connection = null;
//    PreparedStatement updateStmt = null;
//    try {
//      connection = connectionManager.getConnection();
//      updateStmt = connection.prepareStatement(updateTimesRank);
//      updateStmt.setInt(1, newRank);
//      updateStmt.setInt(2, timesRank.getTimesEntryID());
//      updateStmt.executeUpdate();
//      timesRank.setWorldRank(newRank);
//      return timesRank;
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

  public TimesRanking delete(TimesRanking timesRank) throws SQLException {
    String deleteTimesRank = "DELETE FROM TimesRanking WHERE TimesEntryID=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try{
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteTimesRank);
      deleteStmt.setInt(1, timesRank.getTimesEntryID());
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

//  public TimesRanking getTimesRankByEntryId(int timesEntryID) throws SQLException {
//    String selectTimesRank = "SELECT TimesEntryID,WorldRank,UniversityName,UNITID,Teaching,International,Research,Citations,Income,Score,StudentNumber,StudentStaffRatio,InternationalStudentRatio,FemaleStudentRatio,Year" + "FROM TimesRanking" + "WHERE TimesEntryID=?;";
//    Connection connection = null;
//    PreparedStatement selectStmt = null;
//    ResultSet results = null;
//    try {
//      connection = connectionManager.getConnection();
//      selectStmt = connection.prepareStatement(selectTimesRank);
//      selectStmt.setInt(1, timesEntryID);
//      results = selectStmt.executeQuery();
//      UniversitiesDao universityDao = UniversitiesDao.getInstance();
//
//      if(results.next()) {
//        int resultTimesEntryID = results.getInt("TimesEntryID");
//        int worldRank = results.getInt("WorldRank");
//        String universityName = results.getString("UniversityName");
//        // directly get unitID from results
//        int unitID = results.getInt("UNITID");
//        double teaching = results.getDouble("Teaching");
//        double international = results.getDouble("International");
//        double research = results.getDouble("Research");
//        double citations = results.getDouble("Citations");
//        double income = results.getDouble("Income");
//        double score = results.getDouble("Score");
//        int studentNumber = results.getInt("StudentNumber");
//        double studentStaffRatio = results.getDouble("StudentStaffRatio");
//        double internationalStudentRatio = results.getDouble("InternationalStudentRatio");
//        double femaleStudentRatio = results.getDouble("FemaleStudentRatio");
//        String year = results.getString("Year");
//        // get corresponding university using unitID
//        Universities university = universityDao.getUniversityByUnitId(unitID);
//        // pass in university, instead of unitID
//        TimesRanking timesRank = new TimesRanking(resultTimesEntryID, worldRank, universityName, university, teaching, international, research, citations, income, score, studentNumber, studentStaffRatio, internationalStudentRatio, femaleStudentRatio, year);
//        return timesRank;
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
  public List<TimesRanking> getTimesRankingForUniversity(Universities university) throws SQLException {
    List<TimesRanking> TimesRankingsCollection = new ArrayList<TimesRanking>();
//    String selectTimesRanks = "SELECT TimesEntryID,WorldRank,UniversityName,UNITID,Teaching,International,Research,Citations,Income,Score,StudentNumber,StudentStaffRatio,InternationalStudentRatio,FemaleStudentRatio,Year" + "FROM TimesRanking" + "WHERE UNITID=?;";
    String selectTimesRanks = "SELECT TimesEntryID,WorldRank,UniversityName,UNITID,Teaching,International,Research,Citations,Income,Score,StudentNumber,StudentStaffRatio,InternationalStudentRatio,FemaleStudentRatio,Year FROM UniversityApplication.TimesRanking WHERE UNITID=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectTimesRanks);
      selectStmt.setInt(1, university.getUnitId());
      results = selectStmt.executeQuery();
      while(results.next()) {
        // no need to get unitID
        int resultTimesEntryID = results.getInt("TimesEntryID");
        int worldRank = results.getInt("WorldRank");
        String universityName = results.getString("UniversityName");
        double teaching = results.getDouble("Teaching");
        double international = results.getDouble("International");
        double research = results.getDouble("Research");
        double citations = results.getDouble("Citations");
        double income = results.getDouble("Income");
        double score = results.getDouble("Score");
        int studentNumber = results.getInt("StudentNumber");
        double studentStaffRatio = results.getDouble("StudentStaffRatio");
        double internationalStudentRatio = results.getDouble("InternationalStudentRatio");
        double femaleStudentRatio = results.getDouble("FemaleStudentRatio");
        String year = results.getString("Year");
        // just pass in university as parameter
        TimesRanking TimesRanking = new TimesRanking(resultTimesEntryID, worldRank, universityName, university, teaching, international, research, citations, income, score, studentNumber, studentStaffRatio, internationalStudentRatio, femaleStudentRatio, year);
        TimesRankingsCollection.add(TimesRanking);
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
    return TimesRankingsCollection;
  }


  //   Get top 50 TimesRanking in Year 2022
  public List<TimesRanking> getTop50TimesRanking() throws SQLException {
    List<TimesRanking> timesRankingsCollection = new ArrayList<TimesRanking>();
    String selectTimesRanks = "SELECT TimesEntryID,WorldRank,UniversityName,UNITID,Teaching,International,Research,Citations,Income,Score,StudentNumber,StudentStaffRatio,InternationalStudentRatio,FemaleStudentRatio,Year FROM UniversityApplication.TimesRanking WHERE Year=2022 AND UNITID IS NOT NULL ORDER BY WorldRank LIMIT 50;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectTimesRanks);
      results = selectStmt.executeQuery();
      UniversitiesDao universityDao = UniversitiesDao.getInstance();
      while(results.next()) {
        int timesEntryID = results.getInt("TimesEntryID");
        int worldRank = results.getInt("WorldRank");
        String universityName = results.getString("UniversityName");
        // directly get unitID from results
        int unitID = results.getInt("UNITID");
        double teaching = results.getDouble("Teaching");
        double international = results.getDouble("International");
        double research = results.getDouble("Research");
        double citations = results.getDouble("Citations");
        double income = results.getDouble("Income");
        double score = results.getDouble("Score");
        int studentNumber = results.getInt("StudentNumber");
        double studentStaffRatio = results.getDouble("StudentStaffRatio");
        double internationalStudentRatio = results.getDouble("InternationalStudentRatio");
        double femaleStudentRatio = results.getDouble("FemaleStudentRatio");
        String year = results.getString("Year");

        // get corresponding university using unitID
        Universities university = universityDao.getUniversityByUnitId(unitID);
        // pass in university, instead of unitID
        TimesRanking timesRank = new TimesRanking(timesEntryID, worldRank, universityName, university, teaching, international, research, citations, income, score, studentNumber, studentStaffRatio, internationalStudentRatio, femaleStudentRatio, year);
        timesRankingsCollection.add(timesRank);
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
    return timesRankingsCollection;
  }

}
