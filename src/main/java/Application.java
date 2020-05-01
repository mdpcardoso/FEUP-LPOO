import data.ArenaModel;
import data.CubeModel;
import data.PlayerModel;
import gui.ArenaView;
import rules.ArenaController;
import rules.CubeController;

import rules.PlayerController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        PlayerModel playerModel = new PlayerModel(0,0);
        CubeModel cubeModel = new CubeModel();
        ArenaModel arena = new ArenaModel(60, 30, playerModel, cubeModel);

        ArenaView gui = new ArenaView(60, 30);

        PlayerController playerController = new PlayerController();
        CubeController cubeController = new CubeController(30, 1);
        ArenaController controller = new ArenaController(gui, arena, playerController, cubeController);
        controller.start();

    }
}
