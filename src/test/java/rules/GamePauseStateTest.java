package rules;

import gui.ArenaView;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

public class GamePauseStateTest {

    @Test
    public void execute() {
        ArenaController arenaController = Mockito.mock(ArenaController.class, RETURNS_DEEP_STUBS);
        GamePauseState gamePauseState = new GamePauseState();
        gamePauseState.execute(ArenaView.COMMAND.ACCEPT, arenaController);

        Mockito.verify(arenaController.getGui()).drawGamePause(arenaController.getArena());
        Mockito.verify(arenaController).setCurrentState(ArgumentMatchers.any(GameState.class));
    }

    @Test
    public void executeNoAccept() {
        ArenaController arenaController = Mockito.mock(ArenaController.class, RETURNS_DEEP_STUBS);
        GamePauseState gamePauseState = new GamePauseState();
        gamePauseState.execute(ArenaView.COMMAND.EOF, arenaController);

        Mockito.verify(arenaController.getGui()).drawGamePause(arenaController.getArena());
        Mockito.verify(arenaController, Mockito.never()).setCurrentState(ArgumentMatchers.any(GameState.class));
    }
}