package data;

public class Cube {
    private Position position;
    private int speed;

    public Cube(Position position, int speed) {
        this.position = position;
        this.speed = speed;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getSpeed() {
        return speed;
    }
}
