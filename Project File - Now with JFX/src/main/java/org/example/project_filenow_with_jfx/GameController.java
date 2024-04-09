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

    @FXML
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

    @FXML
    public Rectangle[] array_of_sides = new Rectangle[54];

    @FXML
    public void dataAssignment() {array_of_sides[0] = zero; array_of_sides[0].setUserData(zeroZero); array_of_sides[1] = one; array_of_sides[1].setUserData(zeroZero);
        array_of_sides[2] = two; array_of_sides[2].setUserData(oneZero); array_of_sides[3] = three; array_of_sides[3].setUserData(oneZero);
        array_of_sides[4] = four; array_of_sides[4].setUserData(twoZero); array_of_sides[5] = five; array_of_sides[5].setUserData(twoZero);
        array_of_sides[6] = six; array_of_sides[6].setUserData(threeZero); array_of_sides[7] = seven; array_of_sides[7].setUserData(threeZero);
        array_of_sides[8] = eight; array_of_sides[8].setUserData(fourZero); array_of_sides[9] = nine; array_of_sides[9].setUserData(fourZero); array_of_sides[10] = ten; array_of_sides[10].setUserData(fourZero);
        array_of_sides[11] = eleven; array_of_sides[11].setUserData(fiveZero); array_of_sides[12] = twelve; array_of_sides[12].setUserData(fiveZero);
        array_of_sides[13] = thirteen; array_of_sides[13].setUserData(sixZero); array_of_sides[14] = fourteen; array_of_sides[14].setUserData(sixZero);
        array_of_sides[15] = fifteen; array_of_sides[15].setUserData(sevenZero); array_of_sides[16] = sixteen; array_of_sides[16].setUserData(sevenZero);
        array_of_sides[17] = seventeen; array_of_sides[17].setUserData(eightZero); array_of_sides[18] = eighteen; array_of_sides[18].setUserData(eightZero); array_of_sides[19] = nineteen; array_of_sides[19].setUserData(eightZero);
        array_of_sides[20] = twenty; array_of_sides[20].setUserData(eightOne); array_of_sides[21] = twentyOne; array_of_sides[21].setUserData(eightOne);
        array_of_sides[22] = twentyTwo; array_of_sides[22].setUserData(eightTwo); array_of_sides[23] = twentyThree; array_of_sides[23].setUserData(eightTwo);
        array_of_sides[24] = twentyFour; array_of_sides[24].setUserData(eightThree); array_of_sides[25] = twentyFive; array_of_sides[25].setUserData(eightThree);
        array_of_sides[26] = twentySix; array_of_sides[26].setUserData(eightFour); array_of_sides[27] = twentySeven; array_of_sides[27].setUserData(eightFour); array_of_sides[28] = twentyEight; array_of_sides[28].setUserData(eightFour);
        array_of_sides[29] = twentyNine; array_of_sides[29].setUserData(sevenFive); array_of_sides[30] = thirty; array_of_sides[30].setUserData(sevenFive);
        array_of_sides[31] = thirtyOne; array_of_sides[31].setUserData(sixSix); array_of_sides[32] = thirtyTwo; array_of_sides[32].setUserData(sixSix);
        array_of_sides[33] = thirtyThree; array_of_sides[33].setUserData(fiveSeven); array_of_sides[34] = thirtyFour; array_of_sides[34].setUserData(fiveSeven);
        array_of_sides[35] = thirtyFive; array_of_sides[35].setUserData(fourEight); array_of_sides[36] = thirtySix; array_of_sides[36].setUserData(fourEight); array_of_sides[37] = thirtySeven; array_of_sides[37].setUserData(fourEight);
        array_of_sides[38] = thirtyEight; array_of_sides[38].setUserData(threeSeven); array_of_sides[39] = thirtyNine; array_of_sides[39].setUserData(threeSeven);
        array_of_sides[40] = forty; array_of_sides[40].setUserData(twoSix); array_of_sides[41] = fortyOne; array_of_sides[41].setUserData(twoSix);
        array_of_sides[42] = fortyTwo; array_of_sides[42].setUserData(oneFive); array_of_sides[43] = fortyThree; array_of_sides[43].setUserData(oneFive);
        array_of_sides[44] = fortyFour; array_of_sides[44].setUserData(zeroFour); array_of_sides[45] = fortyFive; array_of_sides[45].setUserData(zeroFour); array_of_sides[46] = fortySix; array_of_sides[46].setUserData(zeroFour);
        array_of_sides[47] = fortySeven; array_of_sides[47].setUserData(zeroThree); array_of_sides[48] = fortyEight; array_of_sides[48].setUserData(zeroThree);
        array_of_sides[49] = fortyNine; array_of_sides[49].setUserData(zeroTwo); array_of_sides[50] = fifty; array_of_sides[50].setUserData(zeroTwo);
        array_of_sides[51] = fiftyOne; array_of_sides[51].setUserData(zeroOne); array_of_sides[52] = fiftyTwo; array_of_sides[52].setUserData(zeroOne);
        array_of_sides[53] = fiftyThree; array_of_sides[53].setUserData(zeroZero);};



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
            dataAssignment();
            Rectangle side = array_of_sides[raySource]; //side
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
            System.out.println(r);
            game.calculateRay(r);
            int rayRes = r.getResult();
            Rectangle endSide = array_of_sides[rayRes];

            side.setOpacity(1);
            side.setFill(col);
            endSide.setOpacity(1);
            endSide.setFill(col);
            col = makeColour(col);

            //col = Ema's method

        }
        else {
            System.out.println("Invalid method number. Please enter a valid method number.");
        }

    }

    // hit = dark green (0, 51, 0, 1)
    // return = dark blue (0, 0, 102, 1)
    // 18 colours including the initial one
    private Color makeColour (Color col){
        if (col.getRed() < 1.0){
            return new Color(col.getRed() + 0.25, col.getGreen(), col.getBlue(), 1.0 );
        }
        else if (col.getGreen() < 1.0){
            return new Color(col.getRed(), col.getGreen() + 0.25, col.getBlue(), 1.0 );
        }
        else if (col.getBlue() < 1.0){
            return new Color(col.getRed(), 0.25, col.getBlue() + 0.25, 1.0 );
        }
        else if (col.getBlue() == 1.0){
            return new Color(0, col.getGreen() + 0.25, 1.0, 1.0);
        }
        // final color - light grey
        return new Color(0.37,0.37,0.37,1.0);
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