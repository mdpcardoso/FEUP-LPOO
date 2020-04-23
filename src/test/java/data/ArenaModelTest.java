package data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArenaModelTest {
    private ArenaModel arenaModel;

    @Before
    public void setUp() {
        arenaModel = new ArenaModel(10, 15);
    }

    @Test
    public void testConstructor() {
        assertEquals(10, arenaModel.getWidth());
        assertEquals(15, arenaModel.getHeight());
        assertEquals(new Position(5, 14), arenaModel.getPlayerPosition());
    }

    @Test
    public void testSetPlayerPosition() {
        arenaModel.setPlayerPosition(new Position(1, 2));

        assertEquals(new Position(1, 2), arenaModel.getPlayerPosition());
    }
}