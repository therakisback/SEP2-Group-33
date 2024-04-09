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

import java.util.ArrayList;
import java.util.HashMap;

public class GameController {
    //The Polygons and rectangles represent the hexagons and sides on the board
    // I've put them into arrays to allow for easier manipulation
    @FXML
    public Polygon zeroZero = new Polygon(), zeroOne, zeroTwo, zeroThree, zeroFour,
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
    public Rectangle zero = new Rectangle(), one = new Rectangle(),         two = new Rectangle(),          three = new Rectangle(),
            four = new Rectangle(),         five = new Rectangle(),         six = new Rectangle(),          seven = new Rectangle(),
            eight = new Rectangle(),        nine = new Rectangle(),         ten = new Rectangle(),          eleven = new Rectangle(),
            twelve = new Rectangle(),       thirteen = new Rectangle(),     fourteen = new Rectangle(),     fifteen = new Rectangle(),
            sixteen = new Rectangle(),      seventeen = new Rectangle(),    eighteen = new Rectangle(),     nineteen = new Rectangle(),
            twenty = new Rectangle(),       twentyOne = new Rectangle(),    twentyTwo = new Rectangle(),    twentyThree = new Rectangle(),
            twentyFour = new Rectangle(),   twentyFive = new Rectangle(),   twentySix = new Rectangle(),    twentySeven = new Rectangle(),
            twentyEight = new Rectangle(),  twentyNine = new Rectangle(),   thirty = new Rectangle(),       thirtyOne = new Rectangle(),
            thirtyTwo = new Rectangle(),    thirtyThree = new Rectangle(),  thirtyFour = new Rectangle(),   thirtyFive = new Rectangle(),
            thirtySix = new Rectangle(),    thirtySeven = new Rectangle(),  thirtyEight = new Rectangle(),  thirtyNine = new Rectangle(),
            forty = new Rectangle(),        fortyOne = new Rectangle(),     fortyTwo = new Rectangle(),     fortyThree = new Rectangle(),
            fortyFour = new Rectangle(),    fortyFive = new Rectangle(),    fortySix = new Rectangle(),     fortySeven = new Rectangle(),
            fortyEight = new Rectangle(),   fortyNine = new Rectangle(),    fifty = new Rectangle(),        fiftyOne = new Rectangle(),
            fiftyTwo = new Rectangle(),     fiftyThree = new Rectangle();




    public Rectangle[] array_of_sides = {zero, one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen,
            fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty, twentyOne, twentyTwo, twentyThree,
            twentyFour, twentyFive, twentySix, twentySeven, twentyEight, twentyNine, thirty, thirtyOne, thirtyTwo,
            thirtyThree, thirtyFour, thirtyFive, thirtySix, thirtySeven, thirtyEight, thirtyNine, forty, fortyOne,
            fortyTwo, fortyThree, fortyFour, fortyFive, fortySix, fortySeven, fortyEight, fortyNine, fifty, fiftyOne,
            fiftyTwo, fiftyThree};

