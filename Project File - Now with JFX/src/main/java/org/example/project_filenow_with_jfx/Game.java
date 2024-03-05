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
     * Uses Random to create atom placements on board
     */
    public void setAtoms(int row) {
        if (row < 0 || row > 8) throw new IllegalArgumentException("Row has to be between 0 and 8, inclusive");
        trueAtoms = new Atom[4];
        Random random = new Random();
        int col = 0;
        int n = 2;
        for (int i = 0; i < 4; i++) {
            if (row >= 0 && row < 5) {
                col = random.nextInt(row + 4) + 1;
            } else if (row >= 5 && row < 9) {
                col = random.nextInt(row + n) + 1;
                n = n - 2;
            }
            //I need n to be -2, -4
            trueAtoms[i] = new Atom(row, col);
        }
    }




    /**
     * Checks given atom flags with true atoms,
     *    calculates score, and ends the game
     * @param atomFlags Array of flags to be checked with true atoms
     */
    public void submitGame(Atom[] atomFlags) {

    }

}
