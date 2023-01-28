package higherEducation.model;

public class TimesRanking {
  protected int timesEntryID;
  protected int worldRank;
  protected String universityName;
  protected Universities university;
  protected double teaching;
  protected double international;
  protected double research;
  protected double citations;
  protected double income;
  protected double score;
  protected int studentNumber;
  protected double studentStaffRatio;
  protected double internationalStudentRatio;
  protected double femaleStudentRatio;
  protected String year;

  public TimesRanking(int timesEntryID, int worldRank, String universityName,
      Universities university, double teaching, double international, double research, double citations,
      double income, double score, int studentNumber, double studentStaffRatio,
      double internationalStudentRatio, double femaleStudentRatio, String year) {
    this.timesEntryID = timesEntryID;
    this.worldRank = worldRank;
    this.universityName = universityName;
    this.university = university;
    this.teaching = teaching;
    this.international = international;
    this.research = research;
    this.citations = citations;
    this.income = income;
    this.score = score;
    this.studentNumber = studentNumber;
    this.studentStaffRatio = studentStaffRatio;
    this.internationalStudentRatio = internationalStudentRatio;
    this.femaleStudentRatio = femaleStudentRatio;
    this.year = year;
  }

  public TimesRanking(int timesEntryID) {
    this.timesEntryID = timesEntryID;
  }

  public TimesRanking(int worldRank, String universityName,
      Universities university, double teaching, double international, double research, double citations,
      double income, double score, int studentNumber, double studentStaffRatio,
      double internationalStudentRatio, double femaleStudentRatio, String year) {
    this.worldRank = worldRank;
    this.universityName = universityName;
    this.university = university;
    this.teaching = teaching;
    this.international = international;
    this.research = research;
    this.citations = citations;
    this.income = income;
    this.score = score;
    this.studentNumber = studentNumber;
    this.studentStaffRatio = studentStaffRatio;
    this.internationalStudentRatio = internationalStudentRatio;
    this.femaleStudentRatio = femaleStudentRatio;
    this.year = year;
  }

  public int getTimesEntryID() {
    return timesEntryID;
  }

  public void setTimesEntryID(int timesEntryID) {
    this.timesEntryID = timesEntryID;
  }

  public int getWorldRank() {
    return worldRank;
  }

  public void setWorldRank(int worldRank) {
    this.worldRank = worldRank;
  }

  public String getUniversityName() {
    return universityName;
  }

  public void setUniversityName(String universityName) {
    this.universityName = universityName;
  }

  public Universities getUniversity() {
    return university;
  }

  public void setUniversity(Universities university) {
    this.university = university;
  }

  public double getTeaching() {
    return teaching;
  }

  public void setTeaching(double teaching) {
    this.teaching = teaching;
  }

  public double getInternational() {
    return international;
  }

  public void setInternational(double international) {
    this.international = international;
  }

  public double getResearch() {
    return research;
  }

  public void setResearch(double research) {
    this.research = research;
  }

  public double getCitations() {
    return citations;
  }

  public void setCitations(double citations) {
    this.citations = citations;
  }

  public double getIncome() {
    return income;
  }

  public void setIncome(double income) {
    this.income = income;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  public int getStudentNumber() {
    return studentNumber;
  }

  public void setStudentNumber(int studentNumber) {
    this.studentNumber = studentNumber;
  }

  public double getStudentStaffRatio() {
    return studentStaffRatio;
  }

  public void setStudentStaffRatio(double studentStaffRatio) {
    this.studentStaffRatio = studentStaffRatio;
  }

  public double getInternationalStudentRatio() {
    return internationalStudentRatio;
  }

  public void setInternationalStudentRatio(double internationalStudentRatio) {
    this.internationalStudentRatio = internationalStudentRatio;
  }

  public double getFemaleStudentRatio() {
    return femaleStudentRatio;
  }

  public void setFemaleStudentRatio(double femaleStudentRatio) {
    this.femaleStudentRatio = femaleStudentRatio;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }
  
  @Override
  public String toString() {
    return "TimesRanking{" +
        "timesEntryID=" + timesEntryID +
        ", worldRank=" + worldRank +
        ", universityName='" + universityName + '\'' +
        ", university=" + university +
        ", teaching=" + teaching +
        ", international=" + international +
        ", research=" + research +
        ", citations=" + citations +
        ", income=" + income +
        ", score=" + score +
        ", studentNumber=" + studentNumber +
        ", studentStaffRatio=" + studentStaffRatio +
        ", internationalStudentRatio=" + internationalStudentRatio +
        ", femaleStudentRatio=" + femaleStudentRatio +
        ", year='" + year + '\'' +
        '}';
  }
}
