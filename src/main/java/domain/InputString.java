package domain;

import constant.ConstantNumbers;
import exception.OverMaximumException;
import exception.UnderMaximumException;

public class InputString {
    private String[] stringArray;

    public InputString(String[] string) {
        this.stringArray = string;
        checkException(this.stringArray);
    }

    public void setCars() {
        //car 설정
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
