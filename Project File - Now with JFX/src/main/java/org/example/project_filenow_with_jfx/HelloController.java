package org.example.project_filenow_with_jfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    public Polygon zeroZero, zeroOne, zeroTwo, zeroThree, zeroFour,
    oneZero, oneOne, oneTwo, oneThree, oneFour, oneFive,
    twoZero, twoOne, twoTwo, twoThree, twoFour, twoFive, twoSix;



    private double x,y;
    @FXML
    private void up(MouseEvent e) {
        System.out.println("UP");
    }
    @FXML
    private void placeAtom(MouseEvent e) {
        System.out.println("Dropped the A bomb");
        Polygon source = (Polygon) e.getSource();
        source.setFill(Color.YELLOW);
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