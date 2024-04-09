package org.example.project_filenow_with_jfx;

import java.io.File;

/**
 * Class to manage file IO with respect to the scoreboard and past scores
 * <p>
 *    Needs to have a hardcoded file location so other scoreboard objects
 *    can access the file as well.
 */
public class Scoreboard {

    // Class objects        ----------
    private final String filePath = "src/Scoreboard.txt";       // file path for the scoreboard - will never change
    File sbf;                                                   // File object for (s)core(b)oard (f)ile


    /**
     * Constructor for scoreboard object.
     *    Initializes the file object
     */
    public Scoreboard() {
        // TODO? - I don't know if more is necessary here
        sbf = new File(filePath);
    }

    // Class methods        ----------

    /**
     * Adds player's game to scoreboard file
     * @param score Given score of player
     * @param name  Name / Nickname for player
     */
    public void addToScoreBoard(int score, String name) {
        // TODO
        // Must also sort scoreboard file, which should be fun :)
    }

    /**
     * Gets the ten best scores from the scoreboard file and converts them
     *    to a string array for easy reading / printing.
     *    <p>
     *    String output : "#: Name: Score"
     * @return String array of top scores
     */
    public String[] getTopTen() {
        // TODO
        return new String[10];
    }

    /**
     * Gets every score from the scoreboard file and converts them
     *    to a string array for easy reading / printing
     *    <p>
     *    String output : "#: Name: Score"
     * @return String array of all scores
     */
    public String[] getFullSB() {
        // TODO
        return new String[10];
    }

    /**
     * Cuts the number of scores on the scoreboard to the top # of scores
     * @param count amount of scores to keep,
     *           <p>Ex: 100 means top 100 scores are kept, rest are deleted.
     */
    public void pruneScores(int count) {
        // TODO
    }

    /**
     * Private function for sorting the file of the scoreboard by top score.
     * <p>Just going to help keep repetition to a minimum.
     */
    private void sortSB() {
        // TODO
    }
}
