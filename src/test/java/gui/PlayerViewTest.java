package gui;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.TerminalScreen;
import data.PlayerModel;
import data.Position;
import org.junit.Test;
import org.mockito.Mockito;

public class PlayerViewTest {

    @Test
    public void testDraw() {
        TerminalScreen screen = Mockito.mock(TerminalScreen.class);
        PlayerModel playerModel = Mockito.mock(PlayerModel.class);

        Mockito.when(playerModel.getPosition()).thenReturn(new Position(1, 2));

        PlayerView playerView = new PlayerView();
        playerView.draw(screen, playerModel);

        Mockito.verify(screen, Mockito.times(1))
                .setCharacter(1, 2, new TextCharacter('^'));
    }
}