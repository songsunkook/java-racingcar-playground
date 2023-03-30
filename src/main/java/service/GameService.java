package service;

import java.util.stream.IntStream;

import controller.GameController;
import domain.Cars;
import domain.ConstantNumbers;

public class GameService {
    private Cars cars = new Cars();

    public void startGame() {
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .forEach(i -> inputCarName());
    }

    public void inputCarName() {
        String[] inputString = GameController.inputCarName().split(":");

        //cars.addCar();
    }

    private void checkInputCarNameCount(String[] inputString) {
        if (inputString.length > ConstantNumbers.MAX_CAR_COUNT.getNumber()) {
            //throw exception
        }
    }

}
