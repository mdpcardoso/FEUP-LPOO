import data.ArenaModel;
import data.CubeModel;
import data.OverlayModel;
import data.PlayerModel;
import gui.ArenaView;
import gui.ViewFactory;
import rules.*;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        PlayerModel playerModel = new PlayerModel(0,0);
        CubeModel cubeModel = new CubeModel();
        ArenaModel arena = new ArenaModel(60, 30, playerModel, cubeModel, new OverlayModel());

        ViewFactory viewFactory = new ViewFactory();
        ArenaView gui = new ArenaView(60, 30, viewFactory);

        ControllerFactory controllerFactory = new ControllerFactory();
        ArenaController controller = new ArenaController(gui, arena, controllerFactory);
        controller.start();
    }
}
