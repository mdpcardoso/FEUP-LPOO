package gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import data.ArenaModel;

public class GamePauseView {
    public void draw(Screen screen, ArenaModel arena) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#575757"));
        textGraphics.fillRectangle(new TerminalPosition(17, 13), new TerminalSize(27, 7), ' ');
        textGraphics.putString(arena.getWidth() / 2 - 3, arena.getHeight() / 2, "PAUSED");
        textGraphics.putString(arena.getWidth() / 2 - 10, arena.getHeight() / 2 + 2, "PRESS ENTER TO RESUME");
    }
}
