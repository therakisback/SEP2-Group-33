package org.example.project_filenow_with_jfx;

import org.example.project_filenow_with_jfx.Atom;
import java.util.Random;

/**
 * "Game Manger" class for dealing with the primary functions
 *    and memory keeping of the game
 * <p>
 * Should be written with the idea that it is going to be
 *    and object in the main class kept in mind.
 */
public class Game {

    // Class variables      ----------

    // TODO
    // Board array / arraylist / linked list // tree?
    Atom[] trueAtoms;
    int score;

    /**
     * Constructor for game class, should only be used once in controller class.
     */
    public Game() {
    }

    // Class functions      ----------

    /**
     * Calculates the path and result of given ray
     * @param r Ray object to be used.
     */
    public void calculateRay(Ray r) {


        while(true) {

        }
    }

    /**
     * Takes input for set atom locations
     * @param args Atoms to be included in array
     */
    public void setAtoms(Atom... args) {
        trueAtoms = new Atom[args.length];
        int i = 0;
        for (Atom a : args) {
            if(a.isFlag()) throw new IllegalArgumentException("True atoms cannot have flag marking.");
            trueAtoms[i++] = a;
        }
    }

    /**
     * Randomly generates 4 atoms for game.
     */
    public void setAtoms() {
        // TODO - Ema
        // trueAtoms[i] = random atom
    }


    /**
     * Checks given atom flags with true atoms,
     *    calculates score, and ends the game
     * @param atomFlags Array of flags to be checked with true atoms
     */
    public void submitGame(Atom[] atomFlags) {

    }

}
