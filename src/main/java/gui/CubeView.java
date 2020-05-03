package gui;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import data.Cube;

public class CubeView {
    public void draw(Screen screen, Cube cube) {
        screen.setCharacter(cube.getPosition().getX(), cube.getPosition().getY(), new TextCharacter((char) 0x25a1));
    }
}
