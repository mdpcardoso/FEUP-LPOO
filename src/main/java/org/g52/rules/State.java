package org.g52.rules;

import org.g52.gui.ArenaView;

public interface State {
    void execute(ArenaView.COMMAND command, ArenaController controller);
}
