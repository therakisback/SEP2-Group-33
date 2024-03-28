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
    private Atom[] trueAtoms;
    private ArrayList<Ray> castRays = new ArrayList<>();
    private int score;

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
    public void calculateRay(Ray r) throws IllegalArgumentException{

        // Starting variables / Actions

        // set true where there is an atom
        boolean[] atomNeighbors;
        int pastDirection;

        // Ray added to list of all rays cast to show at end of game
        castRays.add(r);

        // If there are no atoms at all the game has been started wrong
        if (trueAtoms == null) {throw new IllegalArgumentException("Atoms not created before attempting ray");}

        // Main tick loop   ---------
        int count = 0;      // Boolean to check if it's the first tick of the ray.
        while(true) {
            // Basic Checks ----------
            // Check hexagons neighboring ray for atoms
            // created here so "atom bounce checkers" don't have to create their own
            atomNeighbors = new boolean[6];
            int index = 0;
            for (int[] arr : r.createNeighbours()) {
                for (int[] a : Atom.getLocations(trueAtoms)) {
                    if (arr[0] == a[0] && arr[1] == a[1]) {
                        atomNeighbors[index] = true;
                        break; // breaks only inner loop
                    }
                }
                index++;
            }

            // Handles if the ray is created with an atom next to it.
            if (count == 0) {
                for (boolean a : atomNeighbors) {
                    if (a) {
                        r.setEnd(-2);
                        break;
                    }
                }
            }

            pastDirection = r.getDir();

            // Atoms        ----------

            // Checks for atoms to change directions / absorb
            // Done before moving for hopefully obvious reasons.
            if (checkBounce(r, atomNeighbors)) {
                checkBounce(r, atomNeighbors);
            } else if (hitAtom(r, atomNeighbors)) break;

            r.addToPath(pastDirection);

            // Moving       ----------

            moveRay(r); // Self-explanatory

            // Edge Check   ----------

            // Debug        ----------
            if (count > 65) {System.out.println(" Ray loop didn't end"); break;}     // Prevents infinite looping
            count++;
            //System.out.println(Ray.toString(r));

            // Check if ray is done (I.E. at edge hex, heading towards edge)
            // Done after moving so that we have no risk of running off the board
            int edge = onEdge(r);
            if (edge != -1) {
                if (edge == r.getStart()) {
                    r.setEnd(-2);
                } else {
                    r.setEnd(edge);
                }
                return;
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
        trueAtoms = new Atom[4];
        int col;
        int n = 2;
        for (int i = 0; i < 4; i++) {
            if (row < 5) {
                col = random.nextInt(row + 4) + 1;
            } else {
                col = random.nextInt(row + n) + 1;
                n = n - 2;
            }
            trueAtoms[i] = new Atom(row, col);
        }
    }

    /**
     * Checks given atom flags with true atoms,
     * calculates score, and ends the game
     * @param atomFlags Array of flags to be checked with true atoms
     * @return score for given flags and atoms
     */
    public int submitGame(Atom[] atomFlags) {
        // TODO - sprint 4
        return 0;
    }


    /**
     * @param r - ray to traverse board
     * @param atomNeighbors - array of booleans containing positions
     *                      of atom's neighbours
     *
     */
    private boolean hitAtom(Ray r, boolean[] atomNeighbors){
        boolean hit = false;
        switch (r.getDir()){
            case 1:
                if (atomNeighbors[0]) hit = true;
                break;
            case 2:
                if (atomNeighbors[1]) hit = true;
                break;
            case 3:
                if (atomNeighbors[3]) hit = true;
                break;
            case 4:
                if (atomNeighbors[5]) hit = true;
                break;
            case 5:
                if (atomNeighbors[4]) hit = true;
                break;
            case 6:
                if (atomNeighbors[2]) hit = true;
                break;
        }
        if (hit) r.setEnd(-1);
        return hit;
    }

    /**
     * @param r - ray to check for bounce board
     * @param atomNeighbors - array of booleans containing positions
     *                      of atom's neighbours
     *
     */

    private boolean checkBounce(Ray r, boolean[]atomNeighbors){
        boolean bounce = false;
        int dir = r.getDir();
        switch (dir){
            case 1:
                //return
                if (atomNeighbors[1] && atomNeighbors[2]){
                    r.setDir(dir+3);
                }else if (atomNeighbors[1]){
                    bounce = true;
                    r.setDir(--dir);
                }else if (atomNeighbors[2]){
                    bounce = true;
                    r.setDir(++dir);
                }
                break;
            case 2:
                //return
                if (atomNeighbors[0] && atomNeighbors[3]){
                    r.setDir(dir+3);
                }else if (atomNeighbors[0]){
                    bounce = true;
                    r.setDir(++dir);
                }else if (atomNeighbors[3]){
                    bounce = true;
                    r.setDir(--dir);
                }
                break;
            case 3:
                //return
                if (atomNeighbors[1] && atomNeighbors[5]){
                    r.setDir(dir+3);
                }else if (atomNeighbors[1]){
                    bounce = true;
                    r.setDir(++dir);
                }else if (atomNeighbors[5]){
                    bounce = true;
                    r.setDir(--dir);
                }
                break;
            case 4:
                //return
                if (atomNeighbors[3] && atomNeighbors[4]){
                    r.setDir(dir+3);
                }else if (atomNeighbors[3]){
                    bounce = true;
                    r.setDir(++dir);
                }else if (atomNeighbors[4]){
                    bounce = true;
                    r.setDir(--dir);
                }
                break;
            case 5:
                //return
                if (atomNeighbors[2] && atomNeighbors[5]){
                    r.setDir(dir+3);
                }else if (atomNeighbors[2]){
                    bounce = true;
                    r.setDir(--dir);
                }else if (atomNeighbors[5]){
                    bounce = true;
                    r.setDir(++dir);
                }
                break;
            case 6:
                //return
                if (atomNeighbors[0] && atomNeighbors[4]){
                    r.setDir(dir+3);
                }else if (atomNeighbors[0]){
                    bounce = true;
                    r.setDir(--dir);
                }else if (atomNeighbors[4]){
                    bounce = true;
                    r.setDir(++dir);
                }
                break;
        }
        return bounce;
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
                    r.setRow(row-1);
                    r.setCol(col-1);
                } else {
                    r.setRow(row-1);
                }
                break;
            case 2: // Up and right
                if (row <= 4) {
                    r.setRow(row-1);
                } else {
                    r.setRow(row-1);
                    r.setCol(col+1);
                }
                break;
            case 3: // Right
                    r.setCol(col+1);
                    break;
            case 4: // Down and right
                if (row < 4) {
                    r.setRow(row+1);
                    r.setCol(col+1);
                } else {
                    r.setRow(row+1);
                }
                break;
            case 5: // Down and left
                if (row < 4) {
                    r.setRow(row+1);
                } else {
                    r.setRow(row+1);
                    r.setCol(col-1);
                }
                break;
            case 6: // Left
                    r.setCol(col-1);
                    break;
        }
    }

    /**
     * Used to find whether a ray is on an edge hex facing an edge.
     * <p> This is, frankly, a bad method. I couldn't discern a pattern
     * in the hexagons, and thus resorted to hard-coding 53 conditions.
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
        output i;

        // NOTE: comments in telling what edge it marks assume
        // every statement is collapsed if possible, IE shows: {...} a lot
        switch (dir) {
            case 1:
                if (row == 0 && col != 0)      return 54 - (col * 2);   // edge 46 - 52 even
                else if (col == 0 && row <= 4) return (row * 2);        // edge 0  - 8  even
                else                           return -1;
            case 2:
                // Takes edge column as a, and calculates edge from that.
                i = (int a) -> {
                    if (col == a) return 45 - (row * 2);
                    else          return -1;
                };
                return switch (row) {
                    case 0: switch (col) {
                        // k.run does not work here, as edge is based on col
                        case 0:  yield 53;
                        case 1:  yield 51;
                        case 2:  yield 49;
                        case 3:  yield 47;
                        case 4:  yield 45;
                        default: yield -1;
                    }
                    case 1:  yield i.run(5);
                    case 2:  yield i.run(6);
                    case 3:  yield i.run(7);
                    case 4:  yield i.run(8);
                    default: yield -1;
                };                              // edge 37 - 53 odd
            case 3:
                i = (int a) -> {
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
                };                              // edge 28 - 44 even
            case 4:
                i = (int a) -> {
                    if (col == a) return 44 - (row * 2);
                    else return -1;
                };
                return switch (row) {
                    case 4 -> i.run(8);
                    case 5 -> i.run(7);
                    case 6 -> i.run(6);
                    case 7 -> i.run(5);
                    case 8 -> switch (col) {
                            case 0  -> 19;
                            case 1  -> 21;
                            case 2  -> 23;
                            case 3  -> 25;
                            case 4  -> 27;
                            default -> -1;
                        };
                    default -> -1;
                };                              // edge 19 - 35 odd
            case 5:
                if (row == 8 && col != 0)      return 18 + (col * 2);   // edge 20 - 26 even
                else if (col == 0 && row >= 4) return 2 + (row * 2);    // edge 10 - 18 even
                else                           return -1;

            case 6:
                if (col == 0) return (row * 2) + 1;                     // edge 1 - 17 odd
                else          return -1;
            default: return -1;
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