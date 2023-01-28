package higherEducation.servlet;

import higherEducation.dal.*;
import higherEducation.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/applicantcreate")
public class ApplicantCreate extends HttpServlet {
	
	protected ApplicantsDao applicantsDao;
	
	@Override
	public void init() throws ServletException {
		applicantsDao = ApplicantsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/ApplicantCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String id = req.getParameter("personid");
        int personId;
        try {
        	personId = Integer.parseInt(id);
        	Applicants applicant = applicantsDao.getApplicantByPersonId(personId);
        	if (applicant != null) {
        		throw new IOException("The person id is already in use!");
        	}
    	} catch (Exception e) {
    		e.printStackTrace();
			throw new IOException(e);
    	}
        
        if (id == null || id.trim().isEmpty() || personId < 20001) {
            messages.put("success", "Invalid person ID");
        } else {
        	// Create the Applicant	
        	String userName = req.getParameter("username");
        	String passCode = req.getParameter("passcode");
        	String firstName = req.getParameter("firstname");
        	String lastName = req.getParameter("lastname");
        	String email = req.getParameter("email");	
        	String gender = req.getParameter("gender").toLowerCase();
        	// dob must be in the format yyyy-mm-dd.
        	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	String stringDob = req.getParameter("dob");
        	Date dob = new Date();
        	try {
        		dob = dateFormat.parse(stringDob);
        	} catch (ParseException e) {
        		e.printStackTrace();
				throw new IOException(e);
        	}
        	boolean seekingCounselor = Boolean.valueOf(req.getParameter("seekingcounselor"));
        	String highSchool = req.getParameter("highschool");
        	String city = req.getParameter("city");
        	String state = req.getParameter("state");
        	String zipCode = req.getParameter("zipcode");
        	String raceEthnicity = req.getParameter("raceethnicity");
        	String parentEduLevel = req.getParameter("parentedulevel");
	        try {
	        	// Exercise: parse the input for StatusLevel.
	        	Applicants applicant = new Applicants(personId, userName, passCode, firstName, lastName, email, Applicants.Gender.valueOf(gender),dob,seekingCounselor,highSchool, city, state,zipCode, raceEthnicity,parentEduLevel);
	        	applicant = applicantsDao.create(applicant);
	        	messages.put("success", "Successfully created " + userName);
	        	messages.put("disableSubmit", "true");
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/ApplicantCreate.jsp").forward(req, resp);
    }
}