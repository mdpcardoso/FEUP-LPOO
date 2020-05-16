package rules;

import gui.ArenaView;

public interface State {
    void execute(ArenaView.COMMAND command, ArenaController controller);
}
