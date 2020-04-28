import data.ArenaModel;
import data.PlayerModel;
import gui.ArenaView;
import rules.ArenaController;
import rules.PlayerController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        PlayerModel playerModel = new PlayerModel(0,0);
        ArenaModel arena = new ArenaModel(60, 30, playerModel);

        ArenaView gui = new ArenaView(60, 30);
        arena.addObserver(gui);
        gui.changed(arena);

        PlayerController playerController = new PlayerController();
        ArenaController controller = new ArenaController(gui, arena, playerController);
        controller.start();
    }
}
