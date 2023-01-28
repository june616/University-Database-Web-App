package higherEducation.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import higherEducation.model.States;
import higherEducation.model.Universities;
import java.util.ArrayList;
import java.util.List;

public class UniversitiesDao {
    protected ConnectionManager connectionManager;

    // Single pattern: instantiation is limited to one object.
    private static UniversitiesDao instance = null;
    protected UniversitiesDao() {
        connectionManager = new ConnectionManager();
    }
    public static UniversitiesDao getInstance() {
        if(instance == null) {
            instance = new UniversitiesDao();
        }
        return instance;
    }

    public Universities create(Universities university)throws SQLException{
        String insertUniversity = "INSERT INTO Universities" +
            "(UNITID,OPEID,OPEID6,INSTNM,CITY,"
            +"STABBR,ZIP,ACCREDAGENCY,INSTURL,NPCURL,"
            +"NUMBRANCH,CONTROL,LATITUDE,LONGITUDE,ADM_RATE,"
            +"ADM_RATE_ALL,SATVR25,SATVR75,SATMT25,SATMT75,"
            +"SATWR25,SATWR75,SATVRMID,SATMTMID,SATWRMID,"
            +"ACTCM25,ACTCM75,ACTEN25,ACTEN75,ACTMT25,"
            +"ACTMT75,ACTWR25,ACTWR75,ACTCMMID,ACTENMID,"
            +"ACTMTMID,ACTWRMID,SAT_AVG_ALL,UGDS,PPTUG_EF,"
            +"CURROPER,TUITIONFEE_IN,TUITIONFEE_OUT,TUITIONFEE_PROG,PFTFAC,"
            +"MN_EARN_WNE_P6,MD_EARN_WNE_P6,MN_EARN_WNE_P7,MN_EARN_WNE_P8,MD_EARN_WNE_P8,"
            +"MN_EARN_WNE_P9,MN_EARN_WNE_P10,MD_EARN_WNE_P10) "
            +"VALUES(?,?,?,?,?,?,?,?,?,?,"+"?,?,?,?,?,?,?,?,?,?,"+"?,?,?,?,?,?,?,?,?,?,"
            +"?,?,?,?,?,?,?,?,?,?,"+"?,?,?,?,?,?,?,?,?,?,"+"?,?,?"+");";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertUniversity);
            // PreparedStatement allows us to substitute specific types into the query template.
            // For an overview, see:
            // http://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html.
            // http://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
            // For nullable fields, you can check the property first and then call setNull()
            // as applicable.
            insertStmt.setInt(1, university.getUnitId());
            insertStmt.setInt(2, university.getOpeId());
            insertStmt.setInt(3, university.getOpeId6());
            insertStmt.setString(4, university.getInstitutionName());
            insertStmt.setString(5, university.getCity());
            insertStmt.setString(6, university.getState().getPostalAbbreviation());
            insertStmt.setString(7, university.getZip());
            insertStmt.setString(8, university.getAccredagency());
            insertStmt.setString(9, university.getSchoolUrl());
            insertStmt.setString(10, university.getPriceCalculatorUrl());
            insertStmt.setInt(11, university.getNumOfBranches());
            insertStmt.setInt(12, university.getControl());
            insertStmt.setFloat(13,university.getLatitude());
            insertStmt.setFloat(14,university.getLongitude());
            insertStmt.setFloat(15,university.getAdmissionRate());
            insertStmt.setFloat(16,university.getAdmissionRateOverall());
            insertStmt.setInt(17, university.getSatScores25thPercentileCriticalReading());
            insertStmt.setInt(18, university.getSatScores75thPercentileCriticalReading());
            insertStmt.setInt(19, university.getSatScores25thPercentileMath());
            insertStmt.setInt(20, university.getSatScores75thPercentileMath());
            insertStmt.setInt(21, university.getSatScores25thPercentileWriting());
            insertStmt.setInt(22, university.getSatScores75thPercentileWriting());
            insertStmt.setInt(23, university.getSatScoresMidpointCriticalReading());
            insertStmt.setInt(24, university.getSatScoresMidpointMath());
            insertStmt.setInt(25, university.getSatScoresMidpointWriting());
            insertStmt.setInt(26, university.getActScores25thPercentileCumulative());
            insertStmt.setInt(27, university.getActScores75thPercentileCumulative());
            insertStmt.setInt(28, university.getActScores25thPercentileEnglish());
            insertStmt.setInt(29, university.getActScores75thPercentileEnglish());
            insertStmt.setInt(30, university.getActScores25thPercentileMath());
            insertStmt.setInt(31, university.getActScores75thPercentileMath());
            insertStmt.setInt(32, university.getActScores25thPercentileWriting());
            insertStmt.setInt(33, university.getActScores75thPercentileWriting());
            insertStmt.setInt(34, university.getActScoresMidpointCumulative());
            insertStmt.setInt(35, university.getActScoresMidpointEnglish());
            insertStmt.setInt(36, university.getActScoresMidpointMath());
            insertStmt.setInt(37, university.getActScoresMidpointWriting());
            insertStmt.setInt(38, university.getSatScoresAverageByOpeId());
            insertStmt.setInt(39, university.getSizeOfUndergraduateAndDegreeSeeking());
            insertStmt.setFloat(40, university.getShareOfUndergraduateAndDegreeSeekingPartTime());
            insertStmt.setInt(41,university.getOperating());
            insertStmt.setInt(42, university.getTuitionInState());
            insertStmt.setInt(43, university.getTuitionOutOfState());
            insertStmt.setInt(44, university.getTuitionProgramYear());
            insertStmt.setFloat(45, university.getFtFacultyRate());
            insertStmt.setInt(46, university.getMeanEarn_WorkingNotEnrolled_P6());
            insertStmt.setInt(47, university.getMedianEarn_WorkingNotEnrolled_P6());
            insertStmt.setInt(48, university.getMeanEarn_WorkingNotEnrolled_P7());
            insertStmt.setInt(49, university.getMeanEarn_WorkingNotEnrolled_P8());
            insertStmt.setInt(50, university.getMedianEarn_WorkingNotEnrolled_P8());
            insertStmt.setInt(51, university.getMeanEarn_WorkingNotEnrolled_P9());
            insertStmt.setInt(52, university.getMeanEarn_WorkingNotEnrolled_P10());
            insertStmt.setInt(53, university.getMedianEarn_WorkingNotEnrolled_P10());
            // Note that we call executeUpdate(). This is used for a INSERT/UPDATE/DELETE
            // statements, and it returns an int for the row counts affected (or 0 if the
            // statement returns nothing). For more information, see:
            // http://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
            // I'll leave it as an exercise for you to write UPDATE/DELETE methods.
            insertStmt.executeUpdate();

