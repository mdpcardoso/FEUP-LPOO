package rules;

import gui.ArenaView;

public class GameStartState implements State {
    @Override
    public void execute(ArenaView.COMMAND command, ArenaController controller) {
        controller.getCube().executeCommand(controller.getFrameCounter(), controller.getArena());
        controller.getGui().drawGameStart(controller.getArena());

        if (command == ArenaView.COMMAND.ACCEPT) {
            controller.getCube().removeAllCubes(controller.getArena());
            controller.setFrameCounter(0);
            controller.setCurrentState(new GameState());
        }
    }
}
