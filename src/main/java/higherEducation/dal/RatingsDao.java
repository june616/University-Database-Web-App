package higherEducation.dal;

import higherEducation.model.Persons;
import higherEducation.model.Ratings;
import higherEducation.model.Universities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RatingsDao {

    protected ConnectionManager connectionManager;

    // Single pattern: instantiation is limited to one object.
    private static RatingsDao instance = null;
    protected RatingsDao() {
        connectionManager = new ConnectionManager();
    }
    public static RatingsDao getInstance() {
        if(instance == null) {
            instance = new RatingsDao();
        }
        return instance;
    }

    public Ratings create(Ratings rating)  throws SQLException{
        String insertRating = "INSERT INTO Ratings(RatingValue,PersonId,UNITID) VALUES(?,?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        ResultSet resultKey = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertRating, Statement.RETURN_GENERATED_KEYS);
            insertStmt.setFloat(1,rating.getRatingValue());
            insertStmt.setInt(2,rating.getPerson().getPersonId());
            insertStmt.setInt(3,rating.getUniversity().getUnitId());
            insertStmt.executeUpdate();
            resultKey = insertStmt.getGeneratedKeys();
            int ratingId = -1;
            if(resultKey.next()) {
                ratingId = resultKey.getInt(1);
            }else {
                throw new SQLException("Unable to retrieve auto-generated key.");
            }
            rating.setRatingId(ratingId);
            return rating;
        }catch (SQLException e) {
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

    public Ratings updateRatingValue(Ratings ratings, float newRatingValue)throws SQLException{
        String updateRating = "UPDATE Ratings SET RatingValue=? WHERE RatingId=?;";
        Connection connection = null;
        PreparedStatement updateStmt = null;
        try {
            connection = connectionManager.getConnection();
            updateStmt = connection.prepareStatement(updateRating);
            updateStmt.setFloat(1, newRatingValue);
            updateStmt.setInt(2, ratings.getRatingId());
            updateStmt.executeUpdate();
            ratings.setRatingValue(newRatingValue);
            return ratings;
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

    public Ratings delete(Ratings ratings) throws SQLException{
        String deleteRating = "DELETE FROM Ratings WHERE RatingId=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deleteRating);
            deleteStmt.setInt(1, ratings.getRatingId());
            deleteStmt.executeUpdate();

            // Return null so the caller can no longer operate on the BlogPosts instance.
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

    public Ratings getRatingsByRatingId(int ratingId) throws SQLException{
        String selectRating = "SELECT RatingId,RatingValue,PersonId,UNITID FROM Ratings WHERE RatingId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectRating);
            selectStmt.setInt(1, ratingId);
            results = selectStmt.executeQuery();
            PersonsDao personsDao = PersonsDao.getInstance();
            UniversitiesDao universitiesDao = UniversitiesDao.getInstance();
            if(results.next()) {
                int resultRatingId = results.getInt("RatingId");
                float ratingValue = results.getFloat("RatingValue");
                int personId = results.getInt("PersonId");
                int unitId = results.getInt("UNITID");

                Persons person = personsDao.getPersonFromPersonId(personId);
                Universities university = universitiesDao.getUniversityByUnitId(unitId);
                Ratings rating = new Ratings(resultRatingId,ratingValue,person,university);
                return rating;
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

    public List<Ratings> getRatingsByUniversity(Universities university)throws SQLException{
        List<Ratings> ratingsList = new ArrayList<>();
        String selectRatings =
            "SELECT RatingId,RatingValue,PersonId,UNITID " +
                "FROM Ratings " +
                "WHERE UNITID=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectRatings);
            selectStmt.setInt(1, university.getUnitId());
            results = selectStmt.executeQuery();
            PersonsDao personsDao = PersonsDao.getInstance();
            while(results.next()) {
                int ratingId = results.getInt("RatingId");
                float ratingValue = results.getFloat("RatingValue");
                int personId = results.getInt("PersonId");

                Persons person = personsDao.getPersonFromPersonId(personId);
                Ratings rating = new Ratings(ratingId,ratingValue,person,university);
                ratingsList.add(rating);
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
        return ratingsList;
    }

    public List<Ratings> getRatingsByPerson(Persons person)throws SQLException{
        List<Ratings> ratingsList = new ArrayList<>();
        String selectRatings =
            "SELECT RatingId,RatingValue,PersonId,UNITID " +
                "FROM Ratings " +
                "WHERE PersonId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectRatings);
            selectStmt.setInt(1, person.getPersonId());
            results = selectStmt.executeQuery();
            UniversitiesDao universitiesDao = UniversitiesDao.getInstance();
            while(results.next()) {
                int ratingId = results.getInt("RatingId");
                float ratingValue = results.getFloat("RatingValue");
                int universityId = results.getInt("UNITID");

                Universities university = universitiesDao.getUniversityByUnitId(universityId);
                Ratings rating = new Ratings(ratingId,ratingValue,person,university);
                ratingsList.add(rating);
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
        return ratingsList;
    }




}
