package service;

import java.util.stream.IntStream;

import controller.GameController;
import domain.Cars;
import domain.ConstantNumbers;

public class GameService {
    private Cars cars = new Cars();

    public void startGame() {
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .forEach(i -> inputCarName());
    }

    public void inputCarName() {
        cars.addCar(GameController.inputCarName());
    }

}
