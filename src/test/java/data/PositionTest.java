package data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {
    private Position pos;

    @Before
    public void setUp() {
        pos = new Position(0, 0);
    }

    @Test
    public void testUp() {
        Position up = new Position(0, -1);
        assertEquals(up, pos.up());
    }

    @Test
    public void testDown() {
        Position down = new Position(0, 1);
        assertEquals(down, pos.down());
    }

    @Test
    public void testRight() {
        Position right = new Position(1, 0);
        assertEquals(right, pos.right());
    }

    @Test
    public void testLeft() {
        Position left = new Position(-1, 0);
        assertEquals(left, pos.left());
    }
}