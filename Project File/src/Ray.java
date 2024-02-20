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
     * @param row   Starting row of ray
     * @param col   Starting col of ray
     * @param dir   Starting direction for ray      (0-5)
     * @param start Starting number / side of ray.  (0-53)
     */
    public Ray(int row, int col, int dir, int start){
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
    public int getCol() {
        // TODO
        return 0;
    }


    public int getRow() {
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
    public void setRow(int location) {
        // TODO
        return;
    }

    public void setCol(int location) {
        // TODO
        return;
    }

    public void setResult(int result) {
        // TODO
        return;
    }
}
