package higherEducation.servlet;


import higherEducation.dal.ApplicantsDao;
import higherEducation.dal.CollectionsDao;
import higherEducation.dal.CommentsDao;
import higherEducation.dal.CommentsLikeDao;
import higherEducation.dal.CounselorsDao;
import higherEducation.dal.PersonsDao;
import higherEducation.dal.ReservationsDao;
import higherEducation.model.Applicants;
import higherEducation.model.Collections;
import higherEducation.model.Comments;
import higherEducation.model.CommentsLike;
import higherEducation.model.Counselors;
import higherEducation.model.Persons;
import higherEducation.model.Reservations;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/find/applications")
public class FindApplicants extends HttpServlet {
  // Use to find application's basic information
  private PersonsDao personsDao;
  private ApplicantsDao applicantsDao;
  // Use to find the university applicant collected
  private CollectionsDao collectionsDao;
  // Use to find the comments made by this applicant
  private CommentsDao commentsDao;
  // Use to find the comments this applicant like
  private CommentsLikeDao commentsLikeDao;
  // Use to find the reservations of this applicant
  private ReservationsDao reservationsDao;

  @Override
  public void init() throws ServletException {
    this.personsDao = PersonsDao.getInstance();
    this.applicantsDao = ApplicantsDao.getInstance();
    this.collectionsDao = CollectionsDao.getInstance();
    this.commentsDao = CommentsDao.getInstance();
    this.commentsLikeDao = CommentsLikeDao.getInstance();
    this.reservationsDao = ReservationsDao.getInstance();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String applicantId = req.getParameter("applicantId");

    // If input is not valid, show error message to the user
    if (applicantId == null ||
        applicantId.trim().isEmpty() ||
        this.getValidId(applicantId) == -1) {
      req.setAttribute("invalidInput", "Invalid input. Please enter a numeric id.");
      req.getRequestDispatcher("/FindApplicants.jsp").forward(req, resp);
      return;
    }

    int id = this.getValidId(applicantId);
    try {
      Applicants applicant = this.applicantsDao.getApplicantByPersonId(id);
      if (applicant == null) {
        req.setAttribute("applicantNotFound", "No records found. Please check again");
        req.getRequestDispatcher("/FindApplicants.jsp").forward(req, resp);
        return;
      }
      Persons person = this.personsDao.getPersonFromPersonId(id);
      req.setAttribute("person", person);
      req.setAttribute("applicant", applicant);

      collectionsHandler(req, id);
      commentsHandler(req, id);
      commentsLikeHandler(req, id);
      reservationsHandler(req, id);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    req.getRequestDispatcher("/FindApplicantsResult.jsp").forward(req, resp);  
  }

  /**
   * Validate string input id.
   * Allow leading 0s in the input. for example:
   * 00009 is allowed and will be parsed as 9
   * @param id input needs validation
   * @return integer id, if not valid, return -1;
   */
  private Integer getValidId(String id) {
    Integer result = -1;
    if (id.matches("[0-9]*[1-9][0-9]*")) {
      result = Integer.valueOf(id);
    }
    return result;
  }

  /**
   * handler for collections, use to collect collections made by personId
   * @param req http request
   * @param personId the author of a collection
   * @throws SQLException
   */
  private void collectionsHandler(HttpServletRequest req, Integer personId) throws SQLException {
    List<Collections> collections = this.collectionsDao.getCollectionsMadeByPersonId(personId);
    req.setAttribute("collections", collections);
  }

  private void commentsHandler(HttpServletRequest req, Integer personId) throws SQLException {
    List<Comments> comments = this.commentsDao.getCommentsByPersonId(personId);
    req.setAttribute("comments", comments);
  }

  private void commentsLikeHandler(HttpServletRequest req, Integer personId) throws SQLException {
    List<CommentsLike> commentsLikes = this.commentsLikeDao.getCommentsLikeByPersonId(personId);
    req.setAttribute("commentsLikes", commentsLikes);
  }

  private void reservationsHandler (HttpServletRequest req, Integer personId) throws SQLException {
    List<Reservations> reservationsAsParticipant =
        this.reservationsDao.getReservationsAsParticipantByPersonId(personId);
    List<Reservations> reservationsAsHost =
        this.reservationsDao.getReservationsAsHostByPersonId(personId);
    req.setAttribute("reservationsAsParticipant", reservationsAsParticipant);
    req.setAttribute("reservationsAsHost", reservationsAsHost);
  }
}