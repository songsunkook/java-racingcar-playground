package game;

import java.util.List;

import collection.Cars;
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

    public void tryLoopOnce(List<Boolean> isStraightList) {
        cars.goStraights(isStraightList);
        cars.outputResult();
    }

    public int getTryCount() {
        return tryCount.get();
    }

    public Cars judgeFinalWinner() {
        return cars.getFinalWinner();
    }
}
