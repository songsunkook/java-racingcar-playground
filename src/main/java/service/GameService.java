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

    public void setCars(Cars cars) {
        //Only Use Test (다른 방법 생각해보기)
        this.cars = cars;
    }

    public void setTryCount(TryCount tryCount) {
        this.tryCount = tryCount;
    }
}
