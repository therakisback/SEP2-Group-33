package org.example.project_filenow_with_jfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;

public class HelloController {
    @FXML
    private Circle myCircle;
    Hexagon a = new Hexagon();

    private double x,y;
    public void up(ActionEvent e) {
        System.out.println("UP");
        myCircle.setCenterY(y -=5);
    }
    public void down(ActionEvent e) {
        System.out.println("DOWN");
        myCircle.setCenterY(y +=5);
    }
    public void left(ActionEvent e) {
        System.out.println("LEFT");
        myCircle.setCenterX(x -=5);
    }
    public void right(ActionEvent e) {
        System.out.println("RIGHT");
        myCircle.setCenterX(x +=5);
    }
    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane scenePane;

    Stage stage;
    @FXML
    public void logout(ActionEvent event){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to exit!");
        alert.setContentText("Are you sure you want to stop playing this super fun game???");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Great Success");
            stage.close();
        }

    }
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}