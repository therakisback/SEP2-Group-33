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
    // Store grid location of ray particle thingy (row + col)
    private int row;
    private int col;
    // Store result of ray after computed (end location, mark absorbed)
    /*
        -2 - returned
        -1 - absorbed
        0 - 53 - end
     */
    private int end;
    // Store path of ray
    //stores each num of the grid the ray passed through; can increase as needed
    private ArrayList<Integer> path;

    /**
     * Constructor for new ray object.
     * @param direction   Starting direction for ray.
     * @param row   Starting grid square of ray(row).
     * @param col   Starting grid square of ray(col).
     * @param start Starting number / side of ray.
     */
    public Ray( int row, int col, int direction, int start){
        if (direction > 1 && direction < 7 && row >= 0 && row < 9 && col >= 0 && col < 9 && start > 0 && start < 54) {
            this.row = row;
            this.col = col;
            this.direction = direction;
            this.start = start;
            path = new ArrayList<>();
        } else throw new IllegalArgumentException("Invalid input");
    }

    // Get functions        -----------

    /**
     * @return Current direction of the ray.
     */
    public int getDir() {
        return direction;
    }

    /**
     * @return Current grid location of ray (row).
     */
    public int getRow(){
        return row;
    }

    /**
     * @return Current grid location of ray (col).
     */
    public int getCol(){
        return col;
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
        if (direction > 0 && direction < 7) {
            this.direction = direction;
        }else throw new IllegalArgumentException("Invalid direction");
    }

    /**
     * @param row New ray grid location (row).
     */

    public void setRow(int row) {
        if (row > 0 && row < 9){
            this.row = row;
            path.add(row);
        } else throw new IllegalArgumentException("Invalid new row");

    }

    /**
     * @param col New ray grid location (col).
     */

    public void setCol(int col) {
        if (col > 0 && col < 9){
            this.col = col;
            path.add(col);
        } else throw new IllegalArgumentException("Invalid new col");
    }

    public void setEnd(int end) {
        if (end < -2 || end > 53){
            throw new IllegalArgumentException("Invalid result for end of ray path");
        }
        this.end = end;
    }

    /**
     * @return the neighbours of the ray in a 2d array form
     */

    //return a 2d array frm the arrayList of neighbours
    public int[][] createNeighbours(){
        ArrayList<Integer> neighbours = new ArrayList<>();
        int newRow, newCol;
        //pattern for neighbours of positions on top half of board
        if (row >=0 && row < 4) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if ((i == -1 && j == 1) || (i == 0 && j == 0) || (i == 1 && j == -1))
                        continue;
                    newRow = row + i;
                    newCol = col + j;
                    neighbours.add(newRow);
                    neighbours.add(newCol);
                }
            }
            //pattern for neighbours of positions on bottom half of board
        } else if(row > 4) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == j) continue;
                    newRow = row + i;
                    newCol = col + j;
                    neighbours.add(newRow);
                    neighbours.add(newCol);
                }
            }
            //pattern for neighbours of positions on row 4 = middle of board
        } else {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if ((i == -1 && j == 1) || (i == 0 && j == 0) || (i == 1 && j ==1)) continue;
                    newRow = row + i;
                    newCol = col + j;
                    neighbours.add(newRow);
                    neighbours.add(newCol);
                }
            }
        }

        int[][] proximity = new int[6][2];
        int count = 0;
        for (int i = 0; i < 6; i++){
            proximity[i][0] = neighbours.get(count);
            count++;
            proximity[i][1] = neighbours.get(count);
            count++;
        }
        return proximity;
    }
}
