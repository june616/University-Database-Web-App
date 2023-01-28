package higherEducation.model;

/*
DapipId VARCHAR(255),
UNITID INT ,
LocationName VARCHAR(255),
ParentName VARCHAR(255),
ParentDapipId VARCHAR(255),
LocationType VARCHAR(255),
Address LONGTEXT,
GeneralPhone VARCHAR(255),
AdminName VARCHAR(255),
AdminPhone VARCHAR(255),
AdminEmail VARCHAR(255),
Fax VARCHAR(255),
 */
public class Campus {
  protected String DapipId;
  protected Universities University;
  protected String LocationName;
  protected String ParentName;
  protected String ParentDapipId;
  protected String LocationType;
  protected String Address;
  protected String GeneralPhone;
  protected String AdminName;
  protected String AdminPhone;
  protected String AdminEmail;
  protected String Fax;

  public Campus(String dapipId, Universities university, String locationName, String parentName,
      String parentDapipId, String locationType, String address, String generalPhone,
      String adminName, String adminPhone, String adminEmail, String fax) {
    DapipId = dapipId;
    University= university;
    LocationName = locationName;
    ParentName = parentName;
    ParentDapipId = parentDapipId;
    LocationType = locationType;
    Address = address;
    GeneralPhone = generalPhone;
    AdminName = adminName;
    AdminPhone = adminPhone;
    AdminEmail = adminEmail;
    Fax = fax;
  }

  public Campus(String dapipId, Universities university, String locationName, String parentName,
      String parentDapipId, String locationType, String address) {
    DapipId = dapipId;
    University = university;
    LocationName = locationName;
    ParentName = parentName;
    ParentDapipId = parentDapipId;
    LocationType = locationType;
    Address = address;
  }

  public String getDapipId() {
    return DapipId;
  }

  public void setDapipId(String dapipId) {
    DapipId = dapipId;
  }

  public Universities getUniversity() {
    return University;
  }

  public void setUniversity(Universities university) {
    University = university;
  }

  public String getLocationName() {
    return LocationName;
  }

  public void setLocationName(String locationName) {
    LocationName = locationName;
  }

  public String getParentName() {
    return ParentName;
  }

  public void setParentName(String parentName) {
    ParentName = parentName;
  }

  public String getParentDapipId() {
    return ParentDapipId;
  }

  public void setParentDapipId(String parentDapipId) {
    ParentDapipId = parentDapipId;
  }

  public String getLocationType() {
    return LocationType;
  }

  public void setLocationType(String locationType) {
    LocationType = locationType;
  }

  public String getAddress() {
    return Address;
  }

  public void setAddress(String address) {
    Address = address;
  }

  public String getGeneralPhone() {
    return GeneralPhone;
  }

  public void setGeneralPhone(String generalPhone) {
    GeneralPhone = generalPhone;
  }

  public String getAdminName() {
    return AdminName;
  }

  public void setAdminName(String adminName) {
    AdminName = adminName;
  }

  public String getAdminPhone() {
    return AdminPhone;
  }

  public void setAdminPhone(String adminPhone) {
    AdminPhone = adminPhone;
  }

  public String getAdminEmail() {
    return AdminEmail;
  }

  public void setAdminEmail(String adminEmail) {
    AdminEmail = adminEmail;
  }

  public String getFax() {
    return Fax;
  }

  public void setFax(String fax) {
    Fax = fax;
  }

  @Override
  public String toString() {
    return "Campus{" +
        "DapipId='" + DapipId + '\'' +
        ", University=" + University +
        ", LocationName='" + LocationName + '\'' +
        ", ParentName='" + ParentName + '\'' +
        ", ParentDapipId='" + ParentDapipId + '\'' +
        ", LocationType='" + LocationType + '\'' +
        ", Address='" + Address + '\'' +
        ", GeneralPhone='" + GeneralPhone + '\'' +
        ", AdminName='" + AdminName + '\'' +
        ", AdminPhone='" + AdminPhone + '\'' +
        ", AdminEmail='" + AdminEmail + '\'' +
        ", Fax='" + Fax + '\'' +
        '}';
  }
}
