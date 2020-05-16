package data;

import java.util.ArrayList;
import java.util.List;

public class CubeModel {
    private final List<Cube> cubes;

    public CubeModel() {
        cubes = new ArrayList<>();
    }

    public List<Cube> getCubes() {
        return cubes;
    }

    public void addCube(int x, int speed) {
        cubes.add(new Cube(new Position(x, 0), speed));
    }
}
