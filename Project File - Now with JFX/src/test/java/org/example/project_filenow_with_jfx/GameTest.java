package org.example.project_filenow_with_jfx;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    // Test atom hit cases

    Game g;

    @Test
    public void checkReturn() {
        g = new Game();
        Ray r = new Ray(8,4,1,27);
        g.setAtoms(new Atom(4,3, false), new Atom(3,4, false));
        g.calculateRay(r);
        assertEquals(-2, r.getResult());
    }

    @Test
    public void checkDoubleBounce() {
        //test 1
        g = new Game();
        Ray r = new Ray(8,4,1,27);
        g.setAtoms(new Atom(4,3, false), new Atom(3,3, false));
        g.calculateRay(r);
        assertEquals(36, r.getResult());

        //test 2
        g = new Game();
        r = new Ray(8,4,1,27);
        g.setAtoms(new Atom(3,3, false), new Atom(3,4, false));
        g.calculateRay(r);
        assertEquals(18, r.getResult());
    }

    @Test
    public void checkBounce() {
        // test 1
        g = new Game();
        Ray r = new Ray(8,4,1,27);
        g.setAtoms(new Atom(4,3, false));
        g.calculateRay(r);
        assertEquals(45, r.getResult());

        //test 2
        g = new Game();
        r = new Ray(8,4,1,27);
        g.setAtoms(new Atom(3,4, false));
        g.calculateRay(r);
        assertEquals(9, r.getResult());
    }

    @Test
    public void checkHit() {
        g = new Game();
        Ray r = new Ray(8,4,1,27);
        g.setAtoms(new Atom(3,3, false));
        g.calculateRay(r);
        assertEquals(-1, r.getResult());
    }

    @Test
    public void complexPath() {
        g = new Game();
        Ray r = new Ray(8,4, 1, 27);
        g.setAtoms(
                   new Atom(4, 5, false),
                   new Atom(6, 2, false)
                   );
        g.calculateRay(r);
        assertEquals(2, r.getResult());
    }
}