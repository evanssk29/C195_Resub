package Models;

public class Country {
    private String countryName;
    private int countryID;


    public Country(int countryID, String countryName) {
        this.countryID = countryID;
        this.countryName = countryName;
    }

    /** @return countryID */
    public int getCountryID() {
        return countryID;
    }

    /** get countryName */
    public String getCountryName() {
        return countryName;
    }
}
