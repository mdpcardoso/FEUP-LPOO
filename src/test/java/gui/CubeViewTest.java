package gui;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.TerminalScreen;
import data.CubeModel;
import data.Position;
import org.junit.Test;
import org.mockito.Mockito;

public class CubeViewTest {

    @Test
    public void draw() {
        TerminalScreen screen = Mockito.mock(TerminalScreen.class);
        CubeModel cubeModel = Mockito.mock(CubeModel.class);

        Mockito.when(cubeModel.getPosition()).thenReturn(new Position(1, 2));

        CubeView cubeView = new CubeView();
        cubeView.draw(screen, cubeModel);

        Mockito.verify(screen, Mockito.times(1))
                .setCharacter(1, 2, new TextCharacter((char)0x25a1));
    }
}