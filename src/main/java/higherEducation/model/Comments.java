package higherEducation.model;

import java.util.Date;

public class Comments {
  private Integer commentsId;
  private String content;
  private Date createAt;
  private Universities university;
  private Persons person;

  public Comments(Integer commentsId, String content, Date createAt, Universities university,
      Persons person) {
    this.commentsId = commentsId;
    this.content = content;
    this.createAt = createAt;
    this.university = university;
    this.person = person;
  }

  public Comments(String content, Date createAt, Universities university, Persons person) {
    this.content = content;
    this.createAt = createAt;
    this.university = university;
    this.person = person;
  }

  public Integer getCommentsId() {
    return commentsId;
  }

  public String getContent() {
    return content;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public Universities getUniversity() {
    return university;
  }

  public Persons getPerson() {
    return person;
  }

  public void setCommentsId(Integer commentsId) {
    this.commentsId = commentsId;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "Comments{" +
        "commentsId=" + commentsId +
        ", content='" + content + '\'' +
        ", createAt=" + createAt +
        ", university=" + university +
        ", person=" + person +
        '}';
  }
}
