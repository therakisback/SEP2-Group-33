import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AtomTest {

    Atom a;

    @Test
    void Atom() {
        // Location testing in constructor
        assertThrows(IllegalArgumentException.class, () -> {
            Atom a = new Atom(-1, 3, false);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Atom a = new Atom(70, 3, false);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Atom a = new Atom(3, -1, false);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Atom a = new Atom(3, 70, false);
        });
        // Booleans not necessary to test as IDEs don't allow
        //  improper boolean input
    }

    @Test
    void getLoc() {
        a = new Atom(3, 5, false);
        assertEquals(3, a.getRow());
        assertEquals(5, a.getCol());
    }

    @Test
    void isFlag() {
        a = new Atom(3, 5, false);
        assertFalse(a.isFlag());
        a = new Atom(3, 5, true);
        assertTrue(a.isFlag());
    }

    @Test
    void getLocations() {
        Atom[] aArray = {new Atom(1, 1, false), new Atom(2, 2, false), new Atom(3, 3, false), new Atom(4, 4, false)};
        int[][] locs = Atom.getLocations(aArray);
        assertEquals(1, locs[0][0]);
        assertEquals(2, locs[1][0]);
        assertEquals(3, locs[2][0]);
        assertEquals(4, locs[3][0]);
    }

}
