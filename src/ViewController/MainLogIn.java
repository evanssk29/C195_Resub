package ViewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;


public class MainLogIn {
    @FXML public Button enterLogInFormButton;
    @FXML public Label logInFormTitle;
    @FXML public Label userLogInLocationLabel;
    @FXML public PasswordField logInUserPasswordField;
    @FXML public TextField logInUserIDTextField;
    boolean logInSuccessful = false;
    String logInErrorText ="User ID or Password Incorrect!";
    String logInTitleError ="Log In Unsuccessful!";


    public void validateLogIn(ActionEvent event) throws Exception, SQLException {
        String userID = logInUserIDTextField.getText();
        String userPassword = logInUserPasswordField.getText();
        if (userID.equals("test") && userPassword.equals("test")) {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../ViewController/Customers.fxml")));
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(new Scene(root, 1100, 500));
            Customers login = new Customers();
        }
        else {
            JOptionPane.showMessageDialog(null,
                    logInErrorText,
                    logInTitleError,
                    JOptionPane.ERROR_MESSAGE);
            logInSuccessful = false;
        }
        logUserActivity();
    }
    /** records activity of users and logs in text file */
    public void logUserActivity() throws IOException {

    }
}
