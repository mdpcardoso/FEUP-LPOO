package data;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ArenaModelTest {
    private ArenaModel arenaModel;
    private PlayerModel playerModel;

    @Before
    public void setUp() {
        playerModel = Mockito.mock(PlayerModel.class);
        arenaModel = new ArenaModel(10, 15, playerModel);
    }

    @Test
    public void testConstructor() {
        Mockito.when(playerModel.getPosition()).thenReturn(new Position(5, 14));

        assertEquals(10, arenaModel.getWidth());
        assertEquals(15, arenaModel.getHeight());
        assertEquals(new Position(5, 14), arenaModel.getPlayerPosition());
    }

    @Test
    public void testSetPlayerPosition() {
        Mockito.when(playerModel.getPosition()).thenReturn(new Position(1, 2));
        arenaModel.setPlayerPosition(new Position(1, 2));

        assertEquals(new Position(1, 2), arenaModel.getPlayerPosition());
    }
}