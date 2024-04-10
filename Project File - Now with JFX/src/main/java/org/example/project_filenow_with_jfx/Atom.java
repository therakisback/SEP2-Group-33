package org.example.project_filenow_with_jfx;//import

/**
 * Class used to help separate Atom data from 3 main classes
 *    to help pass information concerning atoms between them.
 */
public class Atom {

    // Data Variables       ----------
    private boolean flag;   // Boolean to store whether atom is meant to be a flag
   // Store location of atom
    private final int row;
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

    /**@return row of specified atom.*/
    public int getRow() { return row; }


    /**@return column of specified atom.*/
    public int getCol() { return col; }


    /**@return Whether specified atom is a "flag atom"*/
    public boolean isFlag() { return flag; }

    /**
     * Changes atom's flag value
     * @param flag flag value to change to
     */
    public void setFlag(boolean flag) { this.flag =flag; }


    /**@return the location of each atom in the array [(row1, col1),...(row4, col4)]*/
    public static int[][] getLocations (Atom[] arr){
        int[][] atoms = new int[4][2];
        for (int i = 0; i < arr.length; i++){
            atoms[i][0] = arr[i].getRow();
            atoms[i][1] = arr[i].getCol();
        }
        return atoms;
    }

    /**
     * Equals method to compare two atom objects, compares position and flag value
     * @param obj object to compare
     * @return boolean on whether two objects hold same value
     */
    public boolean equals(Object obj) {
        if (obj instanceof Atom a) {

            if (a.getCol() != this.getCol()) return false;
            if (a.getRow() != this.getRow()) return false;
            return a.isFlag() == this.isFlag();

        } else return false;
    }

    /**
     * Equals method to compare two atom objects, compares position and flag value
     * @param obj1 first object to compare
     * @param obj2 second object to compare
     * @return boolean on whether the two objects hold same value
     */
    static public boolean equals(Object obj1, Object obj2) {
        if (obj1 instanceof Atom a && obj2 instanceof Atom b) {

            if (a.getCol() != b.getCol()) return false;
            if (a.getRow() != b.getRow()) return false;
            return a.isFlag() == b.isFlag();

        } else return false;
    }

    /**
     * Method to convert an Atom object into a String
     * @return String of containing position and flag state of Atom object
     */
    public String toString() { return ("Position: (" + col + ", " + row + ") \tFlag:" + flag); }

    /**
     * Static method to convert an Atom object into a String
     * @return String of containing position and flag state of Atom object
     */
    static public String toString(Atom a) { return ("Position: (" + a.getRow() + ", " + a.getCol() + ") \tFlag:" + a.isFlag()); }
}
