package Controllers;

import DBAccess.DBCountries;
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


    @FXML public TextField customerIDField;
    @FXML public TextField customerNameField;
    @FXML public TextField customerAddressField;
    @FXML public TextField customerPostalCodeField;
    @FXML public TextField customerPhoneNumberField;
    @FXML public ComboBox<String> countryComboBox;
    @FXML public ComboBox<String> firstLevelDivisionComboBox;
    @FXML public Button clearCustomerButton;
    @FXML public Button updateCustomerButton;
    @FXML public Button addCustomerButton;
    @FXML public Button deleteCustomerButton;
    @FXML public TableColumn<Customers, Integer> customerTableIDColumn;
    @FXML public TableView<Customers> customerTable;
    @FXML public TableColumn<Customers, String> customerTableNameColumn;
    @FXML public TableColumn<Customers, String> customerTableAddressColumn;
    @FXML public TableColumn<Customers, Integer> customerTableFirstLevelDivisionColumn;
    @FXML public TableColumn<Customers, String> customerTablePostalCodeColumn;
    @FXML public TableColumn<Customers, String> customerTablePhoneColumn;


    public void initialize() throws SQLException {
        customerTablePhoneColumn.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
        customerTableFirstLevelDivisionColumn.setCellValueFactory(new PropertyValueFactory<>("DivisionID"));
        customerTableIDColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        customerTableAddressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        customerTableNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        customerTablePostalCodeColumn.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));

        ObservableList<Country> allCountries = DBCountries.getAllCountries();
        ObservableList<String> countryNames = FXCollections.observableArrayList();
        for (Country country : allCountries) {
            countryNames.add(country.getCountryName());
        }
    }


    // radio buttons for scene changes from customers
    public void radioButtonReports(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../FXML/Reports.fxml")));
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(new Scene(root, 1100, 500));
    }

    public void radioButtonAppointments(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../FXML/Appointments.fxml")));
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

        customerTable.getSelectionModel().clearSelection();
        customerIDField.clear();
        customerIDField.setDisable(true);
        customerNameField.clear();
        customerAddressField.clear();
        customerPostalCodeField.clear();
        customerPhoneNumberField.clear();
        countryComboBox.setValue("");
        firstLevelDivisionComboBox.setValue("");
        addCustomerButton.setDisable(false);
        updateCustomerButton.setDisable(true);
        deleteCustomerButton.setDisable(true);
        clearCustomerButton.setDisable(true);

    }

    public void setUpdateCustomerButton() throws SQLException {
        int idToUpdate = Integer.parseInt(customerIDField.getText());
        String nameToUpdate = customerNameField.getText();

    }
}
