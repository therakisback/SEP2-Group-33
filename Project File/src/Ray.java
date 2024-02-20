//import

import java.util.ArrayList;

/**
 * Class used to separate base data for rays from main 3 classes
 *    to help pass information concerning rays between them.
 */

public class Ray {

    // Data variables       ----------

    // TODO - Note: Make all variables private
    // Store directions of ray
    private int direction;
    // Store starting location of array
    private int start;
    // Store grid location of ray particle thingy
    private int loc;
    // Store result of ray after computed (end location, mark absorbed)
    // ?result as in reflected/absorbed or the location of teh output of the array, unless it's absorbed?
    private int end;
    // Store path of ray
    //stores each num of the grid the ray passed through; can increase as needed
    private ArrayList<Integer> path;

    /**
     * Constructor for new ray object.
     * @param direction   Starting direction for ray.
     * @param loc   Starting grid square of ray.
     * @param start Starting number / side of ray.
     */
    public Ray(int direction, int loc, int start){
        this.direction = direction;
        this.loc = loc;
        this.start = start;
        path = new ArrayList<>();
    }

    // Get functions        -----------

    /**
     * @return Current direction of the ray.
     */
    public int getDir() {
        return direction;
    }

    /**
     * @return Current grid location of ray.
     */
    public int getLoc() {
        return loc;
    }

    /**
     * @return Starting location of ray.
     */
    public int getStart() {
        return start;
    }

    /**
     * @return Ending result of ray, if one is specified.
     */
    public int getResult() {
        return end;
    }


    // Set functions        -----------

    /**
     * @param direction New ray direction input.
     */
    public void setDir(int direction) {
        // TODO
        this.direction = direction;
        return;
    }

    /**
     * @param location New ray grid location.
     */

    /*
    as in move the current location based on the direction the ray is going in?
     */
    public void setLoc(int location) {
        // TODO
        loc = location;
        path.add(location);
        return;
    }

    public void setResult(int result) {
        end = result;
        return;
    }


}
