package higherEducation.dal;

import higherEducation.model.Comments;
import higherEducation.model.Persons;
import higherEducation.model.Universities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentsDao {
  private ConnectionManager connectionManager;

  private static CommentsDao instance = null;
  protected CommentsDao() {
    connectionManager = new ConnectionManager();
  }
  public static CommentsDao getInstance() {
    if (instance == null) {
      instance = new CommentsDao();
    }
    return instance;
  }

  public Comments create(Comments comment) throws SQLException {
    String insertComment = "INSERT INTO comments (content, createAt, UNITID, applicantID) "
        + "VALUES (?, ?, ?, ?)";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;

    try {
      connection = this.connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertComment, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, comment.getContent());
      insertStmt.setTimestamp(2, new Timestamp(comment.getCreateAt().getTime()));
      insertStmt.setInt(3, comment.getUniversity().getUnitId());
      insertStmt.setInt(4, comment.getPerson().getPersonId());
      insertStmt.executeUpdate();
      resultKey = insertStmt.getGeneratedKeys();
      int commentId = -1;
      if (resultKey.next()) {
        commentId = resultKey.getInt(1);
      }else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      comment.setCommentsId(commentId);
      return comment;
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

  public Comments getCommentById(int commentId) throws SQLException {
    String selectComment = "SELECT * FROM comments WHERE commentID = ?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = this.connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectComment);
      selectStmt.setInt(1, commentId);
      results = selectStmt.executeQuery();
      List<Comments> c = this.selectResultHandler(results, 1);
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

  public List<Comments> getCommentsByPersonId(Integer personId) throws SQLException {
    String selectComment = "SELECT * FROM comments WHERE applicantID = ?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    List<Comments> comments;
    try {
      connection = this.connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectComment);
      selectStmt.setInt(1, personId);
      results = selectStmt.executeQuery();
      comments = this.selectResultHandler(results, -1);
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
    return comments;
  }

  public Comments updateCommentContent(Comments comment, String newContent) throws SQLException {
    String updateContent = "UPDATE comments SET content = ? WHERE commentID = ?;";
    Connection connection = null;
    PreparedStatement updateStmt= null;

    try {
      connection = this.connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateContent);
      updateStmt.setString(1, newContent);
      updateStmt.setInt(2, comment.getCommentsId());
      updateStmt.executeUpdate();
      comment.setContent(newContent);
      return comment;
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


  public Comments delete(Comments comment) throws SQLException {
    String deleteComment = "DELETE FROM comments WHERE commentID = ?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;

    try {
      connection = this.connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteComment);
      deleteStmt.setInt(1, comment.getCommentsId());
      int affectedRows = deleteStmt.executeUpdate();
      if (affectedRows == 0) {
        throw new SQLException("No records available to delete for commentId=" + comment.getCommentsId());
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

  private List<Comments> selectResultHandler(ResultSet results, Integer limit)
      throws SQLException {
    Integer counter = 0;
    if (limit == -1) limit = Integer.MAX_VALUE;
    PersonsDao personsDao = PersonsDao.getInstance();
    UniversitiesDao universitiesDao = UniversitiesDao.getInstance();
    List<Comments> comments = new ArrayList<>();
    while (results.next() && counter < limit) {
      Integer resultCommentId = results.getInt("commentID");
      String resultContent = results.getString("content");
      Date resultCreateAt = new Date(results.getTimestamp("createAt").getTime());
      Universities u = universitiesDao.getUniversityByUnitId(
          results.getInt("UNITID")
      );
      Persons p = personsDao.getPersonFromPersonId(
          results.getInt("applicantID")
      );
      Comments c = new Comments(resultCommentId, resultContent, resultCreateAt, u, p);
      comments.add(c);
      counter ++;
    }
    return comments;
  }
}
