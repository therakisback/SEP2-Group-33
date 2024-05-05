package org.example.project_filenow_with_jfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.QuadCurve;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class EndGameController {
    public EndGameController(){

    }
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

    /** Array of Hexagons used in grid */
    @FXML
    public Polygon[][] array_of_hexagons = new Polygon[9][9];

    /** Rectangles used to represent sides / ray casting - name indicates side number to match */
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

    /** Array of rectangles to hold all side shapes */
    @FXML
    public Rectangle[] array_of_sides = new Rectangle[54];

    /** Function to assign arrays of rectangles and hexagons, also assigns connections to each as needed */
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
        array_of_sides[53] = fiftyThree; array_of_sides[53].setUserData(zeroZero);
        array_of_hexagons[0][0] = zeroZero; array_of_hexagons[0][1] = zeroOne;array_of_hexagons[0][2] = zeroTwo;array_of_hexagons[0][3] = zeroThree;array_of_hexagons[0][4] = zeroFour;
        array_of_hexagons[1][0] = oneZero; array_of_hexagons[1][1] = oneOne;array_of_hexagons[1][2] = oneTwo;array_of_hexagons[1][3] = oneThree;array_of_hexagons[1][4] = oneFour;array_of_hexagons[1][5] = oneFive;
        array_of_hexagons[2][0] = twoZero; array_of_hexagons[2][1] = twoOne;array_of_hexagons[2][2] = twoTwo;array_of_hexagons[2][3] = twoThree;array_of_hexagons[2][4] = twoFour;array_of_hexagons[2][5] = twoFive;array_of_hexagons[2][6] = twoSix;
        array_of_hexagons[3][0] = threeZero; array_of_hexagons[3][1] = threeOne;array_of_hexagons[3][2] = threeTwo;array_of_hexagons[3][3] = threeThree;array_of_hexagons[3][4] = threeFour;array_of_hexagons[3][5] = threeFive;array_of_hexagons[3][6] = threeSix;array_of_hexagons[3][7] = threeSeven;
        array_of_hexagons[4][0] = fourZero; array_of_hexagons[4][1] = fourOne;array_of_hexagons[4][2] = fourTwo;array_of_hexagons[4][3] = fourThree;array_of_hexagons[4][4] = fourFour;array_of_hexagons[4][5] = fourFive;array_of_hexagons[4][6] = fourSix;array_of_hexagons[4][7] = fourSeven;array_of_hexagons[4][8] = fourEight;
        array_of_hexagons[5][0] = fiveZero; array_of_hexagons[5][1] = fiveOne;array_of_hexagons[5][2] = fiveTwo;array_of_hexagons[5][3] = fiveThree;array_of_hexagons[5][4] = fiveFour;array_of_hexagons[5][5] = fiveFive;array_of_hexagons[5][6] = fiveSix;array_of_hexagons[5][7] = fiveSeven;
        array_of_hexagons[6][0] = sixZero; array_of_hexagons[6][1] = sixOne;array_of_hexagons[6][2] = sixTwo;array_of_hexagons[6][3] = sixThree;array_of_hexagons[6][4] = sixFour;array_of_hexagons[6][5] = sixFive;array_of_hexagons[6][6] = sixSix;
        array_of_hexagons[7][0] = sevenZero; array_of_hexagons[7][1] = sevenOne;array_of_hexagons[7][2] = sevenTwo;array_of_hexagons[7][3] = sevenThree;array_of_hexagons[7][4] = sevenFour;array_of_hexagons[7][5] = sevenFive;
        array_of_hexagons[8][0] = eightZero; array_of_hexagons[8][1] = eightOne;array_of_hexagons[8][2] = eightTwo;array_of_hexagons[8][3] = eightThree;array_of_hexagons[8][4] = eightFour;
    }
    @FXML
    public AnchorPane endScenePane;
    protected Game game;
    int score;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public ArrayList<Atom> atomFlags = new ArrayList<>();
    public Atom[] realAtoms = new Atom[4];
    @FXML
    public Line rayOne;

    @FXML
    private TextField scoreField, usernameField;
    @FXML
    private Button usernameButton;


    public void receiveAtoms(ArrayList<Atom> atoms) {
        dataAssignment();
        for (Atom a : atoms) {
            atomFlags.add(a);
        }
        for(Atom a : atomFlags) {
            array_of_hexagons[a.getRow()][a.getCol()].setFill(Color.YELLOW);
        }
    }
    public void receiveRealAtoms(Atom[] atoms) {
        dataAssignment();
        for (int i = 0; i < atoms.length; i++) {
            realAtoms[i] = atoms[i];
        }
        for(Atom a : realAtoms) {
            array_of_hexagons[a.getRow()][a.getCol()].setFill(Color.GREEN);
        }
    }
    public void receiveScore(int score) {
        scoreField.setText("Your score was: " + score);
        this.score = score;
    }

    public void getUsername(ActionEvent e) {
        String username = usernameField.getText();
        game.writeToLeaderboard(username, score);
    }
    public void showRay(Ray ray){
        int originX = 76;
        int originY = 57;
        int exampleX = 284;
        int exampleY = 403;


        //int[] rayStart = ray.getPath().getFirst();
        //int[] rayEnd = ray.getPath().getLast();
        Line line1 = new Line(originX, originY, exampleX, exampleY);
        line1.setStroke(Color.BLACK);
        line1.setStrokeWidth(5);

        endScenePane.getChildren().addAll(line1);

        /*
        double startX = 100;
        double startY = 100;
        double midX = 200;
        double midY = 50;
        double endX = 300;
        double endY = 100;

        Line line1 = new Line(startX, startY, midX, midY);
        line1.setStroke(Color.BLACK);
        line1.setStrokeWidth(5);

        Line line2 = new Line(midX, midY, endX, endY);
        line2.setStroke(Color.BLACK);
        line2.setStrokeWidth(5);

        // Add lines and curve to the pane
        endScenePane.getChildren().addAll(line1, line2);
         */
    }




    @FXML
    public void logout(ActionEvent event){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You are about to exit!");
        alert.setContentText("Are you sure you want to stop playing this super fun game???");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) endScenePane.getScene().getWindow();
            System.out.println("Thanks for playing");
            stage.close();
        }

    }

}
