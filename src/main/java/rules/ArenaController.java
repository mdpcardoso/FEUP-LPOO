package rules;

import data.ArenaModel;
import gui.ArenaView;

import java.io.IOException;

public class ArenaController {
    private final ArenaView gui;
    private final PlayerController player;
    private final ArenaModel arena;

    public ArenaController(ArenaView gui, ArenaModel arena, PlayerController player) {
        this.arena = arena;
        this.gui = gui;
        this.player = player;
    }

    private void executeCommand(ArenaView.COMMAND command) throws IOException {
        if (command == ArenaView.COMMAND.EOF) gui.closeScreen();
    }

    public void start() throws IOException {
        ArenaView.COMMAND command = ArenaView.COMMAND.NOOP;

        while (command != ArenaView.COMMAND.EOF) {
            command = gui.getCommand();

            this.executeCommand(command);
            player.executeCommand(command, arena);
        }
    }
}
