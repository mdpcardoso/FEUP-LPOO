package gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import data.ArenaModel;
import data.OverlayModel;


public class GameOverView {
    public void draw(Screen screen, ArenaModel arena, OverlayModel overlay) {
        final long score = overlay.getScore();
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.ANSI.RED);
        textGraphics.putString(arena.getWidth() / 2 - 3, arena.getHeight() / 2 - 3, "SCORE: ");
        textGraphics.putString(arena.getWidth() / 2 + 3, arena.getHeight() / 2 - 3, String.valueOf(score));
        textGraphics.putString(arena.getWidth() / 2 - 4, arena.getHeight() / 2, "GAME OVER");
        textGraphics.putString(arena.getWidth() / 2 - 7, arena.getHeight() / 2 + 3, "PRESS Q TO EXIT");
    }
}
