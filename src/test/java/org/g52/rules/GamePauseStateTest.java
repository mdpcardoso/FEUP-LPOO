package org.g52.rules;

import org.g52.gui.ArenaView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

public class GamePauseStateTest {
    private ArenaController arenaController;
    private GamePauseState gamePauseState;

    @Before
    public void setup() {
        arenaController = Mockito.mock(ArenaController.class, RETURNS_DEEP_STUBS);
        gamePauseState = new GamePauseState();
    }

    @Test
    public void execute() {
        gamePauseState.execute(ArenaView.COMMAND.ACCEPT, arenaController);

        Mockito.verify(arenaController.getGui()).drawGamePause(arenaController.getArena());
        Mockito.verify(arenaController).setCurrentState(ArgumentMatchers.any(GameState.class));
    }

    @Test
    public void executeNoAccept() {
        gamePauseState.execute(ArenaView.COMMAND.EOF, arenaController);

        Mockito.verify(arenaController.getGui()).drawGamePause(arenaController.getArena());
        Mockito.verify(arenaController, Mockito.never()).setCurrentState(ArgumentMatchers.any(GameState.class));
    }
}