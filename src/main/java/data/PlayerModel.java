package data;

public class PlayerModel extends Element {
    private int velocity;
    private boolean collision;

    public PlayerModel(int x, int y) {
        super(x, y);
        velocity = 0;
        collision = false;
    }

    public int getVelocity() {
        return velocity;
    }

    public boolean getCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public void setRelativeVelocity(int offset) {
        this.velocity = velocity + offset;
    }
}
