package higherEducation.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import higherEducation.model.States;

public class StatesDao {

    protected ConnectionManager connectionManager;

    // Single pattern: instantiation is limited to one object.
    private static StatesDao instance = null;
    protected StatesDao() {
        connectionManager = new ConnectionManager();
    }
    public static StatesDao getInstance() {
        if(instance == null) {
            instance = new StatesDao();
        }
        return instance;
    }

    public States create(States state)throws SQLException{
        String insertState = "INSERT INTO States(PostalAbbreviation,LargestCity,Capital,StateName,Population,TotalAreaSquareMiles,PerCapitaPersonalIncome) VALUES(?,?,?,?,?,?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertState);
            // PreparedStatement allows us to substitute specific types into the query template.
            // For an overview, see:
            // http://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html.
            // http://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
            // For nullable fields, you can check the property first and then call setNull()
            // as applicable.
            insertStmt.setString(1, state.getPostalAbbreviation());
            insertStmt.setString(2, state.getLargestCity());
            insertStmt.setString(3, state.getCapital());
            insertStmt.setString(4, state.getStateName());
            insertStmt.setInt(5, state.getPopulation());
            insertStmt.setInt(6, state.getTotalAreaSquareMiles());
            insertStmt.setInt(7, state.getPerCapitaPersonalIncome());
            // Note that we call executeUpdate(). This is used for a INSERT/UPDATE/DELETE
            // statements, and it returns an int for the row counts affected (or 0 if the
            // statement returns nothing). For more information, see:
            // http://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
            // I'll leave it as an exercise for you to write UPDATE/DELETE methods.
            insertStmt.executeUpdate();

            // Note 1: if this was an UPDATE statement, then the person fields should be
            // updated before returning to the caller.
            // Note 2: there are no auto-generated keys, so no update to perform on the
            // input param person.
            return state;
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

    public States getStateByPostalAbbreviation(String postalAbbreviation)throws SQLException{
        String selectState =
            "SELECT PostalAbbreviation,LargestCity,Capital,StateName,Population,TotalAreaSquareMiles,PerCapitaPersonalIncome " +
                "FROM States " +
                "WHERE PostalAbbreviation=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectState);
            selectStmt.setString(1, postalAbbreviation);
            results = selectStmt.executeQuery();

            if(results.next()) {
                String resultPostalAbbreviation = results.getString("PostalAbbreviation");
                String largestCity = results.getString("LargestCity");
                String capital = results.getString("Capital");
                String stateName = results.getString("StateName");
                int population = results.getInt("Population");
                int totalAreaSquareMiles = results.getInt("TotalAreaSquareMiles");
                int perCapitaPersonalIncome = results.getInt("PerCapitaPersonalIncome");
                States state = new States(resultPostalAbbreviation,largestCity,capital,stateName,population,totalAreaSquareMiles,perCapitaPersonalIncome);
                return state;
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

    public States updateLargestCity(States oldState, String largestCity)throws SQLException{
        String updateState = "UPDATE States SET LargestCity=? WHERE PostalAbbreviation=?;";
        Connection connection = null;
        PreparedStatement updateStmt = null;
        try {
            connection = connectionManager.getConnection();
            updateStmt = connection.prepareStatement(updateState);

            updateStmt.setString(1, largestCity);
            updateStmt.setString(2, oldState.getPostalAbbreviation());
            updateStmt.executeUpdate();

            oldState.setLargestCity(largestCity);

            return oldState;
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

    public States updateCapital(States oldState, String capital)throws SQLException{
        String updateState = "UPDATE States SET Capital=? WHERE PostalAbbreviation=?;";
        Connection connection = null;
        PreparedStatement updateStmt = null;
        try {
            connection = connectionManager.getConnection();
            updateStmt = connection.prepareStatement(updateState);

            updateStmt.setString(1, capital);
            updateStmt.setString(2, oldState.getPostalAbbreviation());
            updateStmt.executeUpdate();

            oldState.setCapital(capital);

            return oldState;
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

    public States updatePopulation(States oldState, int population)throws SQLException{
        String updateState = "UPDATE States SET Population=? WHERE PostalAbbreviation=?;";
        Connection connection = null;
        PreparedStatement updateStmt = null;
        try {
            connection = connectionManager.getConnection();
            updateStmt = connection.prepareStatement(updateState);

            updateStmt.setInt(1, population);
            updateStmt.setString(2, oldState.getPostalAbbreviation());
            updateStmt.executeUpdate();

            oldState.setPopulation(population);

            return oldState;
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

    public States updateTotalAreaSquareMiles(States oldState, int totalAreaSquareMiles)throws SQLException{
        String updateState = "UPDATE States SET TotalAreaSquareMiles=? WHERE PostalAbbreviation=?;";
        Connection connection = null;
        PreparedStatement updateStmt = null;
        try {
            connection = connectionManager.getConnection();
            updateStmt = connection.prepareStatement(updateState);

            updateStmt.setInt(1, totalAreaSquareMiles);
            updateStmt.setString(2, oldState.getPostalAbbreviation());
            updateStmt.executeUpdate();

            oldState.setTotalAreaSquareMiles(totalAreaSquareMiles);

            return oldState;
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

    public States updatePerCapitaPersonalIncome(States oldState, int perCapitaPersonalIncome)throws SQLException{
        String updateState = "UPDATE States SET PerCapitaPersonalIncome=? WHERE PostalAbbreviation=?;";
        Connection connection = null;
        PreparedStatement updateStmt = null;
        try {
            connection = connectionManager.getConnection();
            updateStmt = connection.prepareStatement(updateState);

            updateStmt.setInt(1, perCapitaPersonalIncome);
            updateStmt.setString(2, oldState.getPostalAbbreviation());
            updateStmt.executeUpdate();

            oldState.setPerCapitaPersonalIncome(perCapitaPersonalIncome);

            return oldState;
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

    public States delete(States state)throws SQLException{
        String deleteState = "DELETE FROM States WHERE PostalAbbreviation=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deleteState);
            deleteStmt.setString(1, state.getPostalAbbreviation());
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
}
