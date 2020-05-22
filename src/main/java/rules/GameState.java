package rules;

import data.Position;
import gui.ArenaView;

public class GameState implements State {
    @Override
    public void execute(ArenaView.COMMAND command, ArenaController controller) {
        controller.getPlayer().executeCommand(command, controller.getArena());
        controller.getCube().executeCommand(controller.getFrameCounter(), controller.getArena());
        controller.getOverlay().executeCommand(controller.getArena());
        controller.getGui().drawGame(controller.getArena());

        if (controller.getArena().getPlayerModel().getCollision()) {
            controller.getCube().removeAllCubes(controller.getArena());
            controller.getArena().setPlayerPosition(new Position(controller.getArena().getWidth() / 2, controller.getArena().getHeight() - 1));

            controller.setCurrentState(new GameOverState());
        } else if (command == ArenaView.COMMAND.ACCEPT) {
            controller.setCurrentState(new GamePauseState());
        }
    }
}
