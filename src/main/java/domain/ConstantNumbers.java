package domain;

public enum ConstantNumbers {
    ZERO(0),
    MAX_CAR_COUNT(3);

    private final int number;

    ConstantNumbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
