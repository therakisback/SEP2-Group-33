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
     * @param loc   Grid location of new atom.
     * @param flag  Whether specified atom object is meant to be a "flag atom".
     */
    public Atom(int loc, boolean flag) {
        this.flag = flag;
        // TODO
    }

    // Get functions        ----------

    /**
     * @return Location of specified atom.
     */
    public int getLoc() {
        // TODO
        return 0;
    }

    /**
     * @return Whether specified atom is a "flag atom"
     */
    public boolean isFlag() {
        return flag;
    }


}
