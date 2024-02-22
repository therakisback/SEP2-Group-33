//import


import java.util.ArrayList;

/**
 * Class used to help seperate Atom data from 3 main classes
 *    to help pass information concerning atoms between them.
 */
public class Atom {

    // Data Variables       ----------

    // TODO - Note: Make all variables private
    private final boolean flag;   // Boolean to store whether atom is meant to be a flag
    private final int row;   // Store location of atom
    private final int col;
    //arrayList to store the "neighbours" of the atom
    //neighbour = the nearby grids
    private ArrayList<Integer> neighbours;


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

    //constructor for atoms from beginning
    public Atom (int row, int col){
        if (row >= 0 && row < 9 && col >= 0 && col < 9) {
        this.row = row;
        this.col = col;
        flag = true;
        neighbours = new ArrayList<>();
        } else throw new IllegalArgumentException("Invalid row or column");

    }

    // Get functions        ----------

    /**
     * @return Location of specified atom.
     */

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public ArrayList<Integer> getNeighbours(){
        return neighbours;
    }

    public boolean validNewPos(int newRow, int newCol){
        return (newRow >=0 && newRow < 9 && newCol >= 0 && newCol <9);
    }


    public void createNeighbours() {
        //ArrayList<Integer> nList = new ArrayList<>();
        int newRow, newCol;
        //pattern for neighbours of positions on top half of board
        if (row >=0 && row < 4) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if ((i == -1 && j == 1) || (i == 0 && j == 0) || (i == 1 && j == -1))
                        continue;
                    newRow = row + i;
                    newCol = col + j;
                    if (validNewPos(newRow, newCol)) {
                        neighbours.add(newRow);
                        neighbours.add(newCol);
                    }
                }
            }
            //pattern for neighbours of positions on bottom half of board
        } else if(row > 4) {
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == j) continue;
                        newRow = row + i;
                        newCol = col + j;
                        if (validNewPos(newRow, newCol)) {
                            neighbours.add(newRow);
                            neighbours.add(newCol);
                        }
                    }
                }
            //pattern for neighbours of positions on row 4 = middle of board
        } else {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if ((i == -1 && j == 1) || (i == 0 && j == 0) || (i == 1 && j ==1)) continue;
                    newRow = row + i;
                    newCol = col + j;
                    if (validNewPos(newRow, newCol)) {
                        neighbours.add(newRow);
                        neighbours.add(newCol);
                    }
                }
            }
        }
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


    public static int[][] getLocations (Atom[] arr){
        int[][] atoms = new int[4][2];
        for (int i = 0; i < 4; i++){
            atoms[i][0] = arr[i].getRow();
            atoms[i][1] = arr[i].getCol();
        }
        return atoms;
    }
}
