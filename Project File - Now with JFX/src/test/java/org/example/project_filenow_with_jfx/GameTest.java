package org.example.project_filenow_with_jfx;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    // Test atom hit cases

    Game g = new Game();
    Ray r = new Ray(4,4,1,27);

    @Test
    public void setAtoms() {
        g.setAtoms(new Atom(1,1,false), new Atom(2, 2, false));
        assertEquals(g.trueAtoms[0], (new Atom(1, 1, false)));
        assertEquals(g.trueAtoms[1], (new Atom(2, 2, false)));
    }

    @Test
    public void setAtomsRand(){
        g.setAtoms();
        assertEquals(4, g.trueAtoms.length);
    }

    @Test
    public void checkReturn() {
        g.setAtoms(new Atom(4,3, false), new Atom(3,4, false));
        g.calculateRay(r);
        assertEquals(-2, r.getResult());
    }

    @Test
    public void checkDoubleBounce() {
        //test 1
        g.setAtoms(new Atom(4,3, false), new Atom(3,3, false));
        g.calculateRay(r);
        assertEquals(36, r.getResult());

        //test 2
        g.setAtoms(new Atom(3,3, false), new Atom(3,4, false));
        g.calculateRay(r);
        assertEquals(18, r.getResult());
    }

    @Test
    public void checkBounce() {
        // test 1
        g.setAtoms(new Atom(4,3, false));
        g.calculateRay(r);
        assertEquals(45, r.getResult());

        //test 2
        g.setAtoms(new Atom(3,4, false));
        g.calculateRay(r);
        assertEquals(9, r.getResult());
    }

    @Test
    public void checkHit() {
        g.setAtoms(new Atom(3,3, false));
        g.calculateRay(r);
        assertEquals(-1, r.getResult());
    }
}