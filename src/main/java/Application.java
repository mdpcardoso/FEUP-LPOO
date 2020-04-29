import data.ArenaModel;
import data.CubeModel;
import data.PlayerModel;
import data.Position;
import gui.ArenaView;
import rules.ArenaController;
import rules.CubeController;

import rules.PlayerController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        PlayerModel playerModel = new PlayerModel(0,0);
        Position position = new Position(10, 15);
        CubeModel cubeModel = new CubeModel(position, 3);
        ArenaModel arena = new ArenaModel(60, 30, playerModel, cubeModel);


        ArenaView gui = new ArenaView(60, 30);
        arena.addObserver(gui);
        gui.changed(arena);

        PlayerController playerController = new PlayerController();
        CubeController cubeController = new CubeController(arena, gui, 10, 20);
        ArenaController controller = new ArenaController(gui, arena, playerController);
        controller.start();
    }
}
