package gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import data.ArenaModel;
import data.Cube;


import java.io.IOException;

public class ArenaView {
    private Screen screen;
    private PlayerView player;
    private CubeView cubeView;
    private OverlayView overlay;
    private GameOverView gameover;

    public enum COMMAND {RIGHT, LEFT, EOF, NOOP}

    public ArenaView(int width, int height) throws IOException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height));
        Terminal terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        player = new PlayerView();
        cubeView = new CubeView();
        overlay = new OverlayView();
        gameover = new GameOverView();
    }

    public void drawGame(ArenaModel arena) {
        screen.clear();

        for (Cube cube : arena.getCubeModel().getCubes()) {
            cubeView.draw(screen, cube);
        }

        player.draw(screen, arena.getPlayerModel());
        overlay.draw(screen, arena.getOverlayModel());

        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawGameOver(ArenaModel arena) {
        screen.clear();

        gameover.draw(screen, arena, arena.getOverlayModel());

        try {
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeScreen() throws IOException {
        screen.close();
    }

    public COMMAND getCommand() throws IOException {
        KeyStroke key = screen.pollInput();

        if (key == null) return COMMAND.NOOP;
        if (key.getKeyType() == KeyType.ArrowRight) return COMMAND.RIGHT;
        if (key.getKeyType() == KeyType.ArrowLeft) return COMMAND.LEFT;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') return COMMAND.EOF;
        if (key.getKeyType() == KeyType.EOF) return COMMAND.EOF;

        return COMMAND.NOOP;
    }
}
