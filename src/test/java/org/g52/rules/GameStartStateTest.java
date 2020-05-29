package org.g52.rules;

import org.g52.gui.ArenaView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

public class GameStartStateTest {
    private ArenaController arenaController;
    private GameStartState gameStartState;

    @Before
    public void setup() {
        arenaController = Mockito.mock(ArenaController.class, RETURNS_DEEP_STUBS);
        gameStartState = new GameStartState();
    }

    @Test
    public void execute() {
        gameStartState.execute(ArenaView.COMMAND.ACCEPT, arenaController);

        Mockito.verify(arenaController.getGui()).drawGameStart(arenaController.getArena());
        Mockito.verify(arenaController.getCube()).executeCommand(arenaController.getFrameCounter(), arenaController.getArena());

        Mockito.verify(arenaController.getCube()).removeAllCubes(arenaController.getArena());
        Mockito.verify(arenaController).setCurrentState(ArgumentMatchers.any(GameState.class));
    }
}