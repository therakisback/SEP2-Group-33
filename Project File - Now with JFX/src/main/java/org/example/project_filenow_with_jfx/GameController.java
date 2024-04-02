package org.example.project_filenow_with_jfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;

public class GameController {
    //The Polygons and rectangles represent the hexagons and sides on the board
    // I've put them into arrays to allow for easier manipulation
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

    public Polygon[] array_of_hexagons = {zeroZero, zeroOne, zeroTwo, zeroThree, zeroFour,
            oneZero, oneOne, oneTwo, oneThree, oneFour, oneFive,
            twoZero, twoOne, twoTwo, twoThree, twoFour, twoFive, twoSix,
            threeZero, threeOne, threeTwo, threeThree, threeFour, threeFive, threeSix, threeSeven,
            fourZero, fourOne, fourTwo, fourThree, fourFour, fourFive, fourSix, fourSeven, fourEight,
            fiveZero, fiveOne, fiveTwo, fiveThree, fiveFour, fiveFive, fiveSix, fiveSeven,
            sixZero, sixOne, sixTwo, sixThree, sixFour, sixFive, sixSix,
            sevenZero, sevenOne, sevenTwo, sevenThree, sevenFour, sevenFive,
            eightZero, eightOne, eightTwo, eightThree, eightFour};

    @FXML
    public Rectangle zero, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen,
            fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty, twentyOne, twentyTwo, twentyThree,
            twentyFour, twentyFive, twentySix, twentySeven, twentyEight, twentyNine, thirty, thirtyOne, thirtyTwo,
            thirtyThree, thirtyFour, thirtyFive, thirtySix, thirtySeven, thirtyEight, thirtyNine, forty, fortyOne,
            fortyTwo, fortyThree, fortyFour, fortyFive, fortySix, fortySeven, fortyEight, fortyNine, fifty, fiftyOne,
            fiftyTwo, fiftyThree;

    public Rectangle[] array_of_sides = {zero, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen,
            fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty, twentyOne, twentyTwo, twentyThree,
            twentyFour, twentyFive, twentySix, twentySeven, twentyEight, twentyNine, thirty, thirtyOne, thirtyTwo,
            thirtyThree, thirtyFour, thirtyFive, thirtySix, thirtySeven, thirtyEight, thirtyNine, forty, fortyOne,
            fortyTwo, fortyThree, fortyFour, fortyFive, fortySix, fortySeven, fortyEight, fortyNine, fifty, fiftyOne,
            fiftyTwo, fiftyThree};

    public int flag = 0;
    @FXML
    private Button endGameButton;
    public Game game = new Game();
    @FXML
    private TextField inputField;

    @FXML
    private Button castRayButton;
    @FXML
    private void castRay() {
        // Get user input from the TextField
        String userInput = inputField.getText();

        // Convert the user input to an integer
        int methodNumber;
        try {
            methodNumber = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return;
        }

        // Determine where to cast ray from based on the user input
        if(methodNumber >= 0 && methodNumber <= 53){
            System.out.println("ray cast from " + methodNumber);
            switch(methodNumber){
                case 0:
                    zero.setOpacity(1);
                    zero.setFill(Color.RED);
                    twentySeven.setOpacity(1);
                    twentySeven.setFill(Color.RED);
                    break;
                default:
                    break;
            }
            //TODO
        }
        else {
            System.out.println("Invalid method number. Please enter a valid method number.");
        }

    }

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
    @FXML
    public void endGame(ActionEvent e) {//when four flags are placed, button appears to end the Game

        System.out.println("Game Over");
        //switch to new scene
    }

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
    private void placeAtom(MouseEvent e) {//allows you to place up to 4 flags
        Atom a = new Atom(3,3 ,true);
        Polygon source = (Polygon) e.getSource();
        if(source.getFill() == Color.YELLOW) {
            source.setFill(Color.DODGERBLUE);
            System.out.println("Removed atom flag");
            flag--;
            endGameButton.setOpacity(0);
        }
        else{
            if(flag < 3){
                source.setFill(Color.YELLOW);
                System.out.println("Placed atom flag");
                flag++;
            }
            else if(flag < 4){
                source.setFill(Color.YELLOW);
                System.out.println("Placed atom flag");
                flag++;
                endGameButton.setOpacity(1);
            }
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
}