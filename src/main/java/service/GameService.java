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

}
