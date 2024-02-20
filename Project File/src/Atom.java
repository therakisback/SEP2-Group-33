//import


/**
 * Class used to help seperate Atom data from 3 main classes
 *    to help pass information concerning atoms between them.
 */
public class Atom {

    // Data Variables       ----------

    // TODO - Note: Make all variables private
    private boolean flag;   // Boolean to store whether atom is meant to be a flag
    // Store location of atom
    // Store nearby squares for atom to help with ray computing?

    /**
     * Constructor for new Atom object.
     * @param row   Row location of new atom.
     * @param col   Column location of new atom
     * @param flag  Whether specified atom object is meant to be a "flag atom".
     */
    public Atom(int row, int col, boolean flag) {
        this.flag = flag;
        // TODO
    }

    // Get functions        ----------

    /**
     * @return Location of specified atom.
     */
    public int getCol() {
        // TODO
        return 0;
    }

    public int getRow() {
        //TODO
        return 0;
    }

    /**
     * @return Whether specified atom is a "flag atom"
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * Takes a list of atoms and converts it into a list of the locations of the atoms
     * @param atoms the array of atoms to have the locations taken
     * @return a 2d array of ints marking the location of the atoms {[x1.y1], [x2,y2], [x3,y3], [x4,y4]}
     */
    public static int[][] getLocations(Atom[] atoms) {
        //TODO
        return new int[4][2];
    }


}
