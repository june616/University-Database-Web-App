package higherEducation.model;

public class Universities {

    protected int unitId; // UNITID, Unit ID for institution
    protected int opeId; // OPEID, 8-digit OPE ID for institution
    protected int opeId6; // OPEID6, 6-digit OPE ID for institution
    protected String institutionName; //INSTNM, Institution name
    protected String city; // CITY
    protected States state; //STABBR
    protected String zip; // ZIP,ZIP code
    protected String accredagency; // ACCREDAGENCY, Accreditor for institution
    protected String schoolUrl; // INSTURL, URL for institution's homepage
    protected String priceCalculatorUrl; //NPCURL, URL for institution's net price calculator
    protected int numOfBranches; // NUMBRANCH, Number of branch campuses
    protected int control;
    // CONTROL, Control of institution
    // 1	Public
    // 2	Private nonprofit
    // 3	Private for-profit
    protected float latitude; //LATITUDE
    protected float longitude; // LONGITUDE
    protected float admissionRate; // ADM_RATE, Admission rate
    protected float admissionRateOverall; // ADM_RATE_ALL, Admission rate for all campuses rolled up to the 6-digit OPE ID
    protected int satScores25thPercentileCriticalReading; // SATVR25, 25th percentile of SAT scores at the institution (critical reading)
    protected int satScores75thPercentileCriticalReading; // SATVR75, 75th percentile of SAT scores at the institution (critical reading)
    protected int satScores25thPercentileMath; // SATMT25, 25th percentile of SAT scores at the institution (math)
    protected int satScores75thPercentileMath; // SATMT75, 75th percentile of SAT scores at the institution (math)
    protected int satScores25thPercentileWriting; // SATWR25, 25th percentile of SAT scores at the institution (writing)
    protected int satScores75thPercentileWriting; // SATWR75, 75th percentile of SAT scores at the institution (writing)
    protected int satScoresMidpointCriticalReading; // SATVRMID, Midpoint of SAT scores at the institution (critical reading)
    protected int satScoresMidpointMath; // SATMTMID, Midpoint of SAT scores at the institution (math)
    protected int satScoresMidpointWriting; //SATWRMID, Midpoint of SAT scores at the institution (writing)
    protected int actScores25thPercentileCumulative;// ACTCM25, 25th percentile of the ACT cumulative score
    protected int actScores75thPercentileCumulative;// ACTCM75, 75th percentile of the ACT cumulative score
    protected int actScores25thPercentileEnglish; // ACTEN25, 25th percentile of the ACT English score
    protected int actScores75thPercentileEnglish; // ACTEN75, 75th percentile of the ACT English score
    protected int actScores25thPercentileMath; // ACTMT25, 25th percentile of the ACT math score
    protected int actScores75thPercentileMath; // ACTMT75, 75th percentile of the ACT math score
    protected int actScores25thPercentileWriting; // ACTWR25, 25th percentile of the ACT writing score
    protected int actScores75thPercentileWriting; // ACTWR75, 75th percentile of the ACT writing score
    protected int actScoresMidpointCumulative;//ACTCMMID,Midpoint of the ACT cumulative score
    protected int actScoresMidpointEnglish; //ACTENMID,Midpoint of the ACT English score
    protected int actScoresMidpointMath; //ACTMTMID,Midpoint of the ACT math score
    protected int actScoresMidpointWriting; //ACTWRMID,Midpoint of the ACT writing score
    protected int satScoresAverageByOpeId; //SAT_AVG_ALL,Average SAT equivalent score of students admitted for all campuses rolled up to the 6-digit OPE ID
    protected int sizeOfUndergraduateAndDegreeSeeking;//UGDS，Enrollment of undergraduate certificate/degree-seeking students
    protected float shareOfUndergraduateAndDegreeSeekingPartTime;//PPTUG_EF,Share of undergraduate, degree-/certificate-seeking students who are part-time
    protected int operating;// CURROPER,Flag for currently operating institution, 0=closed, 1=operating
    protected int tuitionInState; //TUITIONFEE_IN,In-state tuition and fees
    protected int tuitionOutOfState; // TUITIONFEE_OUT,Out-of-state tuition and fees
    protected int tuitionProgramYear; // TUITIONFEE_PROG,Tuition and fees for program-year institutions
    protected float ftFacultyRate; // PFTFAC,Proportion of faculty that is full-time
    protected int meanEarn_WorkingNotEnrolled_P6; //MN_EARN_WNE_P6,Mean earnings of students working and not enrolled 6 years after entry
    protected int medianEarn_WorkingNotEnrolled_P6; //MD_EARN_WNE_P6,Median earnings of students working and not enrolled 6 years after entry
    protected int meanEarn_WorkingNotEnrolled_P7; //MN_EARN_WNE_P7,Mean earnings of students working and not enrolled 7 years after entry
    protected int meanEarn_WorkingNotEnrolled_P8; //MN_EARN_WNE_P8,Mean earnings of students working and not enrolled 8 years after entry
    protected int medianEarn_WorkingNotEnrolled_P8; //MD_EARN_WNE_P8,Median earnings of students working and not enrolled 8 years after entry
    protected int meanEarn_WorkingNotEnrolled_P9; //MN_EARN_WNE_P9,Mean earnings of students working and not enrolled 9 years after entry
    protected int meanEarn_WorkingNotEnrolled_P10; //MN_EARN_WNE_P10,Mean earnings of students working and not enrolled 10 years after entry
    protected int medianEarn_WorkingNotEnrolled_P10; //MD_EARN_WNE_P10,Median earnings of students working and not enrolled 10 years after entry

