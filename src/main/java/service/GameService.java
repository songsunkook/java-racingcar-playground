package service;

import java.util.stream.IntStream;

import controller.GameController;
import domain.Cars;

public class GameService {
    private static final int ZERO = 0;
    private static final int MAX_CAR_COUNT = 3;
    private Cars cars = new Cars();

    public void startGame() {
        IntStream.range(ZERO, MAX_CAR_COUNT).forEach(i -> inputCarName());
    }

    public void inputCarName() {
        cars.addCar(GameController.inputCarName());
    }

}
