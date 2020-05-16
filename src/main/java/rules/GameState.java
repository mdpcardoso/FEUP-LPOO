package rules;

import gui.ArenaView;

public class GameState implements State {
    @Override
    public void execute(long frameCounter, ArenaView.COMMAND command, ArenaController controller) {
        controller.getPlayer().executeCommand(command, controller.getArena());
        controller.getCube().executeCommand(frameCounter, controller.getArena());
        controller.getOverlay().executeCommand(frameCounter, controller.getArena());
        controller.getGui().drawGame(controller.getArena());

        if (controller.getArena().getPlayerModel().getCollision()) {
            controller.setCurrentState(new GameOverState());
        }
    }
}