    public Universities(int unitId, int opeId, int opeId6, String institutionName, String city,
        States state, String zip, String accredagency, String schoolUrl, String priceCalculatorUrl,
        int numOfBranches, int control, float latitude, float longitude, float admissionRate,
        float admissionRateOverall, int satScores25thPercentileCriticalReading,
        int satScores75thPercentileCriticalReading, int satScores25thPercentileMath,
        int satScores75thPercentileMath, int satScores25thPercentileWriting,
        int satScores75thPercentileWriting, int satScoresMidpointCriticalReading,
        int satScoresMidpointMath, int satScoresMidpointWriting,
        int actScores25thPercentileCumulative,
        int actScores75thPercentileCumulative, int actScores25thPercentileEnglish,
        int actScores75thPercentileEnglish, int actScores25thPercentileMath,
        int actScores75thPercentileMath, int actScores25thPercentileWriting,
        int actScores75thPercentileWriting, int actScoresMidpointCumulative,
        int actScoresMidpointEnglish, int actScoresMidpointMath, int actScoresMidpointWriting,
        int satScoresAverageByOpeId, int sizeOfUndergraduateAndDegreeSeeking,
        float shareOfUndergraduateAndDegreeSeekingPartTime, int operating, int tuitionInState,
        int tuitionOutOfState, int tuitionProgramYear, float ftFacultyRate,
        int meanEarn_WorkingNotEnrolled_P6, int medianEarn_WorkingNotEnrolled_P6,
        int meanEarn_WorkingNotEnrolled_P7, int meanEarn_WorkingNotEnrolled_P8,
        int medianEarn_WorkingNotEnrolled_P8, int meanEarn_WorkingNotEnrolled_P9,
        int meanEarn_WorkingNotEnrolled_P10, int medianEarn_WorkingNotEnrolled_P10) {
        this.unitId = unitId;
        this.opeId = opeId;
        this.opeId6 = opeId6;
        this.institutionName = institutionName;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.accredagency = accredagency;
        this.schoolUrl = schoolUrl;
        this.priceCalculatorUrl = priceCalculatorUrl;
        this.numOfBranches = numOfBranches;
        this.control = control;
        this.latitude = latitude;
        this.longitude = longitude;
        this.admissionRate = admissionRate;
        this.admissionRateOverall = admissionRateOverall;
        this.satScores25thPercentileCriticalReading = satScores25thPercentileCriticalReading;
        this.satScores75thPercentileCriticalReading = satScores75thPercentileCriticalReading;
        this.satScores25thPercentileMath = satScores25thPercentileMath;
        this.satScores75thPercentileMath = satScores75thPercentileMath;
        this.satScores25thPercentileWriting = satScores25thPercentileWriting;
        this.satScores75thPercentileWriting = satScores75thPercentileWriting;
        this.satScoresMidpointCriticalReading = satScoresMidpointCriticalReading;
        this.satScoresMidpointMath = satScoresMidpointMath;
        this.satScoresMidpointWriting = satScoresMidpointWriting;
        this.actScores25thPercentileCumulative = actScores25thPercentileCumulative;
        this.actScores75thPercentileCumulative = actScores75thPercentileCumulative;
        this.actScores25thPercentileEnglish = actScores25thPercentileEnglish;
        this.actScores75thPercentileEnglish = actScores75thPercentileEnglish;
        this.actScores25thPercentileMath = actScores25thPercentileMath;
        this.actScores75thPercentileMath = actScores75thPercentileMath;
        this.actScores25thPercentileWriting = actScores25thPercentileWriting;
        this.actScores75thPercentileWriting = actScores75thPercentileWriting;
        this.actScoresMidpointCumulative = actScoresMidpointCumulative;
        this.actScoresMidpointEnglish = actScoresMidpointEnglish;
        this.actScoresMidpointMath = actScoresMidpointMath;
        this.actScoresMidpointWriting = actScoresMidpointWriting;
        this.satScoresAverageByOpeId = satScoresAverageByOpeId;
        this.sizeOfUndergraduateAndDegreeSeeking = sizeOfUndergraduateAndDegreeSeeking;
        this.shareOfUndergraduateAndDegreeSeekingPartTime = shareOfUndergraduateAndDegreeSeekingPartTime;
        this.operating = operating;
        this.tuitionInState = tuitionInState;
        this.tuitionOutOfState = tuitionOutOfState;
        this.tuitionProgramYear = tuitionProgramYear;
        this.ftFacultyRate = ftFacultyRate;
        this.meanEarn_WorkingNotEnrolled_P6 = meanEarn_WorkingNotEnrolled_P6;
        this.medianEarn_WorkingNotEnrolled_P6 = medianEarn_WorkingNotEnrolled_P6;
        this.meanEarn_WorkingNotEnrolled_P7 = meanEarn_WorkingNotEnrolled_P7;
        this.meanEarn_WorkingNotEnrolled_P8 = meanEarn_WorkingNotEnrolled_P8;
        this.medianEarn_WorkingNotEnrolled_P8 = medianEarn_WorkingNotEnrolled_P8;
        this.meanEarn_WorkingNotEnrolled_P9 = meanEarn_WorkingNotEnrolled_P9;
        this.meanEarn_WorkingNotEnrolled_P10 = meanEarn_WorkingNotEnrolled_P10;
        this.medianEarn_WorkingNotEnrolled_P10 = medianEarn_WorkingNotEnrolled_P10;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getOpeId() {
        return opeId;
    }

    public void setOpeId(int opeId) {
        this.opeId = opeId;
    }

    public int getOpeId6() {
        return opeId6;
    }

    public void setOpeId6(int opeId6) {
        this.opeId6 = opeId6;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAccredagency() {
        return accredagency;
    }

    public void setAccredagency(String accredagency) {
        this.accredagency = accredagency;
    }

    public String getSchoolUrl() {
        return schoolUrl;
    }

    public void setSchoolUrl(String schoolUrl) {
        this.schoolUrl = schoolUrl;
    }

    public String getPriceCalculatorUrl() {
        return priceCalculatorUrl;
    }

    public void setPriceCalculatorUrl(String priceCalculatorUrl) {
        this.priceCalculatorUrl = priceCalculatorUrl;
    }

    public int getNumOfBranches() {
        return numOfBranches;
    }

    public void setNumOfBranches(int numOfBranches) {
        this.numOfBranches = numOfBranches;
    }

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getAdmissionRate() {
        return admissionRate;
    }

    public void setAdmissionRate(float admissionRate) {
        this.admissionRate = admissionRate;
    }

    public float getAdmissionRateOverall() {
        return admissionRateOverall;
    }

    public void setAdmissionRateOverall(float admissionRateOverall) {
        this.admissionRateOverall = admissionRateOverall;
    }

    public int getSatScores25thPercentileCriticalReading() {
        return satScores25thPercentileCriticalReading;
    }

    public void setSatScores25thPercentileCriticalReading(
        int satScores25thPercentileCriticalReading) {
        this.satScores25thPercentileCriticalReading = satScores25thPercentileCriticalReading;
    }

    public int getSatScores75thPercentileCriticalReading() {
        return satScores75thPercentileCriticalReading;
    }

    public void setSatScores75thPercentileCriticalReading(
        int satScores75thPercentileCriticalReading) {
        this.satScores75thPercentileCriticalReading = satScores75thPercentileCriticalReading;
    }

    public int getSatScores25thPercentileMath() {
        return satScores25thPercentileMath;
    }

    public void setSatScores25thPercentileMath(int satScores25thPercentileMath) {
        this.satScores25thPercentileMath = satScores25thPercentileMath;
    }

    public int getSatScores75thPercentileMath() {
        return satScores75thPercentileMath;
    }

    public void setSatScores75thPercentileMath(int satScores75thPercentileMath) {
        this.satScores75thPercentileMath = satScores75thPercentileMath;
    }

    public int getSatScores25thPercentileWriting() {
        return satScores25thPercentileWriting;
    }

    public void setSatScores25thPercentileWriting(int satScores25thPercentileWriting) {
        this.satScores25thPercentileWriting = satScores25thPercentileWriting;
    }

    public int getSatScores75thPercentileWriting() {
        return satScores75thPercentileWriting;
    }

    public void setSatScores75thPercentileWriting(int satScores75thPercentileWriting) {
        this.satScores75thPercentileWriting = satScores75thPercentileWriting;
    }

    public int getSatScoresMidpointCriticalReading() {
        return satScoresMidpointCriticalReading;
    }

    public void setSatScoresMidpointCriticalReading(int satScoresMidpointCriticalReading) {
        this.satScoresMidpointCriticalReading = satScoresMidpointCriticalReading;
    }

    public int getSatScoresMidpointMath() {
        return satScoresMidpointMath;
    }

    public void setSatScoresMidpointMath(int satScoresMidpointMath) {
        this.satScoresMidpointMath = satScoresMidpointMath;
    }

    public int getSatScoresMidpointWriting() {
        return satScoresMidpointWriting;
    }

    public void setSatScoresMidpointWriting(int satScoresMidpointWriting) {
        this.satScoresMidpointWriting = satScoresMidpointWriting;
    }

    public int getActScores25thPercentileCumulative() {
        return actScores25thPercentileCumulative;
    }

    public void setActScores25thPercentileCumulative(int actScores25thPercentileCumulative) {
        this.actScores25thPercentileCumulative = actScores25thPercentileCumulative;
    }

    public int getActScores75thPercentileCumulative() {
        return actScores75thPercentileCumulative;
    }

    public void setActScores75thPercentileCumulative(int actScores75thPercentileCumulative) {
        this.actScores75thPercentileCumulative = actScores75thPercentileCumulative;
    }

    public int getActScores25thPercentileEnglish() {
        return actScores25thPercentileEnglish;
    }

    public void setActScores25thPercentileEnglish(int actScores25thPercentileEnglish) {
        this.actScores25thPercentileEnglish = actScores25thPercentileEnglish;
    }

    public int getActScores75thPercentileEnglish() {
        return actScores75thPercentileEnglish;
    }

    public void setActScores75thPercentileEnglish(int actScores75thPercentileEnglish) {
        this.actScores75thPercentileEnglish = actScores75thPercentileEnglish;
    }

    public int getActScores25thPercentileMath() {
        return actScores25thPercentileMath;
    }

    public void setActScores25thPercentileMath(int actScores25thPercentileMath) {
        this.actScores25thPercentileMath = actScores25thPercentileMath;
    }

    public int getActScores75thPercentileMath() {
        return actScores75thPercentileMath;
    }

    public void setActScores75thPercentileMath(int actScores75thPercentileMath) {
        this.actScores75thPercentileMath = actScores75thPercentileMath;
    }

    public int getActScores25thPercentileWriting() {
        return actScores25thPercentileWriting;
    }

    public void setActScores25thPercentileWriting(int actScores25thPercentileWriting) {
        this.actScores25thPercentileWriting = actScores25thPercentileWriting;
    }

    public int getActScores75thPercentileWriting() {
        return actScores75thPercentileWriting;
    }

    public void setActScores75thPercentileWriting(int actScores75thPercentileWriting) {
        this.actScores75thPercentileWriting = actScores75thPercentileWriting;
    }

    public int getActScoresMidpointCumulative() {
        return actScoresMidpointCumulative;
    }

    public void setActScoresMidpointCumulative(int actScoresMidpointCumulative) {
        this.actScoresMidpointCumulative = actScoresMidpointCumulative;
    }

    public int getActScoresMidpointEnglish() {
        return actScoresMidpointEnglish;
    }

    public void setActScoresMidpointEnglish(int actScoresMidpointEnglish) {
        this.actScoresMidpointEnglish = actScoresMidpointEnglish;
    }

    public int getActScoresMidpointMath() {
        return actScoresMidpointMath;
    }

    public void setActScoresMidpointMath(int actScoresMidpointMath) {
        this.actScoresMidpointMath = actScoresMidpointMath;
    }

    public int getActScoresMidpointWriting() {
        return actScoresMidpointWriting;
    }

    public void setActScoresMidpointWriting(int actScoresMidpointWriting) {
        this.actScoresMidpointWriting = actScoresMidpointWriting;
    }

    public int getSatScoresAverageByOpeId() {
        return satScoresAverageByOpeId;
    }

    public void setSatScoresAverageByOpeId(int satScoresAverageByOpeId) {
        this.satScoresAverageByOpeId = satScoresAverageByOpeId;
    }

    public int getSizeOfUndergraduateAndDegreeSeeking() {
        return sizeOfUndergraduateAndDegreeSeeking;
    }

    public void setSizeOfUndergraduateAndDegreeSeeking(int sizeOfUndergraduateAndDegreeSeeking) {
        this.sizeOfUndergraduateAndDegreeSeeking = sizeOfUndergraduateAndDegreeSeeking;
    }

    public float getShareOfUndergraduateAndDegreeSeekingPartTime() {
        return shareOfUndergraduateAndDegreeSeekingPartTime;
    }

    public void setShareOfUndergraduateAndDegreeSeekingPartTime(
        float shareOfUndergraduateAndDegreeSeekingPartTime) {
        this.shareOfUndergraduateAndDegreeSeekingPartTime = shareOfUndergraduateAndDegreeSeekingPartTime;
    }

    public int getOperating() {
        return operating;
    }

    public void setOperating(int operating) {
        this.operating = operating;
    }

    public int getTuitionInState() {
        return tuitionInState;
    }

    public void setTuitionInState(int tuitionInState) {
        this.tuitionInState = tuitionInState;
    }

    public int getTuitionOutOfState() {
        return tuitionOutOfState;
    }

    public void setTuitionOutOfState(int tuitionOutOfState) {
        this.tuitionOutOfState = tuitionOutOfState;
    }

    public int getTuitionProgramYear() {
        return tuitionProgramYear;
    }

    public void setTuitionProgramYear(int tuitionProgramYear) {
        this.tuitionProgramYear = tuitionProgramYear;
    }

    public float getFtFacultyRate() {
        return ftFacultyRate;
    }

    public void setFtFacultyRate(float ftFacultyRate) {
        this.ftFacultyRate = ftFacultyRate;
    }

    public int getMeanEarn_WorkingNotEnrolled_P6() {
        return meanEarn_WorkingNotEnrolled_P6;
    }

    public void setMeanEarn_WorkingNotEnrolled_P6(int meanEarn_WorkingNotEnrolled_P6) {
        this.meanEarn_WorkingNotEnrolled_P6 = meanEarn_WorkingNotEnrolled_P6;
    }

    public int getMedianEarn_WorkingNotEnrolled_P6() {
        return medianEarn_WorkingNotEnrolled_P6;
    }

    public void setMedianEarn_WorkingNotEnrolled_P6(int medianEarn_WorkingNotEnrolled_P6) {
        this.medianEarn_WorkingNotEnrolled_P6 = medianEarn_WorkingNotEnrolled_P6;
    }

    public int getMeanEarn_WorkingNotEnrolled_P7() {
        return meanEarn_WorkingNotEnrolled_P7;
    }

    public void setMeanEarn_WorkingNotEnrolled_P7(int meanEarn_WorkingNotEnrolled_P7) {
        this.meanEarn_WorkingNotEnrolled_P7 = meanEarn_WorkingNotEnrolled_P7;
    }

    public int getMeanEarn_WorkingNotEnrolled_P8() {
        return meanEarn_WorkingNotEnrolled_P8;
    }

    public void setMeanEarn_WorkingNotEnrolled_P8(int meanEarn_WorkingNotEnrolled_P8) {
        this.meanEarn_WorkingNotEnrolled_P8 = meanEarn_WorkingNotEnrolled_P8;
    }

    public int getMedianEarn_WorkingNotEnrolled_P8() {
        return medianEarn_WorkingNotEnrolled_P8;
    }

    public void setMedianEarn_WorkingNotEnrolled_P8(int medianEarn_WorkingNotEnrolled_P8) {
        this.medianEarn_WorkingNotEnrolled_P8 = medianEarn_WorkingNotEnrolled_P8;
    }

    public int getMeanEarn_WorkingNotEnrolled_P9() {
        return meanEarn_WorkingNotEnrolled_P9;
    }

    public void setMeanEarn_WorkingNotEnrolled_P9(int meanEarn_WorkingNotEnrolled_P9) {
        this.meanEarn_WorkingNotEnrolled_P9 = meanEarn_WorkingNotEnrolled_P9;
    }

    public int getMeanEarn_WorkingNotEnrolled_P10() {
        return meanEarn_WorkingNotEnrolled_P10;
    }

    public void setMeanEarn_WorkingNotEnrolled_P10(int meanEarn_WorkingNotEnrolled_P10) {
        this.meanEarn_WorkingNotEnrolled_P10 = meanEarn_WorkingNotEnrolled_P10;
    }

    public int getMedianEarn_WorkingNotEnrolled_P10() {
        return medianEarn_WorkingNotEnrolled_P10;
    }

    public void setMedianEarn_WorkingNotEnrolled_P10(int medianEarn_WorkingNotEnrolled_P10) {
        this.medianEarn_WorkingNotEnrolled_P10 = medianEarn_WorkingNotEnrolled_P10;
    }

    @Override
    public String toString() {
        return "higherEducation.model.Universities{" +
            "unitId=" + unitId +
            ", opeId=" + opeId +
            ", opeId6=" + opeId6 +
            ", institutionName='" + institutionName + '\'' +
            ", city='" + city + '\'' +
            ", state=" + state +
            ", zip='" + zip + '\'' +
            ", accredagency='" + accredagency + '\'' +
            ", schoolUrl='" + schoolUrl + '\'' +
            ", priceCalculatorUrl='" + priceCalculatorUrl + '\'' +
            ", numOfBranches=" + numOfBranches +
            ", control=" + control +
            ", latitude=" + latitude +
            ", longitude=" + longitude +
            ", admissionRate=" + admissionRate +
            ", admissionRateOverall=" + admissionRateOverall +
            ", satScores25thPercentileCriticalReading=" + satScores25thPercentileCriticalReading +
            ", satScores75thPercentileCriticalReading=" + satScores75thPercentileCriticalReading +
            ", satScores25thPercentileMath=" + satScores25thPercentileMath +
            ", satScores75thPercentileMath=" + satScores75thPercentileMath +
            ", satScores25thPercentileWriting=" + satScores25thPercentileWriting +
            ", satScores75thPercentileWriting=" + satScores75thPercentileWriting +
            ", satScoresMidpointCriticalReading=" + satScoresMidpointCriticalReading +
            ", satScoresMidpointMath=" + satScoresMidpointMath +
            ", satScoresMidpointWriting=" + satScoresMidpointWriting +
            ", actScores25thPercentileCumulative=" + actScores25thPercentileCumulative +
            ", actScores75thPercentileCumulative=" + actScores75thPercentileCumulative +
            ", actScores25thPercentileEnglish=" + actScores25thPercentileEnglish +
            ", actScores75thPercentileEnglish=" + actScores75thPercentileEnglish +
            ", actScores25thPercentileMath=" + actScores25thPercentileMath +
            ", actScores75thPercentileMath=" + actScores75thPercentileMath +
            ", actScores25thPercentileWriting=" + actScores25thPercentileWriting +
            ", actScores75thPercentileWriting=" + actScores75thPercentileWriting +
            ", actScoresMidpointCumulative=" + actScoresMidpointCumulative +
            ", actScoresMidpointEnglish=" + actScoresMidpointEnglish +
            ", actScoresMidpointMath=" + actScoresMidpointMath +
            ", actScoresMidpointWriting=" + actScoresMidpointWriting +
            ", satScoresAverageByOpeId=" + satScoresAverageByOpeId +
            ", sizeOfUndergraduateAndDegreeSeeking=" + sizeOfUndergraduateAndDegreeSeeking +
            ", shareOfUndergraduateAndDegreeSeekingPartTime="
            + shareOfUndergraduateAndDegreeSeekingPartTime +
            ", operating=" + operating +
            ", tuitionInState=" + tuitionInState +
            ", tuitionOutOfState=" + tuitionOutOfState +
            ", tuitionProgramYear=" + tuitionProgramYear +
            ", ftFacultyRate=" + ftFacultyRate +
            ", meanEarn_WorkingNotEnrolled_P6=" + meanEarn_WorkingNotEnrolled_P6 +
            ", medianEarn_WorkingNotEnrolled_P6=" + medianEarn_WorkingNotEnrolled_P6 +
            ", meanEarn_WorkingNotEnrolled_P7=" + meanEarn_WorkingNotEnrolled_P7 +
            ", meanEarn_WorkingNotEnrolled_P8=" + meanEarn_WorkingNotEnrolled_P8 +
            ", medianEarn_WorkingNotEnrolled_P8=" + medianEarn_WorkingNotEnrolled_P8 +
            ", meanEarn_WorkingNotEnrolled_P9=" + meanEarn_WorkingNotEnrolled_P9 +
            ", meanEarn_WorkingNotEnrolled_P10=" + meanEarn_WorkingNotEnrolled_P10 +
            ", medianEarn_WorkingNotEnrolled_P10=" + medianEarn_WorkingNotEnrolled_P10 +
            '}';
    }
}
