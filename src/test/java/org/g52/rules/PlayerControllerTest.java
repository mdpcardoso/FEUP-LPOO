package org.g52.rules;

import org.g52.data.*;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerControllerTest {

    @Test
    public void checkCollision() {
        PlayerModel playerModel = Mockito.mock(PlayerModel.class);
        Mockito.when(playerModel.getPosition()).thenReturn(new Position(10, 10));

        CubeModel cubeModel = new CubeModel();
        NormalCube normalCube = Mockito.mock(NormalCube.class);
        Mockito.when(normalCube.getPosition()).thenReturn(new Position(10, 10));
        cubeModel.addCube(normalCube);

        ArenaModel arenaModel = new ArenaModel(60, 30, playerModel, cubeModel, new OverlayModel());
        PlayerController playerController = new PlayerController();
        assertEquals(normalCube, playerController.checkCollision(arenaModel));
    }

    @Test
    public void checkNoCollision() {
        PlayerModel playerModel = Mockito.mock(PlayerModel.class);
        Mockito.when(playerModel.getPosition()).thenReturn(new Position(10, 10));

        CubeModel cubeModel = new CubeModel();
        NormalCube normalCube = Mockito.mock(NormalCube.class);
        Mockito.when(normalCube.getPosition()).thenReturn(new Position(20, 20));
        cubeModel.addCube(normalCube);

        ArenaModel arenaModel = new ArenaModel(60, 30, playerModel, cubeModel, new OverlayModel());
        PlayerController playerController = new PlayerController();
        assertNull(playerController.checkCollision(arenaModel));
    }
}