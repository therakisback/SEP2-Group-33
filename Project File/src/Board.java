package com.example.funfx;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;

import javafx.scene.paint.Color;

import javafx.scene.shape.Polygon;

import javafx.scene.layout.Pane;


public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a pane to hold the hexagon
        Pane pane = new Pane();

        //
        double size = 30;
        int cols = 5;
        int rows = 5;
        int line = 0;

        for (int i = 0; i < cols; i++) {

            for (int j = 0; j < rows; j++) {

                double xPosition = (2 * size * j + size * i);
                double yPosition =  size * i * 1.6;

                Polygon hexagon = createHexagon(size, xPosition, yPosition);

                pane.getChildren().add(hexagon);

            }
            line++;
        }


        // Create a scene and set it on the stage

        Scene scene = new Scene(pane, 1000, 800);
        primaryStage.setScene(scene);

        // Set the stage title and show it
        primaryStage.setTitle(" Hexagon Example");
        primaryStage.show();
    }

    private Polygon createHexagon(double size, double x_co, double y_co) { //create hexagon now takes x and y as imput for each new tile (no need for an offset)
        Polygon hexagon = new Polygon();

        // Calculate the coordinates of the hexagon vertices
        for (int i = 0; i < 6; i++) {
            double angle = 2.0 * Math.PI / 6 * i + .51;
            double x = x_co + 500 + size * Math.cos(angle);
            double y = y_co + 200 + size * Math.sin(angle);
            hexagon.getPoints().addAll(x, y);
        }

        hexagon.setFill(Color.GRAY); // Set the fill color

        return hexagon;
    }

    public static void main(String[] args) {
        launch(args);
    }
}