package org.g52.rules;

import org.g52.gui.ArenaView;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

public class GameOverStateTest {

    @Test
    public void execute() {
        // TODO: Check for an alternative
        ArenaController controller = Mockito.mock(ArenaController.class, RETURNS_DEEP_STUBS);
        GameOverState gameOverState = new GameOverState();
        gameOverState.execute(ArenaView.COMMAND.ACCEPT, controller);

        Mockito.verify(controller.getGui()).drawGameOver(controller.getArena());
        Mockito.verify(controller.getArena().getOverlayModel()).setScore(0);
        Mockito.verify(controller).setCurrentState(ArgumentMatchers.any(GameState.class));
    }

    @Test
    public void executeNoAccept() {
        // TODO: Check for an alternative
        ArenaController controller = Mockito.mock(ArenaController.class, RETURNS_DEEP_STUBS);
        GameOverState gameOverState = new GameOverState();
        gameOverState.execute(ArenaView.COMMAND.EOF, controller);

        Mockito.verify(controller.getGui()).drawGameOver(controller.getArena());
        Mockito.verify(controller.getArena().getOverlayModel(), Mockito.never()).setScore(0);
        Mockito.verify(controller, Mockito.never()).setCurrentState(ArgumentMatchers.any(GameState.class));
    }
}