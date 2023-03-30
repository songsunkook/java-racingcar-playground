package service;

import java.util.stream.IntStream;

import constant.ConstantNumbers;
import controller.GameController;
import domain.Cars;
import exception.NotIntegerException;
import exception.OverMaximumException;
import exception.UnderMaximumException;

public class GameService {
    private Cars cars = new Cars();

    public void startGame() throws RuntimeException {
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .forEach(i -> inputCarName());
    }

    public void inputCarName() throws RuntimeException {
        //원시타입 래핑하기, InputView에서 진행할 것
        String[] inputString = GameController.inputCarName().split(",");
        checkInputString(inputString);
        //cars.addCar();
    }

    public void inputTryCount() throws RuntimeException {
        //원시타입 래핑하기, InputView에서 진행할 것
        String tryCount = GameController.inputTryCount();
        int tryCountInt = tryCountConvertInt(tryCount);
    }

    public void checkInputString(String[] inputString) throws RuntimeException {
        if (inputString.length > ConstantNumbers.MAX_CAR_COUNT.getNumber()) {
            throw new OverMaximumException();
        }
        if (inputString.length < ConstantNumbers.MAX_CAR_COUNT.getNumber()) {
            throw new UnderMaximumException();
        }
    }

    public int tryCountConvertInt(String inputInt) throws RuntimeException {
        try {
            return Integer.parseInt(inputInt);
        } catch (NumberFormatException exception) {
            throw new NotIntegerException();
        }
    }
}
