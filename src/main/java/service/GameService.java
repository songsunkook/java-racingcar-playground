package service;

import collection.Cars;
import controller.GameController;
import domain.InputString;
import domain.TryCount;

public class GameService {
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
        tryLoopOnce();
    }

    public void setCars(Cars cars) {
        //Only Use Test (다른 방법 생각해보기)
        this.cars = cars;
    }
}
