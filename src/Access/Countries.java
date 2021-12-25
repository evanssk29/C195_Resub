package Access;

import Utilities.ConnectionDB;
import Models.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Countries {

    public static ObservableList<Country> getAllCountries() throws SQLException {
        ObservableList<Country> countriesObservableList = FXCollections.observableArrayList();
        String sql = "SELECT * from countries";
        PreparedStatement ps = ConnectionDB.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int CountryName = rs.getInt("Country_ID");
            String CountryTitle = rs.getString("Country");
            Country country = new Country(CountryName, CountryTitle);
            countriesObservableList.add(country);
        }
        return countriesObservableList;
    }
}
