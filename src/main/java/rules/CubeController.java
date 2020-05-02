package rules;

import data.ArenaModel;
import data.CubeModel;
import data.Cube;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CubeController {
    private int cubeAmount;
    private int maxSpeed;

    public CubeController(int cubeAmount, int maxSpeed) {
        this.cubeAmount = cubeAmount;
        this.maxSpeed = maxSpeed;
    }

    private void cubeFlow(ArenaModel arena) {
        makeNewCubes(arena);
        makeCubesFall(arena);
        removeFallenCubes(arena);
    }

    private void makeNewCubes(ArenaModel arena) {
        CubeModel cube = arena.getCubeModel();

        if (cube.getCubes().size() < cubeAmount) {
            Random random = new Random();
            cube.addCube(random.nextInt(arena.getWidth()), this.maxSpeed);
        }
    }

    private void makeCubesFall(ArenaModel arena) {
        CubeModel cubeModel = arena.getCubeModel();

        List<Cube> cubes = cubeModel.getCubes();
        for (Cube cube : cubes)
            cube.setPosition(cube.getPosition().verticalBy(cube.getSpeed()));
    }

    private void removeFallenCubes(ArenaModel arena) {
        CubeModel cubeModel = arena.getCubeModel();

        List<Cube> cubes = cubeModel.getCubes();
        List<Cube> toRemove = new ArrayList<>();

        for (Cube cube : cubes)
            if (cube.getPosition().getY() == arena.getHeight())
                toRemove.add(cube);

        cubes.removeAll(toRemove);
    }

    public void executeCommand(long frames, ArenaModel arena) {
        if (frames % 2 == 0) {
            cubeFlow(arena);
        }
    }
}
