//import

/**
 * Class used to separate base data for rays from main 3 classes
 *    to help pass information concerning rays between them.
 */

public class Ray {

    // Data variables       ----------

    // TODO - Note: Make all variables private
    // Store directions of ray
    // Store starting location of array
    // Store grid location of ray particle thingy
    // Store result of ray after computed (end location, mark absorbed)
    // Store path of ray?

    /**
     * Constructor for new ray object.
     * @param dir   Starting direction for ray.
     * @param loc   Starting grid square of ray.
     * @param start Starting number / side of ray.
     */
    public Ray(int dir, int loc, int start){
        // TODO
    }

    // Get functions        -----------

    /**
     * @return Current direction of the ray.
     */
    public int getDir() {
        // TODO
        return 0;
    }

    /**
     * @return Current grid location of ray.
     */
    public int getLoc() {
        // TODO
        return 0;
    }

    /**
     * @return Starting location of ray.
     */
    public int getStart() {
        // TODO
        return 0;
    }

    /**
     * @return Ending result of ray, if one is specified.
     */
    public int getResult() {
        // TODO
        return 0;
    }


    // Set functions        -----------

    /**
     * @param direction New ray direction input.
     */
    public void setDir(int direction) {
        // TODO
        return;
    }

    /**
     * @param location New ray grid location.
     */
    public void setLoc(int location) {
        // TODO
        return;
    }

    public void setResult(int result) {
        // TODO
        return;
    }
}
