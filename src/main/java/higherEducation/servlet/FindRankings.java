
    package higherEducation.servlet;

    import higherEducation.dal.*;
    import higherEducation.model.*;

    import java.io.IOException;
    import java.sql.SQLException;
    import java.util.ArrayList;
    import java.util.List;

    import javax.servlet.annotation.*;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

@WebServlet("/rankings")
public class FindRankings extends HttpServlet {
  protected USNewsHistoricalRankingDao usNewsDao;
  protected CwruRankingDao cwruDao;
  protected ShanghaiRankingDao shanghaiDao;
  protected TimesRankingDao timesDao;

  @Override
  public void init() throws ServletException {
    usNewsDao = USNewsHistoricalRankingDao.getInstance();
    cwruDao = CwruRankingDao.getInstance();
    shanghaiDao = ShanghaiRankingDao.getInstance();
    timesDao = TimesRankingDao.getInstance();
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<USNewsHistoricalRanking> top50USNewsRank = new ArrayList<USNewsHistoricalRanking>();
    List<CwruRanking> top50CwruRank = new ArrayList<CwruRanking>();
    List<ShanghaiRanking> top50ShanghaiRank = new ArrayList<ShanghaiRanking>();
    List<TimesRanking> top50TimesRank = new ArrayList<TimesRanking>();
    try {
      top50USNewsRank = usNewsDao.getTop50USNewsHistoricalRanking();
      top50CwruRank = cwruDao.getTop50CwruRanking();
      top50ShanghaiRank = shanghaiDao.getTop50ShanghaiRanking();
      top50TimesRank = timesDao.getTop50TimesRanking();
    } catch (SQLException e) {
      e.printStackTrace();
      throw new IOException(e);
    }
    req.setAttribute("top50USNewsRank", top50USNewsRank);
    req.setAttribute("top50CwruRank", top50CwruRank);
    req.setAttribute("top50ShanghaiRank", top50ShanghaiRank);
    req.setAttribute("top50TimesRank", top50TimesRank);
    req.getRequestDispatcher("/Rankings.jsp").forward(req, resp);
  }
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    List<USNewsHistoricalRanking> top50USNewsRank = new ArrayList<USNewsHistoricalRanking>();
    List<CwruRanking> top50CwruRank = new ArrayList<CwruRanking>();
    List<ShanghaiRanking> top50ShanghaiRank = new ArrayList<ShanghaiRanking>();
    List<TimesRanking> top50TimesRank = new ArrayList<TimesRanking>();
    try {
      top50USNewsRank = usNewsDao.getTop50USNewsHistoricalRanking();
      top50CwruRank = cwruDao.getTop50CwruRanking();
      top50ShanghaiRank = shanghaiDao.getTop50ShanghaiRanking();
      top50TimesRank = timesDao.getTop50TimesRanking();
    } catch (SQLException e) {
      e.printStackTrace();
      throw new IOException(e);
    }
    req.setAttribute("top50USNewsRank", top50USNewsRank);
    req.setAttribute("top50CwruRank", top50CwruRank);
    req.setAttribute("top50ShanghaiRank", top50ShanghaiRank);
    req.setAttribute("top50TimesRank", top50TimesRank);
    req.getRequestDispatcher("/Rankings.jsp").forward(req, resp);
  }

}

