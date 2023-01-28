package higherEducation.model;

public class USNewsHistoricalRanking {
  protected int usnewsEntryID;
  protected String universityName;
  protected Universities university;
  protected String state;
  protected int rank2022;
  protected int rank2021;
  protected int rank2020;
  protected int rank2019;
  protected int rank2018;
  protected int rank2017;
  protected int rank2016;
  protected int rank2015;
  protected int rank2014;
  protected int rank2013;

  public USNewsHistoricalRanking(int usnewsEntryID, String universityName,
      Universities university, String state, int rank2022, int rank2021, int rank2020, int rank2019,
      int rank2018, int rank2017, int rank2016, int rank2015, int rank2014, int rank2013) {
    this.usnewsEntryID = usnewsEntryID;
    this.universityName = universityName;
    this.university = university;
    this.state = state;
    this.rank2022 = rank2022;
    this.rank2021 = rank2021;
    this.rank2020 = rank2020;
    this.rank2019 = rank2019;
    this.rank2018 = rank2018;
    this.rank2017 = rank2017;
    this.rank2016 = rank2016;
    this.rank2015 = rank2015;
    this.rank2014 = rank2014;
    this.rank2013 = rank2013;
  }

  public USNewsHistoricalRanking(int usnewsEntryID) {
    this.usnewsEntryID = usnewsEntryID;
  }

  public USNewsHistoricalRanking(String universityName, Universities university, String state,
      int rank2022, int rank2021, int rank2020, int rank2019, int rank2018, int rank2017,
      int rank2016, int rank2015, int rank2014, int rank2013) {
    this.universityName = universityName;
    this.university = university;
    this.state = state;
    this.rank2022 = rank2022;
    this.rank2021 = rank2021;
    this.rank2020 = rank2020;
    this.rank2019 = rank2019;
    this.rank2018 = rank2018;
    this.rank2017 = rank2017;
    this.rank2016 = rank2016;
    this.rank2015 = rank2015;
    this.rank2014 = rank2014;
    this.rank2013 = rank2013;
  }

  public int getUsnewsEntryID() {
    return usnewsEntryID;
  }

  public void setUsnewsEntryID(int usnewsEntryID) {
    this.usnewsEntryID = usnewsEntryID;
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

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public int getRank2022() {
    return rank2022;
  }

  public void setRank2022(int rank2022) {
    this.rank2022 = rank2022;
  }

  public int getRank2021() {
    return rank2021;
  }

  public void setRank2021(int rank2021) {
    this.rank2021 = rank2021;
  }

  public int getRank2020() {
    return rank2020;
  }

  public void setRank2020(int rank2020) {
    this.rank2020 = rank2020;
  }

  public int getRank2019() {
    return rank2019;
  }

  public void setRank2019(int rank2019) {
    this.rank2019 = rank2019;
  }

  public int getRank2018() {
    return rank2018;
  }

  public void setRank2018(int rank2018) {
    this.rank2018 = rank2018;
  }

  public int getRank2017() {
    return rank2017;
  }

  public void setRank2017(int rank2017) {
    this.rank2017 = rank2017;
  }

  public int getRank2016() {
    return rank2016;
  }

  public void setRank2016(int rank2016) {
    this.rank2016 = rank2016;
  }

  public int getRank2015() {
    return rank2015;
  }

  public void setRank2015(int rank2015) {
    this.rank2015 = rank2015;
  }

  public int getRank2014() {
    return rank2014;
  }

  public void setRank2014(int rank2014) {
    this.rank2014 = rank2014;
  }

  public int getRank2013() {
    return rank2013;
  }

  public void setRank2013(int rank2013) {
    this.rank2013 = rank2013;
  }
  
  @Override
  public String toString() {
    return "USNewsHistoricalRanking{" +
        "usnewsEntryID=" + usnewsEntryID +
        ", universityName='" + universityName + '\'' +
        ", university=" + university +
        ", state='" + state + '\'' +
        ", rank2022=" + rank2022 +
        ", rank2021=" + rank2021 +
        ", rank2020=" + rank2020 +
        ", rank2019=" + rank2019 +
        ", rank2018=" + rank2018 +
        ", rank2017=" + rank2017 +
        ", rank2016=" + rank2016 +
        ", rank2015=" + rank2015 +
        ", rank2014=" + rank2014 +
        ", rank2013=" + rank2013 +
        '}';
  }
}
