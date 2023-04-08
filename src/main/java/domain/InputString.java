package domain;

import java.util.List;
import java.util.stream.IntStream;

import collection.Cars;
import constant.ConstantNumbers;
import exception.OverMaximumException;
import exception.UnderMaximumException;

public class InputString {
    private final List<String> stringArray;

    public InputString(List<String> string) {
        stringArray = string;
        checkException(stringArray);
    }

    public void setCars(Cars cars) {
        IntStream.range(ConstantNumbers.ZERO.getNumber(), ConstantNumbers.MAX_CAR_COUNT.getNumber())
            .forEach(i -> cars.add(stringArray.get(i)));
    }

    public void checkException(List<String> inputString) {
        if (inputString.size() > ConstantNumbers.MAX_CAR_COUNT.getNumber()) {
            throw new OverMaximumException();
        }
        if (inputString.size() < ConstantNumbers.MAX_CAR_COUNT.getNumber()) {
            throw new UnderMaximumException();
        }
    }
}
