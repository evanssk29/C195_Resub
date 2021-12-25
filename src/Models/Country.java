package Models;

public class Country {
    private String CountryTitle;
    private int CountryName;


    public Country(int CountryName, String CountryTitle) {
        this.CountryName = CountryName;
        this.CountryTitle = CountryTitle;
    }

    /** @return CountryName */
    public int getCountryName() {
        return CountryName;
    }

    /** get CountryTitle */
    public String getCountryTitle() {
        return CountryTitle;
    }
}
