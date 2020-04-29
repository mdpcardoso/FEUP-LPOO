package data;

import java.util.ArrayList;
import java.util.List;

public class CubeModel extends Cube{
    private List<Cube> cubes;

    public CubeModel(Position position, int speed){
        super(position, speed);
        cubes = new ArrayList<>();
    }

    public List<Cube> getCubes() {
        return cubes;
    }

    public void addCube(int x, int speed) {
        cubes.add(new Cube(new Position(x, 0), speed));
    }


}
