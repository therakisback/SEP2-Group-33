package org.example.project_filenow_with_jfx;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RayTest {

    Ray r;

    @Test
    public void Ray() {
        // Location Tests
        r = new Ray(5, 3, 3, 3);
        assertEquals(5, r.getRow());
        assertEquals(3, r.getCol());
        assertThrows(IllegalArgumentException.class, () -> {
            Ray r = new Ray(-1, 3, 3, 3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Ray r = new Ray(70, 3, 3, 3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Ray r = new Ray(3, -1, 3, 3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Ray r = new Ray(3, 70, 3, 3);
        });

        // Direction Tests
        r = new Ray(0, 0, 5, 3);
        assertEquals(5, r.getDir());
        assertThrows(IllegalArgumentException.class, () -> {
            Ray r = new Ray(0, 0, -1, 3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Ray r = new Ray(0, 0, 7, 3);
        });

        // Start Tests
        r = new Ray(0, 0, 3, 5);
        assertEquals(5, r.getStart());
        assertThrows(IllegalArgumentException.class, () -> {
            Ray r = new Ray(0, 0, 3, -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Ray r = new Ray(0, 0, -1, 70);
        });
    }

    @Test
    public void getDir() {
        r = new Ray(0, 0, 5, 3);
        assertEquals(5, r.getDir());
    }

    @Test
    public void getLoc() {
        r = new Ray(5, 3, 3, 3);
        assertEquals(5, r.getRow());
        assertEquals(3, r.getCol());
    }

    @Test
    public void getStart() {
        r = new Ray(0, 0, 3, 5);
        assertEquals(5, r.getStart());
    }

    @Test
    public void getResult() {
        // Testing get and set result in set test method
    }

    @Test
    public void setDir() {
        r = new Ray(0, 0, 3, 3);
        assertEquals(3, r.getDir());
        r.setDir(5);
        assertEquals(5, r.getDir());
    }

    @Test
    public void setLoc() {
        r = new Ray(3, 3, 3, 3);
        assertEquals(3, r.getRow());
        r.setRow(5);
        assertEquals(5, r.getRow());
        assertEquals(3, r.getCol());
        r.setCol(5);
        assertEquals(5, r.getCol());
    }

    @Test
    public void setResult() {
        r = new Ray(0, 0, 3, 3);
        r.setEnd(5);
        assertEquals(5, r.getResult());
    }


    @Test
    public void createNeighboursMiddle() {
        r = new Ray(4, 2, 3, 4);
        assertEquals("[[3, 1], [3, 2], [4, 1], [4, 3], [5, 1], [5, 2]]", Arrays.deepToString(r.createNeighbours()));

    }

    @Test
    public void createNeighboursAbove() {
        r = new Ray(2, 2, 5, 3);
        assertEquals("[[1, 1], [1, 2], [2, 1], [2, 3], [3, 2], [3, 3]]", Arrays.deepToString(r.createNeighbours()));
    }

    @Test
    public void createNeighboursBottom() {
        r = new Ray(6, 3, 5, 3);
        assertEquals("[[5, 3], [5, 4], [6, 2], [6, 4], [7, 2], [7, 3]]", Arrays.deepToString(r.createNeighbours()));
    }

    @Test
    public void createNeighboursMiddleEdge(){
        r = new Ray(4, 8, 5, 3);
        assertEquals("[[3, 7], [3, 8], [4, 7], [4, 9], [5, 7], [5, 8]]", Arrays.deepToString(r.createNeighbours()));
    }

    @Test
    public void createNeighboursAboveEdge(){
        r = new Ray(0, 0, 5, 3);
        assertEquals("[[-1, -1], [-1, 0], [0, -1], [0, 1], [1, 0], [1, 1]]", Arrays.deepToString(r.createNeighbours()));
    }

    @Test
    public void createNeighboursBottomEdge(){
        r = new Ray(8, 4, 5, 3);
        assertEquals("[[7, 4], [7, 5], [8, 3], [8, 5], [9, 3], [9, 4]]", Arrays.deepToString(r.createNeighbours()));
    }

    @Test
    public void path() {
        r = new Ray(8,4,1,27);
        Game g = new Game(new Atom(8,0,false), new Atom(7,0,false), new Atom(6,0,false), new Atom(5,0,false));
        g.calculateRay(r);
        assertEquals(0, r.getResult());
        ArrayList<int[]> path = r.getPath();
        assertEquals("[8, 4, 1, 1]", Arrays.toString(path.getFirst()));
        assertEquals("[0, 0, 1, 1]", Arrays.toString(path.getLast()));
    }
}