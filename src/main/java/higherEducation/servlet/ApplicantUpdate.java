package higherEducation.servlet;

import higherEducation.dal.*;
import higherEducation.model.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/applicantupdate")
public class ApplicantUpdate extends HttpServlet {
	
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

        // Retrieve user and validate.
        String id = req.getParameter("personid");
        int personId;
        if (id == null || id.trim().isEmpty()) {
            messages.put("success", "Please enter a valid person id.");
        } else {
        	try {
        		personId = Integer.parseInt(id);
        		Applicants  applicant = applicantsDao.getApplicantByPersonId(personId);
        		if(applicant == null) {
        			messages.put("success", "Applicant does not exist.");
        		}
        		req.setAttribute("applicant", applicant);
        	} catch (Exception e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/ApplicantUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String id = req.getParameter("personid");
        if (id == null || id.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserName.");
        } else {
        	try {
        		int personId = Integer.parseInt(id);
        		Applicants applicant = applicantsDao.getApplicantByPersonId(personId);
        		if(applicant == null) {
        			messages.put("success", "person Id does not exist. No update to perform.");
        		} else {
        			Boolean seekingCounselor = Boolean.valueOf(req.getParameter("seekingcounselor"));
        	        messages.put("success", "Please enter true or false.");
        	        applicant = applicantsDao.updateSeekingCounselors(applicant, seekingCounselor);
        	        messages.put("success", "Successfully updated person id: " + personId);
        	        }
        		req.setAttribute("applicant", applicant);
        	} catch (Exception e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/ApplicantUpdate.jsp").forward(req, resp);
    }
}