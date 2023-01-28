package higherEducation.tools;

import higherEducation.dal.*;
import higherEducation.model.*;

import java.sql.SQLException;
import java.sql.Timestamp;


/**
 * main() runner, used for the app demo.
 * 
 * Instructions:
 * 1. Create a new MySQL schema and then run the CREATE TABLE statements from lecture:
 * http://goo.gl/86a11H.
 * 2. Update ConnectionManager with the correct user, password, and schema.
 */
public class Inserter {

	public static void main(String[] args) throws SQLException {
//		PersonsDao personsDao = PersonsDao.getInstance();
		ApplicantsDao applicantsDao = ApplicantsDao.getInstance();
		AdministratorsDao administratorsDao = AdministratorsDao.getInstance();
		CounselorsDao counselorsDao = CounselorsDao.getInstance();
		
		//INSERT objects from our model.
		Applicants ap1 = new Applicants(60001, "TonyWang", "12345","Tong","Wang",
				"tongw@gmail.com",Applicants.Gender.male,
				Timestamp.valueOf("2004-10-20 11:59:45"), true, "Bellevue High", 
				"Bellevue", "WA", "98004","Asian","Master");
		ap1 = applicantsDao.create(ap1);
		Applicants ap2 = new Applicants(60002, "FrankS", "Frank123","Frank","Smith",
				"franks@gmail.com",Applicants.Gender.male,
				Timestamp.valueOf("2004-06-10 17:50:35"), true, "Redmond High", 
				"Redmond", "WA", "98052","American","Bachelor");
		ap2 = applicantsDao.create(ap2);
		
		Administrators ad1 = new Administrators(60003, "Yolanda", "Y12390", "Yolanda","Lee",
				"yolandal@hotmail.com",Timestamp.valueOf("2022-11-04 16:45:55"));
		ad1 = administratorsDao.create(ad1);
		
		Counselors c = new Counselors(60004, "JenOragon", "Jen66", "Jen","Oragon", 
				"jeno66@gmail.com", Counselors.Gender.female, 8, true, "Seattle", "WA", "98109", "American");
		c = counselorsDao.create(c);
		
		//READ.
		Applicants a = applicantsDao.getApplicantByPersonId(60001);
		System.out.format("Reading applicant: i:%s n:%s p:%s f:%s l:%s e:%s g:%s d:%s s:%s h:%s "
				+ "c:%s s:%s z:%s r:%s p:%s \n", a.getPersonId(), a.getUserName(), a.getPassCode(),
				a.getFirstName(), a.getLastName(), a.getEmail(), a.getGender().toString(), a.getDateOfBirth(), 
				a.getSeekingCounselors(), a.getHighschool(), a.getCity(), 
				a.getState(), a.getZipCode(), a.getRaceEthnicity(), a.getParentEduLevel());
		
		Applicants a2 = applicantsDao.getApplicantByPersonId(60002);
		System.out.format("Reading applicant: i:%s n:%s p:%s f:%s l:%s e:%s g:%s d:%s s:%s h:%s "
				+ "c:%s s:%s z:%s r:%s p:%s \n", a2.getPersonId(), a2.getUserName(), a2.getPassCode(),
				a2.getFirstName(), a2.getLastName(), a2.getEmail(), a2.getGender().toString(), a2.getDateOfBirth(), 
				a2.getSeekingCounselors(), a2.getHighschool(), a2.getCity(), 
				a2.getState(), a2.getZipCode(), a2.getRaceEthnicity(), a2.getParentEduLevel());
		
		Administrators ad = administratorsDao.getAdministratorByPersonId(60003);
		System.out.format("Reading administrator: i:%s n:%s p:%s f:%s l:%s e:%s l:%s \n", 
				ad.getPersonId(), ad.getUserName(), ad.getPassCode(),
				ad.getFirstName(), ad.getLastName(), ad.getEmail(),ad.getLastLogin());
		Counselors getCr = counselorsDao.getCounselorByPersonId(60004);
		System.out.format("Reading Counselor: i:%s u:%s p:%s f:%s l:%s e:%s g:%s y:%s a:%s c:%s s:%s z:%s r:%s \n",
				getCr.getPersonId(), getCr.getUserName(), getCr.getPassCode(), getCr.getFirstName(),
				getCr.getLastName(), getCr.getEmail(), getCr.getGender().toString(),getCr.getYearsOfExperience(), 
				getCr.getAcceptingNewStudent(), getCr.getCity(), getCr.getState(), getCr.getZipCode(), 
				getCr.getRaceEthnicity());
		
		
		//UPDATE.
		Applicants updatedAp = applicantsDao.updateSeekingCounselors(ap1, false);
		System.out.format("Updating applicant: i:%s n:%s p:%s f:%s l:%s e:%s g:%s d:%s s:%s h:%s "
				+ "c:%s s:%s z:%s r:%s p:%s \n", updatedAp.getPersonId(), 
				updatedAp.getUserName(), updatedAp.getPassCode(),
				updatedAp.getFirstName(), updatedAp.getLastName(), updatedAp.getEmail(), 
				updatedAp.getGender().toString(), updatedAp.getDateOfBirth(), 
				updatedAp.getSeekingCounselors(), updatedAp.getHighschool(), updatedAp.getCity(), 
				updatedAp.getState(), updatedAp.getZipCode(), updatedAp.getRaceEthnicity(),
				updatedAp.getParentEduLevel());
		
		Administrators updatedAd = administratorsDao.updateLastLogin(ad, Timestamp.valueOf("2022-11-06 10:25:00"));
		System.out.format("Updating administrator i:%s u:%s l:%s \n", 
				updatedAd.getPersonId(), updatedAd.getUserName(), updatedAd.getLastLogin());
		
		//DELETE.
		Applicants deletedAp = applicantsDao.delete(a2);
		Administrators deletedAd = administratorsDao.delete(ad);
		Counselors deletedCr = counselorsDao.delete(c);
	
		
		}
	}