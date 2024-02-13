import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class to manage file IO with respect to the scoreboard and past scores
 * <p>
 *    Needs to have a hardcoded file location so other scoreboard objects
 *    can access the file as well.
 */
public class Scoreboard {

    // Class objects        ----------
    private final String filePath = "src/Scoreboard.csv";       // file path for the scoreboard - will never change
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

    public String[] getFullSB() {
        // TODO
        return new String[10];
    }
}
