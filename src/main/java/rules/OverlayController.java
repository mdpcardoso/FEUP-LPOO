package rules;

import data.ArenaModel;
import data.OverlayModel;

public class OverlayController {
    void executeCommand(long frame, ArenaModel arena) {
        OverlayModel model = arena.getOverlayModel();
        model.setScore(frame / 10);
    }
}
