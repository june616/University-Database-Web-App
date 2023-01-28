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


@WebServlet("/applicantdelete")
public class ApplicantDelete extends HttpServlet {
	
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
        // Provide a title and render the JSP.
        messages.put("title", "Delete Applicant");        
        req.getRequestDispatcher("/ApplicantDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String id = req.getParameter("personid");
        if (id == null || id.trim().isEmpty()) {
            messages.put("title", "Invalid UserName");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the BlogUser.
        	try {
        		int personId = Integer.parseInt(id);
        		Applicants applicant = applicantsDao.getApplicantByPersonId(personId);
	     
        		applicant = applicantsDao.delete(applicant);
	        	// Update the message.
		        if (applicant == null) {
		            messages.put("title", "Successfully deleted person id: " + personId);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + personId);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (Exception e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/ApplicantDelete.jsp").forward(req, resp);
    }
}