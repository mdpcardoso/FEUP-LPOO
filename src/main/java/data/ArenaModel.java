package data;

public class ArenaModel {
    private int width;
    private int height;
    private PlayerModel player;
    private CubeModel cube;


    public ArenaModel(int width, int height, PlayerModel player, CubeModel cube) {
        this.width = width;
        this.height = height;
        this.player = player;
        this.player.setPosition(new Position(width / 2, height - 1));

        this.cube = cube;

    }

    public PlayerModel getPlayerModel() {
        return player;
    }

    public Position getPlayerPosition() {
        return player.getPosition();
    }

    public int getPlayerVelocity() {
        return player.getVelocity();
    }

    public void setRelativePlayerVelocity(int offset) {
        player.setRelativeVelocity(offset);
    }

    public void setPlayerPosition(Position position) {
        player.setPosition(position);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public CubeModel getCubeModel(){return cube;}
}
