package service;

import java.util.stream.IntStream;

import collection.Cars;
import constant.ConstantNumbers;
import controller.GameController;
import domain.InputString;
import domain.TryCount;

public class GameService {
    private Cars cars = new Cars();
    private TryCount tryCount;

    public void startGame() throws RuntimeException {
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .forEach(i -> inputCarName());
    }

    public void inputCarName() throws RuntimeException {
        InputString inputString = new InputString(GameController.inputCarName());
        inputString.setCars();
    }

    public void inputTryCount() throws RuntimeException {
        TryCount tryCount = new TryCount(GameController.inputTryCount());
        this.tryCount = tryCount;
    }

}
