package gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import data.ArenaModel;

public class GameStartView {
    public void draw(Screen screen, ArenaModel arena) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.ANSI.GREEN);
        textGraphics.putString(arena.getWidth() / 2 - 5, arena.getHeight() / 2, "CUBEFIELD");
        textGraphics.putString(arena.getWidth() / 2 - 10, arena.getHeight() / 2 + 4, "PRESS ENTER TO START");
    }
}
