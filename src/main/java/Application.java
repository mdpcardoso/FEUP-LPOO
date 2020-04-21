import data.ArenaModel;
import gui.ArenaView;
import rules.ArenaController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        ArenaModel arena = new ArenaModel(60, 30);
        ArenaView gui = new ArenaView(60, 30);
        gui.changed(arena);
        arena.addObserver(gui);

        ArenaController controller = new ArenaController(gui, arena);
        controller.start();
    }
}
