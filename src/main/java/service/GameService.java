package service;

import java.util.stream.IntStream;

import constant.ConstantNumbers;
import controller.GameController;
import domain.Cars;
import exception.OverMaximumException;
import exception.UnderMaximumException;

public class GameService {
    private Cars cars = new Cars();

    public void startGame() throws RuntimeException {
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .forEach(i -> inputCarName());
    }

    public void inputCarName() throws RuntimeException {
        String[] inputString = GameController.inputCarName().split(",");
        checkInputString(inputString);
        //cars.addCar();
    }

    public void checkInputString(String[] inputString) throws RuntimeException {
        if (inputString.length > ConstantNumbers.MAX_CAR_COUNT.getNumber()) {
            throw new OverMaximumException();
        }
        if (inputString.length < ConstantNumbers.MAX_CAR_COUNT.getNumber()) {
            throw new UnderMaximumException();
        }
    }

}
