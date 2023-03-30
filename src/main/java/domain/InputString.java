package domain;

import java.util.stream.IntStream;

import collection.Cars;
import constant.ConstantNumbers;
import exception.OverMaximumException;
import exception.UnderMaximumException;

public class InputString {
    private String[] stringArray;

    public InputString(String[] string) {
        this.stringArray = string;
        checkException(this.stringArray);
    }

    public void setCars(Cars cars) {
        //car 설정
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .forEach(i -> cars.addCar(stringArray[i]));
    }

    public void checkException(String[] inputString) {
        if (inputString.length > ConstantNumbers.MAX_CAR_COUNT.getNumber()) {
            throw new OverMaximumException();
        }
        if (inputString.length < ConstantNumbers.MAX_CAR_COUNT.getNumber()) {
            throw new UnderMaximumException();
        }
    }
}
