package rules;

import gui.ArenaView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

public class GameOverStateTest {

    @Test
    public void execute() {
        // TODO: Check for an alternative
        ArenaController controller = Mockito.mock(ArenaController.class, RETURNS_DEEP_STUBS);
        GameOverState gameOverState = new GameOverState();
        gameOverState.execute(ArenaView.COMMAND.ACCEPT, controller);

        Mockito.verify(controller.getArena().getOverlayModel()).setScore(0);
    }
}