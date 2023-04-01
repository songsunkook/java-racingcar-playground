package game;

import java.util.stream.IntStream;

import collection.Cars;
import constant.ConstantNumbers;
import controller.GameController;
import domain.InputString;
import domain.TryCount;

public class RacingGame {
    private TryCount tryCount;
    private Cars cars = new Cars();

    public void inputCarName() {
        InputString inputString = new InputString(GameController.inputCarName());
        inputString.setCars(cars);
    }

    public void inputTryCount() {
        TryCount tryCount = new TryCount(GameController.inputTryCount());
        this.tryCount = tryCount;
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
