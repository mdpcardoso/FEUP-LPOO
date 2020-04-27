package rules;

import data.ArenaModel;
import gui.ArenaView;

public class PlayerController {
    public void executeCommand(ArenaView.COMMAND command, ArenaModel arena) {
        if (command == ArenaView.COMMAND.LEFT)
            arena.setPlayerPosition(arena.getPlayerPosition().left());
        if (command == ArenaView.COMMAND.RIGHT)
            arena.setPlayerPosition(arena.getPlayerPosition().right());
    }
}
