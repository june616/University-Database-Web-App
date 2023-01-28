package higherEducation.tools;

import higherEducation.dal.*;
import higherEducation.model.*;
import java.sql.SQLException;
import java.util.List;

public class InserterRanking {

public static void main(String[] args) throws SQLException {
	  CwruRankingDao cwruDao = CwruRankingDao.getInstance();
	    ShanghaiRankingDao shanghaiDao = ShanghaiRankingDao.getInstance();
	    TimesRankingDao timesDao = TimesRankingDao.getInstance();
	    USNewsHistoricalRankingDao usNewsDao = USNewsHistoricalRankingDao.getInstance();
	    UniversitiesDao uDao = UniversitiesDao.getInstance();
	    Universities harvard = uDao.getUniversityByUnitId(166027);
	    // insert CwruRanking
	    CwruRanking cwru1 = new CwruRanking(1, "Harvard University", harvard, 7,9,1,1,1,1,5,100,"2022");
	    cwru1 = cwruDao.create(cwru1);
	    System.out.println("insert CwruRanking: " + cwru1);

	    // delete CwruRanking by entry id
	    CwruRanking cwru2 = cwruDao.delete(cwru1);
	    System.out.println("delete CwruRanking by entry id: " + cwru2);
	    
	    // get CwruRanking for a university
	    List<CwruRanking> harvardCwruRank = cwruDao.getCwruRankingForUniversity(harvard);
	    for (CwruRanking rank:harvardCwruRank) {
	      System.out.println("get CwruRanking for a university: " + rank);
	    }

	    // insert ShanghaiRanking
	    ShanghaiRanking sh1 = new ShanghaiRanking(1, "Harvard University", harvard, 100,100,100,100,100,100,(float) 72.4,"2022");
	    sh1 = shanghaiDao.create(sh1);
	    System.out.println("insert ShanghaiRanking: " + sh1);
	    
	    // delete ShanghaiRanking by entry id
	    ShanghaiRanking sh2 = shanghaiDao.delete(sh1);
	    System.out.println("delete ShanghaiRanking by entry id: " + sh2);
	    
	    // get ShanghaiRanking for a university
	    List<ShanghaiRanking> harvardShRank = shanghaiDao.getShanghaiRankingForUniversity(harvard);
	    for (ShanghaiRanking rank:harvardShRank) {
	      System.out.println("get ShanghaiRanking for a university: " + rank);
	    }
	    
	    // insert TimesRanking
	    TimesRanking t1 = new TimesRanking(1, "Harvard University", harvard, 99.7,72.4,98.7,98.8,34.5,96.1,20152,8.9,0.25,0.8,"2022");
	    t1 = timesDao.create(t1);
	    System.out.println("insert TimesRanking: " + t1);
	    
	    // delete TimesRanking by entry id
	    TimesRanking t2 = timesDao.delete(t1);
	    System.out.println("delete TimesRanking by entry id: " + t2);
	    
	    // get TimesRanking for a university
	    List<TimesRanking> harvardTimesRank = timesDao.getTimesRankingForUniversity(harvard);
	    for (TimesRanking rank:harvardTimesRank) {
	      System.out.println("get TimesRanking for a university: " + rank);
	    }
	    
	    // insert USNewsHistoricalRanking
	    USNewsHistoricalRanking un1 = new USNewsHistoricalRanking("Harvard University", harvard, "MA",2,2,2,2,2,2,2,2,2,1);
	    un1 = usNewsDao.create(un1);
	    System.out.println("insert USNewsHistoricalRanking: " + un1);
	    
	    // delete USNewsHistoricalRanking by entry id
	    USNewsHistoricalRanking un2 = usNewsDao.delete(un1);
	    System.out.println("delete USNewsHistoricalRanking by entry id: " + un2);
	    
	    // get USNewsHistoricalRanking for a university
	    List<USNewsHistoricalRanking> harvardUSNewsRank = usNewsDao.getUSNewsHistoricalRankingForUniversity(harvard);
	    for (USNewsHistoricalRanking rank:harvardUSNewsRank) {
	      System.out.println("get USNewsHistoricalRanking for a university: " + rank);
	    }
  

  }

}
