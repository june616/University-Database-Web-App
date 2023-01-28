package higherEducation.model;/*
CIPCODE VARCHAR(255),
CIPTitle VARCHAR(255) ,
CIPDefinition LONGTEXT,
 */

public class CIP {
  protected String CIPCODE;
  protected String CIPTitle;
  protected String CIPDefinition;

  public CIP(String CIPCODE, String CIPTitle, String CIPDefinition) {
    this.CIPCODE = CIPCODE;
    this.CIPTitle = CIPTitle;
    this.CIPDefinition = CIPDefinition;
  }

  public String getCIPCODE() {
    return CIPCODE;
  }

  public void setCIPCODE(String CIPCODE) {
    this.CIPCODE = CIPCODE;
  }

  public String getCIPTitle() {
    return CIPTitle;
  }

  public void setCIPTitle(String CIPTitle) {
    this.CIPTitle = CIPTitle;
  }

  public String getCIPDefinition() {
    return CIPDefinition;
  }

  public void setCIPDefinition(String CIPDefinition) {
    this.CIPDefinition = CIPDefinition;
  }

  @Override
  public String toString() {
    return "CIP{" +
        "CIPCODE='" + CIPCODE + '\'' +
        ", CIPTitle='" + CIPTitle + '\'' +
        ", CIPDefinition='" + CIPDefinition + '\'' +
        '}';
  }
}
