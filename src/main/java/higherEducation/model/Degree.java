package higherEducation.model;


/*
degree_id INT auto_increment,
UNITID INT ,
CIPCODE VARCHAR(255),
CREDLEV LONGTEXT,
 */
public class Degree {
  protected int degree_id;
  protected Universities university;
  protected CIP cip;
  protected DegreeLevel degreeLevel;

  public Degree(int degree_id, Universities university, CIP cip,
      DegreeLevel degreeLevel) {
    this.degree_id = degree_id;
    this.university = university;
    this.cip = cip;
    this.degreeLevel = degreeLevel;
  }

  public Degree(Universities university, CIP cip,
      DegreeLevel degreeLevel) {
    this.university = university;
    this.cip = cip;
    this.degreeLevel = degreeLevel;
  }

  public int getDegree_id() {
    return degree_id;
  }

  public void setDegree_id(int degree_id) {
    this.degree_id = degree_id;
  }

  public Universities getUniversity() {
    return university;
  }

  public void setUniversity(Universities university) {
    this.university = university;
  }

  public CIP getCip() {
    return cip;
  }

  public void setCip(CIP cip) {
    this.cip = cip;
  }

  public DegreeLevel getDegreeLevel() {
    return degreeLevel;
  }

  public void setDegreeLevel(DegreeLevel degreeLevel) {
    this.degreeLevel = degreeLevel;
  }

  @Override
  public String toString() {
    return "Degree{" +
        "degree_id=" + degree_id +
        ", university=" + university +
        ", cip=" + cip +
        ", degreeLevel=" + degreeLevel +
        '}';
  }
}
