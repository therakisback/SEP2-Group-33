package org.example.project_filenow_with_jfx;//import

import java.util.ArrayList;

/**
 * Class used to separate base data for rays from main 3 classes
 *    to help pass information concerning rays between them.
 */


public class Ray {

    // Data variables       ----------
    private int direction;      // Store directions of ray (1-6 -> for each hexagon side)
    private final int start;    // Store starting location of array

    // Store grid location of ray particle thingy (row + col)
    private int row;
    private int col;
    private int end;            // Store result of ray after computed (end location, mark absorbed)
    /**
     * Stores the path of the ray in int[] of length 4: [row, col, startDir, endDir]
     */
    private ArrayList<int[]> path;

    /**
     * Constructor for new ray object.

     * @param direction   Starting direction for ray.
     * @param row   Starting grid square of ray(row).
     * @param col   Starting grid square of ray(col).
     * @param start Starting number / side of ray.
     */
    public Ray(int row, int col, int direction, int start){
        if (direction > 0 && direction < 7 && row >= 0 && row < 9 && col >= 0 && col < 9 && start >= 0 && start < 54) {
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
        int temp;
        temp = (direction - 1) % 6;
        if (temp < 0) temp += 6;
        this.direction = (temp + 1); // Allow any integer and map it to the proper ones.

    }

    /**
     * Sets ray's row value to new integer
     * @param row Integer value of grid row
     */

    public void setRow(int row) {
        if (row >= 0 && row < 9){
            this.row = row;
        } else throw new IllegalArgumentException("Invalid new row");

    }

    /**
     * Sets ray's column value to new integer
     * @param col Integer value of grid column
     */
    public void setCol(int col) {
        if (col >= 0 && col < 9){
            this.col = col;
        } else throw new IllegalArgumentException("Invalid new col");
    }

    /**
     * @param end End position on board of ray.
     */
    public void setEnd(int end) {
        if (end < -2 || end > 53){
            throw new IllegalArgumentException("Invalid result for end of ray path");
        }
        this.end = end;
    }

    /**
     * Adds current row, column, and direction to path variable, with past direction stored.
     * <p>[row, column, endDirection, startDirection]
     */
    public void addToPath(int pastDirection) {
        path.add(new int[] {row, col, direction, pastDirection});
    }

    /**
     * get the arraylist for the path values
     * @return list of integer arrays signifying each hexagon: [row, column, endDirection, startDirection]
     */
    public ArrayList<int[]> getPath() {
        return path;
    }

    /**
     * no need to check if the positions of the neighbours are valid
     * because we're only checking if atoms are in that position and there are only 6 neighbours
     * @return the neighbours of the ray in a 2d array form (row, column)
     */

    public int[][] createNeighbours(){
        ArrayList<Integer> neighbours = new ArrayList<>();
        int newRow, newCol;
        //pattern for neighbours of positions on top half of board
        if (row >= 0 && row < 4) {
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

    public boolean equals(Object obj) {
        if (obj instanceof Ray r) {

            // Using the two properties that are (mostly) unchanging for the ray,
            //   as the same ray travels through multiple location and directions
            //   they would be a bad way to judge whether the rays are equal
            if (r.getStart() != this.getStart()) return false;
            if (r.getResult() != this.getResult()) return false;
            return true;

        } else return false;
    }

    static public boolean equals(Object obj1, Object obj2) {
        if (obj1 instanceof Ray r1 && obj2 instanceof Ray r2) {

            if (r1.getStart() != r2.getStart()) return false;
            if (r1.getResult() != r2.getResult()) return false;
            return true;

        } else return false;
    }

    public String toString() {
        return ("Position: (" + row + ", " + col + ") \tStart: " + start + "\tResult: " + end);
    }

    static public String toString(Ray r) {
        return ("Position: (" + r.getRow() + ", " + r.getCol() + ") \tStart: " + r.getStart() + "\tResult: " + r.getResult());
    }
}
