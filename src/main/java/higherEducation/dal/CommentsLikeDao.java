package higherEducation.dal;

import higherEducation.model.Comments;
import higherEducation.model.CommentsLike;
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

public class CommentsLikeDao {
  private ConnectionManager connectionManager;

  private static CommentsLikeDao instance = null;
  protected CommentsLikeDao() {
    connectionManager = new ConnectionManager();
  }
  public static CommentsLikeDao getInstance() {
    if (instance == null) {
      instance = new CommentsLikeDao();
    }
    return instance;
  }

  public CommentsLike create(CommentsLike commentsLike) throws SQLException {
    String insertCommentLike = "INSERT INTO commentslike (createAt, PersonID, commentID) "
        + "VALUES (?, ?, ?)";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = this.connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertCommentLike, Statement.RETURN_GENERATED_KEYS);
      insertStmt.setTimestamp(1, new Timestamp(commentsLike.getCreateAt().getTime()));
      insertStmt.setInt(2, commentsLike.getPerson().getPersonId());
      insertStmt.setInt(3, commentsLike.getComment().getCommentsId());
      insertStmt.executeUpdate();
      resultKey = insertStmt.getGeneratedKeys();
      int commentLikeId = -1;
      if (resultKey.next()) {
        commentLikeId = resultKey.getInt(1);
      }else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      commentsLike.setCommentsLikeId(commentLikeId);
      return commentsLike;
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

  public CommentsLike getCommentsLikeById(int commentsLikeId) throws SQLException {
    String selectCommentsLike = "SELECT * FROM commentslike WHERE likeID = ?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = this.connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectCommentsLike);
      selectStmt.setInt(1, commentsLikeId);
      results = selectStmt.executeQuery();
      List<CommentsLike> c = this.selectResultHandler(results, 1);
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

  public List<CommentsLike> getCommentsLikeByPersonId(Integer personId) throws SQLException {
    String selectCommentsLike = "SELECT * FROM commentslike WHERE PersonID = ?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    List<CommentsLike> commentsLikes;
    try {
      connection = this.connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectCommentsLike);
      selectStmt.setInt(1, personId);
      results = selectStmt.executeQuery();
      commentsLikes = this.selectResultHandler(results, -1);
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
    return commentsLikes;
  }

  public CommentsLike delete(CommentsLike commentsLike) throws SQLException {
    String deleteComment = "DELETE FROM commentslike WHERE likeID = ?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;

    try {
      connection = this.connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteComment);
      deleteStmt.setInt(1, commentsLike.getCommentsLikeId());
      int affectedRows = deleteStmt.executeUpdate();
      if (affectedRows == 0) {
        throw new SQLException("No records available to delete for commentsLikeId=" + commentsLike.getCommentsLikeId());
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
  };

  private List<CommentsLike> selectResultHandler(ResultSet results, Integer limit)
      throws SQLException {
    Integer counter = 0;
    if (limit == -1) limit = Integer.MAX_VALUE;
    PersonsDao personsDao = PersonsDao.getInstance();
    CommentsDao commentsDao = CommentsDao.getInstance();
    List<CommentsLike> commentsLikes = new ArrayList<>();
    while (results.next() && counter < limit) {
      Integer resultCommentLikeId = results.getInt("likeID");
      Date resultCreateAt = new Date(results.getTimestamp("createAt").getTime());
      Persons p = personsDao.getPersonFromPersonId(
          results.getInt("PersonID")
      );
      Comments c = commentsDao.getCommentById(
          results.getInt("commentID")
      );
      CommentsLike cl = new CommentsLike(resultCommentLikeId, resultCreateAt, c, p);
      commentsLikes.add(cl);
      counter ++;
    }
    return commentsLikes;
  }
}
