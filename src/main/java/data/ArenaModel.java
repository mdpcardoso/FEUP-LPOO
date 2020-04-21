package data;

import observer.Observable;

public class ArenaModel extends Observable<ArenaModel> {
    private int width;
    private int height;
    private Player player;

    public ArenaModel(int width, int height) {
        this.width = width;
        this.height = height;
        this.player = new Player(width / 2, height - 1);
    }

    public Position getPlayerPosition() {
        return player.getPosition();
    }

    public void setPlayerPosition(Position position) {
        player.setPosition(position);
        notifyObservers(this);
    }
}
