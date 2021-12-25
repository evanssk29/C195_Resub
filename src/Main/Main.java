package Main;

import Utilities.ConnectionDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass()).getResource("../ViewController/MainLogIn.fxml"));
        primaryStage.setTitle("C195");
        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.show();
    }

    public static void main(String[] args) {
        ConnectionDB.startConnection();
        launch(args);
        ConnectionDB.closeConnection();
    }
}