    @FXML
    public void dataAssignemnt() {zero.setUserData(zeroZero); one.setUserData(zeroZero); two.setUserData(oneZero); three.setUserData(oneZero);
        four.setUserData(twoZero); five.setUserData(twoZero); six.setUserData(threeZero); seven.setUserData(threeZero); eight.setUserData(fourZero);
        nine.setUserData(fourZero); ten.setUserData(fourZero); eleven.setUserData(fiveZero); twelve.setUserData(fiveZero); thirteen.setUserData(sixZero);
        fourteen.setUserData(sixZero); fifteen.setUserData(sevenZero); sixteen.setUserData(sevenZero); seventeen.setUserData(eightZero); eighteen.setUserData(eightZero);
        nineteen.setUserData(eightZero); twenty.setUserData(eightOne); twentyOne.setUserData(eightOne); twentyTwo.setUserData(eightTwo); twentyThree.setUserData(eightTwo);
        twentyFour.setUserData(eightThree); twentyFive.setUserData(eightThree); twentySix.setUserData(eightFour); twentySeven.setUserData(eightFour);
        twentyEight.setUserData(eightFour); twentyNine.setUserData(sevenFive); thirty.setUserData(sevenFive); thirtyOne.setUserData(sixSix); thirtyTwo.setUserData(sixSix);
        thirtyThree.setUserData(fiveSeven); thirtyFour.setUserData(fiveSeven); thirtyFive.setUserData(fourEight); thirtySix.setUserData(fourEight);
        thirtySeven.setUserData(fourEight);thirtyEight.setUserData(threeSeven); thirtyNine.setUserData(threeSeven); forty.setUserData(twoSix); fortyOne.setUserData(twoSix);
        fortyTwo.setUserData(oneFive); fortyThree.setUserData(oneFive); fortyFour.setUserData(zeroFour); fortyFive.setUserData(zeroFour); fortySix.setUserData(zeroFour);
        fortySeven.setUserData(zeroThree); fortyEight.setUserData(zeroThree); fortyNine.setUserData(zeroTwo); fifty.setUserData(zeroTwo); fiftyOne.setUserData(zeroOne);
        fiftyTwo.setUserData(zeroOne); fiftyThree.setUserData(zeroZero);};



    public int flag = 0;
    @FXML
    private Button endGameButton;
    private final Game game = new Game();
    private Color col = new Color(0,0,0,0);
    private ArrayList<Atom> atoms = new ArrayList<Atom>();
    @FXML
    private TextField inputField;

    @FXML
    private Button castRayButton;
    @FXML
    private void castRay() {
        // Get user input from the TextField
        String userInput = inputField.getText();
        dataAssignemnt();

        // Convert the user input to an integer
        int raySource;
        try {
            raySource = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return;
        }

        // Determine where to cast ray from based on the user input
        if(raySource >= 0 && raySource <= 53){
            System.out.println("ray cast from " + raySource);
            Rectangle side = array_of_sides[raySource];
            int dir;

            // Direction - this is fun
                 if (raySource >= 19 && raySource <= 35 && raySource % 2 == 1) dir = 1;
            else if (raySource >= 10 && raySource <= 26 && raySource % 2 == 0) dir = 2;
            else if (raySource <= 17 && raySource % 2 == 1) dir = 3;
            else if (raySource >= 46 || raySource <= 8) dir = 4;
            else if (raySource >= 37 && raySource % 2 == 1) dir = 5;
            else dir = 6;

            // Row and Column
            int[] ray_place;
            Polygon source = (Polygon) side.getUserData();
            String string = source.getId();
            String[] parts = string.split("(?=[A-Z])");

            ray_place = convertToNumbers(parts);

            // Ray calculation
            Ray r = new Ray(ray_place[0], ray_place[1], dir, raySource);
            game.calculateRay(r);
            int rayRes = r.getResult();
            Rectangle endSide = array_of_sides[rayRes];

            side.setOpacity(1);
            side.setFill(col);
            endSide.setOpacity(1);
            endSide.setFill(col);
            //col = Ema's method
        }
        else {
            System.out.println("Invalid method number. Please enter a valid method number.");
        }

    }
    @FXML
    public void endGame(ActionEvent e) {//when four flags are placed, button appears to end the Game
        int score = game.submitGame(atoms.toArray(new Atom[4]));
        System.out.println("Game Over, your score was: " + score);
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
        int[] atom_place;
        Polygon source = (Polygon) e.getSource();
        String string = source.getId();
        String[] parts = string.split("(?=[A-Z])");

        atom_place = convertToNumbers(parts);
        Atom atom = new Atom(atom_place[1], atom_place[0], false);

        if(source.getFill() == Color.YELLOW) {
            source.setFill(Color.DODGERBLUE);
            System.out.println("Removed atom flag");
            atoms.remove(atom);
            flag--;
            endGameButton.setOpacity(0);
        }
        else{
            if(flag < 3){
                source.setFill(Color.YELLOW);
                System.out.println("Placed atom flag");
                atoms.add(atom);
                flag++;
            }
            else if(flag < 4){
                source.setFill(Color.YELLOW);
                System.out.println("Placed atom flag");
                atoms.add(atom);
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