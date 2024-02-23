package com.example.funfx;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Hexagon {

    public int getHex_identifier() {
        return hex_identifier;
    }

    public void setHex_identifier(int hex_identifier) {
        this.hex_identifier = hex_identifier;
    }

    int hex_identifier;
    public static Polygon createHexagon(double size, double x_co, double y_co) {
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
}


