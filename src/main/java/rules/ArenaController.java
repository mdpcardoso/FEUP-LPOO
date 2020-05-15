package rules;

import data.ArenaModel;
import gui.ArenaView;

import java.io.IOException;

public class ArenaController {
    private final ArenaView gui;
    private final PlayerController player;
    private final CubeController cube;
    private final OverlayController overlay;
    private final ArenaModel arena;

    public ArenaController(ArenaView gui, ArenaModel arena, PlayerController player, CubeController cube, OverlayController overlay) {
        this.arena = arena;
        this.gui = gui;
        this.player = player;
        this.cube = cube;
        this.overlay = overlay;
    }

    private void executeCommand(ArenaView.COMMAND command) throws IOException {
        if (command == ArenaView.COMMAND.EOF) gui.closeScreen();
    }

    public void start() throws IOException, InterruptedException {
        ArenaView.COMMAND command = ArenaView.COMMAND.NOOP;
        long frameCounter = 0;

        while (command != ArenaView.COMMAND.EOF) {
            long start = System.currentTimeMillis();

            command = gui.getCommand();

            this.executeCommand(command);
            player.executeCommand(command, arena);
            cube.executeCommand(frameCounter, arena);
            if (!arena.getPlayerModel().getCollision())
                overlay.executeCommand(frameCounter, arena);
            gui.drawArena(arena);

            frameCounter += 1;

            Thread.sleep(start + 50 - System.currentTimeMillis());
        }
    }
}