            // Note 1: if this was an UPDATE statement, then the person fields should be
            // updated before returning to the caller.
            // Note 2: there are no auto-generated keys, so no update to perform on the
            // input param person.
            return university;
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
        }
    }

    public Universities getUniversityByUnitId(int unitId)throws SQLException{
        String selectUniversity =
            "SELECT UNITID,OPEID,OPEID6,INSTNM,CITY,"
                + "STABBR,ZIP,ACCREDAGENCY,INSTURL,NPCURL,"
                + "NUMBRANCH,CONTROL,LATITUDE,LONGITUDE,ADM_RATE,"
                + "ADM_RATE_ALL,SATVR25,SATVR75,SATMT25,SATMT75,"
                + "SATWR25,SATWR75,SATVRMID,SATMTMID,SATWRMID,"
                + "ACTCM25,ACTCM75,ACTEN25,ACTEN75,ACTMT25,"
                + "ACTMT75,ACTWR25,ACTWR75,ACTCMMID,ACTENMID,"
                + "ACTMTMID,ACTWRMID,SAT_AVG_ALL,UGDS,PPTUG_EF,"
                + "CURROPER,TUITIONFEE_IN,TUITIONFEE_OUT,TUITIONFEE_PROG,PFTFAC,"
                + "MN_EARN_WNE_P6,MD_EARN_WNE_P6,MN_EARN_WNE_P7,MN_EARN_WNE_P8,MD_EARN_WNE_P8,"
                + "MN_EARN_WNE_P9,MN_EARN_WNE_P10,MD_EARN_WNE_P10 " +
                "FROM Universities " +
                "WHERE UNITID=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectUniversity);
            selectStmt.setInt(1, unitId);
            results = selectStmt.executeQuery();

            if(results.next()) {
                int resultUnitId = results.getInt("UNITID");
                int opeId = results.getInt("OPEID");
                int opeId6 = results.getInt("OPEID6");
                String institutionName = results.getString("INSTNM");
                String city = results.getString("CITY");
                String postalAbbreviation = results.getString("STABBR");
                String zip = results.getString("ZIP");
                String accredagency = results.getString("ACCREDAGENCY");
                String schoolUrl = results.getString("INSTURL");
                String priceCalculatorUrl = results.getString("NPCURL");
                int numOfBranches = results.getInt("NUMBRANCH");
                int control = results.getInt("CONTROL");
                float latitude = results.getFloat("LATITUDE");
                float longitude = results.getFloat("LONGITUDE");
                float admissionRate = results.getFloat("ADM_RATE");
                float admissionRateOverall = results.getFloat("ADM_RATE_ALL");
                int satScores25thPercentileCriticalReading = results.getInt("SATVR25");
                int satScores75thPercentileCriticalReading = results.getInt("SATVR75");
                int satScores25thPercentileMath = results.getInt("SATMT25");
                int satScores75thPercentileMath = results.getInt("SATMT75");
                int satScores25thPercentileWriting = results.getInt("SATWR25");
                int satScores75thPercentileWriting = results.getInt("SATWR75");
                int satScoresMidpointCriticalReading = results.getInt("SATVRMID");
                int satScoresMidpointMath = results.getInt("SATMTMID");
                int satScoresMidpointWriting = results.getInt("SATWRMID");
                int actScores25thPercentileCumulative = results.getInt("ACTCM25");
                int actScores75thPercentileCumulative = results.getInt("ACTCM75");
                int actScores25thPercentileEnglish = results.getInt("ACTEN25");
                int actScores75thPercentileEnglish = results.getInt("ACTEN75");
                int actScores25thPercentileMath = results.getInt("ACTMT25");
                int actScores75thPercentileMath = results.getInt("ACTMT75");
                int actScores25thPercentileWriting = results.getInt("ACTWR25");
                int actScores75thPercentileWriting = results.getInt("ACTWR75");
                int actScoresMidpointCumulative = results.getInt("ACTCMMID");
                int actScoresMidpointEnglish = results.getInt("ACTENMID");
                int actScoresMidpointMath = results.getInt("ACTMTMID");
                int actScoresMidpointWriting = results.getInt("ACTWRMID");
                int satScoresAverageByOpeId = results.getInt("SAT_AVG_ALL");
                int sizeOfUndergraduateAndDegreeSeeking = results.getInt("UGDS");
                float shareOfUndergraduateAndDegreeSeekingPartTime = results.getFloat("PPTUG_EF");
                int operating = results.getInt("CURROPER");
                int tuitionInState = results.getInt("TUITIONFEE_IN");
                int tuitionOutOfState = results.getInt("TUITIONFEE_OUT");
                int tuitionProgramYear = results.getInt("TUITIONFEE_PROG");
                float ftFacultyRate = results.getFloat("PFTFAC");
                int meanEarn_WorkingNotEnrolled_P6 = results.getInt("MN_EARN_WNE_P6");
                int medianEarn_WorkingNotEnrolled_P6 = results.getInt("MD_EARN_WNE_P6");
                int meanEarn_WorkingNotEnrolled_P7 = results.getInt("MN_EARN_WNE_P7");
                int meanEarn_WorkingNotEnrolled_P8 = results.getInt("MN_EARN_WNE_P8");
                int medianEarn_WorkingNotEnrolled_P8 = results.getInt("MD_EARN_WNE_P8");
                int meanEarn_WorkingNotEnrolled_P9 = results.getInt("MN_EARN_WNE_P9");
                int meanEarn_WorkingNotEnrolled_P10 = results.getInt("MN_EARN_WNE_P10");
                int medianEarn_WorkingNotEnrolled_P10 = results.getInt("MD_EARN_WNE_P10");
                StatesDao statesDao = StatesDao.getInstance();
                States state = statesDao.getStateByPostalAbbreviation(postalAbbreviation);
                Universities university = new Universities(
                    resultUnitId,opeId,opeId6,institutionName,city,
                    state,zip,accredagency,schoolUrl,priceCalculatorUrl,
                    numOfBranches,control,latitude,longitude,admissionRate,
                    admissionRateOverall,satScores25thPercentileCriticalReading,satScores75thPercentileCriticalReading,satScores25thPercentileMath,satScores75thPercentileMath,
                    satScores25thPercentileWriting,satScores75thPercentileWriting,satScoresMidpointCriticalReading,satScoresMidpointMath,satScoresMidpointWriting,
                    actScores25thPercentileCumulative,actScores75thPercentileCumulative,actScores25thPercentileEnglish,actScores75thPercentileEnglish,actScores25thPercentileMath,
                    actScores75thPercentileMath,actScores25thPercentileWriting,actScores75thPercentileWriting,actScoresMidpointCumulative,actScoresMidpointEnglish,
                    actScoresMidpointMath,actScoresMidpointWriting,satScoresAverageByOpeId,sizeOfUndergraduateAndDegreeSeeking,shareOfUndergraduateAndDegreeSeekingPartTime,
                    operating,tuitionInState,tuitionOutOfState,tuitionProgramYear,ftFacultyRate,
                    meanEarn_WorkingNotEnrolled_P6,medianEarn_WorkingNotEnrolled_P6,meanEarn_WorkingNotEnrolled_P7,meanEarn_WorkingNotEnrolled_P8,medianEarn_WorkingNotEnrolled_P8,
                    meanEarn_WorkingNotEnrolled_P9,meanEarn_WorkingNotEnrolled_P10,medianEarn_WorkingNotEnrolled_P10);
                return university;
            }
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

    public List<Universities> getUniversityByName(String name)throws SQLException{
        List<Universities> universitiesList = new ArrayList<>();
        String selectUniversity =
            "SELECT UNITID,OPEID,OPEID6,INSTNM,CITY,"
                + "STABBR,ZIP,ACCREDAGENCY,INSTURL,NPCURL,"
                + "NUMBRANCH,CONTROL,LATITUDE,LONGITUDE,ADM_RATE,"
                + "ADM_RATE_ALL,SATVR25,SATVR75,SATMT25,SATMT75,"
                + "SATWR25,SATWR75,SATVRMID,SATMTMID,SATWRMID,"
                + "ACTCM25,ACTCM75,ACTEN25,ACTEN75,ACTMT25,"
                + "ACTMT75,ACTWR25,ACTWR75,ACTCMMID,ACTENMID,"
                + "ACTMTMID,ACTWRMID,SAT_AVG_ALL,UGDS,PPTUG_EF,"
                + "CURROPER,TUITIONFEE_IN,TUITIONFEE_OUT,TUITIONFEE_PROG,PFTFAC,"
                + "MN_EARN_WNE_P6,MD_EARN_WNE_P6,MN_EARN_WNE_P7,MN_EARN_WNE_P8,MD_EARN_WNE_P8,"
                + "MN_EARN_WNE_P9,MN_EARN_WNE_P10,MD_EARN_WNE_P10 " +
                "FROM Universities " +
                "WHERE INSTNM LIKE '%" + name + "%';";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectUniversity);
//            selectStmt.setString(1, name);
            results = selectStmt.executeQuery();

            while(results.next()) {
                int unitId = results.getInt("UNITID");
                int opeId = results.getInt("OPEID");
                int opeId6 = results.getInt("OPEID6");
                String resultInstitutionName = results.getString("INSTNM");
                String city = results.getString("CITY");
                String postalAbbreviation = results.getString("STABBR");
                String zip = results.getString("ZIP");
                String accredagency = results.getString("ACCREDAGENCY");
                String schoolUrl = results.getString("INSTURL");
                String priceCalculatorUrl = results.getString("NPCURL");
                int numOfBranches = results.getInt("NUMBRANCH");
                int control = results.getInt("CONTROL");
                float latitude = results.getFloat("LATITUDE");
                float longitude = results.getFloat("LONGITUDE");
                float admissionRate = results.getFloat("ADM_RATE");
                float admissionRateOverall = results.getFloat("ADM_RATE_ALL");
                int satScores25thPercentileCriticalReading = results.getInt("SATVR25");
                int satScores75thPercentileCriticalReading = results.getInt("SATVR75");
                int satScores25thPercentileMath = results.getInt("SATMT25");
                int satScores75thPercentileMath = results.getInt("SATMT75");
                int satScores25thPercentileWriting = results.getInt("SATWR25");
                int satScores75thPercentileWriting = results.getInt("SATWR75");
                int satScoresMidpointCriticalReading = results.getInt("SATVRMID");
                int satScoresMidpointMath = results.getInt("SATMTMID");
                int satScoresMidpointWriting = results.getInt("SATWRMID");
                int actScores25thPercentileCumulative = results.getInt("ACTCM25");
                int actScores75thPercentileCumulative = results.getInt("ACTCM75");
                int actScores25thPercentileEnglish = results.getInt("ACTEN25");
                int actScores75thPercentileEnglish = results.getInt("ACTEN75");
                int actScores25thPercentileMath = results.getInt("ACTMT25");
                int actScores75thPercentileMath = results.getInt("ACTMT75");
                int actScores25thPercentileWriting = results.getInt("ACTWR25");
                int actScores75thPercentileWriting = results.getInt("ACTWR75");
                int actScoresMidpointCumulative = results.getInt("ACTCMMID");
                int actScoresMidpointEnglish = results.getInt("ACTENMID");
                int actScoresMidpointMath = results.getInt("ACTMTMID");
                int actScoresMidpointWriting = results.getInt("ACTWRMID");
                int satScoresAverageByOpeId = results.getInt("SAT_AVG_ALL");
                int sizeOfUndergraduateAndDegreeSeeking = results.getInt("UGDS");
                float shareOfUndergraduateAndDegreeSeekingPartTime = results.getFloat("PPTUG_EF");
                int operating = results.getInt("CURROPER");
                int tuitionInState = results.getInt("TUITIONFEE_IN");
                int tuitionOutOfState = results.getInt("TUITIONFEE_OUT");
                int tuitionProgramYear = results.getInt("TUITIONFEE_PROG");
                float ftFacultyRate = results.getFloat("PFTFAC");
                int meanEarn_WorkingNotEnrolled_P6 = results.getInt("MN_EARN_WNE_P6");
                int medianEarn_WorkingNotEnrolled_P6 = results.getInt("MD_EARN_WNE_P6");
                int meanEarn_WorkingNotEnrolled_P7 = results.getInt("MN_EARN_WNE_P7");
                int meanEarn_WorkingNotEnrolled_P8 = results.getInt("MN_EARN_WNE_P8");
                int medianEarn_WorkingNotEnrolled_P8 = results.getInt("MD_EARN_WNE_P8");
                int meanEarn_WorkingNotEnrolled_P9 = results.getInt("MN_EARN_WNE_P9");
                int meanEarn_WorkingNotEnrolled_P10 = results.getInt("MN_EARN_WNE_P10");
                int medianEarn_WorkingNotEnrolled_P10 = results.getInt("MD_EARN_WNE_P10");
                StatesDao statesDao = StatesDao.getInstance();
                States state = statesDao.getStateByPostalAbbreviation(postalAbbreviation);
                Universities university = new Universities(
                    unitId,opeId,opeId6,resultInstitutionName,city,
                    state,zip,accredagency,schoolUrl,priceCalculatorUrl,
                    numOfBranches,control,latitude,longitude,admissionRate,
                    admissionRateOverall,satScores25thPercentileCriticalReading,satScores75thPercentileCriticalReading,satScores25thPercentileMath,satScores75thPercentileMath,
                    satScores25thPercentileWriting,satScores75thPercentileWriting,satScoresMidpointCriticalReading,satScoresMidpointMath,satScoresMidpointWriting,
                    actScores25thPercentileCumulative,actScores75thPercentileCumulative,actScores25thPercentileEnglish,actScores75thPercentileEnglish,actScores25thPercentileMath,
                    actScores75thPercentileMath,actScores25thPercentileWriting,actScores75thPercentileWriting,actScoresMidpointCumulative,actScoresMidpointEnglish,
                    actScoresMidpointMath,actScoresMidpointWriting,satScoresAverageByOpeId,sizeOfUndergraduateAndDegreeSeeking,shareOfUndergraduateAndDegreeSeekingPartTime,
                    operating,tuitionInState,tuitionOutOfState,tuitionProgramYear,ftFacultyRate,
                    meanEarn_WorkingNotEnrolled_P6,medianEarn_WorkingNotEnrolled_P6,meanEarn_WorkingNotEnrolled_P7,meanEarn_WorkingNotEnrolled_P8,medianEarn_WorkingNotEnrolled_P8,
                    meanEarn_WorkingNotEnrolled_P9,meanEarn_WorkingNotEnrolled_P10,medianEarn_WorkingNotEnrolled_P10);
                universitiesList.add(university);
            }
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
        return universitiesList;
    }


    public Universities delete(Universities university)throws SQLException{
        String deleteUniversity = "DELETE FROM Universities WHERE UNITID=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deleteUniversity);
            deleteStmt.setInt(1, university.getUnitId());
            deleteStmt.executeUpdate();

            // Return null so the caller can no longer operate on the BlogPosts instance.
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
    }
}
