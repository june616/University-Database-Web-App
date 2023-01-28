package higherEducation.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import higherEducation.dal.UniversitiesDao;
import higherEducation.model.Universities;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/find/university")
public class FindUniversity extends HttpServlet {
  private UniversitiesDao universitiesDao;

  public void init() throws ServletException {
    this.universitiesDao=UniversitiesDao.getInstance();


  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String instnm=req.getParameter("instnm");
    System.out.println("instnm"+instnm);
    // If input is not valid, show error message to the user
    if (instnm == null ||
        instnm.trim().isEmpty()) {
      req.setAttribute("invalidInput", "Invalid input. Please enter a valid name.");
      req.getRequestDispatcher("/Home.jsp").forward(req, resp);
      return;
    }
    try{
      List<Universities> universities=this.universitiesDao.getUniversityByName(instnm);
      System.out.println(universities);
      if (universities.size() == 0) {
        req.setAttribute("universityNotFound", "No records found. Please check again");
        req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        return;
      }
      req.setAttribute("universities",universities);
      req.getRequestDispatcher("/Home.jsp").forward(req, resp);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String instnm=req.getParameter("instnm");
    System.out.println("instnm"+instnm);
    // If input is not valid, show error message to the user
    if (instnm == null ||
        instnm.trim().isEmpty()) {
      req.setAttribute("invalidInput", "Invalid input. Please enter a valid name.");
      req.getRequestDispatcher("/Home.jsp").forward(req, resp);
      return;
    }
    try{
      List<Universities> universities=this.universitiesDao.getUniversityByName(instnm);
      System.out.println(universities);
      if (universities.size() == 0) {
        req.setAttribute("universityNotFound", "No records found. Please check again");
        req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        return;
      }
      req.setAttribute("universities",universities);
      req.getRequestDispatcher("/Home.jsp").forward(req, resp);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}

