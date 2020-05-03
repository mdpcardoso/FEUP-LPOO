package gui;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import data.PlayerModel;

public class PlayerView {
    public void draw(Screen screen, PlayerModel player) {
        char playerChar = 0x25b2;
        screen.setCharacter(player.getPosition().getX(), player.getPosition().getY(), new TextCharacter(playerChar));
    }
}
