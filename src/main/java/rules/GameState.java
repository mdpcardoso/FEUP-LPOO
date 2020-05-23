package rules;

import data.NormalCube;
import data.Position;
import data.PowerCube;
import gui.ArenaView;

public class GameState implements State {
    @Override
    public void execute(ArenaView.COMMAND command, ArenaController controller) {
        controller.getPlayer().executeCommand(command, controller.getArena());
        controller.getCube().executeCommand(controller.getFrameCounter(), controller.getArena());
        controller.getOverlay().executeCommand(controller.getArena());
        controller.getGui().drawGame(controller.getArena());

        if (controller.getPlayer().checkCollision(controller.getArena()) instanceof NormalCube) {
            controller.getCube().removeAllCubes(controller.getArena());
            controller.getArena().setPlayerPosition(new Position(controller.getArena().getWidth() / 2, controller.getArena().getHeight() - 1));

            controller.setCurrentState(new GameOverState());
        } else if (controller.getPlayer().checkCollision(controller.getArena()) instanceof PowerCube) {
            controller.getArena().getOverlayModel().setScore(controller.getArena().getOverlayModel().getScore() + 1000);
        } else if (command == ArenaView.COMMAND.ACCEPT) {
            controller.setCurrentState(new GamePauseState());
        }
    }
}
