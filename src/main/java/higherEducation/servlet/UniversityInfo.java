package higherEducation.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

import higherEducation.dal.CampusDao;
import higherEducation.dal.DegreeDao;
import higherEducation.dal.UniversitiesDao;
import higherEducation.model.Campus;
import higherEducation.model.Degree;
import higherEducation.model.Universities;
import higherEducation.model.States;
import higherEducation.model.CIP;
import higherEducation.model.DegreeLevel;
@WebServlet("/university")
public class UniversityInfo extends HttpServlet{
  private UniversitiesDao universitiesDao;
  private CampusDao campusDao;
  private DegreeDao degreeDao;
  public void init() throws ServletException{
    this.universitiesDao=UniversitiesDao.getInstance();
    this.campusDao=CampusDao.getInstance();
    this.degreeDao=DegreeDao.getInstance();

  }
  @Override
  protected void doGet(HttpServletRequest req,HttpServletResponse resp)
  throws ServletException,IOException{

    String UNITID=req.getParameter("UNITID");
    // If input is not valid, show error message to the user
    if (UNITID == null ||
        UNITID.trim().isEmpty() ||
        this.getValidId(UNITID) == -1) {
      req.setAttribute("invalidInput", "Invalid input. Please enter a numeric id.");
      req.getRequestDispatcher("/UniversityInfo.jsp").forward(req, resp);
      return;
    }
    int unitid=this.getValidId(UNITID);
    try{
      Universities university=this.universitiesDao.getUniversityByUnitId(unitid);
      
      if (university == null) {
        req.setAttribute("universityNotFound", "No records found. Please check again");
        req.getRequestDispatcher("/UniversityInfo.jsp").forward(req, resp);
        return;
      }
      List<Campus> campuses=this.campusDao.getCampusFromUNITID(unitid);
      List<Degree> degrees=this.degreeDao.getDegreeFromUNITID(unitid);
      req.setAttribute("university",university);
      req.setAttribute("campuses",campuses);
      req.setAttribute("degrees",degrees);
      req.getRequestDispatcher("/UniversityInfo.jsp").forward(req, resp);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  private Integer getValidId(String id){
    Integer result = -1;
    if (id.matches("[0-9]*[1-9][0-9]*")) {
      result = Integer.valueOf(id);
    }
    return result;

  }
}
