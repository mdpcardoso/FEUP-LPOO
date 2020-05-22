package rules;

import gui.ArenaView;

public class GameOverState implements State {
    @Override
    public void execute(ArenaView.COMMAND command, ArenaController controller) {
        controller.getGui().drawGameOver(controller.getArena());

        if (command == ArenaView.COMMAND.ACCEPT) {
            controller.getArena().getOverlayModel().setScore(0);
            controller.setCurrentState(new GameState());
        }
    }
}
