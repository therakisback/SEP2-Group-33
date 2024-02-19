import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtomTest {

    Atom a;

    @Test
    void Atom() {
        // Location testing in constructor
        assertThrows(IllegalArgumentException.class, () -> {
            Atom a = new Atom(-1, false);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Atom a = new Atom(70, false);
        });
        // Booleans not necessary to test as IDEs don't allow
        //  improper boolean input
    }

    @Test
    void getLoc() {
        a = new Atom(3, false);
        assertEquals(3, a.getLoc());
    }

    @Test
    void isFlag() {
        a = new Atom(3, false);
        assertFalse(a.isFlag());
        a = new Atom(3, true);
        assertTrue(a.isFlag());
    }

    @Test
    void getLocations() {
        Atom[] aArray = {new Atom(1, false), new Atom(2, false), new Atom(3, false), new Atom(4, false)};
        int[] locs = Atom.getLocations(aArray);
        assertEquals(1, locs[0]);
        assertEquals(2, locs[1]);
        assertEquals(3, locs[2]);
        assertEquals(4, locs[3]);
    }
}