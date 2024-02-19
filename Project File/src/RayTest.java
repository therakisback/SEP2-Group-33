import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RayTest {

    Ray r;

    @Test
    void Ray() {
        // Location Tests
        r = new Ray (5, 3, 3);
        assertEquals(5, r.getLoc());
        assertThrows(IllegalArgumentException.class, () -> {
            Ray r = new Ray(-1, 3, 3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Ray r = new Ray(70, 3, 3);
        });

        // Direction Tests
        r = new Ray (0, 5, 3);
        assertEquals(5, r.getDir());
        assertThrows(IllegalArgumentException.class, () -> {
            Ray r = new Ray(0, -1, 3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Ray r = new Ray(0, 7, 3);
        });

        // Start Tests
        r = new Ray (0, 3, 5);
        assertEquals(5, r.getStart());
        assertThrows(IllegalArgumentException.class, () -> {
            Ray r = new Ray(0, 3, -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Ray r = new Ray(0, -1, 70);
        });
    }

    @Test
    void getDir() {
        r = new Ray(0, 5, 3);
        assertEquals(5, r.getDir());
    }

    @Test
    void getLoc() {
        r = new Ray (5, 3, 3);
        assertEquals(5, r.getLoc());
    }

    @Test
    void getStart() {
        r = new Ray (0, 3, 5);
        assertEquals(5, r.getStart());
    }

    @Test
    void getResult() {
        // Testing get and set result in set test method
    }

    @Test
    void setDir() {
        r = new Ray(0, 3 ,3);
        assertEquals(3, r.getDir());
        r.setDir(5);
        assertEquals(5, r.getDir());
    }

    @Test
    void setLoc() {
        r = new Ray(0, 3, 3);
        assertEquals(3, r.getLoc());
        r.setLoc(5);
        assertEquals(5, r.getLoc());
    }

    @Test
    void setResult() {
        r = new Ray(0, 3, 3);
        r.setResult(5);
        assertEquals(5, r.getResult());
    }
}