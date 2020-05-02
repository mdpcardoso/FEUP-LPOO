package gui;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import data.PlayerModel;

public class CollisionView {
    public void draw(Screen screen, PlayerModel player) {
        char collisionChar = 0x2749;
        screen.setCharacter(player.getPosition().getX(), player.getPosition().getY(), new TextCharacter(collisionChar));
    }
}
