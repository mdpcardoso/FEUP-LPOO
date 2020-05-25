package gui;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.TerminalScreen;
import data.NormalCube;
import data.Position;
import org.junit.Test;
import org.mockito.Mockito;

public class CubeViewTest {

    @Test
    public void drawNormalCube() {
        TerminalScreen screen = Mockito.mock(TerminalScreen.class);
        NormalCube cube = Mockito.mock(NormalCube.class);

        Mockito.when(cube.getPosition()).thenReturn(new Position(1, 2));

        CubeView cubeView = new CubeView();
        cubeView.draw(screen, cube);

        Mockito.verify(screen, Mockito.times(1))
                .setCharacter(1, 2, new TextCharacter((char)0x25a1));
    }
}