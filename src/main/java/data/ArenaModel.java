package data;

import observer.Observable;

public class ArenaModel extends Observable<ArenaModel> {
    private int width;
    private int height;
    private PlayerModel player;

    public ArenaModel(int width, int height, PlayerModel player) {
        this.width = width;
        this.height = height;
        this.player = player;
        this.player.setPosition(new Position(width / 2, height - 1));
    }

    public PlayerModel getPlayerModel() {
        return player;
    }

    public Position getPlayerPosition() {
        return player.getPosition();
    }

    public void setPlayerPosition(Position position) {
        player.setPosition(position);
        notifyObservers(this);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
