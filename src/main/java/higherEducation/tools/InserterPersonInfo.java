package higherEducation.tools;

import higherEducation.dal.ApplicantsDao;
import higherEducation.dal.CollectionsDao;
import higherEducation.dal.CommentsDao;
import higherEducation.dal.CommentsLikeDao;
import higherEducation.dal.CounselorsDao;
import higherEducation.dal.ReservationsDao;
import higherEducation.dal.StatesDao;
import higherEducation.dal.UniversitiesDao;
import higherEducation.model.Applicants;
import higherEducation.model.Collections;
import higherEducation.model.Comments;
import higherEducation.model.CommentsLike;
import higherEducation.model.Counselors;
import higherEducation.model.Reservations;
import higherEducation.model.States;
import higherEducation.model.Universities;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Month;

public class InserterPersonInfo {

  public static void main(String[] args) throws SQLException {

    CollectionsDao collectionsDao = CollectionsDao.getInstance();
    ReservationsDao reservationsDao = ReservationsDao.getInstance();
    ApplicantsDao applicantsDao = ApplicantsDao.getInstance();
    CounselorsDao counselorsDao = CounselorsDao.getInstance();
    StatesDao statesDao = StatesDao.getInstance();
    UniversitiesDao universitiesDao = UniversitiesDao.getInstance();
    CommentsDao commentsDao = CommentsDao.getInstance();
    CommentsLikeDao commentsLikeDao = CommentsLikeDao.getInstance();


    Applicants ap1 = new Applicants(60202, "NW", "12345","Nicholas","Wang",
        "NW@gmail.com",Applicants.Gender.male,
        Timestamp.valueOf("2004-10-20 11:59:45"), true, "Bellevue High",
        "Bellevue", "WA", "98004","Asian","Master");
    ap1 = applicantsDao.create(ap1);
    Counselors c = new Counselors(70002, "CC", "CC", "CC","CC",
        "CC@gmail.com", Counselors.Gender.female, 8, true, "Seattle", "WA", "98109", "American");
    c = counselorsDao.create(c);

    States testState = new States("AC", "Apple", "CP",
        "Axios",22234544,34332233,323424235);
    statesDao.create(testState);
    Universities neu= new Universities(
        1234568,12332,12321421,"CC", "colons",
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
    neu = universitiesDao.create(neu);




    Collections collections1 = new Collections(neu, ap1, "Great School!");
    collections1 = collectionsDao.create(collections1);

    Date createAt = new Date(System.currentTimeMillis());
    Date startAt = new Date(Timestamp.valueOf("2022-11-15 13:30:30").getTime());
    Date endAt = new Date(Timestamp.valueOf("2022-11-15 14:30:30").getTime());
    Reservations reservations1 = new Reservations(createAt, "TEST MEETING", startAt, endAt, c, ap1);
    reservationsDao.create(reservations1);

    Comments comments1 = new Comments("this is a comment",createAt, neu, ap1);
    comments1 = commentsDao.create(comments1);

    CommentsLike commentsLike1 = new CommentsLike(createAt, comments1, c);
    commentsLike1 = commentsLikeDao.create(commentsLike1);

    // create
    System.out.println("Create: ");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("  Create collections: ");
    System.out.println("  " + collections1);
    System.out.println();
    System.out.println("  Create reservations: ");
    System.out.println("  " + reservations1);
    System.out.println();
    System.out.println("  Create comments: ");
    System.out.println("  " + comments1);
    System.out.println();
    System.out.println("  Create comments like: ");
    System.out.println("  " + commentsLike1);
    System.out.println("-----------------------------------------------------------------------------------");


    // get - by id
    System.out.println("Get: ");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("  Get collections by id: ");
    Collections collectionsRead = collectionsDao.getCollectionById(collections1.getCollectionsId());
    System.out.println("  " + collectionsRead);
    System.out.println();
    System.out.println("  Get reservations by id: ");
    Reservations reservationsRead = reservationsDao.getReservationById(reservations1.getReservationId());
    System.out.println("  " + reservationsRead);
    System.out.println();
    System.out.println("  Get comments by id: ");
    Comments commentsRead = commentsDao.getCommentById(comments1.getCommentsId());
    System.out.println(commentsRead);
    System.out.println();
    System.out.println("  Get comments like by id: ");
    CommentsLike commentsLikeRead = commentsLikeDao.getCommentsLikeById(commentsLike1.getCommentsLikeId());
    System.out.println(commentsLikeRead);
    System.out.println(commentsRead);

    System.out.println("-----------------------------------------------------------------------------------");

    // update
    System.out.println("Update: ");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("  update collections note: ");
    System.out.println("    Before: Note: " + collections1.getNotes());
    collectionsDao.updateCollectionNote(collections1, "Perfect yo!");
    System.out.println("    After: Note: " + collections1.getNotes());
    System.out.println();
    System.out.println("  update reservations title: ");
    System.out.println("    Before: Title: " + reservations1.getEventTitle());
    reservationsDao.updateReservationTitle(reservations1, "NEW NEW meeting");
    System.out.println("    After: Title: " + reservations1.getEventTitle());
    System.out.println();
    System.out.println(" update comments content");
    System.out.println("  Before: Content: " + comments1.getContent());
    commentsDao.updateCommentContent(comments1, "NEW NEW NEW");
    System.out.println("  After: Content: " + comments1.getContent());
    System.out.println("-----------------------------------------------------------------------------------");

    // delete
    System.out.println("Delete: ");
    System.out.println("-----------------------------------------------------------------------------------");
    System.out.println("  delete collections: ");
    Collections collectionsDelete = collectionsDao.delete(collections1);
    System.out.println("    Delete status: " + (collectionsDelete == null));
    System.out.println("  delete reservations: ");
    Reservations reservationsDelete = reservationsDao.delete(reservations1);
    System.out.println("    Delete status: " + (reservationsDelete == null));
    System.out.println("  delete comments: ");
    Comments commentsDelete = commentsDao.delete(comments1);
    System.out.println("    Delete status: " + (commentsDelete == null));
    System.out.println("  delete comments like: ");
    try {
      commentsLikeDao.delete(commentsLike1);
    } catch (SQLException e) {
      System.out.println("    Delete status: " + true);
      System.out.println("Exception is expected. As when comment is deleted, comment like will also be deleted automatically");
    }
    System.out.println("-----------------------------------------------------------------------------------");


    applicantsDao.delete(ap1);
    counselorsDao.delete(c);
    universitiesDao.delete(neu);
    statesDao.delete(testState);
  }
}
