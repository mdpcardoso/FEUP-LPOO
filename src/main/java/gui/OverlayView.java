package gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import data.OverlayModel;

public class OverlayView {
    public void draw(Screen screen, OverlayModel overlay) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.ANSI.RED);
        textGraphics.putString(4, 2, String.valueOf(overlay.getScore()));
    }
}
