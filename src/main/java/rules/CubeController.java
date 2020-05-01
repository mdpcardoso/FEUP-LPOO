package rules;

import data.ArenaModel;
import data.CubeModel;
import data.Cube;
import gui.ArenaView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CubeController {
    private ArenaModel model;
    private ArenaView view;

    private int cubeAmount;
    private int maxSpeed;

    public CubeController(ArenaModel model, ArenaView view, int cubeAmount, int maxSpeed) {
        this.model = model;
        this.view = view;

        this.cubeAmount = cubeAmount;
        this.maxSpeed = maxSpeed;
    }

    private void cubeFlow() {
        makeCubesFall();
        removeFallenCubes();
        makeNewCubes();
    }

    private void makeNewCubes() {
        CubeModel cube = model.getCubeModel();

        if (cube.getCubes().size() < cubeAmount) {
            Random random = new Random();
            cube.addCube(random.nextInt(model.getWidth()), random.nextInt(maxSpeed) + 1);
        }
    }

    private void makeCubesFall() {
        CubeModel cubeModel = model.getCubeModel();

        List<Cube> cubes = cubeModel.getCubes();
        for (Cube cube : cubes)
            cube.setPosition(cube.getPosition().down());
    }

    private void removeFallenCubes() {
        CubeModel cubeModel = model.getCubeModel();

        List<Cube> cubes = cubeModel.getCubes();
        List<Cube> toRemove = new ArrayList<>();

        for (Cube cube : cubes)
            if (cube.getPosition().getY() == model.getHeight())
                toRemove.add(cube);

        cubes.removeAll(toRemove);
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    cubeFlow();
                    /*
                    try {
                        view.draw();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    */

                }
            }
        }).start();
    }
}
