package rules;

import gui.ArenaView;

public interface State {
    void execute(long frameCounter, ArenaView.COMMAND command, ArenaController controller);
}
