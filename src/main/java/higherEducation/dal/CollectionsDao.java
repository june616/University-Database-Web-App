package higherEducation.dal;

import higherEducation.model.Collections;
import higherEducation.model.Comments;
import higherEducation.model.Persons;
import higherEducation.model.Universities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CollectionsDao {
  protected ConnectionManager connectionManager;

  private static CollectionsDao instance = null;

  protected CollectionsDao() {
    connectionManager = new ConnectionManager();
  }
  public static CollectionsDao getInstance() {
    if (instance == null) {
      instance = new CollectionsDao();
    }
    return instance;
  }

  public Collections create(Collections collection) throws SQLException {
    String insertCollection = "INSERT INTO collections (PersonId, UNITID, Notes) "
        + "VALUES (?, ?, ?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;

    try {
      connection = this.connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertCollection, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setInt(1, collection.getPersons().getPersonId());
      insertStmt.setInt(2, collection.getUniversities().getUnitId());
      insertStmt.setString(3, collection.getNotes());
      insertStmt.executeUpdate();
      resultKey = insertStmt.getGeneratedKeys();
      int collectionId = -1;
      if (resultKey.next()) {
        collectionId = resultKey.getInt(1);
      }else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      collection.setCollectionsId(collectionId);
      return collection;
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

  public Collections getCollectionById(int collectionId) throws SQLException {
    String selectCollection = "SELECT * FROM collections WHERE CollectionId = ?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = this.connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectCollection);
      selectStmt.setInt(1, collectionId);
      results = selectStmt.executeQuery();
      List<Collections> c = this.selectResultHandler(results, 1);
      if (c.size() != 0) return c.get(0);
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


  public List<Collections> getCollectionsMadeByPersonId(Integer personId) throws SQLException {
    String selectCollections = "SELECT * FROM collections WHERE personId = ?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    List<Collections> collections;
    try {
      connection = this.connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectCollections);
      selectStmt.setInt(1, personId);
      results = selectStmt.executeQuery();
      collections = this.selectResultHandler(results, -1);
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
    return collections;
  }


  public Collections updateCollectionNote(Collections collection, String newNotes) throws SQLException {
    String updateCollection = "UPDATE collections SET Notes = ? WHERE CollectionId = ?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;

    try {
      connection = this.connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateCollection);
      updateStmt.setString(1, newNotes);
      updateStmt.setInt(2, collection.getCollectionsId());
      updateStmt.executeUpdate();
      collection.setNotes(newNotes);
      return collection;
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

  public Collections delete(Collections collection) throws SQLException {
    String deleteCollections =
        "DELETE FROM collections WHERE CollectionId = ?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;

    try {
      connection = this.connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteCollections);

      deleteStmt.setInt(1, collection.getCollectionsId());
      int affectedRows = deleteStmt.executeUpdate();
      if (affectedRows == 0) {
        throw new SQLException("No records available to delete for collectionId=" + collection.getCollectionsId());
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

  private List<Collections> selectResultHandler(ResultSet results, Integer limit)
      throws SQLException {
    Integer counter = 0;
    if (limit == -1) limit = Integer.MAX_VALUE;
    PersonsDao personsDao = PersonsDao.getInstance();
    UniversitiesDao universitiesDao = UniversitiesDao.getInstance();
    List<Collections> collections = new ArrayList<>();
    while (results.next() && counter < limit) {
      Integer resultCollectionId = results.getInt("CollectionId");
      Persons p = personsDao.getPersonFromPersonId(
          results.getInt("PersonId")
      );
      Universities u = universitiesDao.getUniversityByUnitId(
          results.getInt("UNITID")
      );
      String resultNotes = results.getString("Notes");
      Collections c = new Collections(resultCollectionId, u, p, resultNotes);
      collections.add(c);
      counter ++;
    }
    return collections;
  }
}
