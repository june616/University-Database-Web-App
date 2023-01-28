package higherEducation.model;

/*
CREDLEV VARCHAR(255),
CREDDESC LONGTEXT,
 */
public class DegreeLevel {
  protected String CREDLEV;
  protected String CREDDESC;

  public DegreeLevel(String CREDLEV, String CREDDESC) {
    this.CREDLEV = CREDLEV;
    this.CREDDESC = CREDDESC;
  }

  public String getCREDLEV() {
    return CREDLEV;
  }

  public void setCREDLEV(String CREDLEV) {
    this.CREDLEV = CREDLEV;
  }

  public String getCREDDESC() {
    return CREDDESC;
  }

  public void setCREDDESC(String CREDDESC) {
    this.CREDDESC = CREDDESC;
  }
}
