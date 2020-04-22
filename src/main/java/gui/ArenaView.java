package gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import data.ArenaModel;
import observer.Observer;

import java.io.IOException;

public class ArenaView implements Observer<ArenaModel> {
    private Screen screen;
    private PlayerView player;

    public enum COMMAND {RIGHT, LEFT, EOF}

    public ArenaView(int width, int height) throws IOException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height));
        Terminal terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        player = new PlayerView();
    }

    @Override
    public void changed(ArenaModel subject) {
        drawArena(subject);
    }

    private void drawArena(ArenaModel arena) {
        try {
            screen.clear();
            player.draw(screen, arena.getPlayerModel());
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeScreen() throws IOException {
        screen.close();
    }

    public COMMAND getCommand() throws IOException {
        while (true) {
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.ArrowRight) return COMMAND.RIGHT;
            if (key.getKeyType() == KeyType.ArrowLeft) return COMMAND.LEFT;
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') return COMMAND.EOF;
            if (key.getKeyType() == KeyType.EOF) return COMMAND.EOF;
        }
    }
}
