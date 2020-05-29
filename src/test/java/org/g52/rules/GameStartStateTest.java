package org.g52.rules;

import org.g52.data.*;
import org.g52.gui.ArenaView;
import org.g52.gui.ViewFactory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

public class GameStartStateTest {
    private GameStartState gameStartState;
    private ArenaController arenaController;
    private ArenaModel arenaModel;

    @Before
    public void setup() {
        PlayerModel playerModel = new PlayerModel(5, 5);
        CubeModel cubeModel = new CubeModel();
        cubeModel.addCube(new NormalCube(new Position(1, 2), 1));
        OverlayModel overlayModel = new OverlayModel();
        arenaModel = new ArenaModel(10, 10, playerModel, cubeModel, overlayModel);

        ControllerFactory controllerFactory = new ControllerFactory();
        arenaController = new ArenaController(Mockito.mock(ArenaView.class), arenaModel, controllerFactory);

        gameStartState = new GameStartState();
    }

    @Test
    public void execute() {
        gameStartState.execute(ArenaView.COMMAND.ACCEPT, arenaController);

        assertEquals(GameState.class, arenaController.getCurrentState().getClass());
        assertEquals(0, arenaModel.getCubeModel().getCubes().size());
    }

    @Test
    public void executeNoAccept() {
        gameStartState.execute(ArenaView.COMMAND.EOF, arenaController);

        assertEquals(GameStartState.class, arenaController.getCurrentState().getClass());
        assertEquals(2, arenaModel.getCubeModel().getCubes().size());
        assertEquals(new Position(1, 3), arenaModel.getCubeModel().getCubes().get(0).getPosition());
    }
}