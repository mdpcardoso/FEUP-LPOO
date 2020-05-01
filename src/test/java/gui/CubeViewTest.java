package gui;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.TerminalScreen;
import data.Cube;
import data.Position;
import org.junit.Test;
import org.mockito.Mockito;

public class CubeViewTest {

    @Test
    public void draw() {
        TerminalScreen screen = Mockito.mock(TerminalScreen.class);
        Cube cube = Mockito.mock(Cube.class);

        Mockito.when(cube.getPosition()).thenReturn(new Position(1, 2));

        CubeView cubeView = new CubeView();
        cubeView.draw(screen, cube);

        Mockito.verify(screen, Mockito.times(1))
                .setCharacter(1, 2, new TextCharacter((char)0x25a1));
    }
}