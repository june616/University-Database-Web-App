package higherEducation.model;

public class Collections {
  private Integer collectionsId;
  private Universities universities;
  private Persons persons;
  private String notes;

  public Collections(Integer collectionsId, Universities universities, Persons persons,
      String notes) {
    this.collectionsId = collectionsId;
    this.universities = universities;
    this.persons = persons;
    this.notes = notes;
  }

  public Collections(Universities universities, Persons persons, String notes) {
    this.universities = universities;
    this.persons = persons;
    this.notes = notes;
  }

  public Integer getCollectionsId() {
    return collectionsId;
  }

  public Universities getUniversities() {
    return universities;
  }

  public Persons getPersons() {
    return persons;
  }

  public String getNotes() {
    return notes;
  }

  public void setCollectionsId(Integer collectionsId) {
    this.collectionsId = collectionsId;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  @Override
  public String toString() {
    return "Collections{" +
        "collectionsId=" + collectionsId +
        ", universities=" + universities +
        ", persons=" + persons +
        ", notes='" + notes + '\'' +
        '}';
  }
}
