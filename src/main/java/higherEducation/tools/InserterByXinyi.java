package higherEducation.tools;

import higherEducation.dal.ApplicantsDao;
import higherEducation.dal.RatingsDao;
import higherEducation.dal.StatesDao;
import higherEducation.dal.UniversitiesDao;
import higherEducation.model.Applicants;
import higherEducation.model.Ratings;
import higherEducation.model.States;
import higherEducation.model.Universities;
import java.sql.SQLException;
import java.sql.Timestamp;

public class InserterByXinyi {

    public static void testDao() throws SQLException {
        StatesDao statesDao = StatesDao.getInstance();
        //create
        States testState = new States("AA", "Apple", "Alice",
            "Axios",22234544,34332233,323424235);
        States testState2 = new States("BB", "Banana", "Bennet",
            "Bubble",2345244,421432532,24143255);
        System.out.println(statesDao.create(testState).toString());
        System.out.println(statesDao.create(testState2).toString());
        System.out.println("-----------------------------");
        //getStateByPostalAbbreviation
        System.out.println(statesDao.getStateByPostalAbbreviation("BB").toString());
        System.out.println("-----------------------------");
        //delete
        System.out.println(statesDao.delete(testState2));
        System.out.println("-----------------------------");
        //updateLargestCity
        System.out.println(statesDao.updateLargestCity(testState, "Orange").toString());
        System.out.println("-----------------------------");
        //updateCapital
        System.out.println(statesDao.updateCapital(testState, "Coco-cola").toString());
        System.out.println("-----------------------------");
        //updatePopulation
        System.out.println(statesDao.updatePopulation(testState, 99999).toString());
        System.out.println("-----------------------------");
        //updateTotalAreaSquareMiles
        System.out.println(statesDao.updateTotalAreaSquareMiles(testState, 8888888).toString());
        System.out.println("-----------------------------");
        //updatePerCapitaPersonalIncome
        System.out.println(statesDao.updatePerCapitaPersonalIncome(testState,7777777).toString());
        System.out.println("-----------------------------");

        UniversitiesDao universitiesDao = UniversitiesDao.getInstance();
        //create
        Universities university = new Universities(
            11111,12332,12321421,"CC", "colons",
            testState, "98444", "Color", "INSTURL","NPCURL",
            3,1,123.45f,67.09f,0.88f,
            0.88f, 123,456,678,901,
            123,3214,123123,12312312,312,
            432,234,234,2345,7564,
            53,2532,42342,4234,23423,
            4242,234,23432,423423,0.99f,
            1,43562,432524,342523,0.90f,
            432432,432432,432432,534534,54353,
            53534,636555,53534);
        Universities university2 = new Universities(
            22222,12332,12321421,"aCC", "colons",
            testState, "98444", "Color", "INSTURL","NPCURL",
            3,1,123.45f,67.09f,0.88f,
            0.88f, 123,456,678,901,
            123,3214,123123,12312312,312,
            432,234,234,2345,7564,
            53,2532,42342,4234,23423,
            4242,234,23432,423423,0.99f,
            1,43562,432524,342523,0.90f,
            432432,432432,432432,534534,54353,
            53534,636555,53534);
        Universities university3 = new Universities(
            33333,12332,12321421,"CCa", "colons",
            testState, "98444", "Color", "INSTURL","NPCURL",
            3,1,123.45f,67.09f,0.88f,
            0.88f, 123,456,678,901,
            123,3214,123123,12312312,312,
            432,234,234,2345,7564,
            53,2532,42342,4234,23423,
            4242,234,23432,423423,0.99f,
            1,43562,432524,342523,0.90f,
            432432,432432,432432,534534,54353,
            53534,636555,53534);
        System.out.println(universitiesDao.create(university).toString());
        System.out.println(universitiesDao.create(university2).toString());
        System.out.println(universitiesDao.create(university3).toString());

        System.out.println("getUniversityByUnitId-----------------------------");
        //getUniversityByUnitId
        System.out.println(universitiesDao.getUniversityByUnitId(33333));

        // getUniversityByName
        System.out.println("getUniversityByName-----------------------------");
        System.out.println(universitiesDao.getUniversityByName("CC").toString());

        //delete
        System.out.println("delete-----------------------------");
        System.out.println(universitiesDao.delete(university2));
        System.out.println("-----------------------------");

        RatingsDao ratingsDao = RatingsDao.getInstance();
        //create
        System.out.println("create-----------------------------");
        ApplicantsDao applicantsDao = ApplicantsDao.getInstance();
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
        Ratings ratings = new Ratings(2.5f, ap1, university);
        Ratings ratings2 = new Ratings(2.6f, ap2, university);
        Ratings ratings3 = new Ratings(3.2f, ap1, university3);
        Ratings ratings4 = new Ratings(2.7f, ap2, university3);
        System.out.println(ratingsDao.create(ratings));
        System.out.println(ratingsDao.create(ratings2));
        System.out.println(ratingsDao.create(ratings3));
        System.out.println(ratingsDao.create(ratings4));
        System.out.println("updateRatingValue-----------------------------");
        //updateRatingValue
        System.out.println(ratingsDao.updateRatingValue(ratings, 3.1f));
        System.out.println("delete-----------------------------");
        //delete
        System.out.println(ratingsDao.delete(ratings3));
        System.out.println("getRatingsByRatingId-----------------------------");
        //getRatingsByRatingId
        System.out.println(ratingsDao.getRatingsByRatingId(2));
        System.out.println("getRatingsByUniversity-----------------------------");
        //getRatingsByUniversity
        System.out.println(ratingsDao.getRatingsByUniversity(university).toString());
        System.out.println("getRatingsByPerson-----------------------------");
        //getRatingsByPerson
        System.out.println(ratingsDao.getRatingsByPerson(ap2).toString());
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) throws SQLException{
        testDao();
    }

}
