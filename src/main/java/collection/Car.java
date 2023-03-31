package collection;

import util.RandomManager;

public class Car {
    private int location;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public void goStraight() {
        if (RandomManager.straightCar()) {
            location++;
        }
    }

    public void goStraight(int randomSeed) {
        if (RandomManager.straightCar(randomSeed)) {
            location++;
        }
    }
}
