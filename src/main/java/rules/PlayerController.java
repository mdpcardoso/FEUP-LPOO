package rules;

import data.ArenaModel;
import gui.ArenaView;

public class PlayerController {
    private ArenaModel arena;
    private ArenaView view;

    public PlayerController(ArenaModel arena) {
        this.arena = arena;
    }

    public void executeCommand(ArenaView.COMMAND command) {
        if (command == ArenaView.COMMAND.LEFT)
            arena.setPlayerPosition(arena.getPlayerPosition().left());
        if (command == ArenaView.COMMAND.RIGHT)
            arena.setPlayerPosition(arena.getPlayerPosition().right());
    }
}
