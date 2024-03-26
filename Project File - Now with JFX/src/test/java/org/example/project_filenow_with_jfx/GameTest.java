package org.example.project_filenow_with_jfx;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    // Test atom hit cases

    @Test
    public void checkReturn() {
        Ray r = new Ray(4,4,1,-1);
        boolean[] neighbors = {true, true, false, false, false, false};

        assertTrue(checkReturn(r, neighbors));
    }

    @Test
    public void checkDoubleBounce() {

    }

    @Test
    public void checkBounce() {

    }

    @Test
    public void hit() {

    }

    // Test ray moving correctly

    @Test
    public void moveRay() {

    }

    // Test edge hit cases

    @Test
    public void dir1() {

    }

    @Test
    public void dir2() {

    }

    @Test
    public void dir3() {

    }

    @Test
    public void dir4() {

    }

    @Test
    public void dir5() {

    }

    @Test
    public void dir6() {

    }

}