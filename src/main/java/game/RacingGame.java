package game;

import java.util.stream.IntStream;

import collection.Cars;
import constant.ConstantNumbers;
import controller.GameController;
import domain.InputString;
import domain.TryCount;

public class RacingGame {
    private TryCount tryCount;
    private final Cars cars = new Cars();

    public void inputCarName() {
        InputString inputString = new InputString(GameController.inputCarName());
        inputString.setCars(cars);
    }

    public void inputTryCount() {
        tryCount = new TryCount(GameController.inputTryCount());
    }

    public void tryLoopOnce() {
        cars.goStraights();
        cars.outputResult();
    }

    public void tryLoop() {
        IntStream.range(ConstantNumbers.ZERO.getNumber(), tryCount.get())
            .forEach(i -> tryLoopOnce());
    }

    public Cars judgeFinalWinner() {
        return cars.getFinalWinner();
    }
}
