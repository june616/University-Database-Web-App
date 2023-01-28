package higherEducation.dal;

import higherEducation.model.Persons;
import higherEducation.model.Reservations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Reservations DAO
 */
public class ReservationsDao {
  protected ConnectionManager connectionManager;

  /**
   * Singleton pattern
   */
  private static ReservationsDao instance = null;
  protected ReservationsDao() {
    connectionManager = new ConnectionManager();
  }
  public static ReservationsDao getInstance() {
    if (instance == null) {
      instance = new ReservationsDao();
    }
    return instance;
  }

  /**
   * Create a new reservation instance in MySql;
   * @param reservation new reservation
   * @return newly created reservation
   * @throws SQLException if can't get auto-generated key
   */
  public Reservations create(Reservations reservation) throws SQLException {
    String insertReservation = "INSERT INTO reservations(createAt, eventTitle, eventBegin, eventEnd, hostID, participantID)"
        + "VALUES (?, ?, ?, ?, ?, ?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = this.connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertReservation, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setTimestamp(1, new Timestamp(reservation.getCreateAt().getTime()));
      insertStmt.setString(2, reservation.getEventTitle());
      insertStmt.setTimestamp(3, new Timestamp(reservation.getEventBegin().getTime()));
      insertStmt.setTimestamp(4, new Timestamp(reservation.getEventEnd().getTime()));
      insertStmt.setInt(5, reservation.getHost().getPersonId());
      insertStmt.setInt(6, reservation.getParticipant().getPersonId());
      insertStmt.executeUpdate();
      resultKey = insertStmt.getGeneratedKeys();
      int reservationId = -1;
      if (resultKey.next()) {
        reservationId = resultKey.getInt(1);
      }else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      reservation.setReservationId(reservationId);
      return reservation;
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

  public Reservations getReservationById(int reservationId) throws SQLException {
    String selectReservation = "SELECT * FROM reservations WHERE reservationID = ?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = this.connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectReservation);
      selectStmt.setInt(1, reservationId);
      results = selectStmt.executeQuery();
      List<Reservations> r = this.selectResultHandler(results, 1);
      if (r.size() != 0) return r.get(0);
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

  public List<Reservations> getReservationsAsParticipantByPersonId(Integer personId)
      throws SQLException {
    String selectReservation = "SELECT * FROM reservations WHERE participantID = ?;";
    return getReservationsByPersonId(selectReservation, personId);
  }

  public List<Reservations> getReservationsAsHostByPersonId(Integer personId) throws SQLException {
    String selectReservation = "SELECT * FROM reservations WHERE hostID = ?;";
    return getReservationsByPersonId(selectReservation, personId);
  }

  private List<Reservations> getReservationsByPersonId(
      String selectReservation, Integer personId) throws SQLException {
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    List<Reservations> reservations;
    try {
      connection = this.connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectReservation);
      selectStmt.setInt(1, personId);
      results = selectStmt.executeQuery();
      reservations = this.selectResultHandler(results, -1);
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
    return reservations;
  }

  public Reservations updateReservationTitle(Reservations reservations, String newTitle)
      throws SQLException {
    String updateReservationTitle =
        "UPDATE reservations SET eventTitle = ? WHERE reservationID = ?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;

    try {
      connection = this.connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateReservationTitle);
      updateStmt.setString(1, newTitle);
      updateStmt.setInt(2, reservations.getReservationId());
      updateStmt.executeUpdate();
      reservations.setEventTitle(newTitle);
      return reservations;
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

  public Reservations delete(Reservations reservation) throws SQLException {
    String deleteReviews = "DELETE FROM reservations WHERE reservationID = ?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;

    try {
      connection = this.connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteReviews);
      deleteStmt.setInt(1, reservation.getReservationId());
      int affectedRows = deleteStmt.executeUpdate();
      if (affectedRows == 0) {
        throw new SQLException("No records available to delete for ReservationId=" + reservation.getReservationId());
      }
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

  private List<Reservations> selectResultHandler(ResultSet results, Integer limit)
      throws SQLException {
    Integer counter = 0;
    if (limit == -1) limit = Integer.MAX_VALUE;
    PersonsDao personsDao = PersonsDao.getInstance();
    List<Reservations> reservations = new ArrayList<>();
    while (results.next() && counter < limit) {
      Integer resultReservationId = results.getInt("reservationID");
      Date resultCreatedAt = new Date(results.getTimestamp("createAt").getTime());
      String resultTitle = results.getString("eventTitle");
      Date resultBegin = new Date(results.getTimestamp("eventBegin").getTime());
      Date resultEnd = new Date(results.getTimestamp("eventEnd").getTime());
      Persons resultHost = personsDao.getPersonFromPersonId(results.getInt("hostID"));
      Persons resultParticipant = personsDao.getPersonFromPersonId(results.getInt("participantID"));
      Reservations r =
          new Reservations(resultReservationId, resultCreatedAt, resultTitle, resultBegin, resultEnd, resultHost, resultParticipant);
      reservations.add(r);
      counter ++;
    }
    return reservations;
  }
}
