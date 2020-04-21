package rules;

import data.ArenaModel;
import gui.ArenaView;

import java.io.IOException;

public class ArenaController {
    private final ArenaView gui;
    private final ArenaModel arena;

    public ArenaController(ArenaView gui, ArenaModel arena) {
        this.gui = gui;
        this.arena = arena;
    }

    public void start() throws IOException {
        while (true) {
            ArenaView.COMMAND command = gui.getCommand();

            if (command == ArenaView.COMMAND.LEFT)
                arena.setPlayerPosition(arena.getPlayerPosition().left());
            if (command == ArenaView.COMMAND.RIGHT)
                arena.setPlayerPosition(arena.getPlayerPosition().right());
            if (command == ArenaView.COMMAND.EOF) {
                gui.closeScreen();
                break;
            }
        }
    }
}
