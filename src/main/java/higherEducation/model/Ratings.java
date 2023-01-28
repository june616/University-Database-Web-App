package higherEducation.model;

public class Ratings {

    protected int ratingId;
    protected float ratingValue;
    protected Persons person;
    protected Universities university;

    public Ratings(int ratingId, float ratingValue, Persons person, Universities university) {
        this.ratingId = ratingId;
        this.ratingValue = ratingValue;
        this.person = person;
        this.university = university;
    }

    public Ratings(int ratingId) {
        this.ratingId = ratingId;
    }

    public Ratings(float ratingValue, Persons person, Universities university) {
        this.ratingValue = ratingValue;
        this.person = person;
        this.university = university;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public float getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(float ratingValue) {
        this.ratingValue = ratingValue;
    }

    public Persons getPerson() {
        return person;
    }

    public void setPerson(Persons person) {
        this.person = person;
    }

    public Universities getUniversity() {
        return university;
    }

    public void setUniversity(Universities university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "higherEducation.model.Ratings{" +
            "ratingId=" + ratingId +
            ", ratingValue=" + ratingValue +
            ", person=" + person +
            ", university=" + university +
            '}';
    }
}
