package higherEducation.model;

import java.util.Date;

/**
 * Represent a reservation
 */
public class Reservations {
  private Integer reservationId;
  private Date createAt;
  private String eventTitle;
  private Date eventBegin;
  private Date eventEnd;
  private Persons host;
  private Persons participant;

  public Reservations(Date createAt, String eventTitle, Date eventBegin, Date eventEnd,
      Persons host,
      Persons participant) {
    this.createAt = createAt;
    this.eventTitle = eventTitle;
    this.eventBegin = eventBegin;
    this.eventEnd = eventEnd;
    this.host = host;
    this.participant = participant;
  }

  public Reservations(Integer reservationID, Date createAt, String eventTitle, Date eventBegin,
      Date eventEnd, Persons host, Persons participant) {
    this.reservationId = reservationID;
    this.createAt = createAt;
    this.eventTitle = eventTitle;
    this.eventBegin = eventBegin;
    this.eventEnd = eventEnd;
    this.host = host;
    this.participant = participant;
  }

  public Integer getReservationId() {
    return reservationId;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public String getEventTitle() {
    return eventTitle;
  }

  public Date getEventBegin() {
    return eventBegin;
  }

  public Date getEventEnd() {
    return eventEnd;
  }

  public Persons getHost() {
    return host;
  }

  public Persons getParticipant() {
    return participant;
  }

  public void setReservationId(Integer reservationId) {
    this.reservationId = reservationId;
  }

  public void setEventTitle(String eventTitle) {
    this.eventTitle = eventTitle;
  }

  @Override
  public String toString() {
    return "Reservations{" +
        "reservationID=" + reservationId +
        ", createAt=" + createAt +
        ", eventTitle='" + eventTitle + '\'' +
        ", eventBegin=" + eventBegin +
        ", eventEnd=" + eventEnd +
        ", host=" + host +
        ", participant=" + participant +
        '}';
  }
}
