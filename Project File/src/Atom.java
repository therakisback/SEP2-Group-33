//import


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class used to help separate Atom data from 3 main classes
 *    to help pass information concerning atoms between them.
 */
public class Atom {

    // Data Variables       ----------
    private final boolean flag;   // Boolean to store whether atom is meant to be a flag
    private final int row;   // Store location of atom
    private final int col;


    /**
     * Constructor for new Atom object.

     * @param row   Grid location of new atom (row).
     * @param col   Grid location of new atom (col).
     * @param flag  Whether specified atom object is meant to be a "flag atom".
     */
    public Atom(int row, int col, boolean flag) {
        if (row >= 0 && row < 9 && col >= 0 && col < 9) {
            this.row = row;
            this.col = col;
            this.flag = flag;
        } else throw new IllegalArgumentException("Invalid row or column");
    }

    /**
     * Constructor for new Atom object at the beginning of game.

     * @param row   Grid location of new atom (row).
     * @param col   Grid location of new atom (col).
     */
    public Atom (int row, int col){
        if (row >= 0 && row < 9 && col >= 0 && col < 9) {
        this.row = row;
        this.col = col;
        flag = true;
        } else throw new IllegalArgumentException("Invalid row or column");

    }

    // Get functions        ----------

    /**
     * @return row of specified atom.
     */

    public int getRow() {
        return row;
    }


    /**
     * @return col of specified atom.
     */
    public int getCol() {
        return col;
    }


    /**
     * @return Whether specified atom is a "flag atom"
     */
    public boolean isFlag() {
        return flag;
    }


    /**
     * @return teh location of each atom (row col)
     */
    public static int[][] getLocations (Atom[] arr){
        int[][] atoms = new int[4][2];
        for (int i = 0; i < 4; i++){
            atoms[i][0] = arr[i].getRow();
            atoms[i][1] = arr[i].getCol();
        }
        return atoms;
    }
}
