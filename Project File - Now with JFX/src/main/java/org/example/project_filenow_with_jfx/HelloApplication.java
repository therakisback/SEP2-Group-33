package org.example.project_filenow_with_jfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game-board.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);

        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            logout(stage);
        });
    }
    public void logout(Stage stage){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to exit!");
        alert.setContentText("Are you sure you want to stop playing this super fun game???");

        if(alert.showAndWait().get() == ButtonType.OK){

            stage.close();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}