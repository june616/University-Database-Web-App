package higherEducation.model;

public class States {

    protected String postalAbbreviation;
    protected String largestCity;
    protected String capital;
    protected String stateName;
    protected int population;
    protected int totalAreaSquareMiles;
    protected int perCapitaPersonalIncome;

    public States(String postalAbbreviation, String largestCity, String capital, String stateName,
        int population, int totalAreaSquareMiles, int perCapitaPersonalIncome) {
        this.postalAbbreviation = postalAbbreviation;
        this.largestCity = largestCity;
        this.capital = capital;
        this.stateName = stateName;
        this.population = population;
        this.totalAreaSquareMiles = totalAreaSquareMiles;
        this.perCapitaPersonalIncome = perCapitaPersonalIncome;
    }

    public String getPostalAbbreviation() {
        return postalAbbreviation;
    }

    public void setPostalAbbreviation(String postalAbbreviation) {
        this.postalAbbreviation = postalAbbreviation;
    }

    public String getLargestCity() {
        return largestCity;
    }

    public void setLargestCity(String largestCity) {
        this.largestCity = largestCity;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getTotalAreaSquareMiles() {
        return totalAreaSquareMiles;
    }

    public void setTotalAreaSquareMiles(int totalAreaSquareMiles) {
        this.totalAreaSquareMiles = totalAreaSquareMiles;
    }

    public int getPerCapitaPersonalIncome() {
        return perCapitaPersonalIncome;
    }

    public void setPerCapitaPersonalIncome(int perCapitaPersonalIncome) {
        this.perCapitaPersonalIncome = perCapitaPersonalIncome;
    }

    @Override
    public String toString() {
        return "higherEducation.model.States{" +
            "postalAbbreviation='" + postalAbbreviation + '\'' +
            ", largestCity='" + largestCity + '\'' +
            ", capital='" + capital + '\'' +
            ", stateName='" + stateName + '\'' +
            ", population=" + population +
            ", totalAreaSquareMiles=" + totalAreaSquareMiles +
            ", perCapitaPersonalIncome=" + perCapitaPersonalIncome +
            '}';
    }
}
