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
    public void up() {
        Position up = new Position(0, -1);
        assertEquals(up, pos.up());
    }

    @Test
    public void down() {
        Position down = new Position(0, 1);
        assertEquals(down, pos.down());
    }

    @Test
    public void right() {
        Position right = new Position(1, 0);
        assertEquals(right, pos.right());
    }

    @Test
    public void left() {
        Position left = new Position(-1, 0);
        assertEquals(left, pos.left());
    }
}