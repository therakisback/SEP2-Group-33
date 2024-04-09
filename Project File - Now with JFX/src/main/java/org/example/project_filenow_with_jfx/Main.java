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
    Game g = new Game();
    char user = 'a';
    int score = 26;
    for (int i = 0; i < 26; i++) {
        g.writeToLeaderboard(Character.toString(user), score);
        user++;
        score--;
    }

        System.out.println(g.getLeaderboard().size());



        // Generate random atoms for game

    }
}

