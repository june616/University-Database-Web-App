package higherEducation.model;

import java.util.Date;

public class CommentsLike {
  private Integer commentsLikeId;
  private Date createAt;
  private Comments comment;
  private Persons person;

  public CommentsLike(Integer commentsLikeId, Date createAt, Comments comment, Persons person) {
    this.commentsLikeId = commentsLikeId;
    this.createAt = createAt;
    this.comment = comment;
    this.person = person;
  }

  public CommentsLike(Date createAt, Comments comment, Persons person) {
    this.createAt = createAt;
    this.comment = comment;
    this.person = person;
  }

  public Integer getCommentsLikeId() {
    return commentsLikeId;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public Comments getComment() {
    return comment;
  }

  public Persons getPerson() {
    return person;
  }

  public void setCommentsLikeId(Integer commentsLikeId) {
    this.commentsLikeId = commentsLikeId;
  }
}
