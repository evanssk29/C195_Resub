package ViewController;

import Access.Countries;
import Models.Country;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class Customers {


    @FXML public TextField TextField_CustomerID;
    @FXML public TextField TextField_CustomerName;
    @FXML public TextField TextField_CustomerAddress;
    @FXML public TextField TextField_Customer_PostalCode;
    @FXML public TextField TextField_CustomerPhoneNumber;
    @FXML public ComboBox<String> ComboBox_Country;
    @FXML public ComboBox<String> ComboBox_FirstLevelDivision;
    @FXML public Button Button_Customers_Clear;
    @FXML public Button Button_Customers_Update;
    @FXML public Button Button_Customers_Add;
    @FXML public Button Button_Customers_Delete;
    @FXML public TableColumn<Customers, Integer> Table_Customers_IDColumn;
    @FXML public TableView<Customers> TableView_Customers;
    @FXML public TableColumn<Customers, String> Table_Customers_NameColumn;
    @FXML public TableColumn<Customers, String> Table_Customers_AddressColumn;
    @FXML public TableColumn<Customers, Integer> Table_Customers_FirstLevelDivisionColumn;
    @FXML public TableColumn<Customers, String> Table_Customers_PostalCodeColumn;
    @FXML public TableColumn<Customers, String> Table_Customers_PhoneColumn;


    public void initialize() throws SQLException {
        Table_Customers_PhoneColumn.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        Table_Customers_FirstLevelDivisionColumn.setCellValueFactory(new PropertyValueFactory<>("DivisionID"));
        Table_Customers_IDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        Table_Customers_AddressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        Table_Customers_NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Table_Customers_PostalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));

        ObservableList<Country> allCountries = Countries.getAllCountries();
        ObservableList<String> CountryTitles = FXCollections.observableArrayList();
        for (Country country : allCountries) {
            CountryTitles.add(country.getCountryTitle());
        }
    }


    // radio buttons for scene changes from customers
    public void radioButtonReports(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../ViewController/Reports.fxml")));
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(root, 1100, 500));
    }

    public void radioButtonAppointments(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../ViewController/Appointments.fxml")));
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(root, 1100, 500));
    }

    // clears customer boxes
    public void clearCustomers(ActionEvent actionEvent) {
    }

    public void deleteCustomer(ActionEvent actionEvent) {
    }

    public void filterFirstLevelDivision(ActionEvent actionEvent) {
    }

    // clear customer table
    public void clearCustomers() {

        TableView_Customers.getSelectionModel().clearSelection();
        TextField_CustomerID.clear();
        TextField_CustomerID.setDisable(true);
        TextField_CustomerName.clear();
        TextField_CustomerAddress.clear();
        TextField_Customer_PostalCode.clear();
        TextField_CustomerPhoneNumber.clear();
        ComboBox_Country.setValue("");
        ComboBox_FirstLevelDivision.setValue("");
        Button_Customers_Add.setDisable(false);
        Button_Customers_Update.setDisable(true);
        Button_Customers_Delete.setDisable(true);
        Button_Customers_Clear.setDisable(true);

    }

    public void setUpdateCustomerButton() throws SQLException {
        int idToUpdate = Integer.parseInt(TextField_CustomerID.getText());
        String nameToUpdate = TextField_CustomerName.getText();

    }
}
