//import


/**
 * Class used to help seperate Atom data from 3 main classes
 *    to help pass information concerning atoms between them.
 */
public class Atom {

    // Data Variables       ----------

    // TODO - Note: Make all variables private
    private boolean flag;   // Boolean to store whether atom is meant to be a flag
    private int loc;   // Store location of atom
    private int[] neighbours;
    // Store nearby squares for atom to help with ray computing
    /*
        the ones directly next to it: location+1(exception: bottom right), location-1 (exception: top left)
        the ones above and underneath are based on the line they're on (see paper with cases)
     */

    /**
     * Constructor for new Atom object.
     * @param loc   Grid location of new atom.
     * @param flag  Whether specified atom object is meant to be a "flag atom".
     */
    public Atom(int loc, boolean flag) {
        this.loc = loc;
        this.flag = flag;
    }

    //constructor for atoms from beginning
    public Atom (int loc){
        this.loc = loc;
        flag = true;
        neighbours = new int[6];
    }

    // Get functions        ----------

    /**
     * @return Location of specified atom.
     */
    public int getLoc() {
        return loc;
    }

    public void createNeighbours(){

    }

    //takes current position of ray and compares it to the neighbours of the atoms
    //needs to be called for all atoms, one at a time
    //if pos = i -> change location on grid
    public boolean checkNeighbours(int pos){
        for (int i : neighbours){
            return pos == i;
        }
        return false;
    }

    /**
     * @return Whether specified atom is a "flag atom"
     */
    public boolean isFlag() {
        return flag;
    }


}
