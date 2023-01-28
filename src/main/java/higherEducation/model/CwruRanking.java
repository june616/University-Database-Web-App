package higherEducation.model;

public class CwruRanking {
  protected int cwruEntryID;
  protected int worldRank;
  protected String universityName;
  protected Universities university;
  protected int educationQuality;
  protected int alumniEmployment;
  protected int facultyQuality;
  protected int publications;
  protected int influence;
  protected int citations;
  protected int patents;
  protected double score;
  protected String year;

  public CwruRanking(int cwruEntryID, int worldRank, String universityName,
      Universities university, int educationQuality, int alumniEmployment, int facultyQuality,
      int publications, int influence, int citations, int patents, double score, String year) {
    this.cwruEntryID = cwruEntryID;
    this.worldRank = worldRank;
    this.universityName = universityName;
    this.university = university;
    this.educationQuality = educationQuality;
    this.alumniEmployment = alumniEmployment;
    this.facultyQuality = facultyQuality;
    this.publications = publications;
    this.influence = influence;
    this.citations = citations;
    this.patents = patents;
    this.score = score;
    this.year = year;
  }

  public CwruRanking(int cwruEntryID) {
    this.cwruEntryID = cwruEntryID;
  }

  public CwruRanking(int worldRank, String universityName, Universities university,
      int educationQuality, int alumniEmployment, int facultyQuality, int publications,
      int influence,
      int citations, int patents, double score, String year) {
    this.worldRank = worldRank;
    this.universityName = universityName;
    this.university = university;
    this.educationQuality = educationQuality;
    this.alumniEmployment = alumniEmployment;
    this.facultyQuality = facultyQuality;
    this.publications = publications;
    this.influence = influence;
    this.citations = citations;
    this.patents = patents;
    this.score = score;
    this.year = year;
  }

  public int getCwruEntryID() {
    return cwruEntryID;
  }

  public void setCwruEntryID(int cwruEntryID) {
    this.cwruEntryID = cwruEntryID;
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

  public int getEducationQuality() {
    return educationQuality;
  }

  public void setEducationQuality(int educationQuality) {
    this.educationQuality = educationQuality;
  }

  public int getAlumniEmployment() {
    return alumniEmployment;
  }

  public void setAlumniEmployment(int alumniEmployment) {
    this.alumniEmployment = alumniEmployment;
  }

  public int getFacultyQuality() {
    return facultyQuality;
  }

  public void setFacultyQuality(int facultyQuality) {
    this.facultyQuality = facultyQuality;
  }

  public int getPublications() {
    return publications;
  }

  public void setPublications(int publications) {
    this.publications = publications;
  }

  public int getInfluence() {
    return influence;
  }

  public void setInfluence(int influence) {
    this.influence = influence;
  }

  public int getCitations() {
    return citations;
  }

  public void setCitations(int citations) {
    this.citations = citations;
  }

  public int getPatents() {
    return patents;
  }

  public void setPatents(int patents) {
    this.patents = patents;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }
  
  @Override
  public String toString() {
    return "CwruRanking{" +
        "cwruEntryID=" + cwruEntryID +
        ", worldRank=" + worldRank +
        ", universityName='" + universityName + '\'' +
        ", university=" + university +
        ", educationQuality=" + educationQuality +
        ", alumniEmployment=" + alumniEmployment +
        ", facultyQuality=" + facultyQuality +
        ", publications=" + publications +
        ", influence=" + influence +
        ", citations=" + citations +
        ", patents=" + patents +
        ", score=" + score +
        ", year='" + year + '\'' +
        '}';
  }
}
