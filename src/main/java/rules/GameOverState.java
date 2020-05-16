package rules;

import gui.ArenaView;

public class GameOverState implements State {
    @Override
    public void execute(long frameCounter, ArenaView.COMMAND command, ArenaController controller) {
        controller.getGui().drawGameOver(controller.getArena());
    }
}
