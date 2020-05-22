package rules;

import data.ArenaModel;
import data.OverlayModel;

public class OverlayController {
    public void executeCommand(ArenaModel arena) {
        OverlayModel model = arena.getOverlayModel();
        model.setScore(model.getScore() + 1);
    }
}
