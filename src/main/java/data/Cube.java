package data;

public class Cube extends Element {
    private final int speed;

    public Cube(Position position, int speed) {
        super(position.getX(), position.getY());
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
