package service;

import java.util.stream.IntStream;

import collection.Cars;
import constant.ConstantNumbers;
import controller.GameController;
import domain.InputString;
import domain.TryCount;

public class GameService {
    private TryCount tryCount;
    private Cars cars = new Cars();

    public void startGame() {
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .forEach(i -> inputCarName());
    }

    public void inputCarName() {
        InputString inputString = new InputString(GameController.inputCarName());
        inputString.setCars(cars);
    }

    public void inputTryCount() {
        TryCount tryCount = new TryCount(GameController.inputTryCount());
        this.tryCount = tryCount;
    }

}
