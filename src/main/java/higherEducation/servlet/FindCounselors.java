package higherEducation.servlet;

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

@WebServlet("/find/counselors")
public class FindCounselors extends HttpServlet {
  // Use to find Counselors's basic information
  private PersonsDao personsDao;
  private CounselorsDao counselorsDao;
  // Use to find the reservations of this counselor;
  private ReservationsDao reservationsDao;
  
  @Override
  public void init() throws ServletException {
    this.personsDao = PersonsDao.getInstance();
    this.counselorsDao = CounselorsDao.getInstance();
    this.reservationsDao = ReservationsDao.getInstance();
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String counselorId = req.getParameter("counselorId");

    // If input is not valid, show error message to the user
    if (counselorId == null ||
    		counselorId.trim().isEmpty() ||
        this.getValidId(counselorId) == -1) {
      req.setAttribute("invalidInput", "Invalid input. Please enter a numeric id.");
      req.getRequestDispatcher("/FindCounselors.jsp").forward(req, resp);
      return;
    }

    int id = this.getValidId(counselorId);
    try {
    	Counselors counselor = this.counselorsDao.getCounselorByPersonId(id);
      if (counselor == null) {
        req.setAttribute("counselorNotFound", "No records found. Please use ID between 01001-19999 and try again");
        req.getRequestDispatcher("/FindCounselors.jsp").forward(req, resp);
        return;
      }
      Persons person = this.personsDao.getPersonFromPersonId(id);
      req.setAttribute("person", person);
      req.setAttribute("counselor", counselor);

      reservationsHandler(req, id);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    req.getRequestDispatcher("/FindCounselorsResult.jsp").forward(req, resp);
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
  
  private void reservationsHandler (HttpServletRequest req, Integer personId) throws SQLException {
	    List<Reservations> reservationsAsParticipant =
	        this.reservationsDao.getReservationsAsParticipantByPersonId(personId);
	    List<Reservations> reservationsAsHost =
	        this.reservationsDao.getReservationsAsHostByPersonId(personId);
	    req.setAttribute("reservationsAsParticipant", reservationsAsParticipant);
	    req.setAttribute("reservationsAsHost", reservationsAsHost);
	  }
}