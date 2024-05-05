package org.example.project_filenow_with_jfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Display_Board extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game-board.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Black Box");
        stage.setScene(scene);

        stage.show();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Welcome to BlackBox");
        alert.setHeaderText("Find the Atoms by casting rays");
        alert.setContentText("Cast rays by entering the number you want to cast from (0 - 53). ");

        if(alert.showAndWait().get() == ButtonType.OK){
            System.out.println("Great Success");
            stage.close();
        }
    }

    public void logout(Stage stage){//logout function to exit the game

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to exit!");
        alert.setContentText("Are you sure you want to stop playing this super fun game???");

        if(alert.showAndWait().get() == ButtonType.OK){
            System.out.println("Great Success");
            stage.close();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}


