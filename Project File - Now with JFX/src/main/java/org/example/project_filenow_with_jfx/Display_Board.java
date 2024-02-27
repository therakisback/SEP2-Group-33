package org.example.project_filenow_with_jfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Display_Board extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a pane to hold the hexagon
        Pane pane = new Pane();
        double size = 55;

        for(int i = 0; i < 5; i++){
            Hexagon a = new Hexagon();
            a.setHex_identifier(i);
            Polygon hexagon = Hexagon.createHexagon(size, 100, -100);
            hexagon.setTranslateX(i * 1.8 * size);
            pane.getChildren().add(hexagon);
        }
        for(int i = 0; i < 6; i++){
            Hexagon a = new Hexagon();
            a.setHex_identifier(i + 5);
            Polygon hexagon = Hexagon.createHexagon(size, 0.9 * -size +100, size * 1.5 -100);
            hexagon.setTranslateX(i * 1.8 * size);
            pane.getChildren().add(hexagon);
        }
        for(int i = 0; i < 7; i++){
            Hexagon a = new Hexagon();
            a.setHex_identifier(i + 11);
            Polygon hexagon = Hexagon.createHexagon(size, 1.8 * -size +100, size * 3 -100);
            hexagon.setTranslateX(i * 1.8 * size);
            pane.getChildren().add(hexagon);
        }
        for(int i = 0; i < 8; i++){
            Hexagon a = new Hexagon();
            a.setHex_identifier(i + 18);
            Polygon hexagon = Hexagon.createHexagon(size, 2.7 * -size +100, size * 4.5 -100);
            hexagon.setTranslateX(i * 1.8 * size);
            pane.getChildren().add(hexagon);
        }
        for(int i = 0; i < 9; i++){
            Hexagon a = new Hexagon();
            a.setHex_identifier(i + 26);
            Polygon hexagon = Hexagon.createHexagon(size, 3.6 * -size +100, size * 6 -100);
            hexagon.setTranslateX(i * 1.8 * size);
            pane.getChildren().add(hexagon);
        }
        for(int i = 0; i < 8; i++){
            Hexagon a = new Hexagon();
            a.setHex_identifier(i + 35);
            Polygon hexagon = Hexagon.createHexagon(size, 2.7 * -size +100, size * 7.5 -100);
            hexagon.setTranslateX(i * 1.8 * size);
            pane.getChildren().add(hexagon);
        }
        for(int i = 0; i < 7; i++){
            Hexagon a = new Hexagon();
            a.setHex_identifier(i + 43);
            Polygon hexagon = Hexagon.createHexagon(size, 1.8 * -size +100, size * 9 -100);
            hexagon.setTranslateX(i * 1.8 * size);
            pane.getChildren().add(hexagon);
        }
        for(int i = 0; i < 6; i++){
            Hexagon a = new Hexagon();
            a.setHex_identifier(i + 50);
            Polygon hexagon = Hexagon.createHexagon(size, 0.9 * -size +100, size * 10.5 -100);
            hexagon.setTranslateX(i * 1.8 * size);
            pane.getChildren().add(hexagon);
        }
        for(int i = 0; i < 5; i++){
            Hexagon a = new Hexagon();
            a.setHex_identifier(i + 56);
            Polygon hexagon = Hexagon.createHexagon(size, 100, size * 12 -100);
            hexagon.setTranslateX(i * 1.8 * size);
            pane.getChildren().add(hexagon);
        }
        // Create the hexagon made up of smaller hexagons

        int cols = 5;
        int rows = 5;
        int line = 0;




        // Create a scene and set it on the stage
        primaryStage.setFullScreen(true);
        Scene scene = new Scene(pane, 1400, 1000);
        primaryStage.setScene(scene);

        // Set the stage title and show it
        primaryStage.setTitle(" Hexagon Example");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}



