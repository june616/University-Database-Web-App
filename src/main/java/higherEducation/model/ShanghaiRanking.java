package higherEducation.model;

public class ShanghaiRanking {

  protected int shanghaiEntryID;
  protected int worldRank;
  protected String universityName;
  protected Universities university;
  protected double score;
  protected double alumni;
  protected double award;
  protected double hici;
  protected double ns;
  protected double pub;
  protected double pcp;
  protected String year;

  public ShanghaiRanking(int shanghaiEntryID, int worldRank, String universityName,
      Universities university, double score, double alumni, double award, double hici, double ns,
      double pub, double pcp, String year) {
    this.shanghaiEntryID = shanghaiEntryID;
    this.worldRank = worldRank;
    this.universityName = universityName;
    this.university = university;
    this.score = score;
    this.alumni = alumni;
    this.award = award;
    this.hici = hici;
    this.ns = ns;
    this.pub = pub;
    this.pcp = pcp;
    this.year = year;
  }

  public ShanghaiRanking(int shanghaiEntryID) {
    this.shanghaiEntryID = shanghaiEntryID;
  }

  public ShanghaiRanking(int worldRank, String universityName,
      Universities university, double score, double alumni, double award, double hici, double ns,
      double pub, double pcp, String year) {
    this.worldRank = worldRank;
    this.universityName = universityName;
    this.university = university;
    this.score = score;
    this.alumni = alumni;
    this.award = award;
    this.hici = hici;
    this.ns = ns;
    this.pub = pub;
    this.pcp = pcp;
    this.year = year;
  }

  public int getShanghaiEntryID() {
    return shanghaiEntryID;
  }

  public void setShanghaiEntryID(int shanghaiEntryID) {
    this.shanghaiEntryID = shanghaiEntryID;
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

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  public double getAlumni() {
    return alumni;
  }

  public void setAlumni(double alumni) {
    this.alumni = alumni;
  }

  public double getAward() {
    return award;
  }

  public void setAward(double award) {
    this.award = award;
  }

  public double getHici() {
    return hici;
  }

  public void setHici(double hici) {
    this.hici = hici;
  }

  public double getNs() {
    return ns;
  }

  public void setNs(double ns) {
    this.ns = ns;
  }

  public double getPub() {
    return pub;
  }

  public void setPub(double pub) {
    this.pub = pub;
  }

  public double getPcp() {
    return pcp;
  }

  public void setPcp(double pcp) {
    this.pcp = pcp;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }
  
  @Override
  public String toString() {
    return "ShanghaiRanking{" +
        "shanghaiEntryID=" + shanghaiEntryID +
        ", worldRank=" + worldRank +
        ", universityName='" + universityName + '\'' +
        ", university=" + university +
        ", score=" + score +
        ", alumni=" + alumni +
        ", award=" + award +
        ", hici=" + hici +
        ", ns=" + ns +
        ", pub=" + pub +
        ", pcp=" + pcp +
        ", year='" + year + '\'' +
        '}';
  }
}