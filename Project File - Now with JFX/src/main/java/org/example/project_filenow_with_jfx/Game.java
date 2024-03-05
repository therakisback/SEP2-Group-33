package org.example.project_filenow_with_jfx;

import java.util.ArrayList;
import java.util.Random;

/**
 * "Game Manger" class for dealing with the primary functions
 *    and memory keeping of the game
 * <p>
 * Should be written with the idea that it is going to be
 *    and object in the main class kept in mind.
 */
public class Game {

    // Class variables      ----------

    // TODO
    Atom[] trueAtoms;
    ArrayList<Ray> castRays= new ArrayList<>();
    int score;

    /**
     * Constructor for game class, should only be used once in controller class.
     */
    public Game() {

    }

    // Class functions      ----------

    /**
     * Calculates the path and result of given ray
     * @param r Ray object to be used.
     */
    public void calculateRay(Ray r) throws Exception{

        // Starting variables / Actions

        // set true where there is an atom
        boolean[] atomNeighbors = new boolean[6];

        // Ray added to list of all rays cast to show at end of game
        castRays.add(r);

        // If there are no atoms at all the game has been started wrong
        if (trueAtoms == null) {throw new Exception("Atoms not created before attempting ray");}

        // Main tick loop   ---------

        while(true) {
            // Calculate atomNeighbors - could probably optimise, but 24 checks is not worth it
            // created here so "atom checkers" don't have to create their own
            int index = 0;
            for (int[] arr : r.createNeighbours()) {
                for (Atom a : trueAtoms) {
                    if (arr[0] == a.getRow() && arr[1] == a.getCol()) {
                        atomNeighbors[index] = true;
                        break; // breaks only inner loop
                    }
                }
                index++;
            }

            // Atoms        ----------

            // Checks for atoms to change directions / absorb
            // Done before moving for hopefully obvious reasons.
            /* if checkReturn(r, atomNeighbors) -> TODO - Sprint 3
            else if checkDoubleBounce(r, atomNeighbors) ->TODO - Sprint 3
            else if checkBounce(r, atomNeighbors) -> TODO - Sprint 3
            else*/ if (hitAtom(r, atomNeighbors)) break;

            // Moving       ----------

            moveRay(r); // Self-explanatory

            // Edge Check   ----------

            // Check if ray is done (I.E. at edge hex, heading towards edge)
            // Done after moving so that we have no risk of running off the board
            int edge = onEdge(r);
            if (edge == -1)  continue;
            else if (edge == r.getStart()){
                r.setEnd(-2);
                break;
            } else {
                r.setEnd(edge);
                break;
            }

        }
    }

    /**
     * Takes input for set atom locations
     * @param args Atoms to be included in array
     */
    public void setAtoms(Atom... args) {
        trueAtoms = new Atom[args.length];
        int i = 0;
        for (Atom a : args) {
            if(a.isFlag()) throw new IllegalArgumentException("True atoms cannot have flag marking.");
            trueAtoms[i++] = a;
        }
    }

    /**
     * Uses Random to create atom placements on board
     */
    public void setAtoms() {
        Random random = new Random();
        int row = random.nextInt(9);
        if (row < 0 || row > 8) throw new IllegalArgumentException("Row has to be between 0 and 8, inclusive");
        trueAtoms = new Atom[4];
        int col = 0;
        int n = 2;
        for (int i = 0; i < 4; i++) {
            if (row >= 0 && row < 5) {
                col = random.nextInt(row + 4) + 1;
            } else if (row >= 5 && row < 9) {
                col = random.nextInt(row + n) + 1;
                n = n - 2;
            }
            //I need n to be -2, -4
            trueAtoms[i] = new Atom(row, col);
        }
    }




    /**
     * Checks given atom flags with true atoms,
     * calculates score, and ends the game
     * @param atomFlags Array of flags to be checked with true atoms
     */
    public void submitGame(Atom[] atomFlags) {
        // TODO - sprint 4
    }

    private boolean hitAtom(Ray r, boolean[] rneighbors){
        boolean hitAtom = false;
        //checks if all neighbours of ray are not atoms, returns true if one of them is

        return false;
    }

    /**
     * Used to move ray one step
     * based on the rays direction and position
     * @param r Ray to be moved
     */
    private void moveRay(Ray r) {
        int row = r.getRow();
        int col = r.getCol();

        //Change row and column based on direction and position
        switch (r.getDir()) {
            case 1: // Up and left
                if (row <= 4) {
                    r.setRow(--row);
                    r.setCol(--col);
                } else {
                    r.setRow(--row);
                }
            case 2: // Up and right
                if (row <= 4) {
                    r.setRow(--row);
                } else {
                    r.setRow(--row);
                    r.setCol(++col);
                }
            case 3: // Right
                    r.setCol(++col);
            case 4: // Down and right
                if (row < 4) {
                    r.setRow(++row);
                    r.setCol(++col);
                } else {
                    r.setRow(++row);
                }
            case 5: // Down and left
                if (row < 4) {
                    r.setRow(++row);
                } else {
                    r.setRow(++row);
                    r.setCol(--col);
                }
            case 6: // Left
                    r.setCol(--col);
        }
    }

    /**
     * Used to find whether a ray is on an edge hex facing an edge
     * @param r Ray to check if on edge
     * @return int for which edge the ray has "hit" or -1 for no hit
     */
    private int onEdge(Ray r) { // Do note, I hate this :D - R
        int row = r.getRow();
        int col = r.getCol();
        int dir = r.getDir();

        // interface used to create "functions" in method to
        // reduce repetition - which is a bad problem for this method
        interface output {int run(int a);} // a = col check

        switch (dir) {
            case 1: // This is the worst, as it has the border between 0 and 53
                if (col == 0 && row <= 4) return (row * 2);         // edge 0  - 8  even
                else if (row == 0)        return 54 - (col * 2);    // edge 46 - 52 even
                else                      return -1;
            case 2:
                if (row == 0) {

                }
                output k = (int a) -> {
                    if (col == a) return 45 - (row * 2);
                    else          return -1;
                };
                return switch (row) {
                    case 1  -> k.run(5);
                    case 2  -> k.run(6);
                    case 3  -> k.run(7);
                    case 4  -> k.run(8);
                    default -> -1;
                };                          // edge 43 - 37 odd
            case 3:
                output i = (int a) -> {
                    if (col == a) return 44 - (row * 2);
                    else return -1;
                };
                return switch (row) {
                    case 0, 8 -> i.run(4);
                    case 1, 7 -> i.run(5);
                    case 2, 6 -> i.run(6);
                    case 3, 5 -> i.run(7);
                    case 4    -> i.run(8);
                    default   -> -1;
                };                          // edge 28 - 44 even
            case 4:

            case 5:

            case 6:
                if (col == 0) return (row * 2) + 1;
                else          return -1;
        }
    }

}

/*          / ------------- \
   ^ ^     | *HHhhoOOoOotTt* |
  (-,-)   / / ------------- /
  |\ /|
 ==M=M==    *Owlly isn't doing well here, he's quite exhausted
             from 'sprinting' and at this point im scared to tell
             him that's now what we mean by 'sprints' - R
 */