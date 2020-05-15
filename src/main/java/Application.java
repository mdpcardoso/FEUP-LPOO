import data.ArenaModel;
import data.CubeModel;
import data.OverlayModel;
import data.PlayerModel;
import gui.ArenaView;
import rules.ArenaController;
import rules.CubeController;

import rules.OverlayController;
import rules.PlayerController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        PlayerModel playerModel = new PlayerModel(0,0);
        CubeModel cubeModel = new CubeModel();
        ArenaModel arena = new ArenaModel(60, 30, playerModel, cubeModel, new OverlayModel());

        ArenaView gui = new ArenaView(60, 30);

        PlayerController playerController = new PlayerController(playerModel);
        CubeController cubeController = new CubeController(30, 1);
        ArenaController controller = new ArenaController(gui, arena, playerController, cubeController, new OverlayController());
        controller.start();
    }
}
