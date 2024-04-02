package org.example.project_filenow_with_jfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;

public class GameController {
    @FXML
    public Polygon zeroZero, zeroOne, zeroTwo, zeroThree, zeroFour,
    oneZero, oneOne, oneTwo, oneThree, oneFour, oneFive,
    twoZero, twoOne, twoTwo, twoThree, twoFour, twoFive, twoSix,
    threeZero, threeOne, threeTwo, threeThree, threeFour, threeFive, threeSix, threeSeven,
    fourZero, fourOne, fourTwo, fourThree, fourFour, fourFive, fourSix, fourSeven, fourEight,
    fiveZero, fiveOne, fiveTwo, fiveThree, fiveFour, fiveFive, fiveSix, fiveSeven,
    sixZero, sixOne, sixTwo, sixThree, sixFour, sixFive, sixSix,
    sevenZero, sevenOne, sevenTwo, sevenThree, sevenFour, sevenFive,
    eightZero, eightOne, eightTwo, eightThree, eightFour;

    public Circle atom;


    private int flag = 0;
    public Game game = new Game();

    @FXML
    private void createAtom(MouseEvent e) {

        int[] atom_place;
        Polygon source = (Polygon) e.getSource();
        String string = source.getId();
        String[] parts = string.split("(?=[A-Z])");

        atom_place = convertToNumbers(parts);
        Atom atom = new Atom(atom_place[1], atom_place[0], false);
        System.out.println("Atom created, " + atom.toString());
    }
    /*@FXML
    private void endGame(MouseEvent e) {
        Circle source = (Circle) e.getSource();
        //source.setOpacity(1);
        //source.setId();
        if(atom.getOpacity() == 0){
            atom.setOpacity(1);
        }

    }*/

    private int[] convertToNumbers(String[] parts) {
        int[] array = new int[2];
        HashMap<String, Integer> numbers= new HashMap<String, Integer>();
        numbers.put("zero", 0);
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);

        for(int i = 0; i < 2; i++){
            array[i] = numbers.getOrDefault(parts[i].toLowerCase(), 0);
        }
        return array;
    }

    @FXML
    private void placeAtom(MouseEvent e) {

        Atom a = new Atom(3,3 ,true);
        Polygon source = (Polygon) e.getSource();
        if(source.getFill() == Color.YELLOW) {
            source.setFill(Color.DODGERBLUE);
            System.out.println("Removed atom flag");
        }
        else{
            source.setFill(Color.YELLOW);
            System.out.println("Placed atom flag");
        }
    }

    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane scenePane;

        Stage stage;
    @FXML
    public void logout(ActionEvent event){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are about to exit!");
        alert.setContentText("Are you sure you want to stop playing this super fun game???");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Thanks for playing");
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