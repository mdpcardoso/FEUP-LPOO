package gui;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import data.CubeModel;

public class CubeView {
    public void draw(Screen screen, CubeModel cube) {
        char cubeChar = 0x25a1;
        screen.setCharacter(cube.getPosition().getX(), cube.getPosition().getY(), new TextCharacter(cubeChar));
    }
}
