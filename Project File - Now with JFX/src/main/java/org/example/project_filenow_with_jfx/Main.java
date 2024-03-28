package org.example.project_filenow_with_jfx;//import

// Moved summary of ideas to README

import org.example.project_filenow_with_jfx.Game;

import java.util.ArrayList;
import java.util.Random;

/**
 * "Controller" class for the game, manages the functionality
 *    between the Game class running the game and the UI class
 *    dealing with user IO
 * <p>
 * A framework for this class and function is difficult,
 *    as it will rely on every other class
 */

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        game.setAtoms();
        Ray r = new Ray(8,4,1,27);
        game.calculateRay(r);
        ArrayList<int[]> arr = r.getPath();
        for (int[] a : arr) {
            System.out.println("Row: " + a[0] + " \tCol: " + a[1] + " \tEnd Dir: " + a[2] + " \tStart Dir: " + a[3]);
        }



        // Generate random atoms for game

    }
}

