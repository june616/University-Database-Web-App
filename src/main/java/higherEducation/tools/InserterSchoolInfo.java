package higherEducation.tools;

import higherEducation.dal.StatesDao;
import higherEducation.model.States;
import java.sql.SQLException;
import java.util.List;
import higherEducation.dal.CIPDao;
import higherEducation.dal.CampusDao;
import higherEducation.dal.DegreeDao;
import higherEducation.dal.DegreeLevelDao;
import higherEducation.dal.UniversitiesDao;
import higherEducation.model.CIP;
import higherEducation.model.Campus;
import higherEducation.model.Degree;
import higherEducation.model.DegreeLevel;
import higherEducation.model.Universities;

public class InserterSchoolInfo {

  public static void main(String[] args) throws SQLException {
    CIPDao cipDao= CIPDao.getInstance();
    DegreeLevelDao degreeLevelDao= DegreeLevelDao.getInstance();
    DegreeDao degreeDao= DegreeDao.getInstance();
    CampusDao campusDao=CampusDao.getInstance();
    UniversitiesDao uDao=UniversitiesDao.getInstance();
    // insert cip
    CIP cip1=new CIP("0","testTitle","testDefinition");
    cip1=cipDao.create(cip1);
    System.out.println("insert CIP: "+cip1);
  // insert degree
    StatesDao statesDao = StatesDao.getInstance();
    States testState = new States("AA", "Apple", "Alice",
        "Axios",22234544,34332233,323424235);
    statesDao.create(testState);
    DegreeLevel level1=new DegreeLevel("0","test");
    Universities neu= new Universities(
        111111111,12332,12321421,"CC", "colons",
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
    UniversitiesDao universitiesDao = UniversitiesDao.getInstance();
    universitiesDao.create(neu);
    Degree degree1=new Degree(neu,cip1,level1);
    degree1=degreeDao.create(degree1);
    System.out.println("insert Degree: "+degree1);
    // insert campus
    Campus campus1=new Campus("1",neu,"Mars","Northeastern","2","test","test");
    Campus campus11=new Campus("2",neu,"Moon","Northeastern","2","test","test");
    Campus campus111=new Campus("3",neu,"Sun","Northeastern","2","test","test");
    campus1=campusDao.create(campus1);
    campus1=campusDao.create(campus11);
    campus1=campusDao.create(campus111);

    System.out.println("insert campus: "+campus1);


    // test get
    CIP cip2=cipDao.getCIPFromCode("0");
    System.out.println("get CIP 0: "+cip2);

    DegreeLevel level2=degreeLevelDao.getDegreeFromCode("1");
    System.out.println("get DegreeLevel 1: "+level2);

    List<Campus> campus2=campusDao.getCampusFromUNITID(neu.getUnitId());
    System.out.println("get campus for university");
    for(Campus c:campus2){
      System.out.println(c);
    }

    // test delete
    CIP cip3=cipDao.delete(cip1);
    System.out.println("delete cip: "+cip3);

    Degree degree3=degreeDao.delete(degree1);
    System.out.println("delete degree: "+degree3);

    Campus campus3=campusDao.delete(campus1);
    System.out.println("delete campus: "+campus3);

    // no delete or create for DegreeLevel
    // clean the data afterwards
    universitiesDao.delete(neu);
    statesDao.delete(testState);
  }
}
