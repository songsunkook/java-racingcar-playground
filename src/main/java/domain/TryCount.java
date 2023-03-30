package domain;

import exception.NotIntegerException;

public class TryCount {
    private int count;

    public TryCount(String countString) {
        this.count = convertInt(countString);
    }

    public int convertInt(String inputInt) {
        try {
            return Integer.parseInt(inputInt);
        } catch (NumberFormatException exception) {
            throw new NotIntegerException();
        }
    }
}
