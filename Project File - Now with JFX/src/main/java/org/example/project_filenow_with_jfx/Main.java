package org.example.project_filenow_with_jfx;//import

// Moved summary of ideas to README

import org.example.project_filenow_with_jfx.Game;

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

        game.setAtoms(
                new Atom(1, 1, false),
                new Atom(4, 4, false),
                new Atom(2, 4, false),
                new Atom(1, 4, false));



        // Generate random atoms for game

    }
}

