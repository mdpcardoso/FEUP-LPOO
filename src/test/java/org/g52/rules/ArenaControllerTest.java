package org.g52.rules;

import org.g52.data.ArenaModel;
import org.g52.gui.ArenaView;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class ArenaControllerTest {

    @Test
    public void executeCommandEOF() throws IOException {
        ArenaModel arenaModel = Mockito.mock(ArenaModel.class);
        ControllerFactory factory = Mockito.mock(ControllerFactory.class);
        ArenaView gui = Mockito.mock(ArenaView.class);

        ArenaController arenaController = new ArenaController(gui, arenaModel, factory);

        arenaController.executeCommand(ArenaView.COMMAND.EOF);
        Mockito.verify(gui).closeScreen();
    }

    @Test
    public void executeCommandNoEOF() throws IOException {
        ArenaModel arenaModel = Mockito.mock(ArenaModel.class);
        ControllerFactory factory = Mockito.mock(ControllerFactory.class);
        ArenaView gui = Mockito.mock(ArenaView.class);

        ArenaController arenaController = new ArenaController(gui, arenaModel, factory);

        arenaController.executeCommand(ArenaView.COMMAND.ACCEPT);
        Mockito.verify(gui, Mockito.times(0)).closeScreen();
    }
}